package common.utils;

import org.jetbrains.annotations.Nullable;

/**
 * @author Tian MA
 */
public class Objects {

	/**
	 * Returns <code>value</code> if it is not null otherwise <code>defaultValue</code>
	 *
	 * @param value
	 * @param defaultValue
	 *
	 * @return
	 */
	public static <T> T or(@Nullable T value, @Nullable T defaultValue) {

		return value != null ? value : defaultValue;
	}

	public static void require(boolean condition, String msg) {

		if(!condition) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void require(boolean condition, RuntimeException exception) {

		if(!condition) {
			throw exception;
		}
	}

}
