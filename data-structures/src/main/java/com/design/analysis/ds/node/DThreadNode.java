package com.design.analysis.ds.node;

public class DThreadNode {

	public int dt;
	public DThreadNode lt, rt, pt, ltd, rtd;

	public DThreadNode(int dt) {
		super();
		this.dt = dt;
		this.lt = null;
		this.rt = null;
		this.pt = null;
		this.ltd = null;
		this.rtd = null;
	}
}
