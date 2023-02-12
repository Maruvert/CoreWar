package corewar.model;

import java.util.ArrayList;

public class Ram {
	
	private CircularArrayList<MemoryAddress> memory;
	
	/**
	 * TODO find the real default value if exists (1024 is a placeholder)
	 */
	private static final int DEFAULT_MEMORY_SIZE = 1024;
	
	
	
	
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
	

}
