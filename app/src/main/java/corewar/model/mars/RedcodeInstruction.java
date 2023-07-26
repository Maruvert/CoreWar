package corewar.model.mars;

import corewar.model.mars.redcode.Opcode;
import corewar.model.mars.redcode.Operand;

/**
 * Represents a Redcode instruction (Opcode + Operand A and B)
 * @author Maruvert
 */
public class RedcodeInstruction {
	/**
	 * The opcode
	 */
	private Opcode opcode;
	
	
	/**
	 * The A operand
	 */
	private Operand a;
	
	
	/**
	 * The B operand
	 */
	private Operand b;
	
	
	
	/**
	 * Constructor used by specifying each attribute
	 * @param opcode The opcode
	 * @param firstValue The A Operand
	 * @param secondValue The B Operand
	 */
	public RedcodeInstruction(Opcode opcode, Operand firstValue, Operand secondValue) {
		this.opcode = opcode;
		this.a = firstValue;
		this.b = secondValue;
	}

	
	
	/**
	 * Shortcut constructor used to create a DAT instruction by specifying the value directly
	 * @param value The value to set as B operand in the DAT instruction
	 */
	public RedcodeInstruction(int value) {
		this(Opcode.DAT, new Operand(0), new Operand(value));
	}
	
	
	
	/**
	 * Shortcut constructor used to create specifically a 'DAT #0 #0' instruction
	 */
	public RedcodeInstruction() {
		this(0);
	}
	
	
	
	
	/**
	 * Decrement the B field
	 */
	public void decrementBfield() {
		this.b.decrement();
	}
	

	
	
	/**
	 * Add the specified value to the B field
	 * @param value The value to add
	 */
	public void addToBfield(int value) {
		this.b.add(value);
	} 


	
	
	
	/**
	 * Return the opcode
	 * @return The opcode
	 */
	public Opcode getOpcode() {
		return opcode;
	}

	


	/**
	 * Return the A field
	 * @return The A field
	 */
	public Operand getAfield() {
		return a;
	}


	

	/**
	 * Return the A field
	 * @return The A field
	 */
	public Operand getBfield() {
		return b;
	}
	
	

}
