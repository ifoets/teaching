/**
 * 
 */
package com.design.analysis.core.ds.hashing.utils;

import com.design.analysis.core.ds.hashing.key2.node.HK2TLNode;
import com.design.analysis.core.ds.hashing.node.HLNode;

/** @author @Gurug **/
/**
 * This Utility class and used in hashing operation for store Key
 */

public class BTreeTLUitls<K extends Comparable<K>, V> {

	public HK2TLNode<K, V> createBst(HK2TLNode<K, V> node, K k) {

		if (node == null)
			node = new HK2TLNode<K, V>(k);
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

	public void inOrderPrint(HK2TLNode<K, V> node) {
		if (node != null) {
			inOrderPrint(node.lt);
			System.out.print("\nkey2:-(" + node.k + ")->");
			HLNode<V> p = node.next;
			for (; p != null; p = p.next) {
				System.out.print("(" + p.t + ")->");
			}
			inOrderPrint(node.rt);
		}
	}

	public HK2TLNode<K, V> recvSearch(HK2TLNode<K, V> node, K k) {
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

	public HK2TLNode<K, V> delete(HK2TLNode<K, V> node, K key) {
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
				HK2TLNode<K, V> q = node;
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
				HK2TLNode<K, V> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.k = node.lt.k;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						HK2TLNode<K, V> q = p;
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
					HK2TLNode<K, V> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.k = node.rt.k;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						HK2TLNode<K, V> y = x;
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
