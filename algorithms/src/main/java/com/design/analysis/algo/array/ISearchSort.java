package com.design.analysis.algo.array;

import java.util.List;

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
public interface ISearchSort {

	/** 1. Search, insert and delete in an unsorted array **/
	public boolean searchInsertDelUnsortedArr(int a[], int n, int x, String flage);

	/** 2. Search, insert and delete in an sorted array **/
	public boolean searchInsertDelSortedArr(int a[], int n, int x, String flage);

	/**
	 * 3. Given an array A[] and a number x, check for pair in A[] with sum as x
	 **/
	public List<List<Integer>> pairOfSumX(int a[], int x);

	/** 4. Majority Element **/
	public Integer majorityElement(int a[]);

	/** 5. Find the Number Occurring Odd Number of Times **/
	public List<Integer> oddNumberOfTimes(int a[]);

	/** 6. Find the Missing Number **/
	public int missingNumber(int a[]);

	/** 7. Merge an array of size n into another array of size m+n **/
	public int[] meargeNArrToMNArr(int mnArr[], int nArr[]);

	/** 8.Leaders in an array **/
	public List<Integer> findLeader(int a[]);

	/** 9. Sort elements by frequency | Set 1 **/
	public void sortByfriquency(int a[]);

	/** 10. Count Inversions in an array | Set 1 (Using Merge Sort) **/
}
