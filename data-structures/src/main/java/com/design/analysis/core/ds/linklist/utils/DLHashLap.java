/**
 * 
 */
package com.design.analysis.core.ds.linklist.utils;

import com.design.analysis.core.ds.linklist.node.DLNode;

/**
 * @author @Gurug
 *
 */
public class DLHashLap implements Lap<DLNode<Integer>, DLNode<Integer>> {

	public DLNode<Integer> head = null;
	public DLNode<Integer> tail = null;

	@Override
	public DLNode<Integer> getHead() {
		return head;
	}

	public void setHead(DLNode<Integer> head) {
		this.head = head;
	}

	@Override
	public DLNode<Integer> getTail() {
		return tail;
	}

	public void setTail(DLNode<Integer> tail) {
		this.tail = tail;
	}

	@Override
	public void put(DLNode<Integer> k, DLNode<Integer> v) {
		setHead(k);
		setTail(v);
	}
}
