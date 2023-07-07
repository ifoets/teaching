package com.design.analysis.core.ds.node;

public class EdgeWeightNode {

	public int dest;
	public int edge;
	public EdgeWeightNode next;
	public boolean visited;// used for control cyclic visit during BFS

	public EdgeWeightNode(int dest, int edge) {
		super();
		this.dest = dest;
		this.edge = edge;
		this.next = null;
		this.visited = false;
	}

	@Override
	public String toString() {
		return dest+", ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dest;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdgeWeightNode other = (EdgeWeightNode) obj;
		if (dest != other.dest)
			return false;
		return true;
	}
}
