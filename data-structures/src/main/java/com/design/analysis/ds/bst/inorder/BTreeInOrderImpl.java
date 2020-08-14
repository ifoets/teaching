package com.design.analysis.ds.bst.inorder;

import com.design.analysis.ds.bst.inorder.node.BTIONode;

public class BTreeInOrderImpl implements IBTreeInOrder<Integer> {

	public BTIONode<Integer> head = null;
	public BTIONode<Integer> tail = null;

	/** creating the tree who maintain the order of insertion */
	public BTIONode<Integer> create(BTIONode<Integer> node, Integer k, int ind) {

		if (node == null) {
			node = new BTIONode<Integer>(k);
			node.ind = ind;
			node.h = Math.abs(ind);
			if (head == null && tail == null)
				head = tail = node;
		} else {
			if (k < node.t) {
				boolean isNull = node.lt == null ? true : false;
				node.lt = create(node.lt, k, --ind);
				if (isNull) {// next/prev pointer assinging to just placed node in tree
					tail.next = node.lt;
					node.lt.prev = tail;
					tail = tail.next;
				}
			} else {
				boolean isNull = node.rt == null ? true : false;
				node.rt = create(node.rt, k, ++ind);
				if (isNull) {// next/prev pointer assinging to just placed node in tree
					tail.next = node.rt;
					node.rt.prev = tail;
					tail = tail.next;
				}
			}
		}

		return node;
	}

	/** print the order of insertion **/
	public void printInsertionOrder(BTIONode<Integer> node) {

		BTIONode<Integer> h = head;
		System.out.println("In order of insertion");
		while (h != null) {
			System.out.print(h.t + "->");
			h = h.next;
		}
		h = tail;
		System.out.println("\nReverse order of insertion");
		while (h != null) {
			System.out.print(h.t + "->");
			h = h.prev;
		}
	}

	/** print tree in order **/
	public void inorderPrint(BTIONode<Integer> node) {

		if (node != null) {
			inorderPrint(node.lt);
			System.out.print(node.t + "->");
			inorderPrint(node.rt);
		}
	}

	/** find which position the node inserted **/
	public int findPoisionOfInsertion(BTIONode<Integer> node, Integer k) {
		BTIONode<Integer> h = head;
		int pos = 1;
		while (h != null) {
			if (k == h.t)
				return pos;
			pos++;
			h = h.next;
		}
		return -1;
	}
}
