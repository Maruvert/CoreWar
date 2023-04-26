package corewar.model.exceptions;

public class InvalidOperandException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6271277973253203166L;


	public InvalidOperandException() {
		super();
	}
	
	
	public InvalidOperandException(String string) {
		super(string);
	}
}
