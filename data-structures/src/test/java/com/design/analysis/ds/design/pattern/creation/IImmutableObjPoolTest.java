package com.design.analysis.ds.design.pattern.creation;

import org.junit.Assert;
import org.junit.Test;

import com.design.analysis.ds.design.pattern.node.TPoolNode;
import com.design.analysis.ds.design.pattern.template.Human;

public class IImmutableObjPoolTest {

	public static IImmutableObjPool<Human> iip = new ImmutableObjPoolImpl();

	/** creating hashtable for pooling **/
	@Test
	public void cretePoolTest() {
		int N = 10;
		TPoolNode<Human> tp[] = iip.cretePool(N);
		Assert.assertTrue(tp.length == N);
		Assert.assertTrue(tp[0] == null);
		Assert.assertTrue(tp[9] == null);

	}

	/** linking datastructue is tree for searching fast **/
	@Test
	public void createTreeTest() {

		TPoolNode<Human> node = null;
		String names[] = { "5", "3", "7", "2", "4", "6", "8" };
		for (int i = 0; i < names.length; i++) {
			node = iip.createTree(node, new Human(names[i], 1));
		}
		iip.printInorderTree(node);
	}

	public static void main(String[] args) {
		System.out.println(new Human("6", 1).equals(new Human("6", 1)));
	}

	/** search in tree to stop duplicate creation of node **/
	@Test
	public void searchInTreeTest() {
		TPoolNode<Human> node = null;
		String names[] = { "5", "3", "7", "2", "4", "6", "8" };
		for (int i = 0; i < names.length; i++) {
			node = iip.createTree(node, new Human(names[i], 1));
		}
		Assert.assertTrue(iip.searchInTree(node, new Human("6", 1)).i.equals(new Human("6", 1)));
	}

	/** searching object in pool before adding new one in pool **/
	@Test
	public void serchObjInPoolTest() {

		int N = 10;
		@SuppressWarnings("unused")
		TPoolNode<Human> tp[] = iip.cretePool(N);

		String names[] = { "5", "3", "7", "2", "4", "6", "8" };
		String dupNames[] = { "3", "4", "2", "4" };
		for (int i = 0; i < names.length; i++) {
			Assert.assertTrue(iip.addObjInPool(new Human(names[i], 1)));
		}
		for (int i = 0; i < dupNames.length; i++) {
			Assert.assertTrue(iip.serchObjInPool(new Human(dupNames[i], 1)).i.getName().equals(dupNames[i]));
		}

	}

	/** adding object to pool **/
	@Test
	public void addObjInPoolTest() {

		int N = 10;
		@SuppressWarnings("unused")
		TPoolNode<Human> tp[] = iip.cretePool(N);

		String names[] = { "5", "3", "7", "2", "4", "6", "8" };
		String dupNames[] = { "3", "4", "2", "4" };
		for (int i = 0; i < names.length; i++) {
			Assert.assertTrue(iip.addObjInPool(new Human(names[i], 1)));
		}

		// try to add duplicate object
		for (int i = 0; i < dupNames.length; i++) {
			Assert.assertTrue(!iip.addObjInPool(new Human(dupNames[i], 1)));
		}

		iip.printPool();

	}

	/** finding object in pool **/
	@Test
	public void getObjFromPoolTest() {
		int N = 10;
		@SuppressWarnings("unused")
		TPoolNode<Human> tp[] = iip.cretePool(N);

		String names[] = { "5", "3", "7", "2", "4", "6", "8" };
		String dupNames[] = { "3", "4", "2", "4" };
		for (int i = 0; i < names.length; i++) {
			Assert.assertTrue(iip.addObjInPool(new Human(names[i], 1)));
		}
		// try to find the object from pool
		for (int i = 0; i < dupNames.length; i++) {
			Assert.assertTrue(iip.getObjFromPool(new Human(dupNames[i], 1)).i.getName().equals(dupNames[i]));
		}
	}

	/** print tree in inorder **/
	@Test
	public void printInorderTreeTest() {
		// tested in above test case
	}

	/** print the pool **/
	@Test
	public void printPoolTest() {
		// tested in above test case
	}
}
