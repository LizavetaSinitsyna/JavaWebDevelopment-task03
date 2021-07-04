package by.epamtc.sinitsyna.task2.logic;

import org.junit.Assert;
import org.junit.Test;

public class MaxElementInLineSortingBaseTest {

	@Test
	public void testRetriveSortingBase() {
		int[][] array = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		int[] expected = { 10, 8, 3, 0 };
		int[] actual = new MaxElementInLineSortingBase().retriveSortingBase(array);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testRetriveSortingBaseByPassingNullArray() {
		int[][] array = null;
		int[] expected = null;
		int[] actual = new MaxElementInLineSortingBase().retriveSortingBase(array);
		Assert.assertArrayEquals(expected, actual);
	}

}
