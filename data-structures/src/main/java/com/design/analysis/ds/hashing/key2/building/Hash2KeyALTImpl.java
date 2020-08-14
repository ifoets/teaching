/**
 * 
 */
package com.design.analysis.ds.hashing.key2.building;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.hashing.key2.node.HK2LTNode;
import com.design.analysis.ds.hashing.node.HTNode;
import com.design.analysis.ds.hashing.utils.BTreeUitls;

/**
 * @author @Gurug
 *start 2 key building key1 table index, key2 link list and tree for
 * store value (ARRAY(key1)-LIST(key2)-TREE(value))
 **/
/** Scenario, product key will be up to x digit unique no **/

public class Hash2KeyALTImpl implements IHash2KeyALT<Integer, Integer, Product> {

	public BTreeUitls<Product> btLTUtils = new BTreeUitls<Product>();
	public int KEY1_SIZE = 100;
	public HK2LTNode<Integer, Product> table[] = null;

	/* add mass of element in single shot */
	@SuppressWarnings("unchecked")
	public void addArray(Integer key1[], Integer key2[], Product a[], Integer tableSize) {
		HK2LTNode<Integer, Product> prev = null;

		if (table == null)
			table = new HK2LTNode[tableSize];

		for (int i = 0; i < a.length; i++) {
			HTNode<Product> x = new HTNode<Product>(a[i]);

			// if no any node exists in bucket position
			if (table[key1[i]] == null) {
				table[key1[i]] = new HK2LTNode<Integer, Product>(key2[i]);
				table[key1[i]].up = x;
			} else {
				// go for search key2 if found traverse for value
				boolean foundKey2 = false;
				HK2LTNode<Integer, Product> p = table[key1[i]];
				// loop breaking at last node of key2 link list

				while (p != null) {
					if (p.key2 == key2[i]) {
						foundKey2 = true;
						break;
					}
					prev = p;
					p = p.next;
				}

				// add value in tree pass the root node
				if (foundKey2 || prev.key2 == key2[i]) {
					if (foundKey2)
						p.up = btLTUtils.createBst(p.up, a[i]);
					else
						prev.up = btLTUtils.createBst(p.up, a[i]);
				} else {
					prev.next = new HK2LTNode<Integer, Product>(key2[i]);
					prev.next.up = x;
				}
			}
		}
	}

	/* add an element or replace if existing */
	public void addElement(Integer key1, Integer key2, Product x) {
		Integer newKey1[] = { key1 };
		Integer newKey2[] = { key2 };
		Product newProd[] = { x };

		addArray(newKey1, newKey2, newProd, 1); // 1 is not useful
	}

	/* find an element */
	public Product getElement(Integer key1, Integer key2, Product x) {

		HK2LTNode<Integer, Product> p = null;
		for (p = table[key1]; p != null; p = p.next) {
			if (p.key2 == key2) {
				HTNode<Product> q = btLTUtils.recvSearch(p.up, x);// p.up is root;
				if (q != null)
					return q.k;
			}
		}
		return null;
	}

	/* delete an element */
	public boolean deleteElement(Product x) {
		boolean deleted = false;
		int key1 = hashKey1(x);
		int key2 = hashKey2(x);

		HK2LTNode<Integer, Product> p = null;
		for (p = table[key1]; p != null; p = p.next) {
			if (p.key2 == key2) {
				if (btLTUtils.recvSearch(p.up, x) != null) {
					p.up = btLTUtils.delete(p.up, x);
					deleted = true;
				}
			}
		}
		return deleted;
	}

	/* destroy cache */
	public void destroyCache() {
		// TODOdestroy all node and pointer
		table = null;
	}

	/* a way to find the key */
	@Override
	public int hashKey1(Product x) {
		return Integer.valueOf(x.ptype.substring(0, 1));
	}

	/* a way to find key2 */
	@Override
	public int hashKey2(Product x) {
		return (int) x.pid;
	}

	/* print all the element if found */
	public void print() {

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println("\ntable[" + i + "]");
				if (table[i] != null) {
					HK2LTNode<Integer, Product> p = table[i];
					for (; p != null; p = p.next) {
						System.out.print("\nkey2:-(" + p.key2 + ")->");
						btLTUtils.inOrderPrint(p.up);
					}
				}
			}
		}
	}
}
