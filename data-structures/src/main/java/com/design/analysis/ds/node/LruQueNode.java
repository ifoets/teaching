/**
 * 
 */
package com.design.analysis.ds.node;

/**
 * @author @Gurug
 *
 */
public class LruQueNode {
	public int pageNo;
	public LruQueNode next, prev;

	public LruQueNode(int pageNo) {
		this.pageNo = pageNo;
		this.next = this.prev = null;
	}
}
