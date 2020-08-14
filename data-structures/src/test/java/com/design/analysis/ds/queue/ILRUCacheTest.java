/**
 * 
 */
package com.design.analysis.ds.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.node.LruHashNode;
import com.design.analysis.ds.node.LruQueue;

/**
 * @author @Gurug
 *
 */
public class ILRUCacheTest {

	public ILRUCache ilruc = null;

	@Before
	public void init() {
		ilruc = new LRUCacheImpl();
	}

	/* testing all method in single short */
	@Test
	public void iLRUCacheTest() {

		LruQueue que = ilruc.createQueue(4);
		LruHashNode hash = ilruc.createHash(10);
		ilruc.referencePag(que, hash, 8);
		Assert.assertTrue(que.front.pageNo == 8);
		Assert.assertTrue(que.rear.pageNo == 8);
		ilruc.referencePag(que, hash, 1);
		Assert.assertTrue(que.front.pageNo == 1);
		Assert.assertTrue(que.rear.pageNo == 8);
		ilruc.referencePag(que, hash, 2);
		Assert.assertTrue(que.front.pageNo == 2);
		Assert.assertTrue(que.rear.pageNo == 8);
		ilruc.referencePag(que, hash, 3);
		Assert.assertTrue(que.front.pageNo == 3);
		Assert.assertTrue(que.rear.pageNo == 8);
		ilruc.referencePag(que, hash, 1);
		Assert.assertTrue(que.front.pageNo == 1);
		Assert.assertTrue(que.rear.pageNo == 8);
		ilruc.referencePag(que, hash, 4);
		Assert.assertTrue(que.front.pageNo == 4);
		Assert.assertTrue(que.rear.pageNo == 2);
		ilruc.referencePag(que, hash, 5);
		Assert.assertTrue(que.front.pageNo == 5);
		Assert.assertTrue(que.rear.pageNo == 3);
		Assert.assertTrue(que.front.pageNo == 5);
		Assert.assertTrue(que.front.next.pageNo == 4);
		Assert.assertTrue(que.front.next.next.pageNo == 1);
		Assert.assertTrue(que.front.next.next.next.pageNo == 3);
	}

}
