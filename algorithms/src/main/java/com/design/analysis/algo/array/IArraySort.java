package com.design.analysis.algo.array;

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
	
	public int minSwapForSortX(int a[]);
	/* 14. Union and Intersection of two sorted arrays */
	/* 15. Find Union and Intersection of two unsorted arrays */
	/* 16. Sort an array of 0s, 1s and 2s */
	/*
	 * 17. Find the Minimum length Unsorted Subarray, sorting which makes the
	 * complete array sorted
	 */
	/* 18. Median in a stream of integers (running integers) */
	/* 19. Count the number of possible triangles */
	/* 20. Find number of pairs (x, y) in an array such that x^y > y^x */
	/* 21. Count all distinct pairs with difference equal to k */
	/* 22. Print All Distinct Elements of a given integer array */
	/* 23. Construct an array from its pair-sum array */
	/* 24. Merge two sorted arrays with O(1) extra space */
	/* 25. Product of maximum in first array and minimum in second */
}
