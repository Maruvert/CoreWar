package corewar.model.redcode;

import corewar.model.MemoryAddress;

public interface IOpcode {
	
	public void execute(MemoryAddress memory);
	
	
	public IOpcode getDat();

}
