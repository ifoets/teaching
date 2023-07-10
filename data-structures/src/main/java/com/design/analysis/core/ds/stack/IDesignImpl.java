package com.design.analysis.core.ds.stack;

import com.design.analysis.core.ds.stackqueue.node.QToSNode;
import com.design.analysis.core.ds.stackqueue.node.SToQNode;
import com.design.analysis.core.ds.stack.node.TwoStackNode;

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
public interface IDesignImpl {

	/** 1. Implement Queue using Stacks **/
	public void enQueue(SToQNode queue, int x);

    public int dQueue(SToQNode queue) throws RuntimeException;

    /*2.Design and Implement Special Stack Data Structure | Added Space Optimized Version @see DaStack.java*/

    /*3.Implement two stacks in an array*/
    public TwoStackNode twoStackImpl(int n);

    /*4. Implement Stack using Queues*/
    public QToSNode<Integer> stackUsingQueue(int n);
}
