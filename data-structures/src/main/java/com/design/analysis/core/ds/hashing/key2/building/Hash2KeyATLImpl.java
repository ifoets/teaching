/**
 * 
 */
package com.design.analysis.core.ds.hashing.key2.building;

import com.design.analysis.core.ds.hashing.node.HLNode;
import com.design.analysis.core.ds.hashing.utils.BTreeTLUitls;
import com.design.analysis.core.ds.common.model.Product;
import com.design.analysis.core.ds.hashing.key2.node.HK2TLNode;

/**
 * @author @Gurug
 * 
*Here Key1 and Key2 are Integer you may choose Object
* start 2 key building, key1 in array index , key2 store in tree and value store in list
* store product (Array(key1)-LIST(key2)-Tree(value))
**/
/** Scenario, product key will be up to x digit unique no **/
public class Hash2KeyATLImpl implements IHash2KeyATL<Integer, Integer, Product> {

	public BTreeTLUitls<Integer, Product> btTLKeyUtils = new BTreeTLUitls<Integer, Product>();
	public int KEY1_SIZE = 100;
	public HK2TLNode<Integer, Product> table[] = null;

	/* add mass of element in single shot */
	@SuppressWarnings("unchecked")
	public void addArray(Integer key1[], Integer key2[], Product a[], Integer tableSize) {
		HK2TLNode<Integer, Product> find = null;
		HLNode<Product> q = null;

		if (table == null)
			table = new HK2TLNode[tableSize];

		for (int i = 0; i < a.length; i++) {
			HLNode<Product> x = new HLNode<Product>(a[i]);

			// if no any node exists in bucket position
			if (table[key1[i]] == null) {
				table[key1[i]] = new HK2TLNode<Integer, Product>(key2[i]);
				table[key1[i]].next = x;
			} else {
				// go for search key2 in tree if found traverse for value

				HK2TLNode<Integer, Product> p = table[key1[i]];
				// search key2 in tree if find then add in their list
				find = btTLKeyUtils.recvSearch(p, key2[i]);
				if (find == null)// no key exists insert new node to it
				{
					p = btTLKeyUtils.createBst(p, key2[i]);// it return root
					find = btTLKeyUtils.recvSearch(p, key2[i]);
				}
				if (find.next == null)
					find.next = x;
				else {
					q = find.next;
					while (q.next != null)
						q = q.next;
					q.next = x;
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

		HK2TLNode<Integer, Product> p = btTLKeyUtils.recvSearch(table[key1], key2);
		if (p != null) {
			HLNode<Product> q = p.next;
			for (; q != null; q = q.next) {
				if (q.t.mno == x.mno)
					return q.t;
			}
		}
		return null;
	}

	/* delete an element */
	public boolean deleteElement(Product x) {
		boolean deleted = false;
		int key1 = hashKey1(x);
		int key2 = hashKey2(x);

		HLNode<Product> prev = null;
		HK2TLNode<Integer, Product> p = btTLKeyUtils.recvSearch(table[key1], key2);
		if (p != null) {
			HLNode<Product> q = p.next;
			// check only one node in list
			for (; q != null; prev = q, q = q.next) {
				if (q.t.mno == x.mno) {
					// check for first node
					if (p.next.next == null) {
						p.next = null;
						//u may delete tree node too need requirement code here
						/*if (p == p.pt.lt)
							p.pt.lt = null;
						else
							p.pt.rt = null;*/
					} else {
						HLNode<Product> t = prev.next;
						prev.next = prev.next.next;
						t.next = null;
						t = null;
					}
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
					btTLKeyUtils.inOrderPrint(table[i]);
				}
			}
		}
	}
}
