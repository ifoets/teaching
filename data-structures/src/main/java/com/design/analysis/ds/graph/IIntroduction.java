/**
* 
*/
package com.design.analysis.ds.graph;

import java.util.Map;
import java.util.Stack;

import com.design.analysis.ds.graph.node.Graph;

/*
 * 
 * @author GuruG
 * 
 * 1.	Graph and its representations
2.	Breadth First Traversal for a Graph
3.	Depth First Traversal for a Graph
4.	Applications of Depth First Search
5.	Applications of Breadth First Traversal
6.	Longest Path in a Directed Acyclic Graph
7.	Find Mother Vertex in a Graph
8.	Transitive Closure of a Graph using DFS
9.	Find K cores of an undirected Graph
10.	Iterative Depth First Search
11.	Count the number of nodes at given level in a tree using BFS
12.	Count all possible paths between two vertices
13.	Minimum initial vertices to traverse whole matrix with given conditions
14.	Shortest path to reach one prime to other by changing single digit at a time
15.	Water Jug problem using BFS
16.	Magical Indices in an array
17.	Count number of trees in a forest
18.	BFS using vectors & queue as per the algorithm of CLRS
19.	Level of Each node in a Tree from source node
20.	Construct binary palindrome by repeated appending and trimming
21.	Iterative Deepening Search(IDS) or Iterative Deepening Depth First Search(IDDFS)

 */
public interface IIntroduction<V, W> {

	/** 1. Graph and its representation **/

	/* this is done in IGraphUtils.java */

	/** 2. Breadth First Traversal for a Graph **/
	public void printBFT(Graph<V, W> g, int start);// breath first travel

	/** 3. Depth First Traversal for a Graph **/
	public void printDFT(Graph<V, W> g, int start);// depth first travel

	/** 4. Applications of Depth First Search :separately discuss class **/

	/** 5. Applications of Breadth First Traversal::separately discuss class **/

	/** 6. Longest Path in a Directed Acyclic Graph **/

	public void topologicalSortUtil(Graph<V, W> g, int v, Stack<V> stack, boolean visited[]);

	/*
	 * directed edge uv, vertex u comes before v in the ordering. Topological
	 * Sorting
	 */
	public Stack<V> topologicalSort(Graph<V, W> g);

	public Map<V, W> longestpath(Graph<V, W> g, V s);

	/** 7. Find Mother Vertex in a Graph **/
	public V motherVertex(Graph<V, W> g);

	/** 8. Transitive Closure of a Graph using DFS **/
	public int[][] transitiveClosure(Graph<V, W> g);

	/** 9. Find K cores of an undirected Graph **/
	public Graph<V, W> kCores(Graph<V, W> g, int k);

	/** 10. Iterative Depth First Search **/
	// TODO did in lazy mood
	public void DFSIterative(Graph<V, W> g, V v);

	/** 11. Count the number of nodes at given level in a tree using BFS **/
	public int noOfNodeGienLevel(Graph<V, W> g, int src, int lev);

	/** 12. Count all possible paths between two vertices **/
	public int countPathsBetwnTwoVertex(Graph<V, W> g, int src, int dest);

	public void pathWisePrint(Graph<V, W> g, int[] path, int size, int src, int dest, int[] count);

	public void printArray(int[] arr, int size);
	/*
	 * 13. Minimum initial vertices to traverse whole matrix with given conditions
	 */
	/*
	 * 14. Shortest path to reach one prime to other by changing single digit at a
	 * time
	 */
	/* 15. Water Jug problem using BFS */
	/* 16. Magical Indices in an array */
	/* 17. Count number of trees in a forest */
	/* 18. BFS using vectors & queue as per the algorithm of CLRS */
	/* 19. Level of Each node in a Tree from source node */
	/* 20. Construct binary palindrome by repeated appending and trimming */
	/*
	 * 21. Iterative Deepening Search(IDS) or Iterative Deepening Depth First
	 * Search(IDDFS)
	 */
}
