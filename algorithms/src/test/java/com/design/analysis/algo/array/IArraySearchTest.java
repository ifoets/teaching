
package com.design.analysis.algo.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArraySearchTest {

	public IArraySearch ias = null;

	@Before
	public void init() {
		ias = new ArraySearchImpl();
	}

	/** 1. Search, insert and delete in an unsorted array **/
	@Test
	public void searchInsertDelUnsortedArrTest() {
		int a[] = { 1, 3, 2, 5, 4, 6, 7, 8, 9 };

		Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, a.length, 5, "S"));
		Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, a.length, 5, "D"));
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, a.length, 10, "I") == false);
		Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, 8, 10, "I") == true);
		// System.out.println(Arrays.toString(a));
	}

	/** 2. Search, insert and delete in an sorted array **/
	@Test
	public void searchInsertDelSortedArrTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Assert.assertTrue(ias.searchInsertDelSortedArr(a, a.length, 5, "S"));
		Assert.assertTrue(ias.searchInsertDelSortedArr(a, a.length, 15, "S") == false);
		Assert.assertTrue(ias.searchInsertDelSortedArr(a, a.length, 5, "D"));
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(ias.searchInsertDelSortedArr(a, a.length, 10, "I") == false);
		Assert.assertTrue(ias.searchInsertDelSortedArr(a, 8, 10, "I") == true);
	}

	/**
	 * 3. Given an array A[] and a number x, check for pair in A[] with sum as x
	 **/
	@Test
	public void pairOfSumXTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(ias.pairOfSumX(a, 6).size() == 2);
	}

	/** 8.Leaders in an array **/
	@Test
	public void findLeaderTest() {
		int a[] = { 16, 17, 4, 3, 5, 2, 1 };
		List<Integer> list = ias.findLeader(a);
		Assert.assertTrue(list.get(0) == 1);
		Assert.assertTrue(list.get(3) == 17);
	}

	/** 14. Majority Element **/
	@Test
	public void majorityElementTest() {
		Assert.assertTrue(ias.majorityElement(null) == null);
		int a[] = {};
		Assert.assertTrue(ias.majorityElement(a) == null);

		
		int b[] = { 5 };
		Assert.assertTrue(ias.majorityElement(b) == 5);

		int c[] = { 1, 2, 3, 4, 5, 6, 7, 4, 7, 2, 3, 5, 1, 2, 5, 5, 5, 3, 4, 5, 5 };
		Assert.assertTrue(ias.majorityElement(c) == 5);
	}
}
