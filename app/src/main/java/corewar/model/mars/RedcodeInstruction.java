package corewar.model.mars;

import corewar.model.mars.redcode.IOpcode;
import corewar.model.mars.redcode.Operand;

/**
 * Represents a Redcode instruction (Opcode + Operand A and B) 
 */
public class RedcodeInstruction {
	
	/**
	 * The opcode
	 */
	private IOpcode opcode;
	
	
	/**
	 * The A operand
	 */
	private Operand a;
	
	
	/**
	 * The B operand
	 */
	private Operand b;
	
	
	
	
	public RedcodeInstruction(IOpcode opcode, Operand firstValue, Operand secondValue) {
		this.opcode = opcode;
		this.a = firstValue;
		this.b = secondValue;
	}

	
	
	
	public RedcodeInstruction() {
		opcode = opcode.getDat();
		this.a = new Operand(0);
		this.b = new Operand(0);
	}
	
	
	
	public RedcodeInstruction(int value) {
		this.opcode = opcode.getDat();
		this.a = new Operand(0);
		this.b = new Operand(value);
	}
	
	
	
	public void decrementBfield() {
		this.b.decrement();
	}
	

	public void addToBfield(int value) {
		this.b.add(value);
	} 
	
	
	

	public IOpcode getOpcode() {
		return opcode;
	}




	public Operand getAfield() {
		return a;
	}




	public Operand getBfield() {
		return b;
	}
	
	

}
