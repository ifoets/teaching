package com.design.analysis.algo.greedyalgorithms.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.greedyalgorithms.GraphGreedyAlgoImpl;
import com.design.analysis.algo.greedyalgorithms.IGraphGreedyAlgo;
import com.design.analysis.algo.greedyalgorithms.node.Edge;
import com.design.analysis.algo.greedyalgorithms.node.GreedyGraph;

public class GreedyGrapUtilsTest {

	public IGraphGreedyAlgo iga = null;

	@Before
	public void init() {
		iga = new GraphGreedyAlgoImpl();
	}

	@Test
	public void addMassEdgesTest() {

		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		GreedyGrapUtils.display(g);
	}

	/** is there cycle any form from given vertex **/
	@Test
	public void isCycleFromVertexTest() {

		GreedyGraph g = new GreedyGraph(3);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1 };
		int dest[] = { 1, 2, 2 };
		int wt[] = { 4, 8, 8 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		GreedyGrapUtils.display(g);
		Assert.assertTrue(GreedyGrapUtils.isCycleFromVertex(g, 0, 0, 0));
		Assert.assertTrue(GreedyGrapUtils.isCycleFromVertex(g, 1, 1, 1));
		Assert.assertTrue(GreedyGrapUtils.isCycleFromVertex(g, 2, 2, 2));

	}

	/* checking cycle in grapah non directed graph */
	@Test
	public void isCycleExistsTest() {
		GreedyGraph g = new GreedyGraph(5);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 2, 2, 3 };
		int dest[] = { 1, 2, 3, 4, 4 };
		int wt[] = { 4, 8, 8, 2, 4 };

		List<Edge> el1 = new ArrayList<>();
		int src1[] = { 0, 0, 2, 2 };
		int dest1[] = { 1, 2, 3, 4 };
		int wt1[] = { 4, 8, 8, 2 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		Assert.assertTrue(GreedyGrapUtils.isCycleExists(g));

		g = new GreedyGraph(5);
		for (int i = 0; i < src1.length; i++)
			el.add(new Edge(src1[i], dest1[i], wt1[i]));
		g = GreedyGrapUtils.addMassEdges(g, el1);

		Assert.assertTrue(!GreedyGrapUtils.isCycleExists(g));

		g = new GreedyGraph(9);
		List<Edge> el2 = new ArrayList<>();
		int src2[] = { 0, 2, 2, 5, 6, 6, 7 };
		int dest2[] = { 1, 3, 8, 6, 7, 8, 8 };
		int wt2[] = { 4, 7, 2, 2, 6, 6, 7 };

		for (int i = 0; i < src2.length; i++)
			el2.add(new Edge(src2[i], dest2[i], wt2[i]));
		g = GreedyGrapUtils.addMassEdges(g, el2);
		System.out.println(GreedyGrapUtils.isCycleExists(g));
		// System.out.println(GreedyGrapUtils.isCycleFromVertex(g, 2, 2, 2));
	}

	/* delete node only from for non directed graph */
	@Test
	public void deleteNodeTest() {
		GreedyGraph g = new GreedyGraph(5);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 2, 2, 3 };
		int dest[] = { 1, 2, 3, 4, 4 };
		int wt[] = { 4, 8, 8, 2, 4 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		Assert.assertTrue(GreedyGrapUtils.isCycleExists(g));

		g = GreedyGrapUtils.deleteNode(g, 3, 4);
		Assert.assertTrue(!GreedyGrapUtils.isCycleExists(g));
	}

	/* least cost edge connected form two sets of vertices...if connected */
	@Test
	public void minEdgeBtnTwoSetsTest() {
		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		//GreedyGrapUtils.display(g);

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.add(0);

		l1.add(1);
		l1.add(2);

		l2.add(3);
		l2.add(5);
		l2.add(7);
		l2.add(8);

		Edge e = GreedyGrapUtils.minEdgeBtnTwoSets(g, l1, l2);
		Assert.assertTrue(e.wt == 2 && e.src == 2 && e.dest == 8);

		l1 = new ArrayList<>();
		l2 = new ArrayList<>();
		l1.add(0);
		for(int i=1;i<g.gSize;i++)
			l2.add(i);
	}

	@Test
	public void connectedTest() {
		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		g = iga.boruvkasMinSpanningTree(g);
		// GreedyGrapUtils.display(g);
		// g = GreedyGrapUtils.deleteNode(g, 1, 2);
		for (int i = 0; i < g.gSize; i++)
			Assert.assertTrue(GreedyGrapUtils.connected(g, i));
		g = GreedyGrapUtils.deleteNode(g, 2, 8);
		System.out.println();
		for (int i = 0; i < g.gSize; i++)
			Assert.assertTrue(!GreedyGrapUtils.connected(g, i));
	}
}
