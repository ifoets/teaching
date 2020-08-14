package com.design.analysis.ds.graph.da;

import com.design.analysis.ds.graph.da.node.GraphWtLNode;

public interface DAIWGraphAdjList {

	public GraphWtLNode initGraph(int v);

	public GraphWtLNode addEdge(GraphWtLNode g, int src, int dest, int wt);

	public void printGraph(GraphWtLNode g);

	// start is the source node
	public void printBFT(GraphWtLNode g, int start);// breath first travel

	public void printDFT(GraphWtLNode g, int start);// depth first travel

	public void markVisited(GraphWtLNode g, int node);

	public int searchSourceNodeIndex(GraphWtLNode g, int source);
}
