package com.design.analysis.core.ds.linklist;

import com.design.analysis.core.ds.linklist.node.SLNode;
import com.design.analysis.core.ds.linklist.utils.Lap;

/*
 * 
 * @author GuruG
 * 
 * 1.	Circular Linked List Introduction and Applications,
2.	Circular Linked List Traversal
3.	Split a Circular Linked List into two halves
4.	Sorted insert for circular linked list
5.	Check if a linked list is Circular Linked List
6.	Convert a Binary Tree to a Circular Doubly Link List
7.	Circular Singly Linked List | Insertion
8.	Deletion from a Circular Linked List
9.	Circular Queue | Set 2 (Circular Linked List Implementation)
10.	Count nodes in Circular linked list
11.	Josephus Circle using circular linked list
12.	Convert singly linked list into circular linked list

 */
public interface ISCLinkList<K> {

	/** 1. Circular Linked List Introduction and Applications, **/
	// just theory part
	/** 2. Circular Linked List Traversal **/
	/* insert collection of element */
	public Lap<SLNode<K>, SLNode<K>> insertArrLast(Lap<SLNode<K>, SLNode<K>> lap, K k[]);

	/* insert single element */
	public Lap<SLNode<K>, SLNode<K>> insertElementLast(Lap<SLNode<K>, SLNode<K>> lap, K k);

	public void printList(SLNode<K> k);

	/** 3. Split a Circular Linked List into two halves **/
	public Lap<SLNode<K>, SLNode<K>> splitTwoHalves(SLNode<K> k);

	/** 4. Sorted insert for circular linked list **/
	public SLNode<K> insertArrSorted(SLNode<K> head, K k[]);

	/** 5. Check if a linked list is Circular Linked List **/
	// @See ISLinkList.java @34. problem
	/** 6. Convert a Binary Tree to a Circular Doubly Link List **/

	/** 7. Circular Singly Linked List | Insertion **/
	// @See 2.
	/** 8. Deletion from a Circular Linked List **/
	public SLNode<Integer> deleteAllX(SLNode<K> head, K x);
	/* 9. Circular Queue | Set 2 (Circular Linked List Implementation) */
	/** 10. Count nodes in Circular linked list **/
	// travell and count...return count+1; init count = 1
	/* 11. Josephus Circle using circular linked list */
	/** 12. Convert singly linked list into circular linked list **/
	// jsut travelled to last and point it to head
}
