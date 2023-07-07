package com.design.analysis.core.ds.bst.link;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.model.Product;
import com.design.analysis.core.ds.common.model.ProductTestUtils;
import com.design.analysis.core.ds.tree.node.BTLNode;

public class IBstLinkTest {

	public IBstLink<Integer, Product> ibtl = null;

	@Before
	public void init() {
		ibtl = new BstLinkImpl();
	}

	@Test
	public void createTest() {

		Product[] pArr = ProductTestUtils.producForTreeLink();
		BTLNode<Integer, Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtl.create(root, pArr[i].pTypeId, pArr[i]);
		Assert.assertTrue(root.next.k.pName == "computer");
		Assert.assertTrue(root.next.next.k.pName == "watch");

		Assert.assertTrue(root.lt.next.k.pName == "bmw");
		Assert.assertTrue(root.lt.next.next.k.pName == "tata");

		Assert.assertTrue(root.rt.next.k.pName == "watch");
		Assert.assertTrue(root.rt.next.next.k.pName == "mobile");

		Product p1 = new Product(3, 1, 11, "3.aaple", "computerNew");
		Product p2 = new Product(3, 2, 12, "3.aaple", "watchNew");
		root = ibtl.create(root, p1.pTypeId, p1);
		root = ibtl.create(root, p2.pTypeId, p2);

		Assert.assertTrue(root.next.k.pName == "computerNew");
		Assert.assertTrue(root.next.next.k.pName == "watchNew");
		// ibtl.inorderBstLink(root);
	}

	/* search link node in inner link of bst */
	@Test
	public void searchTest() {

		Product[] pArr = ProductTestUtils.producForTreeLink();
		BTLNode<Integer, Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtl.create(root, pArr[i].pTypeId, pArr[i]);
		Product p1 = new Product(3, 1, 11, "3.aaple", "computer");
		Product p2 = new Product(3, 2, 12, "3.aaple", "watch");
		Assert.assertTrue(ibtl.search(root, p1.pTypeId, p1).k.equals(p1));
		Assert.assertTrue(ibtl.search(root, p2.pTypeId, p2).k.equals(p2));

		Assert.assertTrue(ibtl.search(root, 1, p1) == null);
		Assert.assertTrue(ibtl.search(root, 2, p2) == null);
	}

	/* delete link node in inner link of bst */
	@Test
	public void deleteTest() {

		Product[] pArr = ProductTestUtils.producForTreeLink();
		BTLNode<Integer, Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtl.create(root, pArr[i].pTypeId, pArr[i]);
		Product p1 = new Product(3, 1, 11, "3.aaple", "computer");
		Product p2 = new Product(3, 3, 13, "3.aaple", "mobile");
		Assert.assertTrue(ibtl.delete(root, 3, p1));
		Assert.assertTrue(ibtl.delete(root, 3, p2));

		Assert.assertTrue(ibtl.delete(root, 4, p1) == false);
		Assert.assertTrue(ibtl.delete(root, 5, p2) == false);

		Assert.assertTrue(root.next.k.pName == "watch");
		Assert.assertTrue(root.next.next == null);

	}

	/* print the bstNode and list inner to it */
	@Test
	public void inorderBstLinkTest() {

		Product[] pArr = ProductTestUtils.producForTreeLink();
		BTLNode<Integer, Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtl.create(root, pArr[i].pTypeId, pArr[i]);
		ibtl.inorderBstLink(root);
	}
}
