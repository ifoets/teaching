package com.design.analysis.core.algo.divideandconquer;

import java.util.List;

import com.design.analysis.core.algo.divideandconquer.model.Point;

/*
 * 
 * @author GuruG
 * 
 * Standard Algorithms :
	1.	Intoduction to Divide and Conquer
	2.	Binary Search
	3.	Randomized Binary Search Algorithm
	4.	Merge Sort
	5.	Quick Sort
	6.	Tiling Problem
	7.	Count Inversions
	8.	Calculate pow(x, n)
	9.	Closest Pair of Points
	10.	Closest Pair of Points | O(nlogn) Implementation
	11.	Multiply two polynomials
	12.	Strassen�s Matrix Multiplication
	13.	The Skyline Problem
	14.	Maximum Subarray Sum
	15.	Longest Common Prefix
	16.	Search in a Row-wise and Column-wise Sorted 2D Array
	17.	Karatsuba algorithm for fast multiplication
	18.	Convex Hull (Simple Divide and Conquer Algorithm)
	19.	Quickhull Algorithm for Convex Hull
	20.	Distinct elements in subarray using Mo�s Algorithm

 */
public interface IStandardAlgo {

	/** 0.1 Find the element in non sorted array using D&C **/
	public int serchInNonSortedArr(int a[], int x, int l, int r);

	/** 0.2 Find sum of even indexed element array using D&C **/
	public int sumOfEvenLableIndexed(int a[], int l, int r, int sum);

	/** 0.3 Find sum of element array using D&C **/
	public int sumOfArrElement(int a[], int l, int r);

	/** 1. Intoduction to Divide and Conquer **/
	/*
	 * 1. Divide: Break the given problem into subproblems of same type. 2.Conquer:
	 * Recursively solve these subproblems. 3. Combine: Appropriately combine the
	 * answers
	 */

	/** 2. Binary Search **/
	public Integer binarySearch(int a[], int l, int e, int x);

	/** 3. Randomized Binary Search Algorithm **/
	public Integer randomizedBinarySearch(int a[], int l, int e, int x);

	/** 4. Merge Sort **/
	/* merging two sorted array */
	public void mergeTwoPartSorted(int a[], int l, int m, int r);

	/* merge sort */
	public void mergeSort(int arr[], int l, int r);

	/** 5. Quick Sort **/
	public void quickSort(int[] a, int l, int h);

	/** 6. Tiling Problem **/
	public boolean fillMissingCellByLShapeSmallCell(int a[][], int xi, int yi, int xr, int yr, int b[][], int n);

	/** 7. Count Inversions **/
	public int countInversion(int arr[], int temp[], int l, int r);

	/** 8. Calculate pow(x, n) **/
	public Float powerOfXtoN(int x, int n);

	/** 9. Closest Pair of Points **/
	/** 10. Closest Pair of Points | O(nlogn) Implementation **/
	public List<Point> clogestPoints(List<Point> lp);

	/** 11. Multiply two polynomials **/
	public int[] multiplyTwoPolynomial(int a[], int b[]);

	/** 12. Strassen�s Matrix Multiplication **/
	public int[][] matrixMultiplication(int a[][], int b[][]);

	// TODO
	/** 13. The Skyline Problem **/

	/** 14. Maximum Subarray Sum **/
	public int maxSubArraySum(int a[], int l, int h);

	public int maxCrossingSum(int a[], int l, int m, int h);

	/** 15. Longest Common Prefix **/
	public String longestCommonPrefix(String str[], int low, int high);

	/** 16. Search in a Row-wise and Column-wise Sorted 2D Array **/
	public void search(int[][] mat, int fromRow, int toRow, int fromCol, int toCol, int key);

	/** 17. Karatsuba algorithm for fast multiplication **/
	public int merge(int arr[], int temp[], int l, int mid, int r);

	/* 18. Convex Hull (Simple Divide and Conquer Algorithm) */
	/* 19. Quickhull Algorithm for Convex Hull */
	/* 20. Distinct elements in subarray using Mo�s Algorithm */
}
