package com.design.analysis.core.ds.hashing.key2.node;

import com.design.analysis.core.ds.hashing.node.HLNode;

/**@author @Gurug
 * Hash key1 and key2 type ..link list to link list **/
/**
 * it is used in two key hashing ... kye1 in table[] index, key2 in link list
 * HK2LLNode and value store in link list HLNode
 **/
public class HK2LLNode<K2, V> {

	public K2 key2; // K1 will be the table index
	public HK2LLNode<K2, V> next;
	public HLNode<V> up;

	public HK2LLNode(K2 key2) {
		this.key2 = key2;
		this.next = null;
		this.up = null;
	}
}
