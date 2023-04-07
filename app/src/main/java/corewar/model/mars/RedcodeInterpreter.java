package corewar.model.mars;

import corewar.model.mars.memory.MemoryAddress;

public class RedcodeInterpreter {
	
	private Ram ram;
	
	private Fifo f1;
	private Fifo f2;
	private Fifo current;
	
	
	
	
	
	public RedcodeInterpreter() {}
	
	
	
	
	public RedcodeInterpreter(Fifo f1, Fifo f2) {
		this.f1 = f1;
		this.f1 = f1;
	}
	
	
	
	
	public void interpret() {
		
		while (!isOneFifoEmpty()) {
			this.execute(current.nextInstruction(), ram);
			this.switchCurrent();
		}
		
	}
	
	
	
	
	
	
	
	public void execute(MemoryAddress memory, Ram ram) {
		memory.getInstruction().getOpcode().execute(memory);
	}
	
	
	
	
	/**
	 * Switch the Fifo to be executed
	 */
	private void switchCurrent() {
		if (this.current.equals(f1)) {
			this.current = f2;
		}
		else {
			this.current = f1;
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Return true if one of the FIFO is empty
	 * @return True if one FIFO is empty ; false else
	 */
	private boolean isOneFifoEmpty() {
		return this.f1.isEmpty() || this.f2.isEmpty(); 
	}
	
	

}
