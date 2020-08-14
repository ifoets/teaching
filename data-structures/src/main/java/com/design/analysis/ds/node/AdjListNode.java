package com.design.analysis.ds.node;

public class AdjListNode {

	public int dest;
	public AdjListNode next;
	public boolean visited;// used for control cyclic visit during BFS

	public AdjListNode(int dest) {
		super();
		this.dest = dest;
		this.next = null;
		this.visited = false;
	}

	@Override
	public String toString() {
		return "AdjListNode [dest=" + dest + ", next=" + next + "]";
	}
}
