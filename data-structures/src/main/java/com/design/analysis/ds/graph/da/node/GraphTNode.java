package com.design.analysis.ds.graph.da.node;

public class GraphTNode {

	public int vSize;// vertices size
	public GTHeadNode t[];

	public GraphTNode(int vSize) {
		this.vSize = vSize;
		t = new GTHeadNode[vSize];
	}
}
