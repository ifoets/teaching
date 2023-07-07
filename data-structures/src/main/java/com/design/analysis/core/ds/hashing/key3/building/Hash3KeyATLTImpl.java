package com.design.analysis.core.ds.hashing.key3.building;

import com.design.analysis.core.ds.hashing.node.HTNode;
import com.design.analysis.core.ds.hashing.utils.BTreeTLTUitls;
import com.design.analysis.core.ds.hashing.utils.BTreeUitls;
import com.design.analysis.core.ds.common.model.Product;
/**@author @Gurug
/**
 * start 3 key building key1 table index, key2 in tree, key3 in tree and value
 * also store in tree too (ARRAY-LIST-LIST-LIST(value))
 **/
import com.design.analysis.core.ds.hashing.key2.node.HK2LTNode;
import com.design.analysis.core.ds.hashing.key3.node.HK3TLTNode;

public class Hash3KeyATLTImpl implements IHash3KeyATLT<Integer, Integer, Integer, Product> {

	public BTreeTLTUitls<Integer, Integer, Product> btTLTUtils = new BTreeTLTUitls<Integer, Integer, Product>();
	public BTreeUitls<Product> btTUtils = new BTreeUitls<Product>();

	public HK3TLTNode<Integer, Integer, Product>[] table = null;
	public HK3TLTNode<Integer, Integer, Product> findK2 = null;
	public HK2LTNode<Integer, Product> findK3 = null;
	public HK2LTNode<Integer, Product> prev = null;
	public HTNode<Product> valueNode = null;

	/* add mass of element in single shot */
	@SuppressWarnings("unchecked")
	@Override
	public void addArray(Integer key1[], Integer key2[], Integer key3[], Product a[], Integer tableSize) {

		if (table == null)
			table = new HK3TLTNode[tableSize];

		for (int i = 0; i < a.length; i++) {
			// insert in first K1 tree;
			table[key1[i]] = btTLTUtils.createBst(table[key1[i]], key2[i]);
			// find the inserted node
			findK2 = btTLTUtils.recvSearch(table[key1[i]], key2[i]);
			// insert in second K2 in list
			if (findK2.next == null) {
				findK2.next = new HK2LTNode<Integer, Product>(key3[i]);
				findK2.next.up = btTUtils.createBst(findK2.next.up, a[i]);
			} else {
				boolean key2Found = false;
				findK3 = findK2.next;
				prev = findK3;
				for (; findK3 != null; prev = findK3, findK3 = findK3.next) {
					if (key3[i].equals(findK3.key2)) {
						findK3.up = btTUtils.createBst(findK2.next.up, a[i]);
						key2Found = true;
						break;
					}
				}
				// other wise create new link and add new value tree
				if (!key2Found) {
					prev.next = new HK2LTNode<Integer, Product>(key2[i]);
					prev.next.up = btTUtils.createBst(prev.next.up, a[i]);
				}
			}
		}
	}

	/* add an element or replace if existing */
	public void addElement(Integer key1, Integer key2, Integer key3, Product x) {

		Integer newKey1[] = { key1 };
		Integer newKey2[] = { key2 };
		Integer newKey3[] = { key3 };
		Product newProd[] = { x };

		addArray(newKey1, newKey2, newKey3, newProd, 1);
	}

	/* find an element */
	@Override
	public Product getElement(Integer key1, Integer key2, Integer key3, Product x) {

		if (table[key1] != null) {
			findK2 = btTLTUtils.recvSearch(table[key1], key2);
			if (findK2 != null) {
				findK3 = findK2.next;
				for (; findK3 != null;findK3 = findK3.next) {
					if (key3.equals(findK3.key2)) {
						valueNode = btTUtils.recvSearch(findK3.up, x);
						if (valueNode != null) {
							return valueNode.k;
						}
					}
				}
			}
		}
		return null;
	}

	/* delete an element */
	@Override
	public boolean deleteElement(Product p) {
		Integer key1 = hashKey1(p);
		Integer key2 = hashKey2(p);
		Integer key3 = hashKey3(p);

		if (table[key1] != null) {
			findK2 = btTLTUtils.recvSearch(table[key1], key2);
			if (findK2 != null) {
				findK3 = findK2.next;
				for (; findK3 != null; findK3 = findK3.next) {
					if (key3.equals(findK3.key2)) {
						valueNode = btTUtils.recvSearch(findK3.up, p);
						if (valueNode != null) {
							btTUtils.delete(findK3.up, p);
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	/* destroy cache */
	@Override
	public void destroyCache() {
		// TODO destroy every node and their link too
		table = null;
	}

	/* a way to find the key */
	@Override
	public int hashKey1(Product v) {
		return v.pTypeId;
	}

	/* a way to find key2 */
	@Override
	public int hashKey2(Product v) {
		return Integer.valueOf(v.ptype.substring(0, 1));
	}

	/* a way to find key3 */
	public int hashKey3(Product v) {
		return (int) v.pid;
	}

	/* print all the element if found */
	public void print() {
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println("\ntable[" + i + "]");
				if (table[i] != null) {
					btTLTUtils.inOrderPrint(table[i]);
				}
			}
		}
	}
}
