/**
 * 
 */
package com.design.analysis.core.ds.hashing.utils;

import com.design.analysis.core.ds.hashing.key2.node.HK2TTNode;
import com.design.analysis.core.ds.hashing.node.HTNode;

/** @author @Gurug **/
/**
 * This Utility class and used in hashing operation for store Key
 */

public class BTreeTTUitls<K extends Comparable<K>, V> {

	BTreeUitls<K> btltUtils = new BTreeUitls<>();

	public HK2TTNode<K, V> createBst(HK2TTNode<K, V> node, K k) {

		if (node == null)
			node = new HK2TTNode<K, V>(k);
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

	public void inOrderPrint(HK2TTNode<K, V> node) {
		if (node != null) {
			inOrderPrint(node.lt);
			System.out.print("\nkey2:-(" + node.k + ")->");
			inInOrderPrint(node.up);
			inOrderPrint(node.rt);
		}
	}

	public void inInOrderPrint(HTNode<V> node) {
		if (node != null) {
			inInOrderPrint(node.lt);
			System.out.print("(" + node.k + ")->");
			inInOrderPrint(node.rt);
		}
	}

	public HK2TTNode<K, V> recvSearch(HK2TTNode<K, V> node, K k) {
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

	public HK2TTNode<K, V> delete(HK2TTNode<K, V> node, K key) {
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
				HK2TTNode<K, V> q = node;
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
				HK2TTNode<K, V> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.k = node.lt.k;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						HK2TTNode<K, V> q = p;
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
					HK2TTNode<K, V> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.k = node.rt.k;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						HK2TTNode<K, V> y = x;
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
