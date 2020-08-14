package com.design.analysis.ds.advance.nary.tree;

import com.design.analysis.ds.advance.nary.tree.node.NaryNode;

public class NaryTreeImpl implements INaryTree<Integer> {

	@Override
	public NaryNode<Integer> create(NaryNode<Integer> node, Integer p, Integer k) {

		if (node == null && p == null)
			node = new NaryNode<Integer>(k);
		else {

			if (node.list.size() == 0) {
				node.list.add(new NaryNode<Integer>(p));
				node.list.get(0).list.add(new NaryNode<Integer>(k));
			} else {
				boolean found = false;
				for (NaryNode<Integer> q : node.list) {
					if (q.k.equals(p)) {
						q.list.add(new NaryNode<Integer>(k));
						found = true;
					}
					if (!found) {
						node.list.add(new NaryNode<Integer>(p));
						node.list.get(0).list.add(new NaryNode<Integer>(k));
					}
				}
			}

		}
		return node;
	}

	@Override
	public void display(NaryNode<Integer> node) {

	}

	@Override
	public boolean search(NaryNode<Integer> node, Integer p, Integer k) {
		return true;
	}

	public boolean isUnival(NaryNode<Integer> node) {
		return true;
	}
}
