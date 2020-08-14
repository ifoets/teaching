package com.design.analysis.algo.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Searching and Sorting :
1.	Search, insert and delete in an unsorted array
2.	Search, insert and delete in a sorted array
3.	Given an array A[] and a number x, check for pair in A[] with sum as x
4.	Majority Element
5.	Find the Number Occurring Odd Number of Times
6.	Find the Missing Number
7.	Merge an array of size n into another array of size m+n
8.	Leaders in an array
9.	Sort elements by frequency | Set 1
10.	Count Inversions in an array | Set 1 (Using Merge Sort)
11.	Two elements whose sum is closest to zero
12.	Check for Majority Element in a sorted array
13.	Union and Intersection of two sorted arrays
14.	Ceiling in a sorted array
15.	Find the two repeating elements in a given array
16.	Sort an array of 0s, 1s and 2s
17.	Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
18.	Equilibrium index of an array
19.	Count number of occurrences (or frequency) in a sorted array
20.	Find the repeating and the missing | Added 3 new methods
21.	Median in a stream of integers (running integers)
22.	Find a Fixed Point in a given array
23.	Find sub-array with given sum
24.	Find a triplet that sum to a given value
25.	Find the two numbers with odd occurrences in an unsorted array
26.	Find a pair with the given difference
27.	Find four elements that sum to a given value | Set 1 (n^3 solution)
28.	Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution)
29.	Median of two sorted arrays of different sizes
30.	Count the number of possible triangles
31.	Find a peak element
32.	Find number of pairs (x, y) in an array such that x^y > y^x
33.	Count all distinct pairs with difference equal to k
34.	Find if there is a sub-array with 0 sum
35.	Given a sorted array and a number x, find the pair in array whose sum is closest to x
36.	Count 1’s in a sorted binary array
37.	Print All Distinct Elements of a given integer array
38.	Construct an array from its pair-sum array
39.	Find common elements in three sorted arrays
40.	Find the first repeating element in an array of integers
41.	Find position of an element in a sorted array of infinite numbers
42.	Check if a given array contains duplicate elements within k distance from each other
43.	Find the element that appears once
44.	Find Union and Intersection of two unsorted arrays
45.	Delete an element from array (Using two traversals and one traversal)
46.	Count frequencies of all elements in array in O(1) extra space and O(n) time
47.	Trapping Rain Water
48.	Count triplets with sum smaller than a given value
49.	Count Inversions of size three in a given array
50.	Merge two sorted arrays with O(1) extra space
51.	Find lost element from a duplicated array
52.	Count pairs with given sum

 */
public class ISearchSortTest {
	
	public ISearchSort iss = null;

	@Before
	public void init() {
		iss = new SearchSortImpl();
	}

	/** 1. Search, insert and delete in an unsorted array **/
	@Test
	public void searchInsertDelUnsortedArrTest() {
		int a[] = { 1, 3, 2, 5, 4, 6, 7, 8, 9 };

		Assert.assertTrue(iss.searchInsertDelUnsortedArr(a, a.length, 5, "S"));
		Assert.assertTrue(iss.searchInsertDelUnsortedArr(a, a.length, 5, "D"));
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(iss.searchInsertDelUnsortedArr(a, a.length, 10, "I") == false);
		Assert.assertTrue(iss.searchInsertDelUnsortedArr(a, 8, 10, "I") == true);
		// System.out.println(Arrays.toString(a));
	}

	/** 2. Search, insert and delete in an sorted array **/
	@Test
	public void searchInsertDelSortedArrTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Assert.assertTrue(iss.searchInsertDelSortedArr(a, a.length, 5, "S"));
		Assert.assertTrue(iss.searchInsertDelSortedArr(a, a.length, 15, "S") == false);
		Assert.assertTrue(iss.searchInsertDelSortedArr(a, a.length, 5, "D"));
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(iss.searchInsertDelSortedArr(a, a.length, 10, "I") == false);
		Assert.assertTrue(iss.searchInsertDelSortedArr(a, 8, 10, "I") == true);
	}

	/**
	 * 3. Given an array A[] and a number x, check for pair in A[] with sum as x
	 **/
	@Test
	public void pairOfSumXTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(iss.pairOfSumX(a, 6).size() == 2);
	}

	/** 4. Majority Element **/
	@Test
	public void majorityElementTest() {
		Assert.assertTrue(iss.majorityElement(null) == null);
		int a[] = {};
		Assert.assertTrue(iss.majorityElement(a) == null);

		int b[] = { 5 };
		Assert.assertTrue(iss.majorityElement(b) == 5);

		int c[] = { 1, 2, 3, 4, 5, 6, 7, 4, 7, 2, 3, 5, 1, 2, 5, 5, 5, 3, 4, 5, 5 };
		Assert.assertTrue(iss.majorityElement(c) == 5);
	}

	/** 5. Find the Number Occurring Odd Number of Times **/
	@Test
	public void oddNumberOfTimesTest() {

		Assert.assertTrue(iss.oddNumberOfTimes(null) == null);
		int a[] = {};
		Assert.assertTrue(iss.oddNumberOfTimes(a) == null);

		int b[] = { 5 };
		Assert.assertTrue(iss.oddNumberOfTimes(b).size() == 1);

		int c[] = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(iss.oddNumberOfTimes(c).size() == 4);
	}

	/** 6. Find the Missing **/
	@Test
	public void missingNumberTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 9 };
		Assert.assertTrue(iss.missingNumber(a) == 8);
	}

	/** 7. Merge an array of size n into another array of size m+n **/
	@Test
	public void meargeNArrToMNArrTest() {
		int mnArr[] = { 2, 0, 7, 0, 0, 10, 0 };
		int nArr[] = { 5, 8, 12, 14 };
		mnArr = iss.meargeNArrToMNArr(mnArr, nArr);
		Assert.assertTrue(mnArr[0] == 2);
		Assert.assertTrue(mnArr[mnArr.length - 1] == 14);
		// System.out.println(Arrays.toString(mnArr));
	}

	/** 8.Leaders in an array **/
	@Test
	public void findLeaderTest() {
		int a[] = { 16, 17, 4, 3, 5, 2, 1 };
		List<Integer> list = iss.findLeader(a);
		Assert.assertTrue(list.get(0) == 1);
		Assert.assertTrue(list.get(3) == 17);
	}

	/** 9. Sort elements by frequency | Set 1 **/
	@Test
	public void sortByfriquencyTest() {
		int a[] = { 5, 2, 2, 8, 5, 6, 8, 8 };
		iss.sortByfriquency(a);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[2] == 8);
		Assert.assertTrue(a[a.length - 1] == 6);
	}
}
