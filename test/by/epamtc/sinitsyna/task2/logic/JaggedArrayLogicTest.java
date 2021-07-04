package by.epamtc.sinitsyna.task2.logic;

import org.junit.Assert;
import org.junit.Test;

import by.epamtc.sinitsyna.comparator.AscendingOrderComparator;
import by.epamtc.sinitsyna.comparator.DescendingOrderComparator;

public class JaggedArrayLogicTest {

	@Test
	public void testSortByLinesSumDescendingOrder() {
		int[][] actual = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		int[][] expected = { { 6, 7, 8 }, { 3, -5, 10 }, { -4, 2, 3 }, null };
		JaggedArrayLogic.sort(actual, new LinesSumSortingBase(), new DescendingOrderComparator());
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testSortByMaxElementInLineAscendingOrderByPassingNullArray() {
		int[][] actual = null;
		int[][] expected = null;
		JaggedArrayLogic.sort(actual, new MaxElementInLineSortingBase(), new AscendingOrderComparator());
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testSortInAscendingOrderByPassingNullSortingBase() {
		int[][] actual = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		int[][] expected = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		JaggedArrayLogic.sort(actual, null, new AscendingOrderComparator());
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testSortByMaxElementInLineByPassingNullComparator() {
		int[][] actual = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		int[][] expected = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		JaggedArrayLogic.sort(actual, new MaxElementInLineSortingBase(), null);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testSortByMinElementInLineDescendingOrderByPassingEmptyArray() {
		int[][] actual = new int[0][];
		int[][] expected = {};
		JaggedArrayLogic.sort(actual, new MinElementInLineSortingBase(), new DescendingOrderComparator());
		Assert.assertArrayEquals(expected, actual);
	}

}
