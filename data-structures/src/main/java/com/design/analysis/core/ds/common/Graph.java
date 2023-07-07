package com.design.analysis.core.ds.common;

public class Graph {

	public int V; // number of vertices in the graph
	public AdjList[] array;

	public Graph(int v) {
		super();
		V = v;
		/*array = new AdjList[v]; //TODO
		for (int i = 0; i < v; i++) {
			array[i] = new AdjList();
			array[i].head = null;
		}*/
	}
}
