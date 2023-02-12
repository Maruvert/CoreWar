package corewar.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
	
	
	
	
	public static String fileToString(String path) {
		String content = null;
		
        try {
            content = Files.readString(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return content;

    }

	
	
	
	
	public static ArrayList<String> splitLines(String text) {
		Scanner scanner = new Scanner(text);
	    ArrayList<String> lines = new ArrayList<String>();
	    
	    while(scanner.hasNext()){
	        lines.add(scanner.nextLine());
	    }
	    return lines;
	}
	
	
	
	

}
