/*Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тримя способами.
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
3. Нахождение максимального и минимального элемента массива.
4. Получить все простые числа находящиеся в массиве.
5. Получить все числа Фибонначчи находящиеся в массиве.
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.*/

package by.epamtc.sinitsyna.task1.runner;

import by.epamtc.sinitsyna.input.UserDataInput;
import by.epamtc.sinitsyna.task1.bean.Array;
import by.epamtc.sinitsyna.task1.exception.NonValidArrayException;
import by.epamtc.sinitsyna.task1.input.ArrayInput;
import by.epamtc.sinitsyna.task1.logic.ArrayLogic;
import by.epamtc.sinitsyna.task1.presenation.ArrayView;

public class Main {

	public static void main(String[] args) {
		ArrayInput arrayInput = new ArrayInput();
		UserDataInput input = new UserDataInput();

		// 7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации
		// случайных чисел.
		Array consoleArray = arrayInput.requestArray();
		ArrayView.printArray("ConsoleArray: ", consoleArray);
		Array fileArray = arrayInput.readArrayFromFile();
		ArrayView.printArray("FileArray: ", fileArray);
		Array randomArray = arrayInput.generateArray();
		ArrayView.printArray("RandomArray: ", randomArray);

		// 1. Сортировать массив тримя способами.
		System.out.println("Bubble sort demo >");
		consoleArray.bubbleSort(true);
		ArrayView.printArray("ConsoleArray sorted in asscending order: ", consoleArray);
		consoleArray.bubbleSort(false);
		ArrayView.printArray("ConsoleArray sorted in descending order: ", consoleArray);

		System.out.println("Merge sort demo >");
		fileArray.mergeSort(true);
		ArrayView.printArray("FileArray sorted in ascending order: ", fileArray);
		fileArray.mergeSort(false);
		ArrayView.printArray("FileArray sorted in descending order: ", fileArray);

		System.out.println("Quick sort demo >");
		randomArray.quickSort(false);
		ArrayView.printArray("RandomArray sorted in descending order: ", randomArray);
		randomArray.quickSort(true);
		ArrayView.printArray("RandomArray sorted in ascending order: ", randomArray);

		// 2. Осуществлять поиск элемента массива (использовать алгоритм бинарного
		// поиска).
		System.out.println("Binary search in RandomArray sorted in ascending order demo >");
		int elementToSearch = input.requestInt("Please, enter a number to search >>");
		int result = ArrayLogic.binarySearch(randomArray, elementToSearch);
		if (result == -1) {
			System.out.println("No such element.");
		} else {
			System.out.printf("Index of the searched element is %d.\n", result);
		}

		try {
			// 3. Нахождение максимального и минимального элемента массива.
			System.out.println("Max/min search in ConsoleArray demo >");

			System.out.printf("Max element = %d, min element = %d.\n", ArrayLogic.findMax(consoleArray),
					ArrayLogic.findMin(consoleArray));

			// 4. Получить все простые числа находящиеся в массиве.
			System.out.println("Prime numbers search in ConcoleArray demo >");
			Array primeNumbers;

			primeNumbers = ArrayLogic.findSimpleNumbers(consoleArray);

			ArrayView.printArray("Prime numbers from ConsoleArray: ", primeNumbers);

			// 5. Получить все числа Фибонначчи находящиеся в массиве
			System.out.println("Fibonacci numbers search in ConsoleArray demo >");
			Array fibonacciNumbers = ArrayLogic.findFibonacciNumbers(consoleArray);
			ArrayView.printArray("Fibonacci numbers from ConsoleArray: ", fibonacciNumbers);

			// 6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых
			// цифр.
			System.out.println("Search for numbers with unique digits in ConsoleArray demo >");
			Array numbersWithUniqueDigits = ArrayLogic.findNumbersWith3UniqueDigits(consoleArray);
			ArrayView.printArray("Numbers with 3 unique digits from ConsoleArray: ", numbersWithUniqueDigits);
		} catch (NonValidArrayException e) {
			e.getMessage();
		}

	}

}