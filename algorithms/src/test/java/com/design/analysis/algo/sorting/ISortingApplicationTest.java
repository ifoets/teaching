package com.design.analysis.algo.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISortingApplicationTest {

	public ISortingApplication isa = null;

	@Before
	public void init() {
		isa = new SortingApplicationImpl();
	}

	@Test
	/** 1. Sort elements by frequency | Set 1 **/
	public void sortByFrequencyTest() {

		int a[] = { 5, 2, 2, 8, 5, 6, 8, 8 };
		int c[] = { 6, 5, 5, 2, 2, 8, 8, 8 };
		int b[] = isa.sortByFrequency(a);
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(c[i] == b[i]);
	}

	// without using inbuilt library
	@Test
	public void sortByFrequencyXTest() {

		int a[] = { 1, 2, 0, 1, 0, 4, 5, 3, 3, 2, 5, 3, 2, 2 };
		a = isa.sortByFrequencyX(a);
		int b[] = { 2, 2, 2, 2, 3, 3, 3, 0, 0, 1, 1, 5, 5, 4 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	@Test
	public void sortByFrequencyMaxToMinTest() {
		int a[] = { 1, 2, 0, 1, 0, 4, 5, 3, 3, 2, 5, 3, 2, 2 };
		a = isa.sortByFrequencyMaxToMin(a);
		int b[] = { 2, 2, 2, 2, 3, 3, 3, 0, 0, 1, 1, 5, 5, 4 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	@Test
	public void sortByFrequencyMinToMaxTest() {
		int a[] = { 1, 2, 0, 1, 0, 4, 5, 3, 3, 2, 5, 3, 2, 2 };
		a = isa.sortByFrequencyMinToMax(a);
		int b[] = { 4, 0, 0, 1, 1, 5, 5, 3, 3, 3, 2, 2, 2, 2 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 2. Sort elements by frequency | Set 2 **/
	@Test
	public void sortByFrequencyBstTest() {
		int a[] = { 1, 2, 0, 1, 0, 4, 5, 3, 3, 2, 5, 3, 2, 2 };
		a = isa.sortByFrequencyBst(a);
		int b[] = { 2, 2, 2, 2, 3, 3, 3, 0, 0, 1, 1, 5, 5, 4 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 3. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	@Test
	public void countInversionTest() {

		int a[] = { 1, 20, 6, 4, 5 };
		Assert.assertTrue(isa.countInversion(a) == 5);
	}

	/** 4. Sort an array of 0s, 1s and 2s **/
	@Test
	public void sortThreeElementXTest() {

		int a[] = { 0, 1, 2, 0, 1, 2 };
		int b[] = { 0, 0, 1, 1, 2, 2 };

		int c[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int d[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 };

		a = isa.sortThreeElementX(a);
		c = isa.sortThreeElementX(c);
		for (int i = 0; i < c.length; i++) {
			if (i < a.length)
				Assert.assertTrue(a[i] == b[i]);
			Assert.assertTrue(c[i] == d[i]);
		}
	}

	@Test
	public void sortThreeElementYTest() {

		int a[] = { 0, 1, 2, 0, 1, 2 };
		int b[] = { 0, 0, 1, 1, 2, 2 };

		int c[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int d[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 };

		a = isa.sortThreeElementY(a);
		c = isa.sortThreeElementY(c);
		for (int i = 0; i < c.length; i++) {
			if (i < a.length)
				Assert.assertTrue(a[i] == b[i]);
			Assert.assertTrue(c[i] == d[i]);
		}
	}

	// O(n)
	@Test
	public void sortThreeElementZTest() {
		int a[] = { 0, 1, 2, 0, 1, 2 };
		int b[] = { 0, 0, 1, 1, 2, 2 };

		int c[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int d[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 };

		a = isa.sortThreeElementZ(a);
		c = isa.sortThreeElementZ(c);
		for (int i = 0; i < c.length; i++) {
			if (i < a.length)
				Assert.assertTrue(a[i] == b[i]);
			Assert.assertTrue(c[i] == d[i]);
		}
	}

	@Test
	public void sortNNaturalNoTest() {
		int a[] = { 0, 1, 2, 0, 1, 2 };
		int b[] = { 0, 0, 1, 1, 2, 2 };

		int c[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int d[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 };

		a = isa.sortNPerfectNumber(a, 2);
		c = isa.sortNPerfectNumber(c, 2);
		for (int i = 0; i < c.length; i++) {
			if (i < a.length)
				Assert.assertTrue(a[i] == b[i]);
			Assert.assertTrue(c[i] == d[i]);
		}
	}

	/**
	 * 5. Find the Minimum length Unsorted Subarray, sorting which makes the
	 * complete array sorted
	 **/
	@Test
	public void unsortedSubArrayLenTest() {
		int a[] = { 1, 2, 3, 8, 5, 6, 7, 9, 10, 11 };
		int b[] = isa.unsortedSubArrayLen(a);
		Assert.assertTrue(b[0] == 3);
		Assert.assertTrue(b[1] == 6);
	}

	@Test
	public void unsortedSubArrayLenXTest() {
		int a[] = { 1, 2, 3, 8, 5, 6, 7, 9, 10, 11 };
		int b[] = isa.unsortedSubArrayLenX(a);
		Assert.assertTrue(b[0] == 3);
		Assert.assertTrue(b[1] == 6);
	}

	/** 6. Find whether an array is subset of another array | Added Method 3 **/
	@Test
	public void isSubsetArrInOtherArrayTest() {

		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };

		Assert.assertTrue(isa.isSubsetArrInOtherArray(arr1, arr2));
	}
}
