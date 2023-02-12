package corewar;

import java.util.ArrayList;

import corewar.model.FileUtils;
import corewar.model.RedcodeParser;

public class Main {

	public static void main(String[] args) {
		
		String redcodeTestPath = "C:/Users/Maruvert/Main/Prog/CoreWar/Redcode.red";
		String redcodeContent = FileUtils.fileToString(redcodeTestPath);
		
		RedcodeParser parser = new RedcodeParser();
		
		
		ArrayList<String> returnedValue = parser.parse(redcodeContent);
		
		
		for (String line : returnedValue) {
			System.out.println(line);
		}
		
		
		
		
		

	}

}
