package com.design.analysis.algo.greedyalgorithms;

import java.util.List;

import com.design.analysis.algo.greedyalgorithms.node.GreedyGraph;

/*
 * 
 * @author GuruG
 * 
Greedy Algorithms in Graphs :
1.	Kruskal’s Minimum Spanning Tree
2.	Prim’s Minimum Spanning Tree
3.	Boruvka’s Minimum Spanning Tree
4.	Reverse delete algorithm for MST
5.	Dijkastra’s Shortest Path Algorithm
6.	Dial’s Algorithm
7.	Dijkstra’s Algorithm for Adjacency List Representation
8.	Prim’s MST for adjacency list representation

 */
public interface IGraphGreedyAlgo {

	/** 1. Kruskal’s Minimum Spanning Tree **/
	public GreedyGraph kruskalMinSpanningTree(GreedyGraph g);

	/** 2. Prim’s Minimum Spanning Tree **/
	public GreedyGraph primsMinSpanningTree(GreedyGraph g, int src);

	/** 3. Boruvka’s Minimum Spanning Tree **/
	public GreedyGraph boruvkasMinSpanningTree(GreedyGraph g);

	/** 4. Reverse delete algorithm for MST **/
	public GreedyGraph reverseDeleteMinSpanningTree(GreedyGraph g);

	/** 5. Dijkastra’s Shortest Path Algorithm **/
	public List<Integer> dijkastrasShortestPathAlgo(GreedyGraph g, int src, int dest);

}
