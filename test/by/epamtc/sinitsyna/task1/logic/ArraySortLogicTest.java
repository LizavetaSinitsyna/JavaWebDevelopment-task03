package by.epamtc.sinitsyna.task1.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epamtc.sinitsyna.comparator.AscendingOrderComparator;
import by.epamtc.sinitsyna.comparator.DescendingOrderComparator;
import by.epamtc.sinitsyna.task1.bean.Array;

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
		ArraySortLogic.bubbleSort(actual, new AscendingOrderComparator());
		Assert.assertEquals(expectedForAscedingOrder, actual);

	}

	@Test
	public void testBubbleSortByPassingEmptyArray() {
		Array expected = new Array();
		Array actual = new Array();
		ArraySortLogic.bubbleSort(actual, new AscendingOrderComparator());
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testBubbleSortInDescendingOrder() {
		Array actual = array;
		ArraySortLogic.bubbleSort(actual, new DescendingOrderComparator());
		Assert.assertEquals(expectedForDescedingOrder, actual);

	}

	@Test
	public void testMergeSortInAscendingOrder() {
		Array actual = array;
		ArraySortLogic.mergeSort(actual, new AscendingOrderComparator());
		Assert.assertEquals(expectedForAscedingOrder, actual);
	}

	@Test
	public void testMergeSortInDescendingOrder() {
		Array actual = array;
		ArraySortLogic.mergeSort(actual, new DescendingOrderComparator());
		Assert.assertEquals(expectedForDescedingOrder, actual);
	}
	
	@Test
	public void testMergeSortByPassingNullArray() {
		Array expected = null;
		Array actual = null;
		ArraySortLogic.mergeSort(actual, new DescendingOrderComparator());
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testQuickSortInAscendingOrder() {
		Array actual = array;
		ArraySortLogic.quickSort(actual, new AscendingOrderComparator());
		Assert.assertEquals(expectedForAscedingOrder, actual);
	}

	@Test
	public void testQuickSortInDescendingOrder() {
		Array actual = array;
		ArraySortLogic.quickSort(actual, new DescendingOrderComparator());
		Assert.assertEquals(expectedForDescedingOrder, actual);
	}
	
	@Test
	public void testQuickSortByPassingEmptyArray() {
		Array expected = new Array();
		Array actual = new Array();
		ArraySortLogic.quickSort(actual, new DescendingOrderComparator());
		Assert.assertEquals(expected, actual);

	}

}
