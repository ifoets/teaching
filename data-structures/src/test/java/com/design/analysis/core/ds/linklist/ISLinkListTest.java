package com.design.analysis.core.ds.linklist;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.ds.linklist.node.FlatLNode;
import com.design.analysis.core.ds.linklist.node.PointNode;
import com.design.analysis.core.ds.linklist.node.SLNode;
import com.design.analysis.core.ds.linklist.utils.Lap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.design.analysis.core.ds.common.Point;

public class ISLinkListTest {

	public ISLinkList<Integer> isl = null;

	@Before
	public void init() {
		isl = new SLinkListImpl();
	}

	/** delete a givin node without head pointer **/
	@Test
	public void deleteNode() {
		Integer a[] = { 8, 7, 9, 2, 3, 4, 0, 1, 5, 6 };
		SLNode<Integer> head = isl.insertArrSorted(null, a);
		SLNode<Integer> q = head.next.next.next.next.next;
		isl.deleteNode(q);
		isl.printList(head);
	}

	/** 3. Linked List Insertion **/
	@Test
	public void insertArrTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = lap.getHead();
		// isl.printList(head);
		// 1->2->3->4->5->6->7->8->9->
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.next.k == 3);
		Assert.assertTrue(head.next.next.next.next.k == 5);

		Integer b[] = { 10, 11, 12 };
		lap = isl.insertArrLast(lap, b);
		// isl.printList(head);
		// 1->2->3->4->5->6->7->8->9->10->11->12->
	}

	/* insert single element */
	@Test
	public void insertElementLastTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = lap.getHead();
		// isl.printList(head);
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.next.k == 3);
		Assert.assertTrue(head.next.next.next.next.k == 5);

		Integer b[] = { 10, 11, 12 };
		lap = isl.insertArrLast(lap, b);
		// isl.printList(head);

	}

	/* insert collection of element in sorted order */
	@Test
	public void insertArrSortedTest() {
		Integer a[] = { 8, 7, 9, 2, 3, 4, 0, 1, 5, 6 };
		SLNode<Integer> head = isl.insertArrSorted(null, a);
		// System.out.println("\nprintSorted order list");
		isl.printList(head);
		Assert.assertTrue(head.k == 0);
		Assert.assertTrue(head.next.next.k == 2);
		Assert.assertTrue(head.next.next.next.next.k == 4);
	}

	/* insert at given position head is at 1st position */
	@Test
	public void insertAtPositionTest() {
		Integer a[] = { 3, 5, 6, 7, 8 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = lap.getHead();
		isl.insertAtPosition(head, 1, 2);
		isl.insertAtPosition(head, 1, 1);
		/*
		 * isl.insertAtPosition(head, 4, 4); isl.insertAtPosition(head, 9, 9);
		 * isl.insertAtPosition(head, 0, 10); isl.insertAtPosition(head, 10, 10);
		 */
		System.out.println("\n");
		isl.printList(head);
	}

	/** 4. Linked List Deletion (Deleting a given key) **/
	@Test
	public void deleteFirstKTest() {
		Integer k[] = {};
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, k);

		Assert.assertTrue(lap == null);
		Integer a[] = { 1 };
		lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = lap.getHead();
		head = isl.deleteFirstK(head, 1);
		Assert.assertTrue(head == null);

		Integer b[] = { 10, 11 };
		lap = isl.insertArrLast(null, b);
		head = lap.getHead();
		head = isl.deleteFirstK(head, 11);
		Assert.assertTrue(head.k == 10);
		Assert.assertTrue(head.next == null);
		// isl.printList(head);
	}

	/* . Linked List Deletion (Deleting a given key) */
	@Test
	public void deleteAllXTest() {
		SLNode<Integer> head = null;
		Integer a[] = { 1, 1, 0, 1, 0, 2, 3, 1 };
		Integer b[] = { 1, 2, 2, 3, 2, 4, 2, 5, 2 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		// isl.printList(head);
		head = isl.deleteAllX(head, 1);
		// isl.printList(head);
		Assert.assertTrue(head.k == 0);
		Assert.assertTrue(head.next.k == 0);
		Assert.assertTrue(head.next.next.k == 2);
		head = null;
		lap = isl.insertArrLast(null, b);
		// isl.printList(head);
		head = isl.deleteAllX(lap.getHead(), 2);
		// isl.printList(head);
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 3);
		Assert.assertTrue(head.next.next.k == 4);
	}

	/* delete the last occurrence of node */
	@Test
	public void deleteLastKTest() {

		SLNode<Integer> head = null;
		Integer a[] = { 2, 4, 0, 1, 0, 2, 3, 1 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		head = isl.deleteLastK(head, 2);
		Assert.assertTrue(head.next.next.next.next.next.k == 3);
		head = isl.deleteLastK(head, 2);
		head = isl.deleteLastK(head, 1);
		head = isl.deleteLastK(head, 10);
		Assert.assertTrue(head.k == 4);
	}

	/* delete the last occurrence of node */
	@Test
	public void deleteLastKXTest() {
		SLNode<Integer> head = null;
		Integer a[] = { 2, 4, 0, 1, 0, 2, 3, 1 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		head = isl.deleteLastKX(head, 2);
		Assert.assertTrue(head.next.next.next.next.next.k == 3);
		head = isl.deleteLastKX(head, 2);
		head = isl.deleteLastKX(head, 1);
		head = isl.deleteLastKX(head, 10);
		Assert.assertTrue(head.k == 4);
	}

	/** 5. Linked List Deletion (Deleting a key at given position) **/
	@Test
	public void deletePosTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		head = isl.deletePos(head, 1);
		head = isl.deletePos(head, 2);
		head = isl.deletePos(head, 7);
		head = isl.deletePos(head, 7);
		Assert.assertTrue(head.k == 2);
		Assert.assertTrue(head.next.k == 4);
		Assert.assertTrue(head.next.next.k == 5);

		// System.out.println("Deletion of position start");
		// isl.printList(head);
		// System.out.println("\nDeletion of position end");
	}

	/** 6. Find Length of a Linked List (Iterative and Recursive) **/
	/* Iterative */
	@Test
	public void lengthIterativeTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		Assert.assertTrue(isl.lengthIterative(head) == 9);
	}

	/* Recursive */
	@Test
	public void lengthRecursiveTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();

		Assert.assertTrue(isl.lengthRecursive(head) == 9);
	}

	/** 7. Search an element in a Linked List (Iterative and Recursive) **/
	/* Iterative */
	@Test
	public void searchIterativeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		Assert.assertTrue(isl.searchIterative(head, 1).k == 1);
		Assert.assertTrue(isl.searchIterative(head, 9).k == 9);
		Assert.assertTrue(isl.searchIterative(head, 5).k == 5);
		Assert.assertTrue(isl.searchIterative(head, 10) == null);
	}

	/* Recursive */
	@Test
	public void searchRecursiveTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();

		Assert.assertTrue(isl.searchRecursive(head, 1).k == 1);
		Assert.assertTrue(isl.searchRecursive(head, 9).k == 9);
		Assert.assertTrue(isl.searchRecursive(head, 5).k == 5);
		Assert.assertTrue(isl.searchRecursive(head, 10) == null);
	}

	/** 8. Swap nodes in a linked list without swapping data **/
	@Test
	public void swapNodesTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();

		head = isl.swapNodes(head, 1, 9);
		head = isl.swapNodes(head, 1, 6);
		head = isl.swapNodes(head, 9, 8);
		head = isl.swapNodes(head, 3, 7);
		// System.out.println("\nafter swap of node");
		// isl.printList(head);
	}

	/** 9. Write a function to get Nth node in a Linked List head 1st node **/
	@Test
	public void getNthNodeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();

		Assert.assertTrue(isl.getNthNode(head, 1).k == 1);
		Assert.assertTrue(isl.getNthNode(head, 5).k == 5);
		Assert.assertTrue(isl.getNthNode(head, 9).k == 9);
	}

	/** 10. Print the middle of a given linked list **/
	@Test
	public void getMiddelNodesTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();

		List<SLNode<Integer>> list = isl.getMiddelNodes(head);
		Assert.assertTrue(list.get(0).k == 4);
		Assert.assertTrue(list.get(1).k == 5);

		Integer b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		lap = isl.insertArrLast(null, b);
		head = lap.getHead();
		list = isl.getMiddelNodes(head);
		Assert.assertTrue(list.size() == 1);
		Assert.assertTrue(list.get(0).k == 5);
	}

	/** 11. Nth node from the end of a Linked List **/
	@Test
	public void nthNodeFromEndTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		Assert.assertTrue(isl.nthNodeFromEnd(head, 1).k == 9);
		Assert.assertTrue(isl.nthNodeFromEnd(head, 3).k == 7);
		Assert.assertTrue(isl.nthNodeFromEnd(head, 10).k == 0);
	}

	/** 12. Write a function to delete a Linked List **/
	@Test
	public void deleteListTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		isl.deleteList(head);
		Assert.assertTrue(head.next == null);
	}

	@Test
	public void countXValNodesTest() {
		Integer a[] = { 9, 1, 4, 3, 4, 5, 4, 7, 4, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		Assert.assertTrue(isl.countXValNodes(head, 9) == 2);
		Assert.assertTrue(isl.countXValNodes(head, 5) == 1);
		Assert.assertTrue(isl.countXValNodes(head, 4) == 4);
	}

	/** 14. Reverse a linked list recursive **/
	@Test
	public void reverseRcvTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		head = lap.getHead();
		head = isl.reverseRcv(head);
		Assert.assertTrue(head.k == 9);
		Assert.assertTrue(head.next.k == 8);
		Assert.assertTrue(head.next.next.k == 7);
	}

	/** 15. Detect loop in a linked list **/
	/* create list that captain loop by mistake */
	@Test
	public void linkContainLoopTes() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = isl.linkContainLoop(null, a);
		int count = 0;
		for (; head != null; head = head.next) {
			if (count++ == 100)
				break;
		}
		Assert.assertTrue(count == 101);
	}

	/* detect and then remove loop in list if any */
	@Test
	public void detectAndRemoveLoopTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = isl.linkContainLoop(null, a);
		head = isl.detectAndRemoveLoop(head);
		int count = 0;
		for (; head != null; head = head.next) {
			if (count++ == 100)
				break;
		}
		Assert.assertTrue(count == 10);
	}

	/** 16. Merge two sorted linked lists **/
	@Test
	public void mergeTwoSotedListTest() {
		SLNode<Integer> result = null;
		Integer a[] = { 1, 3, 5, 7, 9, 0 };
		SLNode<Integer> h1 = isl.insertArrSorted(null, a);
		result = isl.mergeTwoSotedList(h1, null);
		Assert.assertTrue(isl.lengthRecursive(result) == 6);
		result = isl.mergeTwoSotedList(null, h1);
		Assert.assertTrue(isl.lengthRecursive(result) == 6);

		Integer b[] = { 2, 4, 6, 8, 10 };
		SLNode<Integer> h2 = isl.insertArrSorted(null, b);
		result = isl.mergeTwoSotedList(h1, h2);
		SLNode<Integer> p = result;
		for (int i = 0; i <= 10; p = p.next, i++) {
			Assert.assertTrue(p.k == i);
		}
	}

	/** 18. Function to check if a singly linked list is palindrome **/
	@Test
	public void isPalindromeTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 3, 2, 1 };
		Integer b[] = { 1, 2, 3, 4, 3, 2, 1 };
		Integer c[] = { 1, 2, 3, 4, 4, 3, 2, 1 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		Assert.assertTrue(!isl.isPalindrome(lap.getHead()));

		lap = isl.insertArrLast(null, b);
		Assert.assertTrue(isl.isPalindrome(lap.getHead()));

		lap = isl.insertArrLast(null, c);
		Assert.assertTrue(isl.isPalindrome(lap.getHead()));
	}

	/** 19. Intersection point of two Linked Lists. **/
	@Test
	public void intersectionNodeTest() {

		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer b[] = { 0, 1, 2, 3 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);

		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> tail2 = lap2.getTail();
		SLNode<Integer> p = lap1.getHead();
		int i = 0;
		while (i != 6) {
			p = p.next;
			i++;
		}
		tail2.next = p;
		i = 0;
		SLNode<Integer> q = lap2.getHead();
		while (i != 5) {
			q = q.next;
			i++;
		}
		// here testing is connecting or not at 6 of first list
		Assert.assertTrue(q.k == 7);
		//Assert.assertTrue(isl.intersectionNode(lap1.getHead(), lap2.getHead()).k == 6);
	}

	@Test
	public void intersectionNodeXTest() {

		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer b[] = { 0, 1, 2, 3 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);

		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> tail2 = lap2.getTail();
		SLNode<Integer> p = lap1.getHead();
		int i = 0;
		while (i != 6) {
			p = p.next;
			i++;
		}
		tail2.next = p;
		i = 0;
		SLNode<Integer> q = lap2.getHead();
		while (i != 5) {
			q = q.next;
			i++;
		}
		// here testing is is connecting or not at 6 of first list
		Assert.assertTrue(q.k == 7);
		Assert.assertTrue(isl.intersectionNodeX(lap1.getHead(), lap2.getHead()).k == 6);
	}

	/** 20. Recursive function to print reverse of a Linked List **/
	@Test
	public void reversePrintRcvTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		isl.reversePrintRcv(lap.getHead());

	}

	/** 21. Remove duplicates from a sorted linked list **/
	@Test
	public void removeDupicateSortedListTest() {

		Integer a[] = { 1, 1, 1, 3, 4, 5, 6, 6, 9, 9 };
		Integer b[] = { 1, 3, 4, 5, 6, 9 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = isl.removeDupicateSortedList(lap.getHead());
		int i = 0;
		for (; head != null; head = head.next)
			Assert.assertTrue(head.k == b[i++]);
	}

	@Test
	public void removeDupicateSortedListXTest() {

		Integer a[] = { 1, 1, 1, 3, 4, 5, 6, 6, 9, 9 };
		Integer b[] = { 1, 3, 4, 5, 6, 9 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = isl.removeDupicateSortedListX(lap.getHead());
		int i = 0;
		for (; head != null; head = head.next)
			Assert.assertTrue(head.k == b[i++]);
	}

	/** 22. Remove duplicates from an unsorted linked list **/
	@Test
	public void removeDupicateUnSortedListTest() {
		Integer a[] = { 3, 3, 5, 6, 6, 9, 9, 1, 1, 1, 4, 8, 8 };
		Integer b[] = { 3, 5, 6, 9, 1, 4, 8 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = isl.removeDupicateUnSortedList(lap.getHead());
		int i = 0;
		for (; head != null; head = head.next) {
			Assert.assertTrue(head.k == b[i]);
			i++;
		}
	}

	/** 23. Pairwise swap elements of a given linked list **/
	@Test
	public void swapPairwiseTest() {
		Integer a[] = { 1, 2, 3, 4, 5 };
		Integer b[] = { 2, 1, 4, 3, 5 };
		Integer c[] = { 1, 2, 3, 4 };
		Integer d[] = { 2, 1, 4, 3 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = isl.swapPairwise(lap.getHead());
		int i = 0;
		for (; head != null; head = head.next) {
			Assert.assertTrue(head.k == b[i]);
			i++;
		}

		lap = isl.insertArrLast(null, c);
		head = isl.swapPairwise(lap.getHead());
		i = 0;
		for (; head != null; head = head.next) {
			Assert.assertTrue(head.k == d[i]);
			i++;
		}
	}

	@Test
	@Ignore //@TODO
	public void swapPairwiseXTest() {
		Integer a[] = { 1, 2, 3, 4, 5 };
		Integer b[] = { 2, 1, 4, 3, 5 };
		Integer c[] = { 1, 2, 3, 4 };
		Integer d[] = { 2, 1, 4, 3 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = isl.swapPairwiseX(lap.getHead());
		int i = 0;
		for (; head != null; head = head.next) {
			Assert.assertTrue(head.k == b[i]);
			i++;
		}

		lap = isl.insertArrLast(null, c);
		head = isl.swapPairwiseX(lap.getHead());
		i = 0;
		for (; head != null; head = head.next) {
			Assert.assertTrue(head.k == d[i]);
			i++;
		}
	}

	/** 24. Move last element to front of a given Linked List **/
	@Test
	public void moveLastToFirstTest() {
		Integer a[] = { 1, 2, 3, 4, 5 };
		Integer b[] = { 5, 1, 2, 3, 4 };

		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> head = isl.moveLastToFirst(lap.getHead());
		int i = 0;
		for (; head != null; head = head.next) {
			Assert.assertTrue(head.k == b[i]);
			i++;
		}

	}

	/** 25. Intersection of two Sorted Linked Lists **/
	@Test
	public void intersectionOfListsTest() {

		Integer a[] = { 1, 2, 3, 4, 5 };
		Integer b[] = { -1, 0, 1, 2, 3, 4, 6 };

		Lap<SLNode<Integer>, SLNode<Integer>> k1 = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> k2 = isl.insertArrLast(null, b);
		SLNode<Integer> k = isl.intersectionOfLists(k1.getHead(), k2.getHead());
		// isl.printList(k);
		for (int i = 1; i < 5; i++, k = k.next)
			Assert.assertTrue(k.k == i);
	}

	/** 26. Delete alternate nodes of a Linked List **/
	@Test
	public void deleteAlternativeTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Lap<SLNode<Integer>, SLNode<Integer>> k1 = isl.insertArrLast(null, a);
		SLNode<Integer> k = isl.deleteAlternative(k1.getHead());
		for (int i = 1; i < 10; i += 2, k = k.next)
			Assert.assertTrue(i == k.k);
	}

	/** 27. Alternating split of a given Singly Linked List **/
	@Test
	public void alternativeSplitTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		lap = isl.alternativeSplit(lap.getHead());

		SLNode<Integer> k1 = lap.getHead();
		SLNode<Integer> k2 = lap.getTail();
		for (int i = 1; i < 10; i += 2, k1 = k1.next)
			Assert.assertTrue(i == k1.k);

		for (int i = 2; i <= 10; i += 2, k2 = k2.next)
			Assert.assertTrue(i == k2.k);
	}

	@Test
	public void alternativeSplitXTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		lap = isl.alternativeSplitX(lap.getHead());

		SLNode<Integer> k1 = lap.getHead();
		SLNode<Integer> k2 = lap.getTail();
		for (int i = 1; i < 10; i += 2, k1 = k1.next)
			Assert.assertTrue(i == k1.k);

		for (int i = 2; i <= 10; i += 2, k2 = k2.next)
			Assert.assertTrue(i == k2.k);
	}

	/** 28. Identical Linked Lists **/
	@Test
	public void isListsIdenticalTest() {

		Integer a1[] = { 1, 2, 3, 4, 5 };
		Lap<SLNode<Integer>, SLNode<Integer>> k1 = isl.insertArrLast(null, a1);
		Integer a2[] = { 1, 2, 3, 4, 5 };
		Lap<SLNode<Integer>, SLNode<Integer>> k2 = isl.insertArrLast(null, a2);
		Integer a3[] = { 1, 2, 3, 4, 9 };
		Lap<SLNode<Integer>, SLNode<Integer>> k3 = isl.insertArrLast(null, a3);
		Integer a4[] = { 1, 2, 3, 4, 5 };
		Lap<SLNode<Integer>, SLNode<Integer>> k4 = isl.insertArrLast(null, a4);

		Assert.assertTrue(isl.isListsIdentical(k1.getHead(), k2.getHead()));
		Assert.assertTrue(!isl.isListsIdentical(k3.getHead(), k4.getHead()));
	}

	/**
	 * 29. Merge Sort for Linked Lists...getMiddle and sortedMerge internally called
	 * so tested here only.
	 **/
	@Test
	public void mergeSortTest() {
		Integer a1[] = { 1, 3, 2, 5, 4, 7, 6, 9, 8, 10, 0 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a1);
		SLNode<Integer> k = isl.mergeSort(lap.getHead());
		// isl.printList(k);
		for (int i = 0; i < 11; i++, k = k.next)
			Assert.assertTrue(k.k == i);

	}

	/** 30. Reverse a Linked List in groups of given size..reverse every k nodes **/
	@Test
	public void reverseGroupOfNTest() {
		Integer a[] = { 3, 2, 1, 6, 5, 4, 9, 8, 7, 10 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> k = isl.reverseGroupOfN(lap.getHead(), 3);

		for (int i = 1; i < 11; i++, k = k.next)
			Assert.assertTrue(k.k == i);
	}

	/** 31. Reverse alternate K nodes in a Singly Linked List **/
	@Test
	public void reverseAlternateNTest() {
		Integer a[] = { 3, 2, 1, 4, 5, 6, 9, 8, 7, 10, 11, 12, 15, 14, 13, 16, 17 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> k = isl.reverseAlternateN(lap.getHead(), 3);

		for (int i = 1; i < 18; i++, k = k.next)
			Assert.assertTrue(k.k == i);
	}

	/** 32. Delete nodes which have a greater value on right side **/
	@Test
	public void deleteRightGreaterValTest() {
		Integer a[] = { 1, 2, 3, 2, 11, 4, 5, 6, 9, 8, 7, 10, 11, 12, 15, 14, 13, 16, 17 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);
		SLNode<Integer> k = isl.deleteRightGreaterVal(lap.getHead());
		Assert.assertTrue(k.k == 17);
		Assert.assertTrue(k.next == null);

		Integer b[] = { 12, 15, 10, 11, 5, 6, 2, 3 };// {7,6,5,4,6,3,9,0}; //
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, b);
		SLNode<Integer> k1 = isl.deleteRightGreaterVal(lap1.getHead());
		Assert.assertTrue(k1.k == 15);
		Assert.assertTrue(k1.next.k == 11);
	}

	/** 33. Segregate even and odd nodes in a Linked List **/
	@Test
	public void seperateOddEvenListTest() {
		Integer a[] = { 1, 3, 5, 2, 4, 6, 7, 8, 9, 10, 11 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap = isl.insertArrLast(null, a);

		lap = isl.seperateOddEvenList(lap.getHead());
		SLNode<Integer> evn = lap.getHead();
		SLNode<Integer> odd = lap.getTail();

		Assert.assertTrue(evn.k == 2);
		Assert.assertTrue(evn.next.k == 4);

		Assert.assertTrue(odd.k == 1);
		Assert.assertTrue(odd.next.k == 3);

	}

	/** 34. Detect and Remove Loop in a Linked List **/
	@Test
	public void isLoopInListTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> q = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> tail = lap1.getTail();
		SLNode<Integer> head = lap1.getHead();
		q = head;
		for (int i = 0; i < 3; i++)
			q = q.next;
		tail.next = q;
		Assert.assertTrue(isl.isLoopInList(head).k == 9);
	}

	@Test
	public void dectedAndRemoveLoopInListTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> q = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> tail = lap1.getTail();
		SLNode<Integer> head = lap1.getHead();
		q = head;
		for (int i = 0; i < 3; i++)
			q = q.next;
		tail.next = q;
		head = isl.detectAndRemoveLoop(head);
		Assert.assertTrue(tail.next == null);
	}

	/** 35. Add two numbers represented by linked lists | Set 1 **/
	@Test
	public void addTwoNoRepesentByListTest() {

		Integer a[] = { 8, 9, 3, 5 };
		Integer b[] = { 3, 7 };
		Integer c[] = { 8, 9, 7, 2 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> head = isl.addTwoNoRepesentByList(lap1.getHead(), lap2.getHead());
		int i = 0;
		for (; head != null; head = head.next)
			Assert.assertTrue(head.k == c[i++]);
	}

	/** 36. Delete a given node in Linked List under given constraints **/
	@Test
	public void deleteNodeTest() {

		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> x = new SLNode<Integer>(8);
		SLNode<Integer> y = new SLNode<Integer>(5);
		SLNode<Integer> z = new SLNode<Integer>(2);
		SLNode<Integer> head = lap1.getHead();
		head = isl.deleteNode(head, x);
		head = isl.deleteNode(head, y);
		head = isl.deleteNode(head, z);
		isl.printList(head);
	}

	/** 37. Union and Intersection of two Linked Lists **/
	@Test
	public void unionOfListsTest() {
		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Integer b[] = { 8, 9, 7, 2, 4 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> h1 = lap1.getHead();
		SLNode<Integer> h2 = lap2.getHead();
		h1 = isl.unionOfLists(h1, h2);
		isl.printList(h1);
	}

	@Test
	public void intersectionOfListsXTest() {
		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Integer b[] = { 8, 9, 7, 2, 4 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> h1 = lap1.getHead();
		SLNode<Integer> h2 = lap2.getHead();
		h1 = isl.intersectionOfLists(h1, h2);
		isl.printList(h1);
	}

	/** 38. Find a triplet from linked lists with sum equal to a given number **/
	@Test
	public void sortListTest() {

		Integer a[] = { 15, 8, 9, 1, 2, 6, 7, 3, 5, 4 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> head = lap1.getHead();
		head = isl.sortList(head);
		isl.printList(head);
	}

	@Test
	public void tripletInListTest() {

		Integer a[] = { 20, 4, 15, 10 };
		Integer b[] = { 10, 9, 4, 2 };
		Integer c[] = { 1, 2, 8, 4 };
		Lap<SLNode<Integer>, SLNode<Integer>> ha = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> hb = isl.insertArrLast(null, b);
		Lap<SLNode<Integer>, SLNode<Integer>> hc = isl.insertArrLast(null, c);
		List<List<Integer>> ll = isl.tripletInList(ha.getHead(), hb.getHead(), hc.getHead(), 25);
		Assert.assertTrue(ll.size() == 2);
	}

	/** 39. Rotate a Linked List **/
	@Test
	public void rotateListTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<SLNode<Integer>, SLNode<Integer>> ha = isl.insertArrLast(null, a);
		SLNode<Integer> head = ha.getHead();
		head = isl.rotateList(head, 4, true);
		head = isl.rotateList(head, 4, false);
		int i = 0;
		for (; head != null; head = head.next)
			Assert.assertTrue(head.k == a[i++]);

	}

	/** 40. Flattening a Linked List **/
	@Test
	public void insertDownFlatListTest() {

		Integer a[] = { 5, 7, 8, 30 };
		FlatLNode<Integer> head = null;
		for (int i = 0; i < a.length; i++)
			head = isl.insertDownFlatList(head, a[i]);
		isl.displayFlatternList(head);
	}

	@Test
	public void makeFlatListTest() {

		Integer a[] = { 5, 7, 8, 30 };
		Integer b[] = { 10, 20 };
		FlatLNode<Integer> head = null;
		FlatLNode<Integer> head1 = null;
		for (int i = 0; i < a.length; i++)
			head = isl.insertDownFlatList(head, a[i]);

		for (int i = 0; i < b.length; i++)
			head1 = isl.insertDownFlatList(head1, b[i]);
		List<FlatLNode<Integer>> list = new ArrayList<>();

		list.add(head);
		list.add(head1);
		head = isl.makeFlatList(list);
		isl.displayFlatternList(head);
	}

	@Test
	public void mergeTest() {

		Integer a[] = { 5, 7, 8, 30 };
		Integer b[] = { 10, 20 };
		FlatLNode<Integer> head = null;
		FlatLNode<Integer> head1 = null;
		for (int i = 0; i < a.length; i++)
			head = isl.insertDownFlatList(head, a[i]);

		for (int i = 0; i < b.length; i++)
			head1 = isl.insertDownFlatList(head1, b[i]);

		head = isl.merge(head, head1);
		isl.displayFlatternList(head);
	}

	@Test
	public void flatternTest() {

		Integer a[] = { 5, 7, 8, 30 };
		Integer b[] = { 10, 20 };
		Integer c[] = { 19, 22, 23 };
		Integer d[] = { 28, 35, 40, 45 };
		FlatLNode<Integer> h1 = null;
		FlatLNode<Integer> h2 = null;
		FlatLNode<Integer> h3 = null;
		FlatLNode<Integer> h4 = null;

		for (int i = 0; i < a.length; i++)
			h1 = isl.insertDownFlatList(h1, a[i]);

		for (int i = 0; i < b.length; i++)
			h2 = isl.insertDownFlatList(h2, b[i]);

		for (int i = 0; i < c.length; i++)
			h3 = isl.insertDownFlatList(h3, c[i]);

		for (int i = 0; i < d.length; i++)
			h4 = isl.insertDownFlatList(h4, d[i]);
		List<FlatLNode<Integer>> list = new ArrayList<>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		FlatLNode<Integer> head = isl.makeFlatList(list);
		System.out.println("Before flattern");
		isl.displayFlatternList(head);
		head = isl.flattern(head);
		System.out.println("\nAfter flttern");
		isl.printListDown(head);
	}

	/** 41. Add two numbers represented by linked lists | Set 2 **/
	// @see @35. in this list only

	/** 42. Sort a linked list of 0s, 1s and 2s **/
	@Test
	public void sort0s1s2sListTest() {

		Integer a[] = { 2, 1, 0, 0, 1, 2, 2, 1, 1, 0, 0, 0, 1, 2 };
		Lap<SLNode<Integer>, SLNode<Integer>> ha = isl.insertArrLast(null, a);
		SLNode<Integer> head = ha.getHead();
		head = isl.sort0s1s2sList(head);
		isl.printList(head);
	}

	/** 43. Flatten a multilevel linked list **/
	@Test
	public void multiFlatternTest() {

		Integer arr1[] = { 10, 5, 12, 7, 11 };
		Integer arr2[] = { 4, 20, 13 };
		Integer arr3[] = { 17, 6 };
		Integer arr4[] = { 9, 8 };
		Integer arr5[] = { 19, 15 };
		Integer arr6[] = { 2 };
		Integer arr7[] = { 16 };
		Integer arr8[] = { 3 };

		/* create 8 linked lists */
		FlatLNode<Integer> head1 = null;
		FlatLNode<Integer> head2 = null;
		FlatLNode<Integer> head3 = null;
		FlatLNode<Integer> head4 = null;
		FlatLNode<Integer> head5 = null;
		FlatLNode<Integer> head6 = null;
		FlatLNode<Integer> head7 = null;
		FlatLNode<Integer> head8 = null;
		int i;
		for (i = 0; i < arr1.length; i++)
			head1 = isl.insertNextFlatList(head1, arr1[i]);
		for (i = 0; i < arr2.length; i++)
			head2 = isl.insertNextFlatList(head2, arr2[i]);

		for (i = 0; i < arr3.length; i++)
			head3 = isl.insertNextFlatList(head3, arr3[i]);
		for (i = 0; i < arr4.length; i++)
			head4 = isl.insertNextFlatList(head4, arr4[i]);
		for (i = 0; i < arr5.length; i++)
			head5 = isl.insertNextFlatList(head5, arr5[i]);

		for (i = 0; i < arr6.length; i++)
			head6 = isl.insertNextFlatList(head6, arr6[i]);
		for (i = 0; i < arr7.length; i++)
			head7 = isl.insertNextFlatList(head7, arr7[i]);
		for (i = 0; i < arr8.length; i++)
			head8 = isl.insertNextFlatList(head8, arr8[i]);

		head3.down = head4;
		head4.down = head5;

		head7.down = head8;
		head2.next.down = head6;
		head2.next.next.down = head7;
		head1.down = head2;
		head1.next.next.next.down = head3;

		FlatLNode<Integer> head = isl.multiFlattern(head1);
		isl.printListNext(head);
		// 10->5->12->7->11->4->20->13->17->6->2->16->9->8->3->19->15->
	}

	/** 44. Delete N nodes after M nodes of a linked list **/
	@Test
	public void deleteNnodesAfterMNodesTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.deleteNnodesAfterMNodes(head, 2, 2);
		isl.printList(head);
	}

	/** 45. QuickSort on Singly Linked List **/
	@Test
	public void quickSortOnListTest() {
		Integer a[] = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		SLNode<Integer> tail = isl.getTail(head);
		head = isl.quickSortOnList(head, tail);
		isl.printList(head);
	}

	/** 46. Merge a linked list into another linked list at alternate positions **/
	@Test
	public void mergeAtAlternativePosTest() {

		Integer a[] = { 1, 3, 5, 7, 9 };
		Integer b[] = { 2, 4, 6, 8, 10 };
		SLNode<Integer> h1 = isl.insertArrLast(null, a).getHead();
		SLNode<Integer> h2 = isl.insertArrLast(null, b).getHead();
		isl.printList(isl.mergeAtAlternativePos(h1, h2));
	}

	/** 48. Given a linked list of line segments, remove middle points **/

	@Test
	public void removeMiddlePointOfLineSegmentTest() {
		int a[][] = { { 0, 10 }, { 1, 10 }, { 3, 10 }, { 10, 10 }, { 10, 8 }, { 10, 5 }, { 20, 5 }, { 40, 5 } };
		PointNode head = null;
		for (int i = 0; i < a.length; i++)
			head = isl.insertLineLink(head, new Point(a[i][0], a[i][1]));
		System.out.println("before middle deletion");
		isl.displayPointList(head);
		System.out.println("\nAfter middle deletion");
		head = isl.removeMiddlePointOfLineSegment(head);
		isl.displayPointList(head);
	}

	/** 49. Clone a linked list with next and random pointer | Set 1 **/
	@Test
	public void cloneListTest() {
		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> h1 = lap1.getHead();
		h1 = isl.cloneList(h1);
		isl.printList(h1);
	}

	// @See IDLinkList
	/** 50. Clone a linked list with next and random pointer | Set 2 **/

	/** 51. Insertion Sort for Singly Linked List **/
	@Test
	public void insertionSortTest() {
		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> h1 = lap1.getHead();
		h1=isl.insertionSort(h1);
		isl.printList(h1);
	}

	/***********************************************************************************************************************************************************************/
	/**
	 * 87. Union and Intersection of two linked lists | Set-2 (Using Merge Sort)
	 **/
	@Test
	public void unionOfListsByMergeSortTest() {
		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Integer b[] = { 8, 9, 7, 2, 4 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> h1 = lap1.getHead();
		SLNode<Integer> h2 = lap2.getHead();
		h1 = isl.unionOfListsByMergeSort(h1, h2);
		isl.printList(h1);
	}

	@Test
	public void intersectionOfListsByMergeSortTest() {
		Integer a[] = { 8, 9, 1, 2, 6, 7, 3, 5 };
		Integer b[] = { 8, 9, 7, 2, 4 };
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		Lap<SLNode<Integer>, SLNode<Integer>> lap2 = isl.insertArrLast(null, b);
		SLNode<Integer> h1 = lap1.getHead();
		SLNode<Integer> h2 = lap2.getHead();
		h1 = isl.intersectionOfListsByMergeSort(h1, h2);
		isl.printList(h1);
	}

	/** 88. Multiply two numbers represented by Linked Lists **/
	@Test
	public void multiplyTwoListsTest() {
		Integer a[] = { 9, 4, 6 };
		SLNode<Integer> p = isl.insertArrLast(null, a).getHead();
		Integer b[] = { 8, 4 };
		SLNode<Integer> q = isl.insertArrLast(null, b).getHead();
		Assert.assertTrue(isl.multiplyTwoLists(p, q) == 79464);
	}

	/** 89. Union and Intersection of two linked lists | Set-3 (Hashing) **/
	// @See @37. point
	/** 90. Find the sum of last n nodes of the given Linked List **/
	@Test
	public void sumOfLastNNodesTest() {
		Integer a[] = { 10, 6, 8, 4, 12 };
		SLNode<Integer> p = isl.insertArrLast(null, a).getHead();
		Assert.assertTrue(isl.sumOfLastNNodes(p, 2) == 16);
	}

	/**
	 * 91. Count pairs from two linked lists whose sum is equal to a given value
	 **/
	@Test
	public void countPairOfSumTest() {
		Integer a[] = { 2, 5, 7 };
		SLNode<Integer> p = isl.insertArrLast(null, a).getHead();
		Integer b[] = { 1, 3, 4 };
		SLNode<Integer> q = isl.insertArrLast(null, b).getHead();
		Assert.assertTrue(isl.countPairOfSum(p, q, 8) == 2);
	}

	/** 92. Merge k sorted linked lists | Set 2 (Using Min Heap) **/
	@Test
	public void mergeKsortedListTest() {
		Integer a[] = { 2, 5, 7 };
		SLNode<Integer> p = isl.insertArrLast(null, a).getHead();
		Integer b[] = { 1, 3, 4 };
		SLNode<Integer> q = isl.insertArrLast(null, b).getHead();
		Integer c[] = { 6, 8, 9 };
		SLNode<Integer> r = isl.insertArrLast(null, c).getHead();
		List<SLNode<Integer>> list = new ArrayList<>();
		list.add(p);
		list.add(q);
		list.add(r);
		SLNode<Integer> h = isl.mergeKsortedList(list);
		isl.printList(h);
	}

	/**
	 * 93. Recursive selection sort for singly linked list | Swapping node links
	 **/
	@Test
	public void selectionSortRcvTest() {

		Integer a[] = { 1, 2, 8, 9, 3, 4, 5, 6, 7 };
		SLNode<Integer> q = isl.insertArrLast(null, a).getHead();
		SLNode<Integer> p = q.next;
		SLNode<Integer> pnext = p.next;
		q.next = null;

		q = isl.selectionSortRcv(q, p, pnext);
		isl.printList(q);
	}

	/** 94. Find length of loop in linked list **/
	@Test
	public void lengthOfloopTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> q = null;
		Lap<SLNode<Integer>, SLNode<Integer>> lap1 = isl.insertArrLast(null, a);
		SLNode<Integer> tail = lap1.getTail();
		SLNode<Integer> head = lap1.getHead();
		q = head;
		for (int i = 0; i < 3; i++)
			q = q.next;
		tail.next = q;
		int len = isl.lengthOfloop(head);
		Assert.assertTrue(len == 6);
	}

	/** 95. Reverse a Linked List in groups of given size | Set 2 **/
	@Test
	public void reverseInGroupTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		Integer b[] = { 3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.reverseInGroup(head, 3);
		// isl.printList(head);
		int i = 0;
		for (; head != null; head = head.next)
			Assert.assertTrue(head.k == b[i++]);
	}

	/** 96. Insert node into the middle of the linked list **/
	@Test
	public void insertAtMiddleTest() {
		Integer a[] = { 1, 3, 5, 7, 9 };
		Integer b[] = { 2, 4, 6, 8 };

		SLNode<Integer> h1 = isl.insertArrLast(null, a).getHead();
		SLNode<Integer> h2 = isl.insertArrLast(null, b).getHead();
		h1 = isl.insertAtMiddle(h1, 0);
		h2 = isl.insertAtMiddle(h2, 0);
		isl.printList(h1);
		System.out.println();
		isl.printList(h2);
	}

	/** 97. Merge two sorted lists (in-place) **/
	@Test
	public void merge2SortedListTest() {
		Integer a[] = { 1, 3, 5, 7, 9 };
		Integer b[] = { 2, 4, 6, 8 };

		SLNode<Integer> h1 = isl.insertArrLast(null, a).getHead();
		SLNode<Integer> h2 = isl.insertArrLast(null, b).getHead();
		h1 = isl.merge2SortedList(h1, h2);
		isl.printList(h1);
	}

	/** 98. Sort a linked list of 0s, 1s and 2s by changing links **/
	@Test
	public void sort0s1s2sListByChangingLinkTest() {
		Integer a[] = { 1, 0, 2, 1, 1, 0, 0, 2, 2, 0, 0, 1, 0, 2 };
		Integer b[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.sort0s1s2sListByChangingLink(head);
		// isl.printList(head);
		for (int i = 0; head != null; head = head.next)
			Assert.assertTrue(head.k == b[i++]);
	}

	/** 99. Insert a node after the n-th node from the end **/
	@Test
	public void insertAfterNthNodeFromEndTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.insertAfterNthNodeFromEnd(head, 9, 3);
		for (int i = 1; i <= a.length - 3 + 1; i++) {
			head = head.next;
		}
		// isl.printList(head);
		Assert.assertTrue(head.k == 9);
	}

	/** 100. Rotate Linked List block wise **/
	@Test
	public void blockWiseRotationTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		Integer b[] = { 2, 3, 1, 5, 6, 4, 8, 9, 7, 10, 11 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.blockWiseRotation(head, 3, 2);
		// isl.printList(head);
		int i = 0;
		for (; head != null; head = head.next)
			Assert.assertTrue(head.k == b[i++]);
	}

	/** 101. Count rotations in sorted and rotated linked list **/
	@Test
	public void countRotationClkWiseTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.rotateList(head, 2, true);
		Assert.assertTrue(isl.countRotationClkWise(head) == 2);
	}

	/** 102. Make middle node head in a linked list **/
	@Test
	public void makeMiddleNodeHeadTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode<Integer> head = isl.insertArrLast(null, a).getHead();
		head = isl.makeMiddleNodeHead(head);
		// isl.printList(head);
		Assert.assertTrue(head.k == 5);
	}
}
