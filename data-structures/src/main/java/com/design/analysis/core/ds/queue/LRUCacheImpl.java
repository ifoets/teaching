/**
 * 
 */
package com.design.analysis.core.ds.queue;

import com.design.analysis.core.ds.node.LruHashNode;
import com.design.analysis.core.ds.node.LruQueNode;
import com.design.analysis.core.ds.node.LruQueue;

/**
 * @author @Gurug
 *
 */
public class LRUCacheImpl implements ILRUCache {

	public LruQueue que = null;
	public LruHashNode hash = null;

	@Override
	public LruQueue createQueue(int noOfFrame) {

		if (que == null)
			que = new LruQueue(noOfFrame);
		return que;
	}

	@Override
	public LruHashNode createHash(int hashSize) {

		if (hash == null)
			hash = new LruHashNode(hashSize);
		for (int i = 0; i < hashSize; i++)
			hash.lruQueNode[i] = null;
		return hash;
	}

	@Override
	public void referencePag(LruQueue que, LruHashNode hash, int pageNo) {
		LruQueNode reqPage = hash.lruQueNode[pageNo];

		if (reqPage == null)
			enQueue(que, hash, pageNo);

		else if (reqPage != null) {
			// need to delete the existing node of pageNo and add to front
			if (reqPage == que.rear)
				deQueue(que);
			else {
				reqPage.prev.next = reqPage.next;
				if (reqPage.next != null) {
					reqPage.next.prev = reqPage.prev;
				}
			}
			reqPage.next = que.front;
			que.front.prev = reqPage;
			reqPage.prev = null;
			que.front = reqPage;
		}

	}

	@Override
	public void enQueue(LruQueue que, LruHashNode hash, int pageNo) {
		if (isQueueFull(que)) {
			hash.lruQueNode[que.rear.pageNo] = null;
			deQueue(que);
		}

		LruQueNode temp = new LruQueNode(pageNo);
		temp.next = que.front;

		if (isQueueEmpty(que)) {
			que.front = que.rear = temp;
		} else {
			que.front.prev = temp;
			que.front = temp;
		}
		// Add page entry to hash also
		hash.lruQueNode[pageNo] = temp;

		// increment number of full frames
		que.count++;
	}

	@Override
	public void deQueue(LruQueue que) {
		if (isQueueEmpty(que))
			return;

		// If this is the only node in list, then change front
		if (que.front == que.rear)
			que.front = null;

		// Change rear and remove the previous rear
		LruQueNode temp = que.rear;
		que.rear = que.rear.prev;

		if (que.rear != null)
			que.rear.next = null;
		temp.prev = null;

		temp = null;

		// decrement the number of full frames by 1
		que.count--;
	}

	@Override
	public boolean isQueueFull(LruQueue que) {
		return que.count == que.noOfFrame;
	}

	@Override
	public boolean isQueueEmpty(LruQueue que) {
		return que.rear == null;
	}

}
