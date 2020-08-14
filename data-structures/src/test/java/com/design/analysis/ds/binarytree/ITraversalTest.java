package com.design.analysis.ds.binarytree;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.tree.node.BTNode;

public class ITraversalTest {

	public ITraversal<Integer> it = null;

	@Before
	public void init() {
		it = new TraversalImpl();
	}

	/** 1. Tree Traversals **/
	@Test
	public void preOrderTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 1, 2, 4, 5, 3, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.preOrder(root);
	}

	@Test
	public void inOrderTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 4, 2, 5, 1, 6, 3, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.inOrder(root);
	}

	@Test
	public void postOrderTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 4, 5, 2, 6, 7, 3, 1 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.postOrder(root);
	}

	@Test
	public void allPathTest() {
		Integer a[] = { 5, 3, 7, 2, 4, 6, 8 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.allPath(root, new ArrayList<>());

	}

	/** 2. Level Order Tree Traversal **/
	@Test
	public void levelTravelTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer resultLeftToRight[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer resultRightToLeft[] = { 1, 3, 2, 7, 6, 5, 4 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		System.out.println("Left to right Traversal");
		it.levelTravel(root, true);
		System.out.println("\nRight to left Traversal");
		it.levelTravel(root, false);
	}

	/** 3. Print level order traversal line by line | Set 1 **/
	@Test
	public void levelTravelLineBylineTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.levelTravelLineByline(root);
	}

	/** 4. Inorder Tree Traversal without Recursion **/
	@Test
	public void inorderWithoutRecursionTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 4, 2, 5, 1, 6, 3, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.inorderWithoutRecursion(root);
	}

	/** 5. Inorder Tree Traversal without recursion and without stack! **/
	@Test
	public void inorderWithoutRecAndStackTest() {
		// Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 4, 2, 5, 1, 6, 3, 7 };
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.inOrder(root);
		System.out.println();
		it.inorderWithoutRecAndStack(root);
	}

	/** 6. Iterative Preorder Traversal **/
	@Test
	public void iterativePreorderTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 1, 2, 4, 5, 3, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.iterativePreorder(root);
	}

	/** 7. Morris traversal for Preorder **/
	// this same of 5.0
	/** 8. Iterative Postorder Traversal | Set 1 (Using Two Stacks) **/
	@Test
	public void iterativePostorder2StackTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// (4)->(5)->(2)->(6)->(7)->(3)->(1)->
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.iterativePostorder2Stack(root);
	}

	/** 9. Iterative Postorder Traversal | Set 2 (Using One Stack) **/
	@Test
	public void iterativePostorder1StackTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// (4)->(5)->(2)->(6)->(7)->(3)->(1)->
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.iterativePostorder1Stack(root);
	}

	/** 10. Reverse Level Order Traversal **/
	@Test
	public void reverseLevelOrderTraversalTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// (4)->(5)->(2)->(6)->(7)->(3)->(1)->
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.reverseLevelOrderTraversal(root);
	}

	/** 11. Print Postorder traversal from given Inorder and Preorder traversals **/
	@Test
	public void inorderToPostorderTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.inorderToPostorder(root);
	}

	// TODO
	public void preorderToPostorderTest() {

	}

	/** 12. Level order traversal line by line | Set 2 (Using Two Queues) **/
	@Test
	public void levelByLineTrvelTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.levelByLineTrvel(root);
	}

	/** 13. Diagonal Traversal of Binary Tree **/
	/* from top-left to bottom-right corner */
	@Test
	public void printTopLeftToBtmRightDigonallyTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.createforTopLeftToBtmRightTravel(root, a[i]);
		it.printTopLeftToBtmRightDigonally(root);
	}

	/* form top-right to bottom-left */
	@Test
	public void printTopRightToBottomLeftDigonallyTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.createforTopRightToBottomLeftTravel(root, a[i]);
		it.printTopRightToBottomLeftDigonally(root);
	}

	/**
	 * 14. Inorder Non-threaded Binary Tree Traversal without Recursion or Stack
	 **/
	@Test
	public void inorderNoUseRecurStackTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.inorderNoUseRecurStack(root);
	}

	/** 15. Check if leaf traversal of two Binary Trees is same? **/
	@Test
	public void isSameLeafTravelOfTwoTreeTest() {

		Integer a[] = { 1, 2, 3, 4, 5 };
		Integer b[] = { 7, 8, 3, 4, 5 };
		BTNode<Integer> root1 = null;
		BTNode<Integer> root2 = null;
		for (int i = 0; i < a.length; i++)
			root1 = it.create(root1, a[i]);

		for (int i = 0; i < a.length; i++)
			root2 = it.create(root2, b[i]);
		Assert.assertTrue(it.isSameLeafTravelOfTwoTree(root1, root2));
	}

	/** 16. Print a Binary Tree in Vertical Order | Set 1 **/
	// TODO
	@Test
	public void printVerticalOrderTest() {

	}

	/** 17. Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method) **/
	// @See DAIHashingWithTree.java @method printColumWise(....)
	/** 18. Boundary Traversal of binary tree **/
	@Test
	public void boundryTraverseTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		it.boundryTraverse(root);
	}
}
