package by.epamtc.sinitsyna.task1.logic;

import by.epamtc.sinitsyna.task1.bean.Array;

public class ArrayValidation {
	
	public static boolean isEmptyOrNull(Array array) {
		return isNull(array) || array.isEmpty();
	}

	public static boolean isNull(Array array) {
		return array == null;
	}

}
