package com.design.analysis.company.preparation.utils;

import java.util.Objects;

import com.design.analysis.company.preparation.model.LNode;

public class SListUtils {

	public static LNode tail;

	private SListUtils() {
	}

	/** creating the single link list */
	public static LNode createList(LNode h, int key[]) {
		tail = null;
		for (int i = 0; i < key.length; i++) {
			LNode newNode = new LNode(key[i], null);
			if (Objects.isNull(h))
				tail = h = newNode;
			else {
				tail.next = newNode;
				tail = tail.next;
			}
		}
		return h;
	}

	/** finding length of link list */
	public static int length(LNode h) {
		int count = 0;
		while (h != null) {
			h = h.next;
			count++;
		}
		return count;
	}

}
