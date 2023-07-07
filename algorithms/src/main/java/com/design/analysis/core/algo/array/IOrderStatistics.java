package com.design.analysis.core.algo.array;

import java.util.List;

import com.design.analysis.core.algo.array.model.SmallestSum;

/*
 * 
 * @author GuruG
	Array | Order Statistics
	Recent articles on Order Statistics
	1.	K�th Smallest/Largest Element in Unsorted Array | Set 1
	2.	K�th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear Time)
	3.	K�th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear Time)
	4.	K�th Smallest/Largest Element using STL
	5.	k largest(or smallest) elements in an array | added Min Heap method
	6.	Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1
	7.	Program to find largest element in an array
	8.	Find the largest three elements in an array
	9.	Find all elements in array which have at-least two greater elements
	10.	Program for Mean and median of an unsorted array
	11.	Median of Stream of Running Integers using STL
	12.	Minimum product of k integers in an array of positive Integers
	13.	K-th Largest Sum Contiguous Subarray
	14.	K maximum sum combinations from two arrays
	15.	K maximum sums of overlapping contiguous sub-arrays
	16.	K maximum sums of non-overlapping contiguous sub-arrays
	17.	k smallest elements in same order using O(1) extra space
	18.	Find k pairs with smallest sums in two arrays
	19.	k-th smallest absolute difference of two elements in an array
	20.	Find Second largest element in an array
	21.	Find k numbers with most occurrences in the given array
	22.	Find the smallest and second smallest elements in an array
	23.	Find the smallest missing number
	24.	Maximum sum such that no two elements are adjacent
	25.	Maximum and minimum of an array using minimum number of comparisons
	26.	Maximum difference between two elements such that larger element appears after the smaller number
	27.	Given an array arr[], find the maximum j � i such that arr[j] > arr[i]
	28.	Maximum of all subarrays of size k
	29.	Find the minimum distance between two numbers
	30.	Find the maximum element in an array which is first increasing and then decreasing
	31.	Count smaller elements on right side
	32.	Longest Monotonically Increasing Subsequence Size (N log N)
	33.	Find the smallest positive number missing from an unsorted array | Set 1
	34.	Find the maximum repeating number in O(n) time and O(1) extra space
	35.	Given an array of of size n and a number k, find all elements that appear more than n/k times
	36.	Find the Increasing subsequence of length three with maximum product
	37.	Maximum Sum Path in Two Arrays
	38.	Find the closest pair from two sorted arrays
	39.	Find the largest pair sum in an unsorted array
	40.	Smallest greater elements in whole array
	41.	Delete array elements which are smaller than next or become smaller
	42.	Online algorithm for checking palindrome in a stream
	43.	Delete array elements which are smaller than next or become smaller
	44.	Find zeroes to be flipped so that number of consecutive 1�s is maximized
	45.	Count Strictly Increasing Subarrays
	46.	K�th largest element in a stream
	47.	Find k pairs with smallest sums in two arrays
	48.	Maximum difference between group of k-elements and rest of the array.
	49.	Minimum number of elements to add to make median equals x
	50.	Next Greater Element


 */
public interface IOrderStatistics {
	/** 1. K�th Smallest/Largest Element in Unsorted Array | Set 1 **/
	/**
	 * 2. K�th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	/**
	 * 3. K�th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear
	 * Time)
	 **/
	/** 4. K�th Smallest/Largest Element using STL **/

	/*
	 * 1 to 4 is used for unique positive element only* writing method O(n) both
	 * space and time for all elemement excepet biggestelemnt should not be much
	 * high than lenght
	 */
	public int kthHeigstOrSmallest(int a[], int k, boolean isMinOrMax);
	
	public int kthHeigstOrSmallestX(int a[], int k, boolean isMinOrMax);

	/* 10. Program for Mean and median of an unsorted array */
	/**
	 * 5. k largest(or smallest) elements in an array | added Min Heap method O(n)
	 **/
	public List<Integer> kLargestSmallest(int a[], int k, boolean isLargest);

	/**
	 * 6. Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1
	 **/
	public int kthSmallestRowAndCom(int mat[][], int n, int k);
	
	public int kthSmallestRowAndComX(int mat[][], int n, int k);

	/** 7. Program to find largest element in an array 7 **/
	public int kthMaxElement(int a[], int k);
	
	public int kthMaxElementAnyNos(int a[], int k);

	/** 8. Find the largest three elements in an array **/
	/** from 4 to 7 come under 1. these are same **/
	/** 9. Find all elements in array which have at-least two greater elements **/
	public List<Integer> allElemAtleathave2Greter(int a[], boolean is2Greater);

	/** 9. Find k pairs with smallest sums in two arrays **/
	public List<SmallestSum> kSmallestPairSum(int a[], int b[], int k);

	/** 10. k-th smallest absolute difference of two elements in an array **/
	public int kthSmallestAbsDiff(int a[], int k);

	/** 11. Find Second largest element in an array **/
	// it is solved in kth largest
	/** 12. Find k numbers with most occurrences in the given array **/
	public int[] kHiFreqNumber(int a[], int k);
	/* 13. Find the smallest and second smallest elements in an array */
	// this is solved in 1. kth largest or smallest
	/** 14. Next Greater Element **/
	/* 15. Find the smallest missing number */
	/* 16. Maximum sum such that no two elements are adjacent */
	/* 17. Maximum and minimum of an array using minimum number of comparisons */
	/*
	 * 18. Maximum difference between two elements such that larger element appears
	 * after the smaller number
	 */
	/* 19. Given an array arr[], find the maximum j � i such that arr[j] > arr[i] */
	/* 20. Maximum of all subarrays of size k */
}
