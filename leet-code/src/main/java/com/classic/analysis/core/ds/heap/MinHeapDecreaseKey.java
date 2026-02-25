package com.classic.analysis.core.ds.heap;

import java.util.*;

public class MinHeapDecreaseKey {

    List<Node> heap;
    Map<Integer,Integer> indexMap; //key-index
    static class Node{
        int key;
        public Node(int key)
        {
            this.key = key;
        }
    }

    public MinHeapDecreaseKey()
    {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
    }
    public void insert(int key)
    {
        Node node = new Node(key);
        heap.add(node);
        int index = heap.size()-1;
        indexMap.put(key,index);
        hepifyUp(index);
    }
    public int extractMin()
    {
        if(heap.isEmpty()) throw new IllegalStateException("Empty heap..");
        int min = heap.get(0).key;
        swap(0,heap.size()-1);
        heap.removeLast();
        indexMap.remove(min);
        hepifyDown(0);
        return min;
    }
    public void decreaseKey(int oldKey, int newKey)
    {
        if(!indexMap.containsKey(oldKey)) throw new NoSuchElementException("Key not found");
        if(newKey>oldKey) throw new IllegalArgumentException("Old key must be samllar");
        int index = indexMap.get(oldKey);
        heap.get(index).key=newKey;
        indexMap.remove(oldKey);
        indexMap.put(newKey,index);
        hepifyUp(index);
    }
    public void hepifyUp(int index)
    {
        while (index>0)
        {
            int parentIndex=(index-1)/2;
            if(heap.get(parentIndex).key<heap.get(index).key)
                break;
            swap(index,parentIndex);
            index=parentIndex;
        }
    }
    public void hepifyDown(int index)
    {
        while (true)
        {
            int left = 2*index+1;
            int right = 2*index+2;
            int smallest = index;

            if(left<heap.size() && heap.get(left).key<heap.get(smallest).key)
                smallest=left;
            if(right<heap.size() && heap.get(right).key<heap.get(smallest).key)
                smallest=right;
            if(index==smallest)
                break;
            swap(index, smallest);
            index=smallest;
        }
    }
    public void swap(int i, int j)
    {
        Node temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public boolean isEmpty()
    {
        return heap.isEmpty();
    }
}
