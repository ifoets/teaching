package com.design.analysis.core.ds.graph;

import java.util.List;
import java.util.Map;

import com.design.analysis.core.ds.graph.node.Graph;

/*
 * 
 * @author GuruG
 * 
1.	Dijkstra�s shortest path algorithm
2.	Dijkstra�s Algorithm for Adjacency List Representation
3.	Bellman�Ford Algorithm
4.	Floyd Warshall Algorithm
5.	Johnson�s algorithm for All-pairs shortest paths
6.	Shortest Path in Directed Acyclic Graph
7.	Some interesting shortest path questions,
8.	Shortest path with exactly k edges in a directed and weighted graph
9.	Dial�s Algorithm
10.	Printing paths in Dijsktra�s Algorithm
11.	Shortest path of a weighted graph where weight is 1 or 2

 */
public interface IShortestPath<V, W> {

	/** 1. Dijkstra�s shortest path algorithm **/
	public Map<Integer, List<Integer>> dijkstraShortestPath(Graph<V, W> g, V v);
	/* 2. Dijkstra�s Algorithm for Adjacency List Representation */
	/* 3. Bellman�Ford Algorithm */
	/* 4. Floyd Warshall Algorithm */
	/* 5. Johnson�s algorithm for All-pairs shortest paths */
	/* 6. Shortest Path in Directed Acyclic Graph */
	/* 7. Some interesting shortest path questions, */
	/* 8. Shortest path with exactly k edges in a directed and weighted graph */
	/* 9. Dial�s Algorithm */
	/* 10. Printing paths in Dijsktra�s Algorithm */
	/* 11. Shortest path of a weighted graph where weight is 1 or 2 */
}
