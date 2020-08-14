package com.design.analysis.ds.graph.da;

import java.util.List;

import com.design.analysis.ds.graph.da.node.GLNode;
import com.design.analysis.ds.graph.da.node.GraphLNode;

public interface DAIGraphAdjList {

	public GraphLNode initGraph(int v);

	public GraphLNode addEdge(GraphLNode g, int src, int dest);

	public void printGraph(GraphLNode g);

	// start is the source node
	public void printBFT(GraphLNode g, int start);// breath first travel

	public void printDFT(GraphLNode g, int start);// depth first travel

	public void markVisited(GraphLNode g, int node);

	public int searchSourceNodeIndex(GraphLNode g, int source);

	public List<Integer> lastVertexInDFT(GraphLNode g, int srcV);

	public int motherVertex(GraphLNode g);

	public GLNode deleteNodeFromSourcePath(GLNode g, int v);

	public GraphLNode kCores(GraphLNode g, int k);

	public int recursiveLenghtList(GLNode head);

	public GraphLNode deleteNode(GraphLNode g, int arrV[]);
	
	public boolean detectCycleDirectedGraph(GraphLNode g);
}
