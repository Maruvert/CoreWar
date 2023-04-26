package corewar.model.utils;

import java.util.Random;

public class MathsUtils {
	
	public static int roundUp(float value) {
		return (int) Math.ceil(value / 100);
	}
	
	
	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max + 1 - min) + min;
	}

}
