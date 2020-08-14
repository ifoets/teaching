package com.design.analysis.algo.node;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int V;
	public List<Integer> adj[];

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		super();
		this.setV(V);
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}
}
