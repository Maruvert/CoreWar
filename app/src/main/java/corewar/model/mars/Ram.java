package corewar.model.mars;

import java.util.LinkedList;
import corewar.model.mars.memory.CircularArrayList;
import corewar.model.mars.memory.MemoryAddress;


/**
 * The circular Ram memory in which warriors fight each others
 * @author Maruvert
 */
public class Ram {
	
	/**
	 * The Ram size
	 */
	private static int size;
	
	/**
	 * The memory is represented by a circular ArrayList
	 */
	private CircularArrayList<MemoryAddress> memory;
	
	
	
	/**
	 * Constructor
	 * @param ramSize The ram size
	 */
	public Ram(int ramSize) {
		Ram.size = ramSize;
		memory = new CircularArrayList<MemoryAddress>(ramSize);
	}
	
	
	
	/**
	 * Initialize the Ram by filling it with addresses containing DAT #0 #0 instruction
	 */
	public void initialize() {
		for (int i = 0 ; i < size ; i++) {
			MemoryAddress slot = new MemoryAddress(i);
			memory.add(slot);
			slot.initialize();
		}
	}
	
	
	
	
	/**
	 * Load redcode instructions starting at the specified address
	 * @param address The address where the instructions will be loaded
	 * @param instructions The instructions
	 */
	public void loadRedcode(int address, LinkedList<RedcodeInstruction> instructions) {
		for (RedcodeInstruction instruction : instructions) {
			this.memory.get(address).setInstruction(instruction);
			address++;
		}
	}
	
	
	
	

	
	
	
	
	/**
	 * Return the specified memory address. The address is circular
	 * @param address The address
	 * @return The Memory Address object
	 */
	public MemoryAddress getMemoryAddress(int address) {
		return memory.get(address);
		/*address = memory.get(address).getAddress();
		for (MemoryAddress slot : this.memory) {
			if (slot.getAddress() == address) {
				return slot;
			}
		}
		return null;*/
	}


	
	
	
	
	/**
	 * Get the specified address ; useful if the address exceeds the max
	 * @param address The address to get
	 * @return The real address (e.g. max + 3 will return 2)
	 */
	public static int getAddress(int address) {
		return address % Ram.size;
	}
	

	/**
	 * Return the ram size
	 * @return The ram size
	 */
	public static int getSize() {
		return size;
	}
	
}
