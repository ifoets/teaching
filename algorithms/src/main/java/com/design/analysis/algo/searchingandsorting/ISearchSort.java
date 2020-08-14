package com.design.analysis.algo.searchingandsorting;

public interface ISearchSort {

	public Integer binarySearch(int x, int a[]);

	public Integer binarySearch(int x, int l, int r, int a[]);

	public Integer jumpSearch(int a[], int x);

	public Integer interpolationSearch(int a[], int x);

	public void selectionSort(int a[]);

	public void bubbleSort(int a[]);

	public void insertionSort(int a[]);

	public void mergeSort(Integer a[]);

	public void merge(Integer first[], Integer[] second, Integer[] result);

	public void maxHeapSort(int a[]);

	public void minHeapSort(int a[]);

	public void maxHeapify(int a[], int size, int index);

	public void minHeapify(int a[], int size, int index);

	public void quickSort(int a[], int loInx, int hiInd);

	public void radixSort(int a[]);

	public void countingSort(int a[]);

	public void swap(int a[], int i, int j);

	public int max(int a[]);
}
