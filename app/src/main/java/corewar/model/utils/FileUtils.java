package corewar.model.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * File utility methods
 */
public class FileUtils {
	
	
	
	/**
	 * Read the file in the specified path and converts it into a String
	 * @param path The path to the file
	 * @return A String that contains the file content
	 */
	public static String fileToString(String path) {
		String content = null;
		
        try {
            content = Files.readString(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return content;

    }

	
	
	
	/**
	 * Split each line of a String and put them in an ArrayList
	 * @param text A String
	 * @return An ArrayList that contains splitted lines
	 */
	public static ArrayList<String> splitLines(String text) {
		Scanner scanner = new Scanner(text);
	    ArrayList<String> lines = new ArrayList<String>();
	    
	    while(scanner.hasNext()){
	        lines.add(scanner.nextLine());
	    }
	    scanner.close();
	    return lines;
	}
	
	
	
	

}
