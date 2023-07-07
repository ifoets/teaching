/**
 * 
 */
package com.design.analysis.core.ds.linklist.utils;

/**
 * @author @Gurug
 *
 */
public interface Lap<K, V> {

	public K getHead();

	public V getTail();

	public void put(K k, V v);
}
