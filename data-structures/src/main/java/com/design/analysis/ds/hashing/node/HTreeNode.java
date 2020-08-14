package com.design.analysis.ds.hashing.node;

public class HTreeNode {

	public int dt;
	public HTreeNode lt, rt;
	public int index; // index lt is root-- and rt=root++
	public int hIndex; // height index root at 0 lt, rt=root+1

	public HTreeNode(int dt) {
		this.dt = dt;
		this.lt = this.rt = null;
		this.index = 0;
		this.hIndex = 0;
	}
}
