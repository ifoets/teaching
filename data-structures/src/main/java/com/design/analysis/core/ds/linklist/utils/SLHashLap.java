/**
 * 
 */
package com.design.analysis.core.ds.linklist.utils;

import com.design.analysis.core.ds.linklist.node.SLNode;

/**
 * @author @Gurug
 *
 */
public class SLHashLap implements Lap<SLNode<Integer>, SLNode<Integer>> {

	public SLNode<Integer> head = null;
	private SLNode<Integer> tail = null;

	@Override
	public SLNode<Integer> getHead() {
		return head;
	}

	public void setHead(SLNode<Integer> head) {
		this.head = head;
	}

	@Override
	public SLNode<Integer> getTail() {
		return tail;
	}

	public void setTail(SLNode<Integer> tail) {
		this.tail = tail;
	}

	@Override
	public void put(SLNode<Integer> k, SLNode<Integer> v) {
		setHead(k);
		setTail(v);
	}
}
