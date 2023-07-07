package com.design.analysis.core.ds.common;

import com.design.analysis.core.ds.node.BTNode;

public class TreeNodeLinkList {
	public Integer index;
	public BTNode next;
	public TreeNodeLinkList down;

	public TreeNodeLinkList() {
		super();
		this.index = null;
		this.next = null;
		this.down = null;
	}

}
