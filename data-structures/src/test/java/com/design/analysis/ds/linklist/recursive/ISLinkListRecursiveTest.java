package com.design.analysis.ds.linklist.recursive;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.node.SLNode;

public class ISLinkListRecursiveTest {

	ISLinkListRecursive isllr = null;

	@Before
	public void init() {

		isllr = new SLinkListRecursiveImpl();
	}

	@Test
	public void createTest() {

		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		System.out.println("\nprint");
		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		isllr.display(node);
		Assert.assertTrue(node.dt==1);
	}

	@Test
	public void lengthTes() {
		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		System.out.println("Reverse print");
		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		Assert.assertTrue(isllr.length(node)==10);
	}

	@Test
	public void sumTest() {

		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("Reverse print");
		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		Assert.assertTrue(isllr.sum(node)==55);
	}

	@Test
	public void reversePrintTest() {

		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		System.out.println("Reverse print");
		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		isllr.reversePrint(node);
	}
	
	@Test
	public void searchTest()
	{
		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		System.out.println("Reverse print");
		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		Assert.assertTrue(isllr.search(node,-7)==-1);
		Assert.assertTrue(isllr.search(node,7)==7);
	}
	
	@Test
	public void addRearTest()
	{
		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};

		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		node = isllr.addRear(node, 0);
		Assert.assertTrue(node.dt==0);
		isllr.display(node);
	}
	/*TODO
	@Test
	public void addAtPoistionTest()
	{
		SLNode node = null;
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};

		for (int i = 0; i < arr.length; i++)
			node = isllr.create(node, arr[i]);
		node = isllr.addAtPoistion(node, 10,2,0);
		//Assert.assertTrue(node.dt==0);
		isllr.display(node);
	}*/
}
