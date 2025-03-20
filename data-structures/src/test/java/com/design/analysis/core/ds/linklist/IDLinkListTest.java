package com.design.analysis.core.ds.linklist;

import java.util.List;

import com.design.analysis.core.ds.hashing.utils.BTreeUitls;
import com.design.analysis.core.ds.linklist.node.DLNode;
import com.design.analysis.core.ds.linklist.node.SLNode;
import com.design.analysis.core.ds.linklist.node.TTreeNode;
import com.design.analysis.core.ds.linklist.utils.Lap;
import com.design.analysis.core.ds.tree.node.BTNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDLinkListTest {

	public IDLinkList<Integer> idll = null;
	public BTreeUitls<Integer> util = new BTreeUitls<>();

	@Before
	public void init() {
		idll = new DLinkListImpl();
	}

	@Test
	public void insertArrLastTest() {

		Integer a[] = { 1, 3, 2, 4, 6, 5, 8, 9, 7, 8 };
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		DLNode<Integer> head = lap.getHead();
		DLNode<Integer> tail = lap.getTail();
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 3);

		Assert.assertTrue(tail.k == 8);
		Assert.assertTrue(tail.prev.k == 7);
		// idll.print(head);
	}

	@Test
	public void insertElementFirst() {

		Integer a[] = { 1, 3, 2, 4, 6, 5, 8, 7, 8 };
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		lap = idll.insertElementLast(lap, 9);
		DLNode<Integer> head = lap.getHead();
		DLNode<Integer> tail = lap.getTail();

		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 3);

		Assert.assertTrue(tail.k == 9);
		Assert.assertTrue(tail.prev.k == 8);
		// idll.print(head);
	}

	@Test
	public void insertElementLast() {

		Integer a[] = { 3, 2, 4, 6, 5, 8, 7, 8, 9 };
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		lap = idll.insertElementFirst(lap, 1);
		DLNode<Integer> head = lap.getHead();
		DLNode<Integer> tail = lap.getTail();

		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 3);

		Assert.assertTrue(tail.k == 9);
		Assert.assertTrue(tail.prev.k == 8);
	}

	@Test
	public void insertAtPosition() {

		Integer a[] = { 1, 3, 2, 4, 6, 5, 8, 9, 7 };
		DLNode<Integer> head = idll.insertArrSorted(null, a);
		idll.print(head);
	}

	@Test
	public void deleteFirstKTest() {
		Integer k[] = {};
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, k);

		Assert.assertTrue(lap == null);
		Integer a[] = { 1 };
		lap = idll.insertArrLast(null, a);
		DLNode<Integer> head = lap.getHead();
		head = idll.deleteNodeFirstK(head, 1);
		Assert.assertTrue(head == null);

		Integer b[] = { 10, 11 };
		lap = idll.insertArrLast(null, b);
		head = lap.getHead();
		head = idll.deleteNodeFirstK(head, 11);
		Assert.assertTrue(head.k == 10);
		Assert.assertTrue(head.next == null);
		// idll.printList(head);
	}

	/* . Linked List Deletion (Deleting a given key) */
	@Test
	public void deleteAllXTest() {
		DLNode<Integer> head = null;
		Integer a[] = { 1, 1, 0, 1, 0, 2, 3, 1 };
		Integer b[] = { 1, 2, 2, 3, 2, 4, 2, 5, 2 };

		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		head = lap.getHead();
		// idll.printList(head);
		head = idll.deleteAllOccurance(head, 1);
		// idll.printList(head);
		Assert.assertTrue(head.k == 0);
		Assert.assertTrue(head.next.k == 0);
		Assert.assertTrue(head.next.next.k == 2);
		head = null;
		lap = idll.insertArrLast(null, b);
		// idll.printList(head);
		head = idll.deleteAllOccurance(lap.getHead(), 2);
		// idll.printList(head);
		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 3);
		Assert.assertTrue(head.next.next.k == 4);
	}

	/* delete the last occurrence of node */
	@Test
	public void deleteLastKTest() {

		DLNode<Integer> head = null;
		Integer a[] = { 2, 4, 0, 1, 0, 2, 3, 1 };

		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		head = lap.getHead();
		head = idll.deleteNodeLastK(head, 2);
		Assert.assertTrue(head.next.next.next.next.next.k == 3);
		head = idll.deleteNodeLastK(head, 2);
		head = idll.deleteNodeLastK(head, 1);
		head = idll.deleteNodeLastK(head, 10);
		Assert.assertTrue(head.k == 4);
	}

	@Test
	public void deletePosTest() {
		Integer b[] = { 1 };
		DLNode<Integer> head = null;
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, b);

		head = lap.getHead();
		head = idll.deletePos(head, 1);
		Assert.assertTrue(head == null);

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		head = null;
		lap = idll.insertArrLast(null, a);
		head = lap.getHead();
		head = idll.deletePos(head, 1);
		head = idll.deletePos(head, 2);
		head = idll.deletePos(head, 7);
		head = idll.deletePos(head, 7);
		Assert.assertTrue(head.k == 2);
		Assert.assertTrue(head.next.k == 4);
		Assert.assertTrue(head.next.next.k == 5);
	}

	/** 3. Reverse a Doubly Linked List **/
	@Test
	public void reverseIterativeTest() {
		DLNode<Integer> head = null;
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		DLNode<Integer> hd = lap.getHead();
		head = idll.reverseIterative(idll.reverseIterative(lap.getHead()));
		for (; head != null && hd != null; head = head.next, hd = hd.next)
			Assert.assertTrue(head.k == hd.k);
		// idll.print(head);
	}

	@Test
	public void reverseRecursiveTest() {
		DLNode<Integer> head = null;
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		DLNode<Integer> hd = lap.getHead();
		head = idll.reverseRecursive(idll.reverseRecursive(lap.getHead()));
		for (; head != null && hd != null; head = head.next, hd = hd.next)
			Assert.assertTrue(head.k == hd.k);
		// idll.print(head);
	}

	/** 4. The Great Tree-List Recursion Problem. **/
	@Test
	public void bstToListTest() {
		Integer arr[] = { 5, 7, 3, 2, 6, 4, 8, 9, 1 };
		BTNode<Integer> root = null;
		for (int i = 0; i < arr.length; i++)
			root = util.createBst(root, arr[i]);
		root = idll.bstToList(root);
		while (root.lt != null)
			root = root.lt;
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 0;
		for (; root != null; root = root.rt) {
			Assert.assertTrue(root.t == a[i++]);
		}
	}

	/** 5. Copy a linked list with next and arbit pointer **/
	/** 6. QuickSort on Doubly Linked List **/

	@Test
	public void quickSortTest() {
		Integer a[] = { 1, 0, 9, 2, 8, 3, 7, 4, 6, 5 };
		Lap<DLNode<Integer>, DLNode<Integer>> lap = idll.insertArrLast(null, a);
		DLNode<Integer> h = lap.getHead();
		DLNode<Integer> t = h;
		idll.print(h);
		while (t.next != null)
			t = t.next;
		idll.quickSort(h, t);
		// idll.print(h);
	}

	/** 7. Swap Kth node from beginning with Kth node from end in a Linked List **/
	@Test
	public void swapKthNodeFromBegAndEndTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		DLNode<Integer> h = idll.insertArrLast(null, a).getHead();
		h = idll.swapKthNodeFromBegAndEnd(h, 2);
		idll.print(h);
	}

	/** 8. Merge Sort for Doubly Linked List **/
	@Test
	public void mergeSortTest() {
		Integer a[] = { 1, 0, 9, 2, 8, 3, 7, 4, 6, 5 };
		DLNode<Integer> h = idll.insertArrLast(null, a).getHead();
		h = idll.mergeSort(h);
		idll.print(h);
	}

	/** 9. Create a Doubly Linked List from a Ternary Tree **/
	@Test
	public void createTernaryTreeTest() {
		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		TTreeNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = idll.createTernaryTree(root, a[i]);
		idll.printTTree(root);
	}

	@Test
	public void createFromTernaryTreeTest() {

		Integer a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		TTreeNode<Integer> root = null;
		for (int i = 0; i < a.length; i++)
			root = idll.createTernaryTree(root, a[i]);
		TTreeNode<Integer> head = idll.createFromTernaryTree(root);
		idll.printTTOfDl(head);
	}

	/** 10. Find pairs with given sum in doubly linked list **/
	@Test
	public void pairOfGivenSumTest() {
		Integer a[] = { 1, 0, 9, 2, 8, 3, 7, 4, 6, 5 };
		DLNode<Integer> head = idll.insertArrLast(null, a).getHead();
		List<List<DLNode<Integer>>> ll = idll.pairOfGivenSum(head, 10);
		Assert.assertTrue(ll.size() == 4);
	}

	@Test
	public void insertArrSorted() {

		Integer a[] = { 1, 3, 2, 4, 6, 5, 8, 9, 7, 8 };
		DLNode<Integer> head = idll.insertArrSorted(null, a);

		Assert.assertTrue(head.k == 1);
		Assert.assertTrue(head.next.k == 2);
		while (head.next.next != null)
			head = head.next;
		Assert.assertTrue(head.k == 8);
		Assert.assertTrue(head.next.k == 9);
	}

	/**
	 * 13. Count triplets in a sorted doubly linked list whose sum is equal to a
	 * given value x
	 **/
	@Test
	public void tripletROfGivenSumTest() {
		Integer a[] = { 1, 2, 4, 5, 6, 8, 9 };
		DLNode<Integer> head = idll.insertArrSorted(null, a);
		int count = idll.tripletROfGivenSum(head, 17);
		Assert.assertTrue(count == 2);
	}

	/** 14. Remove duplicates from a sorted doubly linked list **/
	@Test
	public void removeDuplicateTest() {
		Integer a[] = { 4, 4, 4, 4, 6, 8, 8, 10, 12, 12 };
		DLNode<Integer> head = idll.insertArrSorted(null, a);
		head = idll.removeDuplicate(head);
		idll.print(head);
	}

	/** 15. Delete all occurrences of a given key in a doubly linked list **/
	@Test
	public void deleteAllOccuranceOfXTest() {
		Integer a[] = { 4, 4, 4, 5, 6, 4, 8, 10, 12, 4 };
		DLNode<Integer> head = idll.insertArrSorted(null, a);
		head = idll.deleteAllOccuranceOfX(head, 4);
		idll.print(head);
	}

	/** 16. Remove duplicates from an unsorted doubly linked list **/
	@Test
	public void remveDuplicateFromNonSotedListTest() {

		Integer a[] = { 4, 4, 10, 12, 12, 4, 4, 6, 8, 8 };
		DLNode<Integer> head = idll.insertArrLast(null, a).getHead();
		head = idll.remveDuplicateFromNonSotedList(head);
		idll.print(head);
	}

	/** 17. Sort the biotonic doubly linked list **/
	@Test
	public void sortBitonicListTest() {
		Integer a[] = { 2, 5, 7, 12, 10, 6, 4, 1 };
		DLNode<Integer> head = idll.insertArrLast(null, a).getHead();
		head = idll.sortBitonicList(head);
		idll.print(head);
	}

	/** 18. Sort a k sorted doubly linked list **/
	@Test
	public void sortAKSortedDLLTest() {
		Integer a[] = { 3, 6, 2, 12, 56, 8 };
		DLNode<Integer> head = idll.insertArrLast(null, a).getHead();
		head = idll.sortAKSortedDLL(head, 2);
		idll.print(head);
	}

	/**
	 * Below question get collcted from ISLinkLIst
	 ******************************************************/
	/** 50. Clone a linked list with next and random pointer | Set 2 **/
	@Test
	public void arbitrarylistTest() {

	}

	/*************************************************Analysis*************************************************************************/
	@Test
	public void swapPairWiseFromHeadRcvTest(){
		Integer []a = {1, 2, 3, 4, 5};
		Integer []b = {1, 2, 3, 4};

		DLNode<Integer> head = idll.swapPairWiseFromHeadRcv(idll.insertArrLast(null, a).getHead());
		idll.print(head);
		Assert.assertEquals(2,(int)head.k);
		Assert.assertEquals(5,(int)head.next.next.next.next.k);

		DLNode<Integer> head1 = idll.swapPairWiseFromHeadRcv(idll.insertArrLast(null, b).getHead());
		idll.print(head1);
		Assert.assertEquals(2,(int)head1.k);
		Assert.assertEquals(3,(int)head1.next.next.next.k);
	}

	@Test
	public void swapPairWiseFromTailRcvTest() {
		Integer []a = {1, 2, 3, 4, 5};
		Integer []b = {1, 2, 3, 4};

		DLNode<Integer> head = idll.swapPairWiseFromTailRcv(idll.insertArrLast(null, a).getHead());
		idll.print(head);
		Assert.assertEquals(1,(int)head.k);
		Assert.assertEquals(4,(int)head.next.next.next.next.k);

		DLNode<Integer> head1 = idll.swapPairWiseFromTailRcv(idll.insertArrLast(null, b).getHead());
		idll.print(head1);
		Assert.assertEquals(2,(int)head1.k);
		Assert.assertEquals(3,(int)head1.next.next.next.k);
	}
}
