package com.design.analysis.core.ds.node;

public class AVLTNode {

	public int dt;
	public int height;
	public AVLTNode lt, rt, pt;// left, right and parent pointer

	public AVLTNode(int dt) {
		super();
		this.dt = dt;
		this.height = 1;
		this.lt = this.rt = this.pt = null;
	}
}
