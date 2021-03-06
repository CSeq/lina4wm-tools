package de.upb.lina.transformations.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.upb.lina.cfg.controlflow.AddressValuePair;
import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.controlflow.GuardedTransition;
import de.upb.lina.cfg.controlflow.Transition;
import de.upb.lina.cfg.controlflow.WriteDefChainTransition;
import de.upb.lina.cfg.gendata.AddressMapping;
import de.upb.lina.cfg.gendata.ConstraintMapping;
import de.upb.lina.cfg.gendata.FunctionParamsMapping;
import de.upb.lina.cfg.gendata.GendataFactory;
import de.upb.lina.cfg.gendata.GeneratorData;
import de.upb.lina.cfg.gendata.LocalVariables;
import de.upb.lina.cfg.gendata.LocationLabel;
import de.upb.lina.cfg.gendata.PhiMapping;
import de.upb.lina.cfg.gendata.TransitionLabel;
import de.upb.lina.transformations.wizards.TransformationWizardPage;
import de.upb.llvm_parser.llvm.AbstractElement;
import de.upb.llvm_parser.llvm.Address;
import de.upb.llvm_parser.llvm.AddressUse;
import de.upb.llvm_parser.llvm.Alloc;
import de.upb.llvm_parser.llvm.ArithmeticOperation;
import de.upb.llvm_parser.llvm.AtomicRMW;
import de.upb.llvm_parser.llvm.BasicBlock;
import de.upb.llvm_parser.llvm.Branch;
import de.upb.llvm_parser.llvm.Call;
import de.upb.llvm_parser.llvm.Cast;
import de.upb.llvm_parser.llvm.CmpXchg;
import de.upb.llvm_parser.llvm.Compare;
import de.upb.llvm_parser.llvm.Constant;
import de.upb.llvm_parser.llvm.ExtractElement;
import de.upb.llvm_parser.llvm.ExtractValue;
import de.upb.llvm_parser.llvm.Fence;
import de.upb.llvm_parser.llvm.FunctionBody;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.FunctionParameter;
import de.upb.llvm_parser.llvm.FunctionParameterList;
import de.upb.llvm_parser.llvm.GetElementPtr;
import de.upb.llvm_parser.llvm.IndirectBranch;
import de.upb.llvm_parser.llvm.InsertElement;
import de.upb.llvm_parser.llvm.InsertValue;
import de.upb.llvm_parser.llvm.Instruction;
import de.upb.llvm_parser.llvm.Invoke;
import de.upb.llvm_parser.llvm.LLVM;
import de.upb.llvm_parser.llvm.LandingPad;
import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.Load;
import de.upb.llvm_parser.llvm.LogicOperation;
import de.upb.llvm_parser.llvm.Phi;
import de.upb.llvm_parser.llvm.PrimitiveValue;
import de.upb.llvm_parser.llvm.Resume;
import de.upb.llvm_parser.llvm.Return;
import de.upb.llvm_parser.llvm.Select;
import de.upb.llvm_parser.llvm.ShuffleVector;
import de.upb.llvm_parser.llvm.Store;
import de.upb.llvm_parser.llvm.Switch;
import de.upb.llvm_parser.llvm.Unreachable;
import de.upb.llvm_parser.llvm.Value;
import de.upb.llvm_parser.llvm.VariableAttributeAccess;
import de.upb.llvm_parser.llvm.impl.AddressUseImpl;

public class GendataPrecomputer {

	private static final String CAS = "cas";
	private static final String GETELEMENTPTR = "getelementptr";

	private List<ControlFlowDiagram> cfgs;
	private int basis;
	private GeneratorData helperModel;

	private HashMap <Address, String> addressLookup = new HashMap<Address, String>();
	private HashMap <ControlFlowDiagram, String> cfgToLabelPrefix = new HashMap <ControlFlowDiagram, String>();

	private HashMap<FunctionDefinition, List<String>> usedVarsInFunctions = new HashMap<FunctionDefinition, List<String>>();

	public GendataPrecomputer(List<ControlFlowDiagram> cfgs, int basis){
		this.cfgs = cfgs;
		this.basis = basis;
	}

	public GeneratorData computeGeneratorData(){
		precomputeHelperModel();
		return helperModel;
	}

	private void precomputeHelperModel(){
		helperModel = GendataFactory.eINSTANCE.createGeneratorData();

		for(ControlFlowDiagram cfg: cfgs){
			try{
				EObject motherObject = cfg.getStart().getOutgoing().get(0).getInstruction().eContainer();
				BasicBlock basicBlock = (BasicBlock) motherObject;
				FunctionBody fb = (FunctionBody)basicBlock.eContainer();
				FunctionDefinition fd = (FunctionDefinition)fb.eContainer();
				usedVarsInFunctions.put(fd, new ArrayList<String>());
			}catch(NullPointerException ex){

			}
		}

		//set the program
		try{
			//llvm
			EObject motherObject = cfgs.get(0).getStart().getOutgoing().get(0).getInstruction().eContainer();
			BasicBlock basicBlock = (BasicBlock) motherObject;
			FunctionBody fb = (FunctionBody)basicBlock.eContainer();
			FunctionDefinition fd = (FunctionDefinition)fb.eContainer();
			LLVM program = (LLVM)fd.eContainer();
			helperModel.setProgram(program);
			//			helperModel.setNeedsCas(false);
			//			helperModel.setNeedsGetElementPtr(false);
			helperModel.getCfgs().addAll(cfgs);

			//local vars
			LocalVariables localVars = GendataFactory.eINSTANCE.createLocalVariables();
			initLocalVariables(localVars, program);
			helperModel.setLocalVariables(localVars);

			//labels
			computeLabelPrefixesPerFunction();
			initLocationLabels(localVars);
			initTransitionLabels(localVars);

			//conditions
			computeTransitionConditionMapping(helperModel.getConstraints());

			//parameterFunctionMappings
			computeParameterFunctionMapping(helperModel);

			//phi mappings
			computePhiMapping(helperModel.getPhiMappings());
			
			//KIV transformation basis
			addBasis();
			checkForMulOrDiv();


		}catch(ClassCastException ex){
			Activator.logError("Could not link LLVM program to this transformation.", ex);
		}
	}

	private void addBasis() {
		if(basis == TransformationWizardPage.INT){
			helperModel.getTransformationSpecificKeys().add("INT");
		}else if(basis == TransformationWizardPage.NAT){
			helperModel.getTransformationSpecificKeys().add("NAT");
		}
	}
	
	private void checkForMulOrDiv(){
		String s = Utils.checkForMulOrDiv(cfgs);
		if(s != null)
			helperModel.getTransformationSpecificKeys().add(s);
	}

	private void computePhiMapping(List<PhiMapping> phiMappings){
		for(ControlFlowDiagram cfg: cfgs){
			HashMap<String, ArrayList<Phi>> blockLabelToPhiInstructions = new HashMap<String, ArrayList<Phi>>();
			try{
				EObject motherObject = cfg.getStart().getOutgoing().get(0).getInstruction().eContainer();
				BasicBlock basicBlock = (BasicBlock) motherObject;
				FunctionBody fb = (FunctionBody)basicBlock.eContainer();
				FunctionDefinition fd = (FunctionDefinition)fb.eContainer();
				for(BasicBlock b: fd.getBody().getBlocks()){
					blockLabelToPhiInstructions.put(b.getLabel(), new ArrayList<Phi>());
					for(Instruction i: b.getInstructions()){
						if(i instanceof Phi){
							if(!blockLabelToPhiInstructions.get(b.getLabel()).contains(i)){
								blockLabelToPhiInstructions.get(b.getLabel()).add((Phi)i);
							}
						}
					}
				}


			}catch(NullPointerException ex){

			}

			for(Transition t: cfg.getTransitions()){
				//block change
				if(!t.getSource().getBlockLabel().equals(t.getTarget().getBlockLabel())){
					for(Transition inc: t.getSource().getIncoming()){
						if(!blockLabelToPhiInstructions.get(t.getTarget().getBlockLabel()).isEmpty()){
							PhiMapping mapping = constructPhiMapping(inc, blockLabelToPhiInstructions.get(t.getTarget().getBlockLabel()), "%" + inc.getSource().getBlockLabel());
							phiMappings.add(mapping);
						}
					}
				}

			}
		}
	}

	private PhiMapping constructPhiMapping(Transition transition, List<Phi> phis, String blockLabel){
		PhiMapping mapping = GendataFactory.eINSTANCE.createPhiMapping();
		mapping.setTransition(transition);
		mapping.getPhi().addAll(phis);
		mapping.setBlockLabelToUse(blockLabel);
		return mapping;
	}

	private void computeParameterFunctionMapping(GeneratorData genData){
		List<FunctionParamsMapping> functionParamMapping = genData.getParameterMappings();
		for(ControlFlowDiagram cfg: cfgs){
			FunctionParamsMapping mapping = GendataFactory.eINSTANCE.createFunctionParamsMapping();
			if(cfg.getStart() != null && !cfg.getStart().getOutgoing().isEmpty()){
				EObject motherObject = cfg.getStart().getOutgoing().get(0).getInstruction().eContainer();
				BasicBlock basicBlock = (BasicBlock) motherObject;
				FunctionBody fb = (FunctionBody)basicBlock.eContainer();
				FunctionDefinition fd = (FunctionDefinition)fb.eContainer();

				mapping.setCfg(cfg);
				mapping.setFunction(fd);
				mapping.setNeedsReturnValue(false);

				for(Transition t: cfg.getTransitions()){
					if(t.getInstruction() instanceof Return){
						Return ret = (Return) t.getInstruction();
						if(ret.getValue() != null){
							mapping.setNeedsReturnValue(true);
						}
					}

					if(t.getInstruction() instanceof CmpXchg){
						if(!genData.getTransformationSpecificKeys().contains(CAS)){
							genData.getTransformationSpecificKeys().add(CAS);
						}
					}
					if(t.getInstruction() instanceof GetElementPtr){
						if(!genData.getTransformationSpecificKeys().contains(GETELEMENTPTR)){
							genData.getTransformationSpecificKeys().add(GETELEMENTPTR);
						}
					}
				}



				//Compute usedvars
				//Remove params from list of vars to declare
				if(fd.getParameter() != null){
					for(FunctionParameter param: fd.getParameter().getParams()){
						usedVarsInFunctions.get(fd).remove(addressLookup.get(param.getValue()));
					}
				}
				mapping.getVarNamesInFunction().addAll(usedVarsInFunctions.get(fd));

				functionParamMapping.add(mapping);
			}

		}




	}

	private void initTransitionLabels(LocalVariables localVars) {

		for(ControlFlowDiagram cfg : cfgs){
			int size = 1;
			for(Transition t : cfg.getTransitions()){
				String labelName = generateTransitionLabel(t, size);
				List<TransitionLabel> labels = helperModel.getTransitionLabels();
				TransitionLabel transitionLabel = GendataFactory.eINSTANCE.createTransitionLabel();
				transitionLabel.setName(labelName);
				transitionLabel.setTransition(t);
				labels.add(transitionLabel);
				size++;
			}
		}
	}
	
	private String generateTransitionLabel(Transition transition, int size){
		String sizeString = String.valueOf(size);
		String transitionLabel = cfgToLabelPrefix.get(transition.getDiagram()).toLowerCase()+sizeString;		
		return transitionLabel;
	}

	private void initLocationLabels(LocalVariables localVars){
		for(ControlFlowDiagram cfg: cfgs){
			List<LocationLabel> labels = helperModel.getLocationLabels();
			//prepare for check if we can use short buffer labels
			List<ControlFlowLocation> conflictingLocs = new ArrayList<ControlFlowLocation>();
			List<String> iteratedBuffers = new ArrayList<String>();
			for(ControlFlowLocation l: cfg.getLocations()){
				String bufferRep = generateShortLabel(l, localVars, cfg.getLocations().size());
				if(iteratedBuffers.contains(bufferRep)){
					conflictingLocs.add(l);
				}
				else
				{
					iteratedBuffers.add(bufferRep);
				}
			}

			for(ControlFlowLocation l: cfg.getLocations()){
				String bufferRepresentation;
				//use long buffer labels if needed as of conflict, short if not needed
				if(conflictingLocs.contains(l)){
					bufferRepresentation = generateLabel(l, localVars, cfg.getLocations().size());
				}else{
					bufferRepresentation = generateShortLabel(l, localVars, cfg.getLocations().size());
				}
				LocationLabel label = GendataFactory.eINSTANCE.createLocationLabel();
				label.setName(bufferRepresentation);
				label.setControlFlowLocation(l);
				labels.add(label);
			}
		}
	}

	private void computeTransitionConditionMapping(List<ConstraintMapping> constraints){
		for(ControlFlowDiagram cfg: cfgs){
			ArrayList<ControlFlowLocation> workedOn = new ArrayList<ControlFlowLocation>();
			ArrayList<ControlFlowLocation> toWorkOn = new ArrayList<ControlFlowLocation>();

			toWorkOn.add(cfg.getStart());

			while(!toWorkOn.isEmpty()){
				ControlFlowLocation currentLoc = toWorkOn.remove(0);
				workedOn.add(currentLoc);

				List<Transition> outgoing = currentLoc.getOutgoing();

				if(outgoing.size() > 1){
					GuardedTransition ifTransition = null;
					for(Transition t: outgoing){
						if(t instanceof GuardedTransition){
							//deal with the if case
							GuardedTransition gt = (GuardedTransition)t;
							if(ifTransition == null && !gt.getCondition().contains("else")){
								ifTransition = gt;
								//TODO: Transform condition correctly!
								constraints.add(constructConstraintMapping(gt, gt.getCondition())); //HERE Cond
							}
						}else{
							//flushs and normal transitions that need a condition in promela
							constraints.add(constructConstraintMapping(t, "true"));
						}

					}

					//get the else case
					for(Transition t: outgoing){
						if(t instanceof GuardedTransition && !t.equals(ifTransition)){
							GuardedTransition gt = (GuardedTransition)t;
							//TODO: Transform condition correctly!
							constraints.add(constructConstraintMapping(gt, "!" + ifTransition.getCondition())); //HERE Cond
						}
						//Add rest to work on
						if(!workedOn.contains(t.getTarget()) && !toWorkOn.contains(t.getTarget())){
							toWorkOn.add(t.getTarget());
						}
					}
				}

				//Add rest to work on
				for(Transition t: outgoing){	
					if(!workedOn.contains(t.getTarget()) && !toWorkOn.contains(t.getTarget())){
						toWorkOn.add(t.getTarget());
					}
				}
			}
		}
	}

	private ConstraintMapping constructConstraintMapping(Transition t, String condition){
		//manipulate condition
		condition = condition.replaceAll("[\\[\\]]", "");

		if(!condition.equalsIgnoreCase("true")){
			for(AddressMapping addressMapping: helperModel.getLocalVariables().getVariables()){
				for(String oldName: addressMapping.getOldNames()){
					if(oldName.equals(condition.replaceAll("!",""))){
						if(condition.startsWith("!")){
							condition = "!" + addressMapping.getName();
						}else{
							condition = addressMapping.getName();
						}
					}
				}
			}

		}

		//construct mapping
		ConstraintMapping mapping = GendataFactory.eINSTANCE.createConstraintMapping();
		mapping.setTransition(t);
		mapping.setCondition(condition);
		return mapping;
	}

	private void computeLabelPrefixesPerFunction(){
		char currentChar = 'A';
		for(int i = 0; i< cfgs.size();i++){
			ControlFlowDiagram cfg = cfgs.get(i);
			cfgToLabelPrefix.put(cfg, ""+currentChar);
			currentChar++;
		}


	}

	private String generateShortLabel(ControlFlowLocation loc, LocalVariables localVars, int size){
		int sizeString = String.valueOf(size).length();
		String bufferLabel = cfgToLabelPrefix.get(loc.getDiagram()) + String.format("%0"+sizeString+"d", loc.getPc());

		for(AddressValuePair avp: loc.getBuffer().getAddressValuePairs()){
			//Address address = ((AddressUse) (avp.getAddress().getValue())).getAddress();

			bufferLabel += lookupValue(avp.getAddress().getValue());
		}

		//		System.out.println(bufferLabel);

		return bufferLabel;
	}

	private String generateLabel(ControlFlowLocation loc, LocalVariables localVars, int size){
		int sizeString = String.valueOf(size).length();
		String bufferLabel = cfgToLabelPrefix.get(loc.getDiagram()) + String.format("%0"+sizeString+"d", loc.getPc());

		for(AddressValuePair avp: loc.getBuffer().getAddressValuePairs()){
			//Address address = ((AddressUse) (avp.getAddress().getValue())).getAddress();

			bufferLabel += lookupValue(avp.getAddress().getValue()) + lookupValue(avp.getValue().getValue());
		}

		//		System.out.println(bufferLabel);

		return bufferLabel;
	}

	private String lookupValue(Value value){
		if (value.eClass().equals(LlvmPackage.eINSTANCE.getConstant())) {
			Constant constant = (Constant) value;
			return constant.getValue().toString();
		}

		if (value instanceof AddressUseImpl) {
			return addressLookup.get(((AddressUseImpl) value).getAddress());
		}

		if(value.eClass().equals(LlvmPackage.eINSTANCE.getPrimitiveValue())){
			PrimitiveValue val = (PrimitiveValue)value;
			return val.getValue();
		}
		return value.toString();
	}

	private Address extractAddressFromValue(Value v){
		if(v instanceof AddressUse){
			return ((AddressUse) v).getAddress();
		}

		return null;
	}

	/**
	 * Constructs the actual variable mapping
	 * @param localVars
	 * @param program
	 */
	private void initLocalVariables(LocalVariables localVars, LLVM program) throws IllegalArgumentException{
		List<AddressMapping> mapping = localVars.getVariables();

		//map copyVars from writeDefChain
		for(ControlFlowDiagram cfg : cfgs){
			for(Transition t : cfg.getTransitions()){
				if(t instanceof WriteDefChainTransition){
					WriteDefChainTransition wdcTransition = (WriteDefChainTransition) t;
					if(wdcTransition.getCopyAddress() != null){
						Address copyAddress = wdcTransition.getCopyAddress();
						addToMapping(mapping, cfg, copyAddress);
					}
					if(wdcTransition.getCopyValue() != null){
						Address copyValue = wdcTransition.getCopyValue();
						addToMapping(mapping, cfg, copyValue);
					}
				}
			}
		}
		
		//collect all addresses
		for(AbstractElement ele: program.getElements()){
			if(ele instanceof FunctionDefinition){
				FunctionDefinition fDef = (FunctionDefinition)ele;
				ControlFlowDiagram matchingCfg = getCFGForFunction(fDef);

				//map params
				if(matchingCfg != null && matchingCfg.getStart() != null && !matchingCfg.getStart().getOutgoing().isEmpty()){		
					EObject motherObject = matchingCfg.getStart().getOutgoing().get(0).getInstruction().eContainer();
					BasicBlock basicBlock = (BasicBlock) motherObject;
					FunctionBody fb = (FunctionBody)basicBlock.eContainer();
					FunctionDefinition fd = (FunctionDefinition)fb.eContainer();
					FunctionParameterList params = fd.getParameter();
					if(params!= null){
						for(FunctionParameter param: params.getParams()){
							addToMapping(mapping, matchingCfg, param.getValue());
						}
					}
				}

				//map vars in function
				if(fDef.getBody() != null && matchingCfg != null){
					for(BasicBlock b: fDef.getBody().getBlocks()){
						for(Instruction i: b.getInstructions()){
							if(i instanceof ArithmeticOperation){
								ArithmeticOperation op = (ArithmeticOperation)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue1()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue2()));

							}else if(i instanceof LogicOperation){
								LogicOperation op = (LogicOperation)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue1()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue2()));

							}else if(i instanceof Cast){
								Cast op = (Cast)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue()));

							}else if(i instanceof GetElementPtr){
								GetElementPtr op = (GetElementPtr)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getAggerate().getValue()));

							}else if(i instanceof Fence){
								//nothing to do here
							}else if(i instanceof CmpXchg){
								CmpXchg op = (CmpXchg)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getAddress().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getNewValue().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue().getValue()));
							}else if(i instanceof AtomicRMW){
								AtomicRMW op = (AtomicRMW) i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getAddress().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getArgument().getValue()));

							}else if(i instanceof Load){
								Load op = (Load) i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getAddress().getValue()));

							}else if(i instanceof Store){
								Store op = (Store)i;
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getTargetAddress().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue().getValue()));

							}else if(i instanceof Call){
								Call op = (Call)i;
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getFunction().getValue()));
								addToMapping(mapping, matchingCfg, op.getResult());

							}else if(i instanceof Alloc){
								Alloc op = (Alloc)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								if(op.getNumOfElements()!=null)
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getNumOfElements().getValue()));

							}else if(i instanceof Phi){
								Phi op = (Phi)i;
								addToMapping(mapping, matchingCfg, op.getResult());

							}else if(i instanceof LandingPad){
								LandingPad op = (LandingPad)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getPersonalityvalue()));

							}else if(i instanceof Select){
								Select op = (Select)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getCondition().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getElseValue().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getTrueValue().getValue()));

							}else if(i instanceof VariableAttributeAccess){
								VariableAttributeAccess op = (VariableAttributeAccess) i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getVaList().getValue()));

							}else if(i instanceof ExtractValue){
								ExtractValue op = (ExtractValue)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getAggerate().getValue()));

							}else if(i instanceof InsertValue){
								InsertValue op = (InsertValue)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getAggerate().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue().getValue()));
							}else if(i instanceof ExtractElement){
								ExtractElement op = (ExtractElement)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getVector().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getIndex().getValue()));

							}else if(i instanceof InsertElement){
								InsertElement op = (InsertElement)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getVector().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getIndex().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue().getValue()));

							}else if(i instanceof ShuffleVector){
								ShuffleVector op = (ShuffleVector)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue1().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue2().getValue()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getMask().getValue()));
							}else if(i instanceof Compare){
								Compare op = (Compare)i;
								addToMapping(mapping, matchingCfg, op.getResult());
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getOperand1()));
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getOperand2()));
							}else if(i instanceof IndirectBranch){
								//nothing to do here
							}else if(i instanceof Switch){
								//nothing to do here
							}else if(i instanceof Invoke){
								Invoke op = (Invoke)i;
								addToMapping(mapping, matchingCfg, op.getName());
							}else if(i instanceof Resume){
								//nothing to do here
							}else if(i instanceof Unreachable){
								//nothing to do here
							}else if(i instanceof Return){
								Return op = (Return) i;
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getValue().getValue()));

							}else if(i instanceof Branch){
								Branch op = (Branch)i;
								addToMapping(mapping, matchingCfg, extractAddressFromValue(op.getCondition()));
							}	
						}
					}
				}

			}else{
				//throw new IllegalArgumentException("Error in LLVM");
			}
		}
	}

	private void addToMapping(List<AddressMapping> mapping, ControlFlowDiagram cfg, Address address){
		if(address == null){
			return;
		}

		Address addressCopy = address;

//		//check if address was redefined
//		for(Address a: cfg.getVariableCopies()){
//			if(a.getName().replaceAll("Copy", "").equalsIgnoreCase(address.getName())){
//				addressCopy = a;
//			}
//		}
		
		
		AddressMapping correspondingMapping = getMappingForAddress(addressCopy, mapping);
		//if corresponding mapping found
		if(correspondingMapping != null){
			//if that address is not yet contained
			if(!doesContainAddress(addressCopy, correspondingMapping)){
				correspondingMapping.getAdresses().add(addressCopy);
				addressLookup.put(addressCopy, correspondingMapping.getName());
			}
		//no mapping found, create new one
		}else{
			//create new addressmapping
			AddressMapping addressMapping = createAddressMapping(addressCopy, Utils.clean(addressCopy.getName()));

			mapping.add(addressMapping);
			addressLookup.put(addressCopy, addressMapping.getName());	
		}

//		//check if already have a mapping for that address
//		if(!isAddressMapped(address, mapping)){
//
//>>>>>>> branch 'develop' of ssh://git@github.com/oleg82upb/lina4wm-tools.git
//			//create new addressmapping
//			AddressMapping addressMapping = createAddressMapping(address, Utils.clean(address.getName()));
//
//			mapping.add(addressMapping);
//			addressLookup.put(address, addressMapping.getName());
//		}


		// add used vars to the list
		FunctionDefinition fun = getFunctionForCfg(cfg);
		if(!address.getName().startsWith("@") && !usedVarsInFunctions.get(fun).contains(addressLookup.get(address))){
			usedVarsInFunctions.get(fun).add(addressLookup.get(address));
		}
	}

	/**
	 * Returns the mapping for the given address if there already exists a mapping
	 * that corresponds to the same varname. If no such mapping is yet constructed, it returns null.
	 * @param address
	 * @param mapping
	 * @return
	 */
	private AddressMapping getMappingForAddress(Address address,
			List<AddressMapping> mapping) {
		for(AddressMapping am: mapping){
			for(Address a: am.getAdresses()){
				if(a.getName().equals(address.getName())){
					return am;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Returns true if the given mapping does have an entry for the address to search.
	 * @param toSearch
	 * @param mapping
	 * @return
	 */
	private boolean doesContainAddress(Address toSearch, AddressMapping mapping){
		for(Address a: mapping.getAdresses()){
			if(a.equals(toSearch)){
				return true;
			}
		}
		return false;
	}

	private boolean isAddressMapped(Address address, List<AddressMapping> mapping){
		for(AddressMapping am: mapping){
			for(Address a: am.getAdresses()){
				//				if(a.getName().equals(address.getName())){
				if(a.getName().equals(address.getName())){
					//System.out.println("a-name: " + a.getName() + "address: " + address.getName());
					return true;
				}
			}
		}
		return false;
	}

	private FunctionDefinition getFunctionForCfg(ControlFlowDiagram cfg){
		EObject motherObject = cfg.getStart().getOutgoing().get(0).getInstruction().eContainer();
		BasicBlock basicBlock = (BasicBlock) motherObject;
		FunctionBody fb = (FunctionBody)basicBlock.eContainer();
		FunctionDefinition fd = (FunctionDefinition)fb.eContainer();
		return fd;
	}

	/**
	 * Returns the correct store buffer graph for the given function in the LLVM
	 * @param fd
	 * @return
	 */
	private ControlFlowDiagram getCFGForFunction(FunctionDefinition fd){
		for(ControlFlowDiagram g: cfgs){
			if(g.getName().equalsIgnoreCase(fd.getAddress().getName())){
				return g;
			}
		}

		return null;
	}


	private AddressMapping createAddressMapping(List<Address> addresses, String name){
		AddressMapping mapping = GendataFactory.eINSTANCE.createAddressMapping();
		mapping.setName(name);
		mapping.getAdresses().addAll(addresses);
		for(int i = 0; i< addresses.size(); i++){
			mapping.getOldNames().add(addresses.get(i).getName());
		}
		return mapping;
	}

	private AddressMapping createAddressMapping(Address address, String name){
		AddressMapping mapping = GendataFactory.eINSTANCE.createAddressMapping();
		mapping.setName(name);
		mapping.getAdresses().add(address);
		mapping.getOldNames().add(address.getName());
		return mapping;
	}
}
