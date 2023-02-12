package corewar.model;

public class RedcodeInterpreter {
	
	public RedcodeInterpreter() {}
	
	public void execute(RedcodeInstruction instruction, Ram memory) {
		instruction.getOpcode().execute(instruction.getFirstValue(), instruction.getSecondValue());
	}

}
