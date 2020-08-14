package com.design.analysis.ds.link.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.common.model.ProductTestUtils;
import com.design.analysis.ds.tree.node.LBTNode;

public class ILinkBsTreeTest {

	public ILinkBstTree<Integer, Product> ilbt = null;

	@Before
	public void init() {
		ilbt = new LinkBsTreeImpl();
	}

	/* operation on link having bst */
	/* create link and inner bst used by link */
	@Test
	public void addReplaceTest() {

		Product p[] = ProductTestUtils.producForLinkTree();
		LBTNode<Integer, Product> head = null;
		for (int i = 0; i < p.length; i++) {
			head = ilbt.addReplace(head, p[i]);
		}
		// ilbt.print(head);
		Assert.assertTrue(head.down.t.pName == "computer");
		Assert.assertTrue(head.next.down.t.pName == "watch");
		Assert.assertTrue(head.next.next.down.t.pName == "shirt");
	}

	/* search link node in inner link of bst */
	@Test
	public void searchTest() {
		Product p[] = ProductTestUtils.producForLinkTree();
		LBTNode<Integer, Product> head = null;
		for (int i = 0; i < p.length; i++) {
			head = ilbt.addReplace(head, p[i]);
		}
		Product p1 = new Product(3, 3, 11, "3.aaple", "computer");
		Product p2 = new Product(3, 5, 12, "3.aaple", "watch");

		Assert.assertTrue(ilbt.search(head, p1).t.equals(p1));
		Assert.assertTrue(ilbt.search(head, p2).t.equals(p2));
	}

	/* delete link node in inner link of bst */
	@Test
	public void deleteTest() {

		Product p[] = ProductTestUtils.producForLinkTree();
		LBTNode<Integer, Product> head = null;
		for (int i = 0; i < p.length; i++) {
			head = ilbt.addReplace(head, p[i]);
		}
		Product p1 = new Product(3, 3, 11, "3.aaple", "computer");
		Product p2 = new Product(3, 5, 12, "3.aaple", "watch");
		Assert.assertTrue(ilbt.delete(head, p1));
		Assert.assertTrue(ilbt.delete(head, p2));

		Assert.assertTrue(ilbt.search(head, p1) == null);
		Assert.assertTrue(ilbt.search(head, p2) == null);
	}

	/* print the bstNode and list inner to it */
	@Test
	public void printTest() {
		Product p[] = ProductTestUtils.producForLinkTree();
		LBTNode<Integer, Product> head = null;
		for (int i = 0; i < p.length; i++) {
			head = ilbt.addReplace(head, p[i]);
		}
		ilbt.print(head);
	}
}
