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
import by.epamtc.sinitsyna.task1.exception.NonValidArrayException;

public class ArrayLogic {
	public static int binarySearch(Array sortedArray, int element) {
		if (isNull(sortedArray)) {
			return -1;
		}
		int middle;
		int left = 0;
		int right = sortedArray.getCurrentLength() - 1;

		while (left <= right) {
			middle = left + (right - left) / 2;

			try {
				if (sortedArray.get(middle) == element) {
					return middle;
				}

				if (sortedArray.get(middle) < element) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		}

		return -1;
	}

	public static int findMax(Array array) throws NonValidArrayException {
		int max = Integer.MIN_VALUE;
		if (isEmptyOrNull(array)) {
			throw new NonValidArrayException("Array can't be null or with length = 0.");
		}
		try {
			max = array.get(0);
			for (int i = 1; i < array.getCurrentLength(); i++) {
				if (array.get(i) > max) {
					max = array.get(i);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		return max;

	}

	public static int findMin(Array array) throws NonValidArrayException {
		if (isEmptyOrNull(array)) {
			throw new NonValidArrayException("Array can't be null or with length = 0.");
		}
		int min = Integer.MAX_VALUE;
		try {
			min = array.get(0);
			for (int i = 1; i < array.getCurrentLength(); i++) {
				if (array.get(i) < min) {
					min = array.get(i);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		return min;

	}

	public static Array findSimpleNumbers(Array array) throws NonValidArrayException {
		if (isNull(array)) {
			throw new NonValidArrayException("Array can't be null.");
		}
		int number;
		Array simpleNumbers = new Array();
		try {
			for (int i = 0; i < array.getCurrentLength(); i++) {
				number = (array.get(i));
				if (isSimple(number)) {
					simpleNumbers.add(number);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		return simpleNumbers;

	}

	public static boolean isSimple(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static Array findFibonacciNumbers(Array array) throws NonValidArrayException {
		Array fibonacciNumbers = new Array();
		if (isNull(array)) {
			return fibonacciNumbers;
		}

		int maxNumber = findMax(array);
		if (maxNumber < 0) {
			return fibonacciNumbers;
		}

		int temp1 = 0;
		int temp2 = 1;
		int fibonacci = temp1 + temp2;
		if (array.contains(temp1)) {
			fibonacciNumbers.add(temp1);
		}
		while (fibonacci <= maxNumber) {
			if (array.contains(fibonacci)) {
				fibonacciNumbers.add(fibonacci);
			}
			temp1 = fibonacci;
			fibonacci = fibonacci + temp2;
			temp2 = temp1;
		}

		return fibonacciNumbers;

	}

	public static Array findNumbersWith3UniqueDigits(Array array) throws NonValidArrayException {
		Array result = new Array();

		if (isNull(array)) {
			return result;
		}

		int number;

		try {
			for (int i = 0; i < array.getCurrentLength(); i++) {
				number = Math.abs(array.get(i));
				if (number > 100 && number < 999 && containsUniqueDigits(number)) {
					result.add(number);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

		return result;

	}

	private static int[] retrieveDigits(int number) {
		int[] digits = new int[Integer.toString(Math.abs(number)).length()];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = number % 10;
			number /= 10;
		}
		return digits;
	}

	private static boolean containsUniqueDigits(int number) {
		int[] digits = retrieveDigits(number);
		for (int i = 0; i < digits.length - 1; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[i] == digits[j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isEmptyOrNull(Array array) {
		return isNull(array) || array.isEmpty();
	}

	private static boolean isNull(Array array) {
		return array == null;
	}
}
