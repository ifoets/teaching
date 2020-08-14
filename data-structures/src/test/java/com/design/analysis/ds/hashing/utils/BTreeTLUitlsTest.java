/**
 * 
 */
package com.design.analysis.ds.hashing.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.hashing.key2.node.HK2TLNode;

/**
 * @author @Gurug
 *
 */
public class BTreeTLUitlsTest {

	public BTreeTLUitls<Integer, Product> util = null;

	@Before
	public void init() {
		util = new BTreeTLUitls<>();
	}

	@Test
	public void createBstTest() {

		Integer a[] = { 5, 2, 7, 3, 1, 0, 6, 8, 9 };
		HK2TLNode<Integer, Product> root = null;
		for (int i = 0; i < a.length; i++)
			root = util.createBst(root, a[i]);
		util.inOrderPrint(root);
	}

	@Test
	public void recvSearchTest() {

		Integer a[] = { 5, 2, 7, 3, 1, 0, 6, 8, 9 };
		HK2TLNode<Integer, Product> root = null;
		for (int i = 0; i < a.length; i++)
			root = util.createBst(root, a[i]);
		// util.inOrderPrint(root);
		Assert.assertTrue(util.recvSearch(root, 6).k == 6);
		Assert.assertTrue(util.recvSearch(root, 0).k == 0);
		Assert.assertTrue(util.recvSearch(root, 9).k == 9);

		Assert.assertTrue(util.recvSearch(root, 90) == null);
		Assert.assertTrue(util.recvSearch(root, -1) == null);

	}
	
	@Test
	public void deleteTest()
	{
		Integer a[] = { 5, 2, 7, 3, 1, 0, 6, 8, 9 };
		HK2TLNode<Integer, Product> root = null;
		for (int i = 0; i < a.length; i++)
			root = util.createBst(root, a[i]);
		//util.inOrderPrint(root);
		
		root =util.delete(root, 5);
		root =util.delete(root, 2);
		root =util.delete(root, 0);
		
		root =util.delete(root, 9);
		root =util.delete(root, 3);
		System.out.println("\n after deletion");
		util.inOrderPrint(root);
		Assert.assertTrue(util.recvSearch(root, 7).k == 7);
		Assert.assertTrue(util.recvSearch(root, 8).k == 8);
		Assert.assertTrue(util.recvSearch(root, 1).k == 1);
	}
}
