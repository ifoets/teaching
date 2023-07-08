package com.design.analysis.core.algo.array;

import java.util.List;
import java.util.Map;

/*
 * 
 * @author GuruG
 * 
 * Sorting :
1.	Alternative Sorting
2.	Sort a nearly sorted (or K sorted) array
3.	Sort an array according to absolute difference with given value
4.	Sort an array in wave form
5.	Merge an array of size n into another array of size m+n
6.	Sort an array which contain 1 to n values
7.	Sort 1 to N by swapping adjacent elements
8.	Sort an array containing two types of elements
9.	Sort elements by frequency | Set 1
10.	Count Inversions in an array | Set 1 (Using Merge Sort)
11.	Two elements whose sum is closest to zero
12.	Shortest Un-ordered Subarray
13.	Minimum number of swaps required to sort an array
14.	Union and Intersection of two sorted arrays
15.	Find Union and Intersection of two unsorted arrays
16.	Sort an array of 0s, 1s and 2s
17.	Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
18.	Median in a stream of integers (running integers)
19.	Count the number of possible triangles
20.	Find number of pairs (x, y) in an array such that x^y > y^x
21.	Count all distinct pairs with difference equal to k
22.	Print All Distinct Elements of a given integer array
23.	Construct an array from its pair-sum array
24.	Merge two sorted arrays with O(1) extra space
25.	Product of maximum in first array and minimum in second

26.	Given an array and two numbers x and k.
27.	Probability of a random pair being the maximum weighted pair
28.	Minimum De-arrangements present in array of AP (Arithmetic Progression)
29.	De-arrangements for minimum product sum of two arrays
30.	Divide an array into k segments to maximize maximum of segment minimums
31.	Minimum product pair an array of positive Integers
32.	Count ways to form minimum product triplets
33.	Check if reversing a sub array make the array sorted
34.	Maximize elements using another array
35.	Making elements of two arrays same with minimum increment/decrement
36.	Check if any interval completely overlaps the other
37.	Sorting array except elements in a subarray
38.	Sorting all array elements except one
39.	Minimum swaps required to Sort Binary array
40.	Sort the linked list in the order of elements appearing in the array
41.	Print sorted distinct elements of array in C++
42.	Maximum number of partitions that can be sorted individually to make sorted
43.	Sort on the basis of number of factors using STL
44.	Ropes left after every removal of smallest
45.	Rank of all elements in an array
46.	Merge 3 Sorted Arrays
47.	Minimum number of subtract operation to make an array decreasing
48.	Maximize the sum of arr[i]*i
49.	Pairs with Difference less than K
50.	Merging two unsorted arrays in sorted order

51.	Maximizing Unique Pairs from two arrays
52.	Sort an array after applying the given equation
53.	Sum of minimum absolute difference of each array element
54.	Find whether it is possible to make array elements same using one external number
55.	Smallest Difference pair of values between two unsorted Arrays
56.	Program to check if an array is sorted or not (Iterative and Recursive)
57.	Find elements larger than half of the elements in an array
58.	Minimum swaps to make two arrays identical
59.	Elements to be added so that all elements of a range are present in array

 */
public interface IArraySort {

	/** 1. Alternative Sorting **/
	public void alternativeSorting(int a[]);

	/** 2. Sort a nearly sorted (or K sorted) array **/
	public void sortNearlySorted(int a[]);

	/** 3. Sort an array according to absolute difference with given value **/
	public void sortByAbsDiffGivenValue(int a[], int x);
	
	public void sortByAbsDiffGivenValueX(int a[], int x);

	/** 4. Sort an array in wave form **/
	public void sortInWaveForm(int a[]);

	/** 5. Merge an array of size n into another array of size m+n **/
	public void meargeNArrToMNArr(int mnArr[], int nArr[]);

	public void meargeNArrToMNArrX(int mnArr[], int nArr[]);

	/** 6. Sort an array which contain 1 to n values **/
	public void sortNaturalNo(int a[]);

	/** 7. Sort 1 to N by swapping adjacent elements **/
	public boolean sort1ToNBySwapAdjacent(int a[], boolean b[]);

	/** 8. Sort an array containing two types of elements **/
	public void sort0And1(int a[]);

	/** 9. Sort elements by frequency | Set 1 */
	public void sortByfriquency(int a[]);
	/** 10. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	/// @See @IStandardAlgo.java 9.

	/** 11. Two elements whose sum is closest to zero **/
	public int[] sumCloseToZero(int a[]);

	/** 12. Shortest Un-ordered Subarray **/
	public int unOrderedLen(int a[]);

	/** 13. Minimum number of swaps required to sort an array **/
	public int minSwapForSort(int a[]);

	/* 14. Union and Intersection of two sorted arrays */
	public List<Integer> unionOfArrays(int[] a, int[] b);

	public List<Integer> intersectionOfArrays(int a[], int b[]);

	/* 15. Find Union and Intersection of two unsorted arrays */
	public List<Integer> unionOfUnSortedArrays(int[] a, int[] b);

	public List<Integer> intersectionOfUnSortedArrays(int a[], int b[]);

	/* 16. Sort an array of 0s, 1s and 2s */
	public List<Integer> sort0s1s2s3s(int a[]);
	/*
	 * 17. Find the Minimum length Unsorted Subarray, sorting which makes the
	 * complete array sorted
	 */
	public int minLenUnSortedSubArray(int a[]);

	/* 18. Median in a stream of integers (running integers),Median of Stream of Running Integers using STL */
	public double[] medianInStream(int a[]);

	/* 19. Count the number of possible triangles */
	public List<List<Integer>> possibleTriangles(int a[]);

	/* 20. Find number of pairs (x, y) in an array such that x^y > y^x */
    public int pairOfXY(int x[], int y[]);
	/* 21. Count all distinct pairs with difference equal to k */
	/* 22. Print All Distinct Elements of a given integer array */
	/* 23. Construct an array from its pair-sum array */
	/* 24. Merge two sorted arrays with O(1) extra space */
	/* 25. Product of maximum in first array and minimum in second */
}
