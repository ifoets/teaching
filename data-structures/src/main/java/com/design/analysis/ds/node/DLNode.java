package com.design.analysis.ds.node;

public class DLNode {

	public int dt;
	public DLNode next;
	public DLNode prev;

	public DLNode(int dt) {
		super();
		this.dt = dt;
		this.next = this.prev = null;
	}
}
