/**
 * 
 */
package de.upb.lina.cfg.controlflow.diagram.edit.parts;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import de.upb.lina.cfg.controlflow.ControlFlowLocation;
import de.upb.lina.cfg.tools.GraphUtility;

/**
 * @author Oleg Travkin, Alexander Hetzer
 *
 */
public class CustomControlFlowLocationPcEditPart extends ControlFlowLocationPcEditPart
{
	
	private View view;

	/**
	 * @param view
	 */
	public CustomControlFlowLocationPcEditPart(View view)
	{
		super(view);
		this.view = view;	
	}
	
	public void setLabel(WrappingLabel figure)
	{
		super.setLabel(figure);
	}
	

	@Override
	protected String getLabelText()
	{
		ControlFlowLocation loc = (ControlFlowLocation) view.getElement();
		return GraphUtility.bufferToString(loc, loc.getDiagram().getMemoryModel());
	}
}
