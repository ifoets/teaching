package com.design.analysis.ds.linklist.node;

public class FlatLNode<K> {

	public K k;
	public FlatLNode<K> next;
	public FlatLNode<K> down;

	public FlatLNode(K k) {
		this.k = k;
		this.next = this.down = null;
	}
}
