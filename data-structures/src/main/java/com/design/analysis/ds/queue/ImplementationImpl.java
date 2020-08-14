/**
 * 
 */
package com.design.analysis.ds.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.design.analysis.ds.node.DLNode;
import com.design.analysis.ds.node.QueueNode;

/**
 * @author @Gurug
 *
 */
public class ImplementationImpl implements IImplementation {

	public Stack<Integer> stk1 = new Stack<>();
	public Stack<Integer> stk2 = new Stack<>();

	public Queue<Integer> q1 = new LinkedList<>();
	public Queue<Integer> q2 = new LinkedList<>();

	/* 1. Implement Queue using Stacks */
	@Override
	public void enQueue(int x) {

		while (!stk1.isEmpty())
			stk2.push(stk1.pop());
		stk1.push(x);

		while (!stk2.isEmpty())
			stk1.push(stk2.pop());
	}

	@Override
	public Integer deQuue() {

		if (!stk1.isEmpty())
			return stk1.pop();
		return null;
	}

	/** 2. LRU Cache Implementation **/
	/* it is implemented in separate class LRUCacheImpl.java */
	/** 3. Implement Stack using Queues **/
	public Integer pop() {

		if (!q1.isEmpty())
			return q1.poll();
		return null;
	}

	public void push(int x) {
		q2.add(x);
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	/* 4. Queue | Set 2 (Linked List Implementation) */
	@Override
	public QueueNode enQueueDLink(QueueNode que, int x) {

		DLNode temp = new DLNode(x);
		if (que == null) {
			que = new QueueNode();
			que.front = que.rear = temp;
		} else {
			temp.next = que.front;
			que.front.prev = temp;
			que.front = temp;
		}
		return que;
	}

	@Override
	public Integer deQuuevDLink(QueueNode que) {
		Integer result = null;
		if (que == null || que.front == null || que.rear == null)
			return result;
		else if (que.front == que.rear) {
			result = que.front.dt;
			que.front = que.rear = null;

		} else {
			result = que.rear.dt;
			DLNode temp = que.rear;
			que.rear = que.rear.prev;
			temp.prev = null;
			que.rear.next = null;
			temp = null;
		}
		return result;
	}
	/* 4. Queue | Set 2 (Linked List Implementation) */
}
