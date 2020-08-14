package com.design.analysis.ds.linklist.node;

public class SOrgNode<N> {

	public N n;
	public int frq;// frequency
	public SOrgNode<N> next;

	public SOrgNode(N n) {
		this.n = n;
		this.frq = 0;
		this.next = null;
	}
}
