package com.design.analysis.algo.searching;

import com.design.analysis.algo.node.SLNode;

/*
 * Searching Algorithms :
1.	Linear Search
2.	Binary Search
3.	Jump Search
4.	Interpolation Search
5.	Exponential Search
6.	Sublist Search (Search a linked list in another list)
7.	Fibonacci Search
8.	The Ubiquitous Binary Search
9.	Recursive program to linearly search an element in a given array
10.	Recursive function to do substring search
11.	Unbounded Binary Search Example (Find the point where a monotonically increasing function becomes positive first time)

 */
public class SearchingAlgoImpl implements ISearchingAlgo {

	/** 1. Linear Search **/
	@Override
	public Integer linearSearch(int a[], int x) {

		if (a == null || a.length == 0)
			return null;
		int j = a.length - 1;
		for (int i = 0; i <= j; i++, j--) {
			if (a[i] == x)
				return i;

			if (a[j] == x)
				return j;
		}
		return null;
	}

	/**
	 * 2. Binary Search l=start index, and e end index. Note: Binary search can be
	 * apply on sorted array only
	 **/

	public Integer binarySearch(int a[], int l, int e, int x) {

		if (a == null || a.length == 0 || x < a[l] || a[e] < x)
			return null;
		if (a[l] == x)
			return l;
		if (a[e] == x)
			return e;

		int mid = l + (e - l) / 2;
		if (l < e) {
			if (a[mid] == x)
				return mid;
			else if (x < a[mid])
				return binarySearch(a, l, mid, x);
			else
				return binarySearch(a, mid + 1, e, x);
		}
		return null;
	}

	/**
	 * 3. Jump Search Note: Jump search can be apply on sorted array only
	 **/
	@Override
	public Integer jumpSearch(int a[], int x) {

		if (a == null || a.length == 0 || x < a[0] || a[a.length - 1] < x)
			return null;
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
			for (int j = i; j <= i + step && j < a.length; j++) {
				if (a[j] == x)
					return j;
			}
		}
		return null;
	}

	/**
	 * 4. Interpolation Search : Note this sort can be apply on sorted array only
	 **/
	@Override
	public Integer interpolationSearch(int a[], int x) {

		if (a == null || a.length == 0 || x < a[0] || a[a.length - 1] < x)
			return null;
		if (a[0] == x)
			return 0;
		if (a[a.length - 1] == x)
			return a.length - 1;

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
		return null;
	}

	/**
	 * 5. Exponential Search : Note this sort can be apply on sorted array only
	 **/
	@Override
	public Integer exponentialSearch(int a[], int x) {
		if (a == null || a.length == 0 || x < a[0] || a[a.length - 1] < x)
			return null;

		if (a[0] == x)
			return 0;
		if (a[a.length - 1] == x)
			return a.length - 1;

		int i = 1;
		while (i < a.length && a[i] <= x)
			i *= 2;
		return binarySearch(a, i / 2, Math.min(i, a.length - 1), x);
	}

	/** 6. Sublist Search (Search a linked list in another list) **/

	/** link list creation **/
	@Override
	public SLNode createLinkList(SLNode node, int dt) {

		if (node == null)
			return new SLNode(dt);
		else if (node.next == null) {
			node.next = new SLNode(dt);
		} else
			createLinkList(node.next, dt);
		return node;
	}

	/** print list **/
	@Override
	public void printSingleLinkList(SLNode node) {
		if (node != null) {
			System.out.print(node.dt + "->");
			printSingleLinkList(node.next);
		}
	}

	@Override
	public boolean subListInListSearch(SLNode list, SLNode subList) {

		if (list == null || subList == null)
			return false;

		SLNode sbHead = subList;
		SLNode lHead = list;
		for (; lHead != null; lHead = lHead.next) {
			if (sbHead.dt == lHead.dt) {
				for (; sbHead != null && lHead != null; sbHead = sbHead.next, lHead = lHead.next) {
					if (lHead.dt != sbHead.dt)
						break;
				}
				if (sbHead == null)
					return true;
			}
		}
		return false;
	}

	/**
	 * 7. Fibonacci Search Note: This sort is applicable for sorted array only
	 **/
	@Override
	public Integer fibonacciSearch(int a[], int x) {

		if (a == null || a.length == 0 || x < a[0] || a[a.length - 1] < x)
			return null;
		if (x == a[0])
			return 0;
		if (a[a.length - 1] == x)
			return a.length - 1;

		int n = a.length;

		int n1 = 0;
		int n2 = 1;
		int n3 = n1 + n2;
		while (n3 < n) {
			n1 = n2;
			n2 = n3;
			n3 = n1 + n2;
		}

		if (a[n2] < x && x <= a[n - 1])
			return binarySearch(a, n2, n - 1, x);
		else {
			while (!(a[n1] < x && x <= a[n2])) {
				n1 = n2 - n1;
				n2 = n3 - n2;
				n3 = n1 + n2;
			}
			return binarySearch(a, n1, n2, x);
		}
	}

	/**
	 * 8. The Ubiquitous Binary Search : Here array is sorted and element may be
	 * duplicate
	 **/
	public int getRightPosition(int a[], int l, int r, int x) {

		int m;
		while (r - l > 1) {
			m = l + (r - l) / 2;
			if (a[m] <= x)
				l = m;
			else
				r = m;
		}
		return l;
	}

	// simplw ways
	public int getRightPositionX(int a[], int l, int r, int x) {

		int i = binarySearch(a, l, r, x);
		while (a[i] == x)
			i++;
		return i - 1;
	}

	public int getLeftPosition(int a[], int l, int r, int x) {
		int m;
		while (r - l > 1) {
			m = l + (r - l) / 2;
			if (a[m] >= x)
				r = m;
			else
				l = m;

		}
		return r;
	}

	// simplw ways
	public int getLeftPositionX(int a[], int l, int r, int x) {
		int i = binarySearch(a, l, r, x);
		while (a[i] == x)
			i--;
		return i + 1;
	}

	public Integer ubiquitousBinarySearch(int a[], int x) {
		int left = getLeftPosition(a, 0, a.length - 1, x);
		int right = getRightPosition(a, 0, a.length - 1, x);

		return (a[left] == x && x == a[right]) ? (right - left + 1) : null;
	}

	/** 12.binary search for first occuracne if multiple value exists **/
	@Override
	public int binarySearchFirstOccurance(int a[], int l, int h, int x) {

		if (l <= h) {
			int mid = l + (h - l) / 2;

			if ((mid == 0 || x > a[mid - 1]) && (x == a[mid]))
				return mid;
			else if (x > a[mid])
				return binarySearchFirstOccurance(a, mid + 1, h, x);
			else
				return binarySearchFirstOccurance(a, l, mid - 1, x);
		}
		return -1;
	}

	/** 13.binary search for last occurance if multiple value exists **/
	@Override
	public int binarySearchLastOccurance(int a[], int l, int h, int x) {

		if (l <= h) {
			int mid = l + (h - l) / 2;

			if ((mid == a.length - 1 || x < a[mid + 1]) && (x == a[mid])) {
				return mid;
			} else if (x < a[mid])
				return binarySearchLastOccurance(a, l, mid - 1, x);
			else
				return binarySearchLastOccurance(a, mid + 1, h, x);
		}
		return -1;
	}
}
