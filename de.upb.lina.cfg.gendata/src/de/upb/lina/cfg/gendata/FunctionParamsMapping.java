/**
 */
package de.upb.lina.cfg.gendata;

import de.upb.lina.cfg.controlflow.ControlFlowDiagram;

import de.upb.llvm_parser.llvm.FunctionDefinition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Params Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.upb.lina.cfg.gendata.FunctionParamsMapping#getFunction <em>Function</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.FunctionParamsMapping#getCfg <em>Cfg</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.FunctionParamsMapping#isNeedsReturnValue <em>Needs Return Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.upb.lina.cfg.gendata.GendataPackage#getFunctionParamsMapping()
 * @model
 * @generated
 */
public interface FunctionParamsMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(FunctionDefinition)
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getFunctionParamsMapping_Function()
	 * @model
	 * @generated
	 */
	FunctionDefinition getFunction();

	/**
	 * Sets the value of the '{@link de.upb.lina.cfg.gendata.FunctionParamsMapping#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionDefinition value);

	/**
	 * Returns the value of the '<em><b>Cfg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cfg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cfg</em>' reference.
	 * @see #setCfg(ControlFlowDiagram)
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getFunctionParamsMapping_Cfg()
	 * @model
	 * @generated
	 */
	ControlFlowDiagram getCfg();

	/**
	 * Sets the value of the '{@link de.upb.lina.cfg.gendata.FunctionParamsMapping#getCfg <em>Cfg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cfg</em>' reference.
	 * @see #getCfg()
	 * @generated
	 */
	void setCfg(ControlFlowDiagram value);

	/**
	 * Returns the value of the '<em><b>Needs Return Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs Return Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs Return Value</em>' attribute.
	 * @see #setNeedsReturnValue(boolean)
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getFunctionParamsMapping_NeedsReturnValue()
	 * @model
	 * @generated
	 */
	boolean isNeedsReturnValue();

	/**
	 * Sets the value of the '{@link de.upb.lina.cfg.gendata.FunctionParamsMapping#isNeedsReturnValue <em>Needs Return Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs Return Value</em>' attribute.
	 * @see #isNeedsReturnValue()
	 * @generated
	 */
	void setNeedsReturnValue(boolean value);

} // FunctionParamsMapping
