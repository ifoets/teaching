package com.design.analysis.ds.hashing.key3.building;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.hashing.key2.building.Hash2KeyLLLImpl;
import com.design.analysis.ds.hashing.key2.building.IHash2KeyLLL;
import com.design.analysis.ds.hashing.key2.node.HK2LLLNode;
import com.design.analysis.ds.hashing.key2.node.HK2LLNode;
import com.design.analysis.ds.hashing.node.HLNode;

/**
 * start 3 key building key1 table index, key2 link list, key3 link list and
 * link list for store value (ARRAY-LIST-LIST-LIST(value))
 **/
public class Hash3KeyALLLImpl implements IHash3KeyALLL<Integer, Integer, Integer, Product> {

	public IHash2KeyLLL<Integer, Integer, Product> ih2KeyLLL = new Hash2KeyLLLImpl();
	public HK2LLLNode<Integer, Integer, Product>[] table = null;

	/* add mass of element in single shot */
	@SuppressWarnings("unchecked")
	@Override
	public void addArray(Integer key1[], Integer key2[], Integer key3[], Product a[], Integer tableSize) {

		if (table == null)
			table = new HK2LLLNode[tableSize];

		for (int i = 0; i < a.length; i++) {

			table[key1[i]] = ih2KeyLLL.addElement(table[key1[i]], key2[i], key3[i], a[i]);
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
			return ih2KeyLLL.getElement(table[key1], key2, key3, x);
		}
		return null;
	}

	/* delete an element */
	@Override
	public boolean deleteElement(Product p) {
		int key1 = hashKey1(p);

		if (table[key1] != null) {
			return ih2KeyLLL.deleteElement(table[key1], p);
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

		/* key2 node */
		HK2LLLNode<Integer, Integer, Product> headHead = null;
		/* Key3 nodes */
		HK2LLNode<Integer, Product> nextHead = null;
		/* value nodes */
		HLNode<Product> node = null;

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println("\ntable[" + i + "]");
				if (table[i] != null) {
					headHead = table[i];
					for (; headHead != null; headHead = headHead.dn) {
						for (nextHead = headHead.next; nextHead != null; nextHead = nextHead.next) {
							System.out.println("\n[key2,key3]: [" + headHead.key1 + "," + nextHead.key2 + "]->");
							for (node = nextHead.up; node != null; node = node.next)
								System.out.print(node.t.pName + "->");
						}
					}
				}
			}
		}
	}
}
