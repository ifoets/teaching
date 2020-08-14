package com.design.analysis.ds.advance.nary.tree;

import com.design.analysis.ds.advance.nary.tree.node.NaryNode;

public interface INaryTree<K> {

	public NaryNode<K> create(NaryNode<K> node, K p, K k);

	public void display(NaryNode<K> node);

	public boolean search(NaryNode<K> node, K p, K k);

	public boolean isUnival(NaryNode<K> node);
}
