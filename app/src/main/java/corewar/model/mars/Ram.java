package corewar.model.mars;

import java.util.ArrayList;

import corewar.model.mars.memory.CircularArrayList;
import corewar.model.mars.memory.MemoryAddress;

public class Ram {
	
	private CircularArrayList<MemoryAddress> memory;
	
	private static final int DEFAULT_MEMORY_SIZE = 8000;
	
	
	
	
	public Ram() {
		this(DEFAULT_MEMORY_SIZE);
	}
	
	
	
	
	public Ram(int memorySize) {
		memory = new CircularArrayList<MemoryAddress>(memorySize);
	}
	
	
	public void initialize() {
		for (MemoryAddress address : memory) {
			address.initialize();
		}
	}
	
	
	
	
	public MemoryAddress getMemoryAddress(int address) {
		for (MemoryAddress slot : this.memory) {
			if (slot.getAddress() == address) {
				return slot;
			}
		}
		return null;
	}
	
	

}
