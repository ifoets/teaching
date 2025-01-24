package com.design.analysis.core.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.algo.greedyalgorithms.node.Edge;
import com.design.analysis.core.algo.greedyalgorithms.node.GreedyGraph;
import com.design.analysis.core.algo.greedyalgorithms.utils.GreedyGrapUtils;
import org.junit.Before;
import org.junit.Test;

public class IGraphGreedyAlgoTest {

	public IGraphGreedyAlgo iga = null;

	@Before
	public void init() {
		iga = new GraphGreedyAlgoImpl();
	}

	/** 1. Kruskal s Minimum Spanning Tree **/
	@Test
	public void kruskalMinSpanningTreeTest() {

		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		g = iga.kruskalMinSpanningTree(g);
		GreedyGrapUtils.display(g);
	}

	/** 2. Prim s Minimum Spanning Tree **/
	@Test
	public void primsMinSpanningTreeTest() {
		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		GreedyGrapUtils.display(g);
		System.out.println("\nAfter prism minimum spanning  tree");
		g = iga.primsMinSpanningTree(g, 0);
		GreedyGrapUtils.display(g);
	}

	/** 3. Boruvka s Minimum Spanning Tree **/
	@Test
	public void boruvkasMinSpanningTreeTest() {
		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		g = iga.boruvkasMinSpanningTree(g);
		GreedyGrapUtils.display(g);
	}

	/** 4. Reverse delete algorithm for MST **/
	@Test
	public void reverseDeleteMinSpanningTreeTest() {

		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);
		g = iga.reverseDeleteMinSpanningTree(g);
		GreedyGrapUtils.display(g);
	}

	/** 5. Dijkastra s Shortest Path Algorithm **/
	// TODO by branch and bounding
	@Test
	public void dijkastrasShortestPathAlgoTest() {

	}
}
