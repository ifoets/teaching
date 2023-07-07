package com.design.analysis.core.ds.bst.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.model.Product;
import com.design.analysis.core.ds.common.model.ProductTestUtils;
import com.design.analysis.core.ds.tree.node.BTNode;

public class IBTUtilsTest {

	public IBTUtils<Product> ibtul = null;

	@Before
	public void init() {
		ibtul = new BTUtils();
	}

	/* add or replace the node */
	@Test
	public void createReplaceTest() {
		Product pArr[] = ProductTestUtils.producForTree();
		BTNode<Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtul.createReplace(root, pArr[i]);

		Assert.assertTrue(root.t.pName == "shirt");
		Product p = new Product(1, 5, 24, "1.textile", "T-shirt");
		root = ibtul.createReplace(root, p);
		Assert.assertTrue(root.t.pName == "T-shirt");
		// ibtul.inorderPrint(root);
	}

	/* search the node */
	@Test
	public void searchTest() {

		Product pArr[] = ProductTestUtils.producForTree();
		BTNode<Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtul.createReplace(root, pArr[i]);
		Product p = new Product(1, 8, 37, "6.mobile", "samsung");
		Product p1 = new Product(1, 8, 37, "7.mobile", "samsung");
		Assert.assertTrue(ibtul.search(root, p).t.pName == "samsung");
		Assert.assertTrue(ibtul.search(root, p1) == null);
	}

	/* delete the node and return the root */
	@Test
	public void deleteTest() {
		Product pArr[] = ProductTestUtils.producForTree();
		BTNode<Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtul.createReplace(root, pArr[i]);
		Product p = new Product(1, 5, 24, "1.textile", "T-shirt");
		Assert.assertTrue(ibtul.delete(root, p).t.pName == "analysis");
		// ibtul.inorderPrint(root);
	}

	/* inorder print */
	@Test
	public void inorderPrintTest() {
		Product pArr[] = ProductTestUtils.producForTree();
		BTNode<Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtul.createReplace(root, pArr[i]);
		// ibtul.inorderPrint(root);
	}

	@Test
	public void bstToListUtilsTest() {
		Product pArr[] = ProductTestUtils.producForTree();
		BTNode<Product> root = null;
		for (int i = 0; i < pArr.length; i++)
			root = ibtul.createReplace(root, pArr[i]);
		root = ibtul.bstToListUtils(root);
		while (root.lt != null)
			root = root.lt;
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 0;
		for (; root != null; root = root.rt) {
			Assert.assertTrue(root.t.pid == a[i++]);
		}
	}
}
