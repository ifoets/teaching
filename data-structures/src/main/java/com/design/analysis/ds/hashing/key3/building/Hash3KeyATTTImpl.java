package com.design.analysis.ds.hashing.key3.building;

import com.design.analysis.ds.common.model.Product;
/**@author @Gurug
/**
 * start 3 key building key1 table index, key2 in tree, key3 in tree and value
 * also store in tree too (ARRAY-LIST-LIST-LIST(value))
 **/
import com.design.analysis.ds.hashing.key2.node.HK2TTNode;
import com.design.analysis.ds.hashing.key3.node.HK3TTTNode;
import com.design.analysis.ds.hashing.node.HTNode;
import com.design.analysis.ds.hashing.utils.BTreeTTTUitls;
import com.design.analysis.ds.hashing.utils.BTreeTTUitls;
import com.design.analysis.ds.hashing.utils.BTreeUitls;

public class Hash3KeyATTTImpl implements IHash3KeyATTT<Integer, Integer, Integer, Product> {

	public BTreeTTTUitls<Integer, Integer, Product> btTTTUtils = new BTreeTTTUitls<Integer, Integer, Product>();
	public BTreeTTUitls<Integer, Product> btTTUtils = new BTreeTTUitls<Integer, Product>();
	public BTreeUitls<Product> btTUtils = new BTreeUitls<Product>();

	public HK3TTTNode<Integer, Integer, Product>[] table = null;

	public HK3TTTNode<Integer, Integer, Product> findK2 = null;
	public HK2TTNode<Integer, Product> findK3 = null;
	public HTNode<Product> valueNode = null;

	/* add mass of element in single shot */
	@SuppressWarnings("unchecked")
	@Override
	public void addArray(Integer key1[], Integer key2[], Integer key3[], Product a[], Integer tableSize) {

		if (table == null)
			table = new HK3TTTNode[tableSize];

		for (int i = 0; i < a.length; i++) {
			// insert in first K1 tree;
			table[key1[i]] = btTTTUtils.createBst(table[key1[i]], key2[i]);
			// find the inserted node
			findK2 = btTTTUtils.recvSearch(table[key1[i]], key2[i]);
			// insert in second K2 tree
			findK2.inY = btTTUtils.createBst(findK2.inY, key3[i]);
			// search inserted K2
			findK3 = btTTUtils.recvSearch(findK2.inY, key3[i]);
			// insert in value tree
			findK3.up = btTUtils.createBst(findK3.up, a[i]);
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
			findK2 = btTTTUtils.recvSearch(table[key1], key2);
			if (findK2 != null) {
				findK3 = btTTUtils.recvSearch(findK2.inY, key3);
				if (findK3 != null) {
					valueNode = btTUtils.recvSearch(findK3.up, x);
					if (valueNode != null) {
						return valueNode.k;
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
			findK2 = btTTTUtils.recvSearch(table[key1], key2);
			if (findK2 != null) {
				findK3 = btTTUtils.recvSearch(findK2.inY, key3);
				if (findK3 != null) {
					valueNode = btTUtils.recvSearch(findK3.up, p);
					if (valueNode != null) {
						btTUtils.delete(findK3.up, p);
						return true;
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
					btTTTUtils.inOrderPrint(table[i]);
				}
			}
		}
	}
}
