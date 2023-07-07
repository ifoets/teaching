/**
 * 
 */
package com.design.analysis.core.ds.queue;

import com.design.analysis.core.ds.node.QueueNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author @Gurug
 *
 */
public class IImplementationTest {

	public IImplementation iim = null;

	@Before
	public void init() {

		iim = new ImplementationImpl();
	}

	/* 1. Implement Queue using Stacks */
	@Test
	public void enQueueDeQuueUsingStackTest() {

		int a[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < a.length; i++) {
			iim.enQueue(a[i]);
		}
		Assert.assertTrue(iim.deQuue() == 1);
		Assert.assertTrue(iim.deQuue() == 2);
		Assert.assertTrue(iim.deQuue() == 3);
		Assert.assertTrue(iim.deQuue() == 4);
	}

	/** 3. Implement Stack using Queues **/
	@Test
	public void popPushUsingQueueTest() {

		int a[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < a.length; i++) {
			iim.push(a[i]);
		}
		Assert.assertTrue(iim.pop() == 5);
		Assert.assertTrue(iim.pop() == 4);
		Assert.assertTrue(iim.pop() == 3);
		Assert.assertTrue(iim.pop() == 2);
	}

	/* 4. Queue | Set 2 (Linked List Implementation) */
	@Test
	public void enQueueDeQuueUsingDLinkTest() {
		QueueNode queue = null;

		int a[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < a.length; i++) {
			queue = iim.enQueueDLink(queue, a[i]);
		}
		Assert.assertTrue(iim.deQuuevDLink(queue) == 1);
		Assert.assertTrue(iim.deQuuevDLink(queue) == 2);
		Assert.assertTrue(iim.deQuuevDLink(queue) == 3);
		Assert.assertTrue(iim.deQuuevDLink(queue) == 4);
		Assert.assertTrue(iim.deQuuevDLink(queue) == 5);
		Assert.assertTrue(iim.deQuuevDLink(queue) == null);
	}
}
