package com.design.analysis.ds.bst.inorder.node;

public class BTIONode<T> {

	public T t;
	public BTIONode<T> lt, rt, next, prev;
	public int h, ind;

	public BTIONode(T t) {
		this.t = t;
		this.lt = this.rt = this.next = this.prev = null;
		this.h = this.ind = 0;
	}
}
