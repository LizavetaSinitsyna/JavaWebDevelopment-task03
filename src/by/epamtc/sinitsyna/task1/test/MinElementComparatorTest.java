package by.epamtc.sinitsyna.task1.test;

import org.junit.Assert;

import org.junit.Test;

import by.epamtc.sinitsyna.task1.logic.MinElementComparator;

public class MinElementComparatorTest {

	@Test
	public void testCompare() {
		MinElementComparator comparator = new MinElementComparator();
		int expected = -1;
		int actual = comparator.compare(3, 1);
		Assert.assertEquals(expected, actual);
	}

}
