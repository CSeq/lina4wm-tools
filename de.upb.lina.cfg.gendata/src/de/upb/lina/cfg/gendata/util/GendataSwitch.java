/**
 */
package de.upb.lina.cfg.gendata.util;

import de.upb.lina.cfg.gendata.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.upb.lina.cfg.gendata.GendataPackage
 * @generated
 */
public class GendataSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GendataPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GendataSwitch()
	{
		if (modelPackage == null) {
			modelPackage = GendataPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID) {
			case GendataPackage.LOCAL_VARIABLES: {
				LocalVariables localVariables = (LocalVariables)theEObject;
				T result = caseLocalVariables(localVariables);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.GENERATOR_DATA: {
				GeneratorData generatorData = (GeneratorData)theEObject;
				T result = caseGeneratorData(generatorData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.ADDRESS_MAPPING: {
				AddressMapping addressMapping = (AddressMapping)theEObject;
				T result = caseAddressMapping(addressMapping);
				if (result == null) result = caseNamedElement(addressMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.CONSTRAINT_MAPPING: {
				ConstraintMapping constraintMapping = (ConstraintMapping)theEObject;
				T result = caseConstraintMapping(constraintMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.FUNCTION_PARAMS_MAPPING: {
				FunctionParamsMapping functionParamsMapping = (FunctionParamsMapping)theEObject;
				T result = caseFunctionParamsMapping(functionParamsMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.LOCATION_LABEL: {
				LocationLabel locationLabel = (LocationLabel)theEObject;
				T result = caseLocationLabel(locationLabel);
				if (result == null) result = caseNamedElement(locationLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.TRANSITION_LABEL: {
				TransitionLabel transitionLabel = (TransitionLabel)theEObject;
				T result = caseTransitionLabel(transitionLabel);
				if (result == null) result = caseNamedElement(transitionLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GendataPackage.PHI_MAPPING: {
				PhiMapping phiMapping = (PhiMapping)theEObject;
				T result = casePhiMapping(phiMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variables</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variables</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariables(LocalVariables object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratorData(GeneratorData object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressMapping(AddressMapping object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintMapping(ConstraintMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Params Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Params Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionParamsMapping(FunctionParamsMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Location Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Location Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocationLabel(LocationLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionLabel(TransitionLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Phi Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phi Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhiMapping(PhiMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //GendataSwitch
