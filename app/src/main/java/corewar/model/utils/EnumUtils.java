package corewar.model.utils;

import java.util.Arrays;

/**
 * Enum utility methods
 *
 */
public class EnumUtils {
	
	
	/**
	 * Return a list of the name of all constants in an enum
	 * @param e The enum class
	 * @return A String[] that contains all constant names
	 */
	public static String[] getNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}

	
}
