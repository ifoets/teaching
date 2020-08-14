package com.design.analysis.ds.linklist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.linklist.node.SLNode;
import com.design.analysis.ds.linklist.utils.Lap;

public class ISCLinkListTest {

	public ISCLinkList<Integer> iscl = null;

	@Before
	public void init() {
		iscl = new SCLinkListImpl();
	}

	/** 3. Linked List Insertion **/
	@Test
	public void insertArrTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = iscl.insertArrLast(null, a);
		SLNode<Integer> head = lap.getHead();
		iscl.printList(head);
		// 1->2->3->4->5->6->7->8->9->
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.next.k == 3);
		Assert.assertTrue(head.next.next.next.next.k == 5);

		Integer b[] = { 10, 11, 12 };
		lap = iscl.insertArrLast(lap, b);
		// iscl.printList(head);
		// 1->2->3->4->5->6->7->8->9->10->11->12->
	}

	/* insert single element */
	@Test
	public void insertElementLastTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = iscl.insertArrLast(null, a);
		SLNode<Integer> head = lap.getHead();
		// isl.printList(head);
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.next.k == 3);
		Assert.assertTrue(head.next.next.next.next.k == 5);

		Integer b[] = { 10, 11, 12 };
		lap = iscl.insertArrLast(lap, b);
		System.out.println();
		iscl.printList(head);

	}

	/** 3. Split a Circular Linked List into two halves **/
	@Test
	public void splitTwoHalvesTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = iscl.insertArrLast(null, a).getHead();
		Lap<SLNode<Integer>, SLNode<Integer>> lap = iscl.splitTwoHalves(head);
		SLNode<Integer> h1 = lap.getHead();
		SLNode<Integer> h2 = lap.getTail();
		iscl.printList(h1);
		System.out.println();
		iscl.printList(h2);
	}

	/** 4. Sorted insert for circular linked list **/
	/* insert collection of element in sorted order */
	@Test
	public void insertArrSortedTest() {
		Integer a[] = { 8, 7, 9, 2, 3, 4, 0, 1, 5, 6 };
		SLNode<Integer> head = iscl.insertArrSorted(null, a);
		System.out.println("\nprintSorted order list");
		iscl.printList(head);
		Assert.assertTrue(head.k == 0);
		Assert.assertTrue(head.next.next.k == 2);
		Assert.assertTrue(head.next.next.next.next.k == 4);
	}

	@Test
	public void deleteAllXTest() {
		SLNode<Integer> head = null;
		Integer a[] = { 1, 1, 0, 1, 0, 2, 3, 1 };
		Integer b[] = { 1, 2, 2, 3, 2, 4, 2, 5, 2 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = iscl.insertArrLast(null, a);
		head = lap.getHead();
		System.out.println();
		iscl.printList(head);
		head = iscl.deleteAllX(head, 1);
		System.out.println();
		iscl.printList(head);
		Assert.assertTrue(head.k == 0);
		Assert.assertTrue(head.next.k == 0);
		Assert.assertTrue(head.next.next.k == 2);
		head = null;
		System.out.println();
		head = iscl.insertArrLast(null, b).getHead();
		iscl.printList(head);
		head = iscl.deleteAllX(head, 2);
		System.out.println();
		iscl.printList(head);
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 3);
		Assert.assertTrue(head.next.next.k == 4);
	}
}
