package by.epamtc.sinitsyna.task2.presentation;

import java.util.Arrays;

public class JaggedArrayView {
	public void printArray(String message, int[][] array) {
		System.out.println(message);
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
