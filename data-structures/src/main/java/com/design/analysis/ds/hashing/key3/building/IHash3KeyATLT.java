package com.design.analysis.ds.hashing.key3.building;

public interface IHash3KeyATLT<K1, K2, K3, V> {

	/**
	 * start 3 key building key1 table index, key2 link list, key3 link list and
	 * link list for store value (ARRAY-LIST-LIST-LIST(value))
	 **/
	/* add mass of element in single shot */
	public void addArray(K1 key1[], K2 key2[], K3 key3[], V v[], Integer tableSize);

	/* add an element or replace if existing */
	public void addElement(K1 key1, K2 key2, K3 kye3, V x);

	/* find an element */
	public V getElement(K1 key1, K2 key2, K3 key3, V x);

	/* delete an element */
	public boolean deleteElement(V v);

	/* destroy cache */
	public void destroyCache();

	/* a way to find the key */
	public int hashKey1(V v);

	/* a way to find key2 */
	public int hashKey2(V v);
	
	/* a way to find key2 */
	public int hashKey3(V v);

	/* print all the element if found */
	public void print();
}
