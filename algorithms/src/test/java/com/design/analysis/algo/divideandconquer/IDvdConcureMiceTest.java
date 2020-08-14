package com.design.analysis.algo.divideandconquer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDvdConcureMiceTest {

	public IDvdConcureMice idcm = null;

	@Before
	public void init() {
		idcm = new DvdConcureMiceImpl();
	}

	/** 1. Largest Rectangular Area in a Histogram | Set 1 **/
	@Test
	public void larestRectInHistogramTest() {

		int a1[] = { 6, 2, 5, 4, 5, 1, 6, 7, 8 };
		int a2[] = { 5, 4, 5, 6, 7, 8 };
		int a3[] = { 6, 2, 5, 4, 5, 1, 6 };
		Assert.assertTrue(idcm.larestRectInHistogram(a1) == 18);
		Assert.assertTrue(idcm.larestRectInHistogram(a2) == 24);
		Assert.assertTrue(idcm.larestRectInHistogram(a3) == 12);
	}

	@Test
	public void larestRectInHistogramXTest() {
		int a1[] = { 6, 2, 5, 4, 5, 1, 6, 7, 8 };
		int a2[] = { 5, 4, 5, 6, 7, 8 };
		int a3[] = { 6, 2, 5, 4, 5, 1, 6 };
		Assert.assertTrue(idcm.larestRectInHistogramX(a1, 0, a1.length - 1) == 18);
		Assert.assertTrue(idcm.larestRectInHistogramX(a2, 0, a2.length - 1) == 24);
		Assert.assertTrue(idcm.larestRectInHistogramX(a3, 0, a3.length - 1) == 12);
	}

	/* 2. Maximum and minimum of an array using minimum number of comparisons */
	@Test
	public void maxMinByMinCompTest() {
		int a[] = { 6, 2, 5, 4, 5, 1, 6, 7, 8 };
		int b[] = idcm.maxMinByMinComp(a);
		Assert.assertTrue(b[0] == 1);
		Assert.assertTrue(b[1] == 8);
	}

	/** 3. Write you own Power without using multiplication(*) and division(/) **/
	@Test
	public void ownPowTest() {

		Assert.assertTrue(idcm.ownPow(2, 3) == 8);
		Assert.assertTrue(idcm.ownPow(3, 3) == 27);
		Assert.assertTrue(idcm.ownPow(4, 3) == 64);
	}

	/** 4. Program to count number of set bits in an (big) array **/
	@Test
	public void setBitOfNumTest() {
		Assert.assertTrue(idcm.setBitOfNum(6) == 2);
	}

	@Test
	public void setBitOfArrTest() {

		int a[] = { 2, 4, 8 };
		Assert.assertTrue(idcm.setBitOfArr(a) == 3);
	}

	/** 5. Maximum Subarray Sum **/

	@Test
	public void maxCrossingSumTest() {
		int a[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
		int m = (a.length - 1) / 2;
		Assert.assertTrue(idcm.maxCrossingSum(a, 0, m, a.length - 1) == 7);
	}

	@Test
	public void maxSumContiSubArrTest() {

		int a[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
		Assert.assertTrue(idcm.maxSumContiSubArr(a, 0, a.length - 1) == 7);
	}

	/** 6. Search in a Row-wise and Column-wise Sorted 2D Array **/
	@Test
	public void searchInSortedMatTest() {

		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		int b[] = idcm.searchInSortedMat(mat, 29);
		Assert.assertTrue(b[0] == 2);
		Assert.assertTrue(b[1] == 1);
	}
}
