package com.design.analysis.core.ds.node;

public class SplayTNode {

	public int dt;
	public SplayTNode rt, lt;

	public SplayTNode(int dt) {
		super();
		this.dt = dt;
		this.lt = this.rt = null;
	}

}
