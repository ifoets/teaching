package com.classic.analysis.core.ds.heap;

import java.util.Arrays;

public class MaxHeap {
    int[] heap;
    int capacity;
    int size;

    public MaxHeap(int capacity)
    {
        this.capacity=capacity;
        this.size=0;
        heap=new int[capacity];
    }

    public void insert(int val)
    {
        ensureCapacity();
        heap[size]=val;
        hepifyUp(size);
        size++;
    }

    public int extractMax()
    {
        if(isEmpty()) throw new IllegalStateException("Empty Heap");
        int max = heap[0];
        heap[0]=heap[size-1]; //during insert size++;
        hepifyDown(0);
        size--;
        return max;
    }
    public void hepifyUp(int index)
    {
        while (index>0 && heap[parent(index)]<heap[index])
        {
            swap(index,parent(index));
            index=parent(index);
        }
    }
    public void hepifyDown(int index)
    {
        while (leftChild(index)<size)
        {
            int bigChild = leftChild(index);
            if(rightChild(index)<size && heap[rightChild(index)]>heap[bigChild])
            {
                bigChild = rightChild(index);
            }
            if(heap[index]>heap[bigChild])
                break;
            swap(index,bigChild);
            index = bigChild;
        }
    }
    int parent(int i)
    {
        return (i-1)/2;
    }
    int leftChild(int i)
    {
        return 2*i+1;
    }
    int rightChild(int i)
    {
        return 2*i+2;
    }
    boolean isEmpty()
    {
        return size==0;
    }
    int size()
    {
        return size;
    }
    int peek()
    {
        if(isEmpty()) throw new IllegalStateException("Empty heap");
        return heap[0];
    }
    void swap(int i, int j)
    {
        int temp = heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    void ensureCapacity()
    {
        if(size==capacity)
        {
            capacity*=2;
            heap = Arrays.copyOf(heap,capacity);
        }
    }
}
