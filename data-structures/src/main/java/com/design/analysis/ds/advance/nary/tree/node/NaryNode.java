package com.design.analysis.ds.advance.nary.tree.node;

import java.util.ArrayList;
import java.util.List;

public class NaryNode<K> {
	public K k;
	public List<NaryNode<K>> list;

	public NaryNode(K k) {
		this.k = k;
		list = new ArrayList<NaryNode<K>>();
	}
}
