package by.epamtc.sinitsyna.task1.bean;

import org.junit.Assert;

import org.junit.Test;

import by.epamtc.sinitsyna.task1.exception.IndexOutOfBoundsException;

public class ArrayTest {

	@Test
	public void testHashCode() {
		Array array = new Array(new int[] { 1, 2 });
		int expected = 2017;
		int actual = array.hashCode();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testArray() {
		Array array = new Array();
		int expectedCapacity = 16;
		int actualCapacity = array.retrieveCapacity();
		Assert.assertEquals(expectedCapacity, actualCapacity);
	}

	@Test
	public void testArrayIntArray() {
		Array array = new Array(new int[] { 3, 5, -8 });
		int expectedCurrentLength = 3;
		int actualCurrentLength = array.getCurrentLength();
		int[] expectedValue = new int[] { 3, 5, -8 };
		int[] actualValue = array.getValue();
		Assert.assertEquals(expectedCurrentLength, actualCurrentLength);
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testArrayIntArrayPassingNullArray() {
		Array array = new Array(null);
		int expectedCapacity = 16;
		int actualCapacity = array.retrieveCapacity();
		Assert.assertEquals(expectedCapacity, actualCapacity);
	}

	@Test
	public void testArrayInt() {
		Array array = new Array(22);
		int expectedCapacity = 22;
		int actualCapacity = array.retrieveCapacity();
		Assert.assertEquals(expectedCapacity, actualCapacity);
	}

	@Test
	public void testArrayIntPassingNegativeCapacity() {
		Array array = new Array(-22);
		int expectedCapacity = 16;
		int actualCapacity = array.retrieveCapacity();
		Assert.assertEquals(expectedCapacity, actualCapacity);
	}

	@Test
	public void testGetValue() {
		Array array = new Array(new int[] { 3, 5, -8 });
		int[] expectedValue = new int[] { 3, 5, -8 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testSetValuePassingNullArray() {
		Array array = new Array();
		Assert.assertFalse(array.setValue(null));
	}

	@Test
	public void testSetValue() {
		Array array = new Array();
		array.setValue(new int[] { 3, 5, -8 });
		int[] expectedValue = new int[] { 3, 5, -8 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetCurrentLength() {
		Array array = new Array(new int[] { 3, 5, -8 });
		int expectedCurrentLength = 3;
		int actualCurrentLength = array.getCurrentLength();
		Assert.assertEquals(expectedCurrentLength, actualCurrentLength);
	}

	@Test
	public void testSetCurrentLength() {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.setCurrentLength(5);
		int expectedCurrentLength = 5;
		int actualCurrentLength = array.getCurrentLength();
		Assert.assertEquals(expectedCurrentLength, actualCurrentLength);
	}

	@Test
	public void testSetCurrentLengthAfterRemoveMethod() {
		Array array = new Array(new int[] { 3, 5, -8, 6, 7 });
		array.remove();
		array.remove();
		array.setCurrentLength(5);
		int[] expectedValue = new int[] { 3, 5, -8, 0, 0 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testSetCurrentLengthWhenPassedNewLengthIsLessThanCurrent() {
		Array array = new Array(new int[] { 3, 5, -8 });
		Assert.assertFalse(array.setCurrentLength(2));
	}

	@Test
	public void testGet() throws IndexOutOfBoundsException {
		Array array = new Array(new int[] { 3, 5, -8 });
		int expected = 5;
		int actual = array.get(1);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetPassingNegativeIndex() throws IndexOutOfBoundsException {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.get(-1);
	}

	@Test
	public void testAdd() {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.add(9);
		int[] expectedValue = new int[] { 3, 5, -8, 9 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testSet() {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.set(6, 0);
		int[] expectedValue = new int[] { 6, 5, -8 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testSetPassingInvalidLargeIndex() {
		Array array = new Array(new int[] { 3, 5, -8 });
		Assert.assertFalse(array.set(5, 4));
	}

	@Test
	public void testInsert() {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.insert(6, 0);
		int[] expectedValue = new int[] { 6, 3, 5, -8 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testInsertPassingInvalidLargeIndex() {
		Array array = new Array(new int[] { 3, 5, -8 });
		Assert.assertFalse(array.insert(6, 10));
	}

	@Test
	public void testRemove() {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.remove();
		int[] expectedValue = new int[] { 3, 5 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testRemoveInt() {
		Array array = new Array(new int[] { 3, 5, -8 });
		array.remove(0);
		int[] expectedValue = new int[] { 5, -8 };
		int[] actualValue = array.getValue();
		Assert.assertArrayEquals(expectedValue, actualValue);
	}

	@Test
	public void testRemoveIntPassingEmptyArray() {
		Array array = new Array();
		Assert.assertFalse(array.remove(2));
	}

	@Test
	public void testContainsPassingExistedElement() {
		Array array = new Array(new int[] { 3, 5, -8 });
		Assert.assertTrue(array.contains(5));
	}

	@Test
	public void testContainsPassingNonExistedElement() {
		Array array = new Array(new int[] { 3, 5, -8 });
		Assert.assertFalse(array.contains(2));
	}

	@Test
	public void testIsEmpty() {
		Array array = new Array();
		Assert.assertTrue(array.isEmpty());
	}

	@Test
	public void testEqualsObjectPassingEqualArrays() {
		Array array1 = new Array(new int[] { 3, 5, -8 });
		Array array2 = new Array(new int[] { 3, 5, -8 });
		Assert.assertTrue(array1.equals(array2));
	}

	@Test
	public void testEqualsObjectPassingNonEqualArrays() {
		Array array1 = new Array(new int[] { 3, 5, -8 });
		Array array2 = new Array(new int[] { 3, 5, -8, 9 });
		Assert.assertFalse(array1.equals(array2));
	}

	@Test
	public void testToString() {
		Array array = new Array(new int[] { 3, 5, -8 });
		String expected = "by.epamtc.sinitsyna.task1.bean.Array [value=[3, 5, -8], length=3]";
		String actual = array.toString();
		Assert.assertEquals(expected, actual);
	}

}
