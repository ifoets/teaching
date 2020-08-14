/**
 * 
 */
package com.design.analysis.ds.graph.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.graph.ConnectivityImpl;
import com.design.analysis.ds.graph.IConnectivity;
import com.design.analysis.ds.graph.node.GLNode;
import com.design.analysis.ds.graph.node.Graph;

/**
 * @author @Gurug
 *
 */
public class IGraphUtilsTest {

	public IGraphUtils<Integer, Integer> igu = null;
	public IConnectivity<Integer, Integer> icv = null;

	@Before
	public void init() {
		igu = new GraphUtils();
		icv = new ConnectivityImpl();
	}

	/** create the graph if not connect you may connect by 1 weight */
	@Test
	public void createGraphTest() {

		List<Integer> gFrom = new ArrayList<>(Arrays.asList(0, 1, 0, 0));
		List<Integer> gTo = new ArrayList<>(Arrays.asList(1, 0, 2, 3));
		List<Integer> gWeight = new ArrayList<>(Arrays.asList(3, 3, 2, 5));
		igu.printGraph(igu.createGraph(gFrom, gTo, gWeight));
	}

	@Test
	public void createGraphConnectTest() {
		List<Integer> gF = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 2));
		List<Integer> gT = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 4, 4));
		List<Integer> gW = new ArrayList<>(Arrays.asList(2, 5, 6, 7, 2, 5, 4));
		igu.printGraph(igu.createGraphConnect(gF, gT, gW));
	}

	/* initialize the graph */
	@Test
	public void initGraphTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		Assert.assertTrue(g.vSize == 5);
	}

	/* print the graph */
	@Test
	public void printGraphTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		/*
		 * igu.printGraph(g); g[0]=>(1)->(4)->(3)-> g[1]=>(0)->(2)->(3)->
		 * g[2]=>(1)->(3)-> g[3]=>(2)->(4)->(0)-> g[4]=>(0)->(3)->(1)->
		 */
	}

	/* add edge to directed and non weighted graph */
	@Test
	public void addEdgeTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		Assert.assertTrue(g.gl[0].v == 1);
		Assert.assertTrue(g.gl[0].next.next.v == 3);

		Assert.assertTrue(g.gl[2].next.v == 3);
		Assert.assertTrue(g.gl[2].next.next == null);

		Assert.assertTrue(g.gl[4].next.v == 3);
		Assert.assertTrue(g.gl[4].next.next.v == 1);

	}

	/* add edge to directed weighted graph */
	@Test
	public void addEdgeWeightedTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j], i + j);
			}
		}
		// igu.printGraph(g);
		Assert.assertTrue(g.gl[0].wt == 0);
		Assert.assertTrue(g.gl[0].next.next.wt == 2);

		Assert.assertTrue(g.gl[2].next.wt == 3);
		Assert.assertTrue(g.gl[2].next.next == null);

		Assert.assertTrue(g.gl[4].next.wt == 5);
		Assert.assertTrue(g.gl[4].next.next.wt == 6);
	}

	/* add edge to directed graph */
	@Test
	public void addEdgeUnDirTest() {
		Graph<Integer, Integer> g = null;

		g = igu.initGraph(5);
		g = igu.addEdgeUnDir(g, 1, 0);
		g = igu.addEdgeUnDir(g, 0, 2);
		g = igu.addEdgeUnDir(g, 2, 1);
		g = igu.addEdgeUnDir(g, 0, 3);
		g = igu.addEdgeUnDir(g, 3, 4);

		/*
		 * igu.printGraph(g); g[0]=>(1)->(2)->(3)-> g[1]=>(0)->(2)-> g[2]=>(0)->(1)->
		 * g[3]=>(0)->(4)-> g[4]=>(3)->
		 */

		Assert.assertTrue(g.gl[0].v == 1);
		Assert.assertTrue(g.gl[0].next.v == 2);

		Assert.assertTrue(g.gl[2].v == 0);
		Assert.assertTrue(g.gl[2].next.v == 1);

		Assert.assertTrue(g.gl[3].v == 0);
		Assert.assertTrue(g.gl[3].next.v == 4);
	}

	/* add edge to directed weighted graph */
	@Test
	public void addEdgeUnDirWeightedTest() {

		Graph<Integer, Integer> g = null;

		g = igu.initGraph(5);
		g = igu.addEdgeUnDir(g, 1, 0, 2);
		g = igu.addEdgeUnDir(g, 0, 2, 3);
		g = igu.addEdgeUnDir(g, 2, 1, 4);
		g = igu.addEdgeUnDir(g, 0, 3, 5);
		g = igu.addEdgeUnDir(g, 3, 4, 6);

		/*
		 * igu.printGraph(g); g[0]=>(1)[2]->(2)[3]->(3)[5]-> g[1]=>(0)[2]->(2)[4]->
		 * g[2]=>(0)[3]->(1)[4]-> g[3]=>(0)[5]->(4)[6]-> g[4]=>(3)[6]->
		 */
		Assert.assertTrue(g.gl[0].wt == 2);
		Assert.assertTrue(g.gl[0].next.wt == 3);

		Assert.assertTrue(g.gl[2].wt == 3);
		Assert.assertTrue(g.gl[2].next.wt == 4);

		Assert.assertTrue(g.gl[3].wt == 5);
		Assert.assertTrue(g.gl[3].next.wt == 6);
	}

	/* length of the list from source */
	@Test
	public void recursiveLenghtListTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		Assert.assertTrue(igu.recursiveLenghtList(g.gl[0]) == 3);
		Assert.assertTrue(igu.recursiveLenghtList(g.gl[1]) == 3);
		Assert.assertTrue(igu.recursiveLenghtList(g.gl[2]) == 2);
		Assert.assertTrue(igu.recursiveLenghtList(g.gl[3]) == 3);
	}

	/* delete the node from the list */
	@Test
	public void deleteNodeFromSourcePathTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		/*
		 * igu.printGraph(g); g[0]=>(1)->(4)->(3)-> g[1]=>(0)->(2)->(3)->
		 * g[2]=>(1)->(3)-> g[3]=>(2)->(4)->(0)-> g[4]=>(0)->(3)->(1)->
		 * System.out.println();
		 */
		GLNode<Integer, Integer> delete = igu.deleteNodeFromSourcePath(g, 0, 3);
		g.gl[0] = delete;

		GLNode<Integer, Integer> delete1 = igu.deleteNodeFromSourcePath(g, 1, 0);
		g.gl[1] = delete1;

		GLNode<Integer, Integer> delete2 = igu.deleteNodeFromSourcePath(g, 2, 3);
		g.gl[2] = delete2;
		/*
		 * igu.printGraph(g); g[0]=>(1)->(4)-> g[1]=>(2)->(3)-> g[2]=>(1)->
		 * g[3]=>(2)->(4)->(0)-> g[4]=>(0)->(3)->(1)->
		 */

		Assert.assertTrue(g.gl[0].next.v == 4);
		Assert.assertTrue(g.gl[1].v == 2);
		Assert.assertTrue(g.gl[2].v == 1);
	}

	/* delete the edge from graph */
	@Test
	public void deleteEdgeTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdge(g, 0, 1);
		igu.addEdge(g, 1, 2);
		igu.addEdge(g, 2, 0);

		igu.addEdge(g, 0, 3);
		igu.addEdge(g, 3, 4);
		igu.addEdge(g, 3, 2);
		igu.addEdge(g, 4, 2);
		System.out.println("before delete edge 4-2");
		igu.printGraph(g);
		Assert.assertTrue(icv.isBiconnected(g));
		igu.deleteEdge(g, 4, 2);
		Assert.assertTrue(!icv.isBiconnected(g));
		System.out.println("After deleting edge 4-2");
		igu.printGraph(g);

	}

	/* delete the node from graph */
	@Test
	public void deleteNodeTest() {

		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 2 }, { 0, 2, 5 }, { 0, 1, 5, 6, 4, 3 }, { 2, 4, 6, 7 }, { 2, 3, 6, 8 }, { 1, 2, 6, 8 },
				{ 7, 8, 5, 2, 4, 3 }, { 3, 4, 6 }, { 6, 5 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		/*
		 * igu.printGraph(g); System.out.println("\nNode 0,1,5,8 have been deleted");
		 * g[0]=>(1)->(2)-> g[1]=>(0)->(2)->(5)-> g[2]=>(0)->(1)->(5)->(6)->(4)->(3)->
		 * g[3]=>(2)->(4)->(6)->(7)-> g[4]=>(2)->(3)->(6)->(8)->
		 * g[5]=>(1)->(2)->(6)->(8)-> g[6]=>(7)->(8)->(5)->(2)->(4)->(3)->
		 * g[7]=>(3)->(4)->(6)-> g[8]=>(6)->(5)-> Node 0,1,5,8 have been deleted
		 */

		Integer arrV[] = { 0, 1, 5, 8 };
		g = igu.deleteNode(g, arrV);
		Assert.assertTrue(g.gl[0] == null && g.gl[1] == null && g.gl[8] == null && g.gl[5] == null);
		Assert.assertTrue(g.gl[2].v == 6);
		Assert.assertTrue(g.gl[6].next.v == 2);

		/*
		 * igu.printGraph(g); g[0]=> g[1]=> g[2]=>(6)->(4)->(3)->
		 * g[3]=>(2)->(4)->(6)->(7)-> g[4]=>(2)->(3)->(6)-> g[5]=>
		 * g[6]=>(7)->(2)->(4)->(3)-> g[7]=>(3)->(4)->(6)-> g[8]=>
		 */
	}

	/* Mark the visited node */
	public void markVisitedTest() {
		Graph<Integer, Integer> g = null;
		int srcDest[][] = { { 1, 4, 3 }, { 0, 2, 3 }, { 1, 3 }, { 2, 4, 0 }, { 0, 3, 1 } };
		g = igu.initGraph(srcDest.length);
		for (int i = 0; i < srcDest.length; i++) {
			for (int j = 0; j < srcDest[i].length; j++) {
				g = igu.addEdge(g, i, srcDest[i][j]);
			}
		}
		igu.markVisited(g, 1);
		Assert.assertTrue(g.gl[0].visited);
		Assert.assertTrue(g.gl[2].visited);
		Assert.assertTrue(g.gl[4].next.next.visited);

		Assert.assertTrue(!g.gl[1].visited);
		Assert.assertTrue(!g.gl[3].visited);
		Assert.assertTrue(!g.gl[4].next.visited);
	}

	/* is there cycle any form from given vertex */
	@Test
	public void isCycleFromVertexTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 0, 3);
		igu.addEdgeUnDir(g, 3, 4);
		igu.addEdgeUnDir(g, 3, 2);

		Assert.assertTrue(igu.isCycleFromVertex(g, 0, new boolean[g.vSize]));
		Assert.assertTrue(igu.isCycleFromVertex(g, 1, new boolean[g.vSize]));
		Assert.assertTrue(igu.isCycleFromVertex(g, 2, new boolean[g.vSize]));
		Assert.assertTrue(igu.isCycleFromVertex(g, 3, new boolean[g.vSize]));
		Assert.assertTrue(!igu.isCycleFromVertex(g, 4, new boolean[g.vSize]));

	}

	/* is graph is connectd to all vertices */
	@Test
	public void isConnectedTest() {
		Graph<Integer, Integer> g = igu.initGraph(5);
		igu.addEdgeUnDir(g, 0, 1);
		igu.addEdgeUnDir(g, 1, 2);
		igu.addEdgeUnDir(g, 2, 0);

		igu.addEdgeUnDir(g, 2, 3);
		igu.addEdgeUnDir(g, 3, 4);

		for (int i = 0; i < g.vSize; i++)
			Assert.assertTrue(igu.isConnected(g, i));
		igu.deleteEdge(g, 0, 2);
		for (int i = 0; i < g.vSize; i++)
			Assert.assertTrue(igu.isConnected(g, i));
		igu.addEdgeUnDir(g, 0, 2);
		igu.deleteEdge(g, 1, 0);
		// igu.printGraph(g);
		for (int i = 0; i < g.vSize; i++)
			Assert.assertTrue(igu.isConnected(g, 4));
		igu.addEdgeUnDir(g, 0, 1);
		igu.deleteEdge(g, 2, 3);
		// igu.printGraph(g);
		for (int i = 0; i < g.vSize; i++)
			Assert.assertTrue(!igu.isConnected(g, 4));

	}
}
