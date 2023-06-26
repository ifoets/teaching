package com.hackerrank.easy.basic.sorting;

import java.util.List;

public interface IBasicEasySorting {

	/* Big Sorting */
	public int compareStrings(String s1, String s2);

	public List<String> bigSorting(List<String> unsorted);

	/* Intro to Tutorial Challenges */
	public int introTutorial(int V, List<Integer> arr);

	/* Insertion Sort - Part 1 */
	public void insertionSort1(int n, List<Integer> arr);

	/* Insertion Sort - Part 2 */
	public void insertionSort2(int n, List<Integer> arr);

	/* Correctness and the Loop Invariant */
	public void insertionSort(int[] a);

	/* Quicksort 1 - Partition */
	public List<Integer> quickSort(List<Integer> arr1);

	/* Running Time of Algorithms */
	public int runningTime(List<Integer> arr);

	/* Counting Sort 1 */
	public List<Integer> countingSort(List<Integer> arr);

	/* Counting Sort 2 */
	public List<Integer> countingSort2(List<Integer> arr);

	/* Closest Numbers */
	public List<Integer> closestNumbers(List<Integer> arr);

	/* Find the Median */
	public int findMedian(List<Integer> arr);
}
