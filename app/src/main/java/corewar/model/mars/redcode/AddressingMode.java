package corewar.model.mars.redcode;

import java.util.HashMap;

import corewar.model.exceptions.NotAValueException;
import corewar.model.mars.Ram;
import corewar.model.mars.memory.MemoryAddress;

/**
 * Enum containing all addressing modes
 * @author Maruvert
 *
 */
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
	
	
	
	
	/**
	 * Return a key/value of each symbol associated with his addressing mode
	 * @return An HashMap Symbol / Addressing Mode
	 */
	public static HashMap<String, AddressingMode> getSymbols() {
		HashMap<String, AddressingMode> symbols = new HashMap<String, AddressingMode>();
		for (AddressingMode mode : AddressingMode.class.getEnumConstants()) {
			symbols.put(mode.getSymbol(), mode);
		}
		return symbols;
	}
	
	
	
	/**
	 * Target a memory address using a specific addressing mode
	 * @param ram The ram in which the game take place
	 * @param address The current address //TODO Refactor (Change MemoryAddress address into int address)
	 * @param value The value associated to the mode
	 * @return The targeted address
	 */
	public abstract int getTargetedMemoryAddress(Ram ram, MemoryAddress address, int value);
	
	
	
	
	/**
	 * Return the mode's symbol
	 * @return The mode's symbol
	 */
	public abstract String getSymbol();
	
	
	
	

}
