package com.hackerrank.ps.basic.easy.sorting;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBasicEasySortingTest {

	IBasicEasySorting ibs;

	@Before
	public void init() {
		ibs = new BasicEasySortingImpl();
	}

	/* Big Sorting */
	@Test
	public void bigSortingTest() {

		System.out.println(ibs.bigSorting(List.of("6", "31415926535897932384626433832795", "1", "3", "10", "3", "5")));
		System.out.println(ibs.bigSorting(List.of("100", "200", "111")));

	}

	/* Intro to Tutorial Challenges */
	@Test
	public void introTutorialTest() {
		Assert.assertTrue(ibs.introTutorial(4, List.of(2, 3, 7, 8, 4)) == 4);
	}

	/* Insertion Sort - Part 1 */
	@Test
	public void insertionSort1Test() {
		List<Integer> list = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 1);
		ibs.insertionSort1(list.size(), list);
	}

	/* Insertion Sort - Part 1 */
	@Test
	public void insertionSort2Test() {
		List<Integer> list = List.of(9, 8, 6, 7, 3, 5, 4, 1, 2);
		ibs.insertionSort2(list.size(), list);
	}

	/* Correctness and the Loop Invariant */
	@Test
	public void insertionSortTest() {
		int a[] = { 9, 8, 6, 7, 3, 5, 4, 1, 2 };
		ibs.insertionSort(a);
	}

	/* Quicksort 1 - Partition */
	@Test
	public void quickSortTest() {
		List<Integer> list = ibs.quickSort(List.of(4, 2, 3, 7, 8));
		System.out.println(list);
	}

	/* Running Time of Algorithms */
	@Test
	public void runningTimeTest() {
		Assert.assertTrue(ibs.runningTime(List.of(2, 1, 3, 1, 2)) == 4);
	}

	/* Counting Sort 1 */
	@Test
	public void countingSortTest() {
		List<Integer> list = ibs.countingSort(List.of(1, 1, 3, 2, 1));
		System.out.println(list);
	}

	/* Closest Numbers */
	@Test
	public void closestNumbersTest() {
		List<Integer> list = ibs.closestNumbers(List.of(5, 2, 3, 4, 1));
		System.out.println(list);
	}

	/* Find the Median */
	@Test
	public void findMedianTest() {
		int median = ibs.findMedian(List.of(5, 2, 3, 4, 1));
		Assert.assertTrue(median == 3);
	}
}
