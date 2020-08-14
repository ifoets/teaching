package com.design.analysis.algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.design.analysis.algo.array.model.AbsSmallDiff;
import com.design.analysis.algo.array.model.ElemFreq;
import com.design.analysis.algo.array.model.SmallestSum;
import com.design.analysis.algo.array.node.HeapNode;

public class OrderStatisticsImpl implements IOrderStatistics {

	/** 1. K’th Smallest/Largest Element in Unsorted Array | Set 1 **/
	/**
	 * 2. K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	/**
	 * 3. K’th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear
	 * Time)
	 **/
	/** 4. K’th Smallest/Largest Element using STL **/

	/*
	 * 1 to 4 is used for unique positive element only* writing method O(n) both
	 * space and time for all elemement type(+ve/-ve ,0 and duplicate)excepet
	 * biggest element should not be much high than lenght
	 */
	@Override
	public int kthHeigstOrSmallest(int a[], int k, boolean isMinOrMax) {

		int b[] = null;
		int x = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], 1 + map.get(a[i]));
			else
				map.put(a[i], 1);
		}
		b = new int[map.size()];
		for (Map.Entry<Integer, Integer> m : map.entrySet())
			b[x++] = m.getKey();

		return isMinOrMax ? b[k - 1] : b[b.length - k];
	}

	@Override
	public int kthHeigstOrSmallestX(int a[], int k, boolean isMinOrMax) {

		int n = a.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			if (max < a[i])
				max = a[i];
		int b[][] = new int[max + 1][2];
		// set b[0][0]=-1
		b[0][0] = -1; // science default is 0
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (a[i] == 0)
				b[0][0]++;
			else if (a[i] > 0)
				b[a[i]][0]++;
			else
				b[Math.abs(a[i])][1]++;
		}
		int m = b.length;

		for (int i = m - 1; i >= 0; i--)
			if (b[i][1] != 0)
				l.add(-i);
		// add 0 zero if it exists
		if (b[0][0] != -1)
			l.add(0);

		for (int i = 0; i < m; i++)
			if (b[i][0] != 0)
				l.add(i);

		return isMinOrMax ? l.get(k - 1) : l.get(l.size() - k);
	}

	/*******************************************************************************************************************************************************/

	/**
	 * .5 k largest(or smallest) elements in an array | added Min Heap method O(n)
	 **/// may be dupliate element present
	@Override
	public List<Integer> kLargestSmallest(int a[], int k, boolean isLargest) {

		List<Integer> list = null;
		Set<Integer> set = new HashSet<>();
		int i;
		for (i = 0; i < a.length; i++)
			set.add(a[i]);
		int b[] = new int[set.size()];
		// remove duplicate element
		list = new ArrayList<>(set);
		i = 0;
		for (Integer in : list)
			b[i++] = in;

		// collect first k largest or smallest O(k*n)
		for (i = 0; i < k; i++) {
			for (int j = i + 1; j < b.length; j++) {
				if (isLargest) {
					if (b[i] < b[j]) {
						int temp = b[i];
						b[i] = b[j];
						b[j] = temp;
					}
				} else {
					if (b[i] > b[j]) {
						int temp = b[i];
						b[i] = b[j];
						b[j] = temp;
					}
				}
			}
		}
		list = new ArrayList<>();
		for (i = 0; i < k; i++)
			list.add(b[i]);
		return list;
	}

	/**
	 * 6. Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1
	 **/
	@Override
	public int kthSmallestRowAndCom(int mat[][], int n, int k) {
		// k must be greater than 0 and smaller than n*n
		if (k <= 0 || k > n * n)
			return Integer.MAX_VALUE;

		// Create a min heap of elements from first row of 2D array
		HeapNode harr[] = new HeapNode[n];
		for (int i = 0; i < n; i++)
			harr[i] = new HeapNode(mat[0][i], 0, i);
		ArrayUtil.buildHeap(harr, n);

		HeapNode hr = null;
		for (int i = 0; i < k - 1; i++) {
			// Get current heap root
			hr = harr[0];

			// Get next value from column of root's value. If the
			// value stored at root was last value in its column,
			// then assign INFINITE as next value
			int nextval = (hr.r < (n - 1)) ? mat[hr.r + 1][hr.c] : Integer.MAX_VALUE;

			// Update heap root with next value
			harr[0].val = nextval;
			harr[0].r = hr.r + 1;
			harr[0].c = hr.c;

			// Heapify root
			ArrayUtil.minHeapify(harr, 0, n);
		}

		// Return the value at last extracted root
		return hr.val;
	}

	// element are unique
	public int kthSmallestRowAndComX(int mat[][], int n, int k) {
		// first row wise or first columan wise
		int x = 0;
		int y = 0;
		if (mat[0][1] > mat[1][0]) {
			x = k / n;
			y = k % n;
			return y == 0 ? mat[n - 1][x - 1] : mat[y - 1][x];
		} else {
			x = k / n;
			y = k % n;
			return y == 0 ? mat[x - 1][n - 1] : mat[x][y - 1];
		}
	}

	/** 7. Program to find largest element in an array of unique values **/
	public int kthMaxElement(int a[], int k) {

		for (int i = 0; i < k; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[k - 1];
	}

	// it is valid for any nos duplicate and -ve
	public int kthMaxElementAnyNos(int a[], int k) {
		int n = a.length;
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max < Math.abs(a[i]))
				max = Math.abs(a[i]);
		}
		int b[][] = new int[max + 1][2];
		b[0][0] = -1;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0)
				b[0][0]++;
			else if (a[i] > 0)
				b[a[i]][0]++;
			else
				b[Math.abs(a[i])][1]++;
		}
		int c[] = new int[max + 1];
		int x = 0;
		for (int i = b.length-1; i >0 ; i--) {
			if (b[i][1] != 0)
				c[x++] = -i;
		}
		if (b[0][0] != -1)
			c[x++] = 0;
		for (int i = 1; i <b.length ; i++) {
			if (b[i][0] != 0)
				c[x++] = i;
		}
		return c[k - 1];
	}

	/** 4. K’th Smallest/Largest Element in Unsorted Array | Set 1 **/
	/**
	 * 5. K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	/**
	 * 6. K’th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear
	 * Time)
	 **/
	/** 7. Find the largest three elements in an array **/
	/** from 4 to 7 come under 1. these are same **/

	/** 8. Find all elements in array which have at-least two greater elements **/
	public List<Integer> allElemAtleathave2Greter(int a[], boolean is2Greater) {
		List<Integer> list = null;
		Set<Integer> set = new HashSet<>();
		int i;
		for (i = 0; i < a.length; i++)
			set.add(a[i]);
		int b[] = new int[set.size()];
		// remove duplicate element
		list = new ArrayList<>(set);
		i = 0;
		for (Integer in : list)
			b[i++] = in;

		// collect first 2 largest or smallest O(2*n)
		for (i = 0; i < 2; i++) {
			for (int j = i + 1; j < b.length; j++) {
				if (is2Greater) {
					if (b[i] < b[j]) {
						int temp = b[i];
						b[i] = b[j];
						b[j] = temp;
					}
				} else {
					if (b[i] > b[j]) {
						int temp = b[i];
						b[i] = b[j];
						b[j] = temp;
					}
				}
			}
		}
		list = new ArrayList<>();
		for (i = 2; i < b.length; i++)
			list.add(b[i]);
		return list;
	}

	/** 9. Find k pairs with smallest sums in two arrays **/
	@Override // O(k*k) //element are sorted in both array
	public List<SmallestSum> kSmallestPairSum(int a[], int b[], int k) {

		if (k > a.length * b.length)
			return null;

		List<SmallestSum> list = new ArrayList<>();
		List<SmallestSum> rList = new ArrayList<>();
		for (int i = 0; i < k / 2; i++) {
			for (int j = 0; j < k / 2; j++) {
				list.add(new SmallestSum(a[i], b[j]));
			}
		}
		// O(k/2*k/2log(k/2*k/2))
		Collections.sort(list);
		for (int i = 0; i < k; i++)
			rList.add(list.get(i));
		return rList;
	}

	/**
	 * 10. k-th smallest absolute difference of two elements in an array O(n(n+1)/2)
	 **/
	public int kthSmallestAbsDiff(int a[], int k) {
		List<AbsSmallDiff> absList = new ArrayList<>();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				absList.add(new AbsSmallDiff(a[i], a[j]));
			}
		}
		Collections.sort(absList);
		return absList.get(k - 1).absDiff;
	}

	/** 12. Find k numbers with most occurrences in the given array **/
	public int[] kHiFreqNumber(int a[], int k) {

		List<ElemFreq> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}
		for (Map.Entry<Integer, Integer> set : map.entrySet())
			list.add(new ElemFreq(set.getKey(), set.getValue()));
		Collections.sort(list);

		int b[] = new int[k];
		for (int i = 0; i < k; i++)
			b[i] = list.get(i).ele;
		return b;
	}
}
