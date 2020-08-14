package com.design.analysis.ds.advance.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.advance.list.node.UnrollListNode;
import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.common.model.ProductTestUtils;

public class IUnrollListTest {

	public IUnrollList<Product> iul = null;

	@Before
	public void init() {
		iul = new UnrollListImpl();
	}

	@Test
	public void createInMassTest() {

		Product[] prdList = ProductTestUtils.producForUnrollList();
		UnrollListNode<Product> head = iul.createInMass(prdList);
		Product prd = new Product(1, 1, 0, "1.gold", "ring");
		Product prdNext = new Product(2, 4, 0, "2.car", "bmw");
		Product prdNextNext = new Product(3, 1, 0, "3.aaple", "computer");
		Assert.assertTrue(head.u[0].equals(prd));
		Assert.assertTrue(head.next.u[0].equals(prdNext));
		Assert.assertTrue(head.next.next.u[0].equals(prdNextNext));
		// iul.display(head);
	}

	@Test
	public void createInUnitTest() {
		Product[] prdList = ProductTestUtils.producForUnrollList();
		UnrollListNode<Product> head = iul.createInMass(prdList);
		Product prd = new Product(4, 4, 3, "4.textile", "shirt");
		Product prdNext = new Product(1, 4, 0, "2.car", "bmw");
		head = iul.createInUnit(prd);
		head = iul.createInUnit(prdNext);
		Assert.assertTrue(head.u[0].equals(prdNext));
		Assert.assertTrue(head.next.next.next.u[3].equals(prd));
		// iul.display(head);
	}

	@Test
	public void searchTest() {

		Product[] prdList = ProductTestUtils.producForUnrollList();
		UnrollListNode<Product> head = iul.createInMass(prdList);
		Product prd = new Product(4, 4, 3, "4.textile", "shirt");
		Product prdNext = new Product(1, 4, 0, "2.car", "bmw");
		Product prdx = new Product(4, 4, 1, "4.textile", "shirt");
		head = iul.createInUnit(prd);
		head = iul.createInUnit(prdNext);
		Assert.assertTrue(iul.search(head, prd).equals(prd));
		Assert.assertTrue(iul.search(head, prdNext).equals(prdNext));
		Assert.assertTrue(iul.search(head, prdx) == null);

	}

	@Test
	public void deleteTest() {
		Product[] prdList = ProductTestUtils.producForUnrollList();
		UnrollListNode<Product> head = iul.createInMass(prdList);
		Product prd = new Product(4, 4, 3, "4.textile", "shirt");
		Product prdNext = new Product(1, 4, 0, "2.car", "bmw");
		Product prdx = new Product(4, 4, 1, "4.textile", "shirt");
		head = iul.createInUnit(prd);
		head = iul.createInUnit(prdNext);
		Assert.assertTrue(iul.delete(head, prd));
		Assert.assertTrue(iul.delete(head, prdNext));
		Assert.assertTrue(!iul.delete(head, prdx));

	}
}
