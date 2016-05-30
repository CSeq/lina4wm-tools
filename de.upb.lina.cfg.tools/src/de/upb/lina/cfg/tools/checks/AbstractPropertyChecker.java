package de.upb.lina.cfg.tools.checks;


import java.util.ArrayList;
import java.util.List;

import de.upb.lina.cfg.tools.EMemoryModel;
import de.upb.llvm_parser.llvm.LLVM;


public abstract class AbstractPropertyChecker {

   private int numberOfMessages = 0;

   private List<String> messages;

   private List<EMemoryModel> memoryModelsToPerformChecksFor;

   protected boolean isPropetyFulfilled;
   protected int errorLevel;

   protected LLVM ast;


   public AbstractPropertyChecker(LLVM ast) {
      this.messages = new ArrayList<String>();
      this.memoryModelsToPerformChecksFor = new ArrayList<EMemoryModel>();

      this.isPropetyFulfilled = false;

      this.ast = ast;


      setErrorLevel();
      setSemanticsToPerformChecksFor();

   }


   public List<String> getMessages() {
      return messages;
   }


   public boolean isPropertyFulfilled() {
      return isPropetyFulfilled;
   }


   public int getLevel() {
      return errorLevel;
   }


   protected void addMessage(String m) {
      numberOfMessages++;
      m = numberOfMessages + ". " + m;
      for (String message : splitMessage(m)) {
         messages.add(message);
      }

   }


   public List<String> splitMessage(String m) {
      List<String> resultMessage = new ArrayList<String>();
      if (m.length() > 20) {
         String result = "";
         String[] splittedM = m.split(" ");
         int size = 0;
         for (int i = 0; i < splittedM.length; i++) {
            if (size > 70) {
               resultMessage.add(result);
               result = "";
               size = 0;
            }
            result += " " + splittedM[i];
            size += splittedM[i].length();
         }
         if (!resultMessage.contains(result)) {
            resultMessage.add(result);
         }
      } else {
         resultMessage.add(m);
      }
      return resultMessage;
   }


   public abstract boolean check();


   protected abstract void setErrorLevel();


   /**
    * Checks if this property checker should perform its checks for the given semantic.
    * 
    * @param memoryModel memory model to check for
    * @return true, if this checker should perform checks for the given semantic, false if not
    */
   public boolean shouldPerformChecksForSemantic(EMemoryModel memoryModel) {
      return memoryModelsToPerformChecksFor.contains(memoryModel);
   }


   /**
    * Adds the given memory model to the list of memory models to perform checks for.
    * 
    * @param memoryModelToAdd memory model to add to the list of memory models to perform checks for
    */
   protected void addSemanticToPerformChecksFor(EMemoryModel memoryModelToAdd) {
      memoryModelsToPerformChecksFor.add(memoryModelToAdd);
   }


   /**
    * Each checker should call the
    * {@link AbstractPropertyChecker#addSemanticToPerformChecksFor(int)} for each of the semantics
    * it should perform checks for in this method.
    */
   protected abstract void setSemanticsToPerformChecksFor();

}
