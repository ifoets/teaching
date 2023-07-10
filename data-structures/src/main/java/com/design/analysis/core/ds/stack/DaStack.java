package com.design.analysis.core.ds.stack;

import com.design.analysis.core.ds.node.SLNode;

public class DaStack implements IDaStack {

	public SLNode head = null;
	public SLNode tail = null;

	/** basic operation on stack **/
	/* create stack for given array elements */
	public SLNode stack(int a[]) {

		SLNode x = null;
		for (int i = 0; i < a.length; i++) {
			x = new SLNode(a[i]);
			if (head == null && tail == null)
				head = tail = x;
			else {
				tail.next = x;
                tail = x;
			}
		}
		return head;
	}

	/* remove element from stack */
	public SLNode pop() {
		SLNode q = null;
		if (tail == null)
			return null;
        if(head==tail)
        {
            q=head;
            head=tail=null;
            return q;
        }
		if (head.next == tail) {
			q = tail;
			tail = head;
            tail.next=null;
			return q;
		}
		SLNode node = head;
		for (; node.next.next != null; node = node.next)
			;
		q = node.next;
		tail = node;
		tail.next = null;
		return q;
	}

	/* retrieve element from stack */
	public SLNode peek() {
		return tail;
	}

	/* add element in stack */
	public SLNode push(int x) {
		SLNode temp = new SLNode(x);
		if (head == null && tail == null)
			head = tail = temp;
		else {
			tail.next = temp;
			tail = tail.next; // or tail=temp;
		}
		return head;
	}

	/* print stack */

	public void print(SLNode node) {

		for (; node != null; System.out.print(node.dt + "->"), node = node.next)
			;
	}

	/* destroy stack */
	public void nullifyStack() {
		SLNode node = head;
		SLNode prev = null;
		for (; node != null; node = node.next, prev.next = null) {
			prev = node;
		}
		head = tail = null;
	}
}
