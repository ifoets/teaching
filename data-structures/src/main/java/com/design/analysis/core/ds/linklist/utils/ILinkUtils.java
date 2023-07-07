package com.design.analysis.core.ds.linklist.utils;

import com.design.analysis.core.ds.linklist.node.SLNode;

public interface ILinkUtils<V> {

	/* it is used in operation on value node ie. on SLode<V> */
	public SLNode<V> addReplace(SLNode<V> head, V x);

	public SLNode<V> delete(SLNode<V> head, V x);

	public SLNode<V> searchNode(SLNode<V> head, V x);

	public void display(SLNode<V> v);

	/* end of SLNode operation */
}
