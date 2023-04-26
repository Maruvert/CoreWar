package corewar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import corewar.model.exceptions.InvalidOperandException;
import corewar.model.exceptions.UnknownOpcodeException;
import corewar.model.mars.RedcodeInstruction;
import corewar.model.mars.redcode.AddressingMode;
import corewar.model.mars.redcode.Opcode;
import corewar.model.mars.redcode.Operand;
import corewar.model.utils.FileUtils;

/**
 * The Redcode parser, converts a redcode file into RedcodeInstruction objects
 *
 */
public class RedcodeParser {
	
	private int firstInstructionIndex;
	

	public RedcodeParser() {}
	
	
	
	
	public LinkedList<RedcodeInstruction> parse(String redcode) {
		
		redcode = removeMultipleSpaces(redcode);
		ArrayList<String> lines = FileUtils.splitLines(redcode);
		lines = clearComments(lines);
		firstInstructionIndex = defineFirstInstruction(lines);
		ArrayList<String[]> instructions = createInstructionArray(lines);
		LinkedList<RedcodeInstruction> instructionList = createRedcodeObjects(instructions);
		return instructionList;
		
	}
	
	
	
	/**
	 * Replace all multiple spaces by only one space
	 * @param lines
	 * @return
	 */
	private String removeMultipleSpaces(String redcode) {
			return redcode.trim().replaceAll(" +", " ");
	}
	
	
	
	
	@SuppressWarnings("unused")
	private ArrayList<String> trimLines(ArrayList<String> lines) {
		for (final ListIterator<String> iterator = lines.listIterator(); iterator.hasNext();) {
			  final String line = iterator.next();
			  iterator.set(line.trim());
		}
		return lines;
	}
	
	
	
	/**
	 * Clean the comments and trim the lines
	 * @param lines
	 * @return
	 */
	private ArrayList<String> clearComments(ArrayList<String> lines) {
		for (final ListIterator<String> iterator = lines.listIterator(); iterator.hasNext();) {
			  final String line = iterator.next();
			  if (line.contains(";")) {
				  iterator.set(line.substring(0, line.indexOf(";")).trim());
			  }
		}
		lines.removeAll(Arrays.asList("", null));
		return lines;
	}
	

	
	private int defineFirstInstruction(ArrayList<String> lines) {
		for (final ListIterator<String> iterator = lines.listIterator(); iterator.hasNext();) {
			  final String line = iterator.next();
			  if (line.contains("ORG")) {
				  String[] orgExp = line.split(" ");
				  iterator.remove();
				  return Integer.valueOf(orgExp[1]);
			  }
		}
		return 0;
	}
	
	
	
	
	
	private ArrayList<String[]> createInstructionArray(ArrayList<String> lines) {
		
		ArrayList<String[]> instructionArrays = new ArrayList<String[]>();
		
		for (final ListIterator<String> iterator = lines.listIterator(); iterator.hasNext();) {
			  String line = iterator.next().replace(",", "");
			  line = line.replace(".", " ");
			  String[] instruction = line.split(" ");
			  instructionArrays.add(instruction);
			  
		}
		
		return instructionArrays;
	}
	
	
	
	
	private LinkedList<RedcodeInstruction> createRedcodeObjects(ArrayList<String[]> instructions) {
		LinkedList<RedcodeInstruction> instructionList = new LinkedList<RedcodeInstruction>();

		for (final ListIterator<String[]> iterator = instructions.listIterator(); iterator.hasNext();) {
			 /*
			for (String statement : iterator.next()) {
				RedcodeInstruction instruction = new RedcodeInstruction();
			}
			*/
			
			String[] line = iterator.next();
			
			String inputOpcode = line[0];
			String inputAfield = line[1];
			String inputBfield = line[2];
			
			Opcode opcode = null;
			Operand aField = null;
			Operand bField = null;
			
			try {
				opcode = this.parseOpcode(inputOpcode);
				aField = this.parseOperand(inputAfield);
				bField = this.parseOperand(inputBfield);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			instructionList.add(new RedcodeInstruction(opcode, aField, bField));

		}
		
		return instructionList;
	}
	
	
	
	
	private Opcode parseOpcode(String input) throws UnknownOpcodeException {
		Opcode[] existingOpcodes = Opcode.getFields();
		Opcode opcodeToParse = null;
		ArrayList<Opcode> usedOpcodes = new ArrayList<Opcode>();
		
		for (Opcode op : existingOpcodes) {
			if (op.name().equals(input)) {
				opcodeToParse = op;
				usedOpcodes.add(opcodeToParse);
			}
		}
		
		if (opcodeToParse == null) {
			throw new UnknownOpcodeException("Unrecognized Opcode : " + input);
		}
		
		return opcodeToParse;
	}
	
	
	
	
	private Operand parseOperand(String input) throws InvalidOperandException {
		
		HashMap<String, AddressingMode> symbols = AddressingMode.getSymbols();
		AddressingMode addressingModeToParse = null;
		
		switch (input.length()) {
		case 1:
			return new Operand(AddressingMode.DIRECT, Integer.valueOf(input));
		case 2:
			String symbolToParse = String.valueOf(input.charAt(0));
			if (symbols.containsValue(symbolToParse)) {
				addressingModeToParse = symbols.get(symbolToParse);
				return new Operand(addressingModeToParse, Integer.valueOf(input.charAt(1)));
			}
			throw new InvalidOperandException();
		default:
			throw new InvalidOperandException();
			
		
		}
	}
	
	
	
	/*
	private Standard defineRedcodeStandard(ArrayList<String[]> instructions) {
		HashSet<String> opcodeFileList = new HashSet<String>();
		
		for (final ListIterator<String[]> iterator = instructions.listIterator(); iterator.hasNext();) {
			opcodeFileList.add(iterator.next()[0]);
		}
		
		
		String[] opcodeArray = EnumUtils.getNames(Icws88Opcode.class);
		List<String> opcodeList = Arrays.asList(opcodeArray);
		if (!opcodeList.containsAll(opcodeFileList)) {
			
		}
			
	}
	*/
	
	
	
	
	
	
	
	
	
	/**
	 * Replace all variable with his EQU value
	 * @return
	 */
	@SuppressWarnings("unused") //Used to parse assembly language
	private ArrayList<String> replaceEquate(ArrayList<String> lines) {
		
		for (final ListIterator<String> readingIterator = lines.listIterator(); readingIterator.hasNext();) {
			final String line = readingIterator.next();
			if (line.contains("EQU")) {
				
				String[] equExp = line.split(" ");
				String variable = equExp[0];
				String value = equExp[2];
				
				for (final ListIterator<String> replacingIterator = lines.listIterator(); replacingIterator.hasNext();) {
					final String cursor = replacingIterator.next();
					replacingIterator.set(cursor.replaceAll(variable, value));
				}
				
				readingIterator.remove();


				//String value = line.substring(line.indexOf("EQU") + EQU_KEYWORD_LENGTH + 1 , line.length());
			}
		}
		
		return lines;
	}
	



	
	
	
	

}