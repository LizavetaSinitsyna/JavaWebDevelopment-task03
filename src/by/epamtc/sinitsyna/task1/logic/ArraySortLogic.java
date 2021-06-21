/*Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тримя способами.
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
3. Нахождение максимального и минимального элемента массива.
4. Получить все простые числа находящиеся в массиве.
5. Получить все числа Фибонначчи находящиеся в массиве.
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.*/

package by.epamtc.sinitsyna.task1.logic;

import by.epamtc.sinitsyna.task1.bean.Array;
import by.epamtc.sinitsyna.task1.exception.IndexOutOfBoundsException;

public class ArraySortLogic {
	public static void bubbleSort(Array array, boolean increase) {
		if (ArrayValidation.isEmptyOrNull(array)) {
			return;
		}
		for (int i = 0; i < array.getCurrentLength() - 1; ++i) {
			for (int j = 0; j < array.getCurrentLength() - i - 1; ++j) {
				try {
					if (increase && array.get(j) > array.get(j + 1) || !increase && array.get(j) < array.get(j + 1)) {
						swap(j, j + 1, array);
					}
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}

			}
		}
	}

	private static void swap(int index1, int index2, Array array) {
		int temp;
		try {
			temp = array.get(index1);
			array.set(array.get(index2), index1);
			array.set(temp, index2);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

	public static void mergeSort(Array array, boolean increase) {
		if (ArrayValidation.isEmptyOrNull(array)) {
			return;
		}
		executeMergeSort(increase, 0, array.getCurrentLength() - 1, array);
	}

	private static void executeMergeSort(boolean increase, int left, int right, Array array) {
		if (left < right) {
			int middle = left + (right - left) / 2;

			executeMergeSort(increase, left, middle, array);
			executeMergeSort(increase, middle + 1, right, array);

			merge(increase, left, middle, right, array);
		}
	}

	private static void merge(boolean increase, int left, int middle, int right, Array array) {
		int leftLength = middle - left + 1;
		int rightLength = right - middle;

		int[] leftSubArray = new int[leftLength];
		int[] rightSubArray = new int[rightLength];

		try {
			for (int i = 0; i < leftLength; ++i) {

				leftSubArray[i] = array.get(left + i);
			}
			for (int i = 0; i < rightLength; ++i) {
				rightSubArray[i] = array.get(middle + 1 + i);
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < leftLength && j < rightLength) {
			if (increase) {
				if (leftSubArray[i] > rightSubArray[j]) {
					array.set(rightSubArray[j], k);
					j++;
				} else {
					array.set(leftSubArray[i], k);
					i++;
				}
			} else {
				if (leftSubArray[i] > rightSubArray[j]) {
					array.set(leftSubArray[i], k);
					i++;
				} else {
					array.set(rightSubArray[j], k);
					j++;
				}
			}
			k++;
		}

		while (i < leftLength) {
			array.set(leftSubArray[i], k);
			++i;
			++k;
		}

		while (j < rightLength) {
			array.set(rightSubArray[j], k);
			++j;
			++k;
		}

	}

	public static void quickSort(Array array, boolean increase) {
		if (ArrayValidation.isEmptyOrNull(array)) {
			return;
		}
		executeQuickSort(array, increase, 0, array.getCurrentLength() - 1);
	}

	private static void executeQuickSort(Array array, boolean increase, int left, int right) {
		int i = left;
		int j = right;

		int pivot;
		try {
			pivot = array.get(left + (right - left) / 2);

			while (i <= j) {
				if (increase) {
					while (array.get(i) < pivot) {
						++i;
					}

					while (array.get(j) > pivot) {
						--j;
					}
				} else {
					while (array.get(i) > pivot) {
						++i;
					}

					while (array.get(j) < pivot) {
						--j;
					}
				}

				if (i <= j) {
					swap(i, j, array);
					++i;
					--j;
				}

			}

			if (left < j) {
				executeQuickSort(array, increase, left, j);
			}

			if (i < right) {
				executeQuickSort(array, increase, i, right);
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

}
