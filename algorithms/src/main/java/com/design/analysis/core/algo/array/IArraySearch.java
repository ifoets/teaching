package com.design.analysis.core.algo.array;

import java.util.List;

/*
 * 
 * @author GuruG
 * Searching :
1.	Search, insert and delete in an unsorted array
2.	Search, insert and delete in a sorted array
3.	Given an array A[] and a number x, check for pair in A[] with sum as x
4.	Searching in an array where adjacent differ by at most k
5.	Find common elements in three sorted arrays
6.	Find position of an element in a sorted array of infinite numbers
7.	Find the only repetitive element between 1 to n-1
8.	Find the element that appears once
9.	Maximum Subarray Sum Excluding Certain Elements
10.	Maximum equlibrium sum in an array
11.	Equilibrium index of an array
12.	Leaders in an array
13.	Ceiling in a sorted array
14.	Majority Element
15.	Check for Majority Element in a sorted array
16.	Check if an array has a majority element
17.	Two Pointers Technique
18.	Find a peak element
19.	Find the two repeating elements in a given array
20.	Find a Fixed Point in a given array
21.	Find sub-array with given sum
22.	Maximum triplet sum in array
23.	Smallest Difference Triplet from Three arrays
24.	Find a triplet that sum to a given value
25.	Find all triplets with zero sum

 */
public interface IArraySearch {

	/** 1. Search, insert and delete in an unsorted array **/
	public boolean searchInsertDelUnsortedArr(int a[], int n, int x, String flage);

	/** 2. Search, insert and delete in an sorted array **/
	public boolean searchInsertDelSortedArr(int a[], int n, int x, String flage);

	/**
	 * 3. Given an array A[] and a number x, check for pair in A[] with sum as x
	 **/
	public List<List<Integer>> pairOfSumX(int a[], int x);

	/** 4. Searching in an array where adjacent differ by at most k **/

	/** 12.Leaders in an array **/
	public List<Integer> findLeader(int a[]);

	/** 14. Majority Element **/
	public Integer majorityElement(int a[]);

}
