package com.design.analysis.core.ds.binarytree.utils;

import com.design.analysis.core.ds.binarytree.ITraversal;
import com.design.analysis.core.ds.binarytree.TraversalImpl;
import com.design.analysis.core.ds.tree.node.BTNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeUtilTest {

	public ITraversal<Integer> it = null;

	@Before
	public void init() {
		it = new TraversalImpl();
	}

	@Test
	public void createCustomTreeTest() {
		Integer parent[] = { 1, 2, 2, 1, 5, 5 };
		Integer child[] = { 2, 3, 4, 5, 7, 8 };
		BTNode<Integer> root = null;
		for (int i = 0; i < parent.length; i++)
			root = BinaryTreeUtil.createCustomTree(root, parent[i], child[i]);
		BinaryTreeUtil.levelTravelLineByline(root);
	}

	@Test
	public void linkNextPrevLevelWiseTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = BinaryTreeUtil.create(root, a[i]);
		BinaryTreeUtil.linkNextPrevLevelWise(root);
		BinaryTreeUtil.printLevelByLink(root);
	}

	@Test
	public void indComparatorTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.createforTopLeftToBtmRightTravel(root, a[i]);
		it.printTopLeftToBtmRightDigonally(root);
	}

	@Test
	public void isIdenticalTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BTNode<Integer> root = null;
		BTNode<Integer> root1 = null;
		BTNode<Integer> root2 = null;
		for (int i = 0; i < a.length; i++) {
			root = BinaryTreeUtil.create(root, a[i]);
			root1 = BinaryTreeUtil.create(root1, a[i]);
			if (i < a.length - 1)
				root2 = BinaryTreeUtil.create(root2, a[i]);
		}
		Assert.assertTrue(BinaryTreeUtil.areIdentical(root, root1));
		Assert.assertTrue(!BinaryTreeUtil.areIdentical(root, root2));
	}

	@Test
	public void searchTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = it.create(root, a[i]);
		BTNode<Integer> x = new BTNode<Integer>(7);
		BTNode<Integer> y = new BTNode<Integer>(4);

		BTNode<Integer> b = new BTNode<Integer>(8);
		BTNode<Integer> c = new BTNode<Integer>(0);
		Assert.assertTrue(BinaryTreeUtil.search(root, x).t == 7);
		Assert.assertTrue(BinaryTreeUtil.search(root, y).t == 4);

		Assert.assertTrue(BinaryTreeUtil.search(root, b) == null);
		Assert.assertTrue(BinaryTreeUtil.search(root, c) == null);
	}
}
