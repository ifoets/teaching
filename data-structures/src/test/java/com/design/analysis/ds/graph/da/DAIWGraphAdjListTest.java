package com.design.analysis.ds.graph.da;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.graph.da.DAIWGraphAdjList;
import com.design.analysis.ds.graph.da.DAWGraphAdjListImpl;
import com.design.analysis.ds.graph.da.node.GraphWtLNode;

public class DAIWGraphAdjListTest {

	public DAIWGraphAdjList iwgl = null;

	@Before
	public void init() {
		iwgl = new DAWGraphAdjListImpl();
	}

	@Test
	public void addEdgeTest() {
		GraphWtLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = iwgl.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = iwgl.addEdge(g, i, srcDest[i][j], i + j);
			}
		}
		iwgl.printGraph(g);
	}

	@Test
	public void printBFTest() {
		GraphWtLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = iwgl.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = iwgl.addEdge(g, i, srcDest[i][j], i + j);
			}
		}
		System.out.println("\nBrith Firest search print start from 0 src");
		iwgl.printBFT(g, 0);

		System.out.println("\nBrith Firest search print end");
	}

	@Test
	public void printDFTTest() {
		GraphWtLNode g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = iwgl.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = iwgl.addEdge(g, i, srcDest[i][j], i + j);
			}
		}
		System.out.println("\nBrith Firest search print start from 0 src");
		iwgl.printDFT(g, 0);

		System.out.println("\nBrith Firest search print end");
	}
}
