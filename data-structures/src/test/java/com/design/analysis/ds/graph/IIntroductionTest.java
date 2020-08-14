/**
 * 
 */
package com.design.analysis.ds.graph;

import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.graph.node.Graph;
import com.design.analysis.ds.graph.utils.GraphUtils;
import com.design.analysis.ds.graph.utils.IGraphUtils;

/**
 * @author @Gurug
 *
 */
public class IIntroductionTest {

	public IIntroduction<Integer, Integer> iit = null;

	public IGraphUtils<Integer, Integer> igu = null;

	@Before
	public void init() {
		iit = new IntroductionImpl();
		igu = new GraphUtils();
	}

	/** 1. Graph and its representation **/

	/* this is done in IGraphUtils.java */

	/** 2. Breadth First Traversal for a Graph **/
	@Test
	public void printBFTTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		System.out.println("\nBrith first Traverse");
		iit.printBFT(g, 0);
	}

	/** 3. Depth First Traversal for a Graph **/
	@Test
	public void printDFTTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		System.out.println("\nDepth first Traverse");
		iit.printDFT(g, 0);
	}

	/** 4. Applications of Depth First Search :separately discuss class **/

	/** 5. Applications of Breadth First Traversal::separately discuss class **/

	/** 6. Longest Path in a Directed Acyclic Graph **/
	@Test
	public void topologicalSortTest() {
		Graph<Integer, Integer> g = igu.initGraph(6);
		g = igu.addEdge(g, 5, 2);
		igu.addEdge(g, 5, 0);
		igu.addEdge(g, 4, 0);
		igu.addEdge(g, 4, 1);
		igu.addEdge(g, 2, 3);
		igu.addEdge(g, 3, 1);

		Stack<Integer> result = iit.topologicalSort(g);
		// 5->4->2->3->1->0->
		/*
		 * while (!result.empty()) System.out.print(result.pop() + "->");
		 */
		Assert.assertTrue(result.pop() == 5);
		Assert.assertTrue(result.pop() == 4);
		Assert.assertTrue(result.pop() == 2);
	}

	@Test
	public void longestpathTest() {

		Graph<Integer, Integer> g = igu.initGraph(6);
		igu.addEdge(g, 0, 1, 5);
		igu.addEdge(g, 0, 2, 3);
		igu.addEdge(g, 1, 3, 6);
		igu.addEdge(g, 1, 2, 2);
		igu.addEdge(g, 2, 4, 4);
		igu.addEdge(g, 2, 5, 2);
		igu.addEdge(g, 2, 3, 7);
		igu.addEdge(g, 3, 5, 1);
		igu.addEdge(g, 3, 4, -1);
		igu.addEdge(g, 4, 5, -2);

		Map<Integer, Integer> map = iit.longestpath(g, 1);
		Assert.assertTrue(map.get(2) == 2);
		Assert.assertTrue(map.get(3) == 9);
		Assert.assertTrue(map.get(4) == 8);
		Assert.assertTrue(map.get(5) == 10);
	}

	/** 7. Find Mother Vertex in a Graph **/
	@Test
	public void motherVertexTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 2 }, { 3 }, {}, {}, { 1 }, { 2, 6 }, { 0, 4 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		// igu.printGraph(g);
		Assert.assertTrue(iit.motherVertex(g) == 5);
	}

	/** 8. Transitive Closure of a Graph using DFS **/
	@Test
	public void transitiveClosureTest() {

	}

	/** 9. Find K cores of an undirected Graph **/

	@Test
	public void kCoresTest() {

		System.out.println("\n kCores start");
		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 2 }, { 0, 2, 5 }, { 0, 1, 5, 6, 4, 3 }, { 2, 4, 6, 7 }, { 2, 3, 6, 8 }, { 1, 2, 6, 8 },
				{ 7, 8, 5, 2, 4, 3 }, { 3, 4, 6 }, { 6, 5 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		iit.kCores(g, 3);
		igu.printGraph(g);

		System.out.println("\n kCores end");
	}

	/** 10. Iterative Depth First Search **/
	@Test
	public void DFSIterativeTest() {
		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		igu.printGraph(g);
		System.out.println();
		iit.DFSIterative(g, 0);
	}

	/** 11. Count the number of nodes at given level in a tree using BFS **/
	@Test
	public void noOfNodeGienLevelTest() {
		Graph<Integer, Integer> g = igu.initGraph(6);
		igu.addEdge(g, 0, 1);
		igu.addEdge(g, 0, 2);
		igu.addEdge(g, 1, 3);
		igu.addEdge(g, 2, 4);
		igu.addEdge(g, 2, 5);
		igu.printGraph(g);
		Assert.assertTrue(iit.noOfNodeGienLevel(g, 0, 2) == 3);
	}

	/** 12. Count all possible paths between two vertices **/
	@Test
	public void countPathsBetwnTwoVertexTest() {
		Graph<Integer, Integer> g = igu.initGraph(6);
		igu.addEdge(g, 0, 1);
		igu.addEdge(g, 0, 2);
		igu.addEdge(g, 0, 3);
		igu.addEdge(g, 1, 2);
		igu.addEdge(g, 1, 4);

		igu.addEdge(g, 3, 4);
		igu.addEdge(g, 3, 2);
		igu.addEdge(g, 4, 2);
		// igu.printGraph(g);
		// System.out.println();
		Assert.assertTrue(iit.countPathsBetwnTwoVertex(g, 0, 2) == 5);
	}
}
