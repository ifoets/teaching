package com.design.analysis.ds.advance.list.node;

public class ExpWayNode<K> {

	public K k;
	public HiWayNode<K> dn;// down
	public ExpWayNode<K> next;

	public ExpWayNode(K k) {
		this.k = k;
		this.dn = null;
		this.next = null;
	}
}
