package by.epamtc.sinitsyna.task1.test;

import org.junit.Assert;

import org.junit.Test;

import by.epamtc.sinitsyna.task1.logic.MaxElementComparator;

public class MaxElementComparatorTest {

	@Test
	public void testCompare() {
		MaxElementComparator comparator = new MaxElementComparator();
		int expected = 1;
		int actual = comparator.compare(3, 1);
		Assert.assertEquals(expected, actual);
	}

}
