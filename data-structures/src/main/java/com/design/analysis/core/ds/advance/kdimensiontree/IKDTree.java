package com.design.analysis.core.ds.advance.kdimensiontree;

import com.design.analysis.core.ds.advance.kdimensiontree.node.XYTNode;
import com.design.analysis.core.ds.advance.kdimensiontree.node.XYZTNode;

/*
 * 
 * @author GuruG
 * 
 * k Dimensional Tree :
1.	K D Tree (Search and Insert)
2.	K D Tree (Find Minimum)
3.	K D Tree (Delete)

 */
public interface IKDTree<T, K> {

	/** 1. K D Tree (Search and Insert) **/
	/* two dimention */
	public XYTNode<T> insertRec(XYTNode<T> node, T t, int depth);

	public boolean searchRec(XYTNode<T> node, T t, int depth);

	/* The point whose x or y is minimum in entire tree */
	public XYTNode<T> findMinimumXorY(XYTNode<T> node, int depth, int xOry);

	public void display(XYTNode<T> node);

	public XYTNode<T> minNode(XYTNode<T> x, XYTNode<T> y, XYTNode<T> z, int d);

	public XYTNode<T> deleteNodeRec(XYTNode<T> node, T t, int depth);

	/* three dimention */
	public XYZTNode<K> insertCube(XYZTNode<K> node, K t, int depth);

	public boolean searchCube(XYZTNode<K> node, K t, int depth);

	public void display(XYZTNode<K> node);

	/* point from origin..simillar way point from x-axis or y-axis */
	public XYTNode<T> insertFromOrigin(XYTNode<T> node, T t);

	public boolean searchFromOrigin(XYTNode<T> node, T t);

	/* find min distance point from origin just travelle left most point */
	/* find max distacne point from origin just travelled right most point */
	/* sort point from origin just have to travelled inorder */

	/* point measure distance form x axis */

	public XYTNode<T> insertFromXOrYaxis(XYTNode<T> node, T t, boolean isXorY);

	public boolean searchFromXOrYaxis(XYTNode<T> node, T t, boolean isXorY);

	/* find min distance point from x|y axis just travelle left most point */
	/* find max distacne point from x|y axis just travelled right most point */
	/* sort point from x|y axis just have to travelled inorder */
}
