package com.design.analysis.ds.graph.da.node;

public class GTHeadNode {
	public int srcV;// source vertex
	public GTNode next;

	public GTHeadNode(int srcV) {
		this.srcV = srcV;
		this.next = null;
	}
}
