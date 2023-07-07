/**
 * 
 */
package com.design.analysis.core.ds.node;

/**
 * @author @Gurug
 *
 */
public class LruHashNode {

	public int hashSize;
	public LruQueNode[] lruQueNode;

	public LruHashNode(int hashSize) {
		this.hashSize = hashSize;
		lruQueNode = new LruQueNode[hashSize];
	}
}
