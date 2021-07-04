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

import by.epamtc.sinitsyna.task1.exception.IndexOutOfBoundsException;
import by.epamtc.sinitsyna.validation.ValidationHelper;

public class Array implements Serializable, Iterable<Integer> {

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_CAPACITY = 16;
	private static final int MIN_FREE_CAPACITY = 1;
	/**
	 * Max capacity is equal to the maximum possible size of an array which is
	 * Integer.MAX_VALUE-2.
	 */
	private static final int MAX_CAPACITY = Integer.MAX_VALUE - 2;

	private int[] value;
	private int currentLength;

	public Array() {
		setValueByDefault();
	}

	public Array(int[] value) {
		if (!ValidationHelper.isNull(value)) {
			this.currentLength = value.length;
			this.value = copy(value.length, value);
		} else {
			setValueByDefault();
		}

	}

	public Array(int size) {
		if (isSizeValid(size)) {
			value = new int[size];
		} else {
			setValueByDefault();
		}

	}

	private void setValueByDefault() {
		value = new int[DEFAULT_CAPACITY];
	}

	public int[] getValue() {
		return copy(currentLength, value);
	}

	@Override
	public Iterator<Integer> iterator() {
		Iterator<Integer> iterator = new Iterator<Integer>() {
			private int element = 0;

			@Override
			public boolean hasNext() {
				return currentLength > element;
			}

			@Override
			public Integer next() {
				return value[element++];
			}
		};

		return iterator;
	}

	public boolean setValue(int[] value) {
		if (!ValidationHelper.isNull(value)) {
			this.currentLength = value.length;
			this.value = copy(currentLength, value);
			return true;
		}
		return false;

	}

	public int getCurrentLength() {
		return currentLength;
	}

	public boolean setCurrentLength(int newLength) {
		int lengthDif = newLength - currentLength;
		if (lengthDif > 0 && ensureCapacity(lengthDif)) {
			for (int i = currentLength; i < newLength; i++) {
				value[i] = 0;
			}
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

	public boolean set(int element, int position) {
		if (isIndexValid(position)) {
			value[position] = element;
			return true;
		}
		return false;
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
		if (!isEmpty() && isIndexValid(position)) {
			shiftToTheLeft(position);
			currentLength--;
			return true;
		}
		return false;
	}

	private void shiftToTheLeft(int deletedElementPosition) {
		for (int i = deletedElementPosition; i < currentLength - 1; ++i) {
			value[i] = value[i + 1];
		}
	}

	public boolean contains(int element) {
		for (int i = 0; i < currentLength; i++) {
			if (value[i] == element) {
				return true;
			}
		}
		return false;

	}

	private boolean ensureCapacity(int elementsAmountToAdd) {
		if (value.length > MAX_CAPACITY - elementsAmountToAdd) {
			return false;
		}
		int requiredMinCapacity = currentLength + elementsAmountToAdd;

		if (requiredMinCapacity <= value.length) {
			return true;
		}

		int newCapacity;

		if (requiredMinCapacity > MAX_CAPACITY / 2) {
			newCapacity = MAX_CAPACITY;
		} else {
			newCapacity = value.length * 2;
		}
		value = copy(newCapacity, value);

		return true;

	}

	private int[] copy(int requiredCapacity, int[] array) {
		int[] arrayCopy = new int[requiredCapacity];
		for (int i = 0; i < currentLength; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;

	}

	public boolean isEmpty() {
		return currentLength == 0;
	}

	private boolean isIndexValid(int index) {
		return ValidationHelper.isPositive(index) && index < currentLength;
	}

	private boolean isSizeValid(int index) {
		return ValidationHelper.isPositive(index) && index <= MAX_CAPACITY;
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
		for (int i = 0; i < currentLength; i++) {
			if (value[i] != other.value[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [value=" + Arrays.toString(value) + ", length=" + currentLength + "]";
	}

}
