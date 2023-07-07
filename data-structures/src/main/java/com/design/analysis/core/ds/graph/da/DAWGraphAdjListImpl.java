package com.design.analysis.core.ds.graph.da;

import java.util.LinkedList;
import java.util.Queue;

import com.design.analysis.core.ds.graph.da.node.GWLHeadNode;
import com.design.analysis.core.ds.graph.da.node.GWLNode;
import com.design.analysis.core.ds.graph.da.node.GraphWtLNode;

public class DAWGraphAdjListImpl implements DAIWGraphAdjList {

	@Override
	public GraphWtLNode initGraph(int v) {
		GraphWtLNode gwtlNode = new GraphWtLNode(v);
		return gwtlNode;
	}

	@Override
	public GraphWtLNode addEdge(GraphWtLNode g, int src, int dest, int wt) {

		GWLNode x = new GWLNode(dest, wt);
		GWLHeadNode head = g.t[src];
		if (head == null) {
			g.t[src] = new GWLHeadNode(src);
			g.t[src].next = x;
		} else {
			GWLNode p = head.next;
			for (; p.next != null; p = p.next)
				;
			p.next = x;
		}
		return g;
	}

	@Override
	public void printGraph(GraphWtLNode g) {

		for (int i = 0; i < g.vSize; i++) {
			System.out.print("\ng[" + i + "]=>");
			GWLNode head = g.t[i].next;
			for (; head != null; head = head.next)
				System.out.print("(" + head.v + ")[" + head.w + "][" + head.visited + "]->");
		}

	}

	@Override
	public void printBFT(GraphWtLNode g, int start) {
		int soucrIndex = searchSourceNodeIndex(g, start);
		if (soucrIndex == -1) {
			System.out.println(start + ": Source is not found:");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(soucrIndex);
		while (!queue.isEmpty()) {

			if (g.t[soucrIndex] != null) {
				GWLNode head = g.t[queue.poll()].next;

				while (head != null) {
					if (head.visited == false) {
						System.out.print(head.v + "->");
						queue.add(head.v);
						markVisited(g, head.v);// remove the cyclic visit
					}
					head = head.next;
				}
			}
		}
	}

	@Override
	public void printDFT(GraphWtLNode g, int start) {
		int soucrIndex = searchSourceNodeIndex(g, start);
		if (soucrIndex == -1) {
			System.out.println(start + ": Source is not found:");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(soucrIndex);
		while (!queue.isEmpty()) {

			if (g.t[soucrIndex] != null) {
				GWLNode head = g.t[queue.poll()].next;

				while (head != null) {
					if (head.visited == false) {
						System.out.print(head.v + "->");
						queue.add(head.v);
						markVisited(g, head.v);// remove the cyclic visit
						printDFT(g, head.v);// go to depth
					}
					head = head.next;
				}
			}
		}
	}

	@Override
	public void markVisited(GraphWtLNode g, int src) {

		GWLNode head = null;

		for (int i = 0; i < g.vSize; i++) {
			head = g.t[i].next;
			for (; head != null; head = head.next) {
				if (src == head.v)
					head.visited = true;
			}
		}
	}

	@Override
	public int searchSourceNodeIndex(GraphWtLNode g, int source) {

		if (source < g.vSize) {
			return source;
		} else
			return -1;
	}

}
