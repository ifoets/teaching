package com.design.analysis.ds.design.pattern.creation;

import com.design.analysis.ds.design.pattern.node.TPoolNode;
import com.design.analysis.ds.design.pattern.template.Human;

/*
 * 
 * @author GuruG
 * This is used for creating our own pool of immutable object just like String constant pool
 */
public interface IImmutableObjPool<I> {

	/** creating hashtable for pooling **/
	public TPoolNode<Human>[] cretePool(int size);

	/** linking datastructue is tree for searching fast **/
	public TPoolNode<I> createTree(TPoolNode<I> node, I i);

	/** search in tree to stop duplicate creation of node **/
	public TPoolNode<I> searchInTree(TPoolNode<I> node, I i);

	/** searching object in pool before adding new one in pool **/
	public TPoolNode<I> serchObjInPool(I i);

	/** adding object to pool **/
	public boolean addObjInPool(I i);

	/** finding object in pool **/
	public TPoolNode<I> getObjFromPool(I i);

	/** print tree in inorder **/
	public void printInorderTree(TPoolNode<I> i);

	/** print the pool **/
	public void printPool();
}
