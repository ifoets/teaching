package com.design.analysis.ds.bst.utils;

import com.design.analysis.ds.tree.node.BTNode;

/*this is utility class of tree used by Link-tree combination*/
public interface IBTUtils<T> {
	/* tree operation that will be used by other package/class */

	/* add or replace the node */
	public BTNode<T> createReplace(BTNode<T> node, T t);

	/* search the node */
	public BTNode<T> search(BTNode<T> node, T t);

	/* delete the node and return the root */
	public BTNode<T> delete(BTNode<T> node, T t);

	/* inorder print */
	public void inorderPrint(BTNode<T> node);

	/* convert bst to list utility */
	public BTNode<T> bstToListUtils(BTNode<T> t);
}
