package com.design.analysis.ds.link.bst;

import com.design.analysis.ds.tree.node.BTNode;
import com.design.analysis.ds.tree.node.LBTNode;

public interface ILinkBstTree<K, T> {

	/* operation on link having bst */
	/* create link  and inner bst  used by link */
	public LBTNode<K, T> addReplace(LBTNode<K, T> node, T t);

	/* search link node in inner link of bst */
	public BTNode<T> search(LBTNode<K, T> node, T t);

	/* delete link node in inner link of bst */
	public boolean delete(LBTNode<K, T> node, T t);

	/* print the bstNode and list inner to it */
	public void print(LBTNode<K, T> node);
}
