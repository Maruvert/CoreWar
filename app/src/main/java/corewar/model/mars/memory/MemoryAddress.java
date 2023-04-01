package corewar.model.mars.memory;

import corewar.model.mars.RedcodeInstruction;

public class MemoryAddress {
	
	private int address;
	private RedcodeInstruction instruction;

	
	
	public MemoryAddress(int address) {}
	
	
	
	public void initialize() {
		this.instruction = new RedcodeInstruction();
	}



	
	
	
	
	public RedcodeInstruction getInstruction() {
		return instruction;
	} 

	
	
	
	
	
	
	
}
