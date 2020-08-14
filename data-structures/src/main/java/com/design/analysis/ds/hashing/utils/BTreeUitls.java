/**
 * 
 */
package com.design.analysis.ds.hashing.utils;

import com.design.analysis.ds.hashing.node.HTNode;
import com.design.analysis.ds.tree.node.BTNode;

/** @author @Gurug **/
/**
 * This Utility class and used in hashing operation for store value
 */

public class BTreeUitls<K extends Comparable<K>> {

	public BTNode<K> createBst(BTNode<K> node, K k) {

		if (node == null)
			node = new BTNode<K>(k);
		else {
			// replacing
			if (k.equals(node.t)) {
				node.t = k;
			} else if (k.compareTo(node.t) < 0) {
				node.lt = createBst(node.lt, k);
			} else {
				node.rt = createBst(node.rt, k);
			}
		}
		return node;
	}

	public HTNode<K> createBst(HTNode<K> node, K k) {

		if (node == null)
			node = new HTNode<K>(k);
		else {
			// replacing
			if (k.equals(node.k)) {
				node.k = k;
			} else if (k.compareTo(node.k) < 0) {
				node.lt = createBst(node.lt, k);
				node.lt.pt = node;
			} else {
				node.rt = createBst(node.rt, k);
				node.rt.pt = node;
			}
		}
		return node;
	}

	public void inOrderPrint(HTNode<K> node) {
		if (node != null) {
			inOrderPrint(node.lt);
			System.out.print("(" + node.k + ")->");
			inOrderPrint(node.rt);
		}
	}

	public HTNode<K> recvSearch(HTNode<K> node, K k) {
		if (node != null) {
			if (node.k.equals(k)) {
				return node;
			} else if (node.k.compareTo(k) < 0) {
				return recvSearch(node.rt, k);
			} else {
				return recvSearch(node.lt, k);
			}
		}
		return null;
	}

	public HTNode<K> delete(HTNode<K> node, K key) {
		if (node == null) {
			System.out.println(key + " not found in tree");
			return null;
		} else if (key.compareTo(node.k) < 0) {
			delete(node.lt, key);
		} else if (key.compareTo(node.k) > 0) {
			delete(node.rt, key);
		} else if (node.k.equals(key)) // found the node
		{
			// case 1: if no child of deleting node
			if (node.lt == null && node.rt == null) {
				HTNode<K> q = node;
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
				HTNode<K> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.k = node.lt.k;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						HTNode<K> q = p;
						p.pt.rt = q.lt; // add left predecesor to right to its
										// parent
						node.k = q.k; // copy the right precedesor to deleing
										// node and nullify it
						q = null;
					} else {
						node.k = node.lt.k;
						node.lt = node.lt.lt;
						node.lt.pt = node;
					}
				} else // find smallest in right subtree
				{
					HTNode<K> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.k = node.rt.k;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						HTNode<K> y = x;
						x.pt.lt = y.rt; // add left predecesor to right to its
										// parent
						node.k = y.k; // copy the right precedesor to deleing
										// node and nullify it
						x = null;
					} else {
						node.k = node.rt.k;
						node.rt = node.rt.rt;
						node.rt.pt = node;
					}
				}
			}
		}
		return node;
	}

	public BTNode<K> bstToListUtils(BTNode<K> k) {

		if (k == null)
			return k;
		// convert left subtree to list and link to root/k
		if (k.lt != null) {
			BTNode<K> left = bstToListUtils(k.lt);
			// go to inorder predecessor
			for (; left.rt != null; left = left.rt)
				;
			left.rt = k;
			k.lt = left;
		}
		// convert right subtree to list and link to root/k
		if (k.rt != null) {
			BTNode<K> right = bstToListUtils(k.rt);
			// go to inorder predecessor
			for (; right.lt != null; right = right.lt)
				;
			right.lt = k;
			k.rt = right;
		}
		return k;
	}
}
