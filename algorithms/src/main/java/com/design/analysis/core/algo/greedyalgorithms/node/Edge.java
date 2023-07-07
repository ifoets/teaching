package com.design.analysis.core.algo.greedyalgorithms.node;

public class Edge implements Comparable<Edge> {

	public int src;
	public int dest;
	public int wt;

	public Edge(int src, int dest, int wt) {
		super();
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}

	@Override
	public int compareTo(Edge arg0) {
		return this.wt - arg0.wt;
	}

	@Override
	public String toString() {
		return "(src:" + src + ",dest: " + dest + ",wt: " + wt + ")";
	}

	@Override
	public int hashCode() {
		return src + dest + wt;
	}

	@Override
	public boolean equals(Object obj) {
		Edge edg = (Edge) obj;
		if (this.wt == edg.wt && this.src == edg.dest && this.dest == edg.src)
			return true;
		return false;
	}
}
