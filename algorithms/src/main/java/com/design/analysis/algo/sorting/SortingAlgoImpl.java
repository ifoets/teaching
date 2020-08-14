package com.design.analysis.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.design.analysis.algo.sorting.model.Person;
import com.design.analysis.algo.sorting.model.Student;
import com.design.analysis.algo.utils.AlgoUtils;

public class SortingAlgoImpl implements ISortingAlgo {

	/** 0. GuruJi Sort O(n) */
	/* this is useful when max is not much more bigger than no of element */
	/*
	 * it is useful for not only uniue but also for duplicate but not for -ve
	 * element
	 */

	public void guruJiSort(int a[]) {
		int n = a.length;
		int i;
		int max = 0;
		// O(n)
		for (i = 0; i < n; i++) {
			if (max < a[i])
				max = a[i];
		}
		int b[][] = new int[max + 1][2];
		// O(n)
		for (i = 0; i < n; i++) {
			b[a[i]][0] = a[i];
			b[a[i]][1] += 1;
		}
		int k = 0;
		// O(max)
		for (i = 0; i < max + 1; i++) {
			for (int j = 0; j < b[i][1]; j++)
				a[k++] = b[i][0];
		}
	}

	/** 1. Selection Sort **/
	@Override
	public void selectionSort(int[] a) {
		if (a == null || a.length == 0 || a.length == 1)
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

	/** 2. Bubble Sort **/
	@Override
	public void bubbleSort(int[] a) {
		if (a == null || a.length == 0 || a.length == 1)

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

	/** 3. Recursive Bubble Sort **/
	@Override
	public void bubbleSortRecursive(int arr[], int n) {
		// Base case no need to sort
		if (n == 1)
			return;

		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		/* Largest element is fixed,recur for remaining array */
		bubbleSortRecursive(arr, n - 1);
	}

	/** 4. Insertion Sort **/
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
				 * Move elements of arr[0..i-1], that are greater than key, to one position
				 * ahead of their current position
				 */
				while (j >= 0 && a[j] > key) {
					a[j + 1] = a[j];
					j = j - 1;
				}
				a[j + 1] = key;
			}
		}
	}

	// from last
	@Override
	public void insertionSortX(int[] a) {
		if (a.length == 0 || a.length == 1)
			return;
		else {
			int n = a.length;
			for (int i = n - 2; i >= 0; i--) {
				int key = a[i];
				int j = i + 1;

				/*
				 * Move elements of arr[0..i-1], that are greater than key, to one position
				 * ahead of their current position
				 */
				while (j < n && key > a[j]) {
					a[j - 1] = a[j];
					j = j + 1;
				}
				a[j - 1] = key;
			}
		}
	}

	/** 5. Recursive Insertion Sort **/
	// form first to last ie top recursion
	public void insertionSortRecursive(int arr[], int n) {
		// Base case
		if (n <= 1)
			return;

		// Sort first n-1 elements

		insertionSortRecursive(arr, n - 1);

		// Insert last element at its correct position
		// in sorted array.
		int last = arr[n - 1];
		int j = n - 2;

		/*
		 * Move elements of arr[0..i-1], that are greater than key, to one position
		 * ahead of their current position
		 */
		while (j >= 0 && arr[j] > last) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = last;
	}

	// from last ..ie bottom recursion
	public void insertionSortRecursiveX(int a[], int n) {
		// Base case
		if (n == 1)
			return;

		int key = a[n - 2];
		int j = n - 1;

		while (j < a.length && key > a[j]) {
			a[j - 1] = a[j];
			j = j + 1;
		}
		a[j - 1] = key;

		insertionSortRecursiveX(a, n - 1);

	}

	/** 6. Merge Sort **/
	public void mergeTwoPartSorted(int a[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int x[] = new int[n1];
		int y[] = new int[n2];

		for (int i = 0; i < n1; i++)
			x[i] = a[l + i];
		for (int j = 0; j < n2; j++)
			y[j] = a[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (x[i] <= y[j]) {
				a[k] = x[i];
				i++;
			} else {
				a[k] = y[j];
				j++;
			}
			k++;
		}
		/* copy remaining of x[] */
		while (i < n1) {
			a[k] = x[i];
			k++;
			i++;
		}

		/* copy remaining of y[] */
		while (j < n2) {
			a[k] = y[j];
			k++;
			j++;
		}
	}

///full and half sort of array using merge sort
	public void mergeTwoPartSortedX(int a[], int l, int m, int r) {
		int j = m + 1;
		if (a[m] < a[m + 1])// all element are already sortedF
			return;
		if (a[l] > a[r])// all element of 2nd part of array r smaller
		{

			int x[] = new int[r - l + 1];
			int k = 0;
			while (m + 1 + k <= r) {
				x[k] = a[m + 1 + k];
				k++;
			}
			while (l <= m)
				x[k++] = a[l++];
			l = 0;
			while (l <= r)
				a[l] = x[l++];
			return;
		}
		// any other condition
		// take one by one element from second and by using special binary search
		// find the correct position and inject by shiftting
		while (j <= r) {
			int ind = speicalBinarySearch(a, l, j - 1, a[j]);
			int temp = a[j];
			for (int k = j - 1; k >= ind; k--)
				a[k + 1] = a[k];
			a[ind] = temp;
			j++;

		}
	}

	// special binary search just greater element
	public int speicalBinarySearch(int a[], int l, int r, int x) {

		if (r - l == 1) {// for complex if l=x and r=x+1
			if (a[l] < x && x < a[r])
				return r;
		} else if (r - l > 1) {
			int m = (l + r) / 2;
			if (x > a[r])// or return -1
				return r + 1;
			if (x < a[l])
				return l;
			if (a[m - 1] < x && x < a[m])
				return m;
			if (x > a[m])
				return speicalBinarySearch(a, m, r, x);
			else
				return speicalBinarySearch(a, l, m, x);
		}
		return -1;
	}

	@Override
	public void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			mergeTwoPartSorted(arr, l, m, r);
		}
	}

	/** 7. Iterative Merge Sort **/
	@Override

	public void mergeSortIterative(int a[]) {

		if (a == null || a.length == 0 || a.length == 1)
			return;
		if (a.length > 1) {
			int n = a.length;

			int m = n / 2;
			/* split left */
			int x[] = new int[m];
			for (int i = 0; i < m; i++)
				x[i] = a[i];

			/* split right */
			int y[] = new int[n - m];
			for (int j = 0; j < n - m; j++)
				y[j] = a[m + j];
			mergeSortIterative(x);
			mergeSortIterative(y);

			int i = 0, j = 0;
			int k = 0;
			int n1 = x.length;
			int n2 = y.length;

			while (i < n1 && j < n2) {
				if (x[i] <= y[j]) {
					a[k] = x[i];
					i++;
				} else {
					a[k] = y[j];
					j++;
				}
				k++;
			}
			/* copy remaining of x[] */
			while (i < n1) {
				a[k] = x[i];
				k++;
				i++;
			}

			/* copy remaining of y[] */
			while (j < n2) {
				a[k] = y[j];
				k++;
				j++;
			}
		}
	}

	/** 8. Quick Sort **/

	@Override
	public void beforeLastElementQuickSort(int a[], int l, int h) {
		int pi = partition(a, l, h);
		quickSort(a, l, pi - 1);
	}

	@Override
	public void afterLastElementHalfQuickSort(int a[], int l, int h) {
		int pi = partition(a, l, h);
		quickSort(a, pi + 1, h);
	}

	@Override
	public void beforeIthIndexElemeQuickSort(int a[], int l, int h, int I) {
		AlgoUtils.swap(a, I, a.length - 1);
		int pi = partition(a, l, h);
		quickSort(a, l, pi - 1);
	}

	@Override
	public void afterIthIndexElemeQuickSort(int a[], int l, int h, int I) {
		AlgoUtils.swap(a, I, a.length - 1);
		int pi = partition(a, l, h);
		quickSort(a, pi + 1, h);
	}

	@Override
	public void quickSort(int a[], int l, int h) {

		if (l < h) {
			int pi = partition(a, l, h);
			quickSort(a, l, pi - 1);
			quickSort(a, pi + 1, h);
		}
	}

//number of elm
	public int partition(int a[], int l, int h) {

		int pvt = a[h];
		int i = l - 1;
		for (int j = l; j < h; j++) {
			if (a[j] <= pvt) {
				i++;
				AlgoUtils.swap(a, i, j);
			}
		}
		AlgoUtils.swap(a, i + 1, h);
		return i + 1;
	}

	/** divide and concure find the smallest element **/
	public int smallestDivideConcure(int a[], int l, int h) {
		if (l <= h) {
			if (l == h)

				return a[l];
			else {
				int m = (l + h) / 2;
				return Math.min(Math.min(smallestDivideConcure(a, l, m - 1), smallestDivideConcure(a, m + 1, h)), a[m]);
			}
		}
		return Integer.MAX_VALUE;
	}

	/** 9. Iterative Quick Sort **/

	/** 10. Heap Sort **/
	/**
	 * arrange i index element greater than 2*i+1 index and 2*i+2 index element
	 **/
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

	/**
	 * arrange i index element less than 2*i+1 index and 2*i+2 index element
	 **/
	@Override
	public void minHeapify(int a[], int n, int i) {

		int min = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a[l] < a[min])
			min = l;
		if (r < n && a[r] < a[min])
			min = r;

		if (min != i) {
			int swap = a[i];
			a[i] = a[min];
			a[min] = swap;
			minHeapify(a, n, min);
		}
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

	/** 11. Counting Sort **/
	@Override
	public void countingSort(int[] a) {

		int max = max(a);
		int output[] = new int[a.length];
		int count[] = new int[max + 1];
		for (int i = 0; i < a.length; ++count[a[i]], i++)
			;

		// add the previous to current
		for (int i = 1; i < max + 1; count[i] += count[i - 1], i++)
			;

		// build output array
		for (int i = 0; i < a.length; output[count[a[i]] - 1] = a[i], --count[a[i]], i++) {
			;

		}
		for (int i = 0; i < a.length; a[i] = output[i], i++)
			;
	}

	// only +ve intergers
	@Override
	public void countingSortX(int[] a) {
		int max = max(a);
		int count[] = new int[max + 1];
		for (int i = 0; i < a.length; count[a[i]]++, i++)
			;
		for (int i = 0, k = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; a[k++] = i, j++)
				;
		}
	}

	/** 12. Radix Sort **/
	/** 11. Counting Sort for Radix sort **/

	public void countingSortRadiX(int[] a, int exp) {
		int n = a.length;

		int i;
		int output[] = new int[n];
		int count[] = new int[10];

		/* add the count occurrences in count[] */
		for (i = 0; i < n; i++)
			count[(a[i] / exp) % 10]++;

		/* add the previous to current */
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		/* Build the output array */
		for (i = n - 1; i >= 0; i--) {
			output[count[(a[i] / exp) % 10] - 1] = a[i];
			count[(a[i] / exp) % 10]--;
		}
		/* copy the out array to actual array */
		for (i = 0; i < n; i++)
			a[i] = output[i];
	}
	
	@Override
	public void radixSort(int a[]) {
		int m = max(a);

		/* Do counting sort for every digit of numbers */
		for (int exp = 1; m / exp > 0; exp *= 10)
			countingSortRadiX(a, exp);
	}

	/** 13. Bucket Sort **/
	@Override
	public void bucketSort(double[] a) {

		@SuppressWarnings("unchecked")
		List<Double>[] arList = new List[10];
		for (int i = 0; i < arList.length; i++)
			arList[i] = new ArrayList<Double>();
		// O(n)
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int bucket = (int) ((int) n * a[i]);
			arList[bucket].add(a[i]);
		}
		int k = 0;
		for (int j = 0; j < arList.length; j++) {
			Collections.sort(arList[j]);
			for (Double fl : arList[j])
				a[k++] = fl;
		}
	}

	/** 14. ShellSort **/
	public void shellSort(int arr[]) {
		int n = arr.length;
		// Start with a big gap, then reduce the gap
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];
				arr[j] = temp;
			}
		}
	}

	/** 15. TimSort **/

	public static int RUN = 32;

	public void timeSort(int a[]) {

		int n = a.length;
		for (int i = 0; i < n; i += RUN)
			AlgoUtils.insertionSort(a, i, Math.min((i + 31), (n - 1)));

		for (int size = RUN; size < n; size = 2 * size) {
			for (int left = 0; left < n; left += 2 * size) {
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));
				AlgoUtils.mergeTwoPartSorted(a, left, mid, right);
			}
		}
	}

	/** 16. Comb Sort **/
	// To find gap between elements
	public int getNextGap(int gap) {
		// Shrink gap by Shrink factor
		gap = (gap * 10) / 13;

		if (gap < 1)
			return 1;
		return gap;
	}

	public void combSort(int a[]) {
		int n = a.length;
		// Initialize gap
		int gap = n;

		// Initialize swapped as true to make sure that
		// loop runs
		boolean swapped = true;

		// Keep running while gap is more than 1 and last
		// iteration caused a swap
		while (gap != 1 || swapped == true) {
			// Find next gap
			gap = getNextGap(gap);

			// Initialize swapped as false so that we can
			// check if swap happened or not
			swapped = false;

			// Compare all elements with current gap
			for (int i = 0; i < n - gap; i++) {
				if (a[i] > a[i + gap]) {
					AlgoUtils.swap(a, i, i + gap);
					swapped = true;
				}
			}
		}
	}

	/** 17. Pigeonhole Sort **/
	public void pigeonholeSort(int a[]) {

		int max = max(a);
		int min = min(a);
		int i, j, index, range;

		range = max - min + 1;
		int count[] = new int[max + 1];
		for (i = 0; i < a.length; i++) {
			++count[a[i] - min];
		}

		/*
		 * // add the previous to current for (int i = 1; i < max + 1; i++) count[i] +=
		 * count[i - 1];
		 */
		index = 0;

		for (j = 0; j < range; j++)
			while (count[j]-- > 0)
				a[index++] = j + min;
		/*
		 * // build output array for (int i = 0; i < a.length; i++) { output[count[a[i]]
		 * - 1] = a[i]; --count[a[i]]; } for (int i = 0; i < a.length; i++) a[i] =
		 * output[i];
		 */
	}

	/** 18. Cycle Sort **/
	int writes = 0;

	@Override
	public void cycleSort(int a[]) {
		int n = a.length;
		for (int cl = 0; cl <= n - 2; cl++) {

			int item = a[cl];
			int pos = cl;
			for (int i = cl + 1; i < n; i++)
				if (a[i] < item)
					pos++;

			// If item is already in correct position
			if (pos == cl)
				continue;

			// ignore all duplicate elements
			while (item == a[pos])
				pos += 1;

			// put the item to it's right position
			if (pos != cl) {
				int temp = item;
				item = a[pos];
				a[pos] = temp;
				writes++;
			}

			// Rotate rest of the cycle
			while (pos != cl) {
				pos = cl;

				// Find position where we put the element
				for (int i = cl + 1; i < n; i++)
					if (a[i] < item)
						pos += 1;

				// ignore all duplicate elements
				while (item == a[pos])
					pos += 1;

				// put the item to it's right position
				if (item != a[pos]) {
					int temp = item;
					item = a[pos];
					a[pos] = temp;
					writes++;
				}
			}
		}
	}

	/** 19. Cocktail Sort **/
	public void cocktailSort(int a[]) {
		int l = 0;
		int e = a.length;
		boolean swaped = true;

		while (swaped) {
			swaped = false;
			// iteration last will be biggest one
			for (int i = l; i < e - 1; i++) {
				if (a[i] > a[i + 1]) {
					AlgoUtils.swap(a, i, i + 1);
					swaped = true;
				}
			}
			// arr is already sorted
			if (!swaped)
				break;

			swaped = false;
			e = e - 1;
			for (int i = e - 1; i >= l; i--) {
				if (a[i] > a[i + 1]) {
					AlgoUtils.swap(a, i, i + 1);
					swaped = true;
				}
			}
			l = l + 1;
		}
	}

	/** 20. Strand Sort **/
	public void strandSort(int a[]) {

		List<Integer> in = new ArrayList<>();
		List<Integer> op = new ArrayList<>();
		for (int i = 0; i < a.length; in.add(a[i]), i++)
			;
		op = strandSort(in, op);
		for (int i = 0; i < a.length; a[i] = op.get(i), i++)
			;
	}

	public List<Integer> strandSort(List<Integer> in, List<Integer> op) {

		if (in.isEmpty())
			return op;
		List<Integer> subList = new ArrayList<>();
		subList.add(in.get(0));
		in.remove(0);

		for (int i = 0; i < in.size(); i++) {
			if (in.get(i) > subList.get(subList.size() - 1)) {
				subList.add(in.get(i));
				in.remove(i);
			}
		}
		op = SortingUtils.mergeSortedList(op, subList);
		return strandSort(in, op);
	}

	/** 21. Bitonic Sort **/
	@Override
	public void compAndSwap(int a[], int i, int j, int dir) {
		if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
			AlgoUtils.swap(a, i, j);
		}
	}

	@Override
	public void bitonicMerge(int a[], int low, int cnt, int dir) {
		if (cnt >= 1) {
			int k = cnt / 2;
			for (int i = low; i < low + k; i++)
				compAndSwap(a, i, i + k, dir);
			bitonicMerge(a, low, k, dir);
			bitonicMerge(a, low + k, k, dir);
		}
	}

	@Override
	public void bitonicSort(int a[], int low, int cnt, int dir) {
		if (cnt >= 1) {
			int k = cnt / 2;
			// sort in ascending order since dir here is 1
			bitonicSort(a, low, k, 1);
			// sort in descending order since dir here is 0
			bitonicSort(a, low + k, k, 0);
			// Will merge wole sequence in ascending order
			// since dir=1.
			bitonicMerge(a, low, cnt, dir);
		}
	}

	/** 22. Pancake sorting **/
	public void pankakeSorte(int a[]) {

		int n = a.length - 1;
		for (int i = n; i > 0; i--) {
			int maxInd = AlgoUtils.maxIndex(a, i + 1);
			AlgoUtils.rvereseArray(a, maxInd, i);
		}
	}

	/** 22. Binary Insertion Sort **/
	public int loc;

	@Override
	public void binaryInsertionSort(int a[]) {
		if (a.length == 0 || a.length == 1)
			return;
		else {
			int n = a.length;

			for (int i = 1; i < n; ++i) {
				int key = a[i];
				int j = i - 1;

				loc = AlgoUtils.binarySearch(a, 0, j, key);
				while (j >= 0 && a[j] > key) {
					a[j + 1] = a[j];
					j = j - 1;
				}
				a[j + 1] = key;
			}
		}
	}

	/** 24. BogoSort or Permutation Sort **/
	@Override
	public boolean isSorted(int a[], int n) {
		while (--n >= 1)
			if (a[n] < a[n - 1])
				return false;
		return true;
	}

	// To generate permuatation of the array
	@Override
	public void shuffle(int a[], int n) {
		for (int i = 0; i < n; i++)
			AlgoUtils.swap(a, i, (int) (Math.random() * i));
	}

	// Sorts array a[0..n-1] using Bogo sort
	@Override
	public void bogosort(int a[]) {
		int n = a.length;
		// if array is not sorted then shuffle
		// the array again
		int cnt = 0;
		while (!isSorted(a, n)) {
			shuffle(a, n);
			cnt++;
		}
		System.out.println(cnt);
	}

	/** 25. Gnome Sort **/
	public void gnomeSort(int a[]) {
		int n = a.length;
		int ind = 0;

		while (ind < n) {
			if (ind == 0)
				ind++;
			if (a[ind] >= a[ind - 1])
				ind++;
			else {
				AlgoUtils.swap(a, ind, ind - 1);
				ind--;
			}
		}
		return;
	}

	/** 26. Sleep Sort – The King of Laziness / Sorting while Sleeping **/
	@Override
	public void sleepSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			Thread thread = new Thread(new SleepsortThread(a[i] * 10));
			thread.start();
		}

	}

	/** 27. Structure Sorting (By Multiple Rules) in C++ **/
	@Override
	public void structureSort(Student a[]) {
		int n = a.length;
		// To calculate total marks for all Students
		for (int i = 0; i < n; i++)
			a[i].total = a[i].math + a[i].phy + a[i].che;

		List<Student> list = new ArrayList<>();
		for (int i = 0; i < n; list.add(a[i]), i++)
			;
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student a, Student b) {
				// returns true for higher total
				if (a.total != b.total)
					return a.total - b.total;

				// If marks in Maths are not same then
				// returns true for higher marks
				if (a.math != b.math)
					return a.math - b.math;

				return (a.phy - b.phy);
			}
		});

		// Assigning ranks after sorting
		for (int i = 0; i < n; i++)
			a[i].rank = i + 1;
	}

	/** 28. Stooge Sort **/
	public void stoogeSort(int arr[], int l, int h) {
		if (l >= h)
			return;

		// If first element is smaller than last,
		// swap them
		if (arr[l] > arr[h])
			AlgoUtils.swap(arr, l, h);

		// If there are more than 2 elements in
		// the array
		if (h - l + 1 > 2) {
			int t = (h - l + 1) / 3;

			// Recursively sort first 2/3 elements
			stoogeSort(arr, l, h - t);

			// Recursively sort last 2/3 elements
			stoogeSort(arr, l + t, h);

			// Recursively sort first 2/3 elements
			// again to confirm
			stoogeSort(arr, l, h - t);
		}
	}

	/** 29. Tag Sort (To get both sorted and original) **/
	public void tagSort(Person persons[], int tag[]) {
		int n = persons.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (persons[tag[i]].getSalary() > persons[tag[j]].getSalary()) {
					// Note we are not sorting the
					// actual Persons array, but only
					// the tag array
					int temp = tag[i];
					tag[i] = tag[j];
					tag[j] = temp;
				}
			}
		}
	}

	/** 30. Tree Sort **/
	/** create tree and print data in inorder traverse */

	/** 31. Cartesian Tree Sorting **/

	/** 32. Odd-Even Sort / Brick Sort **/
	public void oddEvenSort(int arr[]) {
		boolean isSorted = false; // Initially array is unsorted
		int n = arr.length;

		while (!isSorted) {
			isSorted = true;
			int temp = 0;

			// Perform Bubble sort on odd indexed element
			for (int i = 1; i <= n - 2; i = i + 2) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}

			// Perform Bubble sort on even indexed element
			for (int i = 0; i <= n - 2; i = i + 2) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}
			}
		}

		return;
	}

	/**********************************************************************************************************************************************************************/
	/** Sleep Sort use this class **/
	class SleepsortThread implements Runnable {
		private int val;

		public SleepsortThread(int val) {
			this.val = val;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(val);
				System.out.println(val);
			} catch (InterruptedException e) {
				// Oops...
			}
		}
	}

	/** swap two element of array **/
	@Override
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/** min element in a array **/
	@Override
	public int min(int a[]) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min > a[i])
				min = a[i];
		}
		return min;
	}

	/** max element in a array **/
	@Override
	public int max(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

}
