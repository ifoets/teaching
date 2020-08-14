package com.design.analysis.ds.hashing.key2.building;

public interface IHash2KyeAAA<K1, K2, V> {

	/**
	 * start 2 key building key1 table index 1d, key2 in table index 2d and
	 * table index 3d for store value (ARRAY-ARRAY-ARRAY(value))
	 **/
	// **senario: +ve/-ve and product no end of 3 digit(999) unique digit**/
	/* add mass of element in single shot */
	public void addArray(K1 key1[], K2 key2[], V a[], Integer tableSize);

	/* add an element or replace if existing*/
	public void addElement(K1 key1, K2 key2, V x);

	/* find an element */
	public V getElement(K1 key1, K2 key2, boolean isSign);

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
