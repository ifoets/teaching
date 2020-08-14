package com.design.analysis.ds.linklist;

import com.design.analysis.ds.linklist.node.SLNode;
import com.design.analysis.ds.linklist.utils.Lap;
import com.design.analysis.ds.linklist.utils.SLHashLap;

public class SCLinkListImpl implements ISCLinkList<Integer> {

	public SLNode<Integer> head = null;
	public SLNode<Integer> tail = null;

	/** 3. Linked List Insertion **/
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> insertArrLast(Lap<SLNode<Integer>, SLNode<Integer>> lap, Integer a[]) {

		if (a == null || a.length == 0)
			return lap;

		if (lap == null)
			lap = new SLHashLap();

		head = lap.getHead();
		tail = lap.getTail();

		int i = 0;
		if (head == null) {
			head = tail = new SLNode<Integer>(a[0]);
			i++;
		}
		for (; i < a.length; i++) {
			tail.next = new SLNode<Integer>(a[i]);
			tail = tail.next;
		}
		tail.next = head;// this is makes list circular
		lap.put(head, tail);
		return lap;
	}

	/* insert single element */
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> insertElementLast(Lap<SLNode<Integer>, SLNode<Integer>> lap,
			Integer x) {

		SLNode<Integer> temp = new SLNode<Integer>(x);
		if (lap == null) {
			lap = new SLHashLap();
			head = tail = temp;
		} else {
			tail = lap.getTail();
			tail.next = temp;
			tail = tail.next;
		}
		lap.put(head, tail);
		return lap;
	}

	/* print the link list nodes */
	public void printList(SLNode<Integer> node) {
		SLNode<Integer> head = node;
		for (; node.next != head; System.out.print(node.k + "->"), node = node.next)
			;
		System.out.print(node.k + "->");
	}

	/** 3. Split a Circular Linked List into two halves **/
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> splitTwoHalves(SLNode<Integer> head) {

		SLHashLap lap = new SLHashLap();
		SLNode<Integer> p, q, h2;
		p = q = head;
		while (p.next != head && p.next.next != head) {
			q = q.next;
			p = p.next.next;
		}
		h2 = q.next;
		q.next = head;
		p.next = h2;
		lap.setHead(head);
		lap.setTail(h2);
		return lap;
	}

	/** 4. Sorted insert for circular linked list **/
	@Override
	public SLNode<Integer> insertArrSorted(SLNode<Integer> head, Integer a[]) {

		SLNode<Integer> p = null;

		for (int i = 0; i < a.length; i++) {
			SLNode<Integer> temp = new SLNode<Integer>(a[i]);
			if (head == null) {
				head = tail = temp;
			} else if (a[i] <= head.k) { // = applied later
				temp.next = head;
				head = temp;
			} else {
				p = head;
				while (p.next != null) {
					if (a[i] <= p.next.k) { // = applied later
						temp.next = p.next;
						p.next = temp;
						break;
					}
					p = p.next;
				}
				if (p.next == null)
					p.next = temp;
			}
		}
		p = head;
		while (p.next != null)
			p = p.next;
		tail = p;
		tail.next = head;
		return head;
	}

	@Override
	public SLNode<Integer> deleteAllX(SLNode<Integer> head, Integer x) {
		SLNode<Integer> tail = head;
		while (tail.next != head)
			tail = tail.next;
		tail.next = null;// make it non circular list

		boolean isFound = false;
		if (head == null)
			return null;
		SLNode<Integer> q = head;
		while (head != null && head.k == x) {
			head = head.next;
			q.next = null;
			q = head;
			isFound = true;
		}
		SLNode<Integer> node = head.next;
		SLNode<Integer> prev = head;

		for (; node != null; prev = node, node = node.next) {
			if (node.k == x) {
				q = node;
				prev.next = q.next;
				q.next = null;
				q = null;
				node = prev;
				isFound = true;
			}
		}

		// connecect tail to head
		tail = head;
		while (tail.next != null)
			tail = tail.next;
		tail.next = head;

		if (isFound)
			System.out.println("\nall: " + x + ": is deleted");
		else
			System.out.println(x + ": is not found");
		return head;
	}
}
