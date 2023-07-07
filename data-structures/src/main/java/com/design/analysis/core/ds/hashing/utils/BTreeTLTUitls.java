/**
 * 
 */
package com.design.analysis.core.ds.hashing.utils;

import com.design.analysis.core.ds.hashing.key2.node.HK2LTNode;
import com.design.analysis.core.ds.hashing.key3.node.HK3TLTNode;
import com.design.analysis.core.ds.hashing.node.HTNode;

/** @author @Gurug **/
/**
 * This Utility class and used in hashing operation for store Key
 */

public class BTreeTLTUitls<K2 extends Comparable<K2>, K3, V> {

	// BTreeLTUitls<K> btltUtils = new BTreeLTUitls<>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HK3TLTNode<K2, K3, V> createBst(HK3TLTNode<K2, K3, V> node, K2 key2) {

		if (node == null)
			node = new HK3TLTNode(key2);
		else {
			// replacing
			if (key2.equals(node.k)) {
				node.k = key2;
			} else if (key2.compareTo(node.k) < 0) {
				node.lt = createBst(node.lt, key2);
				node.lt.pt = node;
			} else {
				node.rt = createBst(node.rt, key2);
				node.rt.pt = node;
			}
		}
		return node;
	}

	// Key2 tree pring
	public void inOrderPrint(HK3TLTNode<K2, K3, V> node) {
		if (node != null) {
			inOrderPrint(node.lt);
			System.out.print("\nkey2:-(" + node.k + ")->");
			listPrint(node.next);
			inOrderPrint(node.rt);
		}
	}

	// Key3 tree print
	public void listPrint(HK2LTNode<K3, V> node) {

		for (; node != null; node = node.next) {
			System.out.print("\nkey3:-(" + node.key2 + ")->");
			inInInOrderPrint(node.up);
		}
	}

	// value tree print
	public void inInInOrderPrint(HTNode<V> node) {
		if (node != null) {
			inInInOrderPrint(node.lt);
			System.out.print("(" + node.k + ")->");
			inInInOrderPrint(node.rt);
		}
	}

	public HK3TLTNode<K2, K3, V> recvSearch(HK3TLTNode<K2, K3, V> node, K2 key2) {
		if (node != null) {
			if (node.k.equals(key2)) {
				return node;
			} else if (node.k.compareTo(key2) < 0) {
				return recvSearch(node.rt, key2);
			} else {
				return recvSearch(node.lt, key2);
			}
		}
		return null;
	}

	public HK3TLTNode<K2, K3, V> delete(HK3TLTNode<K2, K3, V> node, K2 key) {
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
				HK3TLTNode<K2, K3, V> q = node;
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
				HK3TLTNode<K2, K3, V> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.k = node.lt.k;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						HK3TLTNode<K2, K3, V> q = p;
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
					HK3TLTNode<K2, K3, V> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.k = node.rt.k;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						HK3TLTNode<K2, K3, V> y = x;
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
}
