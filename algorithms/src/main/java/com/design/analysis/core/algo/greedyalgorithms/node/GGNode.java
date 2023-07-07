package com.design.analysis.core.algo.greedyalgorithms.node;

public class GGNode {

	public int dest;
	public int wt;
	public GGNode next;

	public GGNode(int dest, int wt) {
		super();
		this.dest = dest;
		this.wt = wt;
		this.next = null;
	}
}
