package com.design.analysis.core.algo.divideandconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.design.analysis.core.algo.divideandconquer.model.Point;
import org.junit.Assert;
/*
 * Standard Algorithms :
1.	Intoduction to Divide and Conquer
2.	Binary Search
3.	Merge Sort
4.	Quick Sort
5.	Calculate pow(x, n)
6.	Closest Pair of Points
7.	Strassen�s Matrix Multiplication
8.	Karatsuba algorithm for fast multiplication
9.	Count Inversions
10.	Multiply two polynomials
11.	Tiling Problem
12.	Convex Hull (Simple Divide and Conquer Algorithm)
13.	Quickhull Algorithm for Convex Hull

 */
import org.junit.Before;
import org.junit.Test;

public class IStandardAlgoTest {

	IStandardAlgo isa = null;

	@Before
	public void init() {

		isa = new StandardAlgoImpl();
	}

	/** 0.1 Find the element in non sorted array using D&C **/
	@Test
	public void serchInNonSortedArrTest() {

		int a[] = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		int n = a.length - 1;
		Assert.assertTrue(isa.serchInNonSortedArr(a, 9, 0, n) == 1);
		Assert.assertTrue(isa.serchInNonSortedArr(a, 6, 0, n) == 7);
		Assert.assertTrue(isa.serchInNonSortedArr(a, 3, 0, n) == 4);
		Assert.assertTrue(isa.serchInNonSortedArr(a, 7, 0, n) == 5);

		/* negative case */
		Assert.assertTrue(isa.serchInNonSortedArr(a, 10, 0, n) == -1);
		Assert.assertTrue(isa.serchInNonSortedArr(null, 7, 0, n) == -1);
	}

	/** 0.2 Find sum of even indexed element array using D&C **/
	@Test
	public void sumOfEvenLableIndexedTest() {
		int a[] = { 1, 2, 3 };
		Assert.assertTrue(isa.sumOfEvenLableIndexed(a, 0, a.length - 1, 0) == 4);
		int b[] = { 1, 2 };
		Assert.assertTrue(isa.sumOfEvenLableIndexed(b, 0, b.length - 1, 0) == 1);

		int c[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.sumOfEvenLableIndexed(c, 0, c.length - 1, 0) == 25);

	}

	/** 0.3 Find sum of element array using D&C **/
	@Test
	public void sumOfArrElementTest() {
		int a[] = { 1, 2, 3 };
		Assert.assertTrue(isa.sumOfArrElement(a, 0, a.length - 1) == 6);
		int b[] = { 1, 2 };
		Assert.assertTrue(isa.sumOfArrElement(b, 0, b.length - 1) == 3);

		int c[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.sumOfArrElement(c, 0, c.length - 1) == 45);
	}

	/** 1. Intoduction to Divide and Conquer **/
	/*
	 * 1. Divide: Break the given problem into subproblems of same type. 2.Conquer:
	 * Recursively solve these subproblems. 3. Combine: Appropriately combine the
	 * answers
	 */

	/** 2. Binary Search **/
	@Test
	public void binarySearchTest() {
		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.binarySearch(a, 0, 0, 1) == null);
		Assert.assertTrue(isa.binarySearch(b, 0, b.length - 1, 1) == null);
		Assert.assertTrue(isa.binarySearch(c, 0, c.length - 1, 1) == 0);
		Assert.assertTrue(isa.binarySearch(d, 0, d.length - 1, 7) == 6);
		Assert.assertTrue(isa.binarySearch(d, 0, d.length - 1, 10) == null);
		Assert.assertTrue(isa.binarySearch(d, 0, d.length - 1, 9) == 8);

		int a1[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
		Assert.assertTrue(isa.binarySearch(a1, 5, 8, 85) == 8);
	}

	/** 3. Randomized Binary Search Algorithm **/
	@Test
	public void randomizedBinarySearchTest() {
		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.randomizedBinarySearch(a, 0, 0, 1) == null);
		Assert.assertTrue(isa.randomizedBinarySearch(b, 0, b.length - 1, 1) == null);
		Assert.assertTrue(isa.randomizedBinarySearch(c, 0, c.length - 1, 1) == 0);
		Assert.assertTrue(isa.randomizedBinarySearch(d, 0, d.length - 1, 7) == 6);
		Assert.assertTrue(isa.randomizedBinarySearch(d, 0, d.length - 1, 10) == null);
		Assert.assertTrue(isa.randomizedBinarySearch(d, 0, d.length - 1, 9) == 8);

		int a1[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
		Assert.assertTrue(isa.randomizedBinarySearch(a1, 5, 8, 85) == 8);
	}

	/** 4. Merge Sort **/

	/* merging two sorted array */
	@Test
	public void mergeTwoPartSortedTest() {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		isa.mergeTwoPartSorted(a, 0, 5, a.length - 1);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[4] == 5);
		Assert.assertTrue(a[8] == 9);
		int b[] = { 1, 2, 3, 7, 8, 9, 4, 5, 6 };
		isa.mergeTwoPartSorted(b, 4, 6, b.length - 1);
		// System.out.println(Arrays.toString(b));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[4] == 5);
		Assert.assertTrue(a[8] == 9);
	}

	/* merge sort */
	// @Test
	public void mergeSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.mergeSort(a, 0, a.length - 1);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** 5. Quick Sort **/
	@Test
	public void quickSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.quickSort(a, 0, a.length - 1);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** 6. Tiling Problem **/
	@Test // Negative test case give StackOverflow//TODO
	public void fillMissingCellByLShapeSmallCellTest() {

		int n = 8;
		int a[][] = new int[n][n];
		a[2][3] = 1;
		int b[][] = new int[2][2];
		// make b L shape
		b[0][0] = 1;
		b[0][1] = 1;
		b[1][0] = 0;
		b[1][1] = 1;
		System.out.println(isa.fillMissingCellByLShapeSmallCell(a, 0, 0, 8, 8, b, 2));
	}

	/** 7. Count Inversions **/
	@Test
	public void countInversionTest() {
		int arr[] = { 1, 20, 6, 4, 5 };
		int temp[] = new int[arr.length];
		Assert.assertTrue(isa.countInversion(arr, temp, 0, arr.length - 1) == 5);
	}

	/** 8. Calculate pow(x, n) **/
	@Test
	public void powerOfXtoNTest() {
		// System.out.println(isa.powerOfXtoN(2, -3));
		Assert.assertTrue(isa.powerOfXtoN(2, 3) == 8.0);
		Assert.assertTrue(isa.powerOfXtoN(2, -3) == 0.125);
	}

	/** 9. Closest Pair of Points **/
	/** 10. Closest Pair of Points | O(nlogn) Implementation **/
	@Test
	public void clogestPointsTest() {
		List<Point> lp = new ArrayList<>();
		int a[][] = { { 4, 5 }, { 0, 0 }, { 2, 3 }, { 1, 1 } };

		for (int i = 0; i < a.length; i++)
			lp.add(new Point(a[i][0], a[i][1]));
		lp = isa.clogestPoints(lp);
		Assert.assertTrue(lp.get(0).x == 0 && lp.get(0).y == 0 && lp.get(1).x == 1 && lp.get(1).y == 1);

		int b[][] = { { 2, 3 }, { 12, 30 }, { 40, 50 }, { 5, 1 }, { 12, 10 }, { 3, 4 } };

		lp = new ArrayList<>();
		for (int i = 0; i < b.length; i++)
			lp.add(new Point(b[i][0], b[i][1]));

		lp = isa.clogestPoints(lp);
		Assert.assertTrue(lp.get(0).x == 2 && lp.get(0).y == 3 && lp.get(1).x == 3 && lp.get(1).y == 4);
		System.out.println(Math.sqrt(
				Math.pow(Math.abs(lp.get(0).x - lp.get(1).x), 2) + Math.pow(Math.abs(lp.get(0).y - lp.get(1).y), 2)));
	}

	/** 11. Multiply two polynomials **/
	@Test
	public void multiplyTwoPolynomialTest() {
		int a[] = { 5, 0, 10, 6 };
		int b[] = { 1, 2, 4 };
		int prod[] = { 5, 10, 30, 26, 52, 24 };
		int c[] = isa.multiplyTwoPolynomial(a, b);
		for (int i = 0; i < prod.length; i++)
			Assert.assertTrue(prod[i] == c[i]);
	}

	/** 12. Strassen�s Matrix Multiplication **/
	@Test
	public void matrixMultiplicationTest() {

		int a[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		int b[][] = { { 1, 2, 3 }, { 3, 4, 5 } };
		int c[][] = isa.matrixMultiplication(a, b);
		Assert.assertTrue(c.length == 3 && c[0].length == 3);

	}

	// TODO
	/** 13. The Skyline Problem **/

	/** 14. Maximum Subarray Sum **/
	@Test
	public void maxSubArraySumTest() {
		int arr[] = { 2, 3, 4, 5, 7 };
		int brr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
		Assert.assertTrue(isa.maxSubArraySum(arr, 0, arr.length - 1) == 21);
		Assert.assertTrue(isa.maxSubArraySum(brr, 0, brr.length - 1) == 7);
	}

	@Test
	public void maxCrossingSumTest() {
		//int arr[] = { 2, 3, 4, 5, 7 };
		int brr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
		//Assert.assertTrue(isa.maxCrossingSum(arr, 0, (arr.length - 1) / 2, arr.length - 1) == 21);
		Assert.assertTrue(isa.maxCrossingSum(brr, 0, (brr.length - 1) / 2, brr.length - 1) == 7);
	}

	/** 15. Longest Common Prefix **/
	@Test
	public void longestCommonPrefixTest() {
		String str1[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		Assert.assertTrue(isa.longestCommonPrefix(str1, 0, str1.length - 1).equals("gee"));

		String str2[] = { "apple", "ape", "april" };
		Assert.assertTrue(isa.longestCommonPrefix(str2, 0, str2.length - 1).equals("ap"));
	}

	/** 16. Search in a Row-wise and Column-wise Sorted 2D Array **/
	public void searchTest() {

	}
	/** 17. Karatsuba algorithm for fast multiplication **/
}
