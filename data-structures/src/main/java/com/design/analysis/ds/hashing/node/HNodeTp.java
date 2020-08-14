package com.design.analysis.ds.hashing.node;
/*hashing node Tree type probing*/
public class HNodeTp {

	public int dt;
	public HNodeTp lt, rt, pt;

	public HNodeTp(int dt) {
		this.dt = dt;
		this.lt = this.rt = this.pt = null;
	}
}
