package corewar.model;

import java.util.Arrays;

public class EnumUtils {
	
	
	public static String[] getNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}

	
}
