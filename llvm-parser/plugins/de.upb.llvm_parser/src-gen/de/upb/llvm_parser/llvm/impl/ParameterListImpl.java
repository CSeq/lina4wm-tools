/**
 */
package de.upb.llvm_parser.llvm.impl;

import de.upb.llvm_parser.llvm.Instruction;
import de.upb.llvm_parser.llvm.LlvmPackage;
import de.upb.llvm_parser.llvm.ParameterList;
import de.upb.llvm_parser.llvm.TypeList;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.ParameterListImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.ParameterListImpl#getLists <em>Lists</em>}</li>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.ParameterListImpl#getAlignname <em>Alignname</em>}</li>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.ParameterListImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link de.upb.llvm_parser.llvm.impl.ParameterListImpl#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterListImpl extends MinimalEObjectImpl.Container implements ParameterList {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> types;

	/**
	 * The cached value of the '{@link #getLists() <em>Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLists()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeList> lists;

	/**
	 * The cached value of the '{@link #getAlignname() <em>Alignname</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlignname()
	 * @generated
	 * @ordered
	 */
	protected EList<String> alignname;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> variables;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected EList<Instruction> op;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LlvmPackage.Literals.PARAMETER_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTypes() {
		if (types == null) {
			types = new EDataTypeEList<String>(String.class, this, LlvmPackage.PARAMETER_LIST__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeList> getLists() {
		if (lists == null) {
			lists = new EObjectContainmentEList<TypeList>(TypeList.class, this, LlvmPackage.PARAMETER_LIST__LISTS);
		}
		return lists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAlignname() {
		if (alignname == null) {
			alignname = new EDataTypeEList<String>(String.class, this, LlvmPackage.PARAMETER_LIST__ALIGNNAME);
		}
		return alignname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVariables() {
		if (variables == null) {
			variables = new EDataTypeEList<String>(String.class, this, LlvmPackage.PARAMETER_LIST__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instruction> getOp() {
		if (op == null) {
			op = new EObjectContainmentEList<Instruction>(Instruction.class, this, LlvmPackage.PARAMETER_LIST__OP);
		}
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LlvmPackage.PARAMETER_LIST__LISTS:
				return ((InternalEList<?>)getLists()).basicRemove(otherEnd, msgs);
			case LlvmPackage.PARAMETER_LIST__OP:
				return ((InternalEList<?>)getOp()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LlvmPackage.PARAMETER_LIST__TYPES:
				return getTypes();
			case LlvmPackage.PARAMETER_LIST__LISTS:
				return getLists();
			case LlvmPackage.PARAMETER_LIST__ALIGNNAME:
				return getAlignname();
			case LlvmPackage.PARAMETER_LIST__VARIABLES:
				return getVariables();
			case LlvmPackage.PARAMETER_LIST__OP:
				return getOp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LlvmPackage.PARAMETER_LIST__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends String>)newValue);
				return;
			case LlvmPackage.PARAMETER_LIST__LISTS:
				getLists().clear();
				getLists().addAll((Collection<? extends TypeList>)newValue);
				return;
			case LlvmPackage.PARAMETER_LIST__ALIGNNAME:
				getAlignname().clear();
				getAlignname().addAll((Collection<? extends String>)newValue);
				return;
			case LlvmPackage.PARAMETER_LIST__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends String>)newValue);
				return;
			case LlvmPackage.PARAMETER_LIST__OP:
				getOp().clear();
				getOp().addAll((Collection<? extends Instruction>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case LlvmPackage.PARAMETER_LIST__TYPES:
				getTypes().clear();
				return;
			case LlvmPackage.PARAMETER_LIST__LISTS:
				getLists().clear();
				return;
			case LlvmPackage.PARAMETER_LIST__ALIGNNAME:
				getAlignname().clear();
				return;
			case LlvmPackage.PARAMETER_LIST__VARIABLES:
				getVariables().clear();
				return;
			case LlvmPackage.PARAMETER_LIST__OP:
				getOp().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LlvmPackage.PARAMETER_LIST__TYPES:
				return types != null && !types.isEmpty();
			case LlvmPackage.PARAMETER_LIST__LISTS:
				return lists != null && !lists.isEmpty();
			case LlvmPackage.PARAMETER_LIST__ALIGNNAME:
				return alignname != null && !alignname.isEmpty();
			case LlvmPackage.PARAMETER_LIST__VARIABLES:
				return variables != null && !variables.isEmpty();
			case LlvmPackage.PARAMETER_LIST__OP:
				return op != null && !op.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (types: ");
		result.append(types);
		result.append(", alignname: ");
		result.append(alignname);
		result.append(", variables: ");
		result.append(variables);
		result.append(')');
		return result.toString();
	}

} //ParameterListImpl
