/**
 */
package de.upb.lina.lll.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mod</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.upb.lina.lll.expressions.Mod#getLeft <em>Left</em>}</li>
 *   <li>{@link de.upb.lina.lll.expressions.Mod#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.upb.lina.lll.expressions.ExpressionsPackage#getMod()
 * @model
 * @generated
 */
public interface Mod extends AExpression
{
  /**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(AExpression)
	 * @see de.upb.lina.lll.expressions.ExpressionsPackage#getMod_Left()
	 * @model containment="true"
	 * @generated
	 */
  AExpression getLeft();

  /**
	 * Sets the value of the '{@link de.upb.lina.lll.expressions.Mod#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
  void setLeft(AExpression value);

  /**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(AExpression)
	 * @see de.upb.lina.lll.expressions.ExpressionsPackage#getMod_Right()
	 * @model containment="true"
	 * @generated
	 */
  AExpression getRight();

  /**
	 * Sets the value of the '{@link de.upb.lina.lll.expressions.Mod#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
  void setRight(AExpression value);

} // Mod
