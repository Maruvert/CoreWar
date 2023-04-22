package corewar.model.mars.redcode;

import corewar.model.exceptions.NotAValueException;
import corewar.model.mars.Ram;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.standards.Icws88Opcode;

public enum AddressingMode {
	
	
	IMMEDIATE {
		public int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value) {
			return value;
		}
	},
	
	
	
	DIRECT {
		public int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value) {
			return address.getAddress()+value;
		}	
	},
	
	
	
	INDIRECT {
		public int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value) {
			int indirectValue = 0;
			MemoryAddress indirectAddress = null;
			try {
				indirectAddress = ram.getMemoryAddress(address.getAddress()+value);
				indirectValue = indirectAddress.getValue();
			} catch (NotAValueException e) {
				e.printStackTrace();
			}
			return indirectAddress.getAddress()+indirectValue;
		}
	},
	
	
	
	INDIRECT_PREDECREMENT {
		public int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value) {
			int indirectValue = 0;
			MemoryAddress indirectAddress = null;
			try {
				indirectAddress = ram.getMemoryAddress(address.getAddress()+value);
				indirectAddress.getInstruction().decrementBfield();
				indirectValue = indirectAddress.getValue();
			} catch (NotAValueException e) {
				e.printStackTrace();
			}
			return indirectAddress.getAddress()+indirectValue;
		}
	};
	
	
	
	public abstract int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value);
	
	
	
	

}
