package com.design.analysis.algo.greedyalgorithms.utils;

import java.util.LinkedList;
/*
 * @GuruG
 * 
 */
import java.util.List;
import java.util.Queue;

import com.design.analysis.algo.greedyalgorithms.node.Edge;
import com.design.analysis.algo.greedyalgorithms.node.GGNode;
import com.design.analysis.algo.greedyalgorithms.node.GreedyGraph;

public class GreedyGrapUtils {
	public GreedyGraph g = null;

	public static GreedyGraph init(int gSize) {
		return new GreedyGraph(gSize);
	}

	/* this is undirectional or bidirectional and weighted graph single edge */
	public static GreedyGraph addEdges(GreedyGraph g, Edge e) {

		GGNode srcHead = g.nt[e.src];
		GGNode destHead = g.nt[e.dest];
		/* for src to destination connection */

		if (srcHead == null) {
			g.nt[e.src] = new GGNode(e.dest, e.wt);
		} else {
			while (srcHead.next != null)
				srcHead = srcHead.next;
			srcHead.next = new GGNode(e.dest, e.wt);
		}
		/* for destination to src connection */
		if (destHead == null) {
			g.nt[e.dest] = new GGNode(e.src, e.wt);
		} else {
			while (destHead.next != null)
				destHead = destHead.next;
			destHead.next = new GGNode(e.src, e.wt);
		}

		return g;
	}

	/* this is undirectional or bidirectional and weighted grap */
	public static GreedyGraph addMassEdges(GreedyGraph g, List<Edge> el) {

		for (Edge e : el) {
			GGNode srcHead = g.nt[e.src];
			GGNode destHead = g.nt[e.dest];
			/* for src to destination connection */

			if (srcHead == null) {
				g.nt[e.src] = new GGNode(e.dest, e.wt);
			} else {
				while (srcHead.next != null)
					srcHead = srcHead.next;
				srcHead.next = new GGNode(e.dest, e.wt);
			}
			/* for destination to src connection */
			if (destHead == null) {
				g.nt[e.dest] = new GGNode(e.src, e.wt);
			} else {
				while (destHead.next != null)
					destHead = destHead.next;

				destHead.next = new GGNode(e.src, e.wt);
			}
		}
		return g;
	}

	/** is there cycle any form from given vertex non directed graph **/
	public static boolean isCycleFromVertex(GreedyGraph g, Integer intV, Integer v, int parent) {

		GGNode head = g.nt[v];
		if (head != null) {
			for (; head != null; head = head.next) {
				if (head.dest == parent)
					continue;
				if (intV == head.dest || isCycleFromVertex(g, intV, head.dest, v))
					return true;
			}
		}
		return false;
	}

	/* checking cycle in grapah non directed graph */
	public static boolean isCycleExists(GreedyGraph g) {

		for (int i = 0; i < g.gSize; i++) {
			if (isCycleFromVertex(g, i, i, i))
				return true;
		}
		return false;
	}

	/* display of graph */
	public static void display(GreedyGraph g) {

		GGNode head = null;
		for (int i = 0; i < g.gSize; i++) {

			head = g.nt[i];
			if (head != null) {
				System.out.print("g.nt[" + i + "]::=> ");
				for (; head != null; head = head.next)
					System.out.print(head.dest + "[" + head.wt + "]->");
				System.out.println();
			}
		}
	}

	/* delete node only from for non directed graph */
	public static GreedyGraph deleteNode(GreedyGraph g, int src, int dest) {

		g.nt[src] = deleteNodeInList(g.nt[src], dest);
		g.nt[dest] = deleteNodeInList(g.nt[dest], src);

		return g;
	}

	/* delete node from list */
	public static GGNode deleteNodeInList(GGNode head, int key) {
		GGNode p = head;
		GGNode prev = head;
		GGNode temp = null;
		if (head.dest == key) {
			temp = head;
			head = head.next;
			temp.next = null;
			temp = null;
		} else {
			for (; p != null; prev = p, p = p.next) {
				if (p.dest == key) {
					temp = p;
					prev.next = temp.next;
					temp.next = null;
					temp = null;
				}
			}
		}
		return head;
	}

	/* least cost edge connected form two sets of vertices...if connected */
	public static Edge minEdgeBtnTwoSets(GreedyGraph g, List<Integer> l1, List<Integer> l2) {

		int minWt = Integer.MAX_VALUE;
		int src = -1;
		int dest = -1;
		for (int i = 0; i < l1.size(); i++) {
			GGNode head = g.nt[l1.get(i)];
			if (head != null) {
				while (head != null) {
					if (l1.contains(head.dest)) {
						head = head.next;
						continue;
					}
					for (int j = 0; j < l2.size(); j++) {
						if (head.dest == l2.get(j) && minWt > head.wt) {
							src = l1.get(i);
							dest = l2.get(j);
							minWt = head.wt;
						}
					}
					head = head.next;
				}
			}
		}
		return minWt != Integer.MAX_VALUE ? new Edge(src, dest, minWt) : null;
	}

	/* check graph is connected */
	public static boolean connected(GreedyGraph g, int start) {

		boolean visited[] = new boolean[g.gSize];
		int V = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		V++;
		while (!queue.isEmpty()) {
			if (V == g.gSize)
				return true;
			int pollValue = queue.poll();
			if (g.nt[pollValue] != null) {
				GGNode head = g.nt[pollValue];

				while (head != null) {
					if (!visited[head.dest]) {
						visited[head.dest] = true;
						V++;
						queue.add(head.dest);
					}
					head = head.next;
				}
			}
		}
		return false;
	}
}
