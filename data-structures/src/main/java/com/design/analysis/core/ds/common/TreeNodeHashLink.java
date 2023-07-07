package com.design.analysis.core.ds.common;

public class TreeNodeHashLink {

	int size;
	public TreeNodeLinkList[] head;
	public TreeNodeLinkList linkHead;

	public TreeNodeHashLink(int size) {
		super();
		this.size = size;
		head = new TreeNodeLinkList[size];
		for (int i = 0; i < size; i++) {
			head[i] = new TreeNodeLinkList();
			head[i].index = null;
			if (i != 0) {
				head[i - 1].down = head[i];
			}
		}
	}

	public TreeNodeHashLink(int size, TreeNodeLinkList linkHead) {
		super();
		this.size = size;
		linkHead = null;
		for (int i = 0; i < size; i++) {
			if (linkHead == null) {
				linkHead = new TreeNodeLinkList();
				this.linkHead = linkHead;
			} else {
				TreeNodeLinkList temp = this.linkHead;
				while (temp.down != null)
					temp = temp.down;
				temp.down = linkHead;
			}
		}
	}
}
