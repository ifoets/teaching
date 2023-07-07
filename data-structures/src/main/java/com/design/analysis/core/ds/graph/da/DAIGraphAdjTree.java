package com.design.analysis.core.ds.graph.da;

import com.design.analysis.core.ds.graph.da.node.GTNode;
import com.design.analysis.core.ds.graph.da.node.GraphTNode;

/**here at the place of link list we used tree for adjacent node **/
public interface DAIGraphAdjTree {

	public GraphTNode initGraph(int v);

	public GraphTNode addEdge(GraphTNode g, int src, int dest);
	
	public GTNode createTree(GTNode node, int v);
	
	public void printTree(GTNode node);

	public void printGraph(GraphTNode g);

	// start is the source node
	public void printBFT(GraphTNode g, int start);// breath first travel

	public void printDFT(GraphTNode g, int start);// depth first travel

	public void markVisited(GraphTNode g, int node);

	public int searchSourceNodeIndex(GraphTNode g, int source);
}
