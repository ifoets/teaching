package com.design.analysis.algo.searchingandsorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISearchSortTest {
	
	ISearchSort iss = null;

	@Before
	public void init() {
		iss = new SearchSortImpl();
	}

	@Test
	public void binarySearchTest() {

		int a[] = { 1, 2, 9, 0, 7, 6, 5, 4, 3 };
		int x1 = 3;
		int x2 = 0;
		int x3 = 9;
		int indx1 = iss.binarySearch(x1, a);
		int indx2 = iss.binarySearch(x2, a);
		int indx3 = iss.binarySearch(x3, a);

		Assert.assertTrue(indx1 == 3);
		Assert.assertTrue(indx2 == 0);
		Assert.assertTrue(indx3 == 8);

	}

	@Test
	public void selectionSortTest() {
		int a[] = { 1, 2, 9, 0, 7, 6, 5, 4, 3 };

		iss.selectionSort(a);
		Assert.assertTrue(a[3] == 3);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[8] == 9);
	}

	@Test
	public void bubbleSortTest() {
		int a[] = { 2, 1, 9, 0, 7, 6, 5, 4, 3 };

		iss.bubbleSort(a);
		Assert.assertTrue(a[3] == 3);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[8] == 9);
	}

	@Test
	public void insertionSortTest() {
		int a[] = { 1, 2, 9, 0, 7, 6, 5, 4, 3 };

		iss.insertionSort(a);
		Assert.assertTrue(a[3] == 3);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[8] == 9);
	}

	@Test
	public void mergeSortTest() {
		Integer a[] = { 1, 2, 9, 0, 7, 6, 5, 4, 3 };

		iss.mergeSort(a);
		Assert.assertTrue(a[3] == 3);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[8] == 9);
	}

	@Test
	public void jumpSearchTest() {

		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int x1 = iss.jumpSearch(a, 0);
		int x2 = iss.jumpSearch(a, 10);
		int x3 = iss.jumpSearch(a, 5);
		int x4 = iss.jumpSearch(a, 11);

		Assert.assertTrue(x1 == 0);
		Assert.assertTrue(x2 == 10);
		Assert.assertTrue(x3 == 5);
		Assert.assertTrue(x4 == -1);
	}

	@Test
	public void interpolationSearchTest() {
		int a[] = { 0, 11, 21, 35, 49, 50, 65, 79, 81, 99, 101 };

		int x1 = iss.interpolationSearch(a, 81);
		int x2 = iss.interpolationSearch(a, 11);
		int x3 = iss.interpolationSearch(a, 101);
		int x4 = iss.interpolationSearch(a, 491);

		Assert.assertTrue(x1 == 8);
		Assert.assertTrue(x2 == 1);
		Assert.assertTrue(x3 == 10);
		Assert.assertTrue(x4 == -1);
	}

	@Test
	public void maxHeapSortTest() {
		int a[] = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		iss.maxHeapSort(a);

		Assert.assertTrue(a[a.length - 1] == 10);
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[4] == 5);
		Assert.assertTrue(a[8] == 9);
	}

	@Test
	public void minHeapSortTest() {
		int a[] = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		iss.minHeapSort(a);
		Assert.assertTrue(a[a.length - 1] == 1);
		Assert.assertTrue(a[0] == 10);
		Assert.assertTrue(a[4] == 6);
		Assert.assertTrue(a[8] == 2);
	}

	@Test
	public void maxHeapifyTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			iss.maxHeapify(a, n, i);
		Assert.assertTrue(a[0] == 10);

	}

	@Test
	public void minHeapifyTest() {
		int a[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			iss.minHeapify(a, n, i);
		Assert.assertTrue(a[0] == 1);
	}

	@Test
	public void swap() {

		int a[] = { 1, 2, 3, 4, 5 };

		iss.swap(a, 0, 4);
		Assert.assertTrue(a[0] == 5);
		iss.swap(a, 1, 3);
		Assert.assertTrue(a[3] == 2);
	}

	@Test
	public void quickSort() {
		int a[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		iss.quickSort(a, 0, a.length - 1);

		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[9] == 10);
		Assert.assertTrue(a[5] == 6);
	}

	@Test
	public void maxTest() {
		int a[] = { 6, 3, 4, 8, 9, 1, 0, 2, 5 };
		Assert.assertTrue(iss.max(a) == 9);
	}
	
	@Test
	public void countingSortTest()
	{
		int a[] = { 1, 4, 1, 2, 7, 5, 2 };
		iss.countingSort(a);
		System.out.println(Arrays.toString(a));
	}
}
