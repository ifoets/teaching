package com.design.analysis.core.algo.array;

import com.design.analysis.core.algo.array.node.HeapNode;

public class ArrayUtil {

	// swap in 2Array
	public static void swapIn2Arr(int a[], int x, int b[], int y) {
		int t = a[x];
		a[x] = b[y];
		b[y] = t;
	}

	// swap one dimention array elements
	public static void swapArr(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	// swap two dimention array elements
	public static void swap2DArr(int a[][], int i, int j, int x, int y) {
		int temp = a[i][j];
		a[i][j] = a[x][y];
		a[x][y] = temp;

	}

	// A utility function to convert harr[] to a max heap
	public static void buildHeap(HeapNode harr[], int n) {

		int i = (n - 1) / 2;
		while (i >= 0) {
			minHeapify(harr, i, n);
			i--;
		}
	}

	// A utility function to minheapify the node harr[i] of a heap
	// stored in harr[]
	public static void minHeapify(HeapNode harr[], int i, int heap_size) {
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int smallest = i;
		if (l < heap_size && harr[l].val < harr[i].val)
			smallest = l;
		if (r < heap_size && harr[r].val < harr[smallest].val)
			smallest = r;
		if (smallest != i) {
			swap(harr[i], harr[smallest]);
			minHeapify(harr, smallest, heap_size);
		}
	}

	public static void swap(HeapNode x, HeapNode y) {
		/*
		 * HeapNode z = x; x = y; y = z;
		 */
		int temp = x.val;
		x.val = y.val;
		y.val = temp;

		temp = x.c;
		x.c = y.c;
		y.c = temp;

		temp = x.r;
		x.r = y.r;
		y.r = temp;
	}
}
