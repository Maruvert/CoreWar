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
	public void initialize(int address) {
		if(this.fifo.isEmpty()) {
			this.fifo.add(new Process(address));
			this.currentActiveProcess = 0;
		}
		//TODO deal with the else condition
	}
	
	
	
	/**
	 * Return the next address that should be executed on the current process and select the next process
	 * @return The address that should be executed
	 */
	public int getNextAddressToExecute() {
		int nextAddress = this.fifo.get(currentActiveProcess).getNextInstructionAddress();
		this.nextCurrentActiveProcess();
		return nextAddress;
	}
	
	
	
	public void skipNextInstructionOnActiveProcess() {
		this.fifo.get(currentActiveProcess).skipNextInstruction();
	}
	
	
	public void jumpInstructionOnActiveProcess(int address) {
		this.fifo.get(currentActiveProcess).setCurrentPosition(address);
	}
	
	
	
	
	public void createNewProcess(int address) {
		this.fifo.add(new Process(address));
		this.nextCurrentActiveProcess();
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
