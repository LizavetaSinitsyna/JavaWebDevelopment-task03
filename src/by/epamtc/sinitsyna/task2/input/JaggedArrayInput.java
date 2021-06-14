/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.input;

import by.epamtc.sinitsyna.input.UserDataInput;

public class JaggedArrayInput {
	private UserDataInput input = new UserDataInput();

	public int[][] requestArray() {
		int[][] result;
		int size = requestArraySize("Please, enter the size of jagged array >>");
		result = new int[size][];
		for (int i = 0; i < result.length; i++) {
			size = requestArraySize(String.format("Please, enter the size of subarray №%d >>", i + 1));
			result[i] = new int[size];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = input.requestInt(String.format("Please, enter the subarray element №%d >>", j + 1));
			}
		}
		
		return result;

	}

	private int requestArraySize(String message) {
		int result = input.requestInt(message);
		while (!isPositive(result)) {
			System.out.println("Array size must be positive.");
			result = input.requestInt(message);
		}
		return result;
	}

	private boolean isPositive(int number) {
		return number >= 0;
	}

}
