package com.design.analysis.ds.node;

public class STBstNode<T> {

	public int dt;
	public STBstNode<T> lt, rt, pt; /// left,right,parent
	public boolean isThrd;

	public STBstNode(int dt) {
		super();
		this.dt = dt;
		this.lt = this.rt = this.pt = null;
		this.isThrd = false;
	}
}
