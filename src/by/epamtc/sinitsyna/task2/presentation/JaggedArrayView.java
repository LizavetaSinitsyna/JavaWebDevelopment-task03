/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.presentation;

import java.util.Arrays;

import by.epamtc.sinitsyna.validation.ValidationHelper;

public class JaggedArrayView {
	public void printArray(String message, int[][] array) {
		if (message != null) {
			System.out.println(message);
		}
		if (ValidationHelper.isJaggedArrayEmptyOrNull(array)) {
			System.out.println("Array is empty.");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
