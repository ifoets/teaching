package com.design.analysis.algorithms.interview.node;

public class TNode<T> {

	public T t;
	public TNode<T> next, lt, rt, pt;

	public TNode(T t) {
		this.t = t;
		this.lt = this.rt = this.next = this.pt = null;
	}

}
