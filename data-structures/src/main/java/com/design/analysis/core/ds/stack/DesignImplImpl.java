package com.design.analysis.core.ds.stack;
/*
Design and Implementation :
1.	Implement Queue using Stacks
2.	Design and Implement Special Stack Data Structure | Added Space Optimized Version
3.	Implement two stacks in an array
4.	Implement Stack using Queues
5.	Design a stack with operations on middle element
6.	How to efficiently implement k stacks in a single array?
7.	How to create mergable stack?
8.	Design a stack that supports getMin() in O(1) time and O(1) extra space
9.	Implement a stack using single queue
10.	How to implement stack using priority queue or heap?
11.	Create a customized data structure which evaluates functions in O(1)
*/

import com.design.analysis.core.ds.queue.node.QNode;
import com.design.analysis.core.ds.stackqueue.node.QToSNode;
import com.design.analysis.core.ds.stackqueue.node.SToQNode;
import com.design.analysis.core.ds.stack.node.TwoStackNode;

public class DesignImplImpl implements IDesignImpl {

    /** 1. Implement Queue using Stacks **/
    @Override
    public void enQueue(SToQNode queue, int x){
        while (queue.s1.tail != null)
            queue.s2.push(queue.s1.pop().dt);
              queue.s1.push(x);
        while (queue.s2.tail != null)
            queue.s1.push(queue.s2.pop().dt);
    }

    public int dQueue(SToQNode queue) throws  RuntimeException{
           if(queue.s1.tail==null)
               throw new RuntimeException("Queue is Empty");
           return queue.s1.pop().dt;
    }

    /*3.Implement two stacks in an array*/
    @Override
    public TwoStackNode twoStackImpl(int n)
    {
        return new TwoStackNode(n);
    }


    /*4. Implement Stack using Queues*/
    public QToSNode stackUsingQueue(int n)
    {
       return new QToSNode(new QNode(n),new QNode<>(n));
    }

}
