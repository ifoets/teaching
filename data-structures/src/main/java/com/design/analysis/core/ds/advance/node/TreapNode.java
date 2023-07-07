package com.design.analysis.core.ds.advance.node;

public class TreapNode<T> {

	public T key;
	public int priority;
	public TreapNode<T> lt, rt;

	public TreapNode(T key) {
		super();
		this.key = key;
		this.priority = (int) (Math.random() * 100);
		this.lt = this.rt = null;
	}
}
