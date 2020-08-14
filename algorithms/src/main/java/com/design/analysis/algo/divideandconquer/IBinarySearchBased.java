package com.design.analysis.algo.divideandconquer;

/*
 * 
 * @author GuruG
 * 
 * Binary Search Based :

	1.	Median of two sorted arrays
	2.	Median of two sorted arrays of different sizes
	3.	Floor in a Sorted Array
	4.	Find closest number in array
	5.	Find a Fixed Point in a given arrray
	6.	Find a peak element in a given array
	7.	Check for Majority Element in a sorted array
	8.	K-th Element of Two Sorted Arrays
	9.	Find the Rotation Count in Rotated Sorted array
	10.	Find the minimum element in a sorted and rotated array
	11.	Find the only repeating element in a sorted array of size n
	12.	Find index of an extra element pre
	sent in one sorted array
	13.	Find the element that appears once in a sorted array
	14.	Count number of occurrences (or frequency) in a sorted array
	15.	Find the maximum element in an array which is first increasing and then decreasing
	16.	Decrease and Conquer
	17.	Binary Search using pthread
	18.	Binary Search on Singly Linked List
	19.	The painter’s partition problem
	20.	The painter’s partition problem | Set 2
	21.	Find the number of zeroes
	22.	Numbers whose factorials end with n zeros
	23.	Find the missing number in Arithmetic Progression
	24.	Number of days after which tank will become empty
	25.	Find bitonic point in given bitonic sequence
	26.	Find the point where a monotonically increasing function becomes positive first time

 */
public interface IBinarySearchBased {

	/** 1. Median of two sorted arrays **/
	/* by O(n) complexity */
	public int medianOfTwoSottedArr(int a[], int b[]);

	/* get median of an array */
	public int getMedian(int arr[], int l, int h);

	/* by log(n) complexity */
	public int getMedianOf2Array(int a[], int l1, int h1, int b[], int l2, int h2);

	/** 2. Median of two sorted arrays of different sizes **/
	/* by O(1) worst case O(n) when size equal ...complexity */
	public int getMedianOfDiffSize2Array(int a[], int l1, int h1, int b[], int l2, int h2);

	/// GuruJi 2 sorted array O(n2)
	public int getMedianOf2AnySizeArray(int a[], int b[]);

	/// GuruJi 2 sorted array O(n) and SO(n) /n=n1+n2
	public int getMedianOf2AnySizeArrayX(int a[], int b[]);

	// special sorted here all elements in a[] are greater than all elements of b[]
	public int getMedianOfTwoSortedArray(int a[], int b[]);

	/**
	 * 3.Check for Majority Element in a sorted array ie check x appear more than
	 * n/2 times or not
	 **/

	public int binarySearchFirstOccurance(int a[], int l, int h, int x);

	public boolean majorityElemInSortedArr(int a[], int x);

	/**
	 * 4. Count number of occurrences (or frequency) in a sorted array O(Logn) not
	 * O(n)
	 **/
	public int binarySearchLastOccurance(int a[], int l, int h, int x);

	public int frequecnyOfElement(int a[], int x);

	/** 5. Find a Fixed Point **/
	public int findFixedPoint(int a[], int l, int h);

	/** 6. Find a peak element in a given array **/
	// O(nlog(n))
	public int findOnlyPickElemet(int a[], int l, int r);

	public int findAllPickElemtnt(int a[], int l, int r);

	/** 7. Check for Majority Element in a sorted array **/
	/** 8. K-th Element of Two Sorted Arrays **/
	/** 9. Find the Rotation Count in Rotated Sorted array **/
	/** 10. Find the minimum element in a sorted and rotated array **/
	/** public int findCrossOver(int arr[], int low, int high, int x); **/

	/**
	 * 21. Search in allmost sorted array ie 1 element is displaced left or rith 1
	 * position
	 **/
	public int binarySearchInAllmostSoted(int arr[], int l, int r, int x);
}
