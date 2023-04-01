package corewar.model.mars.redcode;

import corewar.model.mars.memory.MemoryAddress;

public interface IOpcode {
	
	public void execute(MemoryAddress memory);
	
	
	public IOpcode getDat();

}
