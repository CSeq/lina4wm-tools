/**
 *
 * $Id$
 */
package de.upb.lina.lll.validation;

import de.upb.lina.lll.Function;
import de.upb.lina.lll.Instruction;

/**
 * A sample validator interface for {@link de.upb.lina.lll.Label}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface LabelValidator {
	boolean validate();

	boolean validateFunction(Function value);
	boolean validateInstruction(Instruction value);
}
