/**
 * 
 */
package com.design.analysis.ds.linklist.node;

/**
 * @author @Gurug
 *
 */
public class DLNode<K> {

	public K k;
	public DLNode<K> next, prev;

	public DLNode(K k) {
		this.k = k;
		this.next = this.prev = null;
	}
}
