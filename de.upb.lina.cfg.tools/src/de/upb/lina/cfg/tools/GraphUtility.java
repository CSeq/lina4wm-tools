package de.upb.lina.cfg.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.upb.lina.cfg.controlflow.AddressValuePair;
import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.controlflow.StoreBuffer;
import de.upb.lina.cfg.controlflow.Transition;
import de.upb.llvm_parser.llvm.BasicBlock;
import de.upb.llvm_parser.llvm.Constant;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.Instruction;
import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.PrimitiveValue;
import de.upb.llvm_parser.llvm.Value;
import de.upb.llvm_parser.llvm.impl.AddressUseImpl;

public class GraphUtility {
	
	/**
	 * Returns the given value as a String
	 * @param value to be transfored into a String
	 * @return String of the given value
	 */
	public String addValue(Value value) {
		String result = "";

		if(value instanceof AddressUseImpl){
			AddressUseImpl aui = (AddressUseImpl)value;
			result +=aui.getAddress().getName();
		}

		else if (value.eClass().equals(LlvmPackage.eINSTANCE.getConstant())) {
			Constant constant = (Constant) value;
			result += constant.getValue();
		}
		
		else if(value.eClass().equals(LlvmPackage.eINSTANCE.getPrimitiveValue())){
			PrimitiveValue val = (PrimitiveValue)value;
			result += val.getValue();
		}

		return (result);
	}
	
	/**
	 * Returns the label under which the given instruction is listed
	 * @param function function of the instruction
	 * @param instruction instruction to look for
	 * @return label of the instruction
	 */
	public String findLabelByInstruction(FunctionDefinition function, Instruction instruction){
		if(instruction == null){
			return "null";
		}
		for(BasicBlock b: function.getBody().getBlocks()){
			if(b.getInstructions().contains(instruction)){
				return b.getLabel();
			}
		}
		return "null";
	}
	
	/**
	 * Transforms a value into a String.
	 * @param value
	 * @return
	 */
	public String valueToString(Value value) {
		if (value.eClass().equals(LlvmPackage.eINSTANCE.getConstant())) {
			Constant constant = (Constant) value;
			return constant.getValue().toString();
		}

		if (value instanceof AddressUseImpl) {
			AddressUseImpl aui = (AddressUseImpl) value;
			return aui.getAddress().getName();
		}
		
		if(value.eClass().equals(LlvmPackage.eINSTANCE.getPrimitiveValue())){
			PrimitiveValue val = (PrimitiveValue)value;
			return val.getValue();
		}
		return value.toString();
	}
	
	/**
	 * Returns the transition that belongs to the instruction i in cfg
	 * @param cfg
	 * @param i
	 * @return CFG transition corresponding to instruction i
	 */
	public Transition findCorrespondingTransition(ControlFlowDiagram cfg,
			Instruction i) {
		for (Transition t : cfg.getTransitions()) {
			if (i.equals(t.getInstruction())) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Returns the first instruction that is listed under the given label
	 * @param function
	 * @param destLabel
	 * @return instruction corresponding to the label
	 */
	public Instruction getInstructionWithLabel(FunctionDefinition function,
			String destLabel) {
		for (BasicBlock b : function.getBody().getBlocks()) {
			if (destLabel.equals(b.getLabel())) {
				return b.getInstructions().get(0);
			}
		}
		throw new RuntimeException("Could not find label " + destLabel + " in function " + function.getAddress().getName());
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
	public ControlFlowLocation findLabeledLocation(ControlFlowDiagram cfg,
			FunctionDefinition function, String destLabel) {
		Instruction dest = getInstructionWithLabel(function, destLabel);
		Transition destTrans = findCorrespondingTransition(cfg, dest);
		return destTrans.getSource();
	}
	
	/**
	 * Checks weather l is equal to the given pc in combination with the given buffer
	 * 
	 * @param l
	 * @param pc
	 * @param buffer
	 * @return
	 */
	public boolean isCorrectLocation(ControlFlowLocation l, int pc, StoreBuffer buffer){
		return (getBufferAsString(l).equalsIgnoreCase(getBufferAsString(buffer, pc)));
		
//		if(l.getPc() == pc){
//			EList<AddressValuePair>pairsOfLocation = l.getBuffer().getAddressValuePairs();
//			EList<AddressValuePair>pairsOfCreatedBuffer = buffer.getAddressValuePairs();
//			if(pairsOfLocation.size() != pairsOfCreatedBuffer.size()){
//				return false;
//			}
//			for(AddressValuePair p: pairsOfCreatedBuffer){
//				for(AddressValuePair p2: pairsOfLocation){
//					Comparator<AddressValuePair> comparator = new Comparator<AddressValuePair>() {
//
//						@Override
//						public int compare(AddressValuePair o1, AddressValuePair o2) {
//							if(addValue(o1.getAddress().getValue()).compareToIgnoreCase(addValue(o2.getAddress().getValue())) != 0){
//
//								return -2;
//							}
//
//							if(addValue(o1.getValue().getValue()).compareToIgnoreCase(addValue(o2.getValue().getValue()))!= 0){
//								return 2;
//							}
//
//							return 0;
//						}
//
//						private String addValue(Value value) {
//							String result = "";
//
//							if(value instanceof AddressUseImpl){
//								AddressUseImpl aui = (AddressUseImpl)value;
//								result +=aui.getAddress().getName();
//							}
//
//							else if (value.eClass().equals(LlvmPackage.eINSTANCE.getConstant())) {
//								Constant constant = (Constant) value;
//								result += constant.getValue();
//							}
//
//							return (result);
//						}
//
//					};
//
//					if(comparator.compare(p, p2) != 0){
//						return false;
//					}
//				}
//			}
//		}else{
//			return false;
//		}
//		return true;
	}
	
	/**
	 * Returns the given ControlFlowLocation as a String
	 * 
	 * @param nextLocation
	 * @return
	 */
	public String getBufferAsString(ControlFlowLocation nextLocation){
		return getBufferAsString(nextLocation.getBuffer(), nextLocation.getPc());
	}
	
	/**
	 * Returns the given buffer and pc as a String
	 * @param buf
	 * @param pc
	 * @return
	 */
	public String getBufferAsString(StoreBuffer buf,  int pc){
		String buffer = ""+pc+"<";
		for(AddressValuePair p: buf.getAddressValuePairs()){
			buffer += "("+addValue(p.getAddress().getValue())+","+addValue(p.getValue().getValue())+")";
		}
		buffer +=">";
		return buffer;
	}
	
	/**
	 * Returns the pc of the given instruction in the given list of all instructions
	 * 
	 * @param instruction
	 * @param instructions
	 * @return
	 */
	public int getPcOfInstruction(Instruction instruction, List<Instruction> instructions){
		for(int i = 0; i<instructions.size(); i++){
			Instruction inst = instructions.get(i);
			if(inst.equals(instruction)){
				return i;
			}
		}

		return -1;
	}
	
	/**
	 * Checks wether the given location is contained in the given list
	 * @param list
	 * @param location
	 * @return true if location in list, else false
	 */
	public boolean isInList(List<ControlFlowLocation> list, ControlFlowLocation location){
		for(ControlFlowLocation loc: list){
			if(isCorrectLocation(location, loc.getPc(), loc.getBuffer())){
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks wether the given pair is in the given list
	 * @param list
	 * @param pair
	 * @return true if pair is in list, else false
	 */
	public boolean isAVPInList(List<AddressValuePair> list, AddressValuePair pair){
		Comparator<AddressValuePair> comparator = new Comparator<AddressValuePair>() {

			@Override
			public int compare(AddressValuePair o1, AddressValuePair o2) {
				if(addValue(o1.getAddress().getValue()).compareToIgnoreCase(addValue(o2.getAddress().getValue())) != 0){

					return -2;
				}

				if(addValue(o1.getValue().getValue()).compareToIgnoreCase(addValue(o2.getValue().getValue()))!= 0){
					return 2;
				}

				return 0;
			}

			private String addValue(Value value) {
				String result = "";

				if(value instanceof AddressUseImpl){
					AddressUseImpl aui = (AddressUseImpl)value;
					result +=aui.getAddress().getName();
				}

				else if (value.eClass().equals(LlvmPackage.eINSTANCE.getConstant())) {
					Constant constant = (Constant) value;
					result += constant.getValue();
				}

				return (result);
			}

		};

		for(AddressValuePair p: list){
			if(comparator.compare(p, pair) == 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retruns a list of all nodes that are adjacent to the given location
	 * @param l
	 * @return
	 */
	public ArrayList<ControlFlowLocation> getAdjacentNodes(ControlFlowLocation l){
		ArrayList<ControlFlowLocation> adjacents = new ArrayList<ControlFlowLocation>();
		for(Transition t:l.getOutgoing()){
			adjacents.add(t.getTarget());
		}
		return adjacents;
	}

	public boolean isSynch(Instruction instruction)
	{
		return (instruction.eClass().equals(LlvmPackage.eINSTANCE.getFence()) 
				|| instruction.eClass().equals(LlvmPackage.eINSTANCE.getCmpXchg())
				|| instruction.eClass().equals(LlvmPackage.eINSTANCE.getReturn()));
	}
	
	
}
