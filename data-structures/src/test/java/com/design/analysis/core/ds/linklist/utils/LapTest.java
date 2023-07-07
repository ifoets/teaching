/**
 * 
 */
package com.design.analysis.core.ds.linklist.utils;

import com.design.analysis.core.ds.linklist.node.SLNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author @Gurug
 *
 */
public class LapTest {

	public Lap<SLNode<Integer>, SLNode<Integer>> lap = null;

	@Before
	public void init() {
		lap = new SLHashLap();
	}

	/* getHead() and getTail() here tested only */
	@Test
	public void putTest() {
		SLNode<Integer> head = new SLNode<Integer>(1);
		SLNode<Integer> tail = new SLNode<Integer>(2);
		lap.put(head, tail);

		Assert.assertTrue(lap.getHead().k == head.k);
		Assert.assertTrue(lap.getTail().k == tail.k);

		head = new SLNode<Integer>(3);
		tail = new SLNode<Integer>(4);

		lap.put(head, tail);

		Assert.assertTrue(lap.getHead().k == head.k);
		Assert.assertTrue(lap.getTail().k == tail.k);
	}
}
