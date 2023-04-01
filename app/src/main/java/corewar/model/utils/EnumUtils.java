package corewar.model.utils;

import java.util.Arrays;

/**
 * Enum utility methods
 * @author Maruvert
 *
 */
public class EnumUtils {
	
	
	public static String[] getNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}

	
}
