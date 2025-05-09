package com.design.analysis.core.ds.bst.link;

/*a tree having link list where actual data store*/
import com.design.analysis.core.ds.tree.node.BTLNode;
import com.design.analysis.core.ds.linklist.node.SLNode;

public interface IBstLink<K, V> {

	/* operation on binary search tree link */
	/* create bst and inner link list used by bst */
	public BTLNode<K, V> create(BTLNode<K, V> node, K k, V v);

	/* search link node in inner link of bst */
	public SLNode<V> search(BTLNode<K, V> node, K k, V v);

	/* delete link node in inner link of bst */
	public boolean delete(BTLNode<K, V> node, K k, V v);

	/*print the bstNode and list inner to it*/
	public void inorderBstLink(BTLNode<K, V> node);
}
