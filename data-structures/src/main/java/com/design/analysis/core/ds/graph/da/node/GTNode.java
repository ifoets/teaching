package com.design.analysis.core.ds.graph.da.node;

public class GTNode {
	public int v;// vertex
	public GTNode lt, rt;

	public GTNode(int v) {
		this.v = v;
		this.lt = this.rt = null;
	}
}
