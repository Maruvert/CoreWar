package corewar.model;

import java.util.Scanner;

import corewar.model.mars.Ram;
import corewar.model.mars.RedcodeInterpreter;
import corewar.model.mars.Warrior;
import corewar.model.utils.FileUtils;

/**
 * The CoreWar launcher, used from main
 *
 */
public class CoreWar {
	
	private static final int DEFAULT_MEMORY_SIZE = 8000;
	
	
	private Warrior firstWarrior;
	private Warrior secondWarrior;
	private int ramSize;
	
	
	
	public CoreWar() {
		this.ramSize = DEFAULT_MEMORY_SIZE;
	}
	
	
	
	
	/**
	 * Launch a CoreWar game
	 */
	public void start() {
		Ram ram = new Ram(this.ramSize);
		ram.initialize();
		RedcodeInterpreter alu = new RedcodeInterpreter();
		alu.interpret();
	}
	
	
	

	public void startConsoleInterface() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first player's name :\n> ");
		String p1 = sc.nextLine();
		System.out.print("Enter the second player's name :\n> ");
		String p2 = sc.nextLine();
		
		this.firstWarrior = new Warrior(p1);
		this.secondWarrior = new Warrior(p2);
		
		System.out.print("Enter a path to load the first player's redcode :\n> ");
		String r1 = sc.nextLine();
		System.out.print("Enter a path to load the second player's redcode :\n> ");
		String r2 = sc.nextLine();
		
		this.loadRedcodeFile(r1, firstWarrior);
		this.loadRedcodeFile(r2, firstWarrior);
		
	}
	
	
	
	public void loadRedcodeFile(String path, Warrior warrior) {
		RedcodeParser parser = new RedcodeParser();
		String redcode = FileUtils.fileToString(path);
		warrior.loadInstructions(parser.parse(redcode), this.ramSize);
	}
	

}
