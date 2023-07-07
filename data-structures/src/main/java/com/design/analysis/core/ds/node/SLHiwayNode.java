package com.design.analysis.core.ds.node;

//it can be used in express sway or any other fast way 
public class SLHiwayNode {

	public int dt;
	public SLHiwayNode next;
	public SLNode down;

	public SLHiwayNode(int dt) {
		super();
		this.dt = dt;
		this.next = null;
		this.down = null;
	}

}
