package com.design.analysis.algo.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortingUtils {

	public static List<Integer> mergeSortedList(List<Integer> l1, List<Integer> l2) {
		if (l1 == null || l1.isEmpty())
			return l2;
		if (l2 == null || l2.isEmpty())
			return l1;

		int i, j;
		i = j = 0;
		List<Integer> rs = new ArrayList<>();
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) <= l2.get(j))
				rs.add(l1.get(i++));
			else
				rs.add(l2.get(j++));
		}
		while (i < l1.size())
			rs.add(l1.get(i++));
		while (j < l2.size())
			rs.add(l2.get(j++));
		l1 = l2 = null;
		return rs;
	}
}
