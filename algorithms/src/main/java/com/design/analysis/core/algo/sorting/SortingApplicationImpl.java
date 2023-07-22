package com.design.analysis.core.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.core.algo.node.BTNode;
import com.design.analysis.core.algo.sorting.model.Element;
import com.design.analysis.core.algo.utils.AlgoUtils;
import com.design.analysis.utils.ArraysUtil;

public class SortingApplicationImpl implements ISortingApplication {

	/**
	 * 1. Sort elements by frequency | Set 1 if equal free then first come first
	 * occur
	 **/
	public int[] sortByFrequency(int a[]) {

		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}
		List<Element> list = new ArrayList<>();
		int j = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			list.add(new Element(entry.getKey(), entry.getValue()));
		Collections.sort(list);
		for (Element elm : list) {
			for (int i = 0; i < elm.count; i++)
				a[j++] = elm.ele;
		}
		return a;
	}

	// without using inbuilt library
	public int[] sortByFrequencyX(int a[]) {
		int b[] = ArraysUtil.getIndexedVal(a);
		String c[] = new String[AlgoUtils.max(b) + 1];

		for (int i = 0; i < b.length; i++) {
			if (b[i] != 0) {
				if (c[b[i]] == null)
					c[b[i]] = new String(i + "");
				else
					c[b[i]] = c[b[i]] + i;
			}
		}
		int k = 0;
		for (int i = c.length - 1; i > 0; i--) {
			if (c[i] != null) {
				char ch[] = c[i].toCharArray();
				for (int j = 0; j < ch.length; j++) {
					for (int x = 0; x < i; x++) {
						a[k++] = ch[j] - 48;
					}
				}
			}
		}
		return a;
	}

	@Override
	public int[] sortByFrequencyMaxToMin(int a[]) {
		int b[] = ArraysUtil.getIndexedVal(a);
		int bMax = AlgoUtils.max(b);
		int k = 0;
		for (int i = bMax; i > 0; i--) {
			// serching the max count in b at on the index js
			for (int j = 0; j < b.length; j++) {
				if (i == b[j]) {
					for (int t = 0; t < i; a[k++] = j, t++)
						;
				}
			}
		}
		return a;
	}

	@Override
	public int[] sortByFrequencyMinToMax(int a[]) {
        int b[] = ArraysUtil.getIndexedVal(a);
		int bMax = AlgoUtils.max(b);
		int k = 0;
		for (int i = 1; i <= bMax; i++) {
			// serching the min count in b at on the index js
			for (int j = 0; j < b.length; j++) {
				if (i == b[j]) {
					for (int t = 0; t < i; a[k++] = j, t++)
						;
				}
			}
		}
		return a;
	}

	/** 2. Sort elements by frequency | Set 2 **/
	@Override
	public BTNode create(BTNode node, int frq, String dt) {
		BTNode temp = new BTNode(frq, dt);
		if (node == null)
			node = temp;
		else if (node.frq == frq) {
			node.dt += dt;
			;
		} else if (frq < node.frq)
			node.lt = create(node.lt, frq, dt);
		else
			node.rt = create(node.rt, frq, dt);
		return node;
	}

	int b[] = null;
	int j = 0;

	@Override
	public void revInorderTravel(BTNode node, int b[]) {

		if (node != null) {
			revInorderTravel(node.rt, b);

			for (char ch : node.dt.toCharArray()) {
				for (int i = 1; i <= node.frq; i++) {
					b[j++] = ch - 48;
				}
			}
			revInorderTravel(node.lt, b);
		}
	}

	@Override
	public int[] sortByFrequencyBst(int a[]) {
		int b[] = ArraysUtil.getIndexedVal(a);
		BTNode node = null;
		for (int i = 0; i < b.length; i++) {
			if (b[i] != 0)
				node = create(node, b[i], i + "");
		}
		b = new int[a.length];
		revInorderTravel(node, b);
		return b;
	}

	/** 3. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	@Override
	public int countInversion(int arr[]) {
		int n = arr.length;
		int inv_count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (arr[i] > arr[j])
					inv_count++;

		return inv_count;
	}

	/** 4. Sort an array of 0s, 1s and 2s **/
	// O(1.5n)
	public int[] sortThreeElementX(int a[]) {

		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] == 0)
				i++;
			if (a[j] != 0)
				j--;
			if (a[i] != 0 && a[j] == 0) {
				AlgoUtils.swap(a, i, j);
				i++;
				j--;
			}
		}
		j = a.length - 1;
		while (i < j) {
			if (a[i] == 1)
				i++;
			if (a[j] != 1)
				j--;
			if (a[i] != 1 && a[j] == 1) {
				AlgoUtils.swap(a, i, j);
				i++;
				j--;
			}
		}
		return a;
	}

	@Override // O(n)
	public int[] sortThreeElementY(int a[]) {
		int l, mid, h;
		l = mid = 0;
		h = a.length - 1;

		while (mid <= h) {
			switch (a[mid]) {
			case 0:
				AlgoUtils.swap(a, l, mid);
				l++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				AlgoUtils.swap(a, mid, h);
				h--;
				break;
			}
		}
		return a;
	}

	// O(n)
	public int[] sortThreeElementZ(int a[]) {

		int b[] = new int[3];
		for (int i = 0; i < a.length; b[a[i]]++, i++)
			;
		int k = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i]; a[k++] = i, j++)
				;
		}
		return a;
	}

	// O(n)
	public int[] sortNPerfectNumber(int a[], int n) {
		int b[] = new int[n + 1];
		for (int i = 0; i < a.length; b[a[i]]++, i++)
			;
		int k = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i]; a[k++] = i, j++)
				;
		}
		return a;
	}

	/**
	 * 5. Find the Minimum length Unsorted Subarray, sorting which makes the
	 * complete array sorted
	 **/
	@Override
	public int[] unsortedSubArrayLen(int a[]) {

		int rs[] = new int[2];
		int i, j, min, max;
		for (i = 0; i < a.length; i++)
			if (a[i] > a[i + 1])
				break;
		for (j = a.length - 1; j >= 0; j--)
			if (a[j - 1] > a[j])
				break;

		min = max = a[i];
		for (int k = i + 1; k <= j; k++) {
			if (min > a[i])
				min = a[i];
			if (max < a[i])
				max = a[i];
		}

		for (int s = 0; s < i; s++) {
			if (a[s] > min) {
				i = s;
				break;
			}
		}
		for (int s = a.length - 1; s >= j + 1; s--) {
			if (a[s] < max) {
				j = s;
				break;
			}
		}
		rs[0] = i;
		rs[1] = j;
		return rs;
	}

	// O(nLog(n))
	public int[] unsortedSubArrayLenX(int a[]) {
		int i, j;
		int rs[] = new int[2];
		int b[] = new int[a.length];
		for (i = 0; i < a.length; b[i] = a[i], i++)
			;
		sortNPerfectNumber(a, AlgoUtils.max(a));
		for (i = 0; i < a.length; i++)
			if (a[i] != b[i])
				break;
		for (j = a.length - 1; j >= 0; j--)
			if (a[j] != b[j])
				break;
		rs[0] = i;
		rs[1] = j;
		return rs;
	}
	
	/** 6. Find whether an array is subset of another array | Added Method 3 **/
	@Override
	public boolean isSubsetArrInOtherArray(int a[], int b[]) {

		// O(mn) by lenear search
		Arrays.sort(a); // n(log(n))

		for (int i = 0; i < b.length; i++) {
			if (AlgoUtils.binarySearch(a, 0, a.length - 1, b[i]) == -1) {
				return false;
			}
		}
		return true;
	}

	/** 7. Sort a nearly sorted (or K sorted) array **/
	/* use heap sortO(k+(n-k)logk) or insetion sort O(nk) */
	/** 8. Sort numbers stored on different machines **/
	/* this is heap-link list problem added to heap lession-data structure */
	/** 9. Sort a linked list of 0s, 1s and 2s **/
	/* @ ISLinkList.java @ point 98....program */
	/** 10. A Pancake Sorting Problem **/

	/* @see ISortingAlgo.java ...point 21. Pancake Sorting */
	/** 11. Find number of pairs (x, y) in an array such that x^y > y^x **/
	public int count(int x, int y[], int n, int nofY[]) {

		if (x == 0)
			return 0;
		if (x == 1)
			return nofY[0];
		return 0;

	}

	public int noOfPair(int x[], int y[], int m, int n) {
		return 0;
	}
}
