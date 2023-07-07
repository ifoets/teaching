package com.design.analysis.core.ds.advance.segmenttree;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISegmentTreeTest {

	ISegmentTree ist = null;

	@Before
	public void init() {
		ist = new SegmentTreeImpl();
	}

	/* common function of segment tree */
	/* constructSegmentTreeUtil(...) also testing here only */
	@Test
	public void createSegmentTreeTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int[] rs = SegmentTreeUtil.createSegmentTree(arr);
		System.out.println(Arrays.toString(rs));
	}

	/** 1. Sum of given range **/
	@Test
	public void getSumTest() {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		Assert.assertTrue(ist.getSum(arr, t, 0, 2) == 9);
		Assert.assertTrue(ist.getSum(arr, t, 0, 5) == 36);
		Assert.assertTrue(ist.getSum(arr, t, 3, 5) == 27);
	}

	@Test
	public void getUpdateTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		int b[] = ist.getUpdate(arr, t, 0, 4);
		// System.out.println(Arrays.toString(b));
		Assert.assertTrue(b[0] == 39);// sum-0-5
		Assert.assertTrue(b[1] == 12);// sum-0-2
	}

	@Test
	public void getMinimumTest() {

		int[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructMinValueTUtil(t, a, 0, a.length - 1, 0);
		Assert.assertTrue(ist.getMinimum(a, t, 0, n) == 1);
		Assert.assertTrue(ist.getMinimum(a, t, 1, n) == 2);
		Assert.assertTrue(ist.getMinimum(a, t, 0, 2) == 1);
		Assert.assertTrue(ist.getMinimum(a, t, 2, 5) == 2);
		Assert.assertTrue(ist.getMinimum(a, t, 4, 5) == 9);
	}

	@Test
	public void getMaximumTest() {

		int[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructMaxValueTUtil(t, a, 0, n, 0);
		Assert.assertTrue(ist.getMaximum(a, t, 0, n) == 11);
		Assert.assertTrue(ist.getMaximum(a, t, 1, n) == 11);
		Assert.assertTrue(ist.getMaximum(a, t, 0, 2) == 3);
		Assert.assertTrue(ist.getMaximum(a, t, 2, 5) == 11);
		Assert.assertTrue(ist.getMaximum(a, t, 4, 5) == 11);
	}

	/** 3. Lazy Propagation **/
	@Test
	public void getLazySumTest() {
		// tested in SegmentTreeUtilTest.java
	}

	@Test
	public void getLazyUpdateRangeTest() {
		// tested in SegmentTreeUtilTest.java
	}

	/* 4. Persistent Segment Tree */
	/* 5. Efficiently design Insert, Delete and Median queries on a set */

	/** 6. Range Minimum Query (Square Root Decomposition and Sparse Table) **/

	/** 7. Range LCM queries **/
	public void getLCMTest() {
		// tested in SegmentTreeUtilTest.java
	}

	/** 8. Min-Max Range queries in array **/
	@Test
	public void getMinMaxTest() {
		// tested in SegmentTreeUtilTest.java
	}

	/* 9. Count and Toggle queries on Binary array */
	/* 10. Querying maximum number of divisors that a number in a given range has */
	/* 11. LCA in a binary tree using RMQ */
	/** 12. GCDs of given index ranges in an array **/
	@Test
	public void getGCDTest() {
		// tested in SegmentTreeUtilTest.java
	}
	/* 13. Smallest sub-array with given GCD */
	/* 14. Largest Rectangular Area in a Histogram */

}
