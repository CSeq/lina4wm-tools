package de.upb.lina.cfgwizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
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
import de.upb.lina.cfg.controlflow.Transition;
import de.upb.llvm_parser.llvm.BasicBlock;
import de.upb.llvm_parser.llvm.Branch;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.IndirectBranch;
import de.upb.llvm_parser.llvm.Instruction;
import de.upb.llvm_parser.llvm.InstructionUse;
import de.upb.llvm_parser.llvm.Invoke;
import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.NonConstantValue;
import de.upb.llvm_parser.llvm.ReturnInstruction;
import de.upb.llvm_parser.llvm.Switch;
import de.upb.llvm_parser.llvm.impl.BranchImpl;
import de.upb.llvm_parser.llvm.impl.FunctionDefinitionImpl;
import de.upb.llvm_parser.llvm.impl.InstructionUseImpl;
import de.upb.llvm_parser.llvm.impl.LLVMImpl;
import de.upb.llvm_parser.llvm.impl.ReturnInstructionImpl;
import de.upb.llvm_parser.llvm.impl.StandartInstructionImpl;

public class CFGWorkspaceOperation extends WorkspaceModifyOperation {

	private final boolean EXCT = false; // Shall exception handling be added to
										// i.e. Invoke function?
	private final boolean SINGLEBRANCH = false; // Shall be useless branches be
												// inside the cfg?
	private LLVMImpl ast = null;
	private Path cfgpath = null;
	private int reordering;
	private ArrayList<ControlFlowDiagram> list = new ArrayList<ControlFlowDiagram>();
	private String sTrueConst = "[true]";
	private String sFalseConst = "[false]";
	private String sDefaultConst = "[default]";
	private String sNormalConst = "[normal]";
	private String sExcConst = "[exception]";

	public CFGWorkspaceOperation(EObject ast, String path, int reordering) {
		super();
		if (ast instanceof LLVMImpl)
			this.ast = (LLVMImpl) ast;
		cfgpath = new Path(path);
		this.reordering = reordering;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		if (monitor == null)
			monitor = new NullProgressMonitor();
		if (ast == null) {
			throw new InterruptedException("Now specified LLVM Object inside the ast.");
		}

		try {
			int a_elem = ast.getElements().size();
			for (int i = 0; i < a_elem; i++) {
				if (ast.getElements().get(i) instanceof FunctionDefinitionImpl) {
					if (((FunctionDefinition) ast.getElements().get(i)).getBody() != null)
						list.add(createCFG((FunctionDefinition) ast.getElements().get(i)));
				}
			}

			if (reordering == 1) {
				addTSO(list);
			}
			/* remove [CFL] ->Branch-> [CFL] single in/out */
			if (SINGLEBRANCH) {
				removeSingleBranches(list);
			}

			ResourceSet resSet = new ResourceSetImpl();
			Resource resource = resSet.createResource(URI.createFileURI(cfgpath.toOSString()));

			for (ControlFlowDiagram cfg : list) {
				EcoreUtil.resolveAll(cfg);
				resource.getContents().add(cfg);
			}

			resource.save(Collections.EMPTY_MAP);
			refreshWorkspace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void removeSingleBranches(ArrayList<ControlFlowDiagram> cfgs) {
		for (ControlFlowDiagram cfg : cfgs) {
			EList<Transition> list = cfg.getTransitions();
			for (int i = 0; i < list.size(); i++) {
				Transition transition = list.get(i);
				if (transition.getInstruction() instanceof BranchImpl) {
					if (((Branch) transition.getInstruction()).getDestination() != null) {
						for (Transition tr1 : transition.getSource().getIncoming()) {
							tr1.setTarget(transition.getTarget());
							transition.getTarget().getIncoming().add(tr1);
						}
						transition.getSource().getIncoming().clear();
						transition.getSource().setDiagram(null);
						transition.getSource().getOutgoing().clear();
						transition.getTarget().getIncoming().remove(transition);
						cfg.getLocations().remove(transition.getSource());
						cfg.getTransitions().remove(transition);
						transition.setSource(null);
						transition.setTarget(null);
						transition.setDiagram(null);
						transition.setInstruction(null);
						i--;
					}
				}
			}
		}

	}

	private ControlFlowDiagram createCFG(FunctionDefinition function) {

		ProgramCounter pc = new ProgramCounter();

		ControlflowFactory caf = ControlflowFactory.eINSTANCE;
		ControlFlowDiagram cfg = caf.createControlFlowDiagram();
		HashMap<BasicBlock, ControlFlowLocation> done = new HashMap<BasicBlock, ControlFlowLocation>();
		cfg.setName(function.getAddress().getName());
		ControlFlowLocation act, temp;
		EList<BasicBlock> blocks = function.getBody().getBlocks();
		for (BasicBlock b : blocks) {
			act = addControlFlowLocation(cfg, pc);
			if (cfg.getStart() == null)
				cfg.setStart(act);
			done.put(b, act);
			for (int i = 0; i < b.getInstructions().size(); i++) {
				Transition t;
				if (b.getInstructions().get(i) instanceof InstructionUseImpl) {
					t = addTransition(cfg, ((InstructionUse) b.getInstructions().get(i)).getInstruction());
				} else if (b.getInstructions().get(i) instanceof StandartInstructionImpl) {
					t = addTransition(cfg, ((Instruction) b.getInstructions().get(i)));
				} else {
					System.out.println("Unknown Instruction");
					return null;
				}
				act.getOutgoing().add(t);
				temp = act;
				act = addControlFlowLocation(cfg, pc);
				act.getIncoming().add(temp.getOutgoing().get(temp.getOutgoing().size() - 1));
				t.setSource(temp);
				t.setTarget(act);
			}
			ReturnInstruction term = b.getTerminator();
			EClass type = term.eClass();
			if (type.equals(LlvmPackage.eINSTANCE.getBranch())) {
				if (((Branch) term).getDestination() != null) {
					Transition t = addTransition(cfg, term);
					act.getOutgoing().add(t);
					t.setSource(act);
				} else {
					GuardedTransition t = addGuardedTransition(cfg, term);
					t.setCondition((((Branch) term).getCondvalue()) + " = " + sTrueConst);
					GuardedTransition f = addGuardedTransition(cfg, term);
					f.setCondition((((Branch) term).getCondvalue()) + " = " + sFalseConst);
					act.getOutgoing().add(t);
					t.setSource(act);
					act.getOutgoing().add(f);
					f.setSource(act);
				}

			} else if (type.equals(LlvmPackage.eINSTANCE.getSwitch())) {
				GuardedTransition def = addGuardedTransition(cfg, term);
				def.setCondition(((Switch) term).getCompvalue() + sDefaultConst);
				act.getOutgoing().add(def);
				def.setSource(act);
				for (int i = 0; i < ((Switch) term).getJvalues().size(); i++) {
					GuardedTransition jump = addGuardedTransition(cfg, term);
					jump.setCondition(((Switch) term).getCompvalue().toString() + ((Switch) term).getJvalues().get(i).toString());
					act.getOutgoing().add(jump);
					jump.setSource(act);
				}
			} else if (type.equals(LlvmPackage.eINSTANCE.getIndirectBranch())) {
				for (int i = 0; i < ((IndirectBranch) term).getLabels().size(); i++) {
					GuardedTransition jump = addGuardedTransition(cfg, term);
					jump.setCondition(((Switch) term).getCompvalue().toString() + ((IndirectBranch) term).getLabels().get(i).toString());
					act.getOutgoing().add(jump);
					jump.setSource(act);
				}
			} else if (type.equals(LlvmPackage.eINSTANCE.getResume())) {
				// No transition right now
			} else if (type.equals(LlvmPackage.eINSTANCE.getInvoke())) {
				GuardedTransition ret = addGuardedTransition(cfg, term);
				ret.setCondition(((Invoke) term).getName() + " -> " + sNormalConst);
				ret.setSource(act);
				act.getOutgoing().add(ret);
				if (EXCT) {
					GuardedTransition exception = addGuardedTransition(cfg, term);
					exception.setCondition(((Invoke) term).getName() + " -> " + sExcConst);
					exception.setSource(act);
					act.getOutgoing().add(exception);
				}
			} else if (type.equals(LlvmPackage.eINSTANCE.getUnreachable())) {
				// No transition right now
			} else if (type.equals(LlvmPackage.eINSTANCE.getReturn())) {
				Transition t = addTransition(cfg, term);
				act.getOutgoing().add(t);
				temp = act;
				act = addControlFlowLocation(cfg, pc);
				act.getIncoming().add(temp.getOutgoing().get(temp.getOutgoing().size() - 1));
				t.setSource(temp);
				t.setTarget(act);
			} else {
				System.out.println("Not Handled Terminator" + term);
			}

		}
		EList<Transition> transitions = cfg.getTransitions();
		for (Transition t : transitions) {
			if (t.getTarget() == null) {
				ControlFlowLocation cfl;
				if (t instanceof GuardedTransition) {
					cfl = searchGTBlock(done, (GuardedTransition) t);
				} else {
					cfl = searchNGTBlock(done, t);
				}
				t.setTarget(cfl);
				cfl.getIncoming().add(t);
			}
		}
		return cfg;
	}

	private ControlFlowLocation searchNGTBlock(HashMap<BasicBlock, ControlFlowLocation> done, Transition destination) {

		Set<BasicBlock> blocks = done.keySet();
		if (destination.getInstruction().eClass().equals(LlvmPackage.eINSTANCE.getBranch())) {
			for (BasicBlock b : blocks) {
				if (b.getLabel().equals(((NonConstantValue) ((Branch) destination.getInstruction()).getDestination()).getName().substring(1))) {
					return done.get(b);
				}
			}
		}
		System.out.println("Not found BasicBlock " + destination);
		return null;
	}

	private ControlFlowLocation searchGTBlock(HashMap<BasicBlock, ControlFlowLocation> done, GuardedTransition destination) {
		Set<BasicBlock> blocks = done.keySet();
		if (destination.getInstruction().eClass().equals(LlvmPackage.eINSTANCE.getBranch())) {
			if (destination.getCondition().contains(sTrueConst)) {
				for (BasicBlock b : blocks) {
					if (b.getLabel().equals(((NonConstantValue) ((Branch) destination.getInstruction()).getLabelTrue()).getName().substring(1))) {
						return done.get(b);
					}
				}
			} else if (destination.getCondition().contains(sFalseConst)) {
				for (BasicBlock b : blocks) {
					if (b.getLabel().equals(((NonConstantValue) ((Branch) destination.getInstruction()).getLabelFalse()).getName().substring(1))) {
						return done.get(b);
					}
				}
			}
		} else if (destination.getInstruction().eClass().equals(LlvmPackage.eINSTANCE.getInvoke())) {
			if (destination.getCondition().contains(sNormalConst)) {
				for (BasicBlock b : blocks) {
					if (b.getLabel().equals(((NonConstantValue) ((Invoke) destination.getInstruction()).getTovalue()).getName().substring(1))) {
						return done.get(b);
					}
				}
			} else if (destination.getCondition().contains(sExcConst)) {
				for (BasicBlock b : blocks) {
					if (b.getLabel().equals(((NonConstantValue) ((Invoke) destination.getInstruction()).getUnwindvalue()).getName().substring(1))) {
						return done.get(b);
					}
				}
			}
		}
		System.out.println("Not found BasicBlock " + destination);
		return null;
	}

	private ControlFlowLocation addControlFlowLocation(ControlFlowDiagram diag, ProgramCounter pc) {
		ControlFlowLocation loc = ControlflowFactory.eINSTANCE.createControlFlowLocation();
		loc.setPc(pc.next());
		loc.setDiagram(diag);
		diag.getLocations().add(loc);
		return loc;
	}

	private Transition addTransition(ControlFlowDiagram diag, Instruction i) {
		Transition transition = ControlflowFactory.eINSTANCE.createTransition();
		transition.setInstruction(i);
		transition.setDiagram(diag);
		diag.getTransitions().add(transition);
		return transition;
	}

	private GuardedTransition addGuardedTransition(ControlFlowDiagram diag, Instruction i) {
		if (i instanceof ReturnInstructionImpl) {
			GuardedTransition transition = ControlflowFactory.eINSTANCE.createGuardedTransition();
			transition.setInstruction(i);
			transition.setDiagram(diag);
			diag.getTransitions().add(transition);
			return transition;
		}
		System.out.println("Class conflict: <Instruction-GuardedTransition>" + i.toString());
		return null;
	}

	private void refreshWorkspace() {
		IProject[] iProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < iProjects.length; i++)
			try {
				iProjects[i].refreshLocal(0, new org.eclipse.core.runtime.NullProgressMonitor());
			} catch (CoreException e) {
				System.out.println("Error on refreshing Workspace - perform F5 by your own.");
				e.printStackTrace();
			}
	}

	private void addTSO(ArrayList<ControlFlowDiagram> list) {
		for (ControlFlowDiagram cfg : list) {
			ControlFlowLocation start = cfg.getStart();
			Set<Transition> may = new TreeSet<Transition>();
			ControlFlowLocation act = start;
			while (!act.getOutgoing().isEmpty()) {

			}
		}
	}
}