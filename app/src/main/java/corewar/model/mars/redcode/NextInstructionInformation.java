package corewar.model.mars.redcode;

public class NextInstructionInformation {
	
	private NextInstructionOperation operation;
	private int address;
	
	
	public NextInstructionInformation(NextInstructionOperation operation, int address) {
		this.operation = operation;
		this.address = address;
	}
	
	public NextInstructionInformation(NextInstructionOperation operation) {
		this.operation = operation;
	}


	public NextInstructionOperation getOperation() {
		return operation;
	}


	public int getAddress() {
		return address;
	}
	
	
	
	

}
