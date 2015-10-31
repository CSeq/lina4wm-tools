/**
 */
package de.upb.lina.cfg.gendata;

import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.llvm_parser.llvm.LLVM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getProgram <em>Program</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getCfgs <em>Cfgs</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getLocationLabels <em>Location Labels</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getTransitionLabels <em>Transition Labels</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getTransformationSpecificKeys <em>Transformation Specific Keys</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getPhiMappings <em>Phi Mappings</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getFilteredAddresses <em>Filtered Addresses</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getAddressMappings <em>Address Mappings</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getMemorySizeMappings <em>Memory Size Mappings</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getInputTypes <em>Input Types</em>}</li>
 *   <li>{@link de.upb.lina.cfg.gendata.GeneratorData#getOldToNewCfgName <em>Old To New Cfg Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData()
 * @model
 * @generated
 */
public interface GeneratorData extends EObject
{
	/**
	 * Returns the value of the '<em><b>Program</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Program</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Program</em>' reference.
	 * @see #setProgram(LLVM)
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_Program()
	 * @model
	 * @generated
	 */
	LLVM getProgram();

	/**
	 * Sets the value of the '{@link de.upb.lina.cfg.gendata.GeneratorData#getProgram <em>Program</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Program</em>' reference.
	 * @see #getProgram()
	 * @generated
	 */
	void setProgram(LLVM value);

	/**
	 * Returns the value of the '<em><b>Cfgs</b></em>' reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.controlflow.ControlFlowDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cfgs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cfgs</em>' reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_Cfgs()
	 * @model required="true"
	 * @generated
	 */
	EList<ControlFlowDiagram> getCfgs();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.ConstraintMapping}.
	 * It is bidirectional and its opposite is '{@link de.upb.lina.cfg.gendata.ConstraintMapping#getGeneratorData <em>Generator Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_Constraints()
	 * @see de.upb.lina.cfg.gendata.ConstraintMapping#getGeneratorData
	 * @model opposite="generatorData" containment="true"
	 * @generated
	 */
	EList<ConstraintMapping> getConstraints();

	/**
	 * Returns the value of the '<em><b>Location Labels</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.LocationLabel}.
	 * It is bidirectional and its opposite is '{@link de.upb.lina.cfg.gendata.LocationLabel#getGeneratorData <em>Generator Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location Labels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Labels</em>' containment reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_LocationLabels()
	 * @see de.upb.lina.cfg.gendata.LocationLabel#getGeneratorData
	 * @model opposite="generatorData" containment="true"
	 * @generated
	 */
	EList<LocationLabel> getLocationLabels();

	/**
	 * Returns the value of the '<em><b>Transition Labels</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.TransitionLabel}.
	 * It is bidirectional and its opposite is '{@link de.upb.lina.cfg.gendata.TransitionLabel#getGeneratorData <em>Generator Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Labels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Labels</em>' containment reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_TransitionLabels()
	 * @see de.upb.lina.cfg.gendata.TransitionLabel#getGeneratorData
	 * @model opposite="generatorData" containment="true"
	 * @generated
	 */
	EList<TransitionLabel> getTransitionLabels();

	/**
	 * Returns the value of the '<em><b>Transformation Specific Keys</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Specific Keys</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Specific Keys</em>' attribute list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_TransformationSpecificKeys()
	 * @model default=""
	 * @generated
	 */
	EList<String> getTransformationSpecificKeys();

	/**
	 * Returns the value of the '<em><b>Phi Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.PhiMapping}.
	 * It is bidirectional and its opposite is '{@link de.upb.lina.cfg.gendata.PhiMapping#getGeneratorData <em>Generator Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phi Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phi Mappings</em>' containment reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_PhiMappings()
	 * @see de.upb.lina.cfg.gendata.PhiMapping#getGeneratorData
	 * @model opposite="generatorData" containment="true"
	 * @generated
	 */
	EList<PhiMapping> getPhiMappings();

	/**
	 * Returns the value of the '<em><b>Filtered Addresses</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type list of {@link de.upb.lina.cfg.gendata.AddressMapping},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtered Addresses</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtered Addresses</em>' map.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_FilteredAddresses()
	 * @model mapType="de.upb.lina.cfg.gendata.FilterToAddressMapping<org.eclipse.emf.ecore.EString, de.upb.lina.cfg.gendata.AddressMapping>"
	 * @generated
	 */
	EMap<String, EList<AddressMapping>> getFilteredAddresses();

	/**
	 * Returns the value of the '<em><b>Address Mappings</b></em>' reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.AddressMapping}.
	 * It is bidirectional and its opposite is '{@link de.upb.lina.cfg.gendata.AddressMapping#getGeneratorData <em>Generator Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address Mappings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address Mappings</em>' reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_AddressMappings()
	 * @see de.upb.lina.cfg.gendata.AddressMapping#getGeneratorData
	 * @model opposite="generatorData"
	 * @generated
	 */
	EList<AddressMapping> getAddressMappings();

	/**
	 * Returns the value of the '<em><b>Memory Size Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.MemorySizeMapping}.
	 * It is bidirectional and its opposite is '{@link de.upb.lina.cfg.gendata.MemorySizeMapping#getGeneratorData <em>Generator Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Size Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Size Mappings</em>' containment reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_MemorySizeMappings()
	 * @see de.upb.lina.cfg.gendata.MemorySizeMapping#getGeneratorData
	 * @model opposite="generatorData" containment="true"
	 * @generated
	 */
	EList<MemorySizeMapping> getMemorySizeMappings();

	/**
	 * Returns the value of the '<em><b>Input Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.upb.lina.cfg.gendata.InputTypeList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Types</em>' containment reference list.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_InputTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputTypeList> getInputTypes();

	/**
	 * Returns the value of the '<em><b>Old To New Cfg Name</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old To New Cfg Name</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old To New Cfg Name</em>' map.
	 * @see de.upb.lina.cfg.gendata.GendataPackage#getGeneratorData_OldToNewCfgName()
	 * @model mapType="de.upb.lina.cfg.gendata.oldToNewCfgNameMapping<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getOldToNewCfgName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<AddressMapping> getFilteredAddresses(String key);

} // GeneratorData
