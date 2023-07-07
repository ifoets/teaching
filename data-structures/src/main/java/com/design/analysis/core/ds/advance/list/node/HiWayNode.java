package com.design.analysis.core.ds.advance.list.node;

import com.design.analysis.core.ds.linklist.node.SLNode;

public class HiWayNode<K> {

	public K k;
	public SLNode<K> dn;// down
	public HiWayNode<K> next;

	public HiWayNode(K k) {
		this.k = k;
		this.dn = null;
		this.next = null;
	}
}
