package corewar.model;

import corewar.model.redcode.IOpcode;
import corewar.model.redcode.Operand;

public class RedcodeInstruction {
	
	private static IOpcode standard;
	
	private IOpcode opcode;
	private Operand firstValue;
	private Operand secondValue;
	
	
	
	
	public RedcodeInstruction(IOpcode opcode, Operand firstValue, Operand secondValue) {
		this.opcode = opcode;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	
	
	
	public RedcodeInstruction() {
		opcode = opcode.getDat();
		this.firstValue = new Operand();
		this.secondValue = new Operand();
	}



	public IOpcode getOpcode() {
		return opcode;
	}




	public Operand getFirstValue() {
		return firstValue;
	}




	public Operand getSecondValue() {
		return secondValue;
	}
	
	
	
	public static void setStandard(IOpcode icwsStandard) {
		standard.getClass().cast(icwsStandard);
	}
	
	

}
