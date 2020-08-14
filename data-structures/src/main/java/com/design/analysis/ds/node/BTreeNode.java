package com.design.analysis.ds.node;

public class BTreeNode {

	public int keys[];
	public int t;// degree
	public BTreeNode[] next;
	int n;
	boolean leaf;

	public BTreeNode(int t, boolean leaf) {
		super();
		this.t = t;
		this.leaf = leaf;

		this.keys = new int[2 * t - 1];
		this.next = new BTreeNode[2 * t];
	}
}
