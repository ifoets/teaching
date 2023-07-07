package com.design.analysis.core.algo.branchandbound.node;

public class JobNode {
	public JobNode parent;
	// contains cost for ancestors nodes including current node
	public int pathCost;
	// contains least promising cost
	public int cost;
	// contain worker number
	public int workerID;
	// contains Job ID
	public int jobID;
	// Boolean array assigned will contains
	// info about available jobs
	public boolean assigned[];

	public JobNode() {
	}

	// Function to allocate a new search tree node Here Person x is assigned to job
	// y
	public JobNode newNode(int x, int y, boolean assigned[], JobNode parent) {
		JobNode node = new JobNode();
		node.assigned = new boolean[assigned.length];
		for (int j = 0; j < assigned.length; j++)
			node.assigned[j] = assigned[j];
		node.assigned[y] = true;

		node.parent = parent;
		node.workerID = x;
		node.jobID = y;
		return node;
	}
}
