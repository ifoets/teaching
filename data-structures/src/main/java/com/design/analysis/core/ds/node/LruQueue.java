/**
 * 
 */
package com.design.analysis.core.ds.node;

/**
 * @author @Gurug
 *
 */
public class LruQueue {

	public int count;// filled frame
	public LruQueNode front, rear;
	public int noOfFrame;// total no of frame

	public LruQueue(int noOfFrame) {
		this.count = 0;
		this.noOfFrame = noOfFrame;
		this.front = this.rear = null;
	}
}
