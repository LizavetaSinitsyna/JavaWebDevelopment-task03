/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.validation;

public class ValidationHelper {

	public static boolean isArrayValid(int[][] array) {
		if (array == null) {
			return false;
		}
		return array.length > 0;
	}

	public static boolean isArrayValid(int[] array) {
		if (isArrayNull(array)) {
			return false;
		}
		return array.length > 0;
	}

	public static boolean isArrayNull(int[] array) {
		return array == null;
	}

	public static boolean isPositive(int element) {
		return element >= 0;
	}

}
