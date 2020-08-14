package com.design.analysis.ds.design.pattern.creation;

import com.design.analysis.ds.design.pattern.node.TPoolNode;
import com.design.analysis.ds.design.pattern.template.Human;

public class ImmutableObjPoolImpl implements IImmutableObjPool<Human> {

	public TPoolNode<Human> tp[] = null;
	public int N = 0;

	/** creating hashtable for pooling **/
	@SuppressWarnings("unchecked")
	@Override
	public TPoolNode<Human>[] cretePool(int size) {
		tp = new TPoolNode[size];
		N = size;
		return tp;
	}

	/** linking datastructue is tree for searching fast **/
	@Override
	public TPoolNode<Human> createTree(TPoolNode<Human> node, Human h) {

		if (node == null)
			node = new TPoolNode<Human>(h);
		else if (h.getName().compareTo(node.i.getName()) < 0)
			node.lt = createTree(node.lt, h);
		else
			node.rt = createTree(node.rt, h);
		return node;
	}

	/** search in tree to stop duplicate creation of node **/
	@Override
	public TPoolNode<Human> searchInTree(TPoolNode<Human> node, Human h) {

		if (node != null) {
			if (node.i.equals(h))
				return node;
			else if (h.getName().compareTo(node.i.getName()) < 0)
				return searchInTree(node.lt, h);
			else
				return searchInTree(node.rt, h);
		}
		return null;
	}

	/** searching object in pool before adding new one in pool **/
	@Override
	public TPoolNode<Human> serchObjInPool(Human h) {

		int hc = h.hashCode();
		if (tp == null)
			return null;
		TPoolNode<Human> head = tp[hc % N];
		if (head != null)
			return searchInTree(head, h);
		return null;
	}

	/** adding object to pool **/
	@Override
	public boolean addObjInPool(Human h) {
		int hc = h.hashCode();
		if (tp == null)
			return false;
		TPoolNode<Human> head = tp[hc % N];
		if (head == null) {
			tp[hc % N] = createTree(head, h);
			return true;
		} else if (searchInTree(head, h) == null) {
			tp[hc % N] = createTree(head, h);
			return true;
		}
		return false;
	}

	/** finding object in pool **/
	@Override
	public TPoolNode<Human> getObjFromPool(Human h) {
		return serchObjInPool(h);
	}

	/** print tree in inorder **/
	@Override
	public void printInorderTree(TPoolNode<Human> node) {

		if (node != null) {
			printInorderTree(node.lt);
			System.out.print(node.i.toString());
			printInorderTree(node.rt);
		}
	}

	/** print the pool **/
	@Override
	public void printPool() {

		for (int i = 0; i < tp.length; i++) {
			if (tp[i] != null)
				printInorderTree(tp[i]);
			System.out.println();
		}
	}
}
