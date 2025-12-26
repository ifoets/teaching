package com.design.analysis.ds.deque.queue.easy;

import com.design.analysis.ds.deque.queue.easy.fundamental.QueueUsingStack;
import com.design.analysis.ds.deque.queue.easy.fundamental.StackUsingQueue;

public interface IQueueEasy {

    /**225. Implement Stack using Queues**/
    int impStackUsingQueue(StackUsingQueue suq, String command, int value);

    /**232. Implement Queue using Stacks**/
    int impQueueUsingStack(QueueUsingStack qus, String command, int value);
}
