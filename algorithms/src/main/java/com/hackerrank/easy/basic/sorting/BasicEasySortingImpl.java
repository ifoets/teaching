package com.hackerrank.easy.basic.sorting;



import com.hackerrank.easy.basic.comman.ArraysUtil;

import java.util.*;
import java.util.stream.Collectors;

public class BasicEasySortingImpl implements IBasicEasySorting {

	/* Big Sorting */
	// @Idea first check length difference then value
	@Override
	public int compareStrings(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		} else if (s1.length() > s2.length()) {
			return 1;
		}
		for (int k = 0; k < s1.length(); k++) {
			if ((int) s1.charAt(k) < (int) s2.charAt(k))
				return -1;
			if ((int) s1.charAt(k) > (int) s2.charAt(k))
				return 1;
		}
		return 0;
	}

	@Override
	public List<String> bigSorting(List<String> unsorted) {

		return unsorted.stream().sorted(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return compareStrings(s1, s2);
			}
		}).collect(Collectors.toList());

	}

	@Override
	// @Idea return the index of matching element
	public int introTutorial(int V, List<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (V == arr.get(i))
				return i;
		}
		return -1;
	}

	/* Insertion Sort - Part 1 */
	// @Idea Apply simple insertion sort print inner iteration and one finally outer
	@Override
	public void insertionSort1(int n, List<Integer> arr) {
		int j, key;
		Integer[] a = arr.toArray(new Integer[arr.size()]);
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			boolean flag = false;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
				for (int k = 0; k < n; k++)
					System.out.print(a[k] + " ");
				flag = true;
				System.out.println();
			}
			a[j + 1] = key;
			if (flag) {
				for (int k = 0; k < n; k++)
					System.out.print(a[k] + " ");
			}
		}
	}

	/* Insertion Sort - Part 2 */
	// @Idea Apply simple insertion sort print at every outer iteration
	@Override
	public void insertionSort2(int n, List<Integer> arr) {
		int j, key;
		Integer[] a = arr.toArray(new Integer[arr.size()]);
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;

			for (int k = 0; k < n; k++)
				System.out.print(a[k] + " ");
			System.out.println();
		}
	}

	/* Correctness and the Loop Invariant */
	// @Idea Apply simple insertion sort
	@Override
	public void insertionSort(int[] a) {

		int j, key;
		int n = a.length;
		// Integer[] a = arr.toArray(new Integer[arr.size()]);
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}

		for (int k = 0; k < n; k++)
			System.out.print(a[k] + " ");
	}

	/* Quicksort 1 - Partition */
	@Override
	public List<Integer> quickSort(List<Integer> iList) {
		Integer[] arr = iList.toArray(new Integer[iList.size()]);
		int high = arr.length - 1;
		int pivot = arr[0];
		int i = 0;

		for (int j = 1; j <= high; j++) {
			if (arr[j] < pivot) {
				i++;
				ArraysUtil.swap(arr, i, j);
			}
		}
		ArraysUtil.swap(arr, i, 0);
		return Arrays.asList(arr);
	}

	/* Running Time of Algorithms */
	// @Idea just put counter in shifting block
	public int runningTime(List<Integer> arr) {
		int j, key;
		int n = arr.size();
		int count = 0;
		Integer[] a = arr.toArray(new Integer[arr.size()]);
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
				count++;
			}
			a[j + 1] = key;
		}
		return count;
	}

	/* Counting Sort 1 */
	// @Idea find max element, create new array of max+1 size and count each
	@Override
	public List<Integer> countingSort(List<Integer> arr) {
		List<Integer> resultList = new ArrayList<>();
		int max = arr.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
		int a[] = new int[max + 1];
		for (int i = 0; i < arr.size(); a[arr.get(i)]++, i++)
			;
		for (int i = 0; i < a.length; resultList.add(a[i]), i++)
			;
		return resultList;
	}

	/* Counting Sort 2 */
	// @Idea find max element, create new array of max+1 size and print in series
	@Override
	public List<Integer> countingSort2(List<Integer> arr) {
		List<Integer> resultList = new ArrayList<>();
		int max = arr.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
		int a[] = new int[max + 1];
		for (int i = 0; i < arr.size(); a[arr.get(i)]++, i++)
			;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i]; resultList.add(i), j++)
				;
		}

		return resultList;
	}

	/* Closest Numbers */
	// Idea sort the list then find the min difference and then the elements
	@Override
	public List<Integer> closestNumbers(List<Integer> arr) {
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		int n = arr.size();

		Integer[] a = arr.toArray(new Integer[arr.size()]);
		Arrays.sort(a);
		for (int i = 0; i < n - 1; i++) {
			if (a[i + 1] - a[i] < min)
				min = a[i + 1] - a[i];
		}
		for (int k = 0; k < n - 1; k++) {
			if (a[k + 1] - a[k] == min) {
				list.add(a[k]);
				list.add(a[k + 1]);
			}
		}
		return list;
	}

	/* Find the Median */
	// @Idea sort and return n/2th element
	@Override
	public int findMedian(List<Integer> arr) {
		Integer[] a = arr.toArray(new Integer[arr.size()]);
		Arrays.sort(a);
		return a[a.length / 2];
	}
}