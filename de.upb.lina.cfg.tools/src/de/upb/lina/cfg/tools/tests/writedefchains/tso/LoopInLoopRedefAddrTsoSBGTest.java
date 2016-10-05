package de.upb.lina.cfg.tools.tests.writedefchains.tso;


import java.util.Arrays;
import java.util.List;

import de.upb.lina.cfg.tools.CFGConstants;
import de.upb.lina.cfg.tools.tests.TSOStoreBufferGraphTest;


public class LoopInLoopRedefAddrTsoSBGTest extends TSOStoreBufferGraphTest {


   @Override
   protected String getTestLocation()
   {
      return "writedefchaintests/Test_loop_in_loop_redef_addr.s";
   }


   @Override
   protected int getExpectedNumberOfNodes()
   {
      return 22;
   }


   @Override
   protected int getExpectedNumberOfEdges()
   {
      return 34;
   }


   @Override
   protected int getExpectedNumberOfNodesWithNonEmptyBuffers()
   {
      return 9;
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
      return Arrays.asList("L9 <(r1" + CFGConstants.WDC_SUFFIX + ": b)>", "L10 <(r1" + CFGConstants.WDC_SUFFIX + ": b)>", "L4 <(r1"
            + CFGConstants.WDC_SUFFIX + ": b)>", "L6 <(r1" + CFGConstants.WDC_SUFFIX + ": b)>", "L5 <(r1" + CFGConstants.WDC_SUFFIX
            + ": b)>", "L7 <(r1" + CFGConstants.WDC_SUFFIX + ": b)>", "L2 <(r1" + CFGConstants.WDC_SUFFIX + ": b)>", "L11 <(r1"
            + CFGConstants.WDC_SUFFIX + ": b)>", "L3 <(r1" + CFGConstants.WDC_SUFFIX + ": b)>");
   }

}