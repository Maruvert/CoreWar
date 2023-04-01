package corewar.model.mars;

import corewar.model.mars.redcode.IOpcode;
import corewar.model.mars.redcode.Operand;

/**
 * Represents a Redcode instruction (Opcode + Operand A and B) 
 * @author Maruvert
 */
public class RedcodeInstruction {
	
	private static IOpcode standard;
	
	
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
		this.a = new Operand();
		this.b = new Operand();
	}



	public IOpcode getOpcode() {
		return opcode;
	}




	public Operand getFirstValue() {
		return a;
	}




	public Operand getSecondValue() {
		return b;
	}
	
	
	
	public static void setStandard(IOpcode icwsStandard) {
		standard.getClass().cast(icwsStandard);
	}
	
	

}
