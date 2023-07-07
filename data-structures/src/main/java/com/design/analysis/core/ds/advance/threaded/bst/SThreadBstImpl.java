package com.design.analysis.core.ds.advance.threaded.bst;

import com.design.analysis.core.ds.node.STBstNode;

public class SThreadBstImpl implements ISThreadBst<Integer> {

	@Override
	public STBstNode<Integer> createSThreadBst(STBstNode<Integer> node, int dt) {

		if (node == null) {
			node = new STBstNode<>(dt);
			// node.lt = node.rt = node;
		} else {
			if (dt < node.dt) {
				node.lt = createSThreadBst(node.lt, dt);
				node.isThrd=false;
				if (node.lt.pt == null)
					node.lt.pt = node;
				if (node.lt.rt == null) {
					node.lt.rt = node;
					node.lt.isThrd = true;
				}
			} else {
				STBstNode<Integer> x = null;
				if (node.rt == node.pt) {
					x = node.rt;
					node.rt = null;
				}
				node.rt = createSThreadBst(node.rt, dt);
				node.isThrd=false;
				if (node.rt.pt == null)
					node.rt.pt = node;
				if (node.rt.rt == null) {
					node.rt.rt = x;
					node.rt.isThrd = true;
				}
			}
		}
		return node;
	}

	@Override
	public STBstNode<Integer> leftMostNode(STBstNode<Integer> node) {

		STBstNode<Integer> root = node;
		if (root == null)
			return null;
		while (node.lt != null)
			node = node.lt;
		return node;
	}

	@Override
	public STBstNode<Integer> rightMostNode(STBstNode<Integer> node) {
		if (node == null)
			return null;
		while (node.rt != null)
			node = node.rt;
		return node;
	}

	@Override
	public void display(STBstNode<Integer> node) {

		STBstNode<Integer> current = leftMostNode(node);
		// STBstNode<Integer> rightMostNode = rightMostNode(node);

		while (current.rt != null) {
			System.out.print(current.dt + "->");

			if (current.isThrd)
				current = current.rt;
			else
				current = leftMostNode(current.rt);
		}

	}

}
