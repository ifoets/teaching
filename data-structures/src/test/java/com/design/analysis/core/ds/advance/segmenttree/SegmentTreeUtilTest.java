package com.design.analysis.core.ds.advance.segmenttree;

import java.util.Arrays;

import com.design.analysis.core.ds.advance.segmenttree.model.MinMaxNode;
import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeUtilTest {

	/**
	 * 0.1 create complete binary tree(creazy tree) whose last level will
	 * 1,2,3....by given level input and rest of the inner node will be the product
	 * of their child;
	 **/
	/* l ,r and e the start,end and current position of data filling index */
	@Test
	public void createCreazyTreeTest()//
	{
		int b[] = { 24, 2, 12, 1, 2, 3, 4 };
		int a[] = SegmentTreeUtil.createCreazyTree(3);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/**
	 * l is level(stat from 1 ie root is at level 1),x ie xth node to yth node
	 * finding the sum
	 **/
	@Test
	public void queryTest() {
		int a[] = SegmentTreeUtil.createCreazyTree(3);
		Assert.assertTrue(SegmentTreeUtil.query(a, 1, 1, 1) == 24);
		Assert.assertTrue(SegmentTreeUtil.query(a, 3, 1, 4) == 10);
		Assert.assertTrue(SegmentTreeUtil.query(a, 2, 1, 2) == 14);
	}

	/* common function of segment tree */
	@Test
	public void createSegmentTreeTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int[] rs = SegmentTreeUtil.createSegmentTree(arr);
		Assert.assertTrue(rs[0] == 0);
		Assert.assertTrue(rs[1] == 0);
		Assert.assertTrue(rs[2] == 0);
		Assert.assertTrue(rs.length == 15);
	}

	/* this is for construct tree such that root is sum of child node */
	@Test
	public void constructSegmentTreeUtilTest() {

		int[] a = { 1, 3, 5, 7, 9, 11 };
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.constructSegmentTreeUtil(t, a, 0, a.length - 1, 0);
		Assert.assertTrue(t[0] == 36);
		Assert.assertTrue(t[1] == 9);
		Assert.assertTrue(t[2] == 27);
		System.out.println(Arrays.toString(t));
	}

	/* this is for find the sum between range of query */
	@Test
	public void querySumUtilTest() {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 0, 2, 0) == 9);
		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 0, 5, 0) == 36);
		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 3, 5, 0) == 27);

		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 2, 4, 0) == 21);
		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 0, 2, 0) == 9);
		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 3, 5, 0) == 27);
		Assert.assertTrue(SegmentTreeUtil.querySumUtil(t, 0, n, 4, 5, 0) == 20);
	}

	/* this is for find the udate value at index i */
	@Test
	public void constructUpdateUtilTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		int diff = 4 - arr[0];
		arr[0] = 4;
		SegmentTreeUtil.constructUpdateUtil(t, 0, n, 0, diff, 0);

		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 39);// sum-0-5
		Assert.assertTrue(t[1] == 12);// sum-0-2
		int diff1 = 6 - arr[1];
		arr[1] = 6;
		SegmentTreeUtil.constructUpdateUtil(t, 0, n, 1, diff1, 0);

		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 42);// sum-0-5
		Assert.assertTrue(t[1] == 15);// sum-0-2
	}

	@Test
	public void constructUpdateRangeUtilTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		int diff = 4;
		for (int i = 0; i <= n; i++)
			arr[i] += diff;
		SegmentTreeUtil.constructUpdateRangeUtil(t, 0, n, 0, n, diff, 0);

		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 60);// sum-0-5
		Assert.assertTrue(t[1] == 21);// sum-0-2
	}

	/* this is for construct tree such that root is smaller child */
	@Test
	public void costructMinValueTUtilTest() {

		int[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructMinValueTUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 1);
		Assert.assertTrue(t[1] == 1);
		Assert.assertTrue(t[2] == 7);

	}

	/* this is for find the minimum between range of query */
	@Test
	public void queryMinValueUtilTest() {

		int[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructMinValueTUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(SegmentTreeUtil.queryMinValueUtil(t, 0, n, 0, n, 0) == 1);
		Assert.assertTrue(SegmentTreeUtil.queryMinValueUtil(t, 0, n, 1, n, 0) == 2);
		Assert.assertTrue(SegmentTreeUtil.queryMinValueUtil(t, 0, n, 0, 2, 0) == 1);
		Assert.assertTrue(SegmentTreeUtil.queryMinValueUtil(t, 0, n, 2, 5, 0) == 2);
		Assert.assertTrue(SegmentTreeUtil.queryMinValueUtil(t, 0, n, 4, 5, 0) == 9);
	}

	/* this is for construct tree such that root is bigger child */
	@Test
	public void costructMaxValSTUtilTest() {
		int[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructMaxValueTUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 11);
		Assert.assertTrue(t[1] == 3);
		Assert.assertTrue(t[2] == 11);
	}

	/* this is for find the maximum between range of query */
	@Test
	public void queryMaxValueUtilTest() {
		int[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructMaxValueTUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(SegmentTreeUtil.queryMaxValueUtil(t, 0, n, 0, n, 0) == 11);
		Assert.assertTrue(SegmentTreeUtil.queryMaxValueUtil(t, 0, n, 1, n, 0) == 11);
		Assert.assertTrue(SegmentTreeUtil.queryMaxValueUtil(t, 0, n, 0, 2, 0) == 3);
		Assert.assertTrue(SegmentTreeUtil.queryMaxValueUtil(t, 0, n, 2, 5, 0) == 11);
		Assert.assertTrue(SegmentTreeUtil.queryMaxValueUtil(t, 0, n, 4, 5, 0) == 11);
	}

	/* this is for construct tree such that root is bigger child */
	@Test
	public void costructAvgValSTUtilTest() {
		double[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		double[] t = SegmentTreeUtil.createSegmentTreeDouble(a);
		SegmentTreeUtil.constructAvgValueUtil(t, a, 0, a.length - 1, 0);
		SegmentTreeUtil.queryAvgUtil(t, 0, n, 0, n, 0);
		System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 5.75);
		Assert.assertTrue(t[1] == 2.0);
		Assert.assertTrue(t[2] == 9.5);
	}

	/* this is for find the maximum between range of query */
	@Test // TODO not give correct result always
	public void queryAvgValueUtilTest() {
		double[] a = { 1, 3, 2, 7, 9, 11 };
		int n = a.length - 1;
		double[] t = SegmentTreeUtil.createSegmentTreeDouble(a);

		SegmentTreeUtil.constructAvgValueUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		// System.out.println(SegmentTreeUtil.queryAvgUtil(t, 0, n, 2, 4, 0));
		Assert.assertTrue(SegmentTreeUtil.queryAvgUtil(t, 0, n, 0, n, 0) == 5.75);
		Assert.assertTrue(SegmentTreeUtil.queryAvgUtil(t, 0, n, 0, 2, 0) == 2);
	}

	// public int getLazySum(int lazy[], int[] t, int[] a, int l, int r, int ql, int
	// qr, int e)
	/*
	 * public static void updateLazyRangeUtil(int lazy[], int[] t, int[] a, int l,
	 * int r, int ul, int ur, int e, int diff) {
	 */
	@Test
	public void getLazySumTest() {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		int lazy[] = new int[t.length];
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		int diff = 4;
		for (int i = 0; i <= n; i++)
			arr[i] += diff;
		SegmentTreeUtil.updateLazyRangeUtil(lazy, t, 0, n, 0, n, 0, diff);

		System.out.println(Arrays.toString(t));
		Assert.assertTrue(SegmentTreeUtil.getLazySum(lazy, t, 0, 5, 0, 5, 0) == 60);// sum-0-5
		Assert.assertTrue(SegmentTreeUtil.getLazySum(lazy, t, 0, 5, 0, 2, 0) == 21);// sum-0-2
		System.out.println(Arrays.toString(t));
	}

	@Test
	public void updateLazyRangeUtilTest() {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(arr);
		int lazy[] = new int[t.length];
		SegmentTreeUtil.constructSegmentTreeUtil(t, arr, 0, arr.length - 1, 0);
		int diff = 4;
		for (int i = 0; i <= n; i++)
			arr[i] += diff;
		SegmentTreeUtil.updateLazyRangeUtil(lazy, t, 0, n, 0, n, 0, diff);

		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 60);// sum-0-5
	}

	/* this is for construct the min max value utils */
	@Test
	public void constructMinMaxUtilTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		MinMaxNode[] t = SegmentTreeUtil.createSegmentTreeMaxMin(arr);
		SegmentTreeUtil.constructMinMaxUtil(t, arr, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0].max == 11);// sum-0-5
		Assert.assertTrue(t[0].min == 1);// sum-0-5
	}

	/* construct the query for min max in array together */
	@Test
	public void queryMinMaxUtilTest() {

		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length - 1;
		MinMaxNode[] t = SegmentTreeUtil.createSegmentTreeMaxMin(arr);
		SegmentTreeUtil.constructMinMaxUtil(t, arr, 0, n, 0);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 0, n, 0).min == 1);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 0, n, 0).max == 11);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 0, 2, 0).min == 1);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 0, 2, 0).max == 5);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 2, 4, 0).min == 5);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 2, 4, 0).max == 9);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 1, 4, 0).min == 3);
		Assert.assertTrue(SegmentTreeUtil.queryMinMaxUtil(t, 0, n, 1, 4, 0).max == 9);
	}

	/* this is for construct tree such that root is lcm of its child */
	@Test
	public void costructLCMUtilTest() {

		int a[] = { 2, 4, 8, 3, 6, 9 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructLCMUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 72);
		Assert.assertTrue(t[1] == 8);
		Assert.assertTrue(t[2] == 18);
	}

	/* this is for find the lcm range of query */
	@Test
	public void queryLCMUtilTest() {

		int a[] = { 2, 4, 8, 3, 6, 9 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructLCMUtil(t, a, 0, n, 0);
		Assert.assertTrue(SegmentTreeUtil.queryLCMUtil(t, 0, n, 0, n, 0) == 72);
		Assert.assertTrue(SegmentTreeUtil.queryLCMUtil(t, 0, n, 0, 2, 0) == 8);
		Assert.assertTrue(SegmentTreeUtil.queryLCMUtil(t, 0, n, 2, 4, 0) == 24);
		Assert.assertTrue(SegmentTreeUtil.queryLCMUtil(t, 0, n, 1, 4, 0) == 24);
	}

	/* this is for construct tree such that root is lcm of its child */
	@Test
	public void costructGCDUtilTest() {

		int a[] = { 2, 4, 8, 3, 6, 9 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructGCDUtil(t, a, 0, n, 0);
		// System.out.println(Arrays.toString(t));
		Assert.assertTrue(t[0] == 1);
		Assert.assertTrue(t[1] == 2);
		Assert.assertTrue(t[2] == 3);
	}

	/* this is for find the lcm range of query */
	@Test
	public void queryGCDUtilTest() {

		int a[] = { 2, 4, 8, 3, 6, 9 };
		int n = a.length - 1;
		int[] t = SegmentTreeUtil.createSegmentTree(a);
		SegmentTreeUtil.costructGCDUtil(t, a, 0, n, 0);
		Assert.assertTrue(SegmentTreeUtil.queryGCDUtil(t, 0, n, 0, n, 0) == 1);
		Assert.assertTrue(SegmentTreeUtil.queryGCDUtil(t, 0, n, 0, 2, 0) == 2);
		Assert.assertTrue(SegmentTreeUtil.queryGCDUtil(t, 0, n, 2, 4, 0) == 1);
		Assert.assertTrue(SegmentTreeUtil.queryGCDUtil(t, 0, n, 1, 4, 0) == 1);
	}
}
