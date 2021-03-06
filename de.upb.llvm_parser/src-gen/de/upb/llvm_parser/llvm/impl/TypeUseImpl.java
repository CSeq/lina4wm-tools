/**
 */
package de.upb.llvm_parser.llvm.impl;

import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.TypeUse;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.TypeUseImpl#getFunctionInput <em>Function Input</em>}</li>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.TypeUseImpl#getPointer <em>Pointer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeUseImpl extends MinimalEObjectImpl.Container implements TypeUse
{
  /**
   * The default value of the '{@link #getFunctionInput() <em>Function Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionInput()
   * @generated
   * @ordered
   */
  protected static final String FUNCTION_INPUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFunctionInput() <em>Function Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionInput()
   * @generated
   * @ordered
   */
  protected String functionInput = FUNCTION_INPUT_EDEFAULT;

  /**
   * The default value of the '{@link #getPointer() <em>Pointer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPointer()
   * @generated
   * @ordered
   */
  protected static final String POINTER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPointer() <em>Pointer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPointer()
   * @generated
   * @ordered
   */
  protected String pointer = POINTER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeUseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LlvmPackage.Literals.TYPE_USE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFunctionInput()
  {
    return functionInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionInput(String newFunctionInput)
  {
    String oldFunctionInput = functionInput;
    functionInput = newFunctionInput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LlvmPackage.TYPE_USE__FUNCTION_INPUT, oldFunctionInput, functionInput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPointer()
  {
    return pointer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPointer(String newPointer)
  {
    String oldPointer = pointer;
    pointer = newPointer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LlvmPackage.TYPE_USE__POINTER, oldPointer, pointer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LlvmPackage.TYPE_USE__FUNCTION_INPUT:
        return getFunctionInput();
      case LlvmPackage.TYPE_USE__POINTER:
        return getPointer();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LlvmPackage.TYPE_USE__FUNCTION_INPUT:
        setFunctionInput((String)newValue);
        return;
      case LlvmPackage.TYPE_USE__POINTER:
        setPointer((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LlvmPackage.TYPE_USE__FUNCTION_INPUT:
        setFunctionInput(FUNCTION_INPUT_EDEFAULT);
        return;
      case LlvmPackage.TYPE_USE__POINTER:
        setPointer(POINTER_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LlvmPackage.TYPE_USE__FUNCTION_INPUT:
        return FUNCTION_INPUT_EDEFAULT == null ? functionInput != null : !FUNCTION_INPUT_EDEFAULT.equals(functionInput);
      case LlvmPackage.TYPE_USE__POINTER:
        return POINTER_EDEFAULT == null ? pointer != null : !POINTER_EDEFAULT.equals(pointer);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (functionInput: ");
    result.append(functionInput);
    result.append(", pointer: ");
    result.append(pointer);
    result.append(')');
    return result.toString();
  }

} //TypeUseImpl
