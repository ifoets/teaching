package com.design.analysis.ds.graph.da;

import com.design.analysis.ds.graph.da.node.GTHeadNode;
import com.design.analysis.ds.graph.da.node.GTNode;
import com.design.analysis.ds.graph.da.node.GraphTNode;

public class DAGraphAdjTreeImpl implements DAIGraphAdjTree {

	@Override
	public GraphTNode initGraph(int v) {
		GraphTNode g = new GraphTNode(v);
		return g;
	}

	@Override
	public GraphTNode addEdge(GraphTNode g, int src, int dest) {

		GTNode x = new GTNode(dest);
		GTHeadNode head = g.t[src];
		if (head == null)
		{
			g.t[src] = new GTHeadNode(src);
			g.t[src].next = x;
		}
		else {
			g.t[src].next = createTree(g.t[src].next, dest);
		}
		return g;
	}

	@Override
	public GTNode createTree(GTNode node, int v) {
		if (node == null)
			node = new GTNode(v);
		else {
			if (v < node.v)
				node.lt = createTree(node.lt, v);
			else
				node.rt = createTree(node.rt, v);

		}
		return node;
	}

	public void printTree(GTNode node) {
		if (node != null) {
			printTree(node.lt);
			System.out.print(node.v + "->");
			printTree(node.rt);
		}
	}

	@Override
	public void printGraph(GraphTNode g) {
		for(int i=0;i<g.vSize;i++)
		{
			System.out.print("\ng["+i+"]=>");
			printTree(g.t[i].next);
		}
	}

	@Override
	public void printBFT(GraphTNode g, int start) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printDFT(GraphTNode g, int start) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markVisited(GraphTNode g, int node) {
		// TODO Auto-generated method stub

	}

	@Override
	public int searchSourceNodeIndex(GraphTNode g, int source) {
		// TODO Auto-generated method stub
		return 0;
	}

}
