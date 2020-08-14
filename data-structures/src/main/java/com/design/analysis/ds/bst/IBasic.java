/**
 * 
 */
package com.design.analysis.ds.bst;

import com.design.analysis.ds.tree.node.BTNode;

/**
 * @author @Gurug
 *
 */
/*
 * Basic : 
 * 1. Binary Search Tree | Set 1 (Search and Insertion) 
 * 2. Binary Search Tree | Set 2 (Delete) 
 * 3. Advantages of BST over Hash Table
 */
public interface IBasic<T> {

	/* 1. Binary Search Tree | Set 1 (Search and Insertion) */
	/* create bst */
	public BTNode<T> insert(BTNode<T> node, T t);

	/* search node in bst */
	public BTNode<T> search(BTNode<T> node, T t);

	/* 2. Binary Search Tree | Set 2 (Delete) */
	public BTNode<T> delete(BTNode<T> node, T t);
	
	/*print inorder*/
	public void inOrder(BTNode<T> node);
	

	/* 3. Advantages of BST over Hash Table */
	/*
	 * No doubt hash is better for Search, Insert, Delete but bst is here better
	 * get all keys in sorted order by just doing inorder order statistics,
	 * finding closest lower and greater elements, doing range queries are easy
	 */
}
