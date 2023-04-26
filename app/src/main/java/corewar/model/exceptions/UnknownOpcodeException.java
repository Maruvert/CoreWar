package corewar.model.exceptions;

public class UnknownOpcodeException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2887810321172692785L;


	public UnknownOpcodeException() {
		super();
	}
	
	
	public UnknownOpcodeException(String string) {
		super(string);
	}

}
