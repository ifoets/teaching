package com.design.analysis.core.algo.greedyalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArraysGreedyAlgoTest {

	IArraysGreedyAlgo iaga = null;

	@Before
	public void init() {
		iaga = new ArraysGreedyAlgoImpl();
	}

	/** 1. Minimum product subset of an array **/
	@Test
	public void minProductSubArrTest() {

		int a[] = { -1, -1, -2, 4, 3 };
		Assert.assertTrue(iaga.minProductSubArr(a) == -24);

		int b[] = { -1, 0 };
		Assert.assertTrue(iaga.minProductSubArr(b) == -1);

		int c[] = { 0, 0, 0, 0, 0 };
		Assert.assertTrue(iaga.minProductSubArr(c) == 0);

		int d[] = { 8, 7, 2, 0, 1 };
		Assert.assertTrue(iaga.minProductSubArr(d) == 0);

		int e[] = { -8, -7, -2, 0, -1 };
		Assert.assertTrue(iaga.minProductSubArr(e) == -112);
	}

	@Test
	public void minProductSubArrTestX() {

		int a[] = { -1, -1, -2, 4, 3 };
		Assert.assertTrue(iaga.minProductSubArrX(a) == -24);

		int b[] = { -1, 0 };
		Assert.assertTrue(iaga.minProductSubArrX(b) == -1);

		int c[] = { 0, 0, 0, 0, 0 };
		Assert.assertTrue(iaga.minProductSubArrX(c) == 0);

		int d[] = { 8, 7, 2, 0, 1 };
		Assert.assertTrue(iaga.minProductSubArrX(d) == 0);

		int e[] = { -8, -7, -2, 0, -1 };
		Assert.assertTrue(iaga.minProductSubArrX(e) == -112);
	}

	/** 2. Maximum product subset of an array **/
	@Test
	public void maxProductSubArrTest() {
		int a[] = { -1, -1, -2, 4, 3 };
		Assert.assertTrue(iaga.maxProductSubArr(a) == 24);

		int b[] = { -1, 0 };
		Assert.assertTrue(iaga.maxProductSubArr(b) == 1);

		int c[] = { 0, 0, 0, 0, 0 };
		Assert.assertTrue(iaga.maxProductSubArr(c) == 0);

		int d[] = { 8, 7, 2, 0, 1 };
		Assert.assertTrue(iaga.maxProductSubArr(d) == 112);

		int e[] = { -8, -7, -2, 0, -1 };
		Assert.assertTrue(iaga.maxProductSubArr(e) == 112);
	}

	/** 3. Maximize array sum after k-negations | Set 1 **/
	@Test
	public void maxSumWithKNegationTest() {
		int a[] = { -2, 0, 5, -1, 2 };
		int k = 4;
		Assert.assertTrue(iaga.maxSumArrWithKNegationX(a, k) == 10);
	}

	@Test
	public void maxSumWithKNegationZTest() {
		int a[] = { -2, 0, 5, -1, 2 };
		int k = 4;
		Assert.assertTrue(iaga.maxSumArrWithKNegationZ(a, k) == 10);
	}

	/* max sub array sum after k-negations */
	@Test
	public void maxSumSubArrWithKNegationTest() {
		int a[] = { -2, 0, 5, -1, 2, -30, 16, -20, -4 };
		int k = 3;
		Assert.assertTrue(iaga.maxSumSubArrWithKNegation(a, k) == 77);
	}

	/** 4. Maximize array sum after k-negations | Set 2 **/
	@Test
	public void maxSumArrWithKNegationYTest() {
		int a[] = { -2, 0, 5, -1, 2 };
		int k = 4;
		Assert.assertTrue(iaga.maxSumArrWithKNegationY(a, k) == 10);
	}

	/** 5. Maximize the sum of arr[i]*i all r +ve element **/
	@Test
	public void maxSumOfElemMultiByIndexTest() {
		int a[] = { 1, 5, 4, 2, 3 };
		Assert.assertTrue(iaga.maxSumOfElemMultiByIndex(a) == 40);
	}

	// all type of element
	@Test
	public void maxSumOfElemMultiByIndexXTest() {
		int a[] = { 1, -5, 0, 2, 3 };
		Assert.assertTrue(iaga.maxSumOfElemMultiByIndexX(a) == 20);
	}

	/** 6. Maximum sum of increasing order elements from n arrays **/
	@Test
	public void maxSumIncrOrderFromNArrsTest() {
		int a[][] = { { 1, 7, 3, 4 }, { 4, 2, 5, 1 }, { 9, 5, 1, 8 } };
		Assert.assertTrue(iaga.maxSumIncrOrderFromNArrs(a) == 18);
		int b[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		Assert.assertTrue(iaga.maxSumIncrOrderFromNArrs(b) == 0);
	}

	@Test
	public void minSumIncrOrderFromNArrsTest() {
		int a[][] = { { 1, 7, 3, 4 }, { 4, 2, 5, 1 }, { 9, 5, 1, 8 } };
		Assert.assertTrue(iaga.minSumIncrOrderFromNArrs(a) == 8);
		int b[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		Assert.assertTrue(iaga.minSumIncrOrderFromNArrs(b) == 7);
	}

	/** 7. Maximum sum of absolute difference of an array **/
	@Test
	public void maxSumOfAbsDiffTest() {
		int a[] = { 1, 2, 4, 8 };
		Assert.assertTrue(iaga.maxSumOfAbsDiff(a) == 18);
	}

	/** 8. Maximize sum of consecutive differences in a circular array **/
	@Test
	public void maxSumOfConscutiveDiffInCircularArrTest() {
		int a[] = { 1, 2, 4, 8 };
		Assert.assertTrue(iaga.maxSumOfConscutiveDiffInCircularArr(a) == 18);
	}

	/** 9. Maximum height pyramid from the given array of objects **/
	@Test
	public void maxHeightPyramidTest() {
		int[] boxes = { 10, 20, 30, 50, 60, 70 };
		Assert.assertTrue(iaga.maxHeightPyramid(boxes) == 3);
	}

	/**
	 * 10. Partition into two subarrays of lengths k and (N – k) such that the
	 * difference of sums is maximum
	 **/
	@Test
	public void partitionForMaxDiffSumTest() {
		int a[] = { 8, 4, 5, 2, 10 };
		int k = 2;
		Assert.assertTrue(iaga.partitionForMaxDiffSum(a, k) == 17);
	}

	/** 11. Minimum sum of product of two arrays **/
	@Test
	public void minSumOfProductsTest() {
		int a[] = { 2, 3, 4, 5, 4 };
		int b[] = { 3, 4, 2, 3, 2 };
		int k = 3;
		Assert.assertTrue(iaga.minSumOfProducts(a, b, k) == 25);
	}

	/** 12. Minimum sum by choosing minimum of pairs from array **/
	@Test
	public void minSumByChooseMinOfPairTest() {
		int a[] = { 3, 6, 2, 8, 7, 5 };
		Assert.assertTrue(iaga.minSumByChooseMinOfPair(a) == 10);
	}

	/** 13. Minimum sum of absolute difference of pairs of two arrays **/
	@Test
	public void minSumAbsDiffOfTwoArrsTest() {
		int a[] = { 4, 1, 8, 7 };
		int b[] = { 2, 3, 6, 5 };
		Assert.assertTrue(iaga.minSumAbsDiffOfTwoArrs(a, b) == 6);
	}

	/* Maximum sum of absolute difference of pairs of two arrays */
	@Test
	public void maxSumAbsDiffOfTwoArrsTest() {
		int a[] = { 4, 1, 8, 7 };
		int b[] = { 2, 3, 6, 5 };
		Assert.assertTrue(iaga.maxSumAbsDiffOfTwoArrs(a, b) == 16);
	}

	/** 14. Minimum operations to make GCD of array a multiple of k **/
	@Test
	public void minOprToMakeGcdOfArrMultiOfKTest() {
		int a[] = { 4, 5, 6 };
		int k = 5;
		Assert.assertTrue(iaga.minOprToMakeGcdOfArrMultiOfK(a, k) == 2);
	}

	/** 15. Minimum sum of absolute difference of pairs of two arrays **/
	/* @See 13. */
	/* 16. Minimum sum of two numbers formed from digits of an array */
	@Test
	public void minSumOfTwoNummByArray() {
		int arr[] = { 6, 8, 4, 5, 2, 3 };
		Assert.assertTrue(iaga.minSumOfTwoNummByArray(arr) == 604);
	}

	/* min product */
	// @idea sort and multiple by first no with rest of no building
	@Test
	public void minProdOfTwoNummByArrayTest() {
		int arr[] = { 4, 5, 2, 3 };
		Assert.assertTrue(iaga.minProdOfTwoNummByArray(arr) == 690);
	}
	/* 17. Minimum increment/decrement to make array non-Increasing */
	/* 18. Making elements of two arrays same with minimum increment/decrement */
	/* 19. Minimize sum of product of two arrays with permutation allowed */
	/* 20. Sorting array with reverse around middle */
	/* 21. Sum of Areas of Rectangles possible for an array */
	/* 22. Array element moved by k using single moves */
	/* 23. Find if k bookings possible with given arrival and departure times */
	/* 24. Lexicographically smallest array after at-most K consecutive swaps */
	/* 25. Largest lexicographic array with at-most K consecutive swaps */
}
