package com.design.analysis.ds.graph.da;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.design.analysis.ds.graph.da.DAGraphAdjListIml;
import com.design.analysis.ds.graph.da.DAIGraphAdjList;
import com.design.analysis.ds.graph.da.node.GLNode;
import com.design.analysis.ds.graph.da.node.GraphLNode;

public class DAIGraphAdjListTest {

	DAIGraphAdjList igal = null;

	@Before
	public void init() {
		igal = new DAGraphAdjListIml();
	}

	@Test
	public void addEdgeTest() {
		GraphLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		igal.printGraph(g);
	}

	@Test
	public void printBFTest() {
		GraphLNode g = null;
		int srcDest[][] = { { 1, 2 }, { 3 }, {}, {}, { 1 }, { 6, 2 }, { 0, 4 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		System.out.println("\nBrith Firest search print start from 0 src");
		igal.printBFT(g, 0);

		System.out.println("\nBrith Firest search print end");
	}

	@Test
	public void printDFTTest() {
		GraphLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		System.out.println("\nBrith Firest search print start from 0 src");
		igal.printDFT(g, 0);

		System.out.println("\nBrith Firest search print end");
	}

	@Test
	public void lastVertexInDFTTest() {
		GraphLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		// System.out.println("\nLast vertex Depth Firest search print start
		// from 0 src");
		// igal.printDFT(g, 0);
		System.out.println("\nLast vertex in des when search from " + 0 + "::>" + igal.lastVertexInDFT(g, 0));

		System.out.println("\nLast vertex Depth Firest search print end");
	}

	@Test
	@Ignore //TODO
	public void motherVertexTest() {
		GraphLNode g = null;
		int srcDest[][] = { { 1, 2 }, { 3 }, {}, {}, { 1 }, { 2, 6 }, { 0, 4 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		igal.printGraph(g);
		Assert.assertTrue(igal.motherVertex(g) == 5);
	}

	@Test
	public void deleteNodeFromSourcePathTest() {
		System.out.println("\n delete the one node from path start");
		GraphLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		igal.printGraph(g);
		System.out.println();
		GLNode delete = igal.deleteNodeFromSourcePath(g.t[0].next, 3);
		g.t[0].next = delete;

		GLNode delete1 = igal.deleteNodeFromSourcePath(g.t[1].next, 0);
		g.t[1].next = delete1;

		GLNode delete2 = igal.deleteNodeFromSourcePath(g.t[2].next, 3);
		g.t[2].next = delete2;
		Assert.assertTrue(g.t[0].next.next.v == 4);
		Assert.assertTrue(g.t[1].next.v == 2);
		Assert.assertTrue(g.t[2].next.v == 1);
		System.out.println("\n delete the one node from path start");
	}

	@Test
	public void deleteNodeTest() {

		System.out.println("\n delete the node start");
		GraphLNode g = null;
		int srcDest[][] = { { 1, 2 }, { 0, 2, 5 }, { 0, 1, 5, 6, 4, 3 }, { 2, 4, 6, 7 }, { 2, 3, 6, 8 }, { 1, 2, 6, 8 },
				{ 7, 8, 5, 2, 4, 3 }, { 3, 4, 6 }, { 6, 5 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		// igal.printGraph(g);
		System.out.println("Node 0,1,5,8 have been deleted");
		int arrV[] = { 0, 1, 5, 8 };
		g = igal.deleteNode(g, arrV);
		Assert.assertTrue(g.t[0].next == null && g.t[1].next == null && g.t[8].next == null && g.t[5].next == null);
		Assert.assertTrue(g.t[2].next.v == 6);
		Assert.assertTrue(g.t[6].next.next.v == 2);
		// igal.printGraph(g);

		System.out.println("\n delete the node from end");
	}

	@Test
	public void kCoresTest() {

		System.out.println("\n kCores start");
		GraphLNode g = null;
		int srcDest[][] = { { 1, 2 }, { 0, 2, 5 }, { 0, 1, 5, 6, 4, 3 }, { 2, 4, 6, 7 }, { 2, 3, 6, 8 }, { 1, 2, 6, 8 },
				{ 7, 8, 5, 2, 4, 3 }, { 3, 4, 6 }, { 6, 5 } };
		g = igal.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igal.addEdge(g, i, srcDest[i][j]);
			}
		}
		igal.kCores(g, 3);
		igal.printGraph(g);

		System.out.println("\n kCores end");
	}
}
