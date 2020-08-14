/**
 * 
 */
package com.design.analysis.ds.graph;

import com.design.analysis.ds.graph.node.Graph;
import com.design.analysis.ds.graph.utils.GraphUtils;
import com.design.analysis.ds.graph.utils.IGraphUtils;

/**
 * @author @Gurug
 *
 */
public class GraphCycleImpl implements IGraphCycle<Integer, Integer> {

	public IGraphUtils<Integer, Integer> igu = new GraphUtils();
	
	/* 1. Detect Cycle in a Directed Graph */

	@Override
	public boolean isCycleDirGraph(Graph<Integer, Integer> g) {
		return true;
	}

	/** 2. Detect Cycle in a an Undirected Graph **/
	@Override
	public boolean isCycleUnDirGraph(Graph<Integer, Integer> g) {
		return true;
	}
	/* 3. Detect cycle in an undirected graph */
	/* 4. Detect cycle in a direct graph using colors */
	/*
	 * 5. Assign directions to edges so that the directed graph remains acyclic
	 */
	/* 6. Detect a negative cycle in a Graph | (Bellman Ford) */
}
