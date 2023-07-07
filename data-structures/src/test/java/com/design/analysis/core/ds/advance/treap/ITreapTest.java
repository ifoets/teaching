package com.design.analysis.core.ds.advance.treap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.advance.node.TreapNode;

public class ITreapTest {

	TreapNode<Integer> root = null;

	public ITreap<Integer> itp = null;

	@Before
	public void init() {
		itp = new TreapImpl();
	}

	@Test
	public void insertTest() {

		int arr[] = { 50, 30, 20, 40, 70, 60, 80 };
		for (int i = 0; i < arr.length; i++) {
			root = itp.insert(root, arr[i]);
		}
		itp.displayInorder(root);
		// Assert.assertTrue(root.key == 50);
	}

	@Test
	public void searchTest() {

		int arr[] = { 50, 30, 20, 40, 70, 60, 80 };
		for (int i = 0; i < arr.length; i++) {
			root = itp.insert(root, arr[i]);
		}
		TreapNode<Integer> searchNode = itp.search(root, 40);
		Assert.assertTrue(searchNode.key == 40);
	}

	@Test
	public void deleteTest() {

	}

	@Test
	public void leftRotateTest() {

	}

	@Test
	public void reightRotateTest() {

	}
}
