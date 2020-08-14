package com.design.analysis.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.design.analysis.algo.sorting.ISortingAlgo;
import com.design.analysis.algo.sorting.SortingAlgoImpl;
import com.design.analysis.algo.utils.AlgoUtils;

public class ArraySortImpl implements IArraySort {

	public ISortingAlgo isa = new SortingAlgoImpl();

	/** 1. Alternative Sorting **/
	@Override
	public void alternativeSorting(int a[]) {

		AlgoUtils.sortByN(a);
		int b[] = new int[a.length];
		int i = 0;
		int j = a.length - 1;
		int k = 0;

		while (i < j) {
			b[k++] = a[j];
			b[k++] = a[i];
			i++;
			j--;
			if (i == j) // for odd no of array
				b[k] = a[i];
		}
		// copying the result
		for (i = 0; i < a.length; i++)
			a[i] = b[i];
	}

	/** 2. Sort a nearly sorted (or K sorted) array **/
	@Override
	public void sortNearlySorted(int a[]) {
		// insertion sort or heap sort is useful here
		isa.maxHeapSort(a);
	}

	/** 3. Sort an array according to absolute difference with given value **/
	@Override
	public void sortByAbsDiffGivenValue(int a[], int x) {

		TreeMap<Integer, List<Integer>> multiMap = new TreeMap<>();
		List<Integer> list = null;
		int i = 0;
		for (; i < a.length; i++) {
			int abs = Math.abs(a[i] - x);
			if (multiMap.get(abs) == null) {
				list = new ArrayList<>();
				list.add(a[i]);
				multiMap.put(abs, list);
			} else {
				list = multiMap.get(abs);
				list.add(a[i]);
				multiMap.put(abs, list);
			}
		}

		i = 0;
		for (Map.Entry<Integer, List<Integer>> map : multiMap.entrySet()) {
			for (Integer inte : map.getValue())
				a[i++] = inte;
		}
	}

	public void sortByAbsDiffGivenValueX(int a[], int x) {
		if (a == null || a.length == 0 || a.length == 1)

			return;
		else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					if (Math.abs(a[j] - x) > Math.abs(a[j + 1] - x)) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
					}
				}
			}
		}
	}

	/** 4. Sort an array in wave form **/
	@Override
	public void sortInWaveForm(int a[]) {
		AlgoUtils.sortByN(a);
		for (int i = 0; i < a.length - 1; i += 2)
			AlgoUtils.swap(a, i, i + 1);
	}

	/** 5. Merge an array of size n into another array of size m+n **/
	@Override
	public void meargeNArrToMNArr(int mnArr[], int nArr[]) {

		int j = mnArr.length - 1;

		for (int i = mnArr.length - 1; i >= 0; i--) {
			if (mnArr[i] != 0) {
				mnArr[j] = mnArr[i];
				mnArr[i] = 0;
				j--;
			}
		}

		/* j+1 at mnArr value start */
		j = j + 1;
		int m = 0;
		int k = 0;
		while (k < mnArr.length) {

			if (j == mnArr.length || m == nArr.length)
				break;

			if (nArr[m] < mnArr[j]) {
				mnArr[k] = nArr[m];
				m++;
			} else {
				mnArr[k] = mnArr[j];
				j++;
			}
			k++;
		}
		/* when nArr end copy pest the rest of mnArr */
		while (j < mnArr.length && k < mnArr.length)
			mnArr[k++] = mnArr[j++];

		/* when mnArr end copy pest the rest of nArr */
		while (m < nArr.length && k < mnArr.length)
			mnArr[k++] = nArr[m++];
	}

	@Override
	public void meargeNArrToMNArrX(int mnArr[], int nArr[]) {

		int k = 0;
		for (int i = 0; i < mnArr.length; i++) {
			if (mnArr[i] == 0)
				mnArr[i] = nArr[k++];
		}
		AlgoUtils.sortByN(mnArr);
	}

	/** 6. Sort an array which contain 1 to n values **/
	// swap function
	public int swap(int itself, int dummy) {
		return itself;
	}

	@Override
	public void sortNaturalNo(int a[]) {
		for (int i = 0; i < a.length; i++) {
			while (i != (a[i] - 1)) {
				a[i] = swap(a[a[i] - 1], a[a[i] - 1] = a[i]);
			}
		}
	}

	/** 7. Sort 1 to N by swapping adjacent elements **/
	public boolean sort1ToNBySwapAdjacent(int a[], boolean b[]) {

		int n = a.length;
		int i, j;

		// Check bool array b and sorts
		// elements for continuos sequnce of 1
		for (i = 0; i < n - 1; i++) {
			if (b[i]) {
				j = i;
				while (b[j]) {
					j++;
				}
				// Sort array A from i to j
				Arrays.sort(a, i, 1 + j);
				i = j;
			}
		}

		// Check if array is sorted or not
		for (i = 0; i < n; i++) {
			if (a[i] != i + 1) {
				return false;
			}
		}

		return true;
	}

	/** 8. Sort an array containing two types of elements **/
	public void sort0And1(int a[]) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] == 0)
				i++;
			if (a[j] == 1)
				j--;
			if (a[i] == 1 && a[j] == 0) {
				AlgoUtils.swap(a, i, j);
				i++;
				j--;
			}
		}
	}

	@Override
	public void sortByfriquency(int a[]) {

		if (a == null || a.length == 0 || a.length == 1)
			return;
		int max = a[0];
		int k = 0;
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}

		int b[] = new int[max + 1];
		for (int i = 0; i < a.length; i++)
			b[a[i]]++;

		max = b[0];
		for (int i = 1; i < b.length; i++) {
			if (max < b[i])
				max = b[i];
		}

		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < b.length; j++) {
				if (i == b[j]) {
					for (int l = 0; l < i; l++)
						a[k++] = j;
				}
			}
		}
	}

	/** 10. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	/// @See @IStandardAlgo.java 9.
	/** 11. Two elements whose sum is closest to zero **/
	public int[] sumCloseToZero(int a[]) {
		// combination of max,min +ve/-ve
		int rs[] = new int[2];
		Arrays.sort(a);
		if (a[0] > 0) // ie all no are +ve
		{
			rs[0] = a[0];
			rs[1] = a[1];
			return rs;
		}

		int i = 0;
		int j = a.length;
		while (i < j && a[i] < 0)
			i++;

		// min -ve and max +ve combination
		int min = Math.abs(a[0] + a[a.length - 1]);
		rs[0] = a[0];
		rs[1] = a[a.length - 1];
		// max -ve and min +ve combination
		if (Math.abs(a[i - 1] + a[i]) < min) {
			min = a[i - 1] + a[i];
			rs[0] = a[i - 1];
			rs[1] = a[i];
		}
		// min -ve and min +ve combination
		if (Math.abs(a[0] + a[i]) < min) {
			rs[0] = a[0];
			rs[1] = a[i];
		}
		// max -ve and max +ve combination
		if (Math.abs(a[i - 1] + a[a.length - 1]) < min) {
			rs[0] = a[i - 1];
			rs[1] = a[a.length - 1];
		}
		return rs;
	}

	/** 12. Shortest Un-ordered Subarray **/
	@Override
	public int unOrderedLen(int a[]) {

		int n = a.length;
		int b[] = new int[n];
		for (int i = 0; i < n; i++)
			b[i] = a[i];

		Arrays.sort(b);
		int i = 0;
		int j = a.length - 1;

		for (; i < n; i++) {
			if (a[i] != b[i])
				break;

		}
		for (; j >= 0; j--) {
			if (a[j] != b[j])
				break;
		}
		return j - i + 1;
	}

	public int minSwapForSortX(int a[]) {
		int count = 0;
		int i = 0;
		int n = a.length;
		int b[] = new int[n];
		for (i = 0; i < n; i++)
			b[i] = a[i];

		Arrays.sort(b);
		i = 0;

		for (; i < n; i++) {
			if (a[i] != b[i])
				break;

		}
		i = 0;
		while (i < n) {
			if (a[i] != b[i])
				count++;
		}
		return count;
	}

	/** 13. Minimum number of swaps required to sort an array **/
	@Override
	public int minSwapForSort(int a[]) {
		return 0;
	}
}
