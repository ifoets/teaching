/**
 * 
 */
package com.design.analysis.ds.graph;

import com.design.analysis.ds.graph.node.Graph;

/**
 * @author @Gurug
 *
 *Graph Cycle:
1.	Detect Cycle in a Directed Graph
2.	Detect Cycle in a an Undirected Graph
3.	Detect cycle in an undirected graph
4.	Detect cycle in a direct graph using colors
5.	Assign directions to edges so that the directed graph remains acyclic
6.	Detect a negative cycle in a Graph | (Bellman Ford)

 */
public interface IGraphCycle<V, W> {

	/** 1. Detect Cycle in a Directed Graph **/
	public boolean isCycleDirGraph(Graph<V, W> g);

	/** 2. Detect Cycle in a an Undirected Graph **/
	public boolean isCycleUnDirGraph(Graph<V, W> g);
	/** 3. Detect cycle in an undirected graph */
	/* 4. Detect cycle in a direct graph using colors */
	/*
	 * 5. Assign directions to edges so that the directed graph remains acyclic
	 */
	/* 6. Detect a negative cycle in a Graph | (Bellman Ford) */
}
