package com.design.analysis.core.ds.graph.da.node;

/**
 * this node is used for directed/non directed and non weighted graph as link
 * list to link the node
 **/
public class GLNode {

	public int v;// vertex
	public GLNode next;
	public boolean visited;
	public int wt;// make it generic

	public GLNode(int v) {
		this.v = v;
		this.next = null;
		this.visited = false;
	}

	public GLNode(int v, int wt) {
		this.v = v;
		this.next = null;
		this.visited = false;
		this.wt = wt;
	}
}
