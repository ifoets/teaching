package com.design.analysis.core.ds.advance.list.node;

import com.design.analysis.core.ds.common.model.Product;

public class UnrollListNode<U> {
	public int uType;
	public Product[] u;
	public UnrollListNode<U> next;

	
	
	public UnrollListNode(int uType) {
		this.uType = uType;
		this.u = new Product[5];
		this.next = null;
	}
}
