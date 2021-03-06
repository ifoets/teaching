package com.design.analysis.algo.array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArrangeReArrangeTest {

	public IArrangeReArrange iar = null;

	@Before
	public void init() {
		iar = new ArrangeReArrangeImpl();
	}

	/** 1. Rearrange an array such that arr[i] = i **/
	@Test
	public void fixedAtIndexTest() {

		int a[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		int b[] = { -1, 1, 2, 3, 4, -1, 6, -1, -1, 9 };
		iar.fixedAtIndex(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/* another apporach with O(n) both SC and TC */
	@Test
	public void fixedAtIndexXTest() {
		int a[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		int b[] = { -1, 1, 2, 3, 4, -1, 6, -1, -1, 9 };
		iar.fixedAtIndexX(a);
		for (int i = 0; i < a.length; Assert.assertTrue(a[i] == b[i]), i++)
			;
	}

	/* for every type of -ve no and no should be in list */
	@Test
	public void fixedAtIndexYTest() {
		int a[] = { 1, -5, -4, 4, 2, 3 };
		int b[] = { -5, 1, 2, 3, 4, -4 };
		iar.fixedAtIndexY(a);
		for (int i = 0; i < a.length; Assert.assertTrue(a[i] == b[i]), i++)
			;
	}

	/** 2. Write a program to reverse an array or string TC O(n/2) **/
	@Test
	public void reverseArrTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int b[] = { 7, 6, 5, 4, 3, 2, 1 };
		iar.reverseArr(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/**
	 * 3. Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j]
	 * if i is odd and j < i
	 **/
	@Test
	public void evenPosIncrOddPosDecrTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int b[] = { 4, 5, 3, 6, 2, 7, 1 };

		iar.evenPosIncrOddPosDecr(a, a.length);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	@Test
	public void evenPosIncrOddPosIncrTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int b[] = { 4, 3, 5, 2, 6, 1, 7 };

		iar.evenPosIncrOddPosIncr(a, a.length);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 4. Rearrange positive and negative numbers in TC O(n) time and SC O(1) **/
	@Test
	public void reArragePosAndNegTest() {
		int a[] = { 1, -2, 3, -4, 5, -6, 7, -8, 9 };
		int b[] = { -8, -2, -6, -4, 5, 3, 7, 1, 9 };
		iar.reArragePosAndNeg(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 5. Rearrange array in alternating positive & negative items by T(n) S(1) **/
	@Test
	public void alternativePosNevElemTest() {

		int a[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int b[] = { 4, -3, 5, -1, 6, -7, 2, 8, 9 };
		iar.alternativePosNevElem(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 6. Move all zeroes to end of array **/
	@Test
	public void pushZerosToEndTest() {
		int a[] = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int b[] = { 1, 9, 8, 4, 2, 7, 6, 9, 0, 0, 0, 0, 0 };
		iar.pushZerosToEnd(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 7. Move all zeroes to end of array | (Using single traversal) **/
	@Test
	public void moveZerosToEndTest() {
		int a[] = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int b[] = { 1, 9, 8, 4, 2, 7, 6, 9, 0, 0, 0, 0, 0 };
		iar.moveZerosToEnd(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 8. Minimum swaps bring all elements less than or equal to k together **/
	@Test
	public void minSwapLessThanKElemTogetherTest() {
		int a[] = { 2, 1, 5, 6, 3 };
		int k = 3;
		Assert.assertTrue(iar.minSwapLessThanKElemTogether(a, k) == 2);
		int b[] = { 2, 7, 9, 5, 8, 7, 4 };
		int k1 = 5;
		Assert.assertTrue(iar.minSwapLessThanKElemTogether(b, k1) == 2);
	}

	/** 9. Rearrange positive and negative numbers using inbuilt sort function **/
	// @See 4.
	/** 10. Rearrange array such that even positioned are greater than odd **/
	@Test
	public void evenPosGreaterThanOddPosTest() {
		int a[] = { 1, 3, 2, 2, 5 };
		int b[] = { 1, 5, 2, 3, 2 };

		iar.evenPosGreaterThanOddPos(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/**
	 * 11. Rearrange an array in order  smallest, largest, 2nd smallest, 2nd
	 * largest, ..
	 **/
	@Test
	public void reArrangeSpecillyTest() {
		int a[] = { 1, 4, 3, 2, 5, 6, 9, 7, 8 };
		int b[] = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		iar.reArrangeSpecilly(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 12. Double the first element and move zero to end **/
	@Test
	public void doubleFirstAndPushZeroEndTest() {
		int a[] = { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 };
		int b[] = { 4, 2, 12, 8, 0, 0, 0, 0, 0, 0 };
		iar.doubleFirstAndPushZeroEnd(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 13. Reorder an array according to given indexes **/
	@Test
	public void reorderAccToGivenIndexTest() {
		int arr[] = { 50, 40, 70, 60, 90 };
		int index[] = { 3, 0, 4, 1, 2 };
		int b[] = { 40, 60, 90, 50, 70 };
		iar.reorderAccToGivenIndex(arr, index);
		for (int i = 0; i < arr.length; i++)
			Assert.assertTrue(arr[i] == b[i]);
	}

	/** 14. Rearrange positive and negative numbers with constant extra space **/
	@Test
	public void rearrangePosNegTest() {
		reArragePosAndNegTest();
	}

	/** 15. Arrange given numbers to form the biggest number **/
	@Test
	public void formBiggestNoTest() {
		int a[] = { 54, 546, 548, 60 };
		int b[] = { 9, 3, 34, 31 };
		Assert.assertTrue(iar.formBiggestNo(a).equals("6054854654"));
		Assert.assertTrue(iar.formBiggestNo(b).equals("934331"));
	}

	/** 16. Rearrange an array such that arr[j] becomes i if arr[i] is j **/
	@Test
	public void arrangeInSpecialTest() {
		int a[] = { 1, 3, 0, 2 };
		int b[] = { 2, 0, 3, 1 };

		iar.arrangeInSpecial(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 17. Rearrange an array in maximum minimum form | Set 1 */
	// Expected time complexity is O(n). sorted array
	@Test
	public void rearrangeMaxMinFormTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		iar.rearrangeMaxMinForm(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 18. Rearrange an array in maximum minimum form | Set 2 (O(1) space) **/
	@Test
	public void segregateElementsTest() {
		int a[] = { -5, 7, -3, -4, 9, 10, -1, 11 };
		int b[] = { 7, 9, 10, 11, -5, -3, -4, -1 };
		iar.segregateElements(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}
	/**
	 * 19. Move all negative numbers to beginning and positive to end with constant
	 * extra space
	 **/
	// @See 14.
	/** 20. Move all negative elements to end in order with extra space allowed **/
	// @See 14.
	/**
	 * 21. Rearrange array such that even index elements are smaller and odd index
	 * elements are greater
	 **/
	// @See 17.

	/** 22. Positive elements at even and negative at odd positions **/
	// @See 5.
	/** 23. Replace every array element by multiplication of previous and next **/
	@Test
	public void modifyTest() {
		int a[] = { 2, 3, 4, 5, 6 };
		int b[] = { 6, 8, 15, 24, 30 };
		iar.modify(a, a.length);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 24. Shuffle a given array **/

	@Test
	public void shuffleArrTest() {
		int a[] = { 2, 3, 4, 5, 6 };
		iar.shuffleArr(a, a.length);
		System.out.println(Arrays.toString(a));
	}
	/** 25. Segregate even and odd numbers **/
	// @See 14 there +ve/-ve here odd/even

	/**********************************************************************************************/

	/** 3. Sort an array in wave form **/
	@Test
	public void sortInWaveFormTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		iar.sortInWaveForm(a);
		System.out.println(Arrays.toString(a));
	}

	/** 6. Move all negative elements to end in order with extra space allowed **/
	@Test
	public void allNegelemEndofArrTest() {
		int a[] = { 1, -2, 3, -4, 5, -6, 7, -8, 9 };
		int b[] = { 1, 9, 3, 7, 5, -6, -4, -8, -2 };
		iar.allNegelemEndofArr(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 7. Three way partitioning of an array around a given range **/
	@Test
	public void threeWayPartitioningTest() {
		int a[] = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };
		int x = 14;
		int y = 20;
		int b[] = { 1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54 };
		iar.threeWayPartitioning(a, x, y);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 8. Rearrange an array in maximum minimum form | Set 1 **/
	@Test // arr is sorted
	public void rearrangeInMaxMinFormTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		a = iar.rearrangeInMaxMinForm(a);
		// System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}
}
