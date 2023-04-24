package corewar.model.mars;

import java.util.ArrayList;
import java.util.LinkedList;

import corewar.model.mars.memory.MemoryAddress;

public class Warrior {
	
	private String author;
	private ArrayList<Process> fifo;
	private int currentActiveProcess;
	
	
	public Warrior() {
		this("Guest");
	}
	
	
	public Warrior(String author) {
		this.author = author;
		this.fifo = new ArrayList<Process>();
	}
	
	
	
	
	/**
	 * Create a new process and load instructions into it. Used when the warrior is created
	 * @param instructions The instructions to load
	 */
	public void loadInstructions(LinkedList<RedcodeInstruction> instructions, int ramSize) {
		if(this.fifo.isEmpty()) {
			this.fifo.add(new Process(ramSize));
			this.currentActiveProcess = 0;
		}
		//TODO deal with the else condition
	}
	
	
	
	
	public int getNextAddressToExecute() {
		int nextAddress = this.fifo.get(currentActiveProcess).getNextInstructionAddress();
		this.nextCurrentActiveProcess();
		return nextAddress;
	}
	
	
	
	private void nextCurrentActiveProcess() {
		this.currentActiveProcess += 1;
		if (this.currentActiveProcess > this.fifo.size()-1) {
			this.currentActiveProcess = 0;
		}
	}
	
	
	
	
	public boolean isFifoEmpty() {
		return this.fifo.isEmpty();
	}
	

}
