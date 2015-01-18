package de.upb.lina.cfg.tools;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.upb.lina.cfg.controlflow.AddressValuePair;
import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.controlflow.ControlflowFactory;
import de.upb.lina.cfg.controlflow.EarlyReadTransition;
import de.upb.lina.cfg.controlflow.FlushTransition;
import de.upb.lina.cfg.controlflow.GuardedTransition;
import de.upb.lina.cfg.controlflow.StoreBuffer;
import de.upb.lina.cfg.controlflow.Transition;
import de.upb.lina.cfg.controlflow.WriteDefChainTransition;
import de.upb.llvm_parser.llvm.Address;
import de.upb.llvm_parser.llvm.AddressUse;
import de.upb.llvm_parser.llvm.BasicBlock;
import de.upb.llvm_parser.llvm.Branch;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.Instruction;
import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.Load;
import de.upb.llvm_parser.llvm.Parameter;
import de.upb.llvm_parser.llvm.Store;
import de.upb.llvm_parser.llvm.Switch;
import de.upb.llvm_parser.llvm.SwitchCase;
import de.upb.llvm_parser.llvm.Value;

public class TSOUtil {
	private List<Instruction> instructions = new ArrayList<Instruction>();
	private List<ControlFlowLocation> processed = new ArrayList<ControlFlowLocation>();
	private List<Instruction> specialstores = new ArrayList<Instruction>();
	
	private GraphUtility util = new GraphUtility();

	private FunctionDefinition function;
	private boolean endProcess = false;
	private boolean loopWithoutFence = false;
	private ArrayList<String> placesInLoopWithoutFence;


	public ControlFlowDiagram createReachibilityGraph(FunctionDefinition function){
		instructions = new ArrayList<Instruction>();
		this.function = function;
		this.placesInLoopWithoutFence = new ArrayList<String>();
		boolean containsFlushesAfterReturn = false;
		ProgramCounter pc = new ProgramCounter();
		ControlFlowDiagram cfg = ControlflowFactory.eINSTANCE
				.createControlFlowDiagram();
		SCUtil sc = new SCUtil();
		PreComputationChecker checker = new PreComputationChecker("", 0);
		List<Transition> earlyReadsInFunction = checker.collectEarlyReadsinSCGraph(sc.createCFG(function));	

		cfg.setName(function.getAddress().getName());
		List<ControlFlowLocation> toBeProcessed = new ArrayList<ControlFlowLocation>();
		processed = new ArrayList<ControlFlowLocation>();

		//Generate a list of all instructions
		EList<BasicBlock> blocks = function.getBody().getBlocks();
		for (BasicBlock b : blocks) {
			for(Instruction i: b.getInstructions()){
				instructions.add(i);
			}
		}

		//just for testing...
		if(Debug.DEBUG2){
			for(Instruction instruction: instructions){
				if(instruction instanceof Store){
					specialstores.add(instruction);
					break;
				}
				
			}
		}

		//first node
		ControlFlowLocation location = createControlFlowLocation(cfg, pc.next(), ControlflowFactory.eINSTANCE.createStoreBuffer(), util.findLabelByInstruction(function,instructions.get(0)));
		if (cfg.getStart() == null) {
			cfg.setStart(location);
			toBeProcessed.add(location);
		}
		
		
		//while we have still nodes to work on
		while(!toBeProcessed.isEmpty() && !endProcess){
			ControlFlowLocation toExplore = toBeProcessed.get(0);

			//get the right instruction of our pc, null if we are at the end
			Instruction nextInstruction = null;
			if(toExplore.getPc() < instructions.size()){
				nextInstruction = instructions.get(toExplore.getPc());	
			}
			//else it is the last location and no further program steps exist


			//empty buffer
			if(toExplore.getBuffer().getAddressValuePairs().isEmpty()){
				if(nextInstruction != null){
					addNonFlushOptions(pc, cfg, toBeProcessed, toExplore, nextInstruction, earlyReadsInFunction);
				}

			//buffer with entries
			}else{
				if(nextInstruction == null)
				{
					//possible flushes after a return
					containsFlushesAfterReturn = true;
//					CFGActivator.logWarning("Method " + function.getAddress().getName() + " potentially returns with a non-empty store buffer."  , null);
				}
				//create flush options, TSO behavior
				addFlushOptions(cfg, toBeProcessed, toExplore, nextInstruction);

				//create normal SC behavior
				if(nextInstruction != null && !util.isSynch(nextInstruction)){
					//other options -SC
					addNonFlushOptions(pc, cfg, toBeProcessed, toExplore, nextInstruction, earlyReadsInFunction);
				}
			}
			//last
			ControlFlowLocation lastProcessed = toBeProcessed.get(0);
			toBeProcessed.remove(0);
			processed.add(lastProcessed);
		}
		
		if (containsFlushesAfterReturn)
		{
			CFGActivator.logWarning("Method " + function.getAddress().getName() + " potentially returns with a non-empty store buffer."  , null);
		}
		
		if(Debug.DEBUG){
			System.out.println("#nodes: " + cfg.getLocations().size() + " ;#edges: " + cfg.getTransitions().size());
		}
		return cfg;

	}


	private void addFlushOptions(ControlFlowDiagram cfg,
			List<ControlFlowLocation> toBeProcessed,
			ControlFlowLocation toExplore, Instruction nextInstruction) {
		
		ControlFlowLocation nextLocation = createControlFlowLocation(cfg, toExplore.getPc(), createFlushedStoreBuffer(toExplore.getBuffer()), util.findLabelByInstruction(function, nextInstruction));
		Transition transition = createFlushTransition(cfg);
		transition.setSource(toExplore);
		transition.setTarget(nextLocation);

		if(!util.isInList(toBeProcessed,nextLocation) && !util.isInList(processed,nextLocation)){
			toBeProcessed.add(nextLocation);	
		}
	}


	private void addNonFlushOptions(ProgramCounter pc, ControlFlowDiagram cfg,
			List<ControlFlowLocation> toBeProcessed,
			ControlFlowLocation toExplore, Instruction nextInstruction, List<Transition> earlyReadsInFunction) {

		//check for branches
		if(nextInstruction.eClass().equals(LlvmPackage.eINSTANCE.getBranch())){
			Branch branch = (Branch)nextInstruction;
			//no jump, real branch
			if(branch.getElseDestination() != null){
				GuardedTransition trueCase = ControlflowFactory.eINSTANCE.createGuardedTransition();

				Instruction trueInstruction = util.getInstructionWithLabel(function, branch.getDestination().substring(1));
				ControlFlowLocation trueLocation = createControlFlowLocation(cfg, util.getPcOfInstruction(trueInstruction, instructions), createStoreBuffer(toExplore.getBuffer(), trueInstruction), util.findLabelByInstruction(function, nextInstruction));
				trueCase.setSource(toExplore);
				trueCase.setTarget(trueLocation);
				trueCase.setInstruction(branch);
				trueCase.setCondition("["+ util.valueToString(branch.getCondition()) + "]");
				trueCase.setDiagram(cfg);

				Instruction elseInstruction = util.getInstructionWithLabel(function, branch.getElseDestination().substring(1));
				ControlFlowLocation falseLocation = createControlFlowLocation(cfg, util.getPcOfInstruction(elseInstruction, instructions), createStoreBuffer(toExplore.getBuffer(), elseInstruction), util.findLabelByInstruction(function, nextInstruction));
				GuardedTransition falseCase = ControlflowFactory.eINSTANCE.createGuardedTransition();
				falseCase.setSource(toExplore);
				falseCase.setTarget(falseLocation);
				falseCase.setInstruction(branch);
				falseCase.setCondition("[else]");
				falseCase.setDiagram(cfg);

				if(!util.isInList(toBeProcessed,trueLocation) && !util.isInList(processed,trueLocation)){
					toBeProcessed.add(trueLocation);
				}
				if(!util.isInList(toBeProcessed,falseLocation) && !util.isInList(processed,falseLocation)){
					toBeProcessed.add(falseLocation);
				}
			}

			//jump
			//&& branch.getElseDestination() == null
			else if(branch.getDestination() != null){
				Transition t = createTransition(cfg, branch);
				Instruction trueInstruction = util.getInstructionWithLabel(function, branch.getDestination().substring(1));
				ControlFlowLocation nextLocation = createControlFlowLocation(cfg, util.getPcOfInstruction(trueInstruction, instructions), createStoreBuffer(toExplore.getBuffer(), branch), util.findLabelByInstruction(function, nextInstruction));
				t.setSource(toExplore);
				t.setTarget(nextLocation);
				if(!util.isInList(toBeProcessed,nextLocation) && !util.isInList(processed,nextLocation)){
					toBeProcessed.add(nextLocation);
				}
			}
		}else if(nextInstruction.eClass().equals(LlvmPackage.eINSTANCE.getSwitch())){
			//TODO: check if switch implementation correct
			Switch swit = (Switch)nextInstruction;
			
			Instruction defaultInstruction = util.getInstructionWithLabel(function, swit.getDefaultCase());
			ControlFlowLocation defaultLocation = createControlFlowLocation(cfg, util.getPcOfInstruction(defaultInstruction, instructions), createStoreBuffer(toExplore.getBuffer(), defaultInstruction), util.findLabelByInstruction(function, nextInstruction));
			
			GuardedTransition defaultCase = ControlflowFactory.eINSTANCE.createGuardedTransition();
			defaultCase.setCondition("else");
			defaultCase.setSource(toExplore);
			defaultCase.setTarget(defaultLocation);
			defaultCase.setDiagram(cfg);
			defaultCase.setInstruction(swit);
			
			if(!util.isInList(toBeProcessed,defaultLocation) && !util.isInList(processed,defaultLocation)){
				toBeProcessed.add(defaultLocation);
			}
			
			for(SwitchCase sc: swit.getCases()){
				Instruction caseInstruction = util.getInstructionWithLabel(function, util.valueToString(sc.getCaseValue().getValue()));
				ControlFlowLocation caseLocation = createControlFlowLocation(cfg, util.getPcOfInstruction(caseInstruction, instructions), createStoreBuffer(toExplore.getBuffer(), caseInstruction), util.findLabelByInstruction(function, nextInstruction));
				
				GuardedTransition caseC = ControlflowFactory.eINSTANCE.createGuardedTransition();
				caseC.setCondition("else");
				caseC.setSource(toExplore);
				caseC.setTarget(caseLocation);
				caseC.setInstruction(swit);
				caseC.setDiagram(cfg);
				
				if(!util.isInList(toBeProcessed,caseLocation) && !util.isInList(processed,caseLocation)){
					toBeProcessed.add(caseLocation);
				}
			}
		}else if(nextInstruction.eClass().equals(LlvmPackage.eINSTANCE.getIndirectBranch())){
			// TODO: target depends on register content -> condition of
			// control flow guards unclear
			throw new RuntimeException(
					"IndirectBranch found. Handling of such is not implemented yet");
			
			//check if nextInstruction is store in WriteDefChain
		}else if(specialstores.contains(nextInstruction) && nextInstruction instanceof Store){
			
			Transition t = createWriteDefChainTransition(cfg, nextInstruction);
			
			//create next location
			ControlFlowLocation nextLocation = createControlFlowLocation(cfg, toExplore.getPc() + 1,
					createStoreBufferAfterWriteDefChainTransition(cfg, toExplore.getBuffer(), (Store)nextInstruction),
					util.findLabelByInstruction(function, nextInstruction));
			t.setSource(toExplore);
			t.setTarget(nextLocation);
			
			if (!util.isInList(toBeProcessed, nextLocation) && !util.isInList(processed, nextLocation)) {
				toBeProcessed.add(nextLocation);
			}
			
		}else{
			//check if instruction is earlyRead
			if(nextInstruction instanceof Load){
				String assignmentExpression = instructionIsEarlyRead(earlyReadsInFunction, toExplore, nextInstruction);
				
				if (assignmentExpression != null) {
					//instruction is early read
					Transition t = createEarlyReadTransition(cfg, (Load)nextInstruction, assignmentExpression);
					ControlFlowLocation nextLocation = createControlFlowLocation(cfg, toExplore.getPc() + 1,
							createStoreBuffer(toExplore.getBuffer(), nextInstruction),
							util.findLabelByInstruction(function, nextInstruction));
					t.setSource(toExplore);
					t.setTarget(nextLocation);
					
					if (!util.isInList(toBeProcessed, nextLocation) && !util.isInList(processed, nextLocation)) {
						toBeProcessed.add(nextLocation);
					}
					return;
				}
			}
			//normal writes will be dealt here
			
			Transition t = createTransition(cfg, nextInstruction);
			ControlFlowLocation nextLocation = createControlFlowLocation(cfg, toExplore.getPc()+1, createStoreBuffer(toExplore.getBuffer(), nextInstruction), util.findLabelByInstruction(function, nextInstruction));
			t.setSource(toExplore);
			t.setTarget(nextLocation);
			
			//if we have a write we have to check if we have a loop without fence 
			//See createStoreBuffer for more details
			if(loopWithoutFence){
				loopWithoutFence = false;
				reportLoopWithoutFence(function.getAddress().getName(), toExplore, nextLocation, nextInstruction);
//				warningLogger.logPlaceInLoopWithoutFence(function.getAddress().getName(), toExplore, nextLocation, nextInstruction);
			}
			
			if(!util.isInList(toBeProcessed,nextLocation) && !util.isInList(processed,nextLocation)){
				toBeProcessed.add(nextLocation);
			}
		}
	}

	private StoreBuffer createStoreBuffer(StoreBuffer oldBuffer, Instruction nextInstruction){
		StoreBuffer buffer = ControlflowFactory.eINSTANCE.createStoreBuffer();
		//create deep copy
		for(AddressValuePair pair: oldBuffer.getAddressValuePairs()){
			AddressValuePair newPair = ControlflowFactory.eINSTANCE.createAddressValuePair();
			newPair.setAddress(pair.getAddress());
			newPair.setValue(pair.getValue());
			buffer.getAddressValuePairs().add(newPair);
		}

		//add new buffer entry for store
		if(nextInstruction.eClass().equals(LlvmPackage.eINSTANCE.getStore())){
			Store store = (Store)nextInstruction;
			AddressValuePair newPair = ControlflowFactory.eINSTANCE.createAddressValuePair();
			newPair.setAddress(store.getTargetAddress());
			newPair.setValue(store.getValue());
			if(!util.isAVPInList(buffer.getAddressValuePairs(), newPair)){
				buffer.getAddressValuePairs().add(newPair);
			}else{
				//TODO: Error handling - loop without fence
				loopWithoutFence = true;
			}

		}

		return buffer;
	}

	/**
	 * Creates a deep copy of the old buffer without its first entry (flushed)
	 * @param oldBuffer the buffer to be flushed
	 * @return flushed deep copy of the old buffer
	 */
	private StoreBuffer createFlushedStoreBuffer(StoreBuffer oldBuffer){
		StoreBuffer buffer = ControlflowFactory.eINSTANCE.createStoreBuffer();
		for(AddressValuePair pair: oldBuffer.getAddressValuePairs()){
			AddressValuePair newPair = ControlflowFactory.eINSTANCE.createAddressValuePair();
			newPair.setAddress(pair.getAddress());
			newPair.setValue(pair.getValue());
			buffer.getAddressValuePairs().add(newPair);
		}
		buffer.getAddressValuePairs().remove(0);

		return buffer;
	}

	private StoreBuffer createStoreBufferAfterWriteDefChainTransition(ControlFlowDiagram cfg, StoreBuffer oldBuffer, Store store) {
		StoreBuffer buffer = ControlflowFactory.eINSTANCE.createStoreBuffer();
		// create deep copy
		for (AddressValuePair pair : oldBuffer.getAddressValuePairs()) {
			AddressValuePair newPair = ControlflowFactory.eINSTANCE.createAddressValuePair();
			newPair.setAddress(pair.getAddress());
			newPair.setValue(pair.getValue());
			buffer.getAddressValuePairs().add(newPair);
		}
		// add new buffer entry for store
		AddressValuePair newPair = ControlflowFactory.eINSTANCE.createAddressValuePair();
		newPair.setAddress(store.getTargetAddress());
		Parameter param = EcoreUtil.copy(store.getValue());
		Address address =  EcoreUtil.copy(((AddressUse)store.getValue().getValue()).getAddress());
		
		String registerName = ((AddressUse) param.getValue()).getAddress().getName();
		registerName += "*";
		address.setName(registerName);
		((AddressUse) param.getValue()).setAddress(address);		
		cfg.getVariableCopies().add(address);
		cfg.getVariableCopyParams().add(param);
		newPair.setValue(param);
		buffer.getAddressValuePairs().add(newPair);

		return buffer;
	}


	/**
	 * @param diag
	 * @param pc
	 * @return
	 */
	private ControlFlowLocation createControlFlowLocation(
			ControlFlowDiagram diag, int pc, StoreBuffer buffer, String blockLabel) {
		for(ControlFlowLocation l: diag.getLocations()){
			if(util.isCorrectLocation(l, pc, buffer)){
				return l;
			}
		}
		ControlFlowLocation loc = ControlflowFactory.eINSTANCE
				.createControlFlowLocation();
		loc.setBuffer(buffer);
		loc.setPc(pc);
		loc.setDiagram(diag);
		loc.setBlockLabel(blockLabel);
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

	/**
	 * @param diag
	 * @param i
	 * @return
	 */
	private Transition createFlushTransition(ControlFlowDiagram diag) {
		FlushTransition transition = ControlflowFactory.eINSTANCE.createFlushTransition();
		transition.setDiagram(diag);
		return transition;
	}
	
	private Transition createEarlyReadTransition(ControlFlowDiagram cfg, Load nextInstruction, String assignmentExpression) {
		EarlyReadTransition transition = ControlflowFactory.eINSTANCE.createEarlyReadTransition();
		transition.setInstruction(nextInstruction);
		transition.setAssignmentExpression(assignmentExpression);
		transition.setDiagram(cfg);
		return transition;
	}
	

	private Transition createWriteDefChainTransition(ControlFlowDiagram cfg, Instruction nextInstruction) {
		WriteDefChainTransition transition = ControlflowFactory.eINSTANCE.createWriteDefChainTransition();
		transition.setDiagram(cfg);
		transition.setInstruction(nextInstruction);
		return transition;
	}

	private String instructionIsEarlyRead(List<Transition> earlyReadsInFunction,
			ControlFlowLocation toExplore, Instruction nextInstruction) {
		for (Transition transition : earlyReadsInFunction) {
			if (transition.getSource().getPc() == toExplore.getPc()
					&& transition.getTarget().getPc() == toExplore.getPc() + 1
					&& transition.getInstruction().equals(nextInstruction)) {
				if (nextInstruction instanceof Load) {
					Load earlyReadInstruction = (Load) nextInstruction;
					// now check if it is indeed an early read
					for (AddressValuePair avp : toExplore.getBuffer().getAddressValuePairs()) {
						if (avp.getValue().getValue() instanceof AddressUse
								&& earlyReadInstruction.getAddress().getValue() instanceof AddressUse) {
							AddressUse avpaddress = (AddressUse) avp.getValue().getValue();
							AddressUse transitionaddress = (AddressUse) earlyReadInstruction.getAddress().getValue();
							if (avpaddress.getAddress().equals(transitionaddress.getAddress())) {
								Value value = avp.getAddress().getValue();
								if (value instanceof AddressUse) {
									return ((AddressUse) value).getAddress().getName();
								}
								return "TODO";
							}
							if (avp.getAddress().eContainer() instanceof Store) {
								Store store = (Store) avp.getAddress().eContainer();
								if (store.getValue().getValue() instanceof AddressUse) {
									if (((AddressUse) store.getValue().getValue()).getAddress().equals(
											transitionaddress.getAddress())) {
										Value value = avp.getAddress().getValue();
										if (value instanceof AddressUse) {
											return ((AddressUse) value).getAddress().getName();
										}
										return "TODO";
									}
								}
							}
						}
					}
				}
			}
		}
		//no early read
		return null;
	}
	
	private void reportLoopWithoutFence(String functionName, ControlFlowLocation locBeforeLatesFence,
			ControlFlowLocation nextLocAfterWrite, Instruction instruction)
	{
		String error = functionName + " - between " + util.getBufferAsString(locBeforeLatesFence) + " and "
				+ util.getBufferAsString(nextLocAfterWrite) + " caused by " + instruction.toString() + "\n";
		if (!placesInLoopWithoutFence.contains(error))
		{
			placesInLoopWithoutFence.add(error);
		}
	}
	
	public String getWarnings()
	{
		
		
		String error = null;

		if (!placesInLoopWithoutFence.isEmpty())
		{
			error = "Loops without fence have been found at: \n";
			for (String s : placesInLoopWithoutFence)
			{
				error += s + "\n";
			}
			error += "\n";
		}
		
		
		return error;
	}
}
