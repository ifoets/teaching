package com.design.analysis.ds.bst.inorder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.bst.inorder.node.BTIONode;

public class IBTreeInOrderTest {

	public IBTreeInOrder<Integer> ibio = null;

	@Before
	public void init() {
		ibio = new BTreeInOrderImpl();
	}

	/** creating the tree who maintain the order of insertion */
	@Test
	public void createTest() {
		int a[] = { 5, 3, 7, 2, 4, 6, 8 };
		BTIONode<Integer> node = null;
		for (int i = 0; i < a.length; i++) {
			node = ibio.create(node, a[i], 0);
		}
		ibio.inorderPrint(node);
	}

	/** print the order of insertion **/
	@Test
	public void printInsertionOrderTest() {
		int a[] = { 5, 3, 7, 2, 4, 6, 8 };
		BTIONode<Integer> node = null;
		for (int i = 0; i < a.length; i++) {
			node = ibio.create(node, a[i], 0);
		}
		ibio.printInsertionOrder(node);
	}

	/** print tree in order **/
	@Test
	public void inorderPrintTest() {
		int a[] = { 5, 3, 7, 2, 4, 6, 8 };
		BTIONode<Integer> node = null;
		for (int i = 0; i < a.length; i++) {
			node = ibio.create(node, a[i], 0);
		}
		Assert.assertTrue(ibio.findPoisionOfInsertion(node, 2) == 4);
	}

	/** find which position the node inserted **/
	// tested in createTest
}
