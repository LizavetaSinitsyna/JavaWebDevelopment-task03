package by.epamtc.sinitsyna.comparator;

import java.util.Comparator;

public class DescendingOrderComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer int1, Integer int2) {
		if (int1 < int2) {
			return 1;
		} else if (int1 > int2) {
			return -1;
		}
		return 0;
	}
}