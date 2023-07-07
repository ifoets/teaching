package com.design.analysis.core.ds.graph.da.node;

/**
 * this node is used for directed/non directed and weighted graph as link list
 * to link the node
 **/
public class GWLNode {

	public int v;// vertex
	public int w;// weight
	public boolean visited;// used for control cyclic visit during BFS
	public GWLNode next;

	public GWLNode(int v, int w) {
		this.v = v;
		this.w = w;
		this.next = null;
	}
}