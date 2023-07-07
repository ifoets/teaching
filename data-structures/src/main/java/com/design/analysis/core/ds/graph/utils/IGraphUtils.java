/**
 * 
 */
package com.design.analysis.core.ds.graph.utils;

import java.util.List;

import com.design.analysis.core.ds.graph.node.GLNode;
import com.design.analysis.core.ds.graph.node.Graph;

/**
 * @author @Gurug
 *
 */
public interface IGraphUtils<V, W> {

	/** create the graph if not connect you may connect by 1 weight */
	public Graph<Integer, Integer> createGraph(List<V> gFrom, List<V> gTo, List<W> gWeight);

	public Graph<Integer, Integer> createGraphConnect(List<V> gFrom, List<V> gTo, List<W> gWeight);

	/* initialize the graph */
	public Graph<Integer, Integer> initGraph(int v);

	/* print the graph */
	public void printGraph(Graph<V, W> g);

	/* add edge to directed and non weighted graph */
	public Graph<V, W> addEdge(Graph<V, W> g, V u, V v);

	/* add edge to directed weighted graph */
	public Graph<V, W> addEdge(Graph<V, W> g, V u, V v, W wt);

	/* add edge to directed graph */
	public Graph<V, W> addEdgeUnDir(Graph<V, W> g, V u, V v);

	/* add edge to directed weighted graph */
	public Graph<V, W> addEdgeUnDir(Graph<V, W> g, V u, V v, W wt);

	/* length of the list from source */
	public int recursiveLenghtList(GLNode<V, W> head);

	/* delete the node from the list */
	public GLNode<V, W> deleteNodeFromSourcePath(Graph<V, W> g, V u, V v);

	/* delete node form list */
	public GLNode<V, W> deleteNodeInList(GLNode<V, W> head, V v);

	/* delete the edge from graph */
	public Graph<V, W> deleteEdge(Graph<V, W> g, V u, V v);

	/* delete the node from graph */
	public Graph<V, W> deleteNode(Graph<V, W> g, V arrV[]);

	/* Mark the visited node */
	public Graph<V, W> markVisited(Graph<V, W> g, V v);

	/* is there cycle any form from given vertex */
	public boolean isCycleFromVertex(Graph<V, W> g, V v, boolean visited[]);

	/* is graph is connectd to all vertices */
	public boolean isConnected(Graph<V, W> g, V v);

	/* no of vertex connected with node */
	public int degree(Graph<V, W> g, V v);
}
