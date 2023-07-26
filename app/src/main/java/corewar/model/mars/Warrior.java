package corewar.model.mars;

import java.util.ArrayList;

/**
 * A CoreWar warrior
 * @author Maruvert
 *
 */
public class Warrior {
	
	/**
	 * The author's name
	 */
	private String author;
	
	/**
	 * A list of active process (pointers into memory)
	 */
	private ArrayList<Process> fifo;
	
	/**
	 * The current active process
	 */
	private int currentActiveProcess;
	
	
	
	
	/**
	 * Default constructor setting author's name as 'Guest'
	 */
	public Warrior() {
		this("Guest");
	}
	
	
	/**
	 * Constructor using the author's name
	 * @param author The author's name
	 */
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
	
	
	
	
	/**
	 * Skip the next address on the active process
	 */
	public void skipNextAddressOnActiveProcess() {
		this.fifo.get(currentActiveProcess).skipNextInstruction();
	}
	
	
	
	/**
	 * Jump to a certain address on the active process
	 * @param address The address to jump to
	 */
	public void jumpToAddressOnActiveProcess(int address) {
		this.fifo.get(currentActiveProcess).setCurrentPosition(address);
	}
	
	
	
	/**
	 * Create a new process for this warrior by specifying its initial position
	 * @param address The initial position in the ram for the process
	 */
	public void createNewProcess(int address) {
		this.fifo.add(new Process(address));
		this.nextCurrentActiveProcess();
	}
	
	
	
	/**
	 * Select the next process to be active
	 */
	private void nextCurrentActiveProcess() {
		this.currentActiveProcess += 1;
		if (this.currentActiveProcess > this.fifo.size()-1) {
			this.currentActiveProcess = 0;
		}
	}
	
	
	
	/**
	 * Return true if the warrior doesn't have any active process
	 * @return True if the warrior doesn't have any active process ; false else
	 */
	public boolean isFifoEmpty() {
		return this.fifo.isEmpty();
	}

	
	

	/**
	 * Return the author
	 * @return The author
	 */
	public String getAuthor() {
		return author;
	}
	
	
	
	
	
	

}
