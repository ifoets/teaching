package com.classic.analysis.core.ds;

public class BoundedQueue {
    private final int[] queue;
    private int head;
    private int tail;
    private int size;
    private final int capacity;

    public BoundedQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean enqueue(int val) {
        if (isFull()) return false;

        queue[tail] = val;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) return false;

        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int peek() {
        return isEmpty() ? -1 : queue[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
