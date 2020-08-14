package com.design.analysis.ds.bst.link;

import com.design.analysis.ds.common.model.Product;
import com.design.analysis.ds.linklist.node.SLNode;
import com.design.analysis.ds.linklist.utils.ILinkUtils;
import com.design.analysis.ds.linklist.utils.LinkUtils;
import com.design.analysis.ds.tree.node.BTLNode;

public class BstLinkImpl implements IBstLink<Integer, Product> {

	public ILinkUtils<Product> ilu = new LinkUtils<>();

	/* operation on binary search tree link */
	/* create bst and inner link list used by bst */
	public BTLNode<Integer, Product> create(BTLNode<Integer, Product> node, Integer dt, Product p) {

		if (node == null) {
			node = new BTLNode<>(dt);
			node.next = ilu.addReplace(node.next, p);
		} else if (dt == node.k) {
			node.next = ilu.addReplace(node.next, p);
		} else if (dt < node.k) {
			node.lt = create(node.lt, dt, p);
			if (node.lt.pt == null) {
				node.lt.pt = node;
			}
		} else {
			node.rt = create(node.rt, dt, p);
			if (node.rt.pt == null) {
				node.rt.pt = node;
			}
		}
		return node;
	}

	/* search link node in inner link of bst */
	public SLNode<Product> search(BTLNode<Integer, Product> node, Integer k, Product p) {

		if (node != null) {
			if (node.k == k) {
				return ilu.searchNode(node.next, p);
			} else if (node.k < k) {
				return search(node.rt, k, p);
			} else {
				return search(node.lt, k, p);
			}
		}
		return null;
	}

	/* delete link node in inner link of bst */
	public boolean delete(BTLNode<Integer, Product> node, Integer k, Product p) {

		if (node != null) {
			if (node.k == k) {
				if (ilu.searchNode(node.next, p) != null) {
					node.next = ilu.delete(node.next, p);
					return true;
				}
				return false;

			} else if (node.k < k) {
				return delete(node.rt, k, p);
			} else {
				return delete(node.lt, k, p);
			}
		}
		return false;
	}

	/* print the bstNode and list inner to it */
	public void inorderBstLink(BTLNode<Integer, Product> node) {

		if (node != null) {
			inorderBstLink(node.lt);
			SLNode<Product> head = node.next;
			System.out.println("\nTreeNode[" + node.k + "]");
			for (; head != null; head = head.next)
				System.out.print(head.k.toStringforTreeLink());
			inorderBstLink(node.rt);
		}
	}
}
