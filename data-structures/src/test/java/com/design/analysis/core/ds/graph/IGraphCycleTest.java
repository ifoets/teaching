/**
 * 
 */
package com.design.analysis.core.ds.graph;

import org.junit.Before;

/**
 * @author @Gurug
 *
 */
public class IGraphCycleTest {

	public IGraphCycle<Integer, Integer> igc = null;

	@Before
	public void init() {
		igc = new GraphCycleImpl();
	}
	
	/** 1. Detect Cycle in a Directed Graph **/
	/* add edge to directed graph */
	/*public void addEdgeTest();

	public boolean isCycleDirGraph(Graph<V, W> g);
	*//** 2. Detect Cycle in a an Undirected Graph **//*

	 add edge to non directed graph 
	public Graph<V, W> addEdgeUnDre(Graph<V, W> g, V u, V v);

	public boolean isCycleUnDirGraph(Graph<V, W> g);*/
	/** 3. Detect cycle in an undirected graph */
	/* 4. Detect cycle in a direct graph using colors */
	/*
	 * 5. Assign directions to edges so that the directed graph remains acyclic
	 */
	/* 6. Detect a negative cycle in a Graph | (Bellman Ford) */
}
