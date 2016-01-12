package de.upb.lina.transformations.wizards;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.cfg.controlflow.ControlflowPackage;
import de.upb.lina.cfg.tools.GraphUtility;
import de.upb.lina.transformations.Activator;
import de.upb.llvm_parser.llvm.BasicBlock;
import de.upb.llvm_parser.llvm.Call;
import de.upb.llvm_parser.llvm.FunctionBody;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.Instruction;

public class FunctionSelectionPage extends WizardPage{
	
	
	private List<ControlFlowDiagram> allCFGs;
	private List<ControlFlowDiagram>selectedFunctions = new ArrayList<ControlFlowDiagram>();
	private HashMap<ControlFlowDiagram, List<ControlFlowDiagram>> cfgToDependentFunctions = new HashMap<>();
	private HashMap<String, ControlFlowDiagram> functionToCfg;
	private HashMap<String, String> oldToNewCfgName = new HashMap<>();
	private Tree tree;
	
	private String DEFAULT_MESSAGE = "Please select the functions you wish to transform and enter names for the functions.";
	

	protected FunctionSelectionPage(String pageName) {
		super(pageName);
		setTitle("Function - Selection");
		setDescription(DEFAULT_MESSAGE);
	}
	
	public FunctionSelectionPage() {
		super("wizardPage");
		setTitle("Function - Selection");
		setDescription(DEFAULT_MESSAGE);
	}

	@Override
	public void createControl(Composite parent) {
		
		/* init */
		final Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		
		tree = new Tree(composite,SWT.CHECK | SWT.MULTI | SWT.H_SCROLL |SWT.BORDER);
		TreeColumn column = new TreeColumn(tree, SWT.H_SCROLL);
		column.setText("Available Functions");
		column.setWidth(250);
		
		TreeColumn column2 = new TreeColumn(tree, SWT.H_SCROLL);
		column2.setText("Name in Transformation");
		column2.setWidth(200);
		
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		GridData treeLayoutData = new GridData(GridData.FILL, GridData.FILL, true, true);
		tree.setLayoutData(treeLayoutData);
		loadCfg();
		Button select = new Button(composite, SWT.CHECK);
		select.setText("select/deselect all");
		select.setSelection(true);
		select.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(select.getSelection())
					for(TreeItem i :tree.getItems()){
						if(!i.getChecked()){
							i.setChecked(true);
							updateSelectedFunctions(i);
						}
						
					}
				else
					for(TreeItem i :tree.getItems()){
						if(i.getChecked()){
							i.setChecked(false);
							updateSelectedFunctions(i);
						}
					}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		tree.addListener(SWT.Selection, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					TreeItem item = (TreeItem) event.item;
					updateSelectedFunctions(item);
				}
				
			}
			
		});
		setControl(composite);
		
	}
	
	private void refreshTree(){
		if(tree!=null){
			tree.removeAll();
			Control[] children = tree.getChildren();
			for(int i = 0; i<children.length;i++){
				Control child = children[i];
				if(child instanceof Text){
					Text text = (Text)child;
					text.setText("");
					text.dispose();
				}
			}
			
			oldToNewCfgName.clear();
			selectedFunctions.clear();
			for(ControlFlowDiagram diagram : allCFGs){
				String cfgName = diagram.getName();
				TreeItem item = new TreeItem(tree, SWT.NONE);
				TreeEditor editor = new TreeEditor(tree);
				item.setText(cfgName);
				item.setChecked(true);
				Text newName = new Text(tree, SWT.NONE);
				newName.addModifyListener(new ModifyListener() {
					
					@Override
					public void modifyText(ModifyEvent e)
					{
						Text text = (Text) e.widget;
						oldToNewCfgName.put(diagram.getName(), text.getText());
					}
				});
				newName.setText(cfgName.replace("@_", "").replace("@", ""));
				editor.grabHorizontal = true;
				editor.setEditor(newName, item, 1);
				updateSelectedFunctions(item);
			}
		}
	}

	protected List<ControlFlowDiagram> loadCfg() {
		String location= ((TransformationWizardPage)this.getPreviousPage()).getGraphModelFile().getText();
		ControlflowPackage.eINSTANCE.getNsURI();
		ResourceSet resourceSet = new ResourceSetImpl();
		Path cfgpath = new Path(location);
		URI uri = URI.createPlatformResourceURI(cfgpath.toOSString(), true);
		Resource cfgResource = resourceSet.getResource(uri, true);
		EcoreUtil.resolveAll(cfgResource);
		List<EObject> graphList = cfgResource.getContents();
		List<ControlFlowDiagram> graphList2  = new ArrayList<ControlFlowDiagram>();
		for(EObject o: graphList){
			if(o instanceof ControlFlowDiagram){
				graphList2.add((ControlFlowDiagram)o);
			}
		}
		this.allCFGs = graphList2;
		
		//mapping from name to cfg
		functionToCfg  = new HashMap<String, ControlFlowDiagram>();
		for(ControlFlowDiagram cfg : allCFGs){
			functionToCfg.put(cfg.getName(), cfg);
		}
		refreshTree();
		computeDependencies();
		return allCFGs;
	}
	
	private void updateSelectedFunctions(TreeItem item) {
		String functionName = item.getText();
		if(item.getChecked()){
			//add to selected functions
			ControlFlowDiagram selectedCFG = functionToCfg.get(functionName);
			if(!selectedFunctions.contains(selectedCFG))
			this.selectedFunctions.add(selectedCFG);
		}else{
			//remove from selected functions
			ControlFlowDiagram deselectedCFG = functionToCfg.get(functionName);
			this.selectedFunctions.remove(deselectedCFG);
		}
		
		//compute not selected functions
		ArrayList<ControlFlowDiagram> notSelectedFunctions = new ArrayList<ControlFlowDiagram>(allCFGs);
		Collections.copy(notSelectedFunctions, allCFGs);
		notSelectedFunctions.removeAll(selectedFunctions);
		
		List<String> dependencyIssues = new ArrayList<String>();
		//display warning in case of dependency problems
		for(ControlFlowDiagram selectedCfg: selectedFunctions){
			for(ControlFlowDiagram notSelectedCfg: notSelectedFunctions){
				//a still selected item does have a dependency for function to removed
				if(cfgToDependentFunctions.get(selectedCfg) != null && cfgToDependentFunctions.get(selectedCfg).contains(notSelectedCfg)){
					dependencyIssues.add("Function " + notSelectedCfg.getName() + " is required by " + selectedCfg.getName() + "! Check your selection!");
				}
			}
		}
		
		if(!dependencyIssues.isEmpty()){
			updateWarning(dependencyIssues.get(0),WARNING);
		}else if(selectedFunctions.isEmpty()){
			updateStatus("Please select at least one function");
		}else{
			updateStatus(null);
			setMessage(DEFAULT_MESSAGE);
		}
	}
	
	protected List<ControlFlowDiagram> getSelectedFunctions(){
		return selectedFunctions;
	}
	
	
	/**
	 * Displays a warning, but finishes the dialog
	 * @param message
	 * @param level
	 */
	private void updateWarning(String message, int level) {
		setMessage(message, level);
		setPageComplete(false);
		updateStatus(null);
		getControl().redraw();
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
	
	/**
	 * Computes dependencies between function
	 */
	private void computeDependencies(){
		try{
			for(ControlFlowDiagram cfg : allCFGs){
				EObject motherObject = cfg.getStart().getOutgoing().get(0).getInstruction().eContainer();
				BasicBlock basicBlock = (BasicBlock) motherObject;
				FunctionBody fb = (FunctionBody)basicBlock.eContainer();
				FunctionDefinition fd = (FunctionDefinition)fb.eContainer();
				
				if(fd.getBody() != null){
					for(BasicBlock b: fd.getBody().getBlocks()){
						for(Instruction ins: b.getInstructions()){
							if(ins instanceof Call){
								String calledFunction = GraphUtility.valueToRawString(((Call) ins).getFunction().getValue()).trim();
								//if the function is to be generated and if its not a self-call (recursion)
								if(functionToCfg.containsKey(calledFunction) && functionToCfg.get(calledFunction) != cfg){
									addDependency(cfg, calledFunction);
								}
							}
						}
					}
				}
			}
			
		}catch(Exception ex){
			Activator.logWarning("Could not compute function dependencies!", ex);
		}
	}
	
	private void addDependency(ControlFlowDiagram callingCfg, String calledFunction){
		//Create empty entry if first dependency for that cfg
		if(!cfgToDependentFunctions.containsKey(callingCfg)){
			cfgToDependentFunctions.put(callingCfg,new ArrayList<ControlFlowDiagram>());
		}
		
		//create entry
		List<ControlFlowDiagram> dependentFuncs =  cfgToDependentFunctions.get(callingCfg);
		ControlFlowDiagram calledCfg = functionToCfg.get(calledFunction);
		if(!dependentFuncs.contains(calledCfg)){
			dependentFuncs.add(calledCfg);
		}
	}
	
	public HashMap<String, String> getMap()
	{
		return oldToNewCfgName;
	}

}
