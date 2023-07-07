package com.design.analysis.core.ds.graph.da.node;

public class GraphLNode {

	public int vSize; // vertices size
	public GLHeadNode[] t; // table of vertices

	public GraphLNode(int vSize) {
		this.vSize = vSize;
		t = new GLHeadNode[vSize];
	}
}
