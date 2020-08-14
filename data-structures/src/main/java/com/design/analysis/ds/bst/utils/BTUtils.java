package com.design.analysis.ds.bst.utils;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.tree.node.BTNode;

public class BTUtils implements IBTUtils<Product> {

	@Override
	public BTNode<Product> createReplace(BTNode<Product> node, Product t) {
		if (node == null)
			node = new BTNode<>(t);
		else {
			if (t.pid == node.t.pid) {
				node.t = t;
			} else if (t.pid < node.t.pid) {
				node.lt = createReplace(node.lt, t);
				if (node.lt.pt == null)
					node.lt.pt = node;
			} else {
				node.rt = createReplace(node.rt, t);
				if (node.rt.pt == null)
					node.rt.pt = node;
			}
		}
		return node;
	}

	@Override
	public BTNode<Product> search(BTNode<Product> node, Product t) {
		if (node != null) {
			if (node.t.equals(t)) {
				return node;
			} else if (node.t.pid < t.pid) {
				return search(node.rt, t);
			} else {
				return search(node.lt, t);
			}
		}
		return null;
	}

	@Override
	public BTNode<Product> delete(BTNode<Product> node, Product t) {
		if (node == null) {
			System.out.println(t.toStringforTreeLink() + " not found in tree");
			return null;
		} else if (t.pid < node.t.pid) {
			delete(node.lt, t);
		} else if (t.pid > node.t.pid) {
			delete(node.rt, t);
		} else if (node.t.pid == t.pid) // found the node
		{
			// case 1: if no child of deleting node
			if (node.lt == null && node.rt == null) {
				BTNode<Product> q = node;
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
				BTNode<Product> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.t = node.lt.t;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						BTNode<Product> q = p;
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
					BTNode<Product> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.t = node.rt.t;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						BTNode<Product> y = x;
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

	@Override
	public void inorderPrint(BTNode<Product> node) {
		if (node != null) {
			inorderPrint(node.lt);
			System.out.println(node.t.toStringforTree() + "->");
			inorderPrint(node.rt);
		}

	}

	@Override
	public BTNode<Product> bstToListUtils(BTNode<Product> node) {

		if (node == null)
			return node;
		// convert left subtree to list and link to root/node
		if (node.lt != null) {
			BTNode<Product> left = bstToListUtils(node.lt);
			// go to inorder predecessor
			for (; left.rt != null; left = left.rt)
				;
			left.rt = node;
			node.lt = left;
		}
		// convert right subtree to list and link to root/node
		if (node.rt != null) {
			BTNode<Product> right = bstToListUtils(node.rt);
			// go to inorder predecessor
			for (; right.lt != null; right = right.lt)
				;
			right.lt = node;
			node.rt = right;
		}
		return node;
	}

}
