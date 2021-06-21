/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.logic;

import by.epamtc.sinitsyna.validation.ValidationHelper;

public class MaxElementInLineSortingBase implements JaggedArraySortingBase {

	@Override
	public int[] retriveSortingBase(int[][] array) {
		if (!ValidationHelper.isArrayValid(array)) {
			return null;
		}

		int max;
		int[] maxElements = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (ValidationHelper.isArrayValid(array[i])) {
				max = array[i][0];
				for (int j = 1; j < array[i].length; j++) {
					if (array[i][j] > max) {
						max = array[i][j];
					}
				}
				maxElements[i] = max;
			}

		}

		return maxElements;
	}

}
