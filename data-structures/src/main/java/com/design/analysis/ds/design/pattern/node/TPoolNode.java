package com.design.analysis.ds.design.pattern.node;

public class TPoolNode<I> {

	public I i;
	public TPoolNode<I> lt, rt;

	public TPoolNode(I i) {
		this.i = i;
		this.lt = this.rt;
	}
}
