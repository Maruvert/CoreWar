package corewar.model.redcode;

import java.util.ArrayList;
import java.util.Arrays;

import corewar.model.EnumUtils;
import corewar.model.exceptions.UnknownStandardException;
import corewar.model.redcode.standards.Icws88Opcode;

public enum Standard {
	
	ICWS88 {
		
		@Override
		public ArrayList<String> getOpcodeArrayList() {
			return createOpcodeArrayList(Icws88Opcode.class);
		}
		
	};
	
	
	
	
	/**
	 * Get a String ArrayList that contains all opcodes in the standard
	 * @return a String ArrayList that contains all opcodes in the standard
	 */
	public abstract ArrayList<String> getOpcodeArrayList();
	
	
	
	
	
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
	
	
	
	
	
	
	/**
	 * Get an ArrayList of all standards compatible with the specified opcodes
	 * @param opcodes A list of opcodes
	 * @return Compatible standards
	 * @throws UnknownStandardException In case of unknown opcode or unsupported standard
	 */
	public static ArrayList<Standard> getStandardByOpcode(ArrayList<String> opcodes) throws UnknownStandardException {
		ArrayList<Standard> compatibleStandards = new ArrayList<Standard>();
		for (Standard standard : values()) {
			if(standard.getOpcodeArrayList().containsAll(opcodes)) {
				compatibleStandards.add(standard);
			}
		}
		if (compatibleStandards.isEmpty()) {
			throw new UnknownStandardException("An opcode is invalid or the ICWS standard is not supported yet");
		}
		return compatibleStandards;
	}
	
	
	
	

}
