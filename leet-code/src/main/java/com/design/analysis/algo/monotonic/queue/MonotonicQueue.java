package com.design.analysis.algo.monotonic.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {

    Deque<Integer> deque = new ArrayDeque<>();
    public void push(int x)
    {
        while (!deque.isEmpty()&&deque.peekLast()<x)
            deque.pollLast();
        deque.offerLast(x);
    }

    //remove element if out of window
    public void pop(int x)
    {
        if(!deque.isEmpty()&&deque.peekLast()==x)
            deque.pollLast();
    }

    public int max()
    {
        return !deque.isEmpty()? deque.peekFirst() : Integer.MIN_VALUE;
    }

}
