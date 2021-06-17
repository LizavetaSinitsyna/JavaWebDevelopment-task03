/*Создание типа Array, который является классом оболочкой над массивом целого типа. В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тримя способами.
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
3. Нахождение максимального и минимального элемента массива.
4. Получить все простые числа находящиеся в массиве.
5. Получить все числа Фибонначчи находящиеся в массиве.
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.*/

package by.epamtc.sinitsyna.task1.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import by.epamtc.sinitsyna.task1.exception.NonValidArrayException;
import by.epamtc.sinitsyna.task1.exception.IndexOutOfBoundsException;

public class Array implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_CAPACITY = 16;
	private static final int MIN_FREE_CAPACITY = 1;

	private int[] value;
	private int currentLength;

	public Array() {
		value = new int[DEFAULT_CAPACITY];
	}

	public Array(int[] value) throws NonValidArrayException {
		if (!isArrayValid(value)) {
			throw new NonValidArrayException("Array can't be equal to null");
		}
		this.value = value;
		this.currentLength = value.length;
	}

	public Array(int size) {
		value = new int[size];
	}

	public int[] getValue() {
		return copy(currentLength);
	}

	public Iterator<Integer> retriveValueIterator() {
		Iterator<Integer> iterator = new Iterator<Integer>() {
			private int element = 0;

			@Override
			public boolean hasNext() {
				return value.length > element;
			}

			@Override
			public Integer next() {
				return value[element++];
			}
		};

		return iterator;
	}

	public boolean setValue(int[] value) {
		if (isArrayValid(value)) {
			this.value = value;
			this.currentLength = value.length;
			return true;
		}
		return false;

	}

	public int getCurrentLength() {
		return currentLength;
	}

	public boolean setCurrentLength(int newLength) {
		int lengthDif = newLength - currentLength;
		if (newLength > currentLength && ensureCapacity(lengthDif)) {
			currentLength = newLength;
			return true;
		}
		return false;

	}

	public int retrieveCapacity() {
		return value.length;
	}

	public int get(int index) throws IndexOutOfBoundsException {
		if (!isIndexValid(index)) {
			throw new IndexOutOfBoundsException("Index can't be less than 0 or larger than array's length.");
		}
		return value[index];
	}

	public boolean add(int element) {
		return insert(element, currentLength);
	}

	public boolean insert(int element, int position) {
		if ((position == currentLength || isIndexValid(position)) && ensureCapacity(MIN_FREE_CAPACITY)) {
			shiftToTheRight(position);
			value[position] = element;
			currentLength++;
			return true;
		}
		return false;
	}

	private void shiftToTheRight(int addedElementPosition) {
		for (int i = currentLength; i > addedElementPosition; --i) {
			value[i] = value[i - 1];
		}
	}

	public void remove() {
		remove(currentLength - 1);
	}

	public boolean remove(int position) {
		if (currentLength > 0 && isIndexValid(position)) {
			if (position < currentLength - 1) {
				shiftToTheLeft(position);
			}
			currentLength--;
			return true;
		}
		return false;
	}

	private void shiftToTheLeft(int deletedElementPosition) {
		for (int i = deletedElementPosition; i < currentLength; ++i) {
			value[i] = value[i + 1];
		}
	}

	public boolean contains(int element) {
		if (isEmpty()) {
			return false;
		}
		for (int i = 0; i < currentLength; i++) {
			if (value[i] == element) {
				return true;
			}
		}

		return false;

	}

	public void bubbleSort(boolean increase) {
		for (int i = 0; i < currentLength - 1; ++i) {
			for (int j = 0; j < currentLength - i - 1; ++j) {
				if (increase && value[j] > value[j + 1] || !increase && value[j] < value[j + 1]) {
					swap(j, j + 1, value);

				}

			}
		}
	}

	private void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public void mergeSort(boolean increase) {
		executeMergeSort(increase, 0, currentLength - 1, value);
	}

	private void executeMergeSort(boolean increase, int left, int right, int[] array) {
		if (left < right) {
			int middle = left + (right - left) / 2;

			executeMergeSort(increase, left, middle, array);
			executeMergeSort(increase, middle + 1, right, array);

			merge(increase, left, middle, right, array);
		}
	}

	private void merge(boolean increase, int left, int middle, int right, int[] array) {
		int leftLength = middle - left + 1;
		int rightLength = right - middle;

		int[] leftSubArray = new int[leftLength];
		int[] rightSubArray = new int[rightLength];

		for (int i = 0; i < leftLength; ++i) {
			leftSubArray[i] = array[left + i];
		}
		for (int i = 0; i < rightLength; ++i) {
			rightSubArray[i] = array[middle + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < leftLength && j < rightLength) {
			if (increase) {
				if (leftSubArray[i] > rightSubArray[j]) {
					array[k] = rightSubArray[j];
					j++;
				} else {
					array[k] = leftSubArray[i];
					i++;
				}
			} else {
				if (leftSubArray[i] > rightSubArray[j]) {
					array[k] = leftSubArray[i];
					i++;
				} else {
					array[k] = rightSubArray[j];
					j++;
				}
			}
			k++;
		}

		while (i < leftLength) {
			array[k] = leftSubArray[i];
			++i;
			++k;
		}

		while (j < rightLength) {
			array[k] = rightSubArray[j];
			++j;
			++k;
		}

	}

	public void quickSort(boolean increase) {
		executeQuickSort(increase, 0, currentLength - 1);
	}

	private void executeQuickSort(boolean increase, int left, int right) {
		int i = left;
		int j = right;

		int pivot = value[left + (right - left) / 2];

		while (i <= j) {
			if (increase) {
				while (value[i] < pivot) {
					++i;
				}

				while (value[j] > pivot) {
					--j;
				}
			} else {
				while (value[i] > pivot) {
					++i;
				}

				while (value[j] < pivot) {
					--j;
				}
			}

			if (i <= j) {
				swap(i, j, value);
				++i;
				--j;
			}

		}

		if (left < j) {
			executeQuickSort(increase, left, j);
		}

		if (i < right) {
			executeQuickSort(increase, i, right);
		}
	}

	private boolean ensureCapacity(int elementsAmountToAdd) {
		if (value.length > Integer.MAX_VALUE - elementsAmountToAdd) {
			return false;
		}
		int requiredMinCapacity = currentLength + elementsAmountToAdd;

		if (requiredMinCapacity <= value.length) {
			return true;
		}

		int newCapacity;

		if (requiredMinCapacity > Integer.MAX_VALUE / 2) {
			newCapacity = Integer.MAX_VALUE;
		} else {
			newCapacity = value.length * 2;
		}
		value = copy(newCapacity);

		return true;

	}

	private int[] copy(int requiredCapacity) {
		int[] arrayCopy = new int[requiredCapacity];
		for (int i = 0; i < currentLength; i++) {
			arrayCopy[i] = value[i];
		}
		return arrayCopy;

	}

	private boolean isArrayValid(int[] value) {
		return value != null;
	}

	private boolean isIndexValid(int index) {
		return index >= 0 && index < currentLength;
	}

	public boolean isEmpty() {
		return currentLength == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentLength;
		result = prime * result + Arrays.hashCode(value);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Array other = (Array) obj;
		if (currentLength != other.currentLength)
			return false;
		if (!Arrays.equals(value, other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [value=" + Arrays.toString(value) + ", length=" + currentLength + "]";
	}

}
