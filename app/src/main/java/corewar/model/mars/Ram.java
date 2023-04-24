package corewar.model.mars;

import java.util.ArrayList;

import corewar.model.mars.memory.CircularArrayList;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.Operand;

public class Ram {
	
	private CircularArrayList<MemoryAddress> memory;
	
	
	
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
	
	
	
	
	public MemoryAddress getMemoryAddressByOperand(MemoryAddress memory, Operand op) {
		return memory;
	}
	
	
	
	
	

}
