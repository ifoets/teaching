package com.design.analysis.ds.advance.kdimensiontree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.advance.kdimensiontree.node.XYTNode;
import com.design.analysis.ds.advance.kdimensiontree.node.XYZPoint;
import com.design.analysis.ds.advance.kdimensiontree.node.XYZTNode;
import com.design.analysis.ds.advance.kdimensiontree.node.XYPoint;

public class IKDTreeTest {

	public IKDTree<XYPoint, XYZPoint> ikdt = null;

	@Before
	public void init() {
		ikdt = new KDTreeImpl();
	}

	/** 1. K D Tree (Search and Insert) **/
	@Test
	public void insertRecTest() {
		XYTNode<XYPoint> root = null;

		int points[][] = { { 3, 6 }, { 17, 15 }, { 13, 15 }, { 6, 12 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertRec(root, new XYPoint(points[i][0], points[i][1]), 0);
		ikdt.display(root);
	}

	@Test
	public void searchRecTest() {
		XYTNode<XYPoint> root = null;

		int points[][] = { { 3, 6 }, { 17, 15 }, { 13, 15 }, { 6, 12 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertRec(root, new XYPoint(points[i][0], points[i][1]), 0);
		// ikdt.display(root);
		Assert.assertTrue(ikdt.searchRec(root, new XYPoint(6, 12), 0));
		Assert.assertTrue(ikdt.searchRec(root, new XYPoint(10, 19), 0));
		Assert.assertTrue(!ikdt.searchRec(root, new XYPoint(7, 12), 0));
	}

	@Test
	public void findMinimumXorYTest() {
		XYTNode<XYPoint> root = null;

		int points[][] = { { 3, 6 }, { 17, 15 }, { 13, 15 }, { 6, 12 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertRec(root, new XYPoint(points[i][0], points[i][1]), 0);
		Assert.assertTrue(ikdt.findMinimumXorY(root, 0, 0).t.x == 2); // min x
		Assert.assertTrue(ikdt.findMinimumXorY(root, 0, 1).t.y == 1); // min y
	}

	@Test
	public void deleteNodeRecTest() {
		XYTNode<XYPoint> root = null;

		int points[][] = { { 3, 6 }, { 17, 15 }, { 13, 15 }, { 6, 12 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertRec(root, new XYPoint(points[i][0], points[i][1]), 0);
		root = ikdt.deleteNodeRec(root, new XYPoint(13, 15), 0);
		root = ikdt.deleteNodeRec(root, new XYPoint(2, 7), 0);
		ikdt.display(root);
		Assert.assertTrue(!ikdt.searchRec(root, new XYPoint(13, 15), 0));
		Assert.assertTrue(!ikdt.searchRec(root, new XYPoint(2, 7), 0));
		Assert.assertTrue(ikdt.searchRec(root, new XYPoint(9, 1), 0));
	}

	@Test
	public void insertCubeTest() {
		XYZTNode<XYZPoint> root = null;

		int points[][] = { { 3, 6, 1 }, { 17, 15, 10 }, { 13, 15, 12 }, { 6, 12, 7 }, { 9, 1, 15 }, { 2, 7, 18 },
				{ 10, 19, 5 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertCube(root, new XYZPoint(points[i][0], points[i][1], points[i][2]), 0);
		ikdt.display(root);
	}

	@Test
	public void searchCubeTest() {
		XYZTNode<XYZPoint> root = null;

		int points[][] = { { 3, 6, 1 }, { 17, 15, 10 }, { 13, 15, 12 }, { 6, 12, 7 }, { 9, 1, 15 }, { 2, 7, 18 },
				{ 10, 19, 5 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertCube(root, new XYZPoint(points[i][0], points[i][1], points[i][2]), 0);
		// ikdt.display(root);
		Assert.assertTrue(ikdt.searchCube(root, new XYZPoint(6, 12, 7), 0));
		Assert.assertTrue(ikdt.searchCube(root, new XYZPoint(10, 19, 5), 0));
		Assert.assertTrue(!ikdt.searchCube(root, new XYZPoint(6, 12, 71), 0));
	}

	/* point from origin..simillar way point from x-axis or y-axis */
	@Test
	public void insertFromOriginTest() {
		XYTNode<XYPoint> root = null;

		int points[][] = { { 6, 12 }, { 3, 6 }, { 17, 15 }, { 13, 15 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertFromOrigin(root, new XYPoint(points[i][0], points[i][1]));
		while (root.lt != null)
			root = root.lt;
		Assert.assertTrue(root.t.x == 3);
		Assert.assertTrue(root.t.y == 6);
		// ikdt.display(root);
	}

	@Test
	public void searchFromOriginTest() {

		XYTNode<XYPoint> root = null;

		int points[][] = { { 3, 6 }, { 17, 15 }, { 13, 15 }, { 6, 12 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertFromOrigin(root, new XYPoint(points[i][0], points[i][1]));
		// sorted by distance from origin coordinate
		// ikdt.display(root);
		Assert.assertTrue(ikdt.searchFromOrigin(root, new XYPoint(6, 12)));
		Assert.assertTrue(ikdt.searchFromOrigin(root, new XYPoint(2, 7)));
		Assert.assertTrue(!ikdt.searchFromOrigin(root, new XYPoint(12, 7)));
	}

	/* point measure distance form x axis */
	@Test
	public void insertFromXOrYaxisTest() {
		/*
		 * from x axis ie measur lt or rt using y distance from x axis ie y coordinate
		 */
		XYTNode<XYPoint> root = null;

		int points[][] = { { 6, 12 }, { 3, 6 }, { 17, 15 }, { 13, 15 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertFromXOrYaxis(root, new XYPoint(points[i][0], points[i][1]), true);
		// sorted by x coordinate
		// ikdt.display(root);
		while (root.lt != null)
			root = root.lt;
		Assert.assertTrue(root.t.x == 9);
		Assert.assertTrue(root.t.y == 1);

		/*
		 * from y axis ie measur lt or rt using x distance from y axis ie x coordinate
		 */
		root = null;

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertFromXOrYaxis(root, new XYPoint(points[i][0], points[i][1]), false);
		// sorted by x coordinate
		// ikdt.display(root);
		while (root.lt != null)
			root = root.lt;
		Assert.assertTrue(root.t.x == 2);
		Assert.assertTrue(root.t.y == 7);
	}

	@Test
	public void searchFromXOrYaxisTest() {
		/*
		 * from x axis ie measur lt or rt using y distance from x axis ie y coordinate
		 */
		XYTNode<XYPoint> root = null;

		int points[][] = { { 6, 12 }, { 3, 6 }, { 17, 15 }, { 13, 15 }, { 9, 1 }, { 2, 7 }, { 10, 19 } };

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertFromXOrYaxis(root, new XYPoint(points[i][0], points[i][1]), true);
		// sorted by x coordinate
		// ikdt.display(root);
		Assert.assertTrue(ikdt.searchFromXOrYaxis(root, new XYPoint(6, 12), true));
		Assert.assertTrue(ikdt.searchFromXOrYaxis(root, new XYPoint(2, 7), true));
		Assert.assertTrue(!ikdt.searchFromXOrYaxis(root, new XYPoint(12, 7), true));

		/*
		 * from y axis ie measur lt or rt using x distance from y axis ie x coordinate
		 */
		root = null;

		for (int i = 0; i < points.length; i++)
			root = ikdt.insertFromXOrYaxis(root, new XYPoint(points[i][0], points[i][1]), false);
		// sorted by x coordinate
		// ikdt.display(root);
		Assert.assertTrue(ikdt.searchFromXOrYaxis(root, new XYPoint(6, 12), false));
		Assert.assertTrue(ikdt.searchFromXOrYaxis(root, new XYPoint(2, 7), false));
		Assert.assertTrue(!ikdt.searchFromXOrYaxis(root, new XYPoint(12, 7), false));
	}
}
