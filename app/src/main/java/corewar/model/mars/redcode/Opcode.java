package corewar.model.mars.redcode;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.Ram;
import corewar.model.mars.memory.MemoryAddress;

/**
 * Enum containing all existing opcodes / represents an opcode
 * @author Maruvert
 *
 */
public enum Opcode {
	
	DAT {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeDAT(ram, memory);
		}
	},
	MOV {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeMOV(ram, memory);
		}
	},
	ADD {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeADD(ram, memory);
		}
	},
	SUB {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeSUB(ram, memory);
		}
	},
	JMP {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeJMP(ram, memory);
		}
	},
	JMZ {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeJMZ(ram, memory);
		}
	},
	JMN {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeJMN(ram, memory);
		}
	},
	CMP {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeCMP(ram, memory);
		}
	},
	SLT {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeSLT(ram, memory);
		}
	},
	DJN {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeDJN(ram, memory);
		}
	},
	SPL {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException {
			return getStandard().executeSPL(ram, memory);
		}
	};
	
	
	
	/**
	 * The Redcode standard used in the game
	 */
	private static IOpcode standard;
	
	
	/**
	 * Execute the instruction contained in 'memory'
	 * @param ram The ram in which the memory is contained
	 * @param memory The address containting the instruction to execute
	 * @return Informations about the next instruction to execute
	 * @throws InvalidAddressingModeException
	 */
	public abstract NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	
	
	/**
	 * Return an array containing all existing opcodes
	 * @return An array containing all existing opcodes
	 */
	public static Opcode[] getFields() {
	    return Opcode.class.getEnumConstants();
	}
	
	
	
	
	/**
	 * Used to set the current opcode standard
	 * @param standard The Redcode standard used in the game
	 */
	public static void setStandard(IOpcode standard) {
		Opcode.standard = standard;
	}


	

	/**
	 * Return the Redcode standard
	 * @return The Redcode standard
	 */
	public static IOpcode getStandard() {
		return standard;
	}

}
