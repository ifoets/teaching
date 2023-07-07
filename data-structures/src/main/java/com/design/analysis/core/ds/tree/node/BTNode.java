/**
 * 
 */
package com.design.analysis.core.ds.tree.node;

/**
 * @author @Gurug
 *
 */
public class BTNode<T> {

	public T t;
	public BTNode<T> lt, rt, pt, next, prev; // next point to successor/prdecessor of node
	public int h, ind;

	public BTNode(T t) {
		this.t = t;
		this.lt = this.rt = this.pt = this.next = this.prev = null;
		this.h = 0;
		this.ind = 0;
	}
}
