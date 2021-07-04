package by.epamtc.sinitsyna.validation;

public class ValidationHelper {

	public static boolean isJaggedArrayEmptyOrNull(int[][] array) {
		return isNull(array) || isJaggedArrayEmpty(array);
	}

	public static boolean isArrayEmptyOrNull(int[] array) {
		return isNull(array) || isArrayEmpty(array);
	}

	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isJaggedArrayEmpty(int[][] array) {
		return array.length == 0;
	}

	public static boolean isArrayEmpty(int[] array) {
		return array.length == 0;
	}

	public static boolean isPositive(int element) {
		return element >= 0;
	}

}
