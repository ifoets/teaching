package com.design.analysis.core.ds.tree.node;

import com.design.analysis.core.ds.linklist.node.SLNode;

/*this node is used for tree that link to list*/
public class BTLNode<K, V> {

	public K k;
	public BTLNode<K, V> lt, rt, pt;
	public SLNode<V> next;

	public BTLNode(K k) {
		this.k = k;
		this.lt = this.rt = this.pt = null;
		this.next = null;
	}

}
