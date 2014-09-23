package de.upb.lina.cfg.tools;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.controlflow.ControlflowFactory;
import de.upb.lina.cfg.controlflow.GuardedTransition;
import de.upb.lina.cfg.controlflow.MultiTransition;
import de.upb.lina.cfg.controlflow.Transition;
import de.upb.llvm_parser.llvm.BasicBlock;
import de.upb.llvm_parser.llvm.Branch;
import de.upb.llvm_parser.llvm.Constant;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.IndirectBranch;
import de.upb.llvm_parser.llvm.Instruction;
import de.upb.llvm_parser.llvm.Invoke;
import de.upb.llvm_parser.llvm.LLVM;
import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.Store;
import de.upb.llvm_parser.llvm.Switch;
import de.upb.llvm_parser.llvm.SwitchCase;
import de.upb.llvm_parser.llvm.Value;
import de.upb.llvm_parser.llvm.impl.AddressUseImpl;
import de.upb.llvm_parser.llvm.impl.FunctionDefinitionImpl;

public class CFGWorkspaceOperation extends WorkspaceModifyOperation {

	private LLVM ast = null;
	private Path cfgpath = null;
	private int reordering;
	private ArrayList<ControlFlowDiagram> list = new ArrayList<ControlFlowDiagram>();
	private HashMap<ControlFlowLocation, Buffer> buffers = new HashMap<ControlFlowLocation, Buffer>();

	public CFGWorkspaceOperation(EObject ast, String path, int reordering) {
		super();
		if (ast instanceof LLVM)
			this.ast = (LLVM) ast;
		cfgpath = new Path(path);
		this.reordering = reordering;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException,
			InvocationTargetException, InterruptedException {
		if (monitor == null)
			monitor = new NullProgressMonitor();
		if (ast == null) {
			throw new InterruptedException(
					"Now specified LLVM Object inside the ast.");
		}

		try {
			int a_elem = ast.getElements().size();
			
			// generating cfg for each function
			for (int i = 0; i < a_elem; i++) {
				if (ast.getElements().get(i) instanceof FunctionDefinitionImpl) {
					if (((FunctionDefinition) ast.getElements().get(i))
							.getBody() != null)
						if(reordering == 1){
							ReorderingUtil reord = new ReorderingUtil();
							list.add(reord.createReachibilityGraph((FunctionDefinition) ast
									.getElements().get(i)));
						}else{
							list.add(createCFG((FunctionDefinition) ast
									.getElements().get(i)));
						}
				}
			}

//			// generating cfg for each function
//			for (int i = 0; i < a_elem; i++) {
//				if (ast.getElements().get(i) instanceof FunctionDefinitionImpl) {
//					if (((FunctionDefinition) ast.getElements().get(i))
//							.getBody() != null)
//						list.add(createCFG((FunctionDefinition) ast
//								.getElements().get(i)));
//				}
//			}

//			// adding TSO control flow
//			ReorderingUtil rutil = new ReorderingUtil();
//			if (reordering == 1) {
//				rutil.addTSO(list);
//			}

			// store resulting cfg
			ResourceSet resSet = new ResourceSetImpl();
			Resource resource = resSet.createResource(URI.createURI(cfgpath
					.toPortableString()));

			for (ControlFlowDiagram cfg : list) {
				EcoreUtil.resolveAll(cfg);
				resource.getContents().add(cfg);
			}

			resource.save(Collections.EMPTY_MAP);
			refreshWorkspace();

		} catch (IOException e) {
			CFGActivator.logError(e.getMessage(), e);
		}

	}

	private ControlFlowDiagram createCFG(FunctionDefinition function) {
//		//START OF CORRECT
		ProgramCounter pc = new ProgramCounter();
		ControlFlowDiagram cfg = ControlflowFactory.eINSTANCE
				.createControlFlowDiagram();

		cfg.setName(function.getAddress().getName());

		//create the naive normal cfg
		EList<BasicBlock> blocks = function.getBody().getBlocks();
		for (BasicBlock b : blocks) {
			ControlFlowLocation location = createControlFlowLocation(cfg, pc);
			if (cfg.getStart() == null) {
				cfg.setStart(location);
			}
			//correct
			for (Instruction instr : b.getInstructions()) {
				Transition t = createTransition(cfg, instr);
				ControlFlowLocation nextLocation = createControlFlowLocation(
						cfg, pc);
				t.setSource(location);
				t.setTarget(nextLocation);
				location = nextLocation;
			}
		}

		ArrayList<Transition> newTransitions = new ArrayList<Transition>();
		for (Transition t : cfg.getTransitions()) {
			if (t.getInstruction() instanceof Branch) {
				Branch br = (Branch) t.getInstruction();
				//check Destination
				ControlFlowLocation target = findLabeledLocation(cfg, function,
						br.getDestination().substring(1));
				if (!t.getTarget().equals(target)) {
					t.setTarget(target);
				}
				
				
				if (br.getElseDestination() != null) {
					
//					// replace transition with guarded
//					GuardedTransition trueCase = ControlflowFactory.eINSTANCE
//							.createGuardedTransition();
//					trueCase.setInstruction(t.getInstruction());
//					GuardedTransition elseCase = ControlflowFactory.eINSTANCE
//							.createGuardedTransition();
//					elseCase.setInstruction(t.getInstruction());
//					newTransitions.add(trueCase);
//					newTransitions.add(elseCase);
//
//					Transition equalCalc = t.getSource().getIncoming().get(0);
//					
//					trueCase.setSource(equalCalc.getSource());
//					elseCase.setSource(equalCalc.getSource());
//					
//					//TODO: FIX THIS, this is still wrong...
//					//delete the source of the compare transition
//					trueCase.setCondition("["+getLabelWithInstruction(function, br) +"]");
//					t.
//					
//					//trueCase.setCondition("["+ valueToString(br.getCondition()) + "]");
//					elseCase.setCondition("[else]");
//					t.setSource(null);
//					t.setTarget(null);
//
//					
//					trueCase.setTarget(findLabeledLocation(cfg, function, br
//							.getDestination().substring(1)));
//					elseCase.setTarget(findLabeledLocation(cfg, function, br
//							.getElseDestination().substring(1)));
					
					 // replace transition with guarded
                    GuardedTransition trueCase = ControlflowFactory.eINSTANCE
                                    .createGuardedTransition();
                    trueCase.setInstruction(t.getInstruction());
                    GuardedTransition elseCase = ControlflowFactory.eINSTANCE
                                    .createGuardedTransition();
                    elseCase.setInstruction(t.getInstruction());
                    newTransitions.add(trueCase);
                    newTransitions.add(elseCase);

                    trueCase.setSource(t.getSource());
                    elseCase.setSource(t.getSource());
                    trueCase.setCondition("["+ valueToString(br.getCondition()) + "]");
                    elseCase.setCondition("[else]");
                    t.setSource(null);
                    t.setTarget(null);

                    trueCase.setTarget(findLabeledLocation(cfg, function, br
                                    .getDestination().substring(1)));
                    elseCase.setTarget(findLabeledLocation(cfg, function, br
                                    .getElseDestination().substring(1)));
					
				}
			} else if (t.getInstruction() instanceof IndirectBranch) {
				// TODO: target depends on register content -> condition of
				// control flow guards unclear
				throw new RuntimeException(
						"IndirectBranch found. Handling of such is not implemented yet");
			} else if (t.getInstruction() instanceof Switch) {
				// replace normal transition by guarded one
				Switch sw = (Switch) t.getInstruction();
				GuardedTransition newT = ControlflowFactory.eINSTANCE
						.createGuardedTransition();
				newT.setCondition("else");
				newT.setSource(t.getSource());
				ControlFlowLocation defaultTarget = findLabeledLocation(cfg,
						function, sw.getDefaultCase().substring(1));
				newT.setTarget(defaultTarget);

				newTransitions.add(newT);

				// add other cases
				for (SwitchCase sc : sw.getCases()) {
					GuardedTransition otherCase = ControlflowFactory.eINSTANCE
							.createGuardedTransition();
					otherCase.setSource(t.getSource());
					otherCase.setCondition(valueToString(sc.getCaseValue()
							.getValue()));
					ControlFlowLocation target = findLabeledLocation(cfg,
							function, sc.getDestination().substring(1));
					otherCase.setTarget(target);

					newTransitions.add(otherCase);
				}

				// will be cleaned up later
				t.setSource(null);
				t.setTarget(null);

			} else if (t.getInstruction() instanceof Invoke) {
				// do nothing
			}
		} //end for 
		

		// has to be done separately in order to not modify collection while
		// iterating
		for (Transition t : newTransitions) {
			t.setDiagram(cfg);
		}

		cleanUp(cfg);
		return cfg;
	}

	/**
	 * Searches for the block with label destLabel and returns preceeding
	 * location of the transition that is corresponding to the first instruction
	 * of the block.
	 * 
	 * @param cfg
	 * @param function
	 * @param destLabel
	 * @return
	 */
	private ControlFlowLocation findLabeledLocation(ControlFlowDiagram cfg,
			FunctionDefinition function, String destLabel) {
		Instruction dest = getInstructionWithLabel(function, destLabel);
		Transition destTrans = findCorrespondingTransition(cfg, dest);
		return destTrans.getSource();
	}

	/**
	 * Removes locations and transitions if not connected
	 * 
	 * @param cfl
	 */
	private void cleanUp(ControlFlowDiagram cfg) {
		ArrayList<ControlFlowLocation> locations = new ArrayList<ControlFlowLocation>();
		for (ControlFlowLocation location : cfg.getLocations()) {
			if (location.getIncoming().isEmpty()
					&& location.getOutgoing().isEmpty()) {
				locations.add(location);
			}
		}

		for (ControlFlowLocation location : locations) {
			location.setDiagram(null); // remove
		}

		ArrayList<Transition> transitions = new ArrayList<Transition>();
		for (Transition t : cfg.getTransitions()) {
			// should not happen
			if (t.getSource() == null || t.getTarget() == null) {
				transitions.add(t);
			}
		}
		for (Transition t : transitions) {
			t.setDiagram(null);
			t.setSource(null);
			t.setTarget(null);
		}
	}
	
	public void seq(List<Instruction> instructions, FunctionDefinition def){
		//empty list
		if(instructions.size() <1){
			return;
		}
		Instruction first = instructions.get(0);
		instructions.remove(first);
		
		
		if(instructions.size() == 1 ){
			//ret
			if(first.eClass().equals(LlvmPackage.eINSTANCE.getReturn())){
				//do nothing, already created
				return;
			}
		}
		
		//write
		if(first.eClass().equals(LlvmPackage.eINSTANCE.getStore())){
			ArrayList<Instruction> writeSeq = new ArrayList<Instruction>();
			writeSeq.add(first);
			del(def ,writeSeq, instructions);
			
		//branch	
		}else if(first.eClass().equals(LlvmPackage.eINSTANCE.getBranch())){
			Branch branch = (Branch)first;
			Instruction ifInstruction = getInstructionWithLabel(def,branch.getDestination().substring(1));
			Instruction elseInstruction = getInstructionWithLabel(def,branch.getElseDestination().substring(1));
			
			//if part
			ArrayList<Instruction> ifCopy = new ArrayList<Instruction>(instructions.size());
			Collections.copy(ifCopy, instructions);		
			for(int i = 0; !ifCopy.get(i).equals(ifInstruction); i++){
				ifCopy.remove(i);
			}
			seq(ifCopy, def);
			
			//else part
			ArrayList<Instruction> elseCopy = new ArrayList<Instruction>(instructions.size());
			Collections.copy(ifCopy, instructions);
			for(int i = 0; !ifCopy.get(i).equals(elseInstruction); i++){
				elseCopy.remove(i);
			}
			seq(elseCopy, def);
			
			//LOOPS!!!!
		//}else if(){
		
//		}
					
		}else{
			//cmd-seq
			//TODO create nodes accordingly
		}
		
	}
	
	public void del(FunctionDefinition def , List<Instruction> writeSeq, List<Instruction> rest){
		if(writeSeq.size()>0){
//			flush(writeSeq, rest);
//			prog(writeSeq, rest);
		}else{
			seq(rest, def);
		}
	}
	
	
	public ArrayList<ControlFlowLocation> getAdjacentNodes(ControlFlowLocation l){
		ArrayList<ControlFlowLocation> adjacents = new ArrayList<ControlFlowLocation>();
		for(Transition t:l.getOutgoing()){
			adjacents.add(t.getTarget());
		}
		return adjacents;
	}

	/**
	 * @param function
	 * @param destLabel
	 * @return instruction corresponding to the label
	 */
	private Instruction getInstructionWithLabel(FunctionDefinition function,
			String destLabel) {
		for (BasicBlock b : function.getBody().getBlocks()) {
			if (destLabel.equals(b.getLabel())) {
				return b.getInstructions().get(0);
			}
		}
		return null;
	}
	
	/**
	 * @param function
	 * @param destLabel
	 * @return instruction corresponding to the label
	 */
	private String getLabelWithInstruction(FunctionDefinition function,
			Instruction i) {
		System.out.println("Iso: " + i.toString());
		for (BasicBlock b : function.getBody().getBlocks()) {
			if (i.equals(b.getInstructions().get(0))) {
				return b.getLabel();
			}
			System.out.println(b.getInstructions().get(0).toString());
		}
		return null;
	}

	/**
	 * 
	 * @param cfg
	 * @param i
	 * @return CFG transition corresponding to instruction i
	 */
	private Transition findCorrespondingTransition(ControlFlowDiagram cfg,
			Instruction i) {
		for (Transition t : cfg.getTransitions()) {
			if (i.equals(t.getInstruction())) {
				return t;
			}
		}
		return null;
	}
	
	private ControlFlowLocation findControlFlowLocation(int pc, Buffer buffer, ControlFlowDiagram cfg){
		for(ControlFlowLocation l: cfg.getLocations()){
			if(l.getPc() == pc && buffers.get(l).equals(buffer)){
				return l;
			}
		}
		return null;
	}

	/**
	 * @param diag
	 * @param pc
	 * @return
	 */
	private ControlFlowLocation createControlFlowLocation(
			ControlFlowDiagram diag, ProgramCounter pc) {
		ControlFlowLocation loc = ControlflowFactory.eINSTANCE
				.createControlFlowLocation();
		loc.setPc(pc.next());
		loc.setDiagram(diag);
		return loc;
	}

	/**
	 * @param diag
	 * @param i
	 * @return
	 */
	private Transition createTransition(ControlFlowDiagram diag, Instruction i) {
		Transition transition = ControlflowFactory.eINSTANCE.createTransition();
		transition.setInstruction(i);
		transition.setDiagram(diag);
		return transition;
	}
	
	private Transition createMultiTransition(ControlFlowDiagram diag, ArrayList <Instruction> instructions) {
		MultiTransition transition = ControlflowFactory.eINSTANCE.createMultiTransition();
		transition.getInstructions().addAll(instructions);
		transition.setDiagram(diag);
		return transition;
	}

	private void refreshWorkspace() {
		IProject[] iProjects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		for (int i = 0; i < iProjects.length; i++)
			try {
				iProjects[i].refreshLocal(0,
						new org.eclipse.core.runtime.NullProgressMonitor());
			} catch (CoreException e) {
				CFGActivator.logError(e.getMessage(), e);
			}
	}

	private String valueToString(Value value) {
		if (value.eClass().equals(LlvmPackage.eINSTANCE.getConstant())) {
			Constant constant = (Constant) value;
			return constant.getValue().toString();
		}

		if (value instanceof AddressUseImpl) {
			AddressUseImpl aui = (AddressUseImpl) value;
			return aui.getAddress().getName();
		}
		return value.toString();
	}
	
//	public void createReachabilityGraph(FunctionDefinition function, ProgramCounter pcc, ControlFlowDiagram cfgraph){
//		ProgramCounter pc = pcc;
//		ControlFlowDiagram cfg = cfgraph;
////		ControlFlowDiagram cfg = ControlflowFactory.eINSTANCE
////				.createControlFlowDiagram();
////
////		cfg.setName(function.getAddress().getName());
//
//		EList<BasicBlock> blocks = function.getBody().getBlocks();
//		for (BasicBlock b : blocks) {
//			ControlFlowLocation location = createControlFlowLocation(cfg, pc);
//			//First location
//			if (cfg.getStart() == null) {
//				cfg.setStart(location);
//				buffers.put(location, new Buffer());		
//			}
//			
//			//correct
//			for (Instruction instr : b.getInstructions()) {
//				Transition t = createTransition(cfg, instr);
//				//dealWithInstruction(instr);
//				ControlFlowLocation nextLocation = createControlFlowLocation(
//						cfg, pc);
//				Buffer newBuffer = new Buffer(buffers.get(location));
//				
//				
//				//store buffer
//				if(instr.eClass().equals(LlvmPackage.eINSTANCE.getStore())){
//					Store store = (Store)instr;
//					newBuffer.addBufferPair(new BufferPair(store.getTargetAddress(), store.getValue()));
//				}
//				
//				if(instr.eClass().equals(LlvmPackage.eINSTANCE.getLoad())){
//					
//				}
//				
//				//flushes?!
////				if(instr.eClass().equals(LlvmPackage.eINSTANCE.get)){
////					
////				}
//				
//				buffers.put(nextLocation, newBuffer);
//				t.setSource(location);
//				t.setTarget(nextLocation);
//				location = nextLocation;
//			}
//		}
//	}
	
//	public ControlFlowLocation getNextLocation(Instruction instruct, ControlFlowLocation oldLocation, ProgramCounter pc, ControlFlowDiagram cfg){
//		if(instruct.eClass().equals(LlvmPackage.eINSTANCE.getStore())){
//			//TODO: NULL CHECK!!
//			Buffer newBuffer = new Buffer(buffers.get(oldLocation));
//			ControlFlowLocation next = findControlFlowLocation(pc.next(), newBuffer, cfg);
//			if(next == null){
//				next = createControlFlowLocation(cfg, pc);
//				//Create edge accordinlgy
//			}else{
//				//Check if edge is already existing for some reason we do not know yet
//			}
//			
//		}
//		
//		return null;
//	}
}