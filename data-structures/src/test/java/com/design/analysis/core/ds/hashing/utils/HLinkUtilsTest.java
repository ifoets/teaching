package com.design.analysis.core.ds.hashing.utils;

import com.design.analysis.core.ds.hashing.node.HLNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.model.Product;

public class HLinkUtilsTest {

	public IHLinkUtils<Integer, Integer, Integer, Product> utill = null;

	@Before
	public void init() {
		utill = new HLinkUtils<>();
	}

	@Test
	public void addReplaceTest() {
		Product arr[] = new Product[9];
		int k = 0;
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(0, 2, 11, "1.aaple", "computer");
			arr[k++] = new Product(0, 2, 12, "1.aaple", "watch");
			arr[k++] = new Product(0, 2, 13, "1.aaple", "mobile");
			arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
			arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			arr[k++] = new Product(0, 5, 16, "2.aaple", "aaa");
			arr[k++] = new Product(0, 5, 17, "2.aaple", "bbb");
			arr[k++] = new Product(0, 5, 18, "2.aaple", "ccc");
			arr[k++] = new Product(0, 5, 19, "2.aaple", "ddd");
		}

		HLNode<Product> head = null;
		for (int i = 0; i < arr.length; i++)
			head = utill.addReplace(head, arr[i]);
		head = utill.addReplace(head, new Product(0, 2, 11, "1.aaple", "Newcomputer"));
		Assert.assertTrue(head.t.pName.equals("Newcomputer"));
	}

	@Test
	public void deleteTest() {

		HLNode<Product> head = null;
		Product p = new Product(0, 2, 11, "1.aaple", "Newcomputer");
		head = utill.addReplace(head, new Product(0, 2, 11, "1.aaple", "Newcomputer"));
		Assert.assertTrue(head.t.pName.equals("Newcomputer"));
		head = utill.delete(head, p);
		Assert.assertTrue(head == null);
		head = utill.addReplace(head, new Product(0, 2, 12, "1.aaple", "computer"));
		head = utill.addReplace(head, new Product(0, 2, 11, "1.aaple", "Newcomputer"));
		head = utill.delete(head, p);
		Assert.assertTrue(head.next == null);
	}

	@Test
	public void searchNodeTest() {

		Product arr[] = new Product[9];
		int k = 0;
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(0, 2, 11, "1.aaple", "computer");
			arr[k++] = new Product(0, 2, 12, "1.aaple", "watch");
			arr[k++] = new Product(0, 2, 13, "1.aaple", "mobile");
			arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
			arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			arr[k++] = new Product(0, 5, 16, "2.aaple", "aaa");
			arr[k++] = new Product(0, 5, 17, "2.aaple", "bbb");
			arr[k++] = new Product(0, 5, 18, "2.aaple", "ccc");
			arr[k++] = new Product(0, 5, 19, "2.aaple", "ddd");
		}

		Product p = new Product(0, 2, 11, "1.aaple", "computerNew");
		Product p1 = new Product(0, 2, 11, "1.aaple1", "computerNew");
		HLNode<Product> head = null;
		for (int i = 0; i < arr.length; i++)
			head = utill.addReplace(head, arr[i]);
		head = utill.addReplace(head, new Product(0, 2, 11, "1.aaple", "Newcomputer"));
		Assert.assertTrue(utill.searchNode(head, p).t.equals(p));
		Assert.assertTrue(utill.searchNode(head, p1) == null);
		p = new Product(0, 5, 19, "2.aaple", "ddd");
		Assert.assertTrue(utill.searchNode(head, p).t.pName == "ddd");

	}

	/* add/replace value in inner link list */
	// TODO
	public void addReplaceInnerNodeTest() {

	}

	/* returning the searching node in link */
	@Test // TODO
	public void searchTest() {

	}
}
