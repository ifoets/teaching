package com.design.analysis.core.ds.advance.list;

import com.design.analysis.core.ds.advance.list.node.UnrollListNode;

public interface IUnrollList<U> {

	public UnrollListNode<U> createInMass(U[] ul);

	public UnrollListNode<U> createInUnit(U u);

	public U search(UnrollListNode<U> uHead, U u);

	public boolean delete(UnrollListNode<U> head, U u);

	public void display(UnrollListNode<U> head);

	public void dispaly();

}
