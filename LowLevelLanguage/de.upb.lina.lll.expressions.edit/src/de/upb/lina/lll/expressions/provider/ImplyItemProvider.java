/**
 */
package de.upb.lina.lll.expressions.provider;


import de.upb.lina.lll.expressions.ExpressionsFactory;
import de.upb.lina.lll.expressions.ExpressionsPackage;
import de.upb.lina.lll.expressions.Imply;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.upb.lina.lll.expressions.Imply} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ImplyItemProvider
	extends LExpressionItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ExpressionsPackage.Literals.IMPLY__LEFT);
			childrenFeatures.add(ExpressionsPackage.Literals.IMPLY__RIGHT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Imply.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Imply"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Imply_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Imply.class)) {
			case ExpressionsPackage.IMPLY__LEFT:
			case ExpressionsPackage.IMPLY__RIGHT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createLExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createCExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createSomeValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createAExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createNumberValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createBooleanValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createStringValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createEquivalent()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createImply()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createLessOrEqual()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createGreaterOrEqual()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createUnequal()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createApprox()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createMulti()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__LEFT,
				 ExpressionsFactory.eINSTANCE.createPow()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createLExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createCExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createSomeValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createAExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createNumberValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createBooleanValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createStringValue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createEquivalent()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createImply()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createLessOrEqual()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createGreaterOrEqual()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createUnequal()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createApprox()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createMulti()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.IMPLY__RIGHT,
				 ExpressionsFactory.eINSTANCE.createPow()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ExpressionsPackage.Literals.IMPLY__LEFT ||
			childFeature == ExpressionsPackage.Literals.IMPLY__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}