package com.design.analysis.algo.divideandconquer;

/*
 * 
 * @author GuruG
 * 
	 * Misc :
	1.	Largest Rectangular Area in a Histogram | Set 1
	2.	Maximum and minimum of an array using minimum number of comparisons
	3.	Write you own Power without using multiplication(*) and division(/) operators
	4.	Program to count number of set bits in an (big) array
	5.	Maximum Subarray Sum
	6.	Search in a Row-wise and Column-wise Sorted 2D Array
	7.	The Skyline Problem
	8.	Square root of an integer
	9.	Longest Common Prefix
	10.	Find frequency of each element in a limited range array in less than O(n) time
	11.	Find cubic root of a number
	12.	Minimum difference between adjacent elements of array which contain elements from each row of a matrix
	13.	Easy way to remember Strassen’s Matrix Equation
	14.	Allocate minimum number of pages
	15.	Place k elements such that minimum distance is maximized
	16.	Search element in a sorted matrix
	17.	Find a peak element in a 2D array
	18.	Collect all coins in minimum number of steps
Shuffle 2n integers in format {a1, b1, a2, b2, a3, b3, ……, an, bn} without using extra space

 */
public interface IDvdConcureMice {

	/** 1. Largest Rectangular Area in a Histogram | Set 1 **/
	public int larestRectInHistogram(int a[]);

	public int larestRectInHistogramX(int a[], int l, int r);

	/** 2. Maximum and minimum of an array using minimum number of comparisons **/
	public int[] maxMinByMinComp(int a[]);

	/** 3. Write you own Power without using multiplication(*) and division(/) **/
	public int ownPow(int x, int y);

	/** 4. Program to count number of set bits in an (big) array **/
	public int setBitOfNum(int a);

	public int setBitOfArr(int a[]);

	/** 5. Maximum Subarray Sum **/
	public int maxCrossingSum(int arr[], int l, int m, int h);

	public int maxSumContiSubArr(int a[], int l, int r);

	/** 6. Search in a Row-wise and Column-wise Sorted 2D Array **/
	public int[] searchInSortedMat(int a[][], int x);
	/* 7. The Skyline Problem */
	/* 8. Square root of an integer */
	/* 9. Longest Common Prefix */
	/*
	 * 10. Find frequency of each element in a limited range array in less than O(n)
	 * time
	 */
}
