package com.design.analysis.core.ds.heap;

public interface IMeanHeap {

	/** Function to insert element */
	public void insert(int x);

	/** Function to print heap **/
	public void printHeap();

	public boolean isEmpty();

	/** Check if heap is full **/
	public boolean isFull();

	/** Clear heap */
	public void makeEmpty();

	/** Function to get index parent of i **/
	public int parent(int i);

	/** Function to get index of k th child of i **/
	public int kthChild(int i, int k);

	/** Function to find least element **/
	public int findMin();

	/** Function to delete min element **/
	public int deleteMin();

	/** Function to delete element at an index **/
	public int delete(int ind);

	/** Function heapifyUp **/
	public void heapifyUp(int childInd);

	/** Function heapifyDown **/
	public void heapifyDown(int ind);

	/** Function to get smallest child **/
	public int minChild(int ind);

	/** decease or increase key **/
	public void decreaseIncreaseKey(int xOld, int xNew);

	/** indx of given value **/
	public int indexOfValue(int x);

	/** heap sort **/
	public int[] heapSort(int arr[]);

	/** 8. Sort numbers stored on different machines **/

}
