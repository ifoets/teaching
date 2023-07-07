package com.design.analysis.core.ds.graph;

import java.util.List;

import com.design.analysis.core.ds.graph.node.Graph;
import com.design.analysis.core.ds.graph.utils.GraphUtils;
import com.design.analysis.core.ds.graph.utils.IGraphUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IConnectivityTest {

	public IConnectivity<Integer, Integer> icv = null;
	public IGraphUtils<Integer, Integer> igu = null;

	@Before
	public void init() {
		icv = new ConnectivityImpl();
		igu = new GraphUtils();
	}

	/** 1. Find if there is a path between two vertices in a directed graph **/
	@Test
	public void allPathsBetwnTwoVertexTest() {
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
		List<List<Integer>> ll = icv.allPathsBetwnTwoVertex(g, 0, 2);
		Assert.assertTrue(ll.size() == 5);
	}

	/** 2. Connectivity in a directed graph **/
	@Test
	public void isStronglyConnectedTest() {
		Graph<Integer, Integer> g = igu.initGraph(6);
		igu.addEdge(g, 0, 1);
		igu.addEdge(g, 1, 2);
		igu.addEdge(g, 2, 3);
		igu.addEdge(g, 3, 4);
		igu.addEdge(g, 4, 5);
		igu.addEdge(g, 5, 0);
		// igu.printGraph(g);

		Assert.assertTrue(icv.isStronglyConnected(g));

		g = igu.initGraph(4);
		igu.addEdge(g, 0, 1);
		igu.addEdge(g, 1, 2);
		igu.addEdge(g, 2, 3);
		igu.addEdge(g, 1, 0);
		igu.addEdge(g, 2, 0);
		Assert.assertTrue(!icv.isStronglyConnected(g));

	}

	/** 4. Biconnected graph **/
	@Test
	public void isCycleFromVertexTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 0, 3);
		igu.addEdgeUnDir(g, 3, 4);
		igu.addEdgeUnDir(g, 3, 2);

		Assert.assertTrue(icv.isCycleFromVertex(g, 0));
		Assert.assertTrue(icv.isCycleFromVertex(g, 1));
		Assert.assertTrue(icv.isCycleFromVertex(g, 2));
		Assert.assertTrue(icv.isCycleFromVertex(g, 3));
		Assert.assertTrue(!icv.isCycleFromVertex(g, 4));
	}

	// it must make cicyle from all vertex if v.size>2
	@Test
	public void isBiconnectedTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 0, 3);
		igu.addEdgeUnDir(g, 3, 4);
		igu.addEdgeUnDir(g, 3, 2);

		Assert.assertTrue(!icv.isBiconnected(g));
		igu.addEdgeUnDir(g, 4, 2);
		Assert.assertTrue(icv.isBiconnected(g));

	}

	/** 5. Bridges in a graph **/
	@Test
	public void bridgesTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 2, 3);
		igu.addEdgeUnDir(g, 3, 4);

		Assert.assertTrue(icv.bridges(g).size() == 2);
	}

	/** 6. Eulerian path and circuit **/
	@Test
	public void eulerianPath() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 2, 3);
		igu.addEdgeUnDir(g, 3, 4);
		List<Integer> list = icv.eulerianPath(g, 4);
		System.out.println(list.toString());
	}

	@Test
	public void eulerianCircuitTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 2, 3);
		igu.addEdgeUnDir(g, 3, 4);

		Assert.assertTrue(!icv.eulerianCircuit(g));
		igu.addEdgeUnDir(g, 2, 4);
		Assert.assertTrue(icv.eulerianCircuit(g));
	}
}
