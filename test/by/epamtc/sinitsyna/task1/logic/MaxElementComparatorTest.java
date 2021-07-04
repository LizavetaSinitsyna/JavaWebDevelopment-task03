package by.epamtc.sinitsyna.task1.logic;

import org.junit.Assert;

import org.junit.Test;

public class MaxElementComparatorTest {

	@Test
	public void testCompareWhenFirstIsLargerThanSecond() {
		MaxElementComparator comparator = new MaxElementComparator();
		int expected = 1;
		int actual = comparator.compare(3, 1);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCompareWhenFirstIsLessThanSecond() {
		MaxElementComparator comparator = new MaxElementComparator();
		int expected = -1;
		int actual = comparator.compare(1, 3);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCompareWhenFirstIsEqualToSecond() {
		MaxElementComparator comparator = new MaxElementComparator();
		int expected = 0;
		int actual = comparator.compare(3, 3);
		Assert.assertEquals(expected, actual);
	}

}
