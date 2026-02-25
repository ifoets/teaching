package com.classic.analysis.core.ds.heap;

import java.util.Arrays;

public class MinHeap {

    int heap[];
    int capacity;
    int size;

    public  MinHeap(int capacity)
    {
        this.capacity = capacity;
        this.size=0;
        heap = new int[capacity];
    }

    public void insert(int val)
    {
        ensureCapacity();
        heap[size]=val;
        hepifyUp(size);
        size++;
    }
    public int extractMin()
    {
        if(isEmpty()) throw new IllegalStateException("Heap Empty");
        int min = heap[0];
        heap[0]=heap[size-1]; //during insert size++ happen
        hepifyDown(0);
        return min;
    }
    void hepifyUp(int index)
    {
        while (index>0 && heap[index]<heap[parent(index)])
        {
            swap(index,parent(index));
            index = parent(index);
        }
    }
    void hepifyDown(int index)
    {
        while (leftChild(index)<size)
        {
            int smallarChild = leftChild(index);
            if(rightChild(index)<size && heap[rightChild(index)]<heap[smallarChild])
            {
                smallarChild = rightChild(index);
            }
            if(heap[index]<heap[smallarChild])
                break;
            swap(index,smallarChild);
            index = smallarChild;
        }
    }
    void ensureCapacity()
    {
        if(size==capacity)
        {
            capacity*=2;
            heap = Arrays.copyOf(heap,capacity);
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

}
