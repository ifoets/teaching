package com.design.analysis.ds.heap;

import java.security.NoSuchAlgorithmException;

public class MeanHeapImpl implements IMeanHeap{

	 /** The number of children each node has **/
    public static final int d = 2;
    public int heapSize;
    public int[] heap;
    
    public MeanHeapImpl(int size)
    {
       heapSize = 0;
       heap = new int[size+1];
    }

	@Override
	public int parent(int nodeIndex) {
		return (nodeIndex-1)/2;
	}
	
	@Override
	public void insert(int x) {
		
		if(isFull())
		{
			new NoSuchAlgorithmException("heap is allready full");
		}
		heap[heapSize++]=x;
		heapifyUp(heapSize-1);
	}

	@Override
	public void heapifyUp(int nodeIndex) {
		
		int ptIndex, temp;
		
		if(nodeIndex != 0)
		{
			ptIndex = parent(nodeIndex);
			if(heap[nodeIndex] < heap[ptIndex])
			{
				temp = heap[ptIndex];
				heap[ptIndex] = heap[nodeIndex];
				heap[nodeIndex] = temp;
				heapifyUp(ptIndex);
			}
		}
	}

	@Override
	public void heapifyDown(int ind) {
		int ltChInd, rtChInd, minInd, temp;
		ltChInd = 2 * ind + 1;
		rtChInd = 2 * ind + 2;

		if (rtChInd >= heapSize) {
			if (ltChInd >= heapSize) {
				return;
			} else {
				minInd = ltChInd;
			}
		} else {
			if (heap[ltChInd] < heap[rtChInd]) {
				minInd = ltChInd;
			} else {
				minInd = rtChInd;
			}
		}
		if (heap[ind] > heap[minInd]) {
			temp = heap[minInd];
			heap[minInd] = heap[ind];
			heap[ind] = temp;
			heapifyDown(minInd);
		}
	}

	@Override
	public void printHeap() {
		for(int i=0;i<heapSize;i++)
			System.out.print(heap[i]+"->");
	}

	@Override
	public boolean isEmpty() {
		return heapSize ==0;
	}

	@Override
	public boolean isFull() {
		return heapSize == heap.length;
	}

	@Override
	public void makeEmpty() {
		heapSize =0;
	}

	@Override
	public int kthChild(int i, int k) {
		return 2*i+k;
	}

	@Override
	public int findMin() {
		return heap[0];
	}

	@Override
	public int deleteMin() {
		if(isEmpty())
		{
			new NoSuchAlgorithmException("heap is empty");
		}
		int temp = heap[0];
		heap[0] = heap[heapSize-1];
		heapSize--;
		heapifyDown(0);
		return temp;
	}

	@Override
	public int delete(int ind) {
		
		if(isEmpty())
		{
			new NoSuchAlgorithmException("heap is empty");
		}
		int temp = heap[ind];
		heap[ind] = heap[heapSize-1];
		heapSize--;
		heapifyDown(ind);
		return temp;
	}

	@Override
	public int minChild(int ind) {
		
		int ltChind, rtChind;
		ltChind = 2*ind+1;
		rtChind = 2*ind+2;
		if(ltChind>=heapSize)
			return Integer.MIN_VALUE;
		if(rtChind>=heapSize)
			return heap[ltChind];
		else
		{
			if(heap[ltChind]<heap[rtChind])
				return heap[ltChind];
			else return heap[rtChind];
		}
	}

	@Override
	public void decreaseIncreaseKey(int xOld, int xNew) {
		
		if(xOld == xNew)
			return;
		
		int index =  indexOfValue(xOld);
		if(index!=-1)
			
		{
			heap[index] = xNew;
		    if(xOld > xNew)
		    heapifyUp(index);
		    else heapifyDown(index);
		}
	}

	@Override
	public int indexOfValue(int x) {
		for(int i =0 ;i<heapSize;i++)
		{
			if(x==heap[i])
				return i;
		}
		return -1;
	}
	
	@Override
	public int[] heapSort(int arr[])
	{
		arr = new int[heapSize];
		
		for(int i=0;i<arr.length;i++)
		{
		  arr[i]=heap[0];
		  heap[0]=heap[heapSize-1];
		  heapSize--;
		  heapifyDown(0);
		}
		return arr;
	}
}
