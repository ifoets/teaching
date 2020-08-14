package com.design.analysis.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortingUtilsTest {

	@Test
	public void mergeSortedListTest() {

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		int a[] = { 1, 3, 5, 7, 9 };
		int b[] = { 1, 2, 4, 6, 8 };
		for (int i = 0; i < a.length; i++) {
			l1.add(a[i]);
			l2.add(b[i]);
		}
		List<Integer> rs = SortingUtils.mergeSortedList(l1, l2);
		System.out.println(Arrays.toString(rs.toArray()));
	}
	
	
}
