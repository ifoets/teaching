package com.design.analysis.ds.deque.queue.easy.fundamental;

import java.util.ArrayDeque;
import java.util.Queue;

/**225. Implement Stack using Queues**/
public class StackUsingQueue {

    public Queue<Integer> queue1;
    public Queue<Integer> queue2;
    public StackUsingQueue()
    {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }
    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if(queue1.isEmpty()) throw new RuntimeException("No Element found");
        while (queue1.size()>1)
        {
            queue2.add(queue1.poll());
        }
        int top = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public int top() {
        if(queue1.isEmpty()) throw new RuntimeException("No Element found");
        while (queue1.size()>1)
        {
            queue2.add(queue1.poll());
        }
        int top = queue1.peek();
        queue2.add(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
