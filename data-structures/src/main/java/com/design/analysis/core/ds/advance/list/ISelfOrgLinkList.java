package com.design.analysis.core.ds.advance.list;

import com.design.analysis.core.ds.linklist.node.SOrgNode;

public interface ISelfOrgLinkList<N> {

	/* creating list in mass */
	public SOrgNode<N> massCreate(N[] n);

	/* insert the node based on sorted frquency */
	public SOrgNode<Integer> insert(SOrgNode<N> n);

	/* creating list in single unit by unit */
	public SOrgNode<N> create(N n);

	/* frequency arrangement is done and return element of search */
	public SOrgNode<N> search(N n);

	/* delering the element */
	public SOrgNode<N> delete(N n);

	/* display the element */
	public void display(SOrgNode<N> n);

	public void display();
}
