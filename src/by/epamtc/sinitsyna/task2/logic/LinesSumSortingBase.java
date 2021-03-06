/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.logic;

import by.epamtc.sinitsyna.validation.ValidationHelper;

public class LinesSumSortingBase implements JaggedArraySortingBase {

	@Override
	public int[] retriveSortingBase(int[][] array) {
		if (ValidationHelper.isJaggedArrayEmptyOrNull(array)) {
			return null;
		}
		int[] linesSum = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (!ValidationHelper.isArrayEmptyOrNull(array[i])) {
				for (int j = 0; j < array[i].length; j++) {
					linesSum[i] += array[i][j];
				}
			}

		}

		return linesSum;
	}

}
