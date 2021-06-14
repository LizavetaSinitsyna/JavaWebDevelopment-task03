/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.logic;

public class JaggedArrayLogic {
	public static void sortByLinesSum(int[][] array, boolean increase) {
		if (!isArrayValid(array)) {
			return;
		}
		int[] linesSum = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (isArrayValid(array[i])) {
				for (int j = 0; j < array[i].length; j++) {
					linesSum[i] += array[i][j];
				}
			}

		}

		sort(array, linesSum, increase);

	}

	public static void sortByMaxElementInLine(int[][] array, boolean increase) {
		if (array == null) {
			return;
		}

		int max;
		int[] maxElements = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (isArrayValid(array[i])) {
				max = array[i][0];
				for (int j = 1; j < array[i].length; j++) {
					if (array[i][j] > max) {
						max = array[i][j];
					}
				}
				maxElements[i] = max;
			}

		}

		sort(array, maxElements, increase);

	}

	public static void sortByMinElementInLine(int[][] array, boolean increase) {
		if (array == null) {
			return;
		}

		int min;
		int[] minElements = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (isArrayValid(array[i])) {
				min = array[i][0];
				for (int j = 1; j < array[i].length; j++) {
					if (array[i][j] < min) {
						min = array[i][j];
					}
				}
				minElements[i] = min;
			}

		}

		sort(array, minElements, increase);

	}

	private static void sort(int[][] array, int[] sortingBase, boolean increase) {
		for (int i = 0; i < sortingBase.length - 1; ++i) {
			for (int j = 0; j < sortingBase.length - i - 1; ++j) {
				if (increase && sortingBase[j] > sortingBase[j + 1]
						|| !increase && sortingBase[j] < sortingBase[j + 1]) {
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

	private static boolean isArrayValid(int[][] array) {
		return array != null;
	}

	private static boolean isArrayValid(int[] array) {
		return array != null;
	}

}
