/**
 *
 * $Id$
 */
package de.upb.lina.lll.validation;

import de.upb.lina.lll.PrimitiveType;

/**
 * A sample validator interface for {@link de.upb.lina.lll.SimpleType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SimpleTypeValidator {
	boolean validate();

	boolean validateType(PrimitiveType value);
}
