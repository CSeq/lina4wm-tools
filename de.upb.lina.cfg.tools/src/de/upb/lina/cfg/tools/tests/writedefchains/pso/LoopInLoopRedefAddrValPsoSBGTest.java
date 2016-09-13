package de.upb.lina.cfg.tools.tests.writedefchains.pso;


import java.util.Arrays;
import java.util.List;

import de.upb.lina.cfg.tools.CFGConstants;
import de.upb.lina.cfg.tools.tests.PSOStoreBufferGraphTest;


public class LoopInLoopRedefAddrValPsoSBGTest extends PSOStoreBufferGraphTest {


   @Override
   protected String getTestLocation()
   {
      return "writedefchaintests/Test_loop_in_loop_redef_addr+val.s";
   }


   @Override
   protected int getExpectedNumberOfNodes()
   {
      return 23;
   }


   @Override
   protected int getExpectedNumberOfEdges()
   {
      return 36;
   }


   @Override
   protected int getExpectedNumberOfNodesWithNonEmptyBuffers()
   {
      return 10;
   }


   @Override
   protected int getExpectedNumberOfEarlyReadEdges()
   {
      return 0;
   }


   @Override
   protected int getExpectedNumberOfWriteDefChainEdges()
   {
      return 1;
   }


   @Override
   protected List<String> getExpectedStoreBufferStringRepresentations()
   {
      return Arrays.asList("L9 <(r1" + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>", "L10 <(r1"
            + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>", "L4 <(r1" + CFGConstants.WDC_SUFFIX + ": b"
            + CFGConstants.WDC_SUFFIX + ")>", "L7 <(r1" + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>", "L5 <(r1"
            + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>", "L6 <(r1" + CFGConstants.WDC_SUFFIX + ": b"
            + CFGConstants.WDC_SUFFIX + ")>", "L1 <(r1" + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>", "L11 <(r1"
            + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>", "L2 <(r1" + CFGConstants.WDC_SUFFIX + ": b"
            + CFGConstants.WDC_SUFFIX + ")>", "L3 <(r1" + CFGConstants.WDC_SUFFIX + ": b" + CFGConstants.WDC_SUFFIX + ")>");
   }

}
