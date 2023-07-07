package com.design.analysis.core.ds.advance.btree;

import com.design.analysis.core.ds.node.BTNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IAvlBSTreeTest {

	IAvlBSTree iat = null;
	BTNode root = null;

	@Before
	public void init() {

		iat = new AvlBSTreeImpl();
	}

	@Test
	public void createTest() {

		int arr[]={10,20,30,40,50,25};
		for(int i=0;i<arr.length;i++)
		root = iat.create(root, arr[i]);
		iat.inorderPrint(root);
		Assert.assertTrue(root.dt==30);
		Assert.assertTrue(root.lt.dt==20);
		Assert.assertTrue(root.rt.dt==40);
	}

	@Test
	public void levelPrintTest() {
        
		int arr[]={6,7,4,5,3};
		for(int i=0;i<arr.length;i++)
		root = iat.create(root, arr[i]);
		BTNode node = iat.rightRotate(root);
		iat.inorderPrint(node);
		Assert.assertTrue(node.dt==4);
		Assert.assertTrue(node.lt.dt==3);
		Assert.assertTrue(node.rt.dt==6);
		System.out.println();
	}

	@Test
	public void spirialPrintLefTest() {

		int arr[]={6,7,4,5,3};
		for(int i=0;i<arr.length;i++)
		root = iat.create(root, arr[i]);
		BTNode node = iat.rightRotate(root);
		BTNode node1 = iat.leftRotate(node);
		iat.inorderPrint(node1);
		Assert.assertTrue(node1.dt==6);
		Assert.assertTrue(node1.lt.dt==4);
		Assert.assertTrue(node1.rt.dt==7);
		System.out.println();
	}

	@Test
	public void spiralPrintRightTest() {

	}
}
