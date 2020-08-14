package com.design.analysis.ds.node;

//this is Self Organizing List node
public class SelfOrgListNode {

	public int dt;
	public SelfOrgListNode next;
	public int count;

	public SelfOrgListNode(int dt) {
		super();
		this.dt = dt;
		this.next = null;
		this.count = 0;
	}

}
