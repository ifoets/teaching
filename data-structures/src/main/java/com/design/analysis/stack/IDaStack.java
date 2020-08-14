package com.design.analysis.stack;

import com.design.analysis.ds.node.SLNode;

public interface IDaStack {

	/** basic operation on stack **/
	/* create stack for given array elements */
	public SLNode stack(int a[]);

	/* remove element from stack */
	public SLNode pop();

	/* retrieve element from stack */
	public SLNode pick();

	/* add element in stack */
	public SLNode push(int x);

	/* print stack */
	public void print(SLNode node);

	/* s */
	public void nullifyStack();
}
