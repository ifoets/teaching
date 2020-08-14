

package com.design.analysis.ds.hashing;
import com.design.analysis.ds.common.Hash;
import com.design.analysis.ds.node.HashNode;

public class HashAdjListImpl implements IHashAdjList {

	@Override
	public void addHashNode(Hash h, String value) {

		int key = getKey(value);
		HashNode node = new HashNode(key, value);

		int loc = hashCode(h.size, value) % h.size;

		// if no node has been added to src
		if (h.array[loc].head == null) {
			h.array[loc].head = node;
		} else {
			// travel to last of the list
			HashNode srcHead = h.array[loc].head;
			while (srcHead.next != null) {

				// replace the old value by new
				if (srcHead.key == key && equals(srcHead.value, value)) {
					srcHead.value = value;
					break;
				}
				srcHead = srcHead.next;
			}
			// add as last node
			srcHead.next = node;
		}
	}

	@Override
	public boolean equals(String used, String exists) {

		if (used.length() != exists.length())
			return false;
		else {

			for (int i = 0; i <= used.length() / 2; i++) {
				if ((used.charAt(i) != exists.charAt(i))
						|| (used.charAt(used.length() - 1 - i) != exists.charAt(used.length() - 1 - i)))
					return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(int size, String value) {
		int hashCode = 0;

		if (value.length() >= 10)
			for (Character ch : value.toCharArray())
				hashCode += (int) ch;
		
		return hashCode;
	}

	@Override
	public int getKey(String value) {
		int hashCode = 0;

		if (value.length() >= 10)
			for (Character ch : value.toCharArray())
				hashCode += (int) ch;

		// we keep key two digit
		return hashCode % 100;
	}

	@Override
	public void print(Hash h) {

		for (int i = 0; i < h.size; i++) {

			HashNode head = h.array[i].head;
			if (head != null)
				System.out.print("[" + head.key + "]");
			while (head != null) {
				System.out.print(head.value + "->");
				if (head != null && head.next == null)
					System.out.print(head.value + "->NULL");
				head = head.next;
			}
			System.out.println();
		}

	}
}
