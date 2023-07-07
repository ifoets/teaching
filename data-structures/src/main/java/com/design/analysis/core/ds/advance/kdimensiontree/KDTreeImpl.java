package com.design.analysis.core.ds.advance.kdimensiontree;

import com.design.analysis.core.ds.advance.kdimensiontree.node.XYPoint;
import com.design.analysis.core.ds.advance.kdimensiontree.node.XYTNode;
import com.design.analysis.core.ds.advance.kdimensiontree.node.XYZPoint;
import com.design.analysis.core.ds.advance.kdimensiontree.node.XYZTNode;

public class KDTreeImpl implements IKDTree<XYPoint, XYZPoint> {

	public int k = 2;

	/** 1. K D Tree (Search and Insert) **/
	@Override
	public XYTNode<XYPoint> insertRec(XYTNode<XYPoint> node, XYPoint point, int depth) {

		if (node == null)
			return new XYTNode<>(point);
		// Calculate current dimension (cd) of comparison
		int cd = depth % k;
		boolean ltOrrt = false;

		switch (cd) {
		case 0:
			ltOrrt = point.x < node.t.x ? true : false;
			break;
		case 1:
			ltOrrt = point.y < node.t.y ? true : false;
			break;
		}

		if (ltOrrt)
			node.lt = insertRec(node.lt, point, depth + 1);
		else
			node.rt = insertRec(node.rt, point, depth + 1);

		return node;
	}

	@Override
	public boolean searchRec(XYTNode<XYPoint> node, XYPoint point, int depth) {
		// Base cases
		if (node == null)
			return false;
		if (node.t.equals(point))
			return true;

		int cd = depth % k;
		boolean ltOrrt = false;

		switch (cd) {
		case 0:
			ltOrrt = point.x < node.t.x ? true : false;
			break;
		case 1:
			ltOrrt = point.y < node.t.y ? true : false;
			break;
		}

		if (ltOrrt)
			return searchRec(node.lt, point, depth + 1);
		else
			return searchRec(node.rt, point, depth + 1);
	}

	/* xOry ie dimention 0 for x and 1 for y */
	@Override
	public XYTNode<XYPoint> findMinimumXorY(XYTNode<XYPoint> node, int depth, int xOry) {

		// Base cases
		if (node == null)
			return new XYTNode<>(new XYPoint(Integer.MAX_VALUE, Integer.MAX_VALUE));

		// Current dimension is computed using current depth and total
		// dimensions (k)
		int cd = depth % k;

		// Compare point with root with respect to cd (Current dimension)
		if (cd == xOry) {
			if (node.lt == null)
				return node;
			return findMinimumXorY(node.lt, depth + 1, xOry);
		}

		// If current dimension is different then minimum can be anywhere
		// in this subtree
		if (xOry == 0)
			return minNode(node, findMinimumXorY(node.lt, depth + 1, xOry), findMinimumXorY(node.rt, depth + 1, xOry),
					xOry);
		else
			return minNode(node, findMinimumXorY(node.lt, depth + 1, xOry), findMinimumXorY(node.rt, depth + 1, xOry),
					xOry);

	}

	@Override
	public void display(XYTNode<XYPoint> node) {
		if (node != null) {
			display(node.lt);
			System.out.println(node.t.toString());
			display(node.rt);
		}

	}

	@Override
	public XYTNode<XYPoint> minNode(XYTNode<XYPoint> x, XYTNode<XYPoint> y, XYTNode<XYPoint> z, int d) {
		XYTNode<XYPoint> res = x;

		if (y != null && d == 0 ? y.t.x < res.t.x : y.t.y < res.t.y)
			res = y;
		if (z != null && d == 0 ? z.t.x < res.t.x : z.t.y < res.t.y)
			res = z;
		return res;
	}

	@Override
	public XYTNode<XYPoint> deleteNodeRec(XYTNode<XYPoint> node, XYPoint point, int depth) {
		// Given point is not present
		if (node == null)
			return null;

		// Find dimension of current node
		int cd = depth % k;

		// If the point to be deleted is present at node
		if (node.t.equals(point)) {
			// 2.b) If right child is not NULL
			if (node.rt != null) {
				// Find minimum of node's dimension in right subtree
				XYTNode<XYPoint> min = findMinimumXorY(node.rt, depth, cd);

				// Copy the minimum to node
				node.t = min.t;
				// Recursively delete the minimum
				node.rt = deleteNodeRec(node.rt, min.t, depth + 1);
			} else if (node.lt != null) // same as above
			{
				XYTNode<XYPoint> min = findMinimumXorY(node.lt, depth, cd);
				node.t = min.t;
				node.rt = deleteNodeRec(node.lt, min.t, depth + 1);
			} else // If node to be deleted is leaf node
			{
				node = null;
				;
				return null;
			}
			return node;
		}

		// 2) If current node doesn't contain point, search downward
		boolean ltOrrt=false;
		switch (cd) {
		case 0:
			ltOrrt = point.x < node.t.x ? true : false;
			break;
		case 1:
			ltOrrt = point.y < node.t.y ? true : false;
			break;
		}
		if (ltOrrt)
			node.lt = deleteNodeRec(node.lt, point, depth + 1);
		else
			node.rt = deleteNodeRec(node.rt, point, depth + 1);
		return node;
	}

	/* three dimention */
	@Override
	public XYZTNode<XYZPoint> insertCube(XYZTNode<XYZPoint> node, XYZPoint point, int depth) {
		if (node == null)
			return new XYZTNode<>(point);
		// Calculate current dimension (cd) of comparison
		int cd = depth % k;
		boolean ltOrrt = false;

		switch (cd) {
		case 0:// depends x
			ltOrrt = point.x < node.t.x ? true : false;
			break;
		case 1:// depends y
			ltOrrt = point.y < node.t.y ? true : false;
			break;
		case 2:// depends z
			ltOrrt = point.z < node.t.z ? true : false;
			break;
		}

		if (ltOrrt)
			node.lt = insertCube(node.lt, point, depth + 1);
		else
			node.rt = insertCube(node.rt, point, depth + 1);

		return node;
	}

	@Override
	public boolean searchCube(XYZTNode<XYZPoint> node, XYZPoint point, int depth) {
		// Base cases
		if (node == null)
			return false;
		if (node.t.equals(point))
			return true;

		int cd = depth % k;
		boolean ltOrrt = false;

		switch (cd) {
		case 0:// depends x
			ltOrrt = point.x < node.t.x ? true : false;
			break;
		case 1:// depends y
			ltOrrt = point.y < node.t.y ? true : false;
			break;
		case 2:// depends z
			ltOrrt = point.z < node.t.z ? true : false;
			break;
		}

		if (ltOrrt)
			return searchCube(node.lt, point, depth + 1);
		else
			return searchCube(node.rt, point, depth + 1);
	}

	@Override
	public void display(XYZTNode<XYZPoint> node) {
		if (node != null) {
			display(node.lt);
			System.out.println(node.t.toString());
			display(node.rt);
		}
	}

	/* point from origin..simillar way point from x-axis or y-axis */
	@Override
	public XYTNode<XYPoint> insertFromOrigin(XYTNode<XYPoint> node, XYPoint point) {
		if (node == null)
			return new XYTNode<>(point);

		boolean ltOrrt = Math.sqrt(Math.pow(point.x, 2) + Math.pow(point.y, 2)) < Math
				.sqrt(Math.pow(node.t.x, 2) + Math.pow(node.t.y, 2)) ? true : false;

		if (ltOrrt)
			node.lt = insertFromOrigin(node.lt, point);
		else
			node.rt = insertFromOrigin(node.rt, point);

		return node;
	}

	@Override
	public boolean searchFromOrigin(XYTNode<XYPoint> node, XYPoint point) {
		if (node == null)
			return false;
		if (node.t.equals(point))
			return true;
		boolean ltOrrt = Math.sqrt(Math.pow(point.x, 2) + Math.pow(point.y, 2)) < Math
				.sqrt(Math.pow(node.t.x, 2) + Math.pow(node.t.y, 2)) ? true : false;

		if (ltOrrt)
			return searchFromOrigin(node.lt, point);
		else
			return searchFromOrigin(node.rt, point);
	}

	/* point measure distance form x axis */
	@Override
	public XYTNode<XYPoint> insertFromXOrYaxis(XYTNode<XYPoint> node, XYPoint point, boolean isXorY) {
		if (node == null)
			return new XYTNode<>(point);

		boolean ltOrrt = isXorY ? (point.y < node.t.y ? true : false) : (point.x < node.t.x ? true : false);

		if (ltOrrt)
			node.lt = insertFromXOrYaxis(node.lt, point, isXorY);
		else
			node.rt = insertFromXOrYaxis(node.rt, point, isXorY);

		return node;
	}

	@Override
	public boolean searchFromXOrYaxis(XYTNode<XYPoint> node, XYPoint point, boolean isXorY) {
		if (node == null)
			return false;
		if (node.t.equals(point))
			return true;
		boolean ltOrrt = isXorY ? (point.y < node.t.y ? true : false) : (point.x < node.t.x ? true : false);

		if (ltOrrt)
			return searchFromXOrYaxis(node.lt, point, isXorY);
		else
			return searchFromXOrYaxis(node.rt, point, isXorY);
	}
}
