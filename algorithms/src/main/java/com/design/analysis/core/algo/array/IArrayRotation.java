package com.design.analysis.core.algo.array;

import java.util.List;

/*
 * 
 * @author GuruG
 * 
Array Rotations :
1.	Program for array rotation
2.	Reversal algorithm for array rotation
3.	Block swap algorithm for array rotation
4.	Program to cyclically rotate an array by one
5.	Search an element in a sorted and rotated array
6.	Given a sorted and rotated array, find if there is a pair with a given sum
7.	Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
8.	Maximum sum of i*arr[i] among all rotations of a given array
9.	Find the Rotation Count in Rotated Sorted array
10.	Quickly find multiple left rotations of an array
11.	Find the minimum element in a sorted and rotated array
12.	Reversal algorithm for right rotation of an array
13.	Find a rotation with maximum hamming distance
14.	Queries on Left and Right Circular shift on array
15.	Print left rotation of array in O(n) time and O(1) space
16.	Find element at given index after a number of rotations
17.	Split the array and add the first part to the end

 */
public interface IArrayRotation {

	/**
	 * 1. Program for array rotation
	 **/
	/* by using temporary array, TC-O(n)- SC- O(n) */
	public void arrayRotationByTemp(int a[], int k);

	/* by using temporary array, TC-O(n)- SC- O(0) */
	public void arrayRotationByOneByOneRot(int a[], int k);

	/** 2. Reversal algorithm for array rotation **/
	/* by using temporary array, TC-O(n)- SC- O(0) ..from start */
	public void arrayRotationByReversalStat(int a[], int k);

	/** 3. Block swap algorithm for array rotation **/
	public void arrRoatByBlockSwap(int a[], int n, int k);

	/** 4. Program to cyclically rotate an array by one **/
	public void cyclicRotation(int a[]);

	/** 5. Search an element in a sorted and rotated array **/
	/* max element index in sorted and rotated array */
	public int findPivot(int arr[], int low, int high);

	/* search elememnt in sorted and rotated array O(log(n)) */
	public int searchInSortedRotatedArr(int a[], int x);

	/** 6.sorted and rotated array, find if there is a pair with a given sum **/
	public List<List<Integer>> pariSumInSortedRottedArr(int a[], int sum);

	/** 7. Max Sum( i*arr[i]) with only rotations on given array allowed **/
	public int maxSumIndexIntoElem(int a[]);

	/** 8. Maximum sum of i*arr[i] among all rotations of a given array **/
	public int maxSumByRotationIndexIntoElem(int a[]);

	/** 9. Find the Rotation Count in Rotated Sorted array **/
	public int countRotationOfSortedArr(int a[]);

	/** 10. Quickly find multiple left rotations of an array **/
	public void arryAfterKRotation(int a[], int n, int k);

	/** 11. Find the minimum element in a sorted and rotated array **/
	public int minInSortedAndRotatedArr(int a[]);

	/** 12. Reversal algorithm for right rotation of an array **/
	/* by using temporary array, TC-O(n)- SC- O(0) ..from end */
	public void arrayRotationByReversalEnd(int a[], int k);

	/** 13. Find a rotation with maximum hamming distance **/
	public int maxHamming(int arr[], int n);

	/** 14. Queries on Left and Right Circular shift on array **/
	// this use left and right rotaton and find the sum form l index to r
	/** 15. Print left rotation of array in O(n) time and O(1) space **/
	public void leftRotate(int arr[], int n, int k);

	/** 16. Find element at given index after a number of rotations **/
	public int findElement(int[] arr, int[][] ranges, int rotations, int index);
	/** 17. Split the array and add the first part to the end **/
	// This is noting but rotaton of array

}
