/**
 * 
 */
package com.design.analysis.ds.hashing.key3.node;

import com.design.analysis.ds.hashing.key2.node.HK2LTNode;

/**
 * @author @Gurug it is used in three key hashing kye1 in table[] index, key2
 *         ,Key3 and value also in tree tree HK2TTNode and value store in tree
 *         HTNode also
 **/
public class HK3TLTNode<K2, K3, V> {

	public K2 k;
	public HK3TLTNode<K2, K3, V> lt, rt, pt;
	public HK2LTNode<K3, V> next;

	public HK3TLTNode(K2 k) {
		this.k = k;
		this.lt = this.rt = this.pt = null;
		this.next = null;
	}
}