package corewar.model;

public class RedcodeInterpreter {
	
	public RedcodeInterpreter() {}
	
	public void execute(MemoryAddress memory, Ram ram) {
		memory.getInstruction().getOpcode().execute(memory);
	}

}
