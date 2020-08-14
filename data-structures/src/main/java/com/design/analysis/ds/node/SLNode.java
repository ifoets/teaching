package com.design.analysis.ds.node;

public class SLNode {

	public int dt;
	public SLNode next;
	public boolean visited;

	public SLNode(int dt) {
		super();
		this.dt = dt;
		this.next = null;
	}
}
