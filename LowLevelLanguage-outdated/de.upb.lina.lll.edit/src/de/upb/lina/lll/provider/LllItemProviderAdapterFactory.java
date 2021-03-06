/**
 */
package de.upb.lina.lll.provider;

import de.upb.lina.lll.util.LllAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LllItemProviderAdapterFactory extends LllAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LllItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Program} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramItemProvider programItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Program}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProgramAdapter() {
		if (programItemProvider == null) {
			programItemProvider = new ProgramItemProvider(this);
		}

		return programItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Function} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionItemProvider functionItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionAdapter() {
		if (functionItemProvider == null) {
			functionItemProvider = new FunctionItemProvider(this);
		}

		return functionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Label} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelItemProvider labelItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Label}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLabelAdapter() {
		if (labelItemProvider == null) {
			labelItemProvider = new LabelItemProvider(this);
		}

		return labelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.FunctionCall} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionCallItemProvider functionCallItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.FunctionCall}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionCallAdapter() {
		if (functionCallItemProvider == null) {
			functionCallItemProvider = new FunctionCallItemProvider(this);
		}

		return functionCallItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.ConditionalBranch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalBranchItemProvider conditionalBranchItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.ConditionalBranch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConditionalBranchAdapter() {
		if (conditionalBranchItemProvider == null) {
			conditionalBranchItemProvider = new ConditionalBranchItemProvider(this);
		}

		return conditionalBranchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Goto} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GotoItemProvider gotoItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Goto}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGotoAdapter() {
		if (gotoItemProvider == null) {
			gotoItemProvider = new GotoItemProvider(this);
		}

		return gotoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Constant} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantItemProvider constantItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Constant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstantAdapter() {
		if (constantItemProvider == null) {
			constantItemProvider = new ConstantItemProvider(this);
		}

		return constantItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Variable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableItemProvider variableItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVariableAdapter() {
		if (variableItemProvider == null) {
			variableItemProvider = new VariableItemProvider(this);
		}

		return variableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.SimpleType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleTypeItemProvider simpleTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.SimpleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSimpleTypeAdapter() {
		if (simpleTypeItemProvider == null) {
			simpleTypeItemProvider = new SimpleTypeItemProvider(this);
		}

		return simpleTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.ComplexType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexTypeItemProvider complexTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.ComplexType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComplexTypeAdapter() {
		if (complexTypeItemProvider == null) {
			complexTypeItemProvider = new ComplexTypeItemProvider(this);
		}

		return complexTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.LocalComputation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalComputationItemProvider localComputationItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.LocalComputation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLocalComputationAdapter() {
		if (localComputationItemProvider == null) {
			localComputationItemProvider = new LocalComputationItemProvider(this);
		}

		return localComputationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.MemoryInstruction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryInstructionItemProvider memoryInstructionItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.MemoryInstruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMemoryInstructionAdapter() {
		if (memoryInstructionItemProvider == null) {
			memoryInstructionItemProvider = new MemoryInstructionItemProvider(this);
		}

		return memoryInstructionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.lina.lll.Return} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnItemProvider returnItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.lina.lll.Return}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReturnAdapter() {
		if (returnItemProvider == null) {
			returnItemProvider = new ReturnItemProvider(this);
		}

		return returnItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (programItemProvider != null) programItemProvider.dispose();
		if (functionItemProvider != null) functionItemProvider.dispose();
		if (labelItemProvider != null) labelItemProvider.dispose();
		if (functionCallItemProvider != null) functionCallItemProvider.dispose();
		if (conditionalBranchItemProvider != null) conditionalBranchItemProvider.dispose();
		if (gotoItemProvider != null) gotoItemProvider.dispose();
		if (constantItemProvider != null) constantItemProvider.dispose();
		if (variableItemProvider != null) variableItemProvider.dispose();
		if (simpleTypeItemProvider != null) simpleTypeItemProvider.dispose();
		if (complexTypeItemProvider != null) complexTypeItemProvider.dispose();
		if (localComputationItemProvider != null) localComputationItemProvider.dispose();
		if (memoryInstructionItemProvider != null) memoryInstructionItemProvider.dispose();
		if (returnItemProvider != null) returnItemProvider.dispose();
	}

}
