package corewar.model.mars;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.memory.MemoryAddress;

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
		
		while (!isOneFifoEmpty()) {
			this.execute(ram.getMemoryAddress(current.getNextAddressToExecute()), ram);
			this.switchCurrent();
		}
		
	}
	
	
	
	
	
	
	
	public void execute(MemoryAddress memory, Ram ram) {
		try {
			memory.getInstruction().getOpcode().execute(ram, memory);
		} catch (InvalidAddressingModeException e) {
			e.printStackTrace();
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
