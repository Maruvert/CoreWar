package corewar.model.mars;

import java.util.LinkedList;

public class Warrior {
	
	private String author;
	private Fifo fifo;
	
	
	public Warrior() {
		this(null);
	}
	
	
	public Warrior(String author) {
		this.author = author;
		this.fifo = new Fifo();
	}
	
	
	
	
	
	public void loadInstructions(LinkedList<RedcodeInstruction> instructions) {
		this.fifo.setInstructions(instructions);
	}


	
	
	/**
	 * Return the warrior's FIFO
	 * @return The FIFO
	 */
	public Fifo getFifo() {
		return fifo;
	}
	
	
	
	
	
	
	

}
