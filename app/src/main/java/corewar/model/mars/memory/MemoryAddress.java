package corewar.model.mars.memory;

import corewar.model.exceptions.NotAValueException;
import corewar.model.mars.RedcodeInstruction;

public class MemoryAddress {
	
	private int address;
	private RedcodeInstruction instruction;

	
	
	public MemoryAddress(int address) {
		this.instruction = null;
	}
	
	
	
	public void initialize() {
		this.instruction = new RedcodeInstruction();
	}
	
	
	
	public void setInstruction(RedcodeInstruction instruction) {
		this.instruction = instruction;
	}


	public int getAddress() {
		return address;
	}



	public RedcodeInstruction getInstruction() {
		return instruction;
	} 
	
	
	
	
	public int getValue() throws NotAValueException {
		if (!this.instruction.getOpcode().equals(instruction.getOpcode().getDat())) {
			throw new NotAValueException("This address is not a value (DAT)");
		}
		return this.instruction.getBfield().getValue();
	}

	
	
	
	
	
	
	
}
