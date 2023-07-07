package com.design.analysis.core.algo.sorting;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.algo.utils.AlgoUtils;

public class SortingUtils {

	public static List<Integer> mergeSortedList(List<Integer> l1, List<Integer> l2) {
		if (l1 == null || l1.isEmpty())
			return l2;
		if (l2 == null || l2.isEmpty())
			return l1;

		int i, j;
		i = j = 0;
		List<Integer> rs = new ArrayList<>();
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) <= l2.get(j))
				rs.add(l1.get(i++));
			else
				rs.add(l2.get(j++));
		}
		while (i < l1.size())
			rs.add(l1.get(i++));
		while (j < l2.size())
			rs.add(l2.get(j++));
		l1 = l2 = null;
		return rs;
	}

	public static void arrangeNeZeroPos(int a[]) {
		int l, mid, h;
		l = mid = 0;
		h = a.length - 1;

		while (mid <= h) {
			if (a[mid] < 0) {
				AlgoUtils.swap(a, l, mid);
				l++;
				mid++;
			} else if (a[mid] > 0) {
				AlgoUtils.swap(a, mid, h);
				h--;
			} else {
				mid++;
			}
		}
		System.out.println("done");
	}

	public void maxHeapSort(int a[], int b[]) {

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

	public static void maxHeapSort1(int a[], int b[]) {

		int M = a.length;
		int N = b.length;
		int L = M + N;
		for (int i = L / 2 - 1; i >= 0; i--) // build head so max is at 0
			maxHeapify(a, b, L, i);

		// swap the 0 to end and hipify the rest
		for (int i = L - 1; i >= 0; i--) {
			int temp;
			if (i < M) {
				temp = a[0];
				a[0] = a[i];
				a[i] = temp;
			} else {
				temp = a[0];
				a[0] = b[i - M];
				b[i - M] = temp;
			}
			maxHeapify(a, b, i, 0);
		}
	}

	//TODO
	public static void maxHeapify(int a[], int b[], int L, int i) {

		int lar = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int M = a.length;
		int N = b.length;
		//int curElm = i < M ? a[i] : b[i - M];

		if (l < M) {
			if (r < M) {
				if (a[l] > a[lar])
					lar = l;
				if (a[r] > a[lar])
					lar = r;
			} else {
				if (a[l] > b[r-M])
					lar = l;
				if (r - M < N && b[r - M] > a[lar])
					lar = r - M;
			}
		} else {
			if(lar<M)
			{
				if (l - M < N && b[l - M] > a[lar])
					lar = l - M;
				if (r - M < N && b[r - M] > b[lar])
					lar = r - M;
			}
			else
			{
				if (l - M < N && b[l - M] > b[lar-M])
					lar = l - M;
				if (r - M < N && b[r - M] > b[lar])
					lar = r - M;
			}
		}

		int swap;
		if (lar != i) {
			if (i < M) {
				if (lar < M) {
					swap = a[i];
					a[i] = a[lar];
					a[lar] = swap;

				} else {
					swap = a[i];
					a[i] = b[lar - M];
					b[lar - M] = swap;
				}
			} else {
					swap = b[i - M];
					b[i - M] = b[lar - M];
					b[lar - M] = swap;
			}
			maxHeapify(a, b, L, lar);
		}
	}

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

	public static void sortTwoArrayTogether(int a[], int b[]) {
		int M = a.length;
		int N = b.length;
		int L = M + N;

		for (int i = 0; i < L; i++) {
			for (int j = i + 1; j < L; j++) {
				if (i < M) {
					if (j < M) {
						if (a[i] > a[j]) {
							int temp = a[i];
							a[i] = a[j];
							a[j] = temp;
						}
					} else {
						if (a[i] > b[j - M]) {
							int temp = a[i];
							a[i] = b[j - M];
							b[j - M] = temp;
						}
					}
				} else {
					if (j < M) {
						if (b[i - M] > a[j]) {
							int temp = b[M - i];
							b[i - M] = a[j];
							a[j] = temp;
						}
					} else {
						if (b[i - M] > b[j - M]) {
							int temp = b[i - M];
							b[i - M] = b[j - M];
							b[j - M] = temp;
						}
					}
				}
			}
		}
	}
}
