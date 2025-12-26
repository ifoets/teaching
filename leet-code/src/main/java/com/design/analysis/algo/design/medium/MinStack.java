package com.design.analysis.algo.design.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> deque;
    Deque<Integer> minDeque;
    public MinStack() {
        deque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }

    public void push(int val) {
        deque.push(val);
        if(minDeque.isEmpty())minDeque.push(val);
        else {
            minDeque.push(Math.min(val,minDeque.peek()));
        }
    }

    public void pop() {
        deque.pop();
        minDeque.pop();
    }

    public Integer top() {
       return deque.peek();
    }

    public Integer getMin() {
         return minDeque.peek();
    }
}
