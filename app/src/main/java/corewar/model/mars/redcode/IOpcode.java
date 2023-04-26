package corewar.model.mars.redcode;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.Ram;
import corewar.model.mars.memory.MemoryAddress;

public interface IOpcode {
	
	public NextInstructionInformation executeDAT(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeMOV(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeADD(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeSUB(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeJMP(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeJMZ(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeJMN(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeCMP(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeSLT(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeDJN(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	
	public NextInstructionInformation executeSPL(Ram ram, MemoryAddress memory) throws InvalidAddressingModeException;
	

}
