package com.design.analysis.ds.advance.btree;

import com.design.analysis.ds.advance.btree.node.BTINode;
import com.design.analysis.ds.advance.btree.node.BTNode;

public interface IBTree<T> {

	/** insert in B+Tree/BTree **/

	/* split the chile when it is full */
	public void splitChild(int i, BTNode<Integer> pt, BTNode<Integer> y);

	/* insert the key */
	public BTNode<Integer> insert(BTNode<Integer> node, Integer k);

	/* insert at non full node */
	public void insertNonFull(BTNode<Integer> node, Integer k);

	/** search key **/
	public BTINode<Integer> search(BTNode<Integer> node, int k);

	/** display the keys **/
	public void display(BTNode<Integer> node);

	/** delete B+Tree/B-Tree node **/

	// A utility function that returns the index of the first key that is
	// greater than or equal to k
	public int findKey(BTNode<Integer> node, int k);

	// A function to remove the idx-th key from this node - which is a leaf node
	public void removeFromLeaf(BTNode<Integer> node, int idx);

	// A function to get predecessor of keys[idx]
	public int getPred(BTNode<Integer> node, int idx);

	// A function to get sucessessor of keys[idx]
	public int getSucc(BTNode<Integer> node, int idx);

	// A function to remove the key k from the sub-tree rooted with this node
	public void remove(BTNode<Integer> node, int k);

	// A function to remove the idx-th key from this node - which is a non-leaf node
	public void removeFromNonLeaf(BTNode<Integer> node, int idx);

	// A function to fill child C[idx] which has less than t-1 keys
	public void fill(BTNode<Integer> node, int idx);

	// A function to borrow a key from C[idx-1] and insert it
	// into C[idx]
	public void borrowFromPrev(BTNode<Integer> node, int idx);

	// A function to borrow a key from the C[idx+1] and place
	// it in C[idx]
	public void borrowFromNext(BTNode<Integer> node, int idx);

	// A function to merge C[idx] with C[idx+1]
	// C[idx+1] is freed after merging
	public void merge(BTNode<Integer> node, int idx);

}
