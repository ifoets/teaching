package com.design.analysis.ds.graph.da;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.graph.da.node.GraphTNode;

public class DAIGraphAdjTreeTest {

	DAIGraphAdjTree gat = null;

	@Before
	public void init() {
		gat = new DAGraphAdjTreeImpl();
	}

	@Test
	public void addEdgeTest() {
		GraphTNode g = null;

		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = gat.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = gat.addEdge(g, i, srcDest[i][j]);
			}
		}
		gat.printGraph(g);
	}
}
