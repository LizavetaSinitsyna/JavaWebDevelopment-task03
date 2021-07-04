package by.epamtc.sinitsyna.task2.logic;

import org.junit.Assert;
import org.junit.Test;

public class MinElementInLineSortingBaseTest {

	@Test
	public void testRetriveSortingBase() {
		int[][] array = { { 3, -5, 10 }, { 6, 7, 8 }, { -4, 2, 3 }, null };
		int[] expected = { -5, 6, -4, 0 };
		int[] actual = new MinElementInLineSortingBase().retriveSortingBase(array);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testRetriveSortingBaseByPassingNullArray() {
		int[][] array = null;
		int[] expected = null;
		int[] actual = new MinElementInLineSortingBase().retriveSortingBase(array);
		Assert.assertArrayEquals(expected, actual);
	}

}
