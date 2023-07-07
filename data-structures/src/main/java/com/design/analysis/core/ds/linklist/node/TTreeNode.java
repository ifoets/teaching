package com.design.analysis.core.ds.linklist.node;

/*
 * 
 * @author GuruG
 * TernaryTreeNode
 */
public class TTreeNode<K> {

	public int dt;
	public TTreeNode<K> lt, rt, md;// left, right and middle pointer

	public TTreeNode(int dt) {
		this.dt = dt;
		this.lt = this.rt = this.md = null;
	}
}
