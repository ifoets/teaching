package com.design.analysis.algo.searching;

import java.util.List;

import com.design.analysis.algo.searching.model.FreqWord;

/*
 * 
 * @author GuruG
 * 
	 * Coding Problems :
	1.	Find the Missing Number
	2.	Search an element in a sorted and rotated array
	3.	Median of two sorted arrays
	4.	Two elements whose sum is closest to zero
	5.	Find the smallest and second smallest element in an array
	6.	Maximum and minimum of an array using minimum number of comparisons
	7.	k largest(or smallest) elements in an array | added Min Heap method
	8.	Ceiling in a sorted array
	9.	Count number of occurrences (or frequency) in a sorted array
	10.	Find the repeating and the missing | Added 3 new methods
	11.	Find a Fixed Point in a given array
	12.	Find the maximum element in an array which is first increasing and then decreasing
	13.	Find a pair with the given difference
	14.	Find the k most frequent words from a file
	15.	Median of two sorted arrays of different sizes
	16.	Find a peak element
	17.	Given an array of of size n and a number k, find all elements that appear more than n/k times
	18.	Find the minimum element in a sorted and rotated array
	19.	Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1
	20.	Find k closest elements to a given value
	21.	Search in an almost sorted array
	22.	A Problem in Many Binary Search Implementations
	23.	Find the first repeating element in an array of integers
	24.	Find common elements in three sorted arrays
	25.	Count 1’s in a sorted binary array
	26.	Given a sorted array and a number x, find the pair in array whose sum is closest to x
	27.	Find the closest pair from two sorted arrays
	28.	K’th Smallest/Largest Element in Unsorted Array | Set 1
	29.	K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear Time)
	30.	K’th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear Time)
	31.	Find position of an element in a sorted array of infinite numbers
	32.	Given a sorted and rotated array, find if there is a pair with a given sum
	33.	Find the largest pair sum in an unsorted array
	34.	Find the nearest smaller numbers on left side in an array
	35.	K’th largest element in a stream
	36.	Find a pair with maximum product in array of Integers
	37.	Find the element that appears once in a sorted array
	38.	Find the odd appearing element in O(Log n) time
	39.	Find the largest three elements in an array
	40.	Search an element in an array where difference between adjacent elements is 1
	41.	Find three closest elements from given three sorted arrays
	42.	Find the element before which all the elements are smaller than it, and after which all are greater
	43.	Binary Search for Rational Numbers without using floating point arithmetic
	44.	Floor in a Sorted Array
	45.	Third largest element in an array of distinct elements
	46.	Second minimum element using minimum comparisons
	47.	Queries for greater than and not less than
	48.	Efficient search in an array where difference between adjacent is 1
	49.	Print all possible sums of consecutive numbers with sum N
	50.	Minimum time required to produce m items
	51.	Make all array elements equal with minimum cost
	52.	Check if there exist two elements in an array whose sum is equal to the sum of rest of the array
	53.	Check if reversing a sub array make the array sorted
	54.	Find all triplets with zero sum
	55.	Search, insert and delete in an unsorted array
	56.	Search, insert and delete in a sorted array
	57.	Move all occurrences of an element to end in a linked list
	58.	Search in an array of strings where non-empty strings are sorted
	59.	Smallest Difference Triplet from Three arrays
	60.	Best First Search (Informed Search)

 */
public interface ICodingProblems {

	/** 1. Find the Missing Number **/
	public int missNumber(int a[]);

	/** 2. Search an element in a sorted and rotated array **/
	public int searchInSortedAndRotatedArr(int a[], int x);

	/** 3. Median of two sorted arrays O(log(n)). **/
	public int medianOfTwoSortedArr(int a[], int b[]);

	/** 4. Two elements whose sum is closest to zero **/
	public int[] sumCloseToZero(int a[]);
	/** 5. Find the smallest and second smallest element in an array **/
	/* use sortig application of 2 min element use bubble sort application */

	/** 6. Maximum and minimum of an array using minimum number of comparisons **/
	public int[] maxMinInMinComparision(int a[]);
	/** 7. k largest(or smallest) elements in an array | added Min Heap method **/
	/* Refer to @IOrderStatistics.java ...point @1. */

	/** 8. Ceiling in a sorted array **/
	public int ceillingInSortedArr(int a[], int x, int l, int h);

	public int floorInSortedArr(int a[], int x, int l, int h);

	/** 9. Count number of occurrences (or frequency) in a sorted array **/
	/* Refer @IBinarySearchBased.java...point @4. sub program */

	/** 10. Find the repeating and the missing | Added 3 new methods **/
	public int[] missingAndRepeatingInNNatural(int a[]);

	public int[] missingAndRepeatingInNNaturalX(int a[]);

	/** 11. Find a Fixed Point in a given array **/
	public int fixedPoint(int a[], int l, int h);

	/** 12. max element in array which is first increasing and then decreasing **/
	public int healInArray(int a[], int l, int h);

	public int healInArrayX(int a[], int l, int h);

	/** 13. Find a pair with the given difference **/
	public int[] pairHaveXDiff(int a[], int x);

	/** 14. Find the k most frequent words from a file **/
	public List<FreqWord> kMostFrequent(String str[], int k);

	/** 15. Median of two sorted arrays of different sizes **/
	public int medianOfTwoSortedArrX(int a[], int b[]);
	/* @See IBinarySearchBased.java @ 2...program */

	/** 16. Find a peak element **/
	public int pickElement(int a[], int l, int h, int n);

	/**
	 * 17. Given an array of of size n and a number k, find all elements that appear
	 * more than n/k times
	 **/
	public List<Integer> elemMoreThanKTimes(int a[], int k);

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
	public int[] kClogestElemInSotedArr(int a[], int val, int k);

	/** 21. Search in an almost sorted array **/
	public int searchInAlmostSotedArr(int a[], int x);
	/** 22. A Problem in Many Binary Search Implementations **/
	/* Theory part */

	/** 23. Find the first repeating element in an array of integers **/
	public int firstRepetingElem(int a[]);

	/** 24. Find common elements in three sorted arrays **/
	public List<Integer> commonIn3Arrs(int a[], int b[], int c[]);

	/** 25. Count 1’s in a sorted binary array **/
	public int countOneInBinaryArr(int a[], int l, int h);

	/**
	 * 26. Given a sorted array and a number x, find the pair in array whose sum is
	 * closest to x
	 **/
	public List<Integer> sumCLogestToX(int a[], int x);

	/** 27. Find the closest pair from two sorted arrays **/
	public List<Integer> sumCLogestToX(int a[], int b[], int x);

	/** 28. K’th Smallest/Largest Element in Unsorted Array | Set 1 **/
	/**
	 * 29. K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/

	/**
	 * 30. K’th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case
	 * Linear Time)
	 **/
	/* all above are common for minimum complxity O(k*n) */
	/* @see @IOrderStatistics.java.. 1....program */
	/** 31. Find position of an element in a sorted array of infinite numbers **/
	// @Amazn
	public int posInInfiniteLenArr(int a[], int x, int siseCheck, int sizeLimit);

	/**
	 * 32. Given a sorted and rotated array, find if there is a pair with a given
	 * sum
	 **/
	/* in single array */
	public List<Integer> sumEqualToX(int a[], int x);

	/* it two array */
	public List<Integer> sumEqualToX(int a[], int b[], int x);

	/** 33. Find the largest pair sum in an unsorted array **/
	public List<Integer> largestPair(int a[]);

	/** 34. Find the nearest smaller numbers on left side in an array **/
	public int[] nearestSmallrOnLeftSideArr(int a[]);

	/** 35. K’th largest element in a stream **/
	/* @see @IOrderStatistics.java....3....program8 */

	/** 36. Find a pair with maximum product in array of Integers **/
	/* this is same max sum pair just use the product without absloute */

	/** 37. Find the element that appears once in a sorted array O(logn) **/
	public int uniqueElement(int a[], int l, int h);

	/** 38. Find the odd appearing element in O(Log n) time **/
	/* logn in unsorted array */
	public int searchIndex(int a[], int l, int h, int x);

	public int oddAppearing(int a[]);

	/** 39. Find the largest three elements in an array O(n) **/
	public int[] largestThreeElement(int a[]);
	/*
	 * 40. Search an element in an array where difference between adjacent elements
	 * is 1
	 */
	/* 41. Find three closest elements from given three sorted arrays */
	/*
	 * 42. Find the element before which all the elements are smaller than it, and
	 * after which all are greater
	 */
	/*
	 * 43. Binary Search for Rational Numbers without using floating point
	 * arithmetic
	 */
	/* 44. Floor in a Sorted Array */
	/* 45. Third largest element in an array of distinct elements */
	/* 46. Second minimum element using minimum comparisons */
	/* 47. Queries for greater than and not less than */
	/* 48. Efficient search in an array where difference between adjacent is 1 */
	/* 49. Print all possible sums of consecutive numbers with sum N */
	/* 50. Minimum time required to produce m items */
}
