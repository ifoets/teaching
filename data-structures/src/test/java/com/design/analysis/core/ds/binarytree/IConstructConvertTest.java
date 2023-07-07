package com.design.analysis.core.ds.binarytree;

import java.util.Arrays;
import java.util.List;

import com.design.analysis.core.ds.binarytree.utils.BinaryTreeUtil;
import com.design.analysis.core.ds.tree.node.BTNode;
import org.junit.Before;
import org.junit.Test;

public class IConstructConvertTest {

	IConstructConvert<Integer> ict = null;

	@Before
	public void init() {
		ict = new ConstructConvertImpl();
	}

	@Test
	public void createPositionTreeTest() {
		BTNode<Integer> root = null;
		root = ict.createPositionTree(null, 20, 20, false);
		root = ict.createPositionTree(root, 20, 8, true);
		root = ict.createPositionTree(root, 20, 22, false);
		root = ict.createPositionTree(root, 8, 4, true);
		root = ict.createPositionTree(root, 8, 12, false);
		root = ict.createPositionTree(root, 12, 10, true);
		root = ict.createPositionTree(root, 12, 14, false);
		BinaryTreeUtil.levelTravelLineByline(root);
	}

	/** 0.1 Consturct tree using given preorder travel as list **/
	@Test
	public void createbstUsingPreorderListTest() {

		List<Integer> list = Arrays.asList(3, 1, 2);
		ict.inorderPrint(ict.createbstUsingPreorderList(null, list));
		System.out.println();
		List<Integer> l = Arrays.asList(5, 3, 4, 2, 7, 6, 8);
		ict.inorderPrint(ict.createbstUsingPreorderList(null, l));

	}

	/** 0.2 Consturct tree using given postorder travel as list **/
	@Test
	public void createbstUsingPostorderListTest() {
		List<Integer> list = Arrays.asList(2, 4, 3, 6, 8, 7, 5);
		ict.inorderPrint(ict.createbstUsingPostorderList(null, list));
	}

	/** 0.3 Consturct tree using given inorder travel as list **/
	@Test
	public void createbstUsingInorderderListTest() {

		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
		ict.inorderPrint(ict.createbstUsingInorderderList(null, list));
		System.out.println();
		List<Integer> l = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
		ict.inorderPrint(ict.createbstUsingInorderderList(null, l));
	}

	/** 1. Construct Tree from given Inorder and Preorder traversals **/
	@Test
	public void buildTreeFromGivenInorderPreorderTest() {
		Integer in[] = { 4, 2, 5, 1, 6, 3 };
		Integer pre[] = { 1, 2, 4, 5, 3, 6 };
		BTNode<Integer> root = ict.buildTreeFromGivenInorderPreorder(in, pre);
		BinaryTreeUtil.levelTravelLineByline(root);
	}
}
