package de.upb.lina.cfg.controlflow.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import de.upb.lina.cfg.controlflow.diagram.part.ControlFlowVisualIDRegistry;

/**
 * @generated
 */
public class ControlFlowEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ControlFlowVisualIDRegistry.getVisualID(view)) {

			case ControlFlowDiagramEditPart.VISUAL_ID:
				return new ControlFlowDiagramEditPart(view);

			case ControlFlowLocationEditPart.VISUAL_ID:
				return new ControlFlowLocationEditPart(view);

			case ControlFlowLocationPcEditPart.VISUAL_ID:
				return new ControlFlowLocationPcEditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
