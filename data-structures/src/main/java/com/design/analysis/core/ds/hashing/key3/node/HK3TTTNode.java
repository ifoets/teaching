/**
 * 
 */
package com.design.analysis.core.ds.hashing.key3.node;

import com.design.analysis.core.ds.hashing.key2.node.HK2TTNode;

/**
 * @author @Gurug it is used in three key hashing kye1 in table[] index, key2
 *         ,Key3 and value also in tree tree HK2TTNode and value store in tree
 *         HTNode also
 **/
public class HK3TTTNode<K2, K3, V> {

	public K2 k;
	public HK3TTTNode<K2, K3, V> lt, rt, pt;
	public HK2TTNode<K3, V> inY;

	public HK3TTTNode(K2 k) {
		this.k = k;
		this.lt = this.rt = this.pt = null;
		this.inY = null;
	}
}