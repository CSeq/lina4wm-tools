/**
 */
package de.upb.llvm_parser.llvm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indirect Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.upb.llvm_parser.llvm.IndirectBranch#getAdress <em>Adress</em>}</li>
 *   <li>{@link de.upb.llvm_parser.llvm.IndirectBranch#getLList <em>LList</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.upb.llvm_parser.llvm.LlvmPackage#getIndirectBranch()
 * @model
 * @generated
 */
public interface IndirectBranch extends Instruction
{
  /**
   * Returns the value of the '<em><b>Adress</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adress</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adress</em>' containment reference.
   * @see #setAdress(TypeAndValue)
   * @see de.upb.llvm_parser.llvm.LlvmPackage#getIndirectBranch_Adress()
   * @model containment="true"
   * @generated
   */
  TypeAndValue getAdress();

  /**
   * Sets the value of the '{@link de.upb.llvm_parser.llvm.IndirectBranch#getAdress <em>Adress</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adress</em>' containment reference.
   * @see #getAdress()
   * @generated
   */
  void setAdress(TypeAndValue value);

  /**
   * Returns the value of the '<em><b>LList</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>LList</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>LList</em>' containment reference.
   * @see #setLList(LabelList)
   * @see de.upb.llvm_parser.llvm.LlvmPackage#getIndirectBranch_LList()
   * @model containment="true"
   * @generated
   */
  LabelList getLList();

  /**
   * Sets the value of the '{@link de.upb.llvm_parser.llvm.IndirectBranch#getLList <em>LList</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>LList</em>' containment reference.
   * @see #getLList()
   * @generated
   */
  void setLList(LabelList value);

} // IndirectBranch