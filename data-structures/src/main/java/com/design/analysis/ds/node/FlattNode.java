package com.design.analysis.ds.node;

public class FlattNode {
	public Integer dt;
	public FlattNode next, prev, up, down;

	public FlattNode(Integer dt) {
		super();
		this.dt = dt;
		this.next = this.prev = this.up = this.down = null;
	}

	// initialize up to 9 didit
	public FlattNode() {
		FlattNode head = null;
		FlattNode tail = null;
		for (int i = 0; i < 9; i++) {
			FlattNode temp = new FlattNode(null);
			if (head == null) {
				head = tail = temp;
			} else {
				tail.next = temp;
				temp.prev = tail;
				tail = tail.next;
			}
			head.prev = tail;
			tail.next = prev;
		}
	}
}
