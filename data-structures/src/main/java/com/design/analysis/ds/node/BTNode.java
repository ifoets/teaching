package com.design.analysis.ds.node;

/*
 * lt left pointer
 * rt right pointer,
 * lht left threaded pointer
 * rht right threaded pointer
 * next point to brother
 * pt point to parent
 * xd x direction pointer
 * rxd reverse x direction pointer
 * yd y direction pointer
 * ryd reverse y direction pointer
 * zd z direction pointer
 * rzd reversez direction pointer
 * simillar way
 * xy rxy,
 * yz ryz
 * zx and rzx
 */
public class BTNode implements Comparable<BTNode> {

	public int dt;
	public int ind;// index find the level of node
	public boolean color; // used for red-blac tree, false:black and true:red
	public BTNode lt, rt, pt, lht, rht, next;
	public int ht;// height of node
	public int count;//duplicate value
	// you should only need pointer since it also west of memory
	// this is used for three 6 dimension tree
	// public BTNode xd, yd, zd, rxd, ryd, rzd, xy, yz, zx, rxy, ryz, rzy;

	public BTNode(int dt) {
		super();
		this.dt = dt;
		ind = 0;
		this.lht = this.rht = this.next = this.pt = this.lt = this.rt = null;
		this.ht = 1;
	}

	@Override
	public String toString() {
		return "BTNode [dt=" + dt + ", ind=" + ind + "]";
	}

	@Override
	public int compareTo(BTNode o) {
		return this.ind-o.ind;
	}
	
	
}
