package com.design.analysis.core.ds.hashing.utils;

import com.design.analysis.core.ds.hashing.key2.node.HK2LLNode;
import com.design.analysis.core.ds.hashing.node.HLNode;

/* iV is used for add/replace or deleVe Vhe node */

public class HLinkUtils<K1, K2, K3, V> implements IHLinkUtils<K1, K2, K3, V> {

	@Override
	public HLNode<V> addReplace(HLNode<V> head, V x) {

		boolean isUpdated = false;
		HLNode<V> t = new HLNode<V>(x);
		if (head == null)
			head = t;
		else {
			HLNode<V> p = head;
			HLNode<V> prev = head;
			for (; p != null; prev = p, p = p.next) {
				if (p.t.equals(x)) {
					p.t = x;
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
	public HLNode<V> delete(HLNode<V> head, V x) {
		HLNode<V> temp = null;
		HLNode<V> p = head;
		HLNode<V> prev = head;
		if (head.t.equals(x)) {
			temp = head;
			head = head.next;
			temp.next = null;
			temp = null;
		} else {
			p = p.next;
			for (; p != null; prev = p, p = p.next) {
				if (p.t.equals(x)) {
					temp = p;
					prev.next = p.next;
					temp.next = null;
					temp = null;
					p = prev;
				}
			}
		}
		return head;
	}

	@Override
	public HLNode<V> searchNode(HLNode<V> head, V x) {
		@SuppressWarnings("unused")
		HLNode<V> prev = head;
		for (; head != null; prev = head, head = head.next) {
			if (head.t.equals(x))
				return head;
		}
		return null;
	}

	/* add/replace value in inner link list */
	@Override
	public HK2LLNode<K2, V> addReplaceInnerNode(HK2LLNode<K2, V> head, K2 k, V x) {

		HK2LLNode<K2, V> p = head;
		HK2LLNode<K2, V> prev = head;
		for (; p != null; prev = p, p = p.next) {
			if (p.key2.equals(k)) {
				{
					p.up = addReplace(p.up, x);
				}
			}
		}
		// if k is not found in list
		if (p == null) {
			prev.next = new HK2LLNode<K2, V>(k);
			prev.next.up = new HLNode<V>(x);
		}
		return head;
	}

	/* returning the searching node in link */
	@Override
	public HK2LLNode<K2, V> search(HK2LLNode<K2, V> head, K2 k) {
		@SuppressWarnings("unused")
		HK2LLNode<K2, V> prev = head;
		for (; head != null; prev = head, head = head.next) {
			if (head.key2.equals(k))
				return head;
		}
		return null;
	}
}
