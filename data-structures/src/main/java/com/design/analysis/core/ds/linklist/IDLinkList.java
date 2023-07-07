package com.design.analysis.core.ds.linklist;

import java.util.List;

import com.design.analysis.core.ds.linklist.node.DLNode;
import com.design.analysis.core.ds.linklist.node.TTreeNode;
import com.design.analysis.core.ds.linklist.utils.Lap;
import com.design.analysis.core.ds.tree.node.BTNode;

/*
 * 
 * @author GuruG
 * Doubly Linked List:

1.	Doubly Linked List Introduction and Insertion
2.	Delete a node in a Doubly Linked List
3.	Reverse a Doubly Linked List
4.	The Great Tree-List Recursion Problem.
5.	Copy a linked list with next and arbit pointer
6.	QuickSort on Doubly Linked List
7.	Swap Kth node from beginning with Kth node from end in a Linked List
8.	Merge Sort for Doubly Linked List
9.	Create a Doubly Linked List from a Ternary Tree
10.	Find pairs with given sum in doubly linked list
11.	Insert value in sorted way in a sorted doubly linked list
12.	Delete a Doubly Linked List node at a given position
13.	Count triplets in a sorted doubly linked list whose sum is equal to a given value x
14.	Remove duplicates from a sorted doubly linked list
15.	Delete all occurrences of a given key in a doubly linked list
16.	Remove duplicates from an unsorted doubly linked list
17.	Sort the biotonic doubly linked list
18.	Sort a k sorted doubly linked list
19.	Convert a given Binary Tree to Doubly Linked List | Set

 */
public interface IDLinkList<K> {

	/** 1. Doubly Linked List Introduction and Insertion **/
	/* insert collection of element */
	public Lap<DLNode<K>, DLNode<K>> insertArrLast(Lap<DLNode<K>, DLNode<K>> lap, K k[]);

	/* insert element at first */
	public Lap<DLNode<K>, DLNode<K>> insertElementFirst(Lap<DLNode<K>, DLNode<K>> lap, K k);

	/* insert single element at end of list */
	public Lap<DLNode<K>, DLNode<K>> insertElementLast(Lap<DLNode<K>, DLNode<K>> lap, K k);

	/* insert at given position head is at 1st position */
	public DLNode<K> insertAtPosition(DLNode<K> head, int pos, K k);

	/* print list */
	public void print(DLNode<K> k);

	/** 2. Delete a node in a Doubly Linked List **/
	/* delete first occurrence */
	public DLNode<K> deleteNodeFirstK(DLNode<K> h, K k);

	/* delete all the node having value k */
	public DLNode<K> deleteAllOccurance(DLNode<K> h, K k);

	/* delete first occurrence */
	public DLNode<K> deleteNodeLastK(DLNode<K> h, K k);

	/** 3. Reverse a Doubly Linked List **/
	/* iterative way to reverse */
	public DLNode<K> reverseIterative(DLNode<K> h);

	/* recursive way to reverse */
	public DLNode<K> reverseRecursive(DLNode<K> node);

	/** 4. The Great Tree-List Recursion Problem. **/
	public BTNode<K> bstToList(BTNode<K> k);

	/** 5. Copy a linked list with next and arbit pointer **/
	/* create random pointer list */
	public DLNode<K> createRandomPointerList(K[] k);

	/* clone random pointer list */
	public DLNode<K> cloneRandomPointerList(DLNode<K> h);

	/** 6. QuickSort on Doubly Linked List **/
	public DLNode<K> partitation(DLNode<K> h, DLNode<K> l);

	public void quickSort(DLNode<K> h, DLNode<K> t);

	/** 7. Swap Kth node from beginning with Kth node from end in a Linked List **/
	public DLNode<K> swapKthNodeFromBegAndEnd(DLNode<K> node, int k);

	/** 8. Merge Sort for Doubly Linked List **/
	/* get middle node of list */
	public DLNode<K> getMiddle(DLNode<K> k);

	/* merge two sorted list */
	public DLNode<Integer> sortedMerge(DLNode<K> k1, DLNode<K> k2);

	/* merge sort of list */
	public DLNode<K> mergeSort(DLNode<K> k);

	/** 9. Create a Doubly Linked List from a Ternary Tree **/
	public TTreeNode<K> createTernaryTree(TTreeNode<K> node, int key);

	public void printTTree(TTreeNode<K> node);

	public TTreeNode<K> createFromTernaryTree(TTreeNode<K> node);

	public void printTTOfDl(TTreeNode<K> node);

	/** 10. Find pairs with given sum in doubly linked list **/
	public List<List<DLNode<K>>> pairOfGivenSum(DLNode<K> k, int sum);

	/** 11. Insert value in sorted way in a sorted doubly linked list **/
	public DLNode<K> insertArrSorted(DLNode<K> head, K k[]);

	/** 12. Delete a Doubly Linked List node at a given position **/
	public DLNode<Integer> deletePos(DLNode<Integer> h, int pos);

	/**
	 * 13. Count triplets in a sorted doubly linked list whose sum is equal to a
	 * given value x
	 **/
	public int countPairs(DLNode<Integer> first, DLNode<Integer> second, int value);

	public int tripletROfGivenSum(DLNode<K> k, int sum);

	/** 14. Remove duplicates from a sorted doubly linked list **/
	public DLNode<K> removeDuplicate(DLNode<K> k);

	/** 15. Delete all occurrences of a given key in a doubly linked list **/
	public DLNode<K> deleteAllOccuranceOfX(DLNode<K> k, int x);

	/** 16. Remove duplicates from an unsorted doubly linked list **/
	public DLNode<K> remveDuplicateFromNonSotedList(DLNode<K> k);

	/** 17. Sort the biotonic doubly linked list **/
	public DLNode<K> sortBitonicList(DLNode<K> k);

	/** 18. Sort a k sorted doubly linked list **/
	public DLNode<K> sortAKSortedDLL(DLNode<K> k, int x);
	/** 19. Convert a given Binary Tree to Doubly Linked List | Set **/
	// @See 4.

	/**
	 * Below question get collcted from ISLinkLIst
	 ******************************************************/
	/** 50. Clone a linked list with next and random pointer | Set 2 **/
	public DLNode<K> arbitrarylist(DLNode<K> h);
	
	public DLNode<K> cloneList(DLNode<K> h);
}
