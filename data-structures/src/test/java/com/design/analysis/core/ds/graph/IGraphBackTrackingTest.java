package com.design.analysis.core.ds.graph;

import java.util.List;

import com.design.analysis.core.ds.graph.node.Graph;
import com.design.analysis.core.ds.graph.utils.GraphUtils;
import com.design.analysis.core.ds.graph.utils.IGraphUtils;
import org.junit.Before;
import org.junit.Test;

public class IGraphBackTrackingTest {

	public IGraphBackTracking<Integer, Integer> ibt = null;
	public IGraphUtils<Integer, Integer> igu = null;

	@Before
	public void init() {
		ibt = new GraphBackTrackingImpl();
		igu = new GraphUtils();
	}

	@Test
	public void pathMoreThanKLenTest() {
		Graph<Integer, Integer> g = null;

		Integer[] src = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		Integer[] dest = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		Integer[] wt = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 1, 6, 7 };
		g = igu.initGraph(9);
		for (int i = 0; i < src.length; i++) {
			g = igu.addEdgeUnDir(g, src[i], dest[i], wt[i]);
		}
		List<List<Integer>> ll = ibt.pathMoreThanKLen(g, 0, 58);
		for (List<Integer> l : ll)
			System.out.println(l.toString());
		System.out.println("\nBrith first Traverse");
		igu.printGraph(g);
	}
}
