/**
 * 
 */
package com.design.analysis.ds.queue;

import com.design.analysis.ds.node.QueueNode;

/*
 * @author @Gurug
 
/*Implementation :
1.	Implement Queue using Stacks
2.	LRU Cache Implementation
3.	Implement Stack using Queues
4.	Queue | Set 2 (Linked List Implementation)
5.	How to efficiently implement k Queues in a single array?
6.	Implement a stack using single queue
7.	Implementation of Deque using circular array
8.	Circular Queue | Set 2 (Circular Linked List Implementation)
*/

public interface IImplementation {

	/** 1. Implement Queue using Stacks **/
	public void enQueue(int x);

	public Integer deQuue();

	/** 2. LRU Cache Implementation **/
	/* it is implemented in separate class LRUCacheImpl.java */
	/** 3. Implement Stack using Queues **/
	public Integer pop();

	public void push(int x);

	/* 4. Queue | Set 2 (Linked List Implementation) */
	public QueueNode enQueueDLink(QueueNode queue, int x);

	public Integer deQuuevDLink(QueueNode que);
}
