package com.design.analysis.ds.advance.segmenttree;

import com.design.analysis.ds.advance.segmenttree.model.MinMaxNode;
import com.design.analysis.ds.utils.DSUtil;

public class SegmentTreeUtil {

	/**
	 * 0.1 create complete binary tree(creazy tree) whose last level will
	 * 1,2,3....by given level input and rest of the inner node will be the product
	 * of their child;
	 **/
	/* l ,r and e the start,end and current position of data filling index */
	public static int[] createCreazyTree(int level)//
	{
		// size of array for given lavel of tree root=1 level
		int N = (int) (Math.pow(2, level) - 1);
		int a[] = new int[N];
		int r = N - 1;
		// filling the last levels stat form 1 to n
		for (int i = r / 2, j = 1; i <= r; a[i] = j++, i++)
			;
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			int lt = 2 * i + 1;
			int rt = 2 * i + 2;
			a[i] = a[lt] * a[rt];
		}
		return a;
	}

	/**
	 * l is level(stat from 1 ie root is at level 1),x ie xth node to yth node
	 * finding the sum
	 **/
	public static int query(int a[], int l, int x, int y) {
		int init = (int) Math.pow(2, l - 1) - 1;
		int sum = 0;
		for (int i = x - 1; i < y; i++)
			sum += a[init + i];
		return sum;
	}

	/* common function of segment tree */
	public static int[] createSegmentTree(int[] s) {

		/* height of segment tree with given input of lenght n */
		int height = (int) Math.ceil((Math.log(s.length) / Math.log(2)));
		/* max size of array that can stroe the sement tree constructed by array of */
		/* lenght n */
		int maxSize = 2 * (int) Math.pow(2, height) - 1;
		int a[] = new int[maxSize];
		return a;
	}

	public static double[] createSegmentTreeDouble(double[] s) {

		/* height of segment tree with given input of lenght n */
		int height = (int) Math.ceil((Math.log(s.length) / Math.log(2)));
		/* max size of array that can stroe the sement tree constructed by array of */
		/* lenght n */
		int maxSize = 2 * (int) Math.pow(2, height) - 1;
		double a[] = new double[maxSize];
		return a;
	}

	public static MinMaxNode[] createSegmentTreeMaxMin(int[] s) {

		/* height of segment tree with given input of lenght n */
		int height = (int) Math.ceil((Math.log(s.length) / Math.log(2)));
		/* max size of array that can stroe the sement tree constructed by array of */
		/* lenght n */
		int maxSize = 2 * (int) Math.pow(2, height) - 1;
		MinMaxNode a[] = new MinMaxNode[maxSize];
		for (int i = 0; i < a.length; i++)
			a[i] = new MinMaxNode(0, 0);
		return a;
	}

	/* this is for construct tree such that root is sum of child node */
	/* l is stat index, r end index and e the current/operated index */
	/* s is the input array and a is the output array */
	public static int constructSegmentTreeUtil(int[] a, int[] s, int l, int r, int e) {

		if (l == r) {
			a[e] = s[l];
			return a[e];
		}
		int mid = l + (r - l) / 2;
		a[e] = constructSegmentTreeUtil(a, s, l, mid, 2 * e + 1)
				+ constructSegmentTreeUtil(a, s, mid + 1, r, 2 * e + 2);
		return a[e];
	}

	/* this is for find the sum between range of query */
	public static int querySumUtil(int[] d, int l, int r, int ql, int qr, int e) {

		if (ql <= l && r <= qr)
			return d[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return 0;
		int mid = l + (r - l) / 2;
		return querySumUtil(d, l, mid, ql, qr, 2 * e + 1) + querySumUtil(d, mid + 1, r, ql, qr, 2 * e + 2);
	}

	/* this is for find the udate value at index i */
	/* i is the index updated and e the current operationl index */

	public static void constructUpdateUtil(int[] d, int l, int r, int i, int diff, int e) {

		if (i < l || i > r)
			return;
		d[e] = d[e] + diff;

		if (l != r) {
			int mid = l + (r - l) / 2;
			constructUpdateUtil(d, l, mid, i, diff, 2 * e + 1);
			constructUpdateUtil(d, mid + 1, r, i, diff, 2 * e + 2);
		}
	}

	/*
	 * it update the particular value in range of ul to ur index, e the current
	 * index of update
	 */
	public static void constructUpdateRangeUtil(int[] t, int l, int r, int ul, int ur, int diff, int e) {

		// out of range
		if (r < l || l > ur || r < ul)
			return;
		// Current node is a leaf node
		if (l == r) {
			t[e] = t[e] + diff;
			return;
		}

		// Add the difference to current node
		int mid = l + (r - l) / 2;
		constructUpdateRangeUtil(t, l, mid, ul, ur, diff, 2 * e + 1);
		constructUpdateRangeUtil(t, mid + 1, r, ul, ur, diff, 2 * e + 2);
		t[e] = t[2 * e + 1] + t[2 * e + 2];
	}

	/* this is for construct tree such that root is smaller child */
	public static int costructMinValueTUtil(int[] a, int[] s, int l, int r, int e) {

		if (l == r) {
			a[e] = s[l];
			return a[e];
		}
		int mid = l + (r - l) / 2;
		a[e] = Math.min(costructMinValueTUtil(a, s, l, mid, 2 * e + 1),
				costructMinValueTUtil(a, s, mid + 1, r, 2 * e + 2));
		return a[e];
	}

	/* this is for find the minimum between range of query */
	public static int queryMinValueUtil(int[] d, int l, int r, int ql, int qr, int e) {
		if (ql <= l && r <= qr)
			return d[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return Integer.MAX_VALUE;
		int mid = l + (r - l) / 2;
		return Math.min(queryMinValueUtil(d, l, mid, ql, qr, 2 * e + 1),
				queryMinValueUtil(d, mid + 1, r, ql, qr, 2 * e + 2));
	}

	/* this is for construct tree such that root is bigger child */
	public static int costructMaxValueTUtil(int[] a, int[] s, int l, int r, int e) {
		if (l == r) {
			a[e] = s[l];
			return a[e];
		}
		int mid = l + (r - l) / 2;
		a[e] = Math.max(costructMaxValueTUtil(a, s, l, mid, 2 * e + 1),
				costructMaxValueTUtil(a, s, mid + 1, r, 2 * e + 2));
		return a[e];
	}

	/* this is for find the maximum between range of query */
	public static int queryMaxValueUtil(int[] d, int l, int r, int ql, int qr, int e) {
		if (ql <= l && r <= qr)
			return d[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return Integer.MIN_VALUE;
		int mid = l + (r - l) / 2;
		return Math.max(queryMaxValueUtil(d, l, mid, ql, qr, 2 * e + 1),
				queryMaxValueUtil(d, mid + 1, r, ql, qr, 2 * e + 2));
	}

	/* this is for construct the average value utils */
	public static double constructAvgValueUtil(double[] a, double[] s, int l, int r, int e) {

		if (l == r) {
			a[e] = s[l];
			return a[e];
		}
		int mid = l + (r - l) / 2;
		a[e] = (constructAvgValueUtil(a, s, l, mid, 2 * e + 1) + constructAvgValueUtil(a, s, mid + 1, r, 2 * e + 2))
				/ 2;
		return a[e];
	}

	/* this is for find the average between range of query */
	// TODO not give correct result always
	public static double queryAvgUtil(double[] d, int l, int r, int ql, int qr, int e) {

		if (ql <= l && r <= qr)
			return d[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return 0;
		int mid = l + (r - l) / 2;
		return (queryAvgUtil(d, l, mid, ql, qr, 2 * e + 1) + queryAvgUtil(d, mid + 1, r, ql, qr, 2 * e + 2));
	}

	/* lazy[0] means corresponging value of t[] is updated other wise lazy update */
	public static void updateLazyRangeUtil(int lazy[], int[] t, int l, int r, int ul, int ur, int e, int diff) {

		// if t[e] is not updated ie pending update
		if (lazy[e] != 0) {
			// Make pending updates using value stored in lazy
			// nodes
			t[e] = t[e] + (l - r + 1) * lazy[e];

			// checking if it is not leaf node
			if (l != r) {
				lazy[e * 2 + 1] = lazy[e * 2 + 1] + lazy[e];
				lazy[e * 2 + 2] = lazy[e * 2 + 2] + lazy[e];
			}
			// update lazy[e] to 0 since it is updated to t[e]
			lazy[e] = 0;
		}

		// out of range
		if (r < l || l > ur || r < ul)
			return;
		// Current segment is fully in range
		if (l >= ul && r <= ur) {
			// Add the difference to current node
			t[e] = t[e] + (r - l + 1) * diff;

			// same logic for checking leaf node or not
			if (l != r) {
				lazy[e * 2 + 1] = lazy[e * 2 + 1] + diff;
				lazy[e * 2 + 2] = lazy[e * 2 + 2] + diff;
			}
			return;
		}
		// Add the difference to current node
		int mid = l + (r - l) / 2;
		updateLazyRangeUtil(lazy, t, l, mid, ul, ur, 2 * e + 1, diff);
		updateLazyRangeUtil(lazy, t, mid + 1, r, ul, ur, 2 * e + 2, diff);
		t[e] = t[2 * e + 1] + t[2 * e + 2];
	}

	/* get sum of updated range utils */
	public static int getLazySum(int lazy[], int[] t, int l, int r, int ql, int qr, int e) {

		// if t[e] is not updated ie pending update
		if (lazy[e] != 0) {
			// Make pending updates using value stored in lazy
			// nodes
			t[e] = t[e] + (r - l + 1) * lazy[e];

			// checking if it is not leaf node
			if (l != r) {
				lazy[e * 2 + 1] = lazy[e * 2 + 1] + lazy[e];
				lazy[e * 2 + 2] = lazy[e * 2 + 2] + lazy[e];
			}
			// update lazy[e] to 0 since it is updated to t[e]
			lazy[e] = 0;
		}

		// out of range
		if (r < l || l > qr || r < ql)
			return 0;

		if (ql <= l && r <= qr)
			return t[e];

		int mid = l + (r - l) / 2;
		return getLazySum(lazy, t, l, mid, ql, qr, 2 * e + 1) + getLazySum(lazy, t, mid + 1, r, ql, qr, 2 * e + 2);
	}

	/* this is for construct the min max value utils */
	public static MinMaxNode constructMinMaxUtil(MinMaxNode[] a, int[] s, int l, int r, int e) {

		if (l == r) {
			a[e].min = s[l];
			a[e].max = s[l];
			return a[e];
		}

		int mid = l + (r - l) / 2;
		constructMinMaxUtil(a, s, l, mid, 2 * e + 1);
		constructMinMaxUtil(a, s, mid + 1, r, 2 * e + 2);
		a[e].min = Math.min(a[e * 2 + 1].min, a[e * 2 + 2].min);
		a[e].max = Math.max(a[e * 2 + 1].max, a[e * 2 + 2].max);
		return a[e];
	}

	/* construct the query for min max in array together */
	public static MinMaxNode queryMinMaxUtil(MinMaxNode[] t, int l, int r, int ql, int qr, int e) {

		MinMaxNode lt, rt;

		if (ql <= l && r <= qr)
			return t[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return new MinMaxNode(Integer.MAX_VALUE, Integer.MIN_VALUE);

		int mid = l + (r - l) / 2;
		lt = queryMinMaxUtil(t, l, mid, ql, qr, 2 * e + 1);
		rt = queryMinMaxUtil(t, mid + 1, r, ql, qr, 2 * e + 2);

		return new MinMaxNode(Math.min(lt.min, rt.min), Math.max(lt.max, rt.max));
	}

	/* this is for construct tree such that root is lcm of its child */
	public static int costructLCMUtil(int[] t, int[] a, int l, int r, int e) {

		if (l == r) {
			t[e] = a[l];
			return t[e];
		}
		int mid = l + (r - l) / 2;
		t[e] = DSUtil.lcm(costructLCMUtil(t, a, l, mid, 2 * e + 1), costructLCMUtil(t, a, mid + 1, r, 2 * e + 2));
		return t[e];
	}

	/* this is for find the lcm range of query */
	public static int queryLCMUtil(int[] t, int l, int r, int ql, int qr, int e) {
		if (ql <= l && r <= qr)
			return t[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return 1;
		int mid = l + (r - l) / 2;
		return DSUtil.lcm(queryLCMUtil(t, l, mid, ql, qr, 2 * e + 1), queryLCMUtil(t, mid + 1, r, ql, qr, 2 * e + 2));
	}

	/* this is for construct tree such that root is lcm of its child */
	public static int costructGCDUtil(int[] t, int[] a, int l, int r, int e) {
		if (l == r) {
			t[e] = a[l];
			return t[e];
		}
		int mid = l + (r - l) / 2;
		t[e] = DSUtil.gcd(costructGCDUtil(t, a, l, mid, 2 * e + 1), costructGCDUtil(t, a, mid + 1, r, 2 * e + 2));
		return t[e];
	}

	/* this is for find the lcm range of query */
	public static int queryGCDUtil(int[] t, int l, int r, int ql, int qr, int e) {
		if (ql <= l && r <= qr)
			return t[e];
		// search range should never start greater then endInde and end never less
		// than startIndex
		if (ql > r || qr < l)
			return 0;
		int mid = l + (r - l) / 2;
		return DSUtil.gcd(queryGCDUtil(t, l, mid, ql, qr, 2 * e + 1), queryGCDUtil(t, mid + 1, r, ql, qr, 2 * e + 2));
	}
}
