package corewar.model.mars.redcode;

/**
 * Represents an operand (AddressingMode + value)
 * @author Maruvert
 *
 */
public class Operand {
	
	/**
	 * The addressing mode
	 */
	private AddressingMode mode;
	
	
	
	/**
	 * The operand value
	 */
	private int value;
	
	
	/**
	 * Constructor used by specifying each attribute
	 * @param mode The addressing mode
	 * @param value The value
	 */
	public Operand(AddressingMode mode, int value) {
		this.mode = mode;
		this.value = value;
	}
	
	
	/**
	 * Shortcut constructor used to create a single value (immediate)
	 * @param value
	 */
	public Operand(int value) {
		this(AddressingMode.IMMEDIATE, value);
	}
	
	
	
	
	/**
	 * Decrement the value by one
	 */
	public void decrement() {
		this.value -= 1;
	}
	
	
	
	
	/**
	 * Add the specified value to the operand's value
	 * @param value The value to add
	 */
	public void add(int value) {
		this.value += value;
	}
	
	
	
	
	/**
	 * Return the mode
	 * @return The mode
	 */
	public AddressingMode getMode() {
		return mode;
	}


	
	
	/**
	 * Return the value
	 * @return The value
	 */
	public int getValue() {
		return value;
	}
	
	
	
	

}
