package com.design.analysis.core.ds.binarytree;

import java.util.List;

import com.design.analysis.core.ds.tree.node.BTNode;

/*
 * 
 * @author GuruG
 * 
 * Traversals :
1.	Tree Traversals
2.	Level Order Tree Traversal
3.	Print level order traversal line by line | Set 1
4.	Inorder Tree Traversal without Recursion
5.	Inorder Tree Traversal without recursion and without stack!
6.	Iterative Preorder Traversal
7.	Morris traversal for Preorder
8.	Iterative Postorder Traversal | Set 1 (Using Two Stacks)
9.	Iterative Postorder Traversal | Set 2 (Using One Stack)
10.	Reverse Level Order Traversal
11.	Print Postorder traversal from given Inorder and Preorder traversals
12.	Level order traversal line by line | Set 2 (Using Two Queues)
13.	Diagonal Traversal of Binary Tree
14.	Inorder Non-threaded Binary Tree Traversal without Recursion or Stack
15.	Check if leaf traversal of two Binary Trees is same?
16.	Print a Binary Tree in Vertical Order | Set 1
17.	Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method)
18.	Boundary Traversal of binary tree
19.	Perfect Binary Tree Specific Level Order Traversal
20.	Perfect Binary Tree Specific Level Order Traversal | Set 2
21.	If you are given two traversal sequences, can you construct the binary tree?

 */
public interface ITraversal<T> {

	/** 0. create binary tree level wise **/
	public BTNode<T> create(BTNode<T> t, T k);

	public BTNode<T> findInsertPostion(BTNode<T> t);

	/** 1. Tree Traversals **/
	public void preOrder(BTNode<T> t);

	public void inOrder(BTNode<T> t);

	public void postOrder(BTNode<T> t);

	public void allPath(BTNode<T> t, List<Integer> list);

	/** 2. Level Order Tree Traversal **/
	public void levelTravel(BTNode<T> t, boolean isLeftToRight);

	/** 3. Print level order traversal line by line | Set 1 **/
	public int height(BTNode<T> node);

	public void printGivenLevel(BTNode<T> root, int level);

	public void levelTravelLineByline(BTNode<T> t);

	/** 4. Inorder Tree Traversal without Recursion **/
	public void inorderWithoutRecursion(BTNode<T> t);

	/** 5. Inorder Tree Traversal without recursion and without stack! **/
	public void inorderWithoutRecAndStack(BTNode<T> t);

	/** 6. Iterative Preorder Traversal **/
	public void iterativePreorder(BTNode<T> t);

	/** 7. Morris traversal for Preorder **/
	// this same of 5.0
	/** 8. Iterative Postorder Traversal | Set 1 (Using Two Stacks) **/
	public void iterativePostorder2Stack(BTNode<T> t);

	/** 9. Iterative Postorder Traversal | Set 2 (Using One Stack) **/
	public void iterativePostorder1Stack(BTNode<T> t);
	
	/**R&D print decresing order using iterative using statck**/
	public void iterativeDecreasingOrderStack(BTNode<T> t);
	
	/**R&D print decresing order using iterative without statck**/
	public void iterativeDecreasingOrder(BTNode<T> t);

	/** 10. Reverse Level Order Traversal **/
	public void reverseLevelOrderTraversal(BTNode<T> t);

	/** 11. Print Postorder traversal from given Inorder and Preorder traversals **/
	public void inorderToPostorder(BTNode<T> t);

	// TODO
	public void preorderToPostorder(BTNode<T> t);

	/** 12. Level order traversal line by line | Set 2 (Using Two Queues) **/
	public void levelByLineTrvel(BTNode<T> t);

	/** 13. Diagonal Traversal of Binary Tree **/
	/* from top-left to bottom-right corner */
	public BTNode<T> createforTopLeftToBtmRightTravel(BTNode<T> t, T k);

	public void printTopLeftToBtmRightDigonally(BTNode<T> t);

	/* form top-right to bottom-left */
	public BTNode<T> createforTopRightToBottomLeftTravel(BTNode<T> t, T k);

	public void printTopRightToBottomLeftDigonally(BTNode<T> t);

	/** 0. create binary tree level wise **/
	// @See 0.
	/**
	 * 14. Inorder Non-threaded Binary Tree Traversal without Recursion or Stack
	 **/
	public void inorderNoUseRecurStack(BTNode<T> t);

	/** 15. Check if leaf traversal of two Binary Trees is same? **/
	public boolean isSameLeafTravelOfTwoTree(BTNode<T> t1, BTNode<T> t2);

	/** 16. Print a Binary Tree in Vertical Order | Set 1 **/
	public void printVerticalOrder(BTNode<T> t);

	/** 17. Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method) **/
	// @See DAIHashingWithTree.java @method printColumWise(....)
	/** 18. Boundary Traversal of binary tree **/
	public void boundryTraverse(BTNode<T> t);
	/* 19. Perfect Binary Tree Specific Level Order Traversal */
	/* 20. Perfect Binary Tree Specific Level Order Traversal | Set 2 */
	/*
	 * 21. If you are given two traversal sequences, can you construct the binary
	 * tree?
	 */
}
