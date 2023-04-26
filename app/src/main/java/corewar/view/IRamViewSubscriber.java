package corewar.view;

import corewar.model.mars.OperationType;

public interface IRamViewSubscriber {

	public void update(OperationType type, int address, int warriorNumber);
	
}
