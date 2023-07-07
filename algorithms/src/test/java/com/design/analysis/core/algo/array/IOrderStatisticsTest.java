package com.design.analysis.core.algo.array;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.algo.array.model.SmallestSum;

public class IOrderStatisticsTest {

	public IOrderStatistics ios = null;

	@Before
	public void init() {
		ios = new OrderStatisticsImpl();
	}

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
	@Test
	public void kthHeigstOrSmallestTest() {

		int a[] = { 0, -1, 2, -2, 9, -8, 8, 0, 5, 6, 1, 7 };
		int b[] = { -8, -2, -1, 0, 1, 2, 5, 6, 7, 8, 9 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(ios.kthHeigstOrSmallest(a, i + 1, true) == b[i]);

		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(ios.kthHeigstOrSmallest(a, i + 1, false) == b[b.length - 1 - i]);
	}

	@Test
	public void kthHeigstOrSmallestXTest() {
		int a[] = { 0, -1, 2, -2, 9, -8, 8, 0, 5, 6, 1, 7 };
		int b[] = { -8, -2, -1, 0, 0, 1, 2, 5, 6, 7, 8, 9 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(ios.kthHeigstOrSmallestX(a, i + 1, true) == b[i]);

		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(ios.kthHeigstOrSmallestX(a, i + 1, false) == b[b.length - 1 - i]);
	}

	/********************************************************************************************************************************************************************/
	/**
	 * 5. k largest(or smallest) elements in an array | added Min Heap method O(n)
	 **/
	@Test
	public void kLargestTest() {
		int a[] = { 0, 1, 2, 0, 3, 4, 1, 9, 7, 2, 8, 9, 8, 7, 7 };
		List<Integer> listLarK = ios.kLargestSmallest(a, 3, true);
		List<Integer> listSmallK = ios.kLargestSmallest(a, 3, false);
		Assert.assertTrue(listLarK.size() == 3);
		Assert.assertTrue(listLarK.get(0) == 9);
		Assert.assertTrue(listLarK.get(1) == 8);
		Assert.assertTrue(listLarK.get(2) == 7);

		Assert.assertTrue(listSmallK.size() == 3);
		Assert.assertTrue(listSmallK.get(0) == 0);
		Assert.assertTrue(listSmallK.get(1) == 1);
		Assert.assertTrue(listSmallK.get(2) == 2);
	}

	/**
	 * 6. Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1
	 **/
	@Test
	public void kthSmallestRowAndComTest() {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 25, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(ios.kthSmallestRowAndCom(mat, mat.length, 3));
		Assert.assertTrue(ios.kthSmallestRowAndCom(mat, mat.length, 7) == 30);
		Assert.assertTrue(ios.kthSmallestRowAndCom(mat, mat.length, 3) == 20);
	}

	// it is valid for any nos duplicate and -ve
	@Test
	public void kthMaxElementAnyNosTest() {
		int a[] = { 0, 0 - 1, -5, 5, -3, 1, -1, -3, -5, -5, 8, 6, 9, 7, 8 };
		int b[] = { -5, -3, -1, 0, 1, 5, 6, 7, 8, 9 };
		for (int i = 0; i < b.length; i++)
			Assert.assertTrue(ios.kthMaxElementAnyNos(a, i+1) == b[i]);
	}

	@Test
	public void kthSmallestRowAndComXTest() {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Assert.assertTrue(ios.kthSmallestRowAndComX(mat, mat.length, 7) == 7);
		Assert.assertTrue(ios.kthSmallestRowAndComX(mat, mat.length, 3) == 3);

		int mat1[][] = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		Assert.assertTrue(ios.kthSmallestRowAndComX(mat1, mat1.length, 7) == 7);
		Assert.assertTrue(ios.kthSmallestRowAndComX(mat1, mat1.length, 3) == 3);
	}

	/** 3. Program to find largest element in an array **/
	@Test
	public void kthMaxElement() {

		int a[] = { 2, 9, 4, 7, 5, 6, 1, 3, 8 };
		Assert.assertTrue(ios.kthMaxElement(a, 3) == 7);
		Assert.assertTrue(ios.kthMaxElement(a, 1) == 9);
	}

	/** 8. Find all elements in array which have at-least two greater elements **/
	@Test
	public void allElemAtleathave2GreterTest() {
		int a[] = { 0, 1, 2, 0, 3, 4, 1, 9, 7, 2, 8, 9, 8, 7, 7 };
		List<Integer> listLarK = ios.allElemAtleathave2Greter(a, true);
		List<Integer> listSmallK = ios.allElemAtleathave2Greter(a, false);
		// System.out.println(listLarK.size()+""+listSmallK.size());
		Assert.assertTrue(listLarK.get(0) == 0);
		Assert.assertTrue(listLarK.get(1) == 1);

		Assert.assertTrue(listSmallK.get(0) == 2);
		Assert.assertTrue(listSmallK.get(1) == 3);
	}

	/** 9. Find k pairs with smallest sums in two arrays **/
	@Test
	public void kSmallestPairSumTest() {
		int a[] = { 1, 3, 11 };
		int b[] = { 2, 4, 8 };
		List<SmallestSum> list = ios.kSmallestPairSum(a, b, 4);
		SmallestSum s1 = new SmallestSum(1, 2);
		SmallestSum s2 = new SmallestSum(1, 4);
		Assert.assertTrue(list.contains(s1));
		Assert.assertTrue(list.contains(s2));
	}

	/** 10. k-th smallest absolute difference of two elements in an array **/
	@Test
	public void kthSmallestAbsDiffTest() {
		int a[] = { 1, 2, 3, 4 };
		Assert.assertTrue(ios.kthSmallestAbsDiff(a, 3) == 1);
	}

	/** 12. Find k numbers with most occurrences in the given array **/
	@Test
	public void kHiFreqNumberTest() {
		int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
		int k = 2;
		int b[] = ios.kHiFreqNumber(arr, k);
		Assert.assertTrue(b[0] == 4);
		Assert.assertTrue(b[1] == 1);
	}
}
