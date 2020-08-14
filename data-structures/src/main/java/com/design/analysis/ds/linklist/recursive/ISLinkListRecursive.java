package com.design.analysis.ds.linklist.recursive;

import com.design.analysis.ds.node.SLNode;

public interface ISLinkListRecursive {

	public SLNode create(SLNode node, int dt);

	public void display(SLNode node);

	public int length(SLNode node);

	public int sum(SLNode node);

	public void reversePrint(SLNode node);

	public int search(SLNode node, int key);

	public SLNode addRear(SLNode node, int key);

	public SLNode addAtPoistion(SLNode node, int key, int pos, int i);
}
