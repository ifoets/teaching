package com.classic.analysis.core.ds;

public class IPriorityQueue {

    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IPriorityQueue() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Empty PQ");
        return heap[0];
    }

    public void insert(int val) {
        ensureCapacity();
        heap[size] = val;
        siftUp(size);
        size++;
    }

    public int poll() {
        if (isEmpty()) throw new IllegalStateException("Empty PQ");

        int result = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return result;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] >= heap[parent]) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap[left] < heap[smallest])
                smallest = left;
            if (right < size && heap[right] < heap[smallest])
                smallest = right;

            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            int newCap = heap.length * 2;
            int[] newHeap = new int[newCap];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}