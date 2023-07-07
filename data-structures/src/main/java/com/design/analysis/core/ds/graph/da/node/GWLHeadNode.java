package com.design.analysis.core.ds.graph.da.node;

public class GWLHeadNode {

	public int srcV;// source vertex
	public GWLNode next;

	public GWLHeadNode(int srcV) {
		this.srcV = srcV;
		this.next = null;
	}
}
