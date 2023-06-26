package com.design.analysis.ds.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.node.SLNode;

public class IDaStackTest {

	public IDaStack ist = null;

	@Before
	public void init() {
		ist = new DaStack();
	}

	/** basic operation on stack **/
	/* create stack for given array elements */
	@Test
	public void stackTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		SLNode head = ist.stack(a);
		Assert.assertTrue(head.dt == 1);
		Assert.assertTrue(head.next.dt == 2);
		Assert.assertTrue(head.next.next.next.dt == 4);
		// ist.print(head);
	}

	/* remove element from stack */
	@Test
	public void popTest() {

		ist.nullifyStack();
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		SLNode head = ist.stack(a);
		Assert.assertTrue(ist.pop().dt == 7);
		Assert.assertTrue(head.dt == 1);
		// ist.print(head);
	}

	/* retrieve element from stack */
	@Test
	public void pickTest() {
		ist.nullifyStack();
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		SLNode head = ist.stack(a);
		Assert.assertTrue(ist.pick().dt == 7);
		Assert.assertTrue(head.dt == 1);
		// ist.print(head);
	}

	/* add element in stack */
	@Test
	public void pushTest() {
		ist.nullifyStack();
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		SLNode head = ist.stack(a);
		Assert.assertTrue(ist.pop().dt == 7);
		Assert.assertTrue(head.dt == 1);
		head = ist.push(7);
		// ist.print(head);
	}

	/* print stack */
	@Test
	public void printTest() {
		ist.nullifyStack();
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		SLNode head = ist.stack(a);
		ist.print(head);
	}
}
