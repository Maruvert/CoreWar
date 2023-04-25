package corewar.model.mars;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.NextInstructionInformation;

public class RedcodeInterpreter {
	
	private Ram ram;
	
	private Warrior w1;
	private Warrior w2;
	private Warrior current;
	
	
	
	
	
	public RedcodeInterpreter() {}
	
	
	
	
	public RedcodeInterpreter(Warrior w1, Warrior w2) {
		this.w1 = w1;
		this.w1 = w1;
	}
	
	
	
	
	public void interpret() {
		
		NextInstructionInformation next;
		
		while (!isOneFifoEmpty()) {
			next = this.execute(ram.getMemoryAddress(current.getNextAddressToExecute()), ram);
			this.setNextInstruction(next);
			this.switchCurrent();
		}
		
	}
	
	
	
	
	
	
	
	private NextInstructionInformation execute(MemoryAddress memory, Ram ram) {
		NextInstructionInformation next = null;
		try {
			next = memory.getInstruction().getOpcode().execute(ram, memory);
		} catch (InvalidAddressingModeException e) {
			e.printStackTrace();
		}
		return next;
	}
	
	
	
	
	private void setNextInstruction(NextInstructionInformation next) {
		switch (next.getOperation()) {
		case NEXT:
			break;
		case SKIP:
			current.skipNextInstructionOnActiveProcess();
			break;
		case JUMP:
			current.jumpInstructionOnActiveProcess(next.getAddress());
			break;
		case FORK:
			current.createNewProcess(next.getAddress());
			break;
		}
	}
	
	
	
	
	/**
	 * Switch the Fifo to be executed
	 */
	private void switchCurrent() {
		if (this.current.equals(w1)) {
			this.current = w2;
		}
		else {
			this.current = w1;
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Return true if one of the FIFO is empty
	 * @return True if one FIFO is empty ; false else
	 */
	private boolean isOneFifoEmpty() {
		return this.w1.isFifoEmpty() || this.w2.isFifoEmpty(); 
	}
	
	

}
