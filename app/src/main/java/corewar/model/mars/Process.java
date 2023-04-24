package corewar.model.mars;

import java.util.LinkedList;

import corewar.model.mars.Warrior;
import corewar.model.mars.memory.MemoryAddress;

public class Process {

	private int currentPosition;
	private static int ramSize;
	
	
	public Process(int ramSize) {
		this.ramSize = ramSize;
	}
	
	
	
	public int getNextInstructionAddress() {
		int nextInstruction = this.currentPosition;
		this.currentPosition = this.incrementAddress(currentPosition);
		return nextInstruction;
	}
	
	
	
	
	private int incrementAddress(int value) {
		if (value >= ramSize) {
			value = 0;
		}
		return value;
	}
	
}
