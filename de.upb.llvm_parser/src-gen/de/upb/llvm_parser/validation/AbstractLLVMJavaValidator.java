/*
* generated by Xtext
*/
package de.upb.llvm_parser.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

public class AbstractLLVMJavaValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(de.upb.llvm_parser.llvm.LlvmPackage.eINSTANCE);
		return result;
	}

}