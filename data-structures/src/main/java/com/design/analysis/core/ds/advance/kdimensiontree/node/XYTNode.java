package com.design.analysis.core.ds.advance.kdimensiontree.node;

/*
 * 
 * @author GuruG
 * This is K-Dimension tree node
 */
public class XYTNode<T> {

	public T t;
	public XYTNode<T> lt, rt;

	public XYTNode(T t) {
		this.lt = this.rt = null;
		this.t = t;
	}
}
