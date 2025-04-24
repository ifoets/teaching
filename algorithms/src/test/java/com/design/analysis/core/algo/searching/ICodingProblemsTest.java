package com.design.analysis.core.algo.searching;

import java.util.List;

import com.design.analysis.core.algo.searching.model.FreqWord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ICodingProblemsTest {

	public ICodingProblems icp = null;

	@Before
	public void init() {
		icp = new CodingProblemsImpl();
	}

	/** 1. Find the Missing Number **/
	@Test
	public void missNumberTest() {
		int a[] = { 1, 2, 4, 6, 0, 3, 7, 8 };
		Assert.assertTrue(icp.missNumber(a) == 5);
	}

	/** 2. Search an element in a sorted and rotated array **/
	@Test
	public void searchInSortedAndRotatedArrTest() {
		int b[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		// System.out.println(iar.searchInSortedRotatedArr(b, 4));
		Assert.assertTrue(icp.searchInSortedAndRotatedArr(b, 8) == 4);
		Assert.assertTrue(icp.searchInSortedAndRotatedArr(b, 3) == 8);
		Assert.assertTrue(icp.searchInSortedAndRotatedArr(b, 4) == 0);
	}

	/** 3. Median of two sorted arrays O(log(n)). **/
	@Test
	public void medianOfTwoSortedArrTest() {
		int a[] = { 1, 3 };
		int b[] = { 2, 4 };
		Assert.assertTrue(icp.medianOfTwoSortedArr(a, b) == 2);

		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };
		Assert.assertTrue(icp.medianOfTwoSortedArr(ar1, ar2) == 16);
	}

	// having space O(n) but for any tow arrays
	@Test
	public void medianOfTwoSortedArrXTest() {
		int a[] = { 1, 3 };
		int b[] = { 2, 4 };
		Assert.assertTrue(icp.medianOfTwoSortedArrX(a, b) == 2);

		int a1[] = { 1, 3 };
		int b1[] = { 2, 4, 5 };
		Assert.assertTrue(icp.medianOfTwoSortedArrX(a1, b1) == 3);

		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };
		Assert.assertTrue(icp.medianOfTwoSortedArrX(ar1, ar2) == 16);
	}

	/** 4. Two elements whose sum is closest to zero **/
	@Test
	public void sumCloseToZeroTest() {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		arr = icp.sumCloseToZero(arr);
		Assert.assertTrue(arr[0] == -80);
		Assert.assertTrue(arr[1] == 85);

		int b[] = { -1, 5, -2, 8, -3, 9, -4 };
		arr = icp.sumCloseToZero(b);
		Assert.assertTrue(arr[0] == -4);
		Assert.assertTrue(arr[1] == 5);
	}

	/** 6. Maximum and minimum of an array using minimum number of comparisons **/
	@Test
	public void maxMinInMinComparisionTest() {
		int b[] = { -1, 5, -2, 8, -3, 9, -4 };
		b = icp.maxMinInMinComparision(b);
		Assert.assertTrue(b[0] == -4);
		Assert.assertTrue(b[1] == 9);
	}

	/** 8. Ceiling in a sorted array **/
	@Test
	public void ceillingInSortedArrTest() {

		int a[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = a.length - 1;
		Assert.assertTrue(icp.ceillingInSortedArr(a, 0, 0, n) == 1);
		Assert.assertTrue(icp.ceillingInSortedArr(a, 20, 0, n) == -1);
		Assert.assertTrue(icp.ceillingInSortedArr(a, 1, 0, n) == 1);
		Assert.assertTrue(icp.ceillingInSortedArr(a, 5, 0, n) == 8);
	}

	@Test
	public void floorInSortedArrTest() {

		int a[] = { 1, 2, 8, 10, 10, 12, 19 };
		int n = a.length - 1;
		Assert.assertTrue(icp.floorInSortedArr(a, 0, 0, n) == -1);
		Assert.assertTrue(icp.floorInSortedArr(a, 20, 0, n) == 19);
		Assert.assertTrue(icp.floorInSortedArr(a, 1, 0, n) == 1);
		Assert.assertTrue(icp.floorInSortedArr(a, 5, 0, n) == 2);
	}

	/** 9. Count number of occurrences (or frequency) in a sorted array **/
	/* Refer @IBinarySearchBased.java...point @4. sub program */

	/** 10. Find the repeating and the missing | Added 3 new methods **/
	@Test
	public void missingAndRepeatingInNNaturalTest() {
		int arr[] = { 1, 3, 4, 5, 5, 6, 2 };
		arr = icp.missingAndRepeatingInNNatural(arr);
		Assert.assertTrue(arr[0] == 5);
		Assert.assertTrue(arr[1] == 7);
	}

	@Test
	public void missingAndRepeatingInNNaturalXTest() {
		int arr[] = { 1, 3, 4, 5, 5, 6, 2 };
		arr = icp.missingAndRepeatingInNNaturalX(arr);
		Assert.assertTrue(arr[0] == 5);
		Assert.assertTrue(arr[1] == 7);
	}

	/** 11. Find a Fixed Point in a given array **/
	@Test
	public void fixedPointTest() {
		int arr[] = { -10, -5, 0, 3, 7 };
		Assert.assertTrue(icp.fixedPoint(arr, 0, arr.length - 1) == 3);
	}

	/** 12. max element in array which is first increasing and then decreasing **/
	@Test
	public void healInArrayTest() {
		int arr[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		Assert.assertTrue(icp.healInArray(arr, 0, arr.length - 1) == 500);

		int arra[] = { 1, 3, 50, 10, 9, 7, 6 };
		Assert.assertTrue(icp.healInArray(arra, 0, arra.length - 1) == 50);

		int a[] = { 10, 20, 30, 40, 50 };
		Assert.assertTrue(icp.healInArray(a, 0, a.length - 1) == 50);

		int b[] = { 120, 100, 80, 20, 0 };
		Assert.assertTrue(icp.healInArray(b, 0, b.length - 1) == 120);
	}

	@Test
	public void healInArrayXTest() {
		int arr[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		Assert.assertTrue(icp.healInArrayX(arr, 0, arr.length - 1) == 500);

		int arra[] = { 1, 3, 50, 10, 9, 7, 6 };
		Assert.assertTrue(icp.healInArrayX(arra, 0, arra.length - 1) == 50);

		int a[] = { 10, 20, 30, 40, 50 };
		Assert.assertTrue(icp.healInArrayX(a, 0, a.length - 1) == 50);

		int b[] = { 120, 100, 80, 20, 0 };
		Assert.assertTrue(icp.healInArrayX(b, 0, b.length - 1) == 120);
	}

	/** 13. Find a pair with the given difference **/
	@Test
	public void pairHaveXDiffTest() {
		int arr[] = { 1, 8, 30, 40, 100 };
		arr = icp.pairHaveXDiff(arr, 39);
		Assert.assertTrue(arr[0] == 1);
		Assert.assertTrue(arr[1] == 40);
	}

	/** 14. Find the k most frequent words from a file **/
	@Test
	public void kMostFrequentTest() {
		String str = "Welcome to the world of Geeks"
				+ "This portal has been created to provide well written well thought and well explained "
				+ "solutions for selected questions If you like Geeks for Geeks and would like to contribute "
				+ "here is your chance You can write article and mail your article to contribute at "
				+ "geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help "
				+ "thousands of other Geeks";
		String tokns[] = str.split(" ");
		List<FreqWord> rsList = icp.kMostFrequent(tokns, 5);
		// System.out.println(Arrays.toString(rsList.toArray()));
		// [(Geeks,5), (and,4), (to,4), (for,3), (your,3)]
		Assert.assertTrue(rsList.get(0).word.equals("Geeks"));
		Assert.assertTrue(rsList.get(0).frq == 5);
	}

	/** 15. Median of two sorted arrays of different sizes **/
	/* @See IBinarySearchBased.java @ 2...program */

	/** 16. Find a peak element **/
	@Test

	public void pickElementTest() {
		int arr[] = { 1, 3, 20, 4, 1, 0 };
		Assert.assertTrue(icp.pickElement(arr, 0, arr.length - 1, arr.length) == 20);
	}

	/**
	 * 17. Given an array of of size n and a number k, find all elements that appear
	 * more than n/k times
	 **/
	@Test
	public void elemMoreThanKTimesTest() {
		int a[] = { 3, 1, 2, 2, 1, 2, 3, 3 };
		List<Integer> rsList = icp.elemMoreThanKTimes(a, 4);
		Assert.assertTrue(rsList.size() == 2);
		Assert.assertTrue(rsList.get(0) == 3 || rsList.get(0) == 2);
		Assert.assertTrue(rsList.get(1) == 3 || rsList.get(1) == 2);
	}

	/** 18. Find the minimum element in a sorted and rotated array **/
	/*
	 * @see IArrayRotation.java...@ 5....a[findPivot(...)+1] ie next to poivot index
	 */
	/**
	 * 19. Kth smallest element in a row-wise and column-wise sorted 2D array | Set
	 * 1
	 */
	/* @see @IOrderStatistics.java ...@2. program */

	/** 20. Find k closest elements to a given value sorted arr **/
	@Test
	public void kClogestElemInSotedArrTest() {
		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int x = 35, k = 4;
		arr = icp.kClogestElemInSotedArr(arr, x, k);
		int rs[] = { 39, 30, 42, 45 };
		for (int i = 0; i < rs.length; i++)
			Assert.assertTrue(rs[i] == arr[i]);
	}

	/** 21. Search in an almost sorted array **/
	@Test
	public void searchInAlmostSotedArrTest() {
		int a[] = { 3, 2, 10, 4, 40 };
		Assert.assertTrue(icp.searchInAlmostSotedArr(a, 4) == 3);
	}

	/** 23. Find the first repeating element in an array of integers **/
	@Test
	public void firstRepetingElemTest() {
		int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
		int brr[] = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
		Assert.assertTrue(icp.firstRepetingElem(arr) == 5);
		Assert.assertTrue(icp.firstRepetingElem(brr) == 6);
	}

	/** 24. Find common elements in three sorted arrays **/
	@Test
	public void commonIn3ArrsTest() {

		int ar1[] = { 1, 5, 10, 20, 40, 80 };
		int ar2[] = { 6, 7, 20, 80, 100 };
		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
		// Output: 20, 80
		List<Integer> list = icp.commonIn3Arrs(ar1, ar2, ar3);
		Assert.assertTrue(list.get(0) == 20);
		Assert.assertTrue(list.get(1) == 80);
		int ar11[] = { 1, 5, 5 };
		int ar21[] = { 3, 4, 5, 5, 10 };
		int ar31[] = { 5, 5, 10, 20 };
		// Output: 5, 5
		list = icp.commonIn3Arrs(ar11, ar21, ar31);
		Assert.assertTrue(list.get(0) == 5);
		Assert.assertTrue(list.get(1) == 5);
	}

	/** 25. Count 1 s in a sorted binary array **/
	@Test
	public void countOneInBinaryArrTest() {
		int arr[] = { 1, 1, 1, 1, 0, 0, 0 };
		Assert.assertTrue(icp.countOneInBinaryArr(arr, 0, arr.length - 1) == 4);
	}

	/**
	 * 26. Given a sorted array and a number x, find the pair in array whose sum is
	 * closest to x
	 **/
	@Test
	public void sumCLogestToXTest() {

		int arr[] = { 10, 22, 28, 29, 30, 40 };
		int x = 54;
		List<Integer> list = icp.sumCLogestToX(arr, x);
		Assert.assertTrue(list.get(0) == 22);
		Assert.assertTrue(list.get(1) == 30);
	}

	/** 27. Find the closest pair from two sorted arrays **/
	@Test
	public void sumCLogestToX2ArrTest() {
		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int x = 38;
		List<Integer> list = icp.sumCLogestToX(ar1, ar2, x);
		Assert.assertTrue(list.get(0) == 7);
		Assert.assertTrue(list.get(1) == 30);
	}
	/** 28. Kth Smallest/Largest Element in Unsorted Array | Set 1 **/
    public ICodingProblemsTest() {
        super();
    }
    /**
	 * 29. Kth Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	/**
	 * 30. K th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case
	 * Linear Time)
	 **/
	/* all above are common for minimum complxity O(k*n) */
	/* @see @IOrderStatistics.java.. 1....program */

	/** 31. Find position of an element in a sorted array of infinite numbers **/
	@Test // @Amazn
	public void posInInfiniteLenArrTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int pos = icp.posInInfiniteLenArr(a, 5, 1000, Integer.MAX_VALUE);
		Assert.assertTrue(pos == 4);
	}

	/**
	 * 32. Given a sorted and rotated array, find if there is a pair with a given
	 * sum
	 **/
	/* in single array */
	@Test
	public void sumEqualToXTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> list = icp.sumEqualToX(a, 12);
		Assert.assertTrue(list.get(0) == 9 || list.get(0) == 3);
		Assert.assertTrue(list.get(1) == 9 || list.get(1) == 3);
	}

	/* it two array */
	@Test
	public void sumEqualToX2ArrTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		List<Integer> list = icp.sumEqualToX(a, b, 95);
		Assert.assertTrue(list.get(0) == 5 || list.get(0) == 90);
		Assert.assertTrue(list.get(1) == 5 || list.get(1) == 90);
	}

	/** 33. Find the largest pair sum in an unsorted array **/
	@Test
	public void largestPairTest() {
		int a[] = { 1, 20, 3, 40, 5, 60, 7, 80, 9 };
		List<Integer> list = icp.largestPair(a);
		Assert.assertTrue(list.get(0) == 80);
		Assert.assertTrue(list.get(1) == 60);
	}

	/** 34. Find the nearest smaller numbers on left side in an array **/
	@Test
	public void nearestSmallrOnLeftSideArrTest() {
		int a[] = { 1, 6, 4, 10, 2, 5 };
		int rs[] = { 0, 1, 1, 4, 1, 2 };
		a = icp.nearestSmallrOnLeftSideArr(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == rs[i]);
	}
	/** 35. K th largest element in a stream **/
	/* @see @IOrderStatistics.java....3....program8 */

	/** 36. Find a pair with maximum product in array of Integers **/
	/* this is same max sum pair just use the product without absloute */

	/** 37. Find the element that appears once in a sorted array O(logn) **/
	@Test
	public void uniqueElementTest() {
		int arr[] = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		// System.out.println(icp.uniqueElement(arr, 0, arr.length - 1));
		Assert.assertTrue(icp.uniqueElement(arr, 0, arr.length - 1) == 2);
	}

	/** 38. Find the odd appearing element in O(Log n) time non sorted **/
	/* logn in unsorted array */
	@Test
	public void searchIndexTest() {
		int a[] = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		int n = a.length - 1;
		Assert.assertTrue(icp.searchIndex(a, 0, n, 3) == 4);
		Assert.assertTrue(icp.searchIndex(a, 0, n, 4) == 6);
		Assert.assertTrue(icp.searchIndex(a, 0, n, 5) == 8);
	}

	@Test
	public void oddAppearingTest() {
		int arr[] = { 1, 1, 2, 2, 1, 1, 2, 2, 13, 1, 1, 40, 40 };
		Assert.assertTrue(icp.uniqueElement(arr, 0, arr.length - 1) == 13);
	}

	/** 39. Find the largest three elements in an array O(n) **/
	@Test
	public void largestThreeElementTest() {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
		int b[] = { 12, 13, 34 };
		arr = icp.largestThreeElement(arr);
		// System.out.println(Arrays.toString(arr));
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(arr[i] == b[i]);
	}
}
