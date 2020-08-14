package com.design.analysis.algo.greedyalgorithms.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.design.analysis.algo.greedyalgorithms.utils.GreedyGrapUtils;

public class EdgeTest {

	@Test
	public void hashCodeTest() {

		Edge e1 = new Edge(1, 2, 2);
		Edge e2 = new Edge(2, 1, 2);
		Assert.assertTrue(e1.hashCode() == e2.hashCode());
	}

	@Test
	public void EqualsTest() {
		Edge e1 = new Edge(1, 2, 2);
		Edge e2 = new Edge(2, 1, 2);
		Assert.assertTrue(e1.equals(e2));
	}

	@Test
	public void edgeTest() {
		GreedyGraph g = new GreedyGraph(9);
		List<Edge> el = new ArrayList<>();
		int src[] = { 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7 };
		int dest[] = { 1, 7, 2, 7, 3, 5, 8, 4, 5, 5, 6, 7, 8, 8 };
		int wt[] = { 4, 8, 8, 11, 7, 4, 2, 9, 14, 10, 2, 6, 1, 7 };

		for (int i = 0; i < src.length; i++)
			el.add(new Edge(src[i], dest[i], wt[i]));
		g = GreedyGrapUtils.addMassEdges(g, el);

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
		System.out.println(set.size() == 5);
		for (Edge e : list)
			System.out.println(e.toString());
	}
}
