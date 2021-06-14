/*Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тримя способами.
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
3. Нахождение максимального и минимального элемента массива.
4. Получить все простые числа находящиеся в массиве.
5. Получить все числа Фибонначчи находящиеся в массиве.
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.*/

package by.epamtc.sinitsyna.task1.presenation;

import java.util.Arrays;

import by.epamtc.sinitsyna.task1.bean.Array;

public class ArrayView {
	public static void printArray(String message, Array array) {
		System.out.print(message);
		if (array.isEmpty()) {
			System.out.println("Array is empty");
			return;
		}
		System.out.printf("Array contains the following %d elements: ", array.getCurrentLength());
		int[] value = array.getValue();
		System.out.println(Arrays.toString(value));

	}

}
