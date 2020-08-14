/**
 * 
 */
package com.design.analysis.ds.hashing.key2.building;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.hashing.key2.node.HK2TTNode;
import com.design.analysis.ds.hashing.node.HTNode;
import com.design.analysis.ds.hashing.utils.BTreeUitls;
import com.design.analysis.ds.hashing.utils.BTreeTTUitls;

//TODO hole code 
/**
 * @author @Gurug
 * 
*Here Key1 and Key2 are Integer you may choose Object
* start 2 key building, key1 in array index , key2 store in tree and value store in list
* store product (Array(key1)-Tree(key2)-Tree(value))
**/
/** Scenario, product key will be up to x digit unique no **/
public class Hash2KeyATTImpl implements IHash2KeyATT<Integer, Integer, Product> {

	public BTreeTTUitls<Integer, Product> btTTUtils = new BTreeTTUitls<Integer, Product>();
	public BTreeUitls<Product> btLTUtils = new BTreeUitls<Product>();

	public int KEY1_SIZE = 100;
	public HK2TTNode<Integer, Product> table[] = null;

	/* add mass of element in single shot */
	@SuppressWarnings("unchecked")
	public void addArray(Integer key1[], Integer key2[], Product a[], Integer tableSize) {
		HK2TTNode<Integer, Product> find = null;

		if (table == null)
			table = new HK2TTNode[tableSize];

		for (int i = 0; i < a.length; i++) {
			HTNode<Product> x = new HTNode<Product>(a[i]);

			// if no any node exists in bucket position
			if (table[key1[i]] == null) {
				table[key1[i]] = new HK2TTNode<Integer, Product>(key2[i]);
				table[key1[i]].up = x;
			} else {
				// go for search key2 in tree if found traverse for value
				HK2TTNode<Integer, Product> p = table[key1[i]];
				// search key2 in tree if find then add in their list
				find = btTTUtils.recvSearch(p, key2[i]);
				if (find == null)// no key exists insert new node to it
				{
					p = btTTUtils.createBst(p, key2[i]);// it return root
					find = btTTUtils.recvSearch(p, key2[i]);
				}
				find.up = btLTUtils.createBst(find.up, a[i]);
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

		HK2TTNode<Integer, Product> p = btTTUtils.recvSearch(table[key1], key2);
		if (p != null) {
			HTNode<Product> q = btLTUtils.recvSearch(p.up, x);
			if (q != null)
				return q.k;
		}
		return null;
	}

	/* delete an element */
	public boolean deleteElement(Product x) {
		boolean deleted = false;
		int key1 = hashKey1(x);
		int key2 = hashKey2(x);

		HK2TTNode<Integer, Product> p = btTTUtils.recvSearch(table[key1], key2);
		if (p != null) {
			HTNode<Product> q = btLTUtils.recvSearch(p.up, x);
			if(q!=null)
			{
				if(q.k.mno==x.mno)
				{
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
					btTTUtils.inOrderPrint(table[i]);
				}
			}
		}
	}
}
