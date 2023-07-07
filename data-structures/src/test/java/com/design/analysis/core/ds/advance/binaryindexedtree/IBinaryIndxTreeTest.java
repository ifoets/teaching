package com.design.analysis.core.ds.advance.binaryindexedtree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBinaryIndxTreeTest {

	public IBinaryIndxTree ibit = null;

	@Before
	public void init() {
		ibit = new BinaryIndxTreeImpl();
	}

	@Test
	public void parentIndexTest() {
		for (int i = 0; i <= 12; i++)
			System.out.println(i + "::->" + ibit.parentIndex(i));
	}

	/** 1. Binary Indexed Tree or Fenwick Tree **/
	@Test
	public void createBITreeTest() {
		int arr[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int bitree[] = ibit.createBITree(arr, arr.length);
		// System.out.println(Arrays.toString(bitree));
		// [0, 2, 3, 1, 7, 2, 5, 4, 21, 6, 13, 8, 30]
		Assert.assertTrue(bitree[0] == 0);
		Assert.assertTrue(bitree[1] == 2);
		Assert.assertTrue(bitree[3] == 1);
		Assert.assertTrue(bitree[4] == 7);
		Assert.assertTrue(bitree[bitree.length - 1] == 30);
	}

	@Test
	public void getSumTest() {
		int arr[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int bitree[] = ibit.createBITree(arr, arr.length);
		Assert.assertTrue(ibit.getSum(bitree, 5) == 12);
		Assert.assertTrue(ibit.getSum(bitree, 6) == 16);
	}

	@Test
	public void updateBITreeTest() {
		int arr[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int bitree[] = ibit.createBITree(arr, arr.length);
		arr[3] += 6;
		ibit.updateBITree(bitree, arr.length, 3, 6);
		Assert.assertTrue(ibit.getSum(bitree, 5) == 18);
		Assert.assertTrue(ibit.getSum(bitree, 6) == 22);
	}
	// TODO testig below
}
