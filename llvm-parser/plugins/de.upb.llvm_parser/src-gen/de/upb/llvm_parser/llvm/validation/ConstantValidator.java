/**
 *
 * $Id$
 */
package de.upb.llvm_parser.llvm.validation;

import java.math.BigDecimal;

/**
 * A sample validator interface for {@link de.upb.llvm_parser.llvm.Constant}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ConstantValidator {
	boolean validate();

	boolean validateValue(BigDecimal value);
}
