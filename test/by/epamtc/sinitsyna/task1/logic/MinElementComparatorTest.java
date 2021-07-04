package by.epamtc.sinitsyna.task1.logic;

import org.junit.Assert;

import org.junit.Test;

public class MinElementComparatorTest {

	@Test
	public void testCompareWhenFirstIsLargerThanSecond() {
		MinElementComparator comparator = new MinElementComparator();
		int expected = -1;
		int actual = comparator.compare(3, 1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCompareWhenFirstIsLessThanSecond() {
		MinElementComparator comparator = new MinElementComparator();
		int expected = 1;
		int actual = comparator.compare(1, 3);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCompareWhenFirstIsEqualToSecond() {
		MinElementComparator comparator = new MinElementComparator();
		int expected = 0;
		int actual = comparator.compare(3, 3);
		Assert.assertEquals(expected, actual);
	}
}
