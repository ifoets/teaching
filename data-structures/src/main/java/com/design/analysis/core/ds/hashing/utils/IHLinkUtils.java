package com.design.analysis.core.ds.hashing.utils;

import com.design.analysis.core.ds.hashing.key2.node.HK2LLNode;
import com.design.analysis.core.ds.hashing.node.HLNode;

public interface IHLinkUtils<K1, K2, K3, V> {

	/* it is used in operation on value node */
	public HLNode<V> addReplace(HLNode<V> head, V x);

	public HLNode<V> delete(HLNode<V> head, V x);

	public HLNode<V> searchNode(HLNode<V> head, V x);

	/* add/replace value in inner link list */
	public HK2LLNode<K2, V> addReplaceInnerNode(HK2LLNode<K2, V> head, K2 k, V x);

	/* returning the searching node in link */
	public HK2LLNode<K2, V> search(HK2LLNode<K2, V> head, K2 k);
}
