package corewar.model;

import java.util.LinkedList;
import java.util.Scanner;

import corewar.model.mars.Ram;
import corewar.model.mars.RedcodeInstruction;
import corewar.model.mars.RedcodeInterpreter;
import corewar.model.mars.Warrior;
import corewar.model.mars.redcode.Opcode;
import corewar.model.mars.redcode.standards.Icws88;
import corewar.model.utils.FileUtils;
import corewar.model.utils.MathsUtils;
import corewar.model.mars.Process;

/**
 * The CoreWar launcher, used from main
 *
 */
public class CoreWar {
	
	private static final int DEFAULT_MEMORY_SIZE = 8000;
	
	
	private Warrior firstWarrior;
	private Warrior secondWarrior;
	
	private LinkedList<RedcodeInstruction> w1redcode;
	private LinkedList<RedcodeInstruction> w2redcode;
	
	private int ramSize;
	
	private RedcodeInterpreter alu;
	
	
	
	public CoreWar() {
		this.ramSize = DEFAULT_MEMORY_SIZE;
	}
	
	
	
	
	/**
	 * Launch a CoreWar game
	 */
	public void initialize() {
		Opcode.setStandard(new Icws88()); //Placeholder, will be deleted when more standards will be supported
		Process.setRamSize(ramSize);
		Ram ram = new Ram(this.ramSize);
		ram.initialize();
		
		int firstPart = MathsUtils.roundUp(ramSize/3);
		int lastPart = MathsUtils.roundUp(ramSize-firstPart);
		
		this.loadRedcodeInRam(ram, MathsUtils.random(0, firstPart), firstWarrior, w1redcode);
		this.loadRedcodeInRam(ram, MathsUtils.random(lastPart, ramSize-w2redcode.size()), secondWarrior, w2redcode);
		
		
		RedcodeInterpreter alu = new RedcodeInterpreter(ram, firstWarrior, secondWarrior);
		this.alu = alu;
	}
	
	
	public void start() {
		alu.interpret();
	}
	
	
	
	public void startQuickImpDebugging() {
		this.firstWarrior = new Warrior("Foo");
		this.secondWarrior = new Warrior("Bar");
		this.w1redcode = this.loadRedcodeFile("C:/Users/Maruvert/Main/Prog/CoreWar/Imp.red");
		this.w2redcode = this.loadRedcodeFile("C:/Users/Maruvert/Main/Prog/CoreWar/Imp.red");
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
		
		this.w1redcode = this.loadRedcodeFile(r1);
		this.w2redcode = this.loadRedcodeFile(r2);
		
		
		
	}
	
	
	
	public LinkedList<RedcodeInstruction> loadRedcodeFile(String path) {
		RedcodeParser parser = new RedcodeParser();
		String redcode = FileUtils.fileToString(path);
		return parser.parse(redcode);
	}
	

	
	public void loadRedcodeInRam(Ram ram, int address, Warrior warrior, LinkedList<RedcodeInstruction> instructions) {
		ram.loadRedcode(address, instructions);
		warrior.initialize(address);
	}




	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}



	public LinkedList<RedcodeInstruction> getW1redcode() {
		return w1redcode;
	}




	public LinkedList<RedcodeInstruction> getW2redcode() {
		return w2redcode;
	}




	public void setFirstWarrior(Warrior firstWarrior) {
		this.firstWarrior = firstWarrior;
	}




	public void setSecondWarrior(Warrior secondWarrior) {
		this.secondWarrior = secondWarrior;
	}




	public RedcodeInterpreter getAlu() {
		return alu;
	}
	
	
	
	
	
	
	
	
	
}
