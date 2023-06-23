package com.design.analysis.algo.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class  IArrayRotationTest{

	public IArrayRotation iar = null;

	@Before
	public void init() {
		iar = new ArrayRotationImpl();
	}

	@Test
	public void arrayRotationByTempTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		iar.arrayRotationByTemp(a, 3);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/* by using temporary array, TC-O(kn)- SC- O(0) */
	@Test
	public void arrayRotationByOneByOneRotTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		iar.arrayRotationByOneByOneRot(a, 3);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 2. Reversal algorithm for array rotation **/
	/* by using temporary array, TC-O(n)- SC- O(0) ..from start */
	@Test
	public void arrayRotationByReversalStatTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		iar.arrayRotationByReversalStat(a, 3);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 3. Block swap algorithm for array rotation **/
	/*
	 * by Guru G O(k*n/k )
	 */
	@Test
	public void arrRoatByBlockSwapTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		iar.arrRoatByBlockSwap(a, a.length, 3);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 4. Program to cyclically rotate an array by one **/
	@Test
	public void cyclicRotationTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 9, 1, 2, 3, 4, 5, 6, 7, 8 };
		iar.cyclicRotation(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 5. Search an element in a sorted and rotated array **/
	/* max element index in sorted and rotated array */
	@Test
	public void findPivotTest() {
		int b[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		Assert.assertTrue(iar.findPivot(b, 0, b.length) == 5);
	}

	/* search elememnt in sorted and rotated array O(log(n)) */
	@Test
	public void searchInSortedRotatedArrTest() {

		int b[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		// System.out.println(iar.searchInSortedRotatedArr(b, 4));
		Assert.assertTrue(iar.searchInSortedRotatedArr(b, 8) == 4);
		Assert.assertTrue(iar.searchInSortedRotatedArr(b, 3) == 8);
		Assert.assertTrue(iar.searchInSortedRotatedArr(b, 4) == 0);
	}

	/** 6.sorted and rotated array, find if there is a pair with a given sum **/
	@Test
	public void pariSumInSortedRottedArrTest() {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		Assert.assertTrue(iar.pariSumInSortedRottedArr(a, 6).size() == 2);
	}

	/**
	 * 7. Max value of Sum( i*arr[i]) with only rotations on given array allowed
	 **/
	@Test
	public void maxSumIndexIntoElemTest() {

		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(iar.maxSumIndexIntoElem(arr) == 330);
		int arr1[] = { 5, 1, 2, 3, 4};
		Assert.assertTrue(iar.maxSumIndexIntoElem(arr1) == 40);
	}

	/** 8. Maximum sum of i*arr[i] among all rotations of a given array **/
	@Test
	public void maxSumByRotationIndexIntoElemTest() {
		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(iar.maxSumByRotationIndexIntoElem(arr) == 330);
	}

	/** 9. Find the Rotation Count in Rotated Sorted array **/
	@Test
	public void countRotationOfSortedArrTest() {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		Assert.assertTrue(iar.countRotationOfSortedArr(a) == 3);
	}

	/** 10. Quickly find multiple left rotations of an array **/
	@Test
	public void arryAfterKRotationTest() {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		iar.arryAfterKRotation(a, a.length, 6);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 11. Find the minimum element in a sorted and rotated array **/
	@Test
	public void minInSortedAndRotatedArrTest() {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		Assert.assertTrue(iar.minInSortedAndRotatedArr(a) == 1);
	}

	/** 12. Reversal algorithm for right rotation of an array **/
	/* by using temporary array, TC-O(n)- SC- O(0) ..from end */
	@Test
	public void arrayRotationByReversalEndTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		iar.arrayRotationByReversalEnd(a, 3);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 13. Find a rotation with maximum hamming distance **/
	@Test
	public void maxHammingTest() {
		int a[] = { 2, 4, 6, 8 };
		Assert.assertTrue(iar.maxHamming(a, a.length) == 4);
	}

	/** 14. Queries on Left and Right Circular shift on array **/
	// this use left and right rotaton and find the sum form l index to r
	/** 15. Print left rotation of array in O(n) time and O(1) space **/
	@Test
	public void leftRotateTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int b[] = { 3, 5, 6 };
		for (int i = 0; i < b.length; i++)
			iar.leftRotate(a, a.length, b[i]);
	}

	/** 16. Find element at given index after a number of rotations **/
	@Test
	public void findElementTest() {
		int[] arr = { 1, 2, 3, 4, 5 };

		// No. of rotations
		int rotations = 2;

		// Ranges according to 0-based indexing
		int[][] ranges = { { 0, 2 }, { 0, 3 } };

		int index = 1;
		Assert.assertTrue(iar.findElement(arr, ranges, rotations, index) == 3);
	}
}
