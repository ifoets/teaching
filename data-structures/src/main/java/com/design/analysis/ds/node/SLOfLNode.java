package com.design.analysis.ds.node;

/*
 * 1 digit store in first list,2nd in 2nd list and so on
 * here searching will be fast and complexity in operation
 */
public class SLOfLNode {

	public SLNode inNext;
	public SLOfLNode outNext;

	public SLOfLNode() {
		super();
		this.inNext = null;
		this.outNext = null;
	}
}
