package com.design.analysis.algo.divideandconquer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBinarySearchBasedTest {
	
	public IBinarySearchBased ibs = null;

	@Before
	public void init() {
		ibs = new BinarySearchBasedImpl();
	}

	/** 1. Median of two sorted arrays **/
	@Test
	public void medianOfTwoSottedArrTest() {

		int a[] = { 1, 3 };
		int b[] = { 2, 4 };
		Assert.assertTrue(ibs.medianOfTwoSottedArr(a, b) == 2);

		
		
		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };
		Assert.assertTrue(ibs.medianOfTwoSottedArr(ar1, ar2) == 16);
	}

	/* get median of an array */
	@Test
	public void getMedianTest() {

		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 1, 2, 3, 4, 5, 6 };

		Assert.assertTrue(ibs.getMedian(a, 0, a.length - 1) == 3);
		Assert.assertTrue(ibs.getMedian(a, 0, b.length - 1) == 3);
		Assert.assertTrue(ibs.getMedian(a, 2, a.length - 1) == 4);
		Assert.assertTrue(ibs.getMedian(a, 2, b.length - 1) == 4);
	}

	/* by log(n) complexity */
	@Test
	public void getMedianOf2ArrayTest() {
		int a[] = { 1, 3 };
		int b[] = { 2, 4 };
		Assert.assertTrue(ibs.getMedianOf2Array(a, 0, a.length - 1, b, 0, b.length - 1) == 2);

		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };
		Assert.assertTrue(ibs.getMedianOf2Array(ar1, 0, ar1.length - 1, ar2, 0, ar2.length - 1) == 16);

	}

	/** 2. Median of two sorted arrays of different sizes **/
	/* by O(1) worst case log(n) when size equal ...complexity */
	@Test
	public void getMedianOfDiffSize2ArrayTest() {
		int A[] = { 900 };
		int B[] = { 5, 8, 10, 20 };

		Assert.assertTrue(ibs.getMedianOfDiffSize2Array(A, 0, A.length - 1, B, 0, B.length - 1) == 10);

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 100, 200, 300, 400, 500 };
		Assert.assertTrue(ibs.getMedianOfDiffSize2Array(a, 0, a.length - 1, b, 0, b.length - 1) == 7);

		int x[] = { 2, 4, 6, 8, 10, 11, 12 };// { 2, 7, 10 };
		int y[] = { 1, 3, 5, 7, 9 };// { 4, 5 };
		Assert.assertTrue(ibs.getMedianOfDiffSize2Array(x, 0, x.length - 1, y, 0, y.length - 1) == 6);

		int t[] = { 2, 7, 10 };
		int n[] = { 4, 5 };

		Assert.assertTrue(ibs.getMedianOfDiffSize2Array(t, 0, t.length - 1, n, 0, n.length - 1) == 5);
	}

	// GuruJi 2 sorted array
	@Test
	public void getMedianOf2AnySizeArrayTest() {
		int A[] = { 900 };
		int B[] = { 5, 8, 10, 20 };

		Assert.assertTrue(ibs.getMedianOf2AnySizeArray(A, B) == 10);

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 100, 200, 300, 400, 500 };
		Assert.assertTrue(ibs.getMedianOf2AnySizeArray(a, b) == 7);

		int x[] = { 2, 4, 6, 8, 10, 11, 12 };// { 2, 7, 10 };
		int y[] = { 1, 3, 5, 7, 9 };// { 4, 5 };
		Assert.assertTrue(ibs.getMedianOf2AnySizeArray(x, y) == 6);

		int t[] = { 2, 7, 10 };
		int n[] = { 4, 5 };

		Assert.assertTrue(ibs.getMedianOf2AnySizeArray(t, n) == 5);
	}

	/// GuruJi 2 sorted array O(n) and SO(n) /n=n1+n2
	@Test
	public void getMedianOf2AnySizeArrayXTest() {
		int A[] = { 9 };
		int B[] = { 5, 8, 10, 20 };

		Assert.assertTrue(ibs.getMedianOf2AnySizeArrayX(A, B) == 9);

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 10, 11, 13, 14, 15 };
		Assert.assertTrue(ibs.getMedianOf2AnySizeArrayX(a, b) == 7);

		int x[] = { 2, 4, 6, 8, 10, 11, 12 };// { 2, 7, 10 };
		int y[] = { 1, 3, 5, 7, 9 };// { 4, 5 };
		Assert.assertTrue(ibs.getMedianOf2AnySizeArrayX(x, y) == 6);

		int t[] = { 2, 7, 10 };
		int n[] = { 4, 5 };

		Assert.assertTrue(ibs.getMedianOf2AnySizeArrayX(t, n) == 5);
	}

	/**
	 * 3.Check for Majority Element in a sorted array ie check x appear more than
	 * n/2 times or not
	 **/

	@Test
	public void binarySearchTest() {

		int a[] = { 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8 };
		Assert.assertTrue(ibs.binarySearchFirstOccurance(a, 0, a.length - 1, 2) == 1);
		Assert.assertTrue(ibs.binarySearchFirstOccurance(a, 0, a.length - 1, 5) == 5);
		Assert.assertTrue(ibs.binarySearchFirstOccurance(a, 0, a.length - 1, 8) == 12);
	}

	@Test
	public void majorityElemInSortedArrTest() {
		int a[] = { 1, 2, 2, 2, 2, 5 };
		int b[] = { 1, 1, 1, 1, 2, 2, 2 };
		Assert.assertTrue(ibs.majorityElemInSortedArr(a, 2));
		Assert.assertTrue(ibs.majorityElemInSortedArr(b, 1));
		Assert.assertTrue(!ibs.majorityElemInSortedArr(b, 2));
	}

	/**
	 * 4. Count number of occurrences (or frequency) in a sorted array O(Logn) not
	 * O(n)
	 **/
	@Test
	public void binarySearchLastOccuranceTest() {

		int a[] = { 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8 };
		Assert.assertTrue(ibs.binarySearchLastOccurance(a, 0, a.length - 1, 2) == 3);
		Assert.assertTrue(ibs.binarySearchLastOccurance(a, 0, a.length - 1, 5) == 7);
		Assert.assertTrue(ibs.binarySearchLastOccurance(a, 0, a.length - 1, 8) == 13);
	}

	@Test
	public void frequecnyOfElementTest() {
		int a[] = { 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8 };
		Assert.assertTrue(ibs.frequecnyOfElement(a, 2) == 3);
		Assert.assertTrue(ibs.frequecnyOfElement(a, 1) == 1);
		Assert.assertTrue(ibs.frequecnyOfElement(a, 7) == 3);
	}

	/** 5. Find a Fixed Point **/
	@Test
	public void findFixedPointTest() {
		int a[] = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
		Assert.assertTrue(ibs.findFixedPoint(a, 0, a.length - 1) == 3);
	}
}
