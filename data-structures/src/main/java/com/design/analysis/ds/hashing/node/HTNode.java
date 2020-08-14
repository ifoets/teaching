package com.design.analysis.ds.hashing.node;

/** @author @Gurug **/
/*
 * This is value node pass any objeect by need to implements Comparable since
 * during create of tree need to compare add at right or left
 */
public class HTNode<K> {

	public K k; // generic value
	public HTNode<K> lt, rt, pt;

	public HTNode(K k) {
		this.k = k;
		this.lt = this.rt = this.pt = null;
	}
}
