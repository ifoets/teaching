package com.design.analysis.ds.hashing.key2.node;

import com.design.analysis.ds.hashing.node.HTNode;

/**@author 
 * Hash key1 and key2 type ..link list to tree **/
/**
 * it is used in two key hashing kye1 in table[] index, key2 in link list
 * HK2LTNode and value store in tree HTNode
 **/
public class HK2LTNode<K2, V> {

	public K2 key2; // key1 will be the table index
	public HK2LTNode<K2, V> next;
	public HTNode<V> up;

	public HK2LTNode(K2 key2) {
		this.key2 = key2;
		this.next = null;
		this.up = null;
	}
}
