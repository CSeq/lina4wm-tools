package de.upb.lina.cfg.tools.tests.reverseLS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.controlflow.ControlflowPackage;
import de.upb.lina.cfg.controlflow.Transition;
import de.upb.lina.cfg.tools.TSOUtil;
import de.upb.lina.cfg.tools.tests.TSO_Test;
import de.upb.llvm_parser.llvm.FunctionDefinition;
import de.upb.llvm_parser.llvm.LlvmPackage;

public class Independent_Write_Read_1_1_rev extends TSO_Test {
	@Before
	public void setUp() throws Exception {
		astLoc = "testdata/reverseLS/Test_Independent_Write_Read_1_1_rev.s.llvm";
		super.setUp();
	}

	@Test
	public final void testCreateReachibilityGraph() {
		TSOUtil util = new TSOUtil();

		ControlFlowDiagram diag = util.createReachibilityGraph((FunctionDefinition) ast.getElements().get(0));

		//check for correct amount of locations and edges
		assertEquals(diag.getLocations().size(),11);
		assertEquals(diag.getTransitions().size(),11);

		List<ControlFlowLocation> locs = diag.getLocations();

		List<ControlFlowLocation> nonEmptyBuffers  = new ArrayList<ControlFlowLocation>();
		Transition fenceTransition = null;

		for(ControlFlowLocation l: locs){
			if(!l.getBuffer().getAddressValuePairs().isEmpty()){
				nonEmptyBuffers.add(l);
			}
			//Find our fence
			for(Transition t: l.getOutgoing()){
				if(!t.eClass().equals(ControlflowPackage.eINSTANCE.getFlushTransition())){
					if(t.getInstruction().eClass().equals(LlvmPackage.eINSTANCE.getFence())){
						fenceTransition = t;
					}
				}
			}
		}

		//check that there is only two nodes with a buffer
		assertEquals(nonEmptyBuffers.size(), 2);

		//check that all buffers contain the correct elements
		for(ControlFlowLocation l: nonEmptyBuffers){
			String buffer = gUtil.getBufferAsString(l);
			boolean isValidBuffer = buffer.equals(l.getPc()+"<(%b,null)>");
			assertTrue(isValidBuffer);

		}

		//Check weather we synch before the fence
		if(fenceTransition != null){
			for(ControlFlowLocation l: diag.getLocations()){
				if(l.getPc() > fenceTransition.getSource().getPc() || l.getIncoming().contains(fenceTransition)){
					assertTrue(l.getBuffer().getAddressValuePairs().isEmpty());
				}
			}
		}else{
			fail("No fence in this test.");
		}
	}
}
