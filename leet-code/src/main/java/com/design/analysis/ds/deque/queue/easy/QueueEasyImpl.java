package com.design.analysis.ds.deque.queue.easy;

import com.design.analysis.ds.deque.queue.easy.fundamental.QueueUsingStack;
import com.design.analysis.ds.deque.queue.easy.fundamental.StackUsingQueue;

public class QueueEasyImpl implements IQueueEasy{

    /**225. Implement Stack using Queues**/
    public int impStackUsingQueue(StackUsingQueue suq, String command, int value){

        switch (command)
        {
            case "push": suq.push(value);
            break;
            case "pop" : return suq.pop();

            case "top" :return suq.top();

            case "empty": return suq.empty()?0:1;

        }
        return -1;
    }

    /**232. Implement Queue using Stacks**/
    public int impQueueUsingStack(QueueUsingStack qus, String command, int value){
        switch (command)
        {
            case "push": qus.push(value);
            break;
            case "pop" : return qus.pop();
            case "top" :return qus.peek();
            case "empty":return qus.empty()?0:1;
        }
        return -1;
    }
}
