package com.design.analysis.core.ds.hashing.key2.node;

/**@author @Gurug 
 * this is first node where key1 store
 * Hash key1 and key2 type ..link to link to link**/
/**
 * it is used in two key hashing ... kye1, key2 and value all store in list
 * only. HK2LLLNode and value store in link list HLNode
 **/
public class HK2LLLNode<K1, K2, V> {

	public K1 key1; // K1 will be bued for link list
	public HK2LLLNode<K1, K2, V> dn;// down
	public HK2LLNode<K2, V> next;

	public HK2LLLNode(K1 key1) {
		this.key1 = key1;
		this.next = null;
		this.setNext(null);
	}

	public HK2LLNode<K2, V> getNext() {
		return next;
	}

	public void setNext(HK2LLNode<K2, V> next) {
		this.next = next;
	}
}
