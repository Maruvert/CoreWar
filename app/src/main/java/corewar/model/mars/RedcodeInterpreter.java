package corewar.model.mars;

import corewar.model.mars.memory.MemoryAddress;

public class RedcodeInterpreter {
	
	public RedcodeInterpreter() {}
	
	public void execute(MemoryAddress memory, Ram ram) {
		memory.getInstruction().getOpcode().execute(memory);
	}

}
