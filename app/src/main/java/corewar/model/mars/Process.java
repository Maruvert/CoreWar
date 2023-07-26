package corewar.model.mars;

/**
 * A specific process (pointer into memory) used by warriors
 * @author Maruvert
 * @see Warrior
 */
public class Process {

	/**
	 * The position of the process in the ram
	 */
	private int currentPosition;
	
	
	/**
	 * Initialize a new process by specifying his position
	 * @param currentPosition The position in the ram
	 */
	public Process(int initialPosition) {
		this.currentPosition = initialPosition;
		//TODO Deal with invalid values (exception)
	}
	
	
	
	/**
	 * Return the next instruction to be executed and increment the position by 1
	 * @return The next instruction to be executed
	 */
	public int getNextInstructionAddress() {
		int nextInstruction = this.currentPosition;
		this.currentPosition = Ram.getAddress(currentPosition + 1);
		return nextInstruction;
	}
	
	
	
	/**
	 * Skip the next instruction
	 */
	public void skipNextInstruction() {
		this.currentPosition = Ram.getAddress(currentPosition + 1);
	}
	
	


	/**
	 * Set the current position
	 * @param currentPosition The current position
	 */
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
}
