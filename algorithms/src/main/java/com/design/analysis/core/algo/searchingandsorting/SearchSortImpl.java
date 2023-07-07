package com.design.analysis.core.algo.searchingandsorting;

import java.util.Arrays;

public class SearchSortImpl implements ISearchSort {

	@Override
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@Override
	public int max(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}
	
	@Override
	public Integer binarySearch(int x, int[] a) {

		if (a.length == 0)
			return null;
		else {
			Arrays.sort(a);
			return binarySearch(x, 0, a.length - 1, a);
		}
	}

	@Override
	public Integer binarySearch(int x, int l, int r, int a[]) {
		int mid = (l + r) / 2;
		if (a[mid] == x)
			return mid;
		else {
			if (x < a[mid])
				return binarySearch(x, l, mid - 1, a);
			else
				return binarySearch(x, mid + 1, r, a);
		}
	}

	@Override
	public Integer jumpSearch(int a[], int x) {
		if (a == null)
			return -1;
		else {
			int step = (int) Math.sqrt(a.length);
			int i = 0;
			int prev = 0;
			for (; i < a.length; i = i + step) {
				if (a[prev] <= x && x <= a[i])
					break;
				prev = i;
			}

			i = i - step;
			if (i < 0)
				i = 0;
			for (int j = i; j < i + step && j < a.length; j++) {
				if (a[j] == x)
					return j;
			}
		}
		return -1;
	}

	@Override
	public Integer interpolationSearch(int a[], int x) {

		int lo = 0;
		int hi = a.length - 1;

		if (x > a[hi] || x < a[lo])
			return -1;
		while (lo < hi) {
			int pos = lo + (x - a[lo]) * (hi - lo) / (a[hi] - a[lo]);
			if (a[pos] == x)
				return pos;
			else if (a[pos] < x)
				lo = pos + 1;
			else
				hi = pos - 1;
		}
		return -1;
	}

	@Override
	public void selectionSort(int[] a) {
		if (a.length == 0 || a.length == 1)
			return;
		else {
			for (int i = 0; i < a.length; i++) {
				for (int j = i + 1; j < a.length; j++) {
					if (a[i] > a[j]) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
		}
	}

	@Override
	public void bubbleSort(int[] a) {
		if (a.length == 0 || a.length == 1)

			return;
		else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					if (a[j] > a[j + 1]) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
					}
				}
			}
		}
	}

	@Override
	public void insertionSort(int[] a) {
		if (a.length == 0 || a.length == 1)
			return;
		else {
			int n = a.length;
			for (int i = 1; i < n; ++i) {
				int key = a[i];
				int j = i - 1;

				/*
				 * Move elements of arr[0..i-1], that are greater than key, to
				 * one position ahead of their current position
				 */
				while (j >= 0 && a[j] > key) {
					a[j + 1] = a[j];
					j = j - 1;
				}
				a[j + 1] = key;
			}
		}
		;
	}

	@Override
	public void mergeSort(Integer[] a) {

		// If list is empty; no need to do anything
		if (a.length <= 1) {
			return;
		}

		// Split the array in half in two parts
		Integer[] first = new Integer[a.length / 2];
		Integer[] second = new Integer[a.length - first.length];
		System.arraycopy(a, 0, first, 0, first.length);
		System.arraycopy(a, first.length, second, 0, second.length);

		// Sort each half recursively
		mergeSort(first);
		mergeSort(second);

		// Merge both halves together, overwriting to original array
		merge(first, second, a);
	}

	public void merge(Integer first[], Integer second[], Integer result[]) {

		// Index Position in first array - starting with first element
		int iFirst = 0;

		// Index Position in second array - starting with first element
		int iSecond = 0;

		// Index Position in merged array - starting with first position
		int iMerged = 0;

		// Compare elements at iFirst and iSecond,
		// and move smaller element at iMerged
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		// copy remaining elements from both halves - each half will have
		// already sorted elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}

	@Override
	public void maxHeapSort(int a[]) {

		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--) // build head so max is at 0
			maxHeapify(a, n, i);

		// swap the 0 to end and hipify the rest
		for (int i = n - 1; i >= 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapify(a, i, 0);
		}
	}

	@Override
	public void minHeapSort(int a[]) {
		int n = a.length;
		for (int i = n / 2 - 1; i >= 0; i--) // build head so max is at 0
			minHeapify(a, n, i);

		// swap the 0 to end and hipify the rest
		for (int i = n - 1; i >= 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			minHeapify(a, i, 0);
		}
	}

	@Override
	public void maxHeapify(int a[], int n, int i) {

		int lar = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a[l] > a[lar])
			lar = l;
		if (r < n && a[r] > a[lar])
			lar = r;

		if (lar != i) {
			int swap = a[i];
			a[i] = a[lar];
			a[lar] = swap;
			maxHeapify(a, n, lar);
		}
	}

	@Override
	public void minHeapify(int a[], int n, int i) {

		int lar = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a[l] < a[lar])
			lar = l;
		if (r < n && a[r] < a[lar])
			lar = r;

		if (lar != i) {
			int swap = a[i];
			a[i] = a[lar];
			a[lar] = swap;
			maxHeapify(a, n, lar);
		}
	}

	@Override
	public void quickSort(int[] a, int l, int h) {

		int pvt = l + (h - l) / 2;
		int i = l;
		int j = h;

		while (i <= j) {
			while (a[i] < a[pvt])
				i++;
			while (a[j] > a[pvt])
				j--;
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		if (l < j)
			quickSort(a, l, j);
		if (i < h)
			quickSort(a, i, h);
	}

	@Override
	public void radixSort(int[] a) {
		// int max = max(a);

	}

	@Override
	public void countingSort(int[] a) {

		int max = max(a);
		int output[] = new int[a.length];
		int count[] = new int[max + 1];
		for (int i = 0; i < a.length; i++) {
			++count[a[i]];
		}

		// add the previous to current
		for (int i = 1; i < max+1; i++)
			count[i] += count[i - 1];

		// build output array
		for (int i = 0; i < a.length; i++) {
			output[count[a[i]] - 1] = a[i];
			--count[a[i]];
		}
		for (int i = 0; i < a.length; i++)
			a[i] = output[i];
	}
}
