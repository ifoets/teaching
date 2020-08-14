package com.design.analysis.algo.greedyalgorithms;

/*
 * 
 * @author GuruG
 * 
 * 
Greedy Algorithms in Arrays :
	1.	Minimum product subset of an array
	2.	Maximum product subset of an array
	3.	Maximize array sum after k-negations | Set 1
	4.	Maximize array sum after k-negations | Set 2
	5.	Maximize the sum of arr[i]*i
	6.	Maximum sum of increasing order elements from n arrays
	7.	Maximum sum of absolute difference of an array
	8.	Maximize sum of consecutive differences in a circular array
	9.	Maximum height pyramid from the given array of objects
	10.	Partition into two subarrays of lengths k and (N – k) such that the difference of sums is maximum
	11.	Minimum sum of product of two arrays
	12.	Minimum sum by choosing minimum of pairs from array
	13.	Minimum sum of absolute difference of pairs of two arrays
	14.	Minimum operations to make GCD of array a multiple of k
	15.	Minimum sum of absolute difference of pairs of two arrays
	16.	Minimum sum of two numbers formed from digits of an array
	17.	Minimum increment/decrement to make array non-Increasing
	18.	Making elements of two arrays same with minimum increment/decrement
	19.	Minimize sum of product of two arrays with permutation allowed
	20.	Sorting array with reverse around middle
	21.	Sum of Areas of Rectangles possible for an array
	22.	Array element moved by k using single moves
	23.	Find if k bookings possible with given arrival and departure times
	24.	Lexicographically smallest array after at-most K consecutive swaps
	25.	Largest lexicographic array with at-most K consecutive swaps

 */
public interface IArraysGreedyAlgo {

	/** 1. Minimum product subset of an array **/
	//O(n)
	public int minProductSubArr(int a[]);
	
	//O(nlogn)
	public int minProductSubArrX(int a[]);

	/** 2. Maximum product subset of an array **/
	public int maxProductSubArr(int a[]);

	/** 3. Maximize array sum after k-negations | Set 1 **/
	public int maxSumArrWithKNegationX(int a[], int k);

	public int maxSumArrWithKNegationZ(int a[], int k);

	/* max sub array sum after k-negations */
	public int maxSumSubArrWithKNegation(int a[], int k);

	/** 4. Maximize array sum after k-negations | Set 2 **/
	public int maxSumArrWithKNegationY(int a[], int k);

	/** 5. Maximize the sum of arr[i]*i **/
	public int maxSumOfElemMultiByIndex(int a[]);

	// all type of element
	public int maxSumOfElemMultiByIndexX(int a[]);

	/** 6. Maximum sum of increasing order elements from n arrays **/
	public int maxSumIncrOrderFromNArrs(int a[][]);

	public int minSumIncrOrderFromNArrs(int a[][]);

	/** 7. Maximum sum of absolute difference of an array **/
	public int maxSumOfAbsDiff(int a[]);

	/** 8. Maximize sum of consecutive differences in a circular array **/
	public int maxSumOfConscutiveDiffInCircularArr(int a[]);

	/** 9. Maximum height pyramid from the given array of objects **/
	public int maxHeightPyramid(int a[]);

	/**
	 * 10. Partition into two subarrays of lengths k and (N – k) such that the
	 * difference of sums is maximum
	 **/
	public int partitionForMaxDiffSum(int a[], int k);

	/** 11. Minimum sum of product of two arrays **/
	public int minSumOfProducts(int a[], int b[], int k);

	/** 12. Minimum sum by choosing minimum of pairs from array **/
	public int minSumByChooseMinOfPair(int a[]);

	/** 13. Minimum sum of absolute difference of pairs of two arrays **/
	public int minSumAbsDiffOfTwoArrs(int a[], int b[]);

	/* Maximum sum of absolute difference of pairs of two arrays */
	public int maxSumAbsDiffOfTwoArrs(int a[], int b[]);

	/** 14. Minimum operations to make GCD of array a multiple of k **/
	public int minOprToMakeGcdOfArrMultiOfK(int a[], int k);
	/** 15. Minimum sum of absolute difference of pairs of two arrays **/
	/* @See 13. */

}
