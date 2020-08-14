package com.design.analysis.ds.binarytree;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.binarytree.utils.BinaryTreeUtil;
import com.design.analysis.ds.tree.node.BTNode;

public class IMiscBinaryTreeTest {

	public IMiscBinaryTree<Integer> imbt = null;

	@Before
	public void init() {
		imbt = new MiscBinaryTreeImpl();
	}

	/** 1. Write a program to Delete a Tree **/
	@Test
	public void deleteTreeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// Integer result[] = { 1, 2, 4, 5, 3, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		// BinaryTreeUtil.levelTravelLineByline(root);
		root = imbt.deleteTree(root);
		Assert.assertTrue(root == null);
	}

	/** 2. Write a Program to Find the Maximum Depth or Height of a Tree **/
	@Test
	public void maxHeightOrDepthTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// Integer result[] = { 1, 2, 4, 5, 3, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		// BinaryTreeUtil.levelTravelLineByline(root);
		Assert.assertTrue(imbt.maxHeightOrDepth(root) == 4);
	}

	/** 3. Write Code to Determine if Two Trees are Identical **/
	@Test
	public void isTwoTreeIdenticalTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// Integer result[] = { 1, 2, 4, 5, 3, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);

		BTNode<Integer> root1 = null;

		for (int i = 0; i < a.length; i++)
			root1 = BinaryTreeUtil.create(root1, a[i]);

		Integer b[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root2 = null;

		for (int i = 0; i < b.length; i++)
			root2 = BinaryTreeUtil.create(root2, b[i]);

		Assert.assertTrue(imbt.isTwoTreeIdentical(root, root1));
		Assert.assertTrue(!imbt.isTwoTreeIdentical(root2, root1));
	}

	/** 4. Write a program to Calculate Size of a tree **/
	@Test
	public void sizeOfTreeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Integer b[] = { 1, 2, 4, 5, 3, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.sizeOfTree(root) == 8);

		root = null;
		for (int i = 0; i < b.length; i++)
			root = BinaryTreeUtil.create(root, b[i]);
		Assert.assertTrue(imbt.sizeOfTree(root) == 7);
	}

	/** 5. Root to leaf path sum equal to a given number **/
	@Test
	public void rootToLeavPathSum() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.rootToLeavPathSum(root, 15));
		Assert.assertTrue(imbt.rootToLeavPathSum(root, 10));
		Assert.assertTrue(imbt.rootToLeavPathSum(root, 11));

		Assert.assertTrue(!imbt.rootToLeavPathSum(root, 16));
		Assert.assertTrue(!imbt.rootToLeavPathSum(root, 4));
		Assert.assertTrue(!imbt.rootToLeavPathSum(root, 9));
	}

	/** 6. How to determine if a binary tree is height-balanced? **/
	@Test
	public void isBalanced() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.isBalanced(root));
	}

	/** 7. Diameter of a Binary Tree **/
	@Test
	public void diameterOfTreeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.diameter(root) == 6);
	}

	/** 8. Check for Children Sum Property in a Binary Tree **/
	@Test
	public void isChildrenSumTest() {
		Integer a[] = { 10, 2, 8, 2, 0, 6, 2 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.isChildrenSum(root));
	}

	/** 9. Program to count leaf nodes in a binary tree **/
	@Test
	public void countLeafNodeTest() {
		Integer a[] = { 10, 2, 8, 2, 0, 6, 2, 8, 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.countLeafNode(root) == 8);
	}

	/** 10. The Great Tree-List Recursion Problem **/
	// @See IBTUtils.java...bstToListUtils(....)
	/**
	 * 11. Given a binary tree, print out all of its root-to-leaf paths one per line
	 **/
	@Test
	public void printAllPathPerLineTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		imbt.printAllPathPerLine(root);
	}

	/** 12. Populate Inorder Successor for all nodes **/
	@Test
	public void populateNextTest() {
		Integer a[] = { 5, 3, 7 };// { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		imbt.populateNext(root);
		imbt.printSuccConnected(root);
	}

	/** 13. Connect nodes at same level using constant extra space **/
	@Test
	public void connectLevelNodesTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		imbt.connectLevelNodes(root);
		imbt.printLevelConnect(root);
	}

	/** 14. Connect nodes at same level **/
	@Test
	public void connectLevelNodesRecTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		imbt.connectLevelNodesRec(root);
		imbt.printLevelConnect(root);
	}

	/** 15. Check if a binary tree is subtree of another binary tree | Set 1 **/
	@Test
	public void isSubtreeTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer b[] = { 2, 4, 5, 8, 9 };
		Integer c[] = { 1, 2, 3, 4, 5 };
		BTNode<Integer> root = null;
		BTNode<Integer> root1 = null;
		BTNode<Integer> root2 = null;
		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		for (int i = 0; i < b.length; i++)
			root1 = BinaryTreeUtil.create(root1, b[i]);
		for (int i = 0; i < c.length; i++)
			root2 = BinaryTreeUtil.create(root2, c[i]);

		Assert.assertTrue(imbt.isSubtree(root, root1));
		Assert.assertTrue(!imbt.isSubtree(root, root2));
	}

	@Test
	public void isOverlapTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer b[] = { 1, 2, 4, 5, 8, 9 };
		Integer c[] = { 1, 2, 3, 4, 5 };
		BTNode<Integer> root = null;
		BTNode<Integer> root1 = null;
		BTNode<Integer> root2 = null;
		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		for (int i = 0; i < b.length; i++)
			root1 = BinaryTreeUtil.create(root1, b[i]);
		for (int i = 0; i < c.length; i++)
			root2 = BinaryTreeUtil.create(root2, c[i]);

		Assert.assertTrue(!imbt.isOverlap(root, root1));
		Assert.assertTrue(imbt.isOverlap(root, root2));
	}

	/** 16. Check if a given Binary Tree is SumTree **/
	@Test
	public void isSumTreeTest() {
		Integer a[] = { 26, 10, 3, 4, 6, 3 };
		Integer b[] = { 26, 10, 3, 4, 6, 4 };
		BTNode<Integer> root = null;
		BTNode<Integer> root1 = null;

		for (int i = 0; i < a.length; i++) {
			root = BinaryTreeUtil.create(root, a[i]);
			root1 = BinaryTreeUtil.create(root1, b[i]);
		}
		Assert.assertTrue(imbt.isSumTree(root));
		Assert.assertTrue(!imbt.isSumTree(root1));
	}

	/** 17. Print Ancestors of a given node in Binary Tree **/
	@Test
	public void printAllAncestorTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++) {
			root = BinaryTreeUtil.create(root, a[i]);
			imbt.printAllAncestor(root, 9);
		}
	}

	/** 18. Get Level of a node in a Binary Tree **/
	@Test
	public void levelOfNodeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.levelOfNode(root, 9) == 4);
	}

	/** 19. Print nodes at k distance from root **/
	@Test
	public void printKdistNodeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		imbt.printKdistNode(root, 4);
	}

	/** 20. Foldable Binary Trees **/
	@Test
	public void isFoldableTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.isFoldable(root));
		root = BinaryTreeUtil.create(root, 8);
		Assert.assertTrue(!imbt.isFoldable(root));
	}

	@Test
	public void isFoldableXTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.isFoldableX(root));
		root = BinaryTreeUtil.create(root, 8);
		Assert.assertTrue(!imbt.isFoldableX(root));
	}

	/** 21. Maximum width of a binary tree **/
	@Test
	public void maxWidthTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.maxWidth(root) == 4);
	}

	@Test
	public void longestPathLenTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.longestPathLen(root) == 5);
	}

	/** 22. Double Tree **/
	@Test
	public void doubleTreeTest() {
		Integer a[] = { 1, 2, 3 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		imbt.doubleTree(root);
		imbt.printAllPathPerLine(root);
	}
	/** 23. Given a binary tree, print all root-to-leaf paths **/
	// @See 11. problem

	/** 24. Linked complete binary tree & its creation **/
	/*
	 * this is create complete binary tree @See BinaryTreeUtil.java...create(....)
	 */
	/**
	 * 25. Check whether a given Binary Tree is Complete or not | Set 1 (Iterative
	 * Solution)
	 **/
	@Test
	public void isCompletBinaryTreeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer b[] = { 5, 3, 7, 2, 4, 6, 8, 9 };
		BTNode<Integer> root = null;
		BTNode<Integer> root1 = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		for (int i = 0; i < b.length; i++)
			root1 = BinaryTreeUtil.createBst(root1, b[i]);
		Assert.assertTrue(imbt.isCompletBinrayTree(root));
		Assert.assertTrue(!imbt.isCompletBinrayTree(root1));

	}

	/** 26. Find the maximum sum leaf to root path in a Binary Tree **/
	@Test
	public void maxSumRootToLeafTest() {
		Integer a[] = { 10, -2, 7, 8, -4 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.maxSumRootToLeaf(root) == 17);
	}

	/** 27. Vertical Sum in a given Binary Tree | Set 1 **/
	@Test
	public void getVerticalSumTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		int b[] = { 4, 2, 12, 3, 7 };
		int i = 0;
		for (Map.Entry<Integer, Integer> set : imbt.getVerticalSum(root).entrySet())
			Assert.assertTrue(set.getValue() == b[i++]);
	}

	/** 28. Sum of all the numbers that are formed from root to leaf paths **/
	@Test
	public void sumOfPathLeafToRootTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		int b[] = { 4, 2, 12, 3, 7 };
		int i = 0;
		for (Integer in : imbt.sumOfPathLeafToRoot(root))
			Assert.assertTrue(in == b[i]);
	}

	/** 29. Find next right node of a given key **/
	@Test
	public void nextRightNodeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.nextRightNode(root, 5).t == 6);
		Assert.assertTrue(imbt.nextRightNode(root, 2).t == 3);
		Assert.assertTrue(imbt.nextRightNode(root, 7) == null);
		Assert.assertTrue(imbt.nextRightNode(root, 9) == null);
	}

	@Test
	public void nextRightKthNodeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.nextRightKthNode(root, 5, 2).t == 7);
		Assert.assertTrue(imbt.nextRightKthNode(root, 4, 2).t == 6);
		Assert.assertTrue(imbt.nextRightKthNode(root, 3, 2) == null);
		Assert.assertTrue(imbt.nextRightKthNode(root, 4, 3).t == 7);
	}

	@Test
	public void nextLeftKthNodeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.nextLeftKthNode(root, 5, 1).t == 4);
		Assert.assertTrue(imbt.nextLeftKthNode(root, 4, 2) == null);
		Assert.assertTrue(imbt.nextLeftKthNode(root, 7, 2).t == 5);
		Assert.assertTrue(imbt.nextLeftKthNode(root, 7, 3).t == 4);
	}

	/** 30. Deepest left leaf node in a binary tree **/
	@Test
	public void deepestLeftNodeTest() {
		Integer a[] = { 7, 4, 9, 6, 5, 3, 2, 9, 8, 12, 11, 10 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.createBst(root, a[i]);
		Assert.assertTrue(imbt.deepestLeftNode(root).t == 10);
	}

	/** 31. Extract Leaves of a Binary Tree in a Doubly Linked List **/
	@Test
	public void extractLeafNodeAsListTest() {
		Integer a[] = { 7, 4, 9, 6, 5, 3, 2, 9, 8, 12, 11, 10 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.createBst(root, a[i]);
		root = imbt.extractLeafNodeAsList(root);
		while (root != null) {
			System.out.print(root.t + "->");
			root = root.next;
		}
	}

	/** 32. Remove all nodes which don’t lie in any path with sum>= k */
	@Test
	public void delAllPathLessSumTest() {
		Integer a[] = { 7, 4, 9, 6, 5, 3, 2, 9, 8, 12, 11, 10 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.createBst(root, a[i]);
		root = imbt.delAllPathLessSum(root, 21);
		BinaryTreeUtil.levelTravelLineByline(root);
	}

	/** 34. Check if all leaves are at same level **/
	@Test
	public void checkAllLeavesAtSameLevelTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		// BinaryTreeUtil.levelTravelLineByline(root);
		Assert.assertTrue(imbt.checkAllLeavesAtSameLevel(root));
		root = BinaryTreeUtil.create(root, 8);
		Assert.assertTrue(!imbt.checkAllLeavesAtSameLevel(root));
	}

	/** 35. Find depth of the deepest odd level leaf node **/
	@Test
	public void deepestOddlevelNodeTest() {
		Integer a[] = { 7, 4, 9, 6, 5, 3, 2, 9, 8, 12, 11, 10 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.createBst(root, a[i]);

		Assert.assertTrue(imbt.deepestOddlevelNode(root).t == 11);
	}

	/**
	 * 36. Difference between sums of odd level and even level nodes of a Binary
	 * Tree
	 **/
	@Test
	public void diffSumOfOddAndEvenLevelTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.diffSumOfOddAndEvenLevel(root) == 9);
	}

	/** 37. Custom Tree Problem **/
	@Test
	public void createCustomTreeTest() {
		Integer parent[] = { 1, 2, 2, 1 };
		Integer child[] = { 2, 3, 4, 5 };
		BTNode<Integer> node = null;
		for (int i = 0; i < parent.length; i++)
			node = imbt.createCustomTree(node, parent[i], child[i]);
		BinaryTreeUtil.levelTravelLineByline(node);
	}

	/** 38. Iterative Method to find Height of Binary Tree **/
	@Test
	public void heightIterativeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BTNode<Integer> root = null;

		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		Assert.assertTrue(imbt.heightIterative(root) == 3);
	}

	/** 39. Tree Isomorphism Problem **/
	@Test
	public void isIsomorphicTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		Integer b[] = { 1, 3, 2, 7, 6, 4, 5 };
		BTNode<Integer> root = null;
		BTNode<Integer> root1 = null;

		for (int i = 0; i < a.length; i++) {
			root = BinaryTreeUtil.create(root, a[i]);
			root1 = BinaryTreeUtil.create(root, b[i]);
		}
		Assert.assertTrue(imbt.isIsomorphic(root, root1));
	}
}
