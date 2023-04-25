package corewar.model.mars;

import java.util.LinkedList;

import corewar.model.mars.Warrior;
import corewar.model.mars.memory.MemoryAddress;

public class Process {

	private int currentPosition;
	private static int ramSize;
	
	
	public Process() {}
	
	
	
	public Process(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
	/**
	 * Return the next instruction to be executed and increment the position by 1
	 * @return The next instruction to be executed
	 */
	public int getNextInstructionAddress() {
		int nextInstruction = this.currentPosition;
		this.currentPosition = this.incrementAddress(currentPosition, 1);
		return nextInstruction;
	}
	
	
	
	public void skipNextInstruction() {
		this.currentPosition = this.incrementAddress(currentPosition, 1);
	}
	
	
	
	private int incrementAddress(int value, int incrementValue) {
		value += incrementValue;
		if (value >= ramSize) {
			value -= ramSize;
		}
		return value;
	}



	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
	
	public static void setRamSize(int ramSize) {
		Process.ramSize = ramSize;
	}
	
	
	
}
