package com.design.analysis.ds.advance.btree;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.advance.btree.BinaryTreeImpl;
import com.design.analysis.ds.advance.btree.IBinaryTree;
import com.design.analysis.ds.node.BTNode;

public class IBinaryTreeTest {

	public IBinaryTree ibt;
	BTNode root = null;

	@Before
	public void beforeLoad() {
		ibt = new BinaryTreeImpl();
	}

	@Test
	public void testMe() {
		Assert.assertTrue(ibt != null);
	}

	@Test
	public void lavelOrderTest() {

		BTNode root1 = null;

		int a[] = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = i;
			root = ibt.create(root, i);
		}
		root1 = ibt.insert(null, a, 0, a.length);
		ibt.levelPrint(root);
		System.out.println();
		ibt.lavelOrderPrint(root1);
	}
	
	@Test
	public void inorderSuccessorTest()
	{
		int a[] = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = i;
			root = ibt.create(root, i);
		}
		BTNode root1 = ibt.insert(null, a, 0, a.length);
		ibt.levelPrint(root);
		System.out.println();
		ibt.lavelOrderPrint(root1);
	}
	
	@Test
	public void createBstTest()
	{
		int a[]={5,3,7,4,2,6,8};
		
		BTNode node = null;
		for(int i=0;i<a.length;i++)
			node = ibt.createBst(node, a[i]);
		ibt.print(node);
	}
	
	@Test
	public void imageTest()
	{
		System.out.println();
		int a[]={5,3,7,4,2,6,8};
		
		BTNode node = null;
		for(int i=0;i<a.length;i++)
			node = ibt.createBst(node, a[i]);
		ibt.print(node);
		System.out.println();
		node=ibt.image(node);
		ibt.print(node);
	}
	
	@Test
	public void createBstIndexTest()
	{
		System.out.println();
		int a[]={5,3,7,4,2,6,8};
		
		BTNode node = null;
		for(int i=0;i<a.length;i++)
			node = ibt.createBstIndex(node, a[i],0);
		ibt.print(node);
		System.out.println();
		node=ibt.image(node);
		List<BTNode> list = ibt.printVertical(node);
		Collections.sort(list);
		System.out.println(list.toString());
	}
	
	@Test
	public void deleteCompletlyTest()
	{
        int a[]={5,3,7,4,2,6,8};
		
		BTNode node = null;
		for(int i=0;i<a.length;i++)
			node = ibt.createBst(node, a[i]);
		ibt.print(node);	
		ibt.deleteCompletly(node);
		node = null;
		System.out.println("after completly deletion of tree");
		ibt.print(node);
	}
	
	@Test
	public void recvSearchTest()
	{
		int a[]={5,3,7,4,2,6,8};
		
		BTNode node = null;
		for(int i=0;i<a.length;i++)
			node = ibt.createBst(node, a[i]);
		ibt.print(node);	
		BTNode searched1 = ibt.recvSearch(node, 7);
		BTNode searched2 = ibt.recvSearch(node, 0);
		
		Assert.assertTrue(searched1.dt == 7);
		Assert.assertTrue(searched2 == null);
		
	}
	@Test
	public void inorderSuccessorTestNew()
	{
		System.out.println("\ninorderSuccessor testing start");
		 int a[]={5,3,7,4,2,6,8,10,9,0,1};
			
			BTNode node = null;
			for(int i=0;i<a.length;i++)
				node = ibt.createBst(node, a[i]);
			ibt.inOrder(node);	
			
			BTNode n1 = ibt.inorderSuccessor(node, 10,true);
			Assert.assertTrue(n1 == null);
			BTNode n2 = ibt.inorderSuccessor(node, 5,false);
			Assert.assertTrue(n2.dt == 6);
			BTNode n3 = ibt.inorderSuccessor(node, 2,false);
			Assert.assertTrue(n3.dt == 3);
			BTNode n4 = ibt.inorderSuccessor(node, 9, false);
			Assert.assertTrue(n4.dt == 10);
			
			BTNode n5 = ibt.inorderSuccessor(node, 8, false);
			Assert.assertTrue(n5.dt == 9);
		
			BTNode n6 = ibt.inorderSuccessor(node, 0,false);
			Assert.assertTrue(n6.dt == 1);
			BTNode n7 = ibt.inorderSuccessor(node, 7,false);
			Assert.assertTrue(n7.dt == 8);
			BTNode n8 = ibt.inorderSuccessor(node, 6,false);
			Assert.assertTrue(n8.dt == 7);
			BTNode n9 = ibt.inorderSuccessor(node, 4,false);
			Assert.assertTrue(n9.dt == 5);
			
			System.out.println("\ninorderSuccessor testing end\n");
	}
	
	@Test
	public void inorderPredecessorTestNew()
	{
		System.out.println("\ninorderSuccessor testing start");
		 int a[]={5,3,7,4,2,6,8,10,9,0,1};
			
			BTNode node = null;
			for(int i=0;i<a.length;i++)
				node = ibt.createBst(node, a[i]);
			ibt.inOrder(node);	
			
			BTNode n1 = ibt.inorderPredecessor(node, 0,true);
			Assert.assertTrue(n1 == null);
			BTNode n2 = ibt.inorderPredecessor(node, 5,false);
			Assert.assertTrue(n2.dt == 4);
			BTNode n3 = ibt.inorderPredecessor(node, 2,false);
			Assert.assertTrue(n3.dt == 1);
			BTNode n4 = ibt.inorderPredecessor(node, 9, false);
			Assert.assertTrue(n4.dt == 8);
			
			BTNode n5 = ibt.inorderPredecessor(node, 8, false);
			Assert.assertTrue(n5.dt == 7);
		
			BTNode n6 = ibt.inorderPredecessor(node, 0,true);
			Assert.assertTrue(n6 == null);
			BTNode n7 = ibt.inorderPredecessor(node, 7,false);
			Assert.assertTrue(n7.dt == 6);
			BTNode n8 = ibt.inorderPredecessor(node, 6,false);
			Assert.assertTrue(n8.dt == 5);
			BTNode n9 = ibt.inorderPredecessor(node, 4,false);
			Assert.assertTrue(n9.dt == 3);
			
			System.out.println("\ninorderSuccessor testing end\n");
	}
	
	@Test
	public void deleteTest()
	{
		int a[]={5,3,7,4,2,6,8,10,9,0,1};
		 	
			BTNode node = null;
			for(int i=0;i<a.length;i++)
				node = ibt.createBst(node, a[i]);
			System.out.println("\nDeleting node test start\n");
			ibt.inOrder(node);	
			System.out.println("\n4 deleted");
			node = ibt.delete(node, 4);
			ibt.inOrder(node);	
			System.out.println("\n6 deleted");
			node = ibt.delete(node, 6);
			ibt.inOrder(node);
			int c[]={4,6};
			for(int i =0;i<c.length;i++)
				node = ibt.create(node, c[i]);
			System.out.println("\n4 and 6 added");
			ibt.inOrder(node);
			
			System.out.println("\n3 deleted");
			node = ibt.delete(node, 3);
			ibt.inOrder(node);
			
			System.out.println("\n7 deleted");
			node = ibt.delete(node, 7);
			ibt.inOrder(node);
			
			System.out.println("\n5 deleted");
			node = ibt.delete(node, 5);
			ibt.inOrder(node);
			
			System.out.println("\n0 deleted");
			node = ibt.delete(node, 0);
			ibt.inOrder(node);
			
			//int b[]={9,5,13,3,7,11,17,2,4,6,8,10,12,15,19,0,1,14,16};
			System.out.println("\nDeleting node test end\n");
			
			System.out.println("new test of deleting node  start");
			node = null;
			int b[]={9,5,13,3,7,11,17,2,4,6,8,10,12,15,19,0,1,14,16};
			for(int i=0;i<b.length;i++)
				node = ibt.createBst(node, b[i]);
			ibt.inOrder(node);
			System.out.println("\n5 deleted");
			node = ibt.delete(node, 5);
			ibt.inOrder(node);
			
			System.out.println("\n13 deleted");
			node = ibt.delete(node, 13);
			ibt.inOrder(node);
			
			System.out.println("\n13 deleted");
			node = ibt.delete(node, 15);
			ibt.inOrder(node);
			
			System.out.println("\n0 deleted");
			node = ibt.delete(node, 0);
			ibt.inOrder(node);
			
			System.out.println("\n-1 deleted");
			node = ibt.delete(node, -1);
			ibt.inOrder(node);
			//Assert.assertTrue(x==null);
			
			System.out.println("new test of deleting node  end");
	}
	
	
	@Test
	public void createBstDuplicateTest()
	{
		//int a[]={5,3,2,1};
		int a[]={5,3,7,4,2,6,8,10,9,0,1,4,2,3,8,0,0,4,2,3,5,5,};
	 	System.out.println("\nDuplicate node insertion in tree stat\n");
		BTNode node = null;
		for(int i=0;i<a.length;i++)
			node = ibt.createBstDuplicate(node, a[i]);
		ibt.print(node);
		System.out.println("\nDuplicate node insertion in tree end\n");
	}
}