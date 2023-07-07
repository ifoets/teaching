package com.design.analysis.core.ds.hashing.key2.node;

import com.design.analysis.core.ds.hashing.node.HLNode;

/**@author @Gurug**/
/** Hash key2 type ..tree to link list**/
/**
 * it is used in two key hashing kye1 in table[] index, key2 in tree HK2TLNode
 * and value store in link list HLNode
 **/
public class HK2TLNode<K2, V> {

	public K2 k;
	public HK2TLNode<K2, V> lt, rt, pt;
	public HLNode<V> next;

	public HK2TLNode(K2 k) {
		this.k = k;
		this.lt = this.rt = this.pt = null;
		this.next = null;
	}
}
