package com.design.analysis.ds.tree.node;

public class LBTNode<K, T> {

	public K k;
	public LBTNode<K, T> next;
	public BTNode<T> down;

	public LBTNode(K k) {
		this.k = k;
		this.next = null;
		this.down = null;
	}
}
