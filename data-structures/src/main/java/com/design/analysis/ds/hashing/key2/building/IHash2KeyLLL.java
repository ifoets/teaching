package com.design.analysis.ds.hashing.key2.building;

import com.design.analysis.ds.hashing.key2.node.HK2LLLNode;

/**@author @Gurug
 * start 2 key building key1 list , key2 link list and value also link list for
 * store value (LIST(key1)-LIST(key2)-LIST(value))
 **/
/** Scenario, product key will be up to x digit unique no **/
public interface IHash2KeyLLL<K1, K2, V> {

	/* add mass of element in single shot */
	public HK2LLLNode<K1, K2, V> addArray(HK2LLLNode<K1, K2, V> mainHead, K1 key1[], K2 key2[], V a[]);

	/* add an element or replace if existing */
	public HK2LLLNode<K1, K2, V> addElement(HK2LLLNode<K1, K2, V> mainHead,K1 key1, K2 key2, V x);

	/* find an element */
	public V getElement(HK2LLLNode<K1, K2, V> mainHead, K1 key1, K2 key2, V x);

	/* delete an element */
	public boolean deleteElement(HK2LLLNode<K1, K2, V> mainHead, V x);

	/* destroy cache */
	public void destroyCache(HK2LLLNode<K1, K2, V> mainHead);

	/* a way to find the key */
	public int hashKey1(V x);

	/* a way to find key2 */
	public int hashKey2(V x);

	/* print all the element if found */
	public void print(HK2LLLNode<K1, K2, V> mainHead);
}
