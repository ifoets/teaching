package com.design.analysis.core.ds.graph.da.node;

public class GraphWtLNode {

	public int vSize; // vertices size
	public GWLHeadNode[] t; // table of vertices

	public GraphWtLNode(int vSize) {
		this.vSize = vSize;
		t = new GWLHeadNode[vSize];
	}
}
