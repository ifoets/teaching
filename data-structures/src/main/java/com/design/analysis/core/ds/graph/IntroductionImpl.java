/**
 * 
 */
package com.design.analysis.core.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.design.analysis.core.ds.graph.node.GLNode;
import com.design.analysis.core.ds.graph.node.Graph;
import com.design.analysis.core.ds.graph.utils.GraphUtils;
import com.design.analysis.core.ds.graph.utils.IGraphUtils;

/**
 * @author @Gurug
 */
public class IntroductionImpl implements IIntroduction<Integer, Integer> {

	public IGraphUtils<Integer, Integer> igu = new GraphUtils();

	/** 1. Graph and its representation **/

	/* this is done in IGraphUtils.java */

	/** 2. Breadth First Traversal for a Graph **/
	@Override
	public void printBFT(Graph<Integer, Integer> g, int start) {

		if (start > g.vSize) {
			System.out.println(start + ": Source is not found:");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {

			if (g.gl[start] != null) {

				int pollValue = queue.poll();
				if (g.gl[pollValue] != null) {
					GLNode<Integer, Integer> head = g.gl[pollValue];

					while (head != null) {
						if (head.visited == false) {
							System.out.print(head.v + "->");
							queue.add(head.v);
							igu.markVisited(g, head.v);// remove the cyclic
							// visit
						}
						head = head.next;
					}
				}

			}
		}
	}

	/** 3. Depth First Traversal for a Graph **/
	@Override
	public void printDFT(Graph<Integer, Integer> g, int start) {

		if (start > g.vSize) {
			System.out.println(start + ": Source is not found:");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {

			if (g.gl[start] != null) {

				int pollValue = queue.poll();
				if (g.gl[pollValue] != null) {
					GLNode<Integer, Integer> head = g.gl[pollValue];

					while (head != null) {
						if (head.visited == false) {
							System.out.print(head.v + "->");
							queue.add(head.v);
							igu.markVisited(g, head.v);// remove the cyclic
							// visit
							printDFT(g, head.v);
						}
						head = head.next;
					}
				}

			}
		}
	}

	/** 4. Applications of Depth First Search :separately discuss class **/

	/** 5. Applications of Breadth First Traversal::separately discuss class **/

	/** 6. Longest Path in a Directed Acyclic Graph **/
	@Override
	public void topologicalSortUtil(Graph<Integer, Integer> g, int v, Stack<Integer> stack, boolean visited[]) {

		visited[v] = true;
		GLNode<Integer, Integer> head = g.gl[v];
		while (head != null) {
			if (!visited[head.v])
				topologicalSortUtil(g, head.v, stack, visited);
			head = head.next;
		}
		stack.push(v);
	}

	/*
	 * directed edge uv, vertex u comes before v in the ordering. Topological
	 * Sorting
	 */
	@Override
	public Stack<Integer> topologicalSort(Graph<Integer, Integer> g) {
		Stack<Integer> stack = new Stack<>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[g.vSize];
		for (int i = 0; i < g.vSize; i++)
			visited[i] = false;

		for (int i = 0; i < g.vSize; i++)
			if (!visited[i])
				topologicalSortUtil(g, i, stack, visited);
		return stack;
	}

	@Override
	public Map<Integer, Integer> longestpath(Graph<Integer, Integer> g, Integer s) {

		int dist[] = new int[g.vSize];

		Stack<Integer> stack = topologicalSort(g);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < g.vSize; i++)
			dist[i] = Integer.MIN_VALUE;
		dist[s] = 0;

		// Process vertices in topological order
		while (!stack.empty()) {
			// Get the next vertex from topological order
			int u = stack.pop();
			GLNode<Integer, Integer> head = null;
			if (dist[u] != Integer.MIN_VALUE) {
				for (head = g.gl[u]; head != null; head = head.next) {
					if (dist[head.v] < dist[u] + head.wt)
						dist[head.v] = dist[u] + head.wt;
					map.put(head.v, dist[head.v]);
				}

			}
		}
		return map;
	}

	/** 7. Find Mother Vertex in a Graph **/
	public Integer motherVertex(Graph<Integer, Integer> g) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < g.vSize; i++) {
			list.add(i);
		}

		boolean visited[] = null;
		List<Integer> listResult = null;

		for (int i = 0; i < g.vSize; i++) {

			listResult = new ArrayList<>();
			listResult.addAll(list);
			visited = new boolean[g.vSize];

			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			while (!queue.isEmpty()) {
				int pollValue = queue.poll();
				if (g.gl[i] != null) {
					if (g.gl[pollValue] != null) {
						GLNode<Integer, Integer> head = g.gl[pollValue];

						while (head != null) {
							if (head.visited == false) {
								listResult.remove(head.v);
								queue.add(head.v);
								visited[head.v] = true;
							}
							head = head.next;
						}
					}
				}
			}
			// source node is not deleted since from here we traversing
			if (listResult.size() == 1)
				return i;
		}
		return -1;
	}

	/** 8. Transitive Closure of a Graph using DFS **/
	@Override // TODO
	public int[][] transitiveClosure(Graph<Integer, Integer> g) {
		return null;
	}

	/** 9. Find K cores of an undirected Graph **/

	public List<Integer> listDel = null;

	@Override
	public Graph<Integer, Integer> kCores(Graph<Integer, Integer> g, int k) {

		// first find the node who have less then k vertices connected
		if (listDel != null)
			listDel.removeAll(listDel);
		else
			listDel = new ArrayList<>();

		for (int i = 0; i < g.vSize; i++) {
			GLNode<Integer, Integer> head = g.gl[i];
			if (head != null) {
				int len = igu.recursiveLenghtList(head);
				if (len != 0 && k > len)
					listDel.add(i);
			}
		}
		Integer arrV[] = new Integer[listDel.size()];
		int j = 0;
		for (Integer inte : listDel)
			arrV[j++] = inte;

		if (listDel.size() > 0) {
			g = igu.deleteNode(g, arrV);
			g = kCores(g, k);
		}

		return igu.deleteNode(g, arrV);
	}

	/** 10. Iterative Depth First Search **/
	@Override
	public void DFSIterative(Graph<Integer, Integer> g, Integer src) {

		boolean visited[] = new boolean[g.vSize];
		if (g.gl[src] != null) {
			Queue<Integer> qu = new LinkedList<>();
			qu.add(src);
			while (!qu.isEmpty()) {
				Integer vtx = qu.poll();
				GLNode<Integer, Integer> p = g.gl[vtx];
				if (!visited[vtx]) {
					visited[vtx] = true;
					System.out.print(vtx + "->");
				}
				for (; p != null; p = p.next) {
					if (!visited[p.v])
						qu.add(p.v);
				}
			}
		}
	}

	/** 11. Count the number of nodes at given level in a tree using BFS **/
	@Override
	public int noOfNodeGienLevel(Graph<Integer, Integer> g, int src, int l) {

		boolean visited[] = new boolean[g.vSize];
		int levl[] = new int[g.vSize];
		Queue<Integer> que = new LinkedList<>();

		que.add(src);// s
		levl[src] = 0;
		visited[src] = true;
		while (!que.isEmpty()) {
			int x = que.poll();

			for (GLNode<Integer, Integer> p = g.gl[x]; p != null; p = p.next) {
				if (!visited[p.v]) {
					levl[p.v] = levl[x] + 1;
					visited[p.v] = true;
					que.add(p.v);
				}
			}
		}
		int count = 0;
		for (int i = 0; i < levl.length; i++) {
			if (levl[i] == l)
				count++;
		}
		return count;
	}

	/** 12. Count all possible paths between two vertices **/
	@Override
	public int countPathsBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y) {

		if (g == null) {
			return 0;
		}
		int[] path = new int[20];
		int count[] = new int[1];
		pathWisePrint(g, path, 0, x, y, count);
		return count[0];
	}

	@Override
	public void pathWisePrint(Graph<Integer, Integer> g, int[] path, int size, int x, int y, int[] count) {
		path[size++] = x;
		if (x == y) {
			count[0]++;
			printArray(path, size);
		} else {
			for (GLNode<Integer, Integer> p = g.gl[x]; p != null; p = p.next) {
				pathWisePrint(g, path, size, p.v, y, count);
			}
		}
	}

	@Override
	public void printArray(int[] a, int size) {
		int i = 0;
		while (i < size) {
			System.out.print(a[i] + "->");
			++i;
		}
		System.out.println();
	}
}
