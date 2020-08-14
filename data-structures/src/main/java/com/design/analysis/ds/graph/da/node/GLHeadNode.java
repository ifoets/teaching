package com.design.analysis.ds.graph.da.node;

public class GLHeadNode {
	public int srcV;// source vertex
	public GLNode next;

	public GLHeadNode(int srcV) {
		this.srcV = srcV;
		this.next = null;
	}
}
