package com.design.analysis.core.ds.hashing.node;

public class HLNode<T> {

	public T t;
	public HLNode<T> next;

	public HLNode(T t) {
		this.t = t;
		this.next = null;
	}
}
