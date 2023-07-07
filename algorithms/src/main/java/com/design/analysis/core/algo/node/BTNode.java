package com.design.analysis.core.algo.node;

public class BTNode {

	public String dt;
	public BTNode lt, rt;
	public int frq;

	public BTNode(int fre, String dt) {
		this.dt = dt;
		this.lt = this.rt = null;
		this.frq = fre;
	}

}
