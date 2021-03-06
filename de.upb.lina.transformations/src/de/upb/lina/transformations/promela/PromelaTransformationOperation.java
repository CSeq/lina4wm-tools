package de.upb.lina.transformations.promela;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;

import de.upb.lina.cfg.controlflow.ControlFlowDiagram;
import de.upb.lina.transformations.wizards.TransformationOperation;

public class PromelaTransformationOperation extends TransformationOperation {
	
	
	
	public PromelaTransformationOperation(List<ControlFlowDiagram> cfgs, String targetContainer, String targetName, String fileEnding) {
		super(cfgs, targetContainer, targetName, fileEnding, 1);
	}


	@Override
	protected void runSpecGeneration() throws IOException {
		GeneratePromelaModel generator;
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(targetName + fileEnding);
		generator = new GeneratePromelaModel(genData, fullPath.toFile(), args);
		generator.doGenerate(new BasicMonitor());
		
	}
	
	

}
