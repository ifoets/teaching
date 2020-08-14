package com.design.analysis.algo.array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArraySortTest {

	public IArraySort ias = null;

	@Before
	public void init() {
		ias = new ArraySortImpl();
	}

	/** 1. Alternative Sorting **/
	@Test
	public void alternativeSortingTest() {

		int a[] = { 1, 12, 4, 6, 7, 10 };
		ias.alternativeSorting(a);
		int b[] = { 12, 1, 10, 4, 7, 6 };
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);

		int a1[] = { 1, 12, 4, 6, 7 };
		ias.alternativeSorting(a1);
		int b1[] = { 12, 1, 7, 4, 6 };
		for (int i = 0; i < a1.length; i++)
			Assert.assertTrue(a1[i] == b1[i]);
	}

	/** 2. Sort a nearly sorted (or K sorted) array **/
	@Test
	public void sortNearlySortedTest() {
		int a[] = { 2, 6, 3, 12, 56, 8 };
		int b[] = { 2, 3, 6, 8, 12, 56 };
		ias.sortNearlySorted(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 3. Sort an array according to absolute difference with given value **/
	@Test
	public void sortByAbsDiffGivenValueTest() {
		int x = 7;
		int a[] = { 10, 5, 3, 9, 2 };
		int b[] = { 5, 9, 10, 3, 2 };
		ias.sortByAbsDiffGivenValue(a, x);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	@Test
	public void sortByAbsDiffGivenValueXTest() {
		int x = 7;
		int a[] = { 10, 5, 3, 9, 2 };
		int b[] = { 5, 9, 10, 3, 2 };
		ias.sortByAbsDiffGivenValueX(a, x);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 4. Sort an array in wave form **/
	@Test
	public void sortInWaveFormTest() {
		int a[] = { 10, 90, 49, 2, 1, 5, 23 };
		ias.sortInWaveForm(a);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length - 2; i++)
			Assert.assertTrue((a[i] >= a[i + 1] && a[i + 1] <= a[i + 2]) || (a[i] <= a[i + 1] && a[i + 1] >= a[i + 2]));
	}

	/** 5. Merge an array of size n into another array of size m+n **/
	@Test
	public void meargeNArrToMNArrTest() {
		int mnArr[] = { 2, 0, 7, 0, 0, 10, 0 };
		int nArr[] = { 5, 8, 12, 14 };
		ias.meargeNArrToMNArr(mnArr, nArr);
		Assert.assertTrue(mnArr[0] == 2);
		Assert.assertTrue(mnArr[mnArr.length - 1] == 14);
		// System.out.println(Arrays.toString(mnArr));
	}

	@Test
	public void meargeNArrToMNArrXTest() {
		int mnArr[] = { 2, 0, 7, 0, 0, 10, 0 };
		int nArr[] = { 5, 8, 12, 14 };
		ias.meargeNArrToMNArr(mnArr, nArr);
		 System.out.println(Arrays.toString(mnArr));
		Assert.assertTrue(mnArr[0] == 2);
		Assert.assertTrue(mnArr[mnArr.length - 1] == 14);
	}

	/** 6. Sort an array which contain 1 to n values **/
	@Test
	public void sortNaturalNoTest() {
		int[] a = { 10, 7, 9, 2, 8, 3, 5, 4, 6, 1 };
		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ias.sortNaturalNo(a);
		// System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 7. Sort 1 to N by swapping adjacent elements **/
	@Test
	public void sort1ToNBySwapAdjacentTest() {
		int a[] = { 1, 2, 5, 3, 4, 6 };
		boolean b[] = { false, true, true, true, false };
		Assert.assertTrue(ias.sort1ToNBySwapAdjacent(a, b));
	}

	/** 8. Sort an array containing two types of elements **/
	@Test
	public void sort0And1Test() {
		int a[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		int b[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };

		ias.sort0And1(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
		int c[] = { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 };
		int d[] = { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
		ias.sort0And1(c);
		for (int i = 0; i < c.length; i++)
			Assert.assertTrue(c[i] == d[i]);
	}

	/** 9. Sort elements by frequency | Set 1 **/
	@Test
	public void sortByfriquencyTest() {
		int a[] = { 5, 2, 2, 8, 5, 6, 8, 8 };
		ias.sortByfriquency(a);
		 System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[2] == 2);
		Assert.assertTrue(a[a.length - 1] == 8);
	}

	/** 10. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	/// @See @IStandardAlgo.java 9.

	/** 11. Two elements whose sum is closest to zero **/
	@Test
	public void sumCloseToZeroTest() {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		arr = ias.sumCloseToZero(arr);
		Assert.assertTrue(arr[0] == -80);
		Assert.assertTrue(arr[1] == 85);

		int b[] = { -1, 5, -2, 8, -3, 9, -4 };
		arr = ias.sumCloseToZero(b);
		Assert.assertTrue(arr[0] == -4);
		Assert.assertTrue(arr[1] == 5);
	}

	/** 12. Shortest Un-ordered Subarray **/
	@Test
	public void unOrderedLenTest() {
		int a[] = { 7, 9, 10, 8, 11 };
		Assert.assertTrue(ias.unOrderedLen(a) == 3);
	}
}
