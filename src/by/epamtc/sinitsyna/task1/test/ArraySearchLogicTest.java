package by.epamtc.sinitsyna.task1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epamtc.sinitsyna.task1.bean.Array;
import by.epamtc.sinitsyna.task1.exception.NonValidArrayException;
import by.epamtc.sinitsyna.task1.logic.ArraySearchLogic;

public class ArraySearchLogicTest {
	private Array array;

	@Before
	public void initArray() {
		array = new Array(new int[] { 1, 1, 2, 3, 4, 5, 556, 781, 897 });
	}

	@Test
	public void testBinarySearchLeftSide() {
		int expected = 2;
		int actual = ArraySearchLogic.binarySearch(array, 2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBinarySearchRightSide() {
		int expected = 7;
		int actual = ArraySearchLogic.binarySearch(array, 781);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBinarySearchWithNullArray() {
		int expected = -1;
		int actual = ArraySearchLogic.binarySearch(null, 4);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindMax() throws NonValidArrayException {
		int expected = 897;
		int actual;
		actual = ArraySearchLogic.findMax(array);
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = NonValidArrayException.class)
	public void testFindMaxWithNull() throws NonValidArrayException {
		Array array = new Array(0);
		int expected = 0;
		int actual;
		actual = ArraySearchLogic.findMax(array);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindMin() throws NonValidArrayException {
		int expected = 1;
		int actual;
		actual = ArraySearchLogic.findMin(array);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindPrimeNumbers() {
		Array expected = new Array(new int[] { 2, 3, 5 });
		Array actual;

		actual = ArraySearchLogic.findPrimeNumbers(array);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindFibonacciNumbers() throws NonValidArrayException {
		Array expected = new Array(new int[] { 1, 2, 3, 5 });
		Array actual;

		actual = ArraySearchLogic.findFibonacciNumbers(array);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindNumbersWith3UniqueDigits() {
		Array expected = new Array(new int[] { 781, 897 });
		Array actual;

		actual = ArraySearchLogic.findNumbersWith3UniqueDigits(array);

		Assert.assertEquals(expected, actual);
	}

}
