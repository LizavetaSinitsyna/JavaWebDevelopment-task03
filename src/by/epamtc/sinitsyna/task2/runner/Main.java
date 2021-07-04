/*Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы;
• в порядке возрастания (убывания) максимальных элементов строк матрицы;
• в порядке возрастания (убывания) минимальных элементов строк матрицы.*/

package by.epamtc.sinitsyna.task2.runner;

import java.util.Comparator;

import by.epamtc.sinitsyna.comparator.AscendingOrderComparator;
import by.epamtc.sinitsyna.comparator.DescendingOrderComparator;
import by.epamtc.sinitsyna.task2.input.JaggedArrayInput;
import by.epamtc.sinitsyna.task2.logic.JaggedArrayLogic;
import by.epamtc.sinitsyna.task2.logic.JaggedArraySortingBase;
import by.epamtc.sinitsyna.task2.logic.LinesSumSortingBase;
import by.epamtc.sinitsyna.task2.logic.MaxElementInLineSortingBase;
import by.epamtc.sinitsyna.task2.logic.MinElementInLineSortingBase;
import by.epamtc.sinitsyna.task2.presentation.JaggedArrayView;

public class Main {

	public static void main(String[] args) {
		JaggedArrayInput input = new JaggedArrayInput();
		JaggedArrayView view = new JaggedArrayView();
		
		Comparator<Integer> ascendingOrder = new AscendingOrderComparator();
		Comparator<Integer> descendingOrder = new DescendingOrderComparator();

		int[][] array = input.requestArray();
		view.printArray("Initial array content: ", array);

		JaggedArraySortingBase linesSumSortingBase = new LinesSumSortingBase();
		JaggedArraySortingBase maxElementInLineSortingBase = new MaxElementInLineSortingBase();
		JaggedArraySortingBase minElementInLineSortingBase = new MinElementInLineSortingBase();

		System.out.println("Sorting by sum of elements in line (ascending order) demo >");
		JaggedArrayLogic.sort(array, linesSumSortingBase, ascendingOrder);
		view.printArray("Array content after sorting: ", array);

		System.out.println("Sorting by sum of elements in line (descending order) demo >");
		JaggedArrayLogic.sort(array, linesSumSortingBase, descendingOrder);
		view.printArray("Array content after sorting: ", array);

		System.out.println("Sorting by max element in line (ascending order) demo >");
		JaggedArrayLogic.sort(array, maxElementInLineSortingBase, ascendingOrder);
		view.printArray("Array content after sorting: ", array);

		System.out.println("Sorting by max element in line (descending order) demo >");
		JaggedArrayLogic.sort(array, maxElementInLineSortingBase, descendingOrder);
		view.printArray("Array content after sorting: ", array);

		System.out.println("Sorting by min element in line (ascending order) demo >");
		JaggedArrayLogic.sort(array, minElementInLineSortingBase, ascendingOrder);
		view.printArray("Array content after sorting: ", array);

		System.out.println("Sorting by min element in line (descending order) demo >");
		JaggedArrayLogic.sort(array, minElementInLineSortingBase, descendingOrder);
		view.printArray("Array content after sorting: ", array);

	}

}
