package by.epamtc.sinitsyna.task1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epamtc.sinitsyna.task1.bean.Array;
import by.epamtc.sinitsyna.task1.logic.ArraySortLogic;

public class ArraySortLogicTest {
	private Array array;

	private final Array expectedForAscedingOrder = new Array(new int[] { -5, 7, 8, 10, 11, 12, 13, 14, 15, 21, 23 });
	private final Array expectedForDescedingOrder = new Array(new int[] { 23, 21, 15, 14, 13, 12, 11, 10, 8, 7, -5 });

	@Before
	public void initArray() {
		array = new Array(new int[] { 15, 12, 14, 13, 7, 11, 10, 23, 21, -5, 8 });
	}

	@Test
	public void testBubbleSortInAscendingOrder() {
		Array actual = array;
		ArraySortLogic.bubbleSort(actual, true);
		Assert.assertEquals(expectedForAscedingOrder, actual);

	}

	@Test
	public void testBubbleSortInDescendingOrder() {
		Array actual = array;
		ArraySortLogic.bubbleSort(actual, false);
		Assert.assertEquals(expectedForDescedingOrder, actual);

	}

	@Test
	public void testMergeSortInAscendingOrder() {
		Array actual = array;
		ArraySortLogic.mergeSort(actual, true);
		Assert.assertEquals(expectedForAscedingOrder, actual);
	}

	@Test
	public void testMergeSortInDescendingOrder() {
		Array actual = array;
		ArraySortLogic.mergeSort(actual, false);
		Assert.assertEquals(expectedForDescedingOrder, actual);
	}

	@Test
	public void testQuickSortInAscendingOrder() {
		Array actual = array;
		ArraySortLogic.quickSort(actual, true);
		Assert.assertEquals(expectedForAscedingOrder, actual);
	}

	@Test
	public void testQuickSortInDescendingOrder() {
		Array actual = array;
		ArraySortLogic.quickSort(actual, false);
		Assert.assertEquals(expectedForDescedingOrder, actual);
	}

}
