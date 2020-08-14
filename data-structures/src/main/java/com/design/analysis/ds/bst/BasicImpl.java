/**
 * 
 */
package com.design.analysis.ds.bst;

import com.design.analysis.ds.tree.node.BTNode;

/**
 * @author @Gurug
 *
 */
public class BasicImpl implements IBasic<Integer> {

	/* 1. Binary Search Tree | Set 1 (Search and Insertion) */
	/* create bst */
	public BTNode<Integer> insert(BTNode<Integer> node, Integer dt) {

		if (node == null)
			node = new BTNode<Integer>(dt);
		else {
			if (dt < node.t) {
				node.lt = insert(node.lt, dt);
				if (node.lt.pt == null)
					node.lt.pt = node;
			} else {
				node.rt = insert(node.rt, dt);
				if (node.rt.pt == null)
					node.rt.pt = node;
			}
		}
		return node;
	}

	/* search node in bst */
	public BTNode<Integer> search(BTNode<Integer> node, Integer dt) {

		if (node != null) {
			if (node.t == dt) {
				return node;
			} else if (node.t < dt) {
				return search(node.rt, dt);
			} else {
				return search(node.lt, dt);
			}
		}
		return null;
	}

	/* 2. Binary Search Tree | Set 2 (Delete) */
	public BTNode<Integer> delete(BTNode<Integer> node, Integer key) {

		if (node == null) {
			System.out.println(key + " not found in tree");
			return null;
		} else if (key < node.t) {
			delete(node.lt, key);
		} else if (key > node.t) {
			delete(node.rt, key);
		} else if (node.t == key) // found the node
		{
			// case 1: if no child of deleting node
			if (node.lt == null && node.rt == null) {
				BTNode<Integer> q = node;
				// if deleting node is left node of its parent
				if (q.pt.lt == node) {
					q.pt.lt = null;
				} else // deleting node is right child of its parent
				{
					q.pt.rt = null;
				}
				q = null;
			} else // deleting node have left as well as right child ..eighter
					// manage by right succesor or left predecesor
			{
				BTNode<Integer> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.t = node.lt.t;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						BTNode<Integer> q = p;
						p.pt.rt = q.lt; // add left predecesor to right to its
										// parent
						node.t = q.t; // copy the right precedesor to deleing
										// node and nullify it
						q = null;
					} else {
						node.t = node.lt.t;
						node.lt = node.lt.lt;
						node.lt.pt = node;
					}
				} else // find smallest in right subtree
				{
					BTNode<Integer> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.t = node.rt.t;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						BTNode<Integer> y = x;
						x.pt.lt = y.rt; // add left predecesor to right to its
										// parent
						node.t = y.t; // copy the right precedesor to deleing
										// node and nullify it
						x = null;
					} else {
						node.t = node.rt.t;
						node.rt = node.rt.rt;
						node.rt.pt = node;
					}
				}
			}
		}
		return node;
	}

	/* print inorder */
	public void inOrder(BTNode<Integer> node) {
		if (node != null) {
			inOrder(node.lt);
			System.out.print("(" + node.t + ")->");
			inOrder(node.rt);
		}
	}
}
