package com.design.analysis.ds.graph;

import java.util.List;

import com.design.analysis.ds.graph.da.node.Edge;
import com.design.analysis.ds.graph.node.Graph;

/*
 * 
 * @author GuruG
 * 
 * Connectivity:
1.	Find if there is a path between two vertices in a directed graph
2.	Connectivity in a directed graph
3.	Articulation Points (or Cut Vertices) in a Graph
4.	Biconnected graph
5.	Bridges in a graph
6.	Eulerian path and circuit
7.	Fleury’s Algorithm for printing Eulerian Path or Circuit
8.	Strongly Connected Components
9.	Transitive closure of a graph
10.	Find the number of islands
11.	Count all possible walks from a source to a destination with exactly k edges
12.	Euler Circuit in a Directed Graph
13.	Biconnected Components
14.	Count the number of non-reachable nodes
15.	Find the Degree of a Particular vertex in a Graph
16.	Check if a given graph is tree or not
17.	Karger’s algorithm for Minimum Cut
18.	Eulerian Path in undirected graph
19.	Find if there is a path of more than k length
20.	Length of shortest chain to reach the target word
21.	Print all paths from a given source to destination
22.	Find minimum cost to reach destination using train
23.	Tarjan’s Algorithm to find strongly connected Components

 */
public interface IConnectivity<V, W> {

	/** 1. Find if there is a path between two vertices in a directed graph **/
	public List<List<V>> allPathsBetwnTwoVertex(Graph<V, W> g, int x, int y);

	public void collectPath(Graph<V, W> g, int[] path, int size, int x, int y, List<List<Integer>> list);

	/** 2. Connectivity in a directed graph **/
	public boolean isStronglyConnected(Graph<V, W> g);

	/** 3. Articulation Points (or Cut Vertices) in a Graph **/
	public List<Integer> articulationPoints(Graph<V, W> g);

	/** 4. Biconnected graph **/
	public boolean isCycleFromVertex(Graph<V, W> g, V v);

	public boolean isBiconnected(Graph<V, W> g);

	/** 5. Bridges in a graph **/
	public List<Edge> bridges(Graph<V, W> g);

	/** 6. Eulerian path and circuit **/
	public List<Integer> eulerianPath(Graph<V, W> g, V v);

	public boolean eulerianCircuit(Graph<V, W> g);

	/* 7. Fleury’s Algorithm for printing Eulerian Path or Circuit */
	/* 8. Strongly Connected Components */
	/* 9. Transitive closure of a graph */
	/* 10. Find the number of islands */
}
