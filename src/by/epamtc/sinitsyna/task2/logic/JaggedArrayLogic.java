/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.logic;

import java.util.Comparator;

import by.epamtc.sinitsyna.validation.ValidationHelper;

public class JaggedArrayLogic {

	public static void sort(int[][] array, JaggedArraySortingBase base, Comparator<Integer> comparator) {
		if (ValidationHelper.isNull(base) || ValidationHelper.isNull(array) || ValidationHelper.isNull(comparator)) {
			return;
		}
		int[] sortingBase = base.retriveSortingBase(array);
		if (sortingBase == null) {
			return;
		}
		for (int i = 0; i < sortingBase.length - 1; ++i) {
			for (int j = 0; j < sortingBase.length - i - 1; ++j) {
				if (comparator.compare(sortingBase[j], sortingBase[j + 1]) == 1) {
					swap(j, j + 1, array);
					swap(j, j + 1, sortingBase);

				}

			}
		}
	}

	private static void swap(int index1, int index2, int[][] array) {
		int temp[] = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
