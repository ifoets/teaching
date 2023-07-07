package com.design.analysis.core.ds.link.bst;

import com.design.analysis.core.ds.tree.node.BTNode;
import com.design.analysis.core.ds.tree.node.LBTNode;
import com.design.analysis.core.ds.bst.utils.BTUtils;
import com.design.analysis.core.ds.bst.utils.IBTUtils;
import com.design.analysis.core.ds.common.model.Product;

public class LinkBsTreeImpl implements ILinkBstTree<Integer, Product> {

	public IBTUtils<Product> ibtul = new BTUtils();

	@Override
	public LBTNode<Integer, Product> addReplace(LBTNode<Integer, Product> node, Product t) {

		if (node == null) {
			node = new LBTNode<Integer, Product>(t.pTypeId);
			node.down = ibtul.createReplace(node.down, t);
		} else {
			LBTNode<Integer, Product> p = node;
			LBTNode<Integer, Product> prev = node;
			for (; p != null; prev = p, p = p.next) {
				if (p.k == t.pTypeId) {
					p.down = ibtul.createReplace(p.down, t);
					break;
				}
			}
			if (p == null) {
				prev.next = new LBTNode<Integer, Product>(t.pTypeId);
				prev.next.down = ibtul.createReplace(prev.next.down, t);
			}
		}
		return node;
	}

	@Override
	public BTNode<Product> search(LBTNode<Integer, Product> node, Product t) {

		LBTNode<Integer, Product> p = node;

		for (; p != null; p = p.next) {
			if (p.k == t.pTypeId) {
				return ibtul.search(p.down, t);
			}
		}
		return null;
	}

	@Override
	public boolean delete(LBTNode<Integer, Product> node, Product t) {
		LBTNode<Integer, Product> p = node;

		for (; p != null; p = p.next) {
			if (p.k == t.pTypeId) {
				if (ibtul.search(p.down, t) != null) {
					ibtul.delete(p.down, t);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void print(LBTNode<Integer, Product> node) {
		LBTNode<Integer, Product> p = node;

		for (; p != null; p = p.next) {
			System.out.println("LinkNod[pTypeId:-" + p.k + "]");
			ibtul.inorderPrint(p.down);
		}
	}
}
