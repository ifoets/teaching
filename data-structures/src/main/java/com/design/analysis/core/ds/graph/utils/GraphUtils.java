/**
 * 
 */
package com.design.analysis.core.ds.graph.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.design.analysis.core.ds.graph.node.GLNode;
import com.design.analysis.core.ds.graph.node.Graph;

/**
 * @author @Gurug
 *
 */
public class GraphUtils implements IGraphUtils<Integer, Integer> {

	/** create the graph if not connect you may connect by 1 weight */
	public Graph<Integer, Integer> createGraph(List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		Set<Integer> set = new HashSet<>(gFrom);
		set.addAll(gTo);
		int size = set.size();
		Graph<Integer, Integer> g = initGraph(set.size());

		@SuppressWarnings("unchecked")
		GLNode<Integer, Integer>[] tails = new GLNode[size];
		GLNode<Integer, Integer>[] heads = g.gl;

		for (int i = 0; i < gFrom.size(); i++) {
			int x = gFrom.get(i);
			int y = gTo.get(i);
			int z = gWeight.get(i);

			GLNode<Integer, Integer> t = new GLNode<Integer, Integer>(y, z);

			if (heads[x] == null) {
				heads[x] = tails[x] = t;
			} else {
				tails[x].next = t;
				tails[x] = tails[x].next;
			}
		}
		// if there is no any connection then I connect with 1 weight
		for (int i = 0; i < size; i++) {
			boolean bool[] = new boolean[size];
			bool[i] = true;
			GLNode<Integer, Integer> head = heads[i];
			while (head != null) {
				bool[head.v] = true;
				head = head.next;
			}
			// connecting the not connected node with weight 1
			// same node should not connect with it self
			for (int j = 1; j < size; j++) { // j==1 since start node is zero and no need to connect another node with
												// zero sice it wil create cycle with start node
				if (!bool[j]) {
					if (heads[i] == null)// stop to connect start node from other node
						heads[i] = tails[i] = new GLNode<Integer, Integer>(j, 1);
					else {
						tails[i].next = new GLNode<Integer, Integer>(j, 1);
						tails[i] = tails[i].next;
					}
				}
			}
		}
		return g;
	}

	/**
	 * create the graph if not connect you may connect by 1 weight having i<j
	 * i-sourceand j-destination
	 */
	public Graph<Integer, Integer> createGraphConnect(List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		Set<Integer> set = new HashSet<>(gFrom);
		set.addAll(gTo);
		int size = set.size();
		Graph<Integer, Integer> g = initGraph(set.size());

		@SuppressWarnings("unchecked")
		GLNode<Integer, Integer>[] tails = new GLNode[size];
		GLNode<Integer, Integer>[] heads = g.gl;

		for (int i = 0; i < gFrom.size(); i++) {
			int x = gFrom.get(i);
			int y = gTo.get(i);
			int z = gWeight.get(i);

			GLNode<Integer, Integer> t = new GLNode<Integer, Integer>(y, z);

			if (heads[x] == null) {
				heads[x] = tails[x] = t;
			} else {
				tails[x].next = t;
				tails[x] = tails[x].next;
			}
		}
		// if there is no any connection s<d then I connect with 1 weight
		for (int i = 0; i < size; i++) {
			boolean bool[] = new boolean[size];
			bool[i] = true;
			GLNode<Integer, Integer> head = heads[i];
			while (head != null) {
				bool[head.v] = true;
				head = head.next;
			}
			// connecting the not connected node with weight 1
			// same node should not connect with it self
			for (int j = 1; j < size; j++) { // j==1 since start node is zero and no need to connect another node with

				if (!bool[j] && i < j) { // s<d(i<j)
					if (heads[i] == null)// stop to connect start node from other node
						heads[i] = tails[i] = new GLNode<Integer, Integer>(j, 1);
					else {
						tails[i].next = new GLNode<Integer, Integer>(j, 1);
						tails[i] = tails[i].next;
					}
				}
			}
		}
		return g;
	}

	/** 1. Graph and its representation **/
	@Override
	public Graph<Integer, Integer> initGraph(int v) {

		return new Graph<>(v);
	}

	/* print the graph */
	@Override
	public void printGraph(Graph<Integer, Integer> g) {

		for (int i = 0; i < g.vSize; i++) {
			System.out.print("\ng[" + i + "]=>");
			if (g.gl[i] != null) {
				GLNode<Integer, Integer> head = g.gl[i];
				for (; head != null; head = head.next) {
					System.out.print("(" + head.v + ")");
					if (head.wt != null)
						System.out.print("[" + head.wt + "]");
					System.out.print("->");
				}
			}
		}
	}

	/* add edge to directed and non weighted graph */
	@Override
	public Graph<Integer, Integer> addEdge(Graph<Integer, Integer> g, Integer src, Integer dest) {

		GLNode<Integer, Integer> x = new GLNode<Integer, Integer>(dest);
		if (g.gl[src] == null) {
			g.gl[src] = x;
		} else {
			GLNode<Integer, Integer> p = g.gl[src];
			for (; p.next != null; p = p.next)
				;
			p.next = x;
		}
		return g;
	}

	/* add edge to directed weighted graph */
	@Override
	public Graph<Integer, Integer> addEdge(Graph<Integer, Integer> g, Integer src, Integer dest, Integer wt) {

		GLNode<Integer, Integer> x = new GLNode<Integer, Integer>(dest, wt);
		if (g.gl[src] == null) {
			g.gl[src] = x;
		} else {
			GLNode<Integer, Integer> p = g.gl[src];
			for (; p.next != null; p = p.next)
				;
			p.next = x;
		}
		return g;
	}

	/* add edge to directed graph */
	@Override
	public Graph<Integer, Integer> addEdgeUnDir(Graph<Integer, Integer> g, Integer u, Integer v) {

		// add to v to u node
		GLNode<Integer, Integer> x = new GLNode<Integer, Integer>(v);
		if (g.gl[u] == null) {
			g.gl[u] = x;
		} else {
			GLNode<Integer, Integer> p = g.gl[u];
			for (; p.next != null; p = p.next)
				;
			p.next = x;
		}
		// add u to v node
		GLNode<Integer, Integer> y = new GLNode<Integer, Integer>(u);
		if (g.gl[v] == null) {
			g.gl[v] = y;
		} else {
			GLNode<Integer, Integer> p = g.gl[v];
			for (; p.next != null; p = p.next)
				;
			p.next = y;
		}
		return g;
	}

	/* add edge to undirected weighted graph */
	@Override
	public Graph<Integer, Integer> addEdgeUnDir(Graph<Integer, Integer> g, Integer u, Integer v, Integer wt) {
		// add to v to u node
		GLNode<Integer, Integer> x = new GLNode<Integer, Integer>(v, wt);
		if (g.gl[u] == null) {
			g.gl[u] = x;
		} else {
			GLNode<Integer, Integer> p = g.gl[u];
			for (; p.next != null; p = p.next)
				;
			p.next = x;
		}
		// add u to v node
		GLNode<Integer, Integer> y = new GLNode<Integer, Integer>(u, wt);
		if (g.gl[v] == null) {
			g.gl[v] = y;
		} else {
			GLNode<Integer, Integer> p = g.gl[v];
			for (; p.next != null; p = p.next)
				;
			p.next = y;
		}
		return g;
	}

	/* length of the list from source */
	@Override
	public int recursiveLenghtList(GLNode<Integer, Integer> head) {
		if (head == null)
			return 0;
		return 1 + recursiveLenghtList(head.next);
	}

	/* delete the node from the list */
	@Override
	public GLNode<Integer, Integer> deleteNodeFromSourcePath(Graph<Integer, Integer> g, Integer src, Integer v) {

		if (g.gl[src] != null) {

			GLNode<Integer, Integer> q = g.gl[src];
			GLNode<Integer, Integer> prev = g.gl[src];
			GLNode<Integer, Integer> temp = null;
			// if first node is matching
			if (g.gl[src].v == v) {
				temp = g.gl[src];
				g.gl[src] = temp.next;
				temp.next = null;
				temp = null;
			}
			for (; q != null; prev = q, q = q.next) {
				if (q.v == v) {
					temp = q;
					prev.next = q.next;
					temp.next = null;
					temp = null;
				}
			}
		}
		return g.gl[src];
	}

	/* delete the edge from graph */
	@Override
	public Graph<Integer, Integer> deleteEdge(Graph<Integer, Integer> g, Integer src, Integer dest) {

		g.gl[src] = deleteNodeInList(g.gl[src], dest);
		g.gl[dest] = deleteNodeInList(g.gl[dest], src);
		return g;
	}

	/* delete node form list */
	@Override
	public GLNode<Integer, Integer> deleteNodeInList(GLNode<Integer, Integer> head, Integer x) {

		if (head != null) {
			boolean isDeleted = false;
			GLNode<Integer, Integer> temp = null;
			GLNode<Integer, Integer> p = head;
			GLNode<Integer, Integer> prev = head;
			if (head.v.equals(x)) {
				temp = head;
				head = head.next;
				temp.next = null;
				temp = null;
				isDeleted = true;
			} else {
				p = p.next;
				for (; p != null; prev = p, p = p.next) {
					if (p.v.equals(x)) {
						temp = p;
						prev.next = p.next;
						temp.next = null;
						temp = null;
						p = prev;
						isDeleted = true;
					}
				}
			}
			if (isDeleted)
				System.out.println("Deleted:-" + x.toString());
			else
				System.out.println("Not found:-" + x.toString());
		}
		return head;
	}

	/* delete the node from graph */
	@Override
	public Graph<Integer, Integer> deleteNode(Graph<Integer, Integer> g, Integer arrV[]) {

		for (int i = 0; i < arrV.length; i++) {
			g.gl[arrV[i]] = null;
		}
		for (int j = 0; j < g.vSize; j++) {
			GLNode<Integer, Integer> head = g.gl[j];

			if (head != null) {
				for (int k = 0; k < arrV.length; k++) {
					g.gl[j] = deleteNodeFromSourcePath(g, j, arrV[k]);
				}
			}
		}
		return g;
	}

	/** Mark the visited node **/
	@Override
	public Graph<Integer, Integer> markVisited(Graph<Integer, Integer> g, Integer node) {
		GLNode<Integer, Integer> head = null;

		for (int i = 0; i < g.vSize; i++) {
			if (g.gl[i] != null) {
				head = g.gl[i];
				for (; head != null; head = head.next) {
					if (node == head.v)
						head.visited = true;
				}
			}
		}
		return g;
	}

	/** is there cycle any form from given vertex for directed graph **/
	@Override
	public boolean isCycleFromVertex(Graph<Integer, Integer> g, Integer v, boolean visited[]) {

		int currentParent[] = new int[g.vSize];
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		visited[v] = true;
		while (!que.isEmpty()) {
			int par = que.poll();
			GLNode<Integer, Integer> gn = g.gl[par];
			for (; gn != null; gn = gn.next) {
				currentParent[gn.v] = par;
				if (v.equals(gn.v) && currentParent[par] != gn.v)
					return true;
				if (!visited[gn.v]) {
					visited[gn.v] = true;
					que.add(gn.v);
				}
			}
		}
		return false;
	}

	/* is graph is connectd to all vertices */
	@Override // for non directional graph
	public boolean isConnected(Graph<Integer, Integer> g, Integer src) {
		boolean visited[] = new boolean[g.vSize];

		Queue<Integer> que = new LinkedList<>();
		GLNode<Integer, Integer> x = g.gl[src];
		que.add(src);
		visited[src] = true;
		while (!que.isEmpty()) {
			x = g.gl[que.poll()];
			for (; x != null; x = x.next)
				if (!visited[x.v]) {
					visited[x.v] = true;
					que.add(x.v);
				}
		}
		for (int i = 0; i < g.vSize; i++)
			if (!visited[i])
				return false;
		return true;
	}

	/* no of vertex connected with node */
	@Override
	public int degree(Graph<Integer, Integer> g, Integer src) {
		int count = 0;
		GLNode<Integer, Integer> x = g.gl[src];
		for (; x != null; count++, x = x.next)
			;
		return count;

	}
}
