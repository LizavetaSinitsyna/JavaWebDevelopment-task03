/*Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тримя способами.
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
3. Нахождение максимального и минимального элемента массива.
4. Получить все простые числа находящиеся в массиве.
5. Получить все числа Фибонначчи находящиеся в массиве.
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.*/

package by.epamtc.sinitsyna.task1.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import by.epamtc.sinitsyna.task1.bean.Array;
import by.epamtc.sinitsyna.input.UserDataInput;

public class ArrayInput {
	private final static int RANDOM_LIMIT = 100;

	private UserDataInput input = new UserDataInput();

	public Array requestArray() {
		int element;
		int size = input.requestInt("Please, enter array size >>");
		while (!isPositive(size)) {
			System.out.println("Array size must be positive.");
			size = input.requestInt("Please, enter array size >>");
		}

		Array array = new Array(size);
		for (int i = 1; i <= size; i++) {
			element = input.requestInt("Please, enter number to add >>");
			array.add(element);
		}
		return array;

	}

	public Array readArrayFromFile() {
		Array array = new Array();
		String filePath = input.requestString("Please enter the file path >>");
		File file = new File(filePath);
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextInt()) {
				array.add(scanner.nextInt());
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return array;

	}

	public Array generateArray() {
		Random random = new Random();
		int element;
		int size = random.nextInt(RANDOM_LIMIT);
		Array array = new Array(size);
		for (int i = 1; i <= size; i++) {
			element = random.nextInt(RANDOM_LIMIT);
			array.add(element);
		}
		return array;

	}

	private boolean isPositive(int number) {
		return number >= 0;
	}

}
