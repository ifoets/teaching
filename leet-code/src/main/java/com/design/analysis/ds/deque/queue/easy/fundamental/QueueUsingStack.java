package com.design.analysis.ds.deque.queue.easy.fundamental;

import java.util.Stack;

/**232. Implement Queue using Stacks**/
public class QueueUsingStack {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public QueueUsingStack()
    {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
       if(stack1.isEmpty()) throw new RuntimeException("Empty queue!!");
       while (!stack1.isEmpty()) stack2.push(stack1.pop());
       int pop = stack2.pop();
       while (!stack2.isEmpty())stack1.push(stack2.pop());
       return pop;
    }

    public int peek() {
        if(stack1.isEmpty()) throw new RuntimeException("Empty queue!!");
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        int peek = stack2.peek();
        while (!stack2.isEmpty())stack1.push(stack2.pop());
        return peek;
    }

    public boolean empty() {
     return stack1.isEmpty();
    }
}
