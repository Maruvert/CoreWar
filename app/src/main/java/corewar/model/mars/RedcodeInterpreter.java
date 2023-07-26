package corewar.model.mars;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.NextInstructionInformation;
import corewar.view.IRamViewSubscriber;

public class RedcodeInterpreter {
	
	private Ram ram;
	
	private Warrior w1;
	private Warrior w2;
	private Warrior current;
	
	private ArrayList<IRamViewSubscriber> subscribers;
	
	
	
	
	
	public RedcodeInterpreter() {}
	
	
	
	
	public RedcodeInterpreter(Ram ram, Warrior w1, Warrior w2) {
		this.ram = ram;
		this.w1 = w1;
		this.w2 = w2;
		this.current = w1;
		this.subscribers = new ArrayList<IRamViewSubscriber>();
	}
	
	
	
	
	public void interpret() {
		
		NextInstructionInformation next;
		
		while (!isOneFifoEmpty()) {
			int addressToExecute = current.getNextAddressToExecute();
			next = this.execute(ram.getMemoryAddress(addressToExecute), ram);
			this.notify(OperationType.EXECUTION, addressToExecute, this.warriorToNumber(current));
			this.setNextInstruction(next);
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
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
			current.skipNextAddressOnActiveProcess();
			break;
		case JUMP:
			current.jumpToAddressOnActiveProcess(next.getAddress());
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
	
	
	
	private int warriorToNumber(Warrior warrior) {
		if (warrior.equals(w1)) {
			return 0;
		}
		else if (warrior.equals(w2)) {
			return 1;
		}
		else return -1;
	}
	
	
	
	
	
	/**
	 * Return true if one of the FIFO is empty
	 * @return True if one FIFO is empty ; false else
	 */
	private boolean isOneFifoEmpty() {
		return this.w1.isFifoEmpty() || this.w2.isFifoEmpty(); 
	}
	
	
	
	private void notify(OperationType type, int address, int warriorNumber) {
		for(IRamViewSubscriber sub : this.subscribers) {
			sub.update(type, address, warriorNumber);
		}
	}
	
	
	
	public void subscribe(IRamViewSubscriber sub) {
		this.subscribers.add(sub);
	}
	
	
	
	

}
