/**
 * 
 */
package com.design.analysis.ds.queue;

import com.design.analysis.ds.node.LruHashNode;
import com.design.analysis.ds.node.LruQueue;

/**
 * @author @Gurug
 *
 */
public interface ILRUCache {

	public LruQueue createQueue(int noOfFrame);

	public LruHashNode createHash(int hashSize);

	public void referencePag(LruQueue que, LruHashNode hash, int pageNo);

	public void enQueue(LruQueue que, LruHashNode hash, int pageNo);

	public void deQueue(LruQueue que);

	public boolean isQueueFull(LruQueue que);

	public boolean isQueueEmpty(LruQueue que);
}
