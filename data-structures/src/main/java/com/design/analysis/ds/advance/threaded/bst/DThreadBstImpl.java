package com.design.analysis.ds.advance.threaded.bst;

import com.design.analysis.ds.node.DThreadNode;

public class DThreadBstImpl implements IDThreadBst {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public DThreadNode create(DThreadNode node, int dt) {

		if (node == null)
			node = new DThreadNode(dt);
		else {
			if (dt <= node.dt) {
				node.lt = create(node.lt, dt);
				node.lt.pt = node;
			} else {
				node.rt = create(node.rt, dt);
				node.rt.pt = node;
			}
		}
		return node;
	}

	@Override
	public DThreadNode successor(DThreadNode node, int dt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DThreadNode predecessor(DThreadNode node, int dt) {
		// TODO Auto-generated method stub
		return null;
	}

}
