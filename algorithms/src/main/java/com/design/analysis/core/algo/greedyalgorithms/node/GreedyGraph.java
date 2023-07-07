package com.design.analysis.core.algo.greedyalgorithms.node;

public class GreedyGraph {

	public GGNode nt[]; // graph node table
	public int gSize;

	public GreedyGraph(int gSize) {
		this.gSize = gSize;
		nt = new GGNode[this.gSize];
	}
}
