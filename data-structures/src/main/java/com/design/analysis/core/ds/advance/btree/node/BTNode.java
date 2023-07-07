package com.design.analysis.core.ds.advance.btree.node;

/*
 * 
 * @author GuruG
 * B+Tree Node
 */
public class BTNode<T> {

	public BTINode<T>[] keys; // an arrays of key
	public int t; // Minimum degree (defines the range for number of keys)
	public BTNode<T>[] c; //// An array of child pointers
	public int n;// Current number of keys
	public boolean isLeaf;// Is true when node is leaf. Otherwise false

	@SuppressWarnings("unchecked")
	public BTNode(int t, boolean isLeaf) {
		this.isLeaf = isLeaf;
		keys = new BTINode[2 * t - 1];
		c = new BTNode[2 * t + 1];
		this.n = 0;
		this.t = t;
	}
}
