/**
 * 
 */
package com.design.analysis.core.ds.hashing.key2.building;

/**
 * @author @Gurug
 *
 * Here Key1 and Key2 are Integer you may choose Object
 * start 2 key building key1 list , key2 link list and value store in tree
 * store product (Array(key1)-LIST(key2)-Tree(value))
 **/
/** Scenario, product key will be up to x digit unique no **/

public interface IHash2KeyALT<K1, K2, V> {

	/* add mass of element in single shot */
	public void addArray(K1 key1[], K2 key2[], V a[], Integer tableSize);

	/* add an element or replace if existing */
	public void addElement(K1 key1, K2 key2, V x);

	/* find an element */
	public V getElement(K1 key1, K2 key2, V x);

	/* delete an element */
	public boolean deleteElement(V x);

	/* destroy cache */
	public void destroyCache();

	/* a way to find the key */
	public int hashKey1(V x);

	/* a way to find key2 */
	public int hashKey2(V x);

	/* print all the element if found */
	public void print();
}
