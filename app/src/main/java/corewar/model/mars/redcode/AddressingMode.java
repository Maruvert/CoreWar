package corewar.model.mars.redcode;

import java.util.HashMap;

import corewar.model.exceptions.NotAValueException;
import corewar.model.mars.Ram;
import corewar.model.mars.memory.MemoryAddress;

public enum AddressingMode {
	
	
	IMMEDIATE {
		@Override
		public int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value) {
			return value;
		}

		@Override
		public String getSymbol() {
			return "#";
		}
	},
	
	
	
	DIRECT {
		@Override
		public int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value) {
			return address.getAddress()+value;
		}

		@Override
		public String getSymbol() {
			return "$";
		}	
	},
	
	
	
	INDIRECT {
		@Override
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

		@Override
		public String getSymbol() {
			return "@";
		}
	},
	
	
	
	INDIRECT_PREDECREMENT {
		@Override
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

		@Override
		public String getSymbol() {
			return "<";
		}
	};
	
	
	
	public static HashMap<String, AddressingMode> getSymbols() {
		HashMap<String, AddressingMode> symbols = new HashMap<String, AddressingMode>();
		for (AddressingMode mode : AddressingMode.class.getEnumConstants()) {
			symbols.put(mode.getSymbol(), mode);
		}
		return symbols;
	}
	
	
	
	
	public abstract int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value);
	
	
	
	public abstract String getSymbol();
	
	
	
	

}
