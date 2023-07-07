package com.design.analysis.core.ds.bst.inorder;

import com.design.analysis.core.ds.bst.inorder.node.BTIONode;

/*
 * 
 * @author GuruG
 * This is used for the opranation analysis of  a tree who maintain the insetion orde like LinkedHashMap maintain the insertion order
 */
public interface IBTreeInOrder<T> {

	/** creating the tree who maintain the order of insertion */
	public BTIONode<T> create(BTIONode<T> node, T t, int ind);

	/** print the order of insertion **/
	public void printInsertionOrder(BTIONode<T> node);

	/** print tree in order **/
	public void inorderPrint(BTIONode<T> node);

	/** find which position the node inserted **/
	public int findPoisionOfInsertion(BTIONode<T> node, T t);
}
