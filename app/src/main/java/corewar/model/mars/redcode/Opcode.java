package corewar.model.mars.redcode;

import java.util.ArrayList;
import java.util.Arrays;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.Ram;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.utils.EnumUtils;

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
	
	
	private static IOpcode standard;
	
	
	public abstract NextInstructionInformation execute(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	
	

	/**
	 * Create an ArrayList that contains all opcodes in the specified standard
	 * @param standardClass The standard enum
	 * @return The ArrayList containing all opcodes
	 */
	protected ArrayList<String> createOpcodeArrayList(Class<? extends Enum<?>> standardClass) {
		String[] opcodeArray = EnumUtils.getNames(standardClass);
		ArrayList<String> opcodeList = (ArrayList<String>) Arrays.asList(opcodeArray);
		return opcodeList;
	} 
	
	
	
	
	public static Opcode[] getFields() {
	    return Opcode.class.getEnumConstants();
	}
	
	
	
	
	
	
	public static void setStandard(IOpcode standard) {
		Opcode.standard = standard;
	}




	public static IOpcode getStandard() {
		return standard;
	}

}
