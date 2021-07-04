package by.epamtc.sinitsyna.task1.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epamtc.sinitsyna.task1.bean.Array;
import by.epamtc.sinitsyna.task1.exception.NonValidArrayException;

public class ArraySearchLogicTest {
	private Array array;

	@Before
	public void initArray() {
		array = new Array(new int[] { -5, 0, 1, 1, 2, 3, 4, 5, 556, 781, 897, 1011, 1234 });
	}

	@Test
	public void testBinarySearchLeftSide() {
		int expected = 4;
		int actual = ArraySearchLogic.binarySearch(array, 2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBinarySearchRightSide() {
		int expected = 9;
		int actual = ArraySearchLogic.binarySearch(array, 781);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBinarySearchByPassingNullArray() {
		int expected = -1;
		int actual = ArraySearchLogic.binarySearch(null, 4);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBinarySearchBySearchingNonExistedElement() {
		int expected = -1;
		int actual = ArraySearchLogic.binarySearch(array, 101);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindMax() throws NonValidArrayException {
		int expected = 1234;
		int actual;
		actual = ArraySearchLogic.findMax(array);
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = NonValidArrayException.class)
	public void testFindMaxPassingEmptyArray() throws NonValidArrayException {
		Array array = new Array(0);
		ArraySearchLogic.findMax(array);

	}

	@Test
	public void testFindMin() throws NonValidArrayException {
		int expected = -5;
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
	public void testFindPrimeNumbersByPassingNullArray() {
		Array array = null;
		Array expected = new Array();
		Array actual;

		actual = ArraySearchLogic.findPrimeNumbers(array);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindFibonacciNumbers() throws NonValidArrayException {
		Array expected = new Array(new int[] { 0, 1, 2, 3, 5 });
		Array actual;

		actual = ArraySearchLogic.findFibonacciNumbers(array);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindFibonacciNumbersByPassingNullArray() throws NonValidArrayException {
		Array array = null;
		Array expected = new Array();
		Array actual;

		actual = ArraySearchLogic.findFibonacciNumbers(array);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testFindFibonacciNumbersByPassingArrayWithNegativeElements() throws NonValidArrayException {
		Array array = new Array(new int[] { -1, -1, -2, -3, -4, -5 });
		Array expected = new Array();
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

	@Test
	public void testFindNumbersWith3UniqueDigitsByPassingNullArray() {
		Array array = null;
		Array expected = new Array();
		Array actual;

		actual = ArraySearchLogic.findNumbersWith3UniqueDigits(array);

		Assert.assertEquals(expected, actual);
	}

}
