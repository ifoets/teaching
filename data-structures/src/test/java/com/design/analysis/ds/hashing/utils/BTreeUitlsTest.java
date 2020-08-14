/**
 * 
 */
package com.design.analysis.ds.hashing.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.hashing.node.HTNode;
import com.design.analysis.ds.tree.node.BTNode;

/**
 * @author @Gurug
 *
 */
public class BTreeUitlsTest {

	public BTreeUitls<Integer> util = null;

	@Before
	public void init() {
		util = new BTreeUitls<>();
	}

	@Test
	public void createBstTest() {

		Integer a[] = { 5, 2, 7, 3, 1, 0, 6, 8, 9 };
		HTNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = util.createBst(root, a[i]);
		util.inOrderPrint(root);
	}

	@Test
	public void recvSearchTest() {

		Integer a[] = { 5, 2, 7, 3, 1, 0, 6, 8, 9 };
		HTNode<Integer> root = null;
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
		HTNode<Integer> root = null;
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
	
	@Test
	public void bstToListUtilsTest() {
		Integer arr[]= {5,7,3,2,6,4,8,9,1};
		BTNode<Integer> root = null;
		for (int i = 0; i < arr.length; i++)
			root = util.createBst(root, arr[i]);
		root = util.bstToListUtils(root);
		while (root.lt != null)
			root = root.lt;
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 0;
		for (; root != null; root = root.rt) {
			Assert.assertTrue(root.t == a[i++]);
		}
	}
}
