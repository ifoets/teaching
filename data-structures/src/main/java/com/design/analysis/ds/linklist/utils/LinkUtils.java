package com.design.analysis.ds.linklist.utils;

import com.design.analysis.ds.linklist.node.SLNode;

public class LinkUtils<V> implements ILinkUtils<V> {

	/* it is used in operation on value node */
	@Override
	public SLNode<V> addReplace(SLNode<V> head, V x) {
		boolean isUpdated = false;
		SLNode<V> t = new SLNode<V>(x);
		if (head == null)
			head = t;
		else {
			SLNode<V> p = head;
			SLNode<V> prev = head;
			for (; p != null; prev = p, p = p.next) {
				if (p.k.equals(x)) {
					p.k = x;
					isUpdated = true;
					break;
				}
			}
			if (!isUpdated)
				prev.next = t;
		}
		return head;
	}

	@Override
	public SLNode<V> delete(SLNode<V> head, V x) {
		boolean isDeleted = false;
		SLNode<V> temp = null;
		SLNode<V> p = head;
		SLNode<V> prev = head;
		if (head.k.equals(x)) {
			temp = head;
			head = head.next;
			temp.next = null;
			temp = null;
			isDeleted = true;
		} else {
			p = p.next;
			for (; p != null; prev = p, p = p.next) {
				if (p.k.equals(x)) {
					temp = p;
					prev.next = p.next;
					temp.next = null;
					temp = null;
					p = prev;
					isDeleted = true;
				}
			}
		}
		if (isDeleted)
			System.out.println("Deleted:-" + x.toString());
		else
			System.out.println("Not found:-" + x.toString());
		return head;
	}

	@Override
	public SLNode<V> searchNode(SLNode<V> head, V x) {
		@SuppressWarnings("unused")
		SLNode<V> prev = head;
		for (; head != null; prev = head, head = head.next) {
			if (head.k.equals(x))
				return head;
		}
		return null;
	}

	@Override
	public void display(SLNode<V> head) {
		for (; head != null; head = head.next)
			System.out.println(head.k.toString());
	}
}
