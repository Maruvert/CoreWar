package corewar.model.mars;

import java.util.LinkedList;

import corewar.model.mars.Warrior;
import corewar.model.mars.memory.MemoryAddress;

public class Fifo {
	
	private LinkedList<MemoryAddress> instructions;
	private int currentPosition;
	
	
	public Fifo() {}
	
	
	
	public MemoryAddress nextInstruction() {
		return null;
	}
	
	
	public void setInstructions(LinkedList<RedcodeInstruction> instructions) {
		
	}
	
	
	
	public boolean isEmpty() {
		return this.instructions.isEmpty();
	}
	
	
	

}
