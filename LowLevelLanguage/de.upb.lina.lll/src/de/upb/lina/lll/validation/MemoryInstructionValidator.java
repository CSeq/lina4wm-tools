/**
 *
 * $Id$
 */
package de.upb.lina.lll.validation;

import de.upb.lina.lll.MemoryInstructionType;

/**
 * A sample validator interface for {@link de.upb.lina.lll.MemoryInstruction}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MemoryInstructionValidator {
	boolean validate();

	boolean validateInstructionType(MemoryInstructionType value);
}