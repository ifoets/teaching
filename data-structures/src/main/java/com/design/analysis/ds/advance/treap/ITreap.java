package com.design.analysis.ds.advance.treap;

import com.design.analysis.ds.advance.node.TreapNode;

/*
 * 
 * @author GuruG
 ScapeGoat Tree and Treap :
1.	ScapeGoat Tree | (Introduction and Insertion)
2.	Treap | Set 1 (A Randomized Binary Search Tree)
3.	Treap | Set 2 (Implementation of Search, Insert and Delete)
*/

public interface ITreap<T> {

	// TODO
	/** 1. ScapeGoat Tree | (Introduction and Insertion) **/

	/** 2. Treap | Set 1 (A Randomized Binary Search Tree) @Theory only **/
	/** 3. Treap | Set 2 (Implementation of Search, Insert and Delete) **/
	public TreapNode<T> insert(TreapNode<T> node, T key);

	public void displayInorder(TreapNode<T> node);

	public TreapNode<T> search(TreapNode<T> node, T key);

	public TreapNode<T> deleteNode(TreapNode<T> node, T key);

	public TreapNode<T> leftRotate(TreapNode<T> x);

	public TreapNode<T> reightRotate(TreapNode<T> x);
}
