/**
 */
package de.upb.llvm_parser.llvm.provider;

import de.upb.llvm_parser.llvm.util.LlvmAdapterFactory;

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
public class LlvmItemProviderAdapterFactory extends LlvmAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public LlvmItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.LLVM} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LLVMItemProvider llvmItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.LLVM}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLLVMAdapter() {
		if (llvmItemProvider == null) {
			llvmItemProvider = new LLVMItemProvider(this);
		}

		return llvmItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ARRAY} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ARRAYItemProvider arrayItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ARRAY}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createARRAYAdapter() {
		if (arrayItemProvider == null) {
			arrayItemProvider = new ARRAYItemProvider(this);
		}

		return arrayItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ValueStruct} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueStructItemProvider valueStructItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ValueStruct}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueStructAdapter() {
		if (valueStructItemProvider == null) {
			valueStructItemProvider = new ValueStructItemProvider(this);
		}

		return valueStructItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.AbstractElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractElementItemProvider abstractElementItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.AbstractElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAbstractElementAdapter() {
		if (abstractElementItemProvider == null) {
			abstractElementItemProvider = new AbstractElementItemProvider(this);
		}

		return abstractElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.TopLevelEntity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLevelEntityItemProvider topLevelEntityItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.TopLevelEntity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTopLevelEntityAdapter() {
		if (topLevelEntityItemProvider == null) {
			topLevelEntityItemProvider = new TopLevelEntityItemProvider(this);
		}

		return topLevelEntityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.MainLevelEntity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainLevelEntityItemProvider mainLevelEntityItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.MainLevelEntity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMainLevelEntityAdapter() {
		if (mainLevelEntityItemProvider == null) {
			mainLevelEntityItemProvider = new MainLevelEntityItemProvider(this);
		}

		return mainLevelEntityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.NamedType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedTypeItemProvider namedTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.NamedType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNamedTypeAdapter() {
		if (namedTypeItemProvider == null) {
			namedTypeItemProvider = new NamedTypeItemProvider(this);
		}

		return namedTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.CastStructure} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastStructureItemProvider castStructureItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.CastStructure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCastStructureAdapter() {
		if (castStructureItemProvider == null) {
			castStructureItemProvider = new CastStructureItemProvider(this);
		}

		return castStructureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Structure} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureItemProvider structureItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Structure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStructureAdapter() {
		if (structureItemProvider == null) {
			structureItemProvider = new StructureItemProvider(this);
		}

		return structureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.FunctionHeader} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionHeaderItemProvider functionHeaderItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.FunctionHeader}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionHeaderAdapter() {
		if (functionHeaderItemProvider == null) {
			functionHeaderItemProvider = new FunctionHeaderItemProvider(this);
		}

		return functionHeaderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ParameterList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterListItemProvider parameterListItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ParameterList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterListAdapter() {
		if (parameterListItemProvider == null) {
			parameterListItemProvider = new ParameterListItemProvider(this);
		}

		return parameterListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.TypeList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeListItemProvider typeListItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.TypeList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypeListAdapter() {
		if (typeListItemProvider == null) {
			typeListItemProvider = new TypeListItemProvider(this);
		}

		return typeListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Alias} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AliasItemProvider aliasItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Alias}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAliasAdapter() {
		if (aliasItemProvider == null) {
			aliasItemProvider = new AliasItemProvider(this);
		}

		return aliasItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.GetElementPtr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GetElementPtrItemProvider getElementPtrItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.GetElementPtr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGetElementPtrAdapter() {
		if (getElementPtrItemProvider == null) {
			getElementPtrItemProvider = new GetElementPtrItemProvider(this);
		}

		return getElementPtrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ExtractValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtractValueItemProvider extractValueItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ExtractValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExtractValueAdapter() {
		if (extractValueItemProvider == null) {
			extractValueItemProvider = new ExtractValueItemProvider(this);
		}

		return extractValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.InsertValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InsertValueItemProvider insertValueItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.InsertValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInsertValueAdapter() {
		if (insertValueItemProvider == null) {
			insertValueItemProvider = new InsertValueItemProvider(this);
		}

		return insertValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Fence} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FenceItemProvider fenceItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Fence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFenceAdapter() {
		if (fenceItemProvider == null) {
			fenceItemProvider = new FenceItemProvider(this);
		}

		return fenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.CmpXchg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CmpXchgItemProvider cmpXchgItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.CmpXchg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCmpXchgAdapter() {
		if (cmpXchgItemProvider == null) {
			cmpXchgItemProvider = new CmpXchgItemProvider(this);
		}

		return cmpXchgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.AtomicRMW} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicRMWItemProvider atomicRMWItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.AtomicRMW}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAtomicRMWAdapter() {
		if (atomicRMWItemProvider == null) {
			atomicRMWItemProvider = new AtomicRMWItemProvider(this);
		}

		return atomicRMWItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Load} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadItemProvider loadItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Load}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLoadAdapter() {
		if (loadItemProvider == null) {
			loadItemProvider = new LoadItemProvider(this);
		}

		return loadItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Store} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoreItemProvider storeItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Store}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStoreAdapter() {
		if (storeItemProvider == null) {
			storeItemProvider = new StoreItemProvider(this);
		}

		return storeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Call} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallItemProvider callItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Call}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCallAdapter() {
		if (callItemProvider == null) {
			callItemProvider = new CallItemProvider(this);
		}

		return callItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Alloc} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocItemProvider allocItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Alloc}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAllocAdapter() {
		if (allocItemProvider == null) {
			allocItemProvider = new AllocItemProvider(this);
		}

		return allocItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.PHI} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PHIItemProvider phiItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.PHI}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPHIAdapter() {
		if (phiItemProvider == null) {
			phiItemProvider = new PHIItemProvider(this);
		}

		return phiItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ValuePair} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuePairItemProvider valuePairItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ValuePair}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValuePairAdapter() {
		if (valuePairItemProvider == null) {
			valuePairItemProvider = new ValuePairItemProvider(this);
		}

		return valuePairItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.LandingPad} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LandingPadItemProvider landingPadItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.LandingPad}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLandingPadAdapter() {
		if (landingPadItemProvider == null) {
			landingPadItemProvider = new LandingPadItemProvider(this);
		}

		return landingPadItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Clause} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClauseItemProvider clauseItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Clause}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClauseAdapter() {
		if (clauseItemProvider == null) {
			clauseItemProvider = new ClauseItemProvider(this);
		}

		return clauseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Select} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectItemProvider selectItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Select}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSelectAdapter() {
		if (selectItemProvider == null) {
			selectItemProvider = new SelectItemProvider(this);
		}

		return selectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.VA_Arg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VA_ArgItemProvider vA_ArgItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.VA_Arg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVA_ArgAdapter() {
		if (vA_ArgItemProvider == null) {
			vA_ArgItemProvider = new VA_ArgItemProvider(this);
		}

		return vA_ArgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ExtractElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtractElementItemProvider extractElementItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ExtractElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExtractElementAdapter() {
		if (extractElementItemProvider == null) {
			extractElementItemProvider = new ExtractElementItemProvider(this);
		}

		return extractElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.InsertElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InsertElementItemProvider insertElementItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.InsertElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInsertElementAdapter() {
		if (insertElementItemProvider == null) {
			insertElementItemProvider = new InsertElementItemProvider(this);
		}

		return insertElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ShuffleVector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShuffleVectorItemProvider shuffleVectorItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ShuffleVector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createShuffleVectorAdapter() {
		if (shuffleVectorItemProvider == null) {
			shuffleVectorItemProvider = new ShuffleVectorItemProvider(this);
		}

		return shuffleVectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Cast} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastItemProvider castItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Cast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCastAdapter() {
		if (castItemProvider == null) {
			castItemProvider = new CastItemProvider(this);
		}

		return castItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Compare} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompareItemProvider compareItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Compare}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompareAdapter() {
		if (compareItemProvider == null) {
			compareItemProvider = new CompareItemProvider(this);
		}

		return compareItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.ARITHMETIC_OP} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ARITHMETIC_OPItemProvider arithmetiC_OPItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.ARITHMETIC_OP}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createARITHMETIC_OPAdapter() {
		if (arithmetiC_OPItemProvider == null) {
			arithmetiC_OPItemProvider = new ARITHMETIC_OPItemProvider(this);
		}

		return arithmetiC_OPItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.LOGICAL_OP} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LOGICAL_OPItemProvider logicaL_OPItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.LOGICAL_OP}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLOGICAL_OPAdapter() {
		if (logicaL_OPItemProvider == null) {
			logicaL_OPItemProvider = new LOGICAL_OPItemProvider(this);
		}

		return logicaL_OPItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Instruction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstructionItemProvider instructionItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Instruction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstructionAdapter() {
		if (instructionItemProvider == null) {
			instructionItemProvider = new InstructionItemProvider(this);
		}

		return instructionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.IndirectBranch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndirectBranchItemProvider indirectBranchItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.IndirectBranch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIndirectBranchAdapter() {
		if (indirectBranchItemProvider == null) {
			indirectBranchItemProvider = new IndirectBranchItemProvider(this);
		}

		return indirectBranchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.LabelList} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelListItemProvider labelListItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.LabelList}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLabelListAdapter() {
		if (labelListItemProvider == null) {
			labelListItemProvider = new LabelListItemProvider(this);
		}

		return labelListItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Switch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchItemProvider switchItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Switch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSwitchAdapter() {
		if (switchItemProvider == null) {
			switchItemProvider = new SwitchItemProvider(this);
		}

		return switchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.JumpTable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JumpTableItemProvider jumpTableItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.JumpTable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJumpTableAdapter() {
		if (jumpTableItemProvider == null) {
			jumpTableItemProvider = new JumpTableItemProvider(this);
		}

		return jumpTableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Invoke} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeItemProvider invokeItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Invoke}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInvokeAdapter() {
		if (invokeItemProvider == null) {
			invokeItemProvider = new InvokeItemProvider(this);
		}

		return invokeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Resume} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResumeItemProvider resumeItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Resume}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResumeAdapter() {
		if (resumeItemProvider == null) {
			resumeItemProvider = new ResumeItemProvider(this);
		}

		return resumeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Unreachable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnreachableItemProvider unreachableItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Unreachable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnreachableAdapter() {
		if (unreachableItemProvider == null) {
			unreachableItemProvider = new UnreachableItemProvider(this);
		}

		return unreachableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Return} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnItemProvider returnItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Return}.
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
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Branch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchItemProvider branchItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Branch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBranchAdapter() {
		if (branchItemProvider == null) {
			branchItemProvider = new BranchItemProvider(this);
		}

		return branchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.FunctionBody} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBodyItemProvider functionBodyItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.FunctionBody}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionBodyAdapter() {
		if (functionBodyItemProvider == null) {
			functionBodyItemProvider = new FunctionBodyItemProvider(this);
		}

		return functionBodyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.BasicBlock} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicBlockItemProvider basicBlockItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.BasicBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBasicBlockAdapter() {
		if (basicBlockItemProvider == null) {
			basicBlockItemProvider = new BasicBlockItemProvider(this);
		}

		return basicBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.upb.llvm_parser.llvm.Ret_Instr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ret_InstrItemProvider ret_InstrItemProvider;

	/**
	 * This creates an adapter for a {@link de.upb.llvm_parser.llvm.Ret_Instr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRet_InstrAdapter() {
		if (ret_InstrItemProvider == null) {
			ret_InstrItemProvider = new Ret_InstrItemProvider(this);
		}

		return ret_InstrItemProvider;
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
		if (llvmItemProvider != null) llvmItemProvider.dispose();
		if (abstractElementItemProvider != null) abstractElementItemProvider.dispose();
		if (topLevelEntityItemProvider != null) topLevelEntityItemProvider.dispose();
		if (mainLevelEntityItemProvider != null) mainLevelEntityItemProvider.dispose();
		if (namedTypeItemProvider != null) namedTypeItemProvider.dispose();
		if (castStructureItemProvider != null) castStructureItemProvider.dispose();
		if (arrayItemProvider != null) arrayItemProvider.dispose();
		if (valueStructItemProvider != null) valueStructItemProvider.dispose();
		if (structureItemProvider != null) structureItemProvider.dispose();
		if (aliasItemProvider != null) aliasItemProvider.dispose();
		if (functionHeaderItemProvider != null) functionHeaderItemProvider.dispose();
		if (parameterListItemProvider != null) parameterListItemProvider.dispose();
		if (functionBodyItemProvider != null) functionBodyItemProvider.dispose();
		if (basicBlockItemProvider != null) basicBlockItemProvider.dispose();
		if (ret_InstrItemProvider != null) ret_InstrItemProvider.dispose();
		if (typeListItemProvider != null) typeListItemProvider.dispose();
		if (instructionItemProvider != null) instructionItemProvider.dispose();
		if (getElementPtrItemProvider != null) getElementPtrItemProvider.dispose();
		if (extractValueItemProvider != null) extractValueItemProvider.dispose();
		if (insertValueItemProvider != null) insertValueItemProvider.dispose();
		if (fenceItemProvider != null) fenceItemProvider.dispose();
		if (cmpXchgItemProvider != null) cmpXchgItemProvider.dispose();
		if (atomicRMWItemProvider != null) atomicRMWItemProvider.dispose();
		if (loadItemProvider != null) loadItemProvider.dispose();
		if (storeItemProvider != null) storeItemProvider.dispose();
		if (callItemProvider != null) callItemProvider.dispose();
		if (allocItemProvider != null) allocItemProvider.dispose();
		if (phiItemProvider != null) phiItemProvider.dispose();
		if (valuePairItemProvider != null) valuePairItemProvider.dispose();
		if (landingPadItemProvider != null) landingPadItemProvider.dispose();
		if (clauseItemProvider != null) clauseItemProvider.dispose();
		if (selectItemProvider != null) selectItemProvider.dispose();
		if (vA_ArgItemProvider != null) vA_ArgItemProvider.dispose();
		if (extractElementItemProvider != null) extractElementItemProvider.dispose();
		if (insertElementItemProvider != null) insertElementItemProvider.dispose();
		if (shuffleVectorItemProvider != null) shuffleVectorItemProvider.dispose();
		if (castItemProvider != null) castItemProvider.dispose();
		if (compareItemProvider != null) compareItemProvider.dispose();
		if (arithmetiC_OPItemProvider != null) arithmetiC_OPItemProvider.dispose();
		if (logicaL_OPItemProvider != null) logicaL_OPItemProvider.dispose();
		if (indirectBranchItemProvider != null) indirectBranchItemProvider.dispose();
		if (labelListItemProvider != null) labelListItemProvider.dispose();
		if (switchItemProvider != null) switchItemProvider.dispose();
		if (jumpTableItemProvider != null) jumpTableItemProvider.dispose();
		if (invokeItemProvider != null) invokeItemProvider.dispose();
		if (resumeItemProvider != null) resumeItemProvider.dispose();
		if (unreachableItemProvider != null) unreachableItemProvider.dispose();
		if (returnItemProvider != null) returnItemProvider.dispose();
		if (branchItemProvider != null) branchItemProvider.dispose();
	}

}