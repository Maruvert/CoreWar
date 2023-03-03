package corewar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import corewar.model.redcode.IOpcode;
import corewar.model.redcode.Standard;
import corewar.model.redcode.standards.Icws88Opcode;

public class RedcodeParser {
	
	private int firstInstructionIndex;
	private ArrayList<Standard> compatibleStandards;
	

	public RedcodeParser() {}
	
	
	
	
	public ArrayList<String> parse(String redcode) {
		
		redcode = removeBlanks(redcode);
		ArrayList<String> lines = FileUtils.splitLines(redcode);
		lines = clearComments(lines);
		firstInstructionIndex = defineFirstInstruction(lines);
		ArrayList<String[]> instructions = createInstructionArray(lines);
		
		return lines;
		
	}
	
	
	
	/**
	 * Replace all multiple spaces by only one space
	 * @param lines
	 * @return
	 */
	private String removeBlanks(String redcode) {
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
	
	
	
	
	private ArrayList<RedcodeInstruction> createRedcodeObjects(ArrayList<String[]> instructions) {
		
		for (final ListIterator<String[]> iterator = instructions.listIterator(); iterator.hasNext();) {
			 
			for (String statement : iterator.next()) {
				RedcodeInstruction instruction = new RedcodeInstruction();
			}
			
		}
		
		
		
		return null;
		
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