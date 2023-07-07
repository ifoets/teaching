package com.design.analysis.core.algo.sorting;

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

	@Test
	public void arrangeNeZeroPosTest() {
		int c[] = { 0, 4, -5, 0, 1, 2, -1, 2, 0, 0, 0, -8, 10 };
		SortingUtils.arrangeNeZeroPos(c);
		System.out.println(Arrays.toString(c));
	}

	@Test
	public void sortTwoArrayTogetherTest() {

		int a[] = { 1, 9, 2, 11, 3 };
		int b[] = { 5, 4, 6, 8, 7, 10 };
		//SortingUtils.sortTwoArrayTogether(a, b);
		SortingUtils.maxHeapSort1(a, b);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
