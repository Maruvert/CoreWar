package corewar.model.mars.redcode;

public class Operand {
	
	private AddressingMode mode;
	private int value;
	
	
	
	public Operand(AddressingMode mode, int value) {
		this.mode = mode;
		this.value = value;
	}
	
	
	
	public Operand(int value) {
		this(AddressingMode.IMMEDIATE, value);
	}
	
	
	
	
	
	public void decrement() {
		this.value -= 1;
	}
	
	
	
	public void add(int value) {
		this.value += value;
	}
	
	
	
	public AddressingMode getMode() {
		return mode;
	}






	public int getValue() {
		return value;
	}
	
	
	
	

}
