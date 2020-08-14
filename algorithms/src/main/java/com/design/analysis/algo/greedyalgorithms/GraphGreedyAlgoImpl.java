package com.design.analysis.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import com.design.analysis.algo.greedyalgorithms.node.Edge;
import com.design.analysis.algo.greedyalgorithms.node.GGNode;
import com.design.analysis.algo.greedyalgorithms.node.GreedyGraph;
import com.design.analysis.algo.greedyalgorithms.utils.GreedyGrapUtils;

public class GraphGreedyAlgoImpl implements IGraphGreedyAlgo {

	/** 1. Kruskal’s Minimum Spanning Tree **/
	@Override
	public GreedyGraph kruskalMinSpanningTree(GreedyGraph g) {

		List<Edge> list = new ArrayList<>();
		Set<Edge> set = new HashSet<>();
		GGNode head = null;
		for (int i = 0; i < g.gSize; i++) {
			head = g.nt[i];
			if (head != null) {
				for (; head != null; head = head.next)
					set.add(new Edge(i, head.dest, head.wt));
			}
		}
		list.addAll(set);
		Collections.sort(list);

		// costruct the graph from extracted edge
		g = new GreedyGraph(g.gSize);

		int V = 0;
		for (Edge e : list) {
			if (V == g.gSize - 1)
				break;
			g = GreedyGrapUtils.addEdges(g, e);
			// since newly added edge only make the cycle
			boolean isCycle = GreedyGrapUtils.isCycleFromVertex(g, e.src, e.src, e.src)
					|| GreedyGrapUtils.isCycleFromVertex(g, e.dest, e.dest, e.dest);
			if (isCycle || GreedyGrapUtils.isCycleExists(g)) { // worst case
				g = GreedyGrapUtils.deleteNode(g, e.src, e.dest);
			} else
				V++;
		}
		return g;
	}

	/** 2. Prim’s Minimum Spanning Tree **/
	// here node of graps has been sorted order
	@Override
	public GreedyGraph primsMinSpanningTree(GreedyGraph g, int src) {
		// costruct the graph
		GreedyGraph gNew = new GreedyGraph(g.gSize);

		boolean visited[] = new boolean[g.gSize];
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
		// mark the initial vertex as visited
		visited[src] = true;

		// for every edge connected to the source, add it to the PriorityQueue
		GGNode p = g.nt[src];
		for (; p != null; p = p.next)
			priorityQueue.add(new Edge(src, p.dest, p.wt));

		// keep adding edges until the PriorityQueue is empty
		while (!priorityQueue.isEmpty()) {
			Edge x = priorityQueue.remove();

			// if we have already visited the opposite vertex, go to the next edge
			if (visited[x.dest]) {
				continue;
			}
			gNew = GreedyGrapUtils.addEdges(gNew, x);
			// mark the opposite vertex as visited
			visited[x.dest] = true;
			GGNode q = g.nt[x.dest];
			for (; q != null; q = q.next)
				priorityQueue.add(new Edge(x.dest, q.dest, q.wt));
		}
		return gNew;
	}

	/** 3. Boruvka’s Minimum Spanning Tree **/
	@Override
	public GreedyGraph boruvkasMinSpanningTree(GreedyGraph g) {
		GreedyGraph gn = new GreedyGraph(g.gSize);
		List<List<Integer>> ll = new ArrayList<>();
		List<Integer> l = null;
		for (int i = 0; i < g.gSize; i++) {
			l = new ArrayList<>();
			l.add(i);
			ll.add(l);
		}

		int srcInd = -1;
		int destInd = -1;
		int src = -1;
		int dest = -1;
		int minWt = Integer.MAX_VALUE;
		List<Edge> list = new ArrayList<>();
		for (int i = 0; i < ll.size() && ll.size() != 1; i = 0) {
			srcInd = -1;
			destInd = -1;
			src = -1;
			dest = -1;
			minWt = Integer.MAX_VALUE;
			for (int j = i + 1; j < ll.size() && ll.size() != 1; j++) {

				Edge e = GreedyGrapUtils.minEdgeBtnTwoSets(g, ll.get(i), ll.get(j));
				if (e != null && minWt > e.wt) {
					srcInd = i;
					destInd = j;
					src = e.src;
					dest = e.dest;
					minWt = e.wt;
				}
			}
			list.add(new Edge(src, dest, minWt));
			List<Integer> ln = ll.get(srcInd);
			ln.addAll(ll.get(destInd));
			ll.remove(destInd);
		}
		g = GreedyGrapUtils.addMassEdges(gn, list);
		return gn;
	}

	/** 4. Reverse delete algorithm for MST **/
	@Override
	public GreedyGraph reverseDeleteMinSpanningTree(GreedyGraph g) {

		List<Edge> list = new ArrayList<>();
		Set<Edge> set = new HashSet<>();
		GGNode head = null;
		for (int i = 0; i < g.gSize; i++) {
			head = g.nt[i];
			if (head != null) {
				for (; head != null; head = head.next)
					set.add(new Edge(i, head.dest, head.wt));
			}
		}
		list.addAll(set);
		Collections.sort(list);
		Collections.reverse(list);
		for (Edge e : list) {
			g = GreedyGrapUtils.deleteNode(g, e.src, e.dest);
			if (!GreedyGrapUtils.connected(g, e.src))
				g = GreedyGrapUtils.addEdges(g, e);
		}
		return g;
	}

	/** 5. Dijkastra’s Shortest Path Algorithm **/
	// TODO by branch and bounding
	public List<Integer> dijkastrasShortestPathAlgo(GreedyGraph g, int src, int dest) {

		return null;
	}
}
