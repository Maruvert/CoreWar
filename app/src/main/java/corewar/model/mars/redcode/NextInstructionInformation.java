package corewar.model.mars.redcode;

/**
 * Contains informations about the next instruction to execute
 * @author Maruvert
 *
 */
public class NextInstructionInformation {
	
	/**
	 * The operation to execute by the interpreter
	 */
	private NextInstructionOperation operation;
	
	/**
	 * The address in case of jump or fork
	 */
	private int address;
	
	
	/**
	 * Constructor used by specifying each attribute (in case of jump and fork operation)
	 * @param operation The operation
	 * @param address The next address
	 */
	public NextInstructionInformation(NextInstructionOperation operation, int address) {
		this.operation = operation;
		this.address = address;
	}
	
	/**
	 * Constructor used if the address is useless (in case of skip and next operation)
	 * @param operation
	 */
	public NextInstructionInformation(NextInstructionOperation operation) {
		this.operation = operation;
	}


	/**
	 * Return the operation
	 * @return The operation
	 */
	public NextInstructionOperation getOperation() {
		return operation;
	}

	
	/**
	 * Return the address
	 * @return The address
	 */
	public int getAddress() {
		return address;
	}
	
	
	
	

}
