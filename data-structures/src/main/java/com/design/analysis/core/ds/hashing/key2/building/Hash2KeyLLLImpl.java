package com.design.analysis.core.ds.hashing.key2.building;

import com.design.analysis.core.ds.hashing.node.HLNode;
import com.design.analysis.core.ds.common.model.Product;
import com.design.analysis.core.ds.hashing.key2.node.HK2LLLNode;
import com.design.analysis.core.ds.hashing.key2.node.HK2LLNode;

/**@author @Gurug
 * Here Key1 and Key2 are Integer you may choose Object
 * start 2 key building key1 list , key2 link list and value also link list for
 * store product (LIST(key1)-LIST(key2)-LIST(value))
 **/
/** Scenario, product key will be up to x digit unique no **/
public class Hash2KeyLLLImpl implements IHash2KeyLLL<Integer, Integer, Product> {

	// public HK2LLLNode<Integer, Integer, Product> mainHead = null;

	/* add mass of element in single shot */
	@Override
	public HK2LLLNode<Integer, Integer, Product> addArray(HK2LLLNode<Integer, Integer, Product> mainHead,
			Integer key1[], Integer key2[], Product a[]) {

		/* Key1 nodes */
		HK2LLLNode<Integer, Integer, Product> upHead = null;
		HK2LLLNode<Integer, Integer, Product> headHead = null;
		/* Key2 nodes */
		HK2LLNode<Integer, Product> nextHead = null;
		HK2LLNode<Integer, Product> prev = null;

		/* value node */
		HLNode<Product> q = null;

		for (int i = 0; i < a.length; i++) {
			HLNode<Product> x = new HLNode<Product>(a[i]);

			// if no any node exists in bucket position
			if (mainHead == null) {
				mainHead = new HK2LLLNode<Integer, Integer, Product>(key1[i]);
				nextHead = new HK2LLNode<Integer, Product>(key2[i]);
				mainHead.next = nextHead;
				nextHead.up = x;
			} else {
				// go for search key2 if found traverse for value
				boolean foundKey1 = false;
				boolean foundKey2 = false;
				headHead = mainHead;
				// may be last down node have key

				upHead = headHead;
				while (headHead != null) {
					if (headHead.key1 == key1[i]) {
						foundKey1 = true;
						break;
					}
					upHead = headHead;
					headHead = headHead.dn;
				}

				if (foundKey1 || upHead.key1 == key1[i]) {

					HK2LLNode<Integer, Product> p = null;
					if (foundKey1)
						p = headHead.next;
					else
						p = upHead.next;

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
						// add the new key2 and value as well
						prev.next = new HK2LLNode<Integer, Product>(key2[i]);
						prev.next.up = x;
					}

				} else {// add the new down for key1 and add key2 and value as
					// well
					upHead.dn = new HK2LLLNode<Integer, Integer, Product>(key1[i]);
					nextHead = new HK2LLNode<Integer, Product>(key2[i]);
					upHead.dn.next = nextHead;
					nextHead.up = x;
				}
			}
		}
		return mainHead;
	}

	/* add an element or replace if existing */
	@Override
	public HK2LLLNode<Integer, Integer, Product> addElement(HK2LLLNode<Integer, Integer, Product> mainHead,
			Integer key1, Integer key2, Product x) {
		Integer newKey1[] = { key1 };
		Integer newKey2[] = { key2 };
		Product newProd[] = { x };

		return addArray(mainHead, newKey1, newKey2, newProd);
	}

	/* find an element */
	@Override
	public Product getElement(HK2LLLNode<Integer, Integer, Product> mainHead, Integer key1, Integer key2, Product x) {
		HK2LLLNode<Integer, Integer, Product> pHead = mainHead;
		HK2LLNode<Integer, Product> p = null;
		for (; pHead != null; pHead = pHead.dn) {
			for (p = pHead.next; p != null; p = p.next) {
				if (p.key2 == key2) {
					HLNode<Product> q = p.up;
					for (; q != null; q = q.next) {
						if (q.t.mno == x.mno)
							return q.t;
					}
				}
			}
		}
		return null;
	}

	/* delete an element */
	@Override
	public boolean deleteElement(HK2LLLNode<Integer, Integer, Product> mainHead, Product x) {

		int key1 = hashKey1(x);
		int key2 = hashKey2(x);

		/* key1 node */
		HK2LLLNode<Integer, Integer, Product> headHead = mainHead;
		/* Key2 nodes */
		HK2LLNode<Integer, Product> p = null;
		HLNode<Product> q = null;
		HLNode<Product> prev = null;

		for (; headHead != null; headHead = headHead.dn) {
			if (headHead.key1 == key1) { // key1 match
				for (p = headHead.next; p != null; p = p.next) {
					if (p.key2 == key2) { // key2 match
						q = p.up;
						prev = q;
						for (; q != null; prev = q, q = q.next) {
							if (q.t.mno == x.mno) {
								// if first element only
								if (q == prev && q.next == null)
									p.up = null;
								else
									prev.next = q.next;
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/* destroy cache */
	@Override
	public void destroyCache(HK2LLLNode<Integer, Integer, Product> mainHead) {
		mainHead = null;
		// TODO all node and pointer need to destroy or nullify
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
	@Override
	public void print(HK2LLLNode<Integer, Integer, Product> mainHead) {

		/* key1 node */
		HK2LLLNode<Integer, Integer, Product> headHead = mainHead;
		/* Key2 nodes */
		HK2LLNode<Integer, Product> nextHead = null;
		HLNode<Product> node = null;

		for (; headHead != null; headHead = headHead.dn) {
			for (nextHead = headHead.next; nextHead != null; nextHead = nextHead.next) {
				System.out.println("\n[key1,key2]: [" + headHead.key1 + "," + nextHead.key2 + "]->");
				for (node = nextHead.up; node != null; node = node.next)
					System.out.print(node.t.pName + "->");
			}
		}
	}
}
