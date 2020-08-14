package com.design.analysis.ds.graph.da;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.design.analysis.ds.graph.da.node.GLHeadNode;
import com.design.analysis.ds.graph.da.node.GLNode;
import com.design.analysis.ds.graph.da.node.GraphLNode;

public class DAGraphAdjListIml implements DAIGraphAdjList {

	@Override
	public GraphLNode initGraph(int v) {
		GraphLNode g = new GraphLNode(v);
		return g;
	}

	@Override
	public GraphLNode addEdge(GraphLNode g, int src, int dest) {

		GLNode x = new GLNode(dest);
		GLHeadNode head = g.t[src];
		if (head == null) {
			g.t[src] = new GLHeadNode(src);
			g.t[src].next = x;
		} else {
			GLNode p = head.next;
			for (; p.next != null; p = p.next)
				;
			p.next = x;
		}
		return g;
	}

	@Override
	public void printGraph(GraphLNode g) {
		for (int i = 0; i < g.vSize; i++) {
			System.out.print("\ng[" + i + "]=>");
			if (g.t[i] != null) {
				GLNode head = g.t[i].next;
				for (; head != null; head = head.next)
					System.out.print("(" + head.v + ")->");
			}
		}
	}

	@Override
	public void printBFT(GraphLNode g, int start) {
		int soucrIndex = searchSourceNodeIndex(g, start);
		if (soucrIndex == -1) {
			System.out.println(start + ": Source is not found:");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(soucrIndex);
		while (!queue.isEmpty()) {

			if (g.t[soucrIndex] != null) {

				int pollValue = queue.poll();
				if (g.t[pollValue] != null) {
					GLNode head = g.t[pollValue].next;

					while (head != null) {
						if (head.visited == false) {
							System.out.print(head.v + "->");
							queue.add(head.v);
							markVisited(g, head.v);// remove the cyclic
													// visit
						}
						head = head.next;
					}
				}

			}
		}

	}

	@Override
	public void printDFT(GraphLNode g, int start) {
		int soucrIndex = searchSourceNodeIndex(g, start);
		if (soucrIndex == -1) {
			System.out.println(start + ": Source is not found:");
			return;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(soucrIndex);
		while (!queue.isEmpty()) {

			if (g.t[soucrIndex] != null) {

				int pollValue = queue.poll();
				if (g.t[pollValue] != null) {
					GLNode head = g.t[pollValue].next;

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
	}

	@Override
	public void markVisited(GraphLNode g, int node) {
		GLNode head = null;

		for (int i = 0; i < g.vSize; i++) {
			if (g.t[i] != null) {
				if (g.t[i] != null) {
					head = g.t[i].next;
					for (; head != null; head = head.next) {
						if (node == head.v)
							head.visited = true;
					}
				}
			}
		}

	}

	@Override
	public int searchSourceNodeIndex(GraphLNode g, int source) {
		if (source < g.vSize) {
			return source;
		} else
			return -1;
	}

	List<Integer> list = null;

	@Override
	public List<Integer> lastVertexInDFT(GraphLNode g, int srcV) {
		if (list == null) {
			list = new ArrayList<>();
		}
		if (srcV > g.vSize) {

			System.out.println(srcV + " is not exists in given graph");
			return null;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(srcV);
		while (!queue.isEmpty()) {

			if (g.t[srcV] != null) {

				int pollValue = queue.poll();
				if (g.t[pollValue] != null) {
					GLNode head = g.t[pollValue].next;

					while (head != null) {
						if (head.visited == false) {
							// System.out.print(head.v + "->");
							list.add(head.v);
							queue.add(head.v);
							markVisited(g, head.v);// remove the cyclic visit
							lastVertexInDFT(g, head.v);// go to depth
						}
						head = head.next;
					}
				}
			}
		}
		return list;
	}

	@Override
	public int motherVertex(GraphLNode g) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < g.vSize; i++) {
			list.add(i);
		}

		List<Integer> listResult = null;

		for (int i = 0; i < g.vSize; i++) {
			listResult = new ArrayList<>();
			listResult.addAll(list);
			markUnVisitedAllNode(g);
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			while (!queue.isEmpty()) {
				int pollValue = queue.poll();
				if (g.t[i] != null) {
					if (g.t[pollValue] != null) {
						GLNode head = g.t[pollValue].next;

						while (head != null) {
							if (head.visited == false) {
								listResult.remove(head.v);
								queue.add(head.v);
								markVisited(g, head.v);// remove the visit
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

	public void markUnVisitedAllNode(GraphLNode g) {
		for (int i = 0; i < g.vSize; i++) {
			if (g.t[i] != null) {

				GLNode head = g.t[i].next;

				while (head != null) {
					if (head.visited == true)
						head.visited = false;
					head = head.next;
				}
			}
		}
	}

	// just delete link list node
	@Override
	public GLNode deleteNodeFromSourcePath(GLNode g, int v) {
		GLNode head = g;
		GLNode q = head;
		if (q.v == v) // ie first node
		{
			head = head.next;
			q = null;
		} else {
			for (; q.next.next != null; q = q.next) {
				if (q.next.v == v) {
					GLNode p = q.next;
					q.next = p.next;
					p.next = null;
					p = null;
				}
			}
			// check for last node
			if (q.next.v == v) {
				q.next = null;
			}
		}
		return head;
	}

	// assume vertices are exists in graph
	@Override
	public GraphLNode deleteNode(GraphLNode g, int arrV[]) {

		for (int i = 0; i < arrV.length; i++) {
			g.t[arrV[i]].next = null;
		}
		for (int j = 0; j < g.vSize; j++) {
			GLHeadNode head = g.t[j];

			if (head != null && head.next != null) {
				for (int k = 0; k < arrV.length; k++) {
					head.next = deleteNodeFromSourcePath(head.next, arrV[k]);
				}
			}
		}
		return g;
	}

	@Override
	public int recursiveLenghtList(GLNode head) {
		if (head == null)
			return 0;
		return 1 + recursiveLenghtList(head.next);
	}

	List<Integer> listDel = null;

	@Override
	public GraphLNode kCores(GraphLNode g, int k) {
		// first find the node who have less then k vertices connected
		if (listDel != null)
			listDel.removeAll(listDel);
		else
			listDel = new ArrayList<>();

		for (int i = 0; i < g.vSize; i++) {
			GLHeadNode head = g.t[i];
			if (head != null) {
				int len = recursiveLenghtList(head.next);
				if (len != 0 && k > len)
					listDel.add(i);
			}
		}
		int arrV[] = new int[listDel.size()];
		int j = 0;
		for (Integer inte : listDel)
			arrV[j++] = inte;

		if (listDel.size() > 0) {
			g = deleteNode(g, arrV);
			g = kCores(g, k);
		}

		return deleteNode(g, arrV);
	}
	
	@Override
	public boolean detectCycleDirectedGraph(GraphLNode g){
		
		for(int i=0;i<g.vSize;i++)
		{
			
		}
		return true;
	}
}
