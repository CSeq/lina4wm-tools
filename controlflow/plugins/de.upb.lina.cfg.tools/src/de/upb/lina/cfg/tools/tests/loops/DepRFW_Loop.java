package de.upb.lina.cfg.tools.tests.loops;

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

public class DepRFW_Loop extends TSO_Test {
	@Before
	public void setUp() throws Exception {
		astLoc = "testdata/loops/Test_Dependent_Read_Fence_Write_Loop.s.llvm";
		super.setUp();
	}

	@Test
	public final void testCreateReachibilityGraph() {
		TSOUtil util = new TSOUtil();

		ControlFlowDiagram diag = util.createReachibilityGraph((FunctionDefinition) ast.getElements().get(0));
		
		//check for correct amount of locations and edges
		assertEquals(diag.getLocations().size(),14);
		assertEquals(diag.getTransitions().size(),18);
		
		List<ControlFlowLocation> locs = diag.getLocations();
		
		List<ControlFlowLocation> nonEmptyBuffers  = new ArrayList<ControlFlowLocation>();
		for(ControlFlowLocation l: locs){
			if(!l.getBuffer().getAddressValuePairs().isEmpty()){
				nonEmptyBuffers.add(l);
			}
		}
		
		//check that there is only three nodes with a buffer
		assertEquals(nonEmptyBuffers.size(), 5);
		
		//check that all buffers contain the correct elements
		for(ControlFlowLocation l: nonEmptyBuffers){
			String buffer = gUtil.getBufferAsString(l);
			boolean isValidBuffer = buffer.equals(l.getPc()+"<(%0,%r1)>");
			assertTrue(isValidBuffer);	
		}
		
	}
}