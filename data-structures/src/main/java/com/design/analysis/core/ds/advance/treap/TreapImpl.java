package com.design.analysis.core.ds.advance.treap;

import com.design.analysis.core.ds.advance.node.TreapNode;

public class TreapImpl implements ITreap<Integer> {

	@Override
	public TreapNode<Integer> insert(TreapNode<Integer> node, Integer key) {
		if (node == null)
			return new TreapNode<Integer>(key);
		else {
			if (key <= node.key) {
				// insert into left subtree
				node.lt = insert(node.lt, key);
				// Fix Heap property if it is violated
				if (node.lt.priority > node.priority)
					node = reightRotate(node);
			} else {
				// insert into right subtree
				node.rt = insert(node.rt, key);
				// Fix Heap property if it is violated
				if (node.rt.priority > node.priority)
					node = leftRotate(node);
			}
		}
		return node;
	}

	@Override
	public void displayInorder(TreapNode<Integer> node) {
		if (node != null) {
			displayInorder(node.lt);
			System.out.println("[" + node.key + ", " + node.priority + "]");
			displayInorder(node.rt);
		}
	}

	@Override
	public TreapNode<Integer> search(TreapNode<Integer> node, Integer key) {

		if (node == null || node.key == key)
			return node;
		else {
			if (key < node.key)
				return search(node.lt, key);
			else
				return search(node.rt, key);
		}
	}

	@Override
	public TreapNode<Integer> deleteNode(TreapNode<Integer> node, Integer key) {
		if (node == null)
			return node;

		if (key < node.key)
			node.lt = deleteNode(node.lt, key);
		else if (key > node.key)
			node.rt = deleteNode(node.rt, key);

		// IF KEY IS AT ROOT

		// If left is NULL
		else if (node.lt == null) {
			TreapNode<Integer> temp = node.rt;
			node = null;
			node = temp; // Make right child as root
		}

		// If Right is NULL
		else if (node.rt == null) {
			TreapNode<Integer> temp = node.lt;
			node = null;
			node = temp; // Make left child as root
		}

		// If ksy is at root and both left and right are not NULL
		else if (node.lt.priority < node.rt.priority) {
			node = leftRotate(node);
			node.lt = deleteNode(node.lt, key);
		} else {
			node = reightRotate(node);
			node.rt = deleteNode(node.rt, key);
		}

		return node;
	}

	@Override
	public TreapNode<Integer> leftRotate(TreapNode<Integer> x) {
		TreapNode<Integer> y = x.rt;
		x.rt = y.lt;
		y.lt = x;
		return y;
	}

	@Override
	public TreapNode<Integer> reightRotate(TreapNode<Integer> y) {
		TreapNode<Integer> x = y.lt;
		y.lt = x.rt;
		x.rt = y;
		return x;
	}
}
