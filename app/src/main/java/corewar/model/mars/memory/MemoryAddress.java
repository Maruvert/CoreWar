package corewar.model.mars.memory;

import corewar.model.exceptions.NotAValueException;
import corewar.model.mars.RedcodeInstruction;
import corewar.model.mars.redcode.Opcode;


public class MemoryAddress {
	
	/**
	 * The memory slot address
	 */
	private int address;
	
	
	/**
	 * The instruction in the memory slot
	 */
	private RedcodeInstruction instruction;

	
	
	public MemoryAddress(int address) {
		this.address = address;
		this.instruction = null;
	}
	
	
	/**
	 * Fill the address with a DAT #0 #0 instruction
	 */
	public void initialize() {
		this.instruction = new RedcodeInstruction();
	}
	
	
	/**
	 * 
	 * @param instruction
	 */
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
		if (!this.instruction.getOpcode().equals(Opcode.DAT)) 
		{
			throw new NotAValueException("This address is not a value (DAT)");
		}
		return this.instruction.getBfield().getValue();
	}

	
	
	
	
	
	
	
}
