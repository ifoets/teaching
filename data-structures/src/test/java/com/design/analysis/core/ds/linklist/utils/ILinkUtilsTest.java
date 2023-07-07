package com.design.analysis.core.ds.linklist.utils;

import com.design.analysis.core.ds.linklist.node.SLNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.model.Product;
import com.design.analysis.core.ds.common.model.ProductTestUtils;

public class ILinkUtilsTest {

	public ILinkUtils<Product> ilu = null;

	@Before
	public void init() {
		ilu = new LinkUtils<>();
	}

	/* it is used in operation on value node */
	@Test
	public void addReplaceTest() {

		Product[] arr = ProductTestUtils.producForLink();
		SLNode<Product> head = null;
		for (int i = 0; i < arr.length; i++)
			head = ilu.addReplace(head, arr[i]);
		// ilu.display(head);
		Assert.assertTrue(head.k.pName == "computer");

	}

	@Test
	public void deleteTest() {

		Product[] arr = ProductTestUtils.producForLink();
		SLNode<Product> head = null;
		for (int i = 0; i < arr.length; i++)
			head = ilu.addReplace(head, arr[i]);
		Product p1 = new Product(0, 1, 11, "0.aaple", "computer1");
		Product p2 = new Product(1, 4, 14, "1.car", "bmw1");
		Product p3 = new Product(2, 9, 19, "2.lenavo", "desktop1");
		head = ilu.delete(head, p1);
		head = ilu.delete(head, p2);
		head = ilu.delete(head, p3);
		Assert.assertTrue(head.k.pName == "watch");
	}

	@Test
	public void searchNodeTest() {
		Product[] arr = ProductTestUtils.producForLink();
		SLNode<Product> head = null;
		for (int i = 0; i < arr.length; i++)
			head = ilu.addReplace(head, arr[i]);
		Product p1 = new Product(0, 1, 11, "0.aaple", "computer1");
		Product p2 = new Product(1, 4, 14, "1.car", "bmw1");
		Product p3 = new Product(2, 9, 19, "2.lenavo", "desktop1");

		Assert.assertTrue(ilu.searchNode(head, p1).k.equals(p1));
		Assert.assertTrue(ilu.searchNode(head, p2).k.equals(p2));
		Assert.assertTrue(ilu.searchNode(head, p3).k.equals(p3));
	}
}
