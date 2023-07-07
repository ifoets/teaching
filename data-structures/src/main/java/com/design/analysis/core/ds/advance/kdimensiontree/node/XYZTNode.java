package com.design.analysis.core.ds.advance.kdimensiontree.node;

public class XYZTNode<T> {

	public T t;
	public XYZTNode<T> lt, rt;

	public XYZTNode(T t) {
		this.lt = this.rt = null;
		this.t = t;
	}
}
