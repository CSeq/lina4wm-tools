package de.upb.lina.cfg.tools.tests.tso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.tools.CFGConstants;
import de.upb.lina.cfg.tools.GraphUtility;
import de.upb.lina.cfg.tools.tests.TSO_Test;

public class RU_T_IndWR extends TSO_Test {

	@Before
	public void setUp() throws Exception {
		testLocation = "Test_Independent_Write_Read.s";
		super.setUp();
	}

	@Test
	public final void testCreateReachibilityGraph() {
		
		//check for correct amount of locations and edges
		assertEquals(diag.getLocations().size(),9);
		assertEquals(diag.getTransitions().size(),9);
		
		List<ControlFlowLocation> locs = diag.getLocations();
		
		List<ControlFlowLocation> nonEmptyBuffers  = new ArrayList<ControlFlowLocation>();
		for(ControlFlowLocation l: locs){
			if(!l.getBuffer().getAddressValuePairs().isEmpty()){
				nonEmptyBuffers.add(l);
			}
		}
		
		//check that there is only three nodes with a buffer
		assertEquals(nonEmptyBuffers.size(), 2);
		
		//check that all buffers contain the correct elements
		for(ControlFlowLocation l: nonEmptyBuffers){
			String buffer = GraphUtility.bufferToString(l, CFGConstants.TSO);
			boolean isValidBuffer = buffer.equals("L" +l.getPc()+" <(r1: b)>");
			assertTrue(isValidBuffer);
			
		}
	}

}
