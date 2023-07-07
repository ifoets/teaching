package com.design.analysis.core.ds.hashing.key2.building;

import com.design.analysis.core.ds.common.model.Product;

/**@author @Gurug
 * Note: Here key1,key2 have been taken as Integer object, you may choose any different object for them.
 * start 2 key building key1 table index, key2 link list and link list for
 * store value (ARRAY(key1)-LIST(key2)-LIST(value))
 **/

/** Scenario, product key will be up to x digit unique no **/
import com.design.analysis.core.ds.hashing.key2.node.HK2LLNode;
import com.design.analysis.core.ds.hashing.node.HLNode;

public class Hash2KeyALLImpl implements IHash2KeyALL<Integer, Integer, Product> {

	public HK2LLNode<Integer, Product>[] table = null;

	@SuppressWarnings("unchecked")
	@Override
	/* add mass of element in single shot */
	public void addArray(Integer key1[], Integer key2[], Product a[], Integer tableSize) {

		HK2LLNode<Integer, Product> prev = null;
		HLNode<Product> q = null;

		if (table == null)
			table = new HK2LLNode[tableSize];

		for (int i = 0; i < a.length; i++) {
			HLNode<Product> x = new HLNode<Product>(a[i]);

			// if no any node exists in bucket position
			if (table[key1[i]] == null) {
				table[key1[i]] = new HK2LLNode<Integer, Product>(key2[i]);
				table[key1[i]].up = x;
			} else {
				// go for search key2 if found traverse for value
				boolean foundKey2 = false;
				HK2LLNode<Integer, Product> p = table[key1[i]];
				// loop breaking at last node of key2 link list

				while (p != null) {
					if (p.key2 == key2[i]) {
						foundKey2 = true;
						break;
					}
					prev = p;
					p = p.next;
				}

				if (foundKey2 || prev.key2 == key2[i]) {
					if (foundKey2)
						q = p.up;
					else
						q = prev.up;

					if (q.next == null) {
						if (q.equals(x))// replacing
							q.t = x.t;
						else
							q.next = x;
						continue;
					} else {
						for (; q.next != null; q = q.next) {
							if (q.equals(x)) {// replacing
								q.t = x.t;
								break;
							}
						}
						q.next = x;
					}
				} else {
					prev.next = new HK2LLNode<Integer, Product>(key2[i]);
					prev.next.up = x;
				}
			}
		}
	}

	/* add an element or replace if existing */
	public void addElement(Integer key1, Integer key2, Product y) {
		Integer newKey1[] = { key1 };
		Integer newKey2[] = { key2 };
		Product newProd[] = { y };

		addArray(newKey1, newKey2, newProd, 1);

	}

	/* find an element */
	public Product getElement(Integer key1, Integer key2, Product x) {
		HK2LLNode<Integer, Product> p = null;
		for (p = table[key1]; p != null; p = p.next) {
			if (p.key2 == key2) {
				HLNode<Product> q = p.up;
				for (; q != null; q = q.next) {
					if (q.t.mno == x.mno)
						return q.t;
				}
			}
		}
		return null;
	}

	/* delete an element */
	public boolean deleteElement(Product x) {
		boolean deleted = false;
		int key1 = hashKey1(x);
		int key2 = hashKey2(x);

		HK2LLNode<Integer, Product> p = null;
		for (p = table[key1]; p != null; p = p.next) {
			if (p.key2 == key2) {
				HLNode<Product> q = p.up;
				if (q.t.mno == x.mno) // if first element
				{
					p.up = q.next;
					q = null;
					deleted = true;
				} else {
					for (; q.next.next != null; q = q.next) {
						if (q.next.t.mno == x.mno) {
							HLNode<Product> y = q.next;
							q.next = y.next;
							y.next = null;
							y = null;
							deleted = true;
						}
						// for last node
						if (q.next.t.mno == x.mno) {
							q.next = null;
							deleted = true;
						}
					}
				}
			}
		}
		return deleted;
	}

	/* destroy cache */
	public void destroyCache() {
		// TODO destroy all the nodes and pointer
		table = null;
	}

	/* a way to find the key */
	public int hashKey1(Product x) {
		return Integer.valueOf(x.ptype.substring(0, 1));
	}

	/* a way to find key2 */
	public int hashKey2(Product x) {
		return (int) x.pid;
	}

	/* print all the element if found */
	public void print() {

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println("\ntable[" + i + "]");
				if (table[i] != null) {
					HK2LLNode<Integer, Product> p = table[i];
					for (; p != null; p = p.next) {
						System.out.print("\nkey2:-(" + p.key2 + ")->");

						HLNode<Product> q = null;
						for (q = p.up; q != null; q = q.next) {
							System.out.print(q.t.pName + "->");
						}
					}
				}
			}
		}
	}
}
