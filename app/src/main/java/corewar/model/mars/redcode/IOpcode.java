package corewar.model.mars.redcode;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.Ram;
import corewar.model.mars.RedcodeInstruction;
import corewar.model.mars.memory.MemoryAddress;

public interface IOpcode {
	
	public int execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	
	public boolean isLegal(RedcodeInstruction instruction);
	
	
	public IOpcode getDat();

}
