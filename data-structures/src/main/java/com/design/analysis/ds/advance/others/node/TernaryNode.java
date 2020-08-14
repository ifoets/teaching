package com.design.analysis.ds.advance.others.node;

public class TernaryNode<T> {

	public T dt;
	public boolean isEnd;
	public TernaryNode<T> lt, rt, eq;

	public TernaryNode(T dt) {
		super();
		this.dt = dt;
		this.isEnd = false;
		this.lt = this.rt = this.eq = null;
	}
}
