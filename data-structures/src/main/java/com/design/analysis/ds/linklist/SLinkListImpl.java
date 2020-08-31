package com.design.analysis.ds.linklist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.design.analysis.ds.common.Point;
import com.design.analysis.ds.linklist.node.FlatLNode;
import com.design.analysis.ds.linklist.node.PointNode;
import com.design.analysis.ds.linklist.node.SLNode;
import com.design.analysis.ds.linklist.utils.Lap;
import com.design.analysis.ds.linklist.utils.SLHashLap;

public class SLinkListImpl implements ISLinkList<Integer> {

	public SLNode<Integer> head = null;
	public SLNode<Integer> tail = null;

	/** delete a givin node without head pointer **/
	public void deleteNode(SLNode<Integer> node) {

		SLNode<Integer> delNode = node;
		Integer delVal = delNode.k;
		delNode.k = delNode.next.k;
		delNode.next.k = delVal;
		SLNode<Integer> q = delNode.next;
		delNode.next = q.next;
		q = null;
	}

	/** 3. Linked List Insertion **/
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> insertArrLast(Lap<SLNode<Integer>, SLNode<Integer>> lap, Integer a[]) {

		if (a == null || a.length == 0)
			return lap;

		if (lap == null)
			lap = new SLHashLap();

		head = lap.getHead();
		tail = lap.getTail();

		int i = 0;
		if (head == null) {
			head = tail = new SLNode<Integer>(a[0]);
			i++;
		}
		for (; i < a.length; i++) {
			tail.next = new SLNode<Integer>(a[i]);
			tail = tail.next;
		}
		lap.put(head, tail);
		return lap;
	}

	/* insert single element */
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> insertElementLast(Lap<SLNode<Integer>, SLNode<Integer>> lap,
			Integer x) {

		SLNode<Integer> temp = new SLNode<Integer>(x);
		if (lap == null) {
			lap = new SLHashLap();
			head = tail = temp;
		} else {
			tail = lap.getTail();
			tail.next = temp;
			tail = tail.next;
		}
		lap.put(head, tail);
		return lap;
	}

	/* insert collection of element in sorted order */
	@Override
	public SLNode<Integer> insertArrSorted(SLNode<Integer> head, Integer a[]) {

		for (int i = 0; i < a.length; i++) {
			SLNode<Integer> temp = new SLNode<Integer>(a[i]);
			if (head == null) {
				head = tail = temp;
			} else if (a[i] <= head.k) { // = applied later
				temp.next = head;
				head = temp;
			} else {
				SLNode<Integer> p = head;
				while (p.next != null) {
					if (a[i] <= p.next.k) { // = applied later
						temp.next = p.next;
						p.next = temp;
						break;
					}
					p = p.next;
				}
				if (p.next == null)
					p.next = temp;
			}
		}
		return head;
	}

	/* insert at given position head is at 1st position */
	@Override
	public SLNode<Integer> insertAtPosition(SLNode<Integer> head, int pos, Integer x) {

		if (pos < 1)
			return head;
		SLNode<Integer> temp = new SLNode<Integer>(x);
		if (head != null) {
			if (pos == 1) {
				temp.next = head;
				head = temp;
			} else {
				SLNode<Integer> p = head;
				for (int i = 1; i < pos - 1; i++, p = p.next)
					;
				if (p != null) {
					temp.next = p.next;
					p.next = temp;
				} else {
					System.out.println("\n position :" + pos + " is out of list");
				}
			}
		} else {
			if (pos == 1)
				head = temp;
		}
		return head;
	}

	/* print the link list nodes */
	public void printList(SLNode<Integer> node) {
		for (; node != null; System.out.print(node.k + "->"), node = node.next)
			;
	}

	/** 4. Linked List Deletion (Deleting a given key) **/
	/* delete the first occurrence of k */
	@Override
	public SLNode<Integer> deleteFirstK(SLNode<Integer> head, Integer x) {
		boolean isFound = false;
		if (head == null)
			return null;
		SLNode<Integer> q = head;
		if (head.k == x) {
			head = head.next;
			q.next = null;
			q = null;
			isFound = true;
		} else {
			SLNode<Integer> node = head.next;
			SLNode<Integer> prev = head;

			for (; node != null; prev = node, node = node.next) {
				if (node.k == x) {
					q = node;
					prev.next = q.next;
					q.next = null;
					q = null;
					isFound = true;
					break;
				}
			}
		}
		if (isFound)
			System.out.println("\n First" + x + ": is deleted");
		else
			System.out.println(x + ": is not found");
		return head;
	}

	/* . Linked List Deletion (Deleting a given key) */
	@Override
	public SLNode<Integer> deleteAllX(SLNode<Integer> head, Integer x) {
		boolean isFound = false;
		if (head == null)
			return null;
		SLNode<Integer> q = head;
		while (head != null && head.k == x) {
			head = head.next;
			q.next = null;
			q = head;
			isFound = true;
		}
		SLNode<Integer> node = head.next;
		SLNode<Integer> prev = head;

		for (; node != null; prev = node, node = node.next) {
			if (node.k == x) {
				q = node;
				prev.next = q.next;
				q.next = null;
				q = null;
				node = prev;
				isFound = true;
			}
		}

		if (isFound)
			System.out.println("\nall: " + x + ": is deleted");
		else
			System.out.println(x + ": is not found");
		return head;
	}

	/* delete the last occurrence of node */
	@Override
	public SLNode<Integer> deleteLastK(SLNode<Integer> head, Integer k) {

		boolean isFound = false;
		SLNode<Integer> prev, prevK, q;
		q = prev = head;
		prevK = null;
		for (; q != null; prev = q, q = q.next) {
			if (q.k == k)
				prevK = prev;
		}
		if (prevK == head) {
			head = head.next;
			prevK.next = null;
			prevK = null;
			isFound = true;
		} else if (prevK != null) {
			SLNode<Integer> temp = prevK.next;
			prevK.next = temp.next;
			temp.next = null;
			temp = null;
			isFound = true;
		}
		if (isFound)
			System.out.println("\nlast: " + k + ": is deleted");
		else
			System.out.println(k + ": is not found");
		return head;
	}

	/* delete the last occurrence of node */
	@Override
	public SLNode<Integer> deleteLastKX(SLNode<Integer> head, Integer k) {

		/* find the position of last occurence */
		int pos = 0;
		int counter = 0;
		SLNode<Integer> q = head;
		while (q != null) {
			if (q.k == k)
				pos = counter + 1;
			counter++;
			q = q.next;
		}
		if (pos == 1)
			return deleteFirstK(head, k);
		else
			return deletePos(head, pos);
	}

	/**
	 * 5. Linked List Deletion (Deleting a key at given position) head at pos=1
	 **/
	@Override
	public SLNode<Integer> deletePos(SLNode<Integer> head, int pos) {
		if (pos < 1)
			return head;

		if (head != null) {
			SLNode<Integer> q = null;
			if (pos == 1) {
				q = head;
				head = head.next;
				q.next = null;
				q = null;
			} else {
				SLNode<Integer> p = head;
				for (int i = 1; i < pos - 1; i++, p = p.next)
					;
				/* p.next is the deleting node */
				if (p != null && p.next != null) {
					q = p.next;
					p.next = q.next;
					q.next = null;
					q = null;
				} else {
					System.out.println("\n position :" + pos + " is out of list");
				}
			}
		}
		return head;
	}

	/** 6. Find Length of a Linked List (Iterative and Recursive) **/
	/* Iterative */
	@Override
	public int lengthIterative(SLNode<Integer> head) {
		int len;
		for (len = 0; head != null; head = head.next, len++)
			;
		return len;
	}

	/* Recursive */
	@Override
	public int lengthRecursive(SLNode<Integer> head) {

		if (head == null)
			return 0;
		return 1 + lengthRecursive(head.next);
	}

	/** 7. Search an element in a Linked List (Iterative and Recursive) **/
	/* Iterative */
	@Override
	public SLNode<Integer> searchIterative(SLNode<Integer> head, Integer x) {
		for (; head != null; head = head.next) {
			if (head.k == x)
				break;
		}
		return head;
	}

	/* Recursive */
	@Override
	public SLNode<Integer> searchRecursive(SLNode<Integer> head, Integer x) {

		if (head == null || head.k == x)
			return head;
		return searchIterative(head.next, x);
	}

	/** 8. Swap nodes in a linked list without swapping data **/
	@Override
	public SLNode<Integer> swapNodes(SLNode<Integer> head, Integer x, Integer y) {

		// Nothing to do if x and y are same
		if (x == y)
			return head;

		// Search for x (keep track of prevX and CurrX)
		SLNode<Integer> prevX = null, currX = head;
		while (currX != null && currX.k != x) {
			prevX = currX;
			currX = currX.next;
		}

		// Search for y (keep track of prevY and currY)
		SLNode<Integer> prevY = null, currY = head;
		while (currY != null && currY.k != y) {
			prevY = currY;
			currY = currY.next;
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return head;

		// If x is not head of linked list
		if (prevX != null)
			prevX.next = currY;
		else // make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.next = currX;
		else // make x the new head
			head = currX;

		// Swap next pointers
		SLNode<Integer> temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		return head;
	}

	/** 9. Write a function to get Nth node in a Linked List head 1st node **/
	public SLNode<Integer> getNthNode(SLNode<Integer> head, int n) {
		for (int i = 1; i < n; i++)
			head = head.next;
		return head;
	}

	/** 10. Print the middle of a given linked list **/
	public List<SLNode<Integer>> getMiddelNodes(SLNode<Integer> head) {

		List<SLNode<Integer>> list = new ArrayList<>();
		if (head == null || head.next == null) {
			list.add(head);
		} else {
			int len = lengthIterative(head);
			for (int i = 1; i < len / 2; i++)
				head = head.next;
			if (len % 2 == 1)
				list.add(head.next);
			else {
				list.add(head);
				list.add(head.next);
			}
		}
		return list;
	}

	/** 11. Nth node from the end of a Linked List **/
	@Override
	public SLNode<Integer> nthNodeFromEnd(SLNode<Integer> head, int n) {
		int l = lengthRecursive(head);
		SLNode<Integer> p = head;
		for (int i = 1; i <= l - n && p != null; p = p.next, i++)
			;
		return p;
	}

	/** 12. Write a function to delete a Linked List **/
	@Override
	public void deleteList(SLNode<Integer> h) {
		SLNode<Integer> p = h;
		SLNode<Integer> prev = p;
		for (; p != null; p = p.next, prev.next = null, prev = p)
			;
		h = null;
	}

	/** 13. counts the number of times a given int occurs **/
	@Override
	public Integer countXValNodes(SLNode<Integer> h, int x) {
		int count = 0;
		for (; h != null; h = h.next) {
			if (h.k == x)
				count++;
		}
		return count;
	}

	/** 14. Reverse a linked list recursive **/
	@Override
	public SLNode<Integer> reverseRcv(SLNode<Integer> node) {
		if (node == null || node.next == null)
			return node;
		SLNode<Integer> newNode = reverseRcv(node.next);
		node.next.next = node;
		node.next = null;
		return newNode;
	}

	/** 15. Detect loop in a linked list **/
	/* create list that contain loop by mistake */
	@Override
	public SLNode<Integer> linkContainLoop(SLNode<Integer> node, Integer[] k) {
		SLNode<Integer> head, tail;
		head = tail = null;
		SLNode<Integer> x = null;
		for (int i = 0; i < k.length; i++) {
			x = new SLNode<Integer>(k[i]);
			if (head == null)
				head = tail = x;
			else {
				tail.next = x;
				tail = x;
			}
		}
		/* do mistake and make point of tail.next to some where */
		x = head;
		for (int i = 0; i < 4 && x != null; x = x.next, i++)
			;
		tail.next = x;
		return head;
	}

	/* detect and then remove loop in list if any */
	@Override
	public SLNode<Integer> detectAndRemoveLoop(SLNode<Integer> k) {
		boolean isLoop = false;
		SLNode<Integer> p = k;
		Set<SLNode<Integer>> set = new HashSet<>();
		for (; p != null; p = p.next) {
			if (set.contains(p.next)) {
				isLoop = true;
				break;
			}
			set.add(p);
		}
		// if loop exits need to remove
		if (isLoop)
			p.next = null;
		return k;
	}

	/** 16. Merge two sorted linked lists **/
	@Override
	public SLNode<Integer> mergeTwoSotedList(SLNode<Integer> k1, SLNode<Integer> k2) {
		if (k1 == null)
			return k2;
		if (k2 == null)
			return k1;
		SLNode<Integer> head, tail;
		head = tail = null;

		while (k1 != null && k2 != null) {
			if (k1.k < k2.k) {
				if (head == null) {
					head = tail = k1;
				} else {
					tail.next = k1;
					tail = k1;
				}
				k1 = k1.next;
			} else {
				if (head == null) {
					head = tail = k2;
				} else {
					tail.next = k2;
					tail = k2;
				}
				k2 = k2.next;
			}
		}
		if (k1 != null) {
			while (k1 != null) {
				tail.next = k1;
				tail = k1;
				k1 = k1.next;
			}
		}

		if (k2 != null) {
			while (k2 != null) {
				tail.next = k2;
				tail = k2;
				k2 = k2.next;
			}
		}
		return head;
	}

	/** 18. Function to check if a singly linked list is palindrome **/
	@Override
	public boolean isPalindrome(SLNode<Integer> h) {

		Stack<Integer> s = new Stack<>();
		SLNode<Integer> p = h;
		while (p != null) {
			s.add(p.k);
			p = p.next;
		}
		p = h;
		while (p != null) {
			if (!p.k.equals(s.pop()))
				return false;
			p = p.next;
		}
		return true;
	}

	/** 19. Intersection point of two Linked Lists. **/
	@Override
	public SLNode<Integer> intersectionNode(SLNode<Integer> k1, SLNode<Integer> k2) {

		SLNode<Integer> p1 = k1;
		SLNode<Integer> p2 = k2;

		Set<SLNode<Integer>> s1 = new HashSet<>();
		while (p1 != null) {
			s1.add(p1);
			p1 = p1.next;
		}
		while (p2 != null) {
			if (s1.contains(p2))
				return p2;
			p2 = p2.next;
		}
		return null;
	}

	/** 19. Intersection point of two Linked Lists. **/
	@Override
	public SLNode<Integer> intersectionNodeX(SLNode<Integer> k1, SLNode<Integer> k2) {

		SLNode<Integer> p1 = k1;
		SLNode<Integer> p2 = k2;

		int l1 = lengthRecursive(p1);
		int l2 = lengthRecursive(p2);
		int d = Math.abs(l1 - l2);
		if (l1 > l2)
			for (int i = 0; i < d; p1 = p1.next, i++)
				;
		if (l2 > l1)
			for (int i = 0; i < d; p2 = p2.next, i++)
				;
		while (p1 != null && p2 != null && p1.next != p2.next) {
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p1 != null || p2 != null)
			return p1.next;
		return null;
	}

	/** 20. Recursive function to print reverse of a Linked List **/
	@Override
	public void reversePrintRcv(SLNode<Integer> k) {

		if (k != null) {
			reversePrintRcv(k.next);
			System.out.print(k.k + "->");
		}
	}

	/** 21. Remove duplicates from a sorted linked list **/
	@Override
	public SLNode<Integer> removeDupicateSortedList(SLNode<Integer> head) {

		SLNode<Integer> q = head;
		SLNode<Integer> temp = null;
		for (; q != null;) {
			if (q.next != null && q.k == q.next.k) {
				temp = q.next;
				q.next = temp.next;
				temp.next = null;
				temp = null;
			} else
				q = q.next;
		}
		return head;
	}

	@Override
	public SLNode<Integer> removeDupicateSortedListX(SLNode<Integer> k) {
		SLNode<Integer> prev = k;
		SLNode<Integer> cur = k;
		for (; cur != null; prev = cur, cur = cur.next) {
			if (prev.k == cur.k) {
				SLNode<Integer> temp = cur;
				prev.next = temp.next;
				temp = temp.next = null;
				cur = prev;
			}
		}
		return k;
	}

	/** 22. Remove duplicates from an unsorted linked list **/
	@Override
	public SLNode<Integer> removeDupicateUnSortedList(SLNode<Integer> head) {

		int i = 0;
		SLNode<Integer> q = head;
		// keep data in order
		LinkedHashSet<SLNode<Integer>> set = new LinkedHashSet<>();
		while (q != null) {
			set.add(q);
			q = q.next;
		}

		for (SLNode<Integer> slNode : set) {
			if (i == 0) {
				head = q = slNode;
			} else {
				q.next = slNode;
				q = slNode;
				if (i == set.size() - 1)
					q.next = null;// for last node since it may point to some one
			}
			i++;
		}
		return head;
	}

	/** 23. Pairwise swap elements of a given linked list **/
	@Override
	public SLNode<Integer> swapPairwise(SLNode<Integer> h) {

		// simply swap the data
		SLNode<Integer> p = h;
		for (; p != null && p.next != null; p = p.next.next) {
			int tm = p.k;
			p.k = p.next.k;
			p.next.k = tm;
		}
		return h;
	}

	@Override
	public SLNode<Integer> swapPairwiseX(SLNode<Integer> h) {

		// simply swap the data
		SLNode<Integer> p = h;
		SLNode<Integer> t = null;
		for (; p != null && p.next != null; p = p.next) {
			if (t == null)
				head = t = p.next;
			else
				t = p.next;
			p.next = t.next;
			t.next = p;
		}
		return h;
	}

	/** 24. Move last element to front of a given Linked List **/
	@Override
	public SLNode<Integer> moveLastToFirst(SLNode<Integer> head) {

		SLNode<Integer> h = head;
		while (h.next != null && h.next.next != null)
			h = h.next;
		SLNode<Integer> temp = h.next;
		h.next = null;// now this is last
		temp.next = head;
		head = temp;
		return temp;

	}

	/** 25. Intersection of two Sorted Linked Lists assume element are unique **/
	@Override
	public SLNode<Integer> intersectionOfLists(SLNode<Integer> k1, SLNode<Integer> k2) {

		SLNode<Integer> q = k1;
		Set<SLNode<Integer>> set = new HashSet<>();
		while (q != null) {
			set.add(q);
			q = q.next;
		}

		SLNode<Integer> p = k2;
		SLNode<Integer> prev = k2;
		while (p != null) {
			if (!set.contains(p)) {
				if (p.equals(k2)) {
					SLNode<Integer> temp = p;
					p = p.next;
					k2 = k2.next;
					temp.next = null;
					temp = null;
				} else {
					k2 = deleteFirstK(k2, p.k);
					p = prev;
				}
			} else {
				prev = p;
				p = p.next;
			}
		}
		return k2;
	}

	/** 26. Delete alternate nodes of a Linked List **/
	@Override
	public SLNode<Integer> deleteAlternative(SLNode<Integer> k) {

		SLNode<Integer> q = k;
		SLNode<Integer> temp = null;
		while (q != null && q.next != null) {
			temp = q.next;
			q.next = temp.next;
			temp.next = null;
			temp = null;
			q = q.next;
		}
		return k;
	}

	/** 27. Alternating split of a given Singly Linked List **/
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> alternativeSplit(SLNode<Integer> k) {

		Lap<SLNode<Integer>, SLNode<Integer>> lap = new SLHashLap();

		if (k == null)
			return lap;
		SLNode<Integer> q = k;
		SLNode<Integer> temp = null;
		SLNode<Integer> tempPrev = null;
		;
		SLNode<Integer> k2 = k.next;
		while (q != null && q.next != null) {
			tempPrev = temp;
			temp = q.next;
			q.next = temp.next;
			if (tempPrev != null)
				tempPrev.next = temp;
			q = q.next;
		}
		lap.put(k, k2);
		return lap;
	}

	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> alternativeSplitX(SLNode<Integer> k) {

		Lap<SLNode<Integer>, SLNode<Integer>> lap = new SLHashLap();

		if (k == null)
			return lap;
		SLNode<Integer> h1 = k;
		SLNode<Integer> h2 = k.next;
		SLNode<Integer> p = h1;
		SLNode<Integer> q = h2;

		while (p != null && p.next != null && q != null && q.next != null) {
			p.next = q.next;
			p = p.next;

			q.next = p.next;
			q = q.next;

		}
		if (q != null && q.next == null)
			p.next = null;// that ponint ot 2nd node of last node check by eveen number nodes by digram
		else {
			if (p != null && p.next == null)// that ponint ot 1st node of last node check by odd number nodes by digram
				q.next = null;
		}

		lap.put(h1, h2);
		return lap;
	}

	/** 28. Identical Linked Lists **/
	@Override
	public boolean isListsIdentical(SLNode<Integer> k1, SLNode<Integer> k2) {

		while (k1 != null && k2 != null) {
			if (!k1.equals(k2))
				return false;
			k1 = k1.next;
			k2 = k2.next;
		}
		return k1 == null && k2 == null;
	}

	/** 29. Merge Sort for Linked Lists **/
	@Override
	public SLNode<Integer> mergeSort(SLNode<Integer> k) {

		if (k == null || k.next == null)
			return k;
		SLNode<Integer> middle = getMiddle(k);
		SLNode<Integer> nextMiddle = middle.next;

		middle.next = null;
		SLNode<Integer> left = mergeSort(k);
		SLNode<Integer> right = mergeSort(nextMiddle);
		SLNode<Integer> sortedList = sortedMerge(left, right);
		return sortedList;
	}

	/* get middle node of list */
	@Override
	public SLNode<Integer> getMiddle(SLNode<Integer> k) {
		if (k == null)
			return k;
		SLNode<Integer> slow = k;
		SLNode<Integer> fast = k.next;

		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}

	/* merge two sorted list */
	@Override
	public SLNode<Integer> sortedMerge(SLNode<Integer> k1, SLNode<Integer> k2) {

		SLNode<Integer> result = null;
		if (k1 == null)
			return k2;
		if (k2 == null)
			return k1;

		if (k1.k <= k2.k) {
			result = k1;
			result.next = sortedMerge(k1.next, k2);
		} else {
			result = k2;
			result.next = sortedMerge(k1, k2.next);
		}
		return result;
	}

	/** 30. Reverse a Linked List in groups of given size..reverse every k nodes **/
	@Override
	public SLNode<Integer> reverseGroupOfN(SLNode<Integer> k, Integer n) {

		// breaking the list in group of n
		SLNode<Integer> q = k;
		SLNode<Integer> nextQ = null;
		SLNode<Integer> headOfSlot = null;
		SLNode<Integer> tailOfPrevSlot = null;
		while (q != null) {
			headOfSlot = q;
			for (int i = 1; i < n && q != null; i++)
				q = q.next;
			if (q != null) {
				nextQ = q.next;
				q.next = null;// breaking the list

			} else
				nextQ = null;
			if (headOfSlot.equals(k)) {
				k = reverseRcv(headOfSlot);

			} else {
				tailOfPrevSlot.next = reverseRcv(headOfSlot);
			}
			tailOfPrevSlot = headOfSlot;
			q = nextQ;

		}
		return k;
	}

	/** 31. Reverse alternate K nodes in a Singly Linked List **/
	@Override
	public SLNode<Integer> reverseAlternateN(SLNode<Integer> k, Integer n) {

		// breaking the list in group of n
		SLNode<Integer> q = k;
		SLNode<Integer> nextQ = null;
		SLNode<Integer> headOfSlot = null;
		SLNode<Integer> tailOfPrevSlot = null;
		boolean isReverse = true;
		while (q != null) {
			if (isReverse) {
				headOfSlot = q;
				for (int i = 1; i < n && q != null; i++)
					q = q.next;
				if (q != null) {
					nextQ = q.next;
					q.next = null;// breaking the list

				} else
					nextQ = null;
				if (headOfSlot.equals(k)) {
					k = reverseRcv(headOfSlot);

				} else {
					tailOfPrevSlot.next = reverseRcv(headOfSlot);
				}
				tailOfPrevSlot = headOfSlot;
				q = nextQ;
				isReverse = false;
			} else {
				tailOfPrevSlot.next = q;
				for (int i = 1; i < n && q != null; i++)
					q = q.next;
				tailOfPrevSlot = q;
				if (q != null)
					q = q.next;// go to next slot
				isReverse = true;
			}
		}
		return k;
	}

	/**
	 * 32. Delete nodes which have a greater value on right side assume value r
	 * unique
	 **/
	@Override
	public SLNode<Integer> delLesserNodes(SLNode<Integer> head) {
		SLNode<Integer> current = head;

		SLNode<Integer> maxnode = head;
		SLNode<Integer> temp;

		while (current != null && current.next != null) {
			/* If current is smaller than max, then delete current */
			if (maxnode.k > current.next.k) {
				temp = current.next;
				current.next = temp.next;
				temp = null;
			} else {
				current = current.next;
				maxnode = current;
			}
		}
		return head;
	}

	@Override
	public SLNode<Integer> deleteRightGreaterVal(SLNode<Integer> head) {
		head = reverseRcv(head);
		head = delLesserNodes(head);
		return reverseRcv(head);
	}

	/** 33. Segregate even and odd nodes in a Linked List **/
	@Override
	public Lap<SLNode<Integer>, SLNode<Integer>> seperateOddEvenList(SLNode<Integer> node) {
		SLNode<Integer> ep, eh = null;
		SLNode<Integer> op, oh = null;
		SLNode<Integer> p = head;
		ep = null;
		op = null;
		while (p != null) {
			if (p.k % 2 == 0) {
				if (eh == null) {
					eh = p;
					ep = p;
				} else {
					ep.next = p;
					ep = ep.next;
				}
			} else {
				if (oh == null) {
					oh = p;
					op = p;
				} else {
					op.next = p;
					op = op.next;
				}
			}

			p = p.next;
		}
		// managing last pointer every list connected to last node
		if (ep.next != null && ep.next.k % 2 != 0)
			ep.next = null;
		if (op.next != null && op.next.k % 2 == 0)
			op.next = null;
		SLHashLap lap = new SLHashLap();
		lap.setHead(eh);
		lap.setTail(oh);
		return lap;
	}

	/** 34. Detect and Remove Loop in a Linked List **/
	@Override
	public SLNode<Integer> isLoopInList(SLNode<Integer> head) {

		Set<Integer> set = new HashSet<>();
		SLNode<Integer> hPrev = head;
		while (head != null) {
			if (!set.contains(head.k))
				set.add(head.k);
			else
				return hPrev;
			hPrev = head;
			head = head.next;
		}
		return null;
	}

	@Override
	public SLNode<Integer> dectedAndRemoveLoopInList(SLNode<Integer> head) {

		SLNode<Integer> p = head;
		p = isLoopInList(p);
		if (p != null)
			p.next = null;// breaking the loop
		return head;
	}

	/** 35. Add two numbers represented by linked lists | Set 1 **/
	@Override
	public SLNode<Integer> addTwoNoRepesentByList(SLNode<Integer> h1, SLNode<Integer> h2) {

		int n1 = 0;
		int n2 = 0;
		SLNode<Integer> p1 = h1;
		SLNode<Integer> p2 = h2;
		for (; p1 != null; n1++, p1 = p1.next)
			;
		for (; p2 != null; n2++, p2 = p2.next)
			;

		h1 = reverseRcv(h1);
		h2 = reverseRcv(h2);
		p1 = h1;
		p2 = h2;
		int carry = 0;
		if (n1 > n2) {
			while (p2 != null) {
				int sum = p1.k + p2.k;
				if (carry == 1) {
					sum++;
					carry = 0;
				}
				if (sum > 10) {
					sum = sum % 10;
					carry = 1;
				}
				p1.k = sum;
				p2 = p2.next;
				p1 = p1.next;
			}
			if (carry == 1)
				p1.next.k = p1.next.k + 1;
		} else {

			while (p1 != null) {
				int sum = p1.k + p2.k;
				if (carry == 1) {
					sum++;
					carry = 0;
				}
				if (sum > 10) {
					sum = sum % 10;
					carry = 1;
				}
				p2.k = sum;
				p2 = p2.next;
				p1 = p1.next;
			}
			if (carry == 1)
				p2.next.k = p2.next.k + 1;
		}
		return n1 > n2 ? reverseRcv(h1) : reverseRcv(h2);
	}

	/** 36. Delete a given node in Linked List under given constraints **/
	@Override
	public SLNode<Integer> deleteNode(SLNode<Integer> head, SLNode<Integer> delNode) {
		return deleteFirstK(head, delNode.k);
	}

	/** 37. Union and Intersection of two Linked Lists **/
	@Override
	public SLNode<Integer> unionOfLists(SLNode<Integer> h1, SLNode<Integer> h2) {

		List<Integer> list = new ArrayList<>();
		SLNode<Integer> p = h1;
		SLNode<Integer> prev = h1;
		while (p != null) {
			if (searchRecursive(h2, p.k) != null)
				list.add(p.k);
			prev = p;
			p = p.next;
		}
		prev.next = h2;
		for (Integer inte : list)
			h1 = deleteLastK(h1, inte);
		return h1;
	}

	@Override
	public SLNode<Integer> intersectionOfListsX(SLNode<Integer> h1, SLNode<Integer> h2) {
		List<Integer> list = new ArrayList<>();
		SLNode<Integer> p = h1;
		while (p != null) {
			if (searchRecursive(h2, p.k) == null)
				list.add(p.k);
			p = p.next;
		}
		for (Integer inte : list)
			h1 = deleteFirstK(h1, inte);
		return h1;
	}

	/** 38. Find a triplet from linked lists with sum equal to a given number **/
	@SuppressWarnings("unchecked")
	@Override
	public SLNode<Integer> sortList(SLNode<Integer> head) {
		int max = Integer.MIN_VALUE;
		SLNode<Integer> p = head;
		// O(n)
		for (; p != null; p = p.next) {
			if (max < p.k)
				max = p.k;
		}
		SLNode<Integer> arr[] = new SLNode[max + 1];
		// O(n)
		for (p = head; p != null; p = p.next)
			arr[p.k] = p;
		// O(max)
		for (int i = 0, k = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (k == 0) {
					head = arr[i];
					p = arr[i];
					k++;
				} else {
					p.next = arr[i];
					p = p.next;
				}
			}
		}
		// last node must point to null;
		p.next = null;
		return head;
	}

	@Override
	public List<List<Integer>> tripletInList(SLNode<Integer> ah, SLNode<Integer> bh, SLNode<Integer> ch,
			int givenNumber) {
		List<List<Integer>> ll = new ArrayList<>();
		bh = sortList(bh);
		ch = sortList(ch);
		SLNode<Integer> a, b, c;
		a = ah;
		while (a != null) {
			// For every node of list a, prick two nodes
			// from lists b abd c
			b = bh;
			c = ch;
			while (b != null && c != null) {
				// If this a triplet with given sum, print
				// it and return true
				int sum = a.k + b.k + c.k;
				if (sum == givenNumber) {
					List<Integer> l = new ArrayList<>();
					l.add(a.k);
					l.add(b.k);
					l.add(c.k);
					ll.add(l);
					b = b.next;
					c = c.next;
				}

				// If sum of this triplet is smaller, look for
				// greater values in b
				else if (sum < givenNumber)
					b = b.next;
				else // If sum is greater, look for smaller values in c
					c = c.next;
			}
			a = a.next; // Move ahead in list a
		}

		return ll;
	}

	/** 39. Rotate a Linked List **/
	@Override
	public SLNode<Integer> rotateList(SLNode<Integer> head, int noOfRotation, boolean isClockWise) {

		int n = lengthRecursive(head);
		SLNode<Integer> p, q, newHead;
		p = head;
		q = null;
		int rotateLen = isClockWise ? n - noOfRotation : noOfRotation;

		for (int i = 1; i < rotateLen; i++)
			p = p.next;
		q = p.next;
		p.next = null;
		newHead = q;
		while (q.next != null)
			q = q.next;
		q.next = head;
		head = newHead;

		return head;
	}

	/** 40. Flattening a Linked List **/
	@Override
	public FlatLNode<Integer> insertDownFlatList(FlatLNode<Integer> head, Integer k) {

		FlatLNode<Integer> temp = new FlatLNode<Integer>(k);
		if (head == null)
			head = temp;
		else {
			FlatLNode<Integer> x = head;
			while (x.down != null)
				x = x.down;
			x.down = temp;
		}
		return head;
	}

	@Override
	public FlatLNode<Integer> makeFlatList(List<FlatLNode<Integer>> list) {

		FlatLNode<Integer> head = list.get(0);
		FlatLNode<Integer> q = head;
		for (int i = 1; i < list.size(); i++) {
			q.next = list.get(i);
			q = q.next;
		}
		return head;
	}

	public FlatLNode<Integer> merge(FlatLNode<Integer> a, FlatLNode<Integer> b) {

		// If first list is empty, the second list is result
		if (a == null)
			return b;

		// If second list is empty, the second list is result
		if (b == null)
			return a;

		// Compare the data members of head nodes of both lists
		// and put the smaller one in result
		FlatLNode<Integer> result;
		if (a.k < b.k) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(a, b.down);
		}
		return result;
	}

	@Override
	public FlatLNode<Integer> flattern(FlatLNode<Integer> head) {
		// Base cases
		if (head == null || head.next == null)
			return head;

		// Merge this list with the list on right side
		return merge(head, flattern(head.next));
	}

	@Override
	public void displayFlatternList(FlatLNode<Integer> k) {

		FlatLNode<Integer> p = k;
		FlatLNode<Integer> q = k;
		for (; p != null; p = p.next) {
			System.out.println();
			for (q = p; q != null; q = q.down)
				System.out.print(q.k + "->");
		}
	}

	public void printListDown(FlatLNode<Integer> node) {
		while (node != null) {
			System.out.print(node.k + "->");
			node = node.down;
		}
	}

	/** 41. Add two numbers represented by linked lists | Set 2 **/
	// @see @35. in this list only

	/** 42. Sort a linked list of 0s, 1s and 2s **/
	@SuppressWarnings("unchecked")
	public SLNode<Integer> sort0s1s2sList(SLNode<Integer> head) {

		SLNode<Integer> p = head;
		// keep the value in to arraylist

		List<SLNode<Integer>> arList[] = new ArrayList[3];
		for (int i = 0; i <= 2; i++)
			arList[i] = new ArrayList<>();
		// O(n)
		for (p = head; p != null; p = p.next)
			arList[p.k].add(p);

		// O(2*(n/3))
		for (int i = 0, k = 0; i < arList.length; i++) {
			for (SLNode<Integer> node : arList[i])
				if (node != null) {
					if (k == 0) {
						head = node;
						p = node;
						k++;
					} else {
						p.next = node;
						p = p.next;
					}
				}
		}
		// last node must point to null;
		p.next = null;
		return head;
	}

	/** 43. Flatten a multilevel linked list **/
	@Override
	public FlatLNode<Integer> insertNextFlatList(FlatLNode<Integer> head, Integer k) {
		FlatLNode<Integer> temp = new FlatLNode<Integer>(k);
		if (head == null)
			head = temp;
		else {
			FlatLNode<Integer> x = head;
			while (x.next != null)
				x = x.next;
			x.next = temp;
		}
		return head;
	}

	public FlatLNode<Integer> multiFlattern(FlatLNode<Integer> head) {
		Queue<FlatLNode<Integer>> queue = new LinkedList<>();
		FlatLNode<Integer> p = head;
		FlatLNode<Integer> prev = head;
		for (; p != null; prev = p, p = p.next) {
			if (p.down != null)
				queue.add(p.down);
		}
		FlatLNode<Integer> pp = null;
		while (!queue.isEmpty()) {
			FlatLNode<Integer> inHead = queue.poll();
			prev.next = inHead;
			prev = prev.next;
			pp = inHead;
			for (; inHead != null; pp = inHead, inHead = inHead.next) {
				prev = prev.next;
				if (inHead.down != null)
					queue.add(inHead.down);
			}
			// prev always should be at last node in row list
			prev = pp;
		}
		return head;
	}

	@Override
	public void printListNext(FlatLNode<Integer> node) {
		while (node != null) {
			System.out.print(node.k + "->");
			node = node.next;
		}
	}

	/** 44. Delete N nodes after M nodes of a linked list **/
	public SLNode<Integer> deleteNnodesAfterMNodes(SLNode<Integer> head, int m, int n) {
		// after every m count of node delete n count of node
		int count = 1;
		int cnt = 0;
		SLNode<Integer> p = head;
		SLNode<Integer> q = null;
		while (p != null) {

			if (count == m) {
				cnt = 0;
				q = p;
				while (q != null) {
					if (cnt == n) {
						p.next = q.next;
						count = 0;
						break;
					}
					q = q.next;
					cnt++;
				}
			}
			p = p.next;
			count++;
		}
		return head;
	}

	/** 45. QuickSort on Singly Linked List **/
	public SLNode<Integer> getTail(SLNode<Integer> node) {
		if (node == null)
			return node;
		else {
			while (node.next != null)
				node = node.next;
			return node;
		}
	}

	// nh & nt will be newHead nad newTail, h and t will be head ann tail
	public List<SLNode<Integer>> partition(SLNode<Integer> h, SLNode<Integer> t, SLNode<Integer> nh,
			SLNode<Integer> nt) {

		List<SLNode<Integer>> list = new ArrayList<>();
		SLNode<Integer> pivot, curTail, prev, cur;
		prev = null;
		cur = h;
		pivot = t;
		curTail = pivot;// t

		while (cur != pivot) {
			if (cur.k < pivot.k) {
				if (nh == null)
					nh = cur;
				prev = cur;
				cur = cur.next;
			} else {
				if (prev != null)
					prev.next = cur.next;
				SLNode<Integer> temp = cur.next;
				cur.next = null;
				curTail.next = cur;
				curTail = cur;
				cur = temp;
			}
		}
		// If the pivot data is the smallest element in the current list,
		// pivot becomes the head
		if (nh == null)
			nh = pivot;
		nt = curTail;

		list.add(pivot);
		list.add(nh);
		list.add(nt);
		return list;
	}

	@Override
	public SLNode<Integer> quickSortOnList(SLNode<Integer> head, SLNode<Integer> tail) {

		if (head == null || head == tail)
			return head;
		SLNode<Integer> newHead, newTail, pivot;
		pivot = newHead = newTail = null;

		List<SLNode<Integer>> list = partition(head, tail, newHead, newTail);
		pivot = list.get(0);
		newHead = list.get(1);
		newTail = list.get(2);

		// If pivot is the smallest element - no need to recur for
		// the left part.
		if (newHead != pivot) {
			// Set the node before the pivot node as NULL
			SLNode<Integer> tmp = newHead;
			while (tmp.next != pivot)
				tmp = tmp.next;
			tmp.next = null;

			// Recur for the list before pivot
			newHead = quickSortOnList(newHead, tmp);

			// Change next of last node of the left half to pivot
			tmp = getTail(newHead);
			tmp.next = pivot;
		}

		// Recur for the list after the pivot element
		pivot.next = quickSortOnList(pivot.next, newTail);

		return newHead;
	}

	/** 46. Merge a linked list into another linked list at alternate positions **/
	public SLNode<Integer> mergeAtAlternativePos(SLNode<Integer> h1, SLNode<Integer> h2) {
		SLNode<Integer> pPrev, p, qPrev, q;
		pPrev = h1;
		p = h1.next;

		qPrev = h2;
		q = h2.next;

		for (; p != null && q != null; qPrev = q, pPrev = p, p = p.next, q = q.next) {

			pPrev.next = qPrev;
			qPrev.next = p;
		}
		// ie first is greater lengh
		if (q == null && p != null) {
			pPrev.next = qPrev;
			qPrev.next = p;
		}
		// last node of q need to link if both have same length
		if (q == null && p == null)
			pPrev.next = qPrev;
		// if both list is not same length
		if (q != null) {
			// link the last node of q to PPrev then seperate the rest of q
			pPrev.next = qPrev;
			h2 = qPrev.next;
			qPrev.next = null;
		}
		return h1;
	}

	/** 47. Pairwise swap elements of a given linked list by changing links **/
	@Override
	public SLNode<Integer> pairwiseSwapUseLink(SLNode<Integer> head) {
		// If linked list is empty or there is only one node in list
		if (head == null || head.next == null)
			return head;

		// Initialize previous and current pointers
		SLNode<Integer> prev = head;
		SLNode<Integer> curr = head.next;

		head = curr; // Change head before proceeeding

		// Traverse the list
		while (true) {
			SLNode<Integer> next = curr.next;
			curr.next = prev; // Change next of current as previous node

			// If next NULL or next is the last node
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}

			// Change next of previous to next next
			prev.next = next.next;

			// Update previous and curr
			prev = next;
			curr = prev.next;
		}
		return head;
	}

	/** 48. Given a linked list of line segments, remove middle points **/
	@Override
	public PointNode insertLineLink(PointNode head, Point p) {
		PointNode temp = new PointNode(p.x, p.y);
		if (head == null)
			head = temp;
		else {
			PointNode q = head;
			while (q.next != null)
				q = q.next;
			q.next = temp;
		}
		return head;
	}

	@Override
	public PointNode removeMiddlePointOfLineSegment(PointNode head) {

		// If only one node or no node...Return back
		if (head == null || head.next == null || head.next.next == null)
			return head;

		PointNode p = head.next;
		PointNode q = p.next;

		// Check if this is a vertical line or horizontal line
		if (head.x == p.x) {
			// Find middle nodes with same x value, and delete them
			while (q != null && p.x == q.x) {
				// delete p
				head.next = p.next;
				p.next = null;

				// Update Next and NextNext for next iteration
				p = q;
				q = q.next;
			}
		} else if (head.y == p.y) // If horizontal line
		{
			// Find middle nodes with same y value, and delete them
			while (q != null && p.y == q.y) {
				head.next = p.next;
				p.next = null;

				// Update Next and NextNext for next iteration
				p = q;
				q = q.next;
			}
		} else // Adjacent points must have either same x or same y
		{
			System.out.println("Given linked list is not valid");
			return null;
		}

		// Recur for next segment
		removeMiddlePointOfLineSegment(head.next);

		return head;
	}

	@Override
	public void displayPointList(PointNode p) {

		while (p != null) {
			System.out.print("(" + p.x + "," + p.y + ")=>");
			p = p.next;
		}
	}

	/*****************************************************************************************************************************************************************/
	/** 86. Check whether the length of given linked list is Even or Odd **/
	public boolean evenOrOdd(SLNode<Integer> head) {
		return lengthRecursive(head) % 2 == 0;
	}

	/**
	 * 87. Union and Intersection of two linked lists | Set-2 (Using Merge Sort)
	 **/
	public SLNode<Integer> unionOfListsByMergeSort(SLNode<Integer> h1, SLNode<Integer> h2) {

		h1 = mergeSort(h1);
		h2 = mergeSort(h2);
		SLNode<Integer> head, tail;
		head = tail = null;

		while (h1 != null && h2 != null) {
			if (h1.k < h2.k) {
				if (head == null)
					head = tail = h1;
				else {
					tail.next = h1;
					tail = tail.next;
				}
				h1 = h1.next;
			} else if (h2.k < h1.k) {
				if (head == null)
					head = tail = h2;
				else {
					tail.next = h2;
					tail = tail.next;
				}
				h2 = h2.next;
			} // both r equal
			else {
				if (head == null)
					head = tail = h2;
				else {
					tail.next = h2;
					tail = tail.next;
				}
				h1 = h1.next;
				h2 = h2.next;
			}
		}
		while (h1 != null) {
			tail.next = h1;
			tail = tail.next;
		}

		while (h2 != null) {
			tail.next = h2;
			tail = tail.next;
		}
		return head;
	}

	public SLNode<Integer> intersectionOfListsByMergeSort(SLNode<Integer> h1, SLNode<Integer> h2) {
		h1 = mergeSort(h1);
		h2 = mergeSort(h2);
		SLNode<Integer> head, tail;
		head = tail = null;

		while (h1 != null && h2 != null) {
			if (h1.k < h2.k) {
				h1 = h1.next;
			} else if (h2.k < h1.k) {
				h2 = h2.next;
			} // both r equal
			else {
				if (head == null)
					head = tail = h2;
				else {
					tail.next = h2;
					tail = tail.next;
				}
				h1 = h1.next;
				h2 = h2.next;
			}
		}
		return head;

	}

	/** 88. Multiply two numbers represented by Linked Lists **/
	public int multiplyTwoLists(SLNode<Integer> h1, SLNode<Integer> h2) {

		int num1 = 0, num2 = 0;

		// Generate numbers from linked lists
		while (h1 != null || h2 != null) {
			if (h1 != null) {
				num1 = num1 * 10 + h1.k;
				h1 = h1.next;
			}
			if (h2 != null) {
				num2 = num2 * 10 + h2.k;
				h2 = h2.next;
			}
		}
		return num1 * num2;
	}

	/** 89. Union and Intersection of two linked lists | Set-3 (Hashing) **/
	// @See @37. point
	/** 90. Find the sum of last n nodes of the given Linked List **/
	public int sumOfLastNNodes(SLNode<Integer> h, int n) {
		int sum = 0;
		SLNode<Integer> p = h;
		int len = lengthRecursive(h);
		for (int i = 1; i < len - n + 1; i++)
			p = p.next;
		while (p != null) {
			sum += p.k;
			p = p.next;
		}
		return sum;
	}

	/**
	 * 91. Count pairs from two linked lists whose sum is equal to a given value
	 **/
	public int countPairOfSum(SLNode<Integer> h1, SLNode<Integer> h2, int sum) {

		int count = 0;
		SLNode<Integer> x = h1;
		Set<Integer> set = new HashSet<>();
		for (; x != null; set.add(x.k), x = x.next)
			;
		SLNode<Integer> y = h2;

		for (; y != null; y = y.next) {
			if (set.contains(sum - y.k))
				count++;
		}
		return count;
	}

	/** 92. Merge k sorted linked lists | Set 2 (Using Min Heap) **/
	public static Comparator<SLNode<Integer>> idComparator = new Comparator<SLNode<Integer>>() {
		@Override
		public int compare(SLNode<Integer> lhs, SLNode<Integer> rhs) {
			return lhs.k - rhs.k;
		}
	};

	public SLNode<Integer> mergeKsortedList(List<SLNode<Integer>> list) {
		Queue<SLNode<Integer>> pq = new PriorityQueue<SLNode<Integer>>(idComparator);

		SLNode<Integer> head, last;
		head = last = null;
		// add the all header to pq
		for (int i = 0; i < list.size(); i++)
			pq.add(list.get(i));

		while (!pq.isEmpty()) {
			SLNode<Integer> top = pq.poll();
			if (top.next != null)
				pq.add(top.next);
			if (head == null) {
				head = top;
				last = top;
			} else {
				last.next = top;
				last = top;
			}
		}
		return head;

	}

	/**
	 * 93. Recursive selection sort for singly linked list | Swapping node links
	 **/
	@Override
	public SLNode<Integer> insertAtSorted(SLNode<Integer> head, SLNode<Integer> temp) {

		if (head == null) {
			head = tail = temp;
		} else if (temp.k <= head.k) { // = applied later
			temp.next = head;
			head = temp;
		} else {
			SLNode<Integer> p = head;
			while (p.next != null) {
				if (temp.k <= p.next.k) { // = applied later
					temp.next = p.next;
					p.next = temp;
					break;
				}
				p = p.next;
			}
			if (p.next == null)
				p.next = temp;
		}
		return head;
	}

	public SLNode<Integer> selectionSortRcv(SLNode<Integer> head, SLNode<Integer> p, SLNode<Integer> pnext) {

		if (pnext == null)
			return head;
		else {
			p.next = null;
			head = insertAtSorted(head, p);
		}
		return selectionSortRcv(head, pnext, pnext.next);
	}

	/** 94. Find length of loop in linked list **/
	public int lengthOfloop(SLNode<Integer> head) {
		int loopLen = 0;
		boolean isLoop = false;
		SLNode<Integer> p = head;
		Set<SLNode<Integer>> set = new HashSet<>();
		for (; p != null; p = p.next) {
			if (set.contains(p.next)) {
				isLoop = true;
				break;
			}
			set.add(p);
		}
		if (isLoop) {

			SLNode<Integer> q = p.next;
			while (q != p) {
				loopLen++;
				q = q.next;
			}
		}
		return isLoop ? loopLen + 1 : 0;
	}

	/** 95. Reverse a Linked List in groups of given size | Set 2 **/
	@Override
	public SLNode<Integer> reverseInGroup(SLNode<Integer> head, int blockSize) {

		Queue<SLNode<Integer>> queue = new LinkedList<>();

		SLNode<Integer> p, q, r;
		p = head;
		q = head;
		for (int i = 1; i <= blockSize && p != null; i++) {
			if (i == blockSize) {
				r = p.next;
				p.next = null;
				queue.add(q);
				q = r;
				p = q;
				i = 0;
				continue;
			}
			p = p.next;
		}
		// keep last some node less than bolck size
		SLNode<Integer> x = q;
		boolean isHead = true;
		r = null;
		while (!queue.isEmpty()) {
			p = reverseRcv(queue.poll());
			if (isHead) {
				r = p;
				head = p;
				isHead = false;
			} else {
				r.next = p;
			}
			while (r.next != null)
				r = r.next;
		}
		// add x to list
		r.next = x;
		return head;
	}

	/** 96. Insert node into the middle of the linked list **/
	@Override
	public SLNode<Integer> insertAtMiddle(SLNode<Integer> head, Integer x) {

		SLNode<Integer> temp = new SLNode<Integer>(x);
		SLNode<Integer> p, q;
		p = q = head;
		while (q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
		}
		temp.next = p.next;
		p.next = temp;
		return head;
	}

	/** 97. Merge two sorted lists (in-place) **/
	@Override
	public SLNode<Integer> merge2SortedList(SLNode<Integer> h1, SLNode<Integer> h2) {

		SLNode<Integer> p, q, temp, head;
		temp = head = null;
		p = h1;
		q = h2;
		while (p.next != null && q.next != null) {
			if (p.k < q.k) {
				temp = p.next;
				if (head == null)
					head = p;
				p.next = q;
				p = temp;
			} else {
				temp = q.next;
				if (head == null)
					head = q;
				q.next = p;
				q = temp;
			}
		}
		// link the last node
		if (q.next == null) {
			q.next = p.next;
			p.next = q;
		}
		if (p.next == null) {
			p.next = q;
			q.next = p;
		}
		return head;
	}

	/** 98. Sort a linked list of 0s, 1s and 2s by changing links **/
	@Override
	public SLNode<Integer> sort0s1s2sListByChangingLink(SLNode<Integer> head) {
		SLNode<Integer> h0, h0next, h1, h1next, h2, h2next, p;
		p = head;
		h0 = h0next = h1 = h1next = h2 = h2next = null;

		for (; p != null; p = p.next) {
			switch (p.k) {
			case 0:
				if (h0 == null) {
					h0 = p;
					h0next = p;
				} else {
					h0next.next = p;
					h0next = h0next.next;
				}
				break;
			case 1:
				if (h1 == null) {
					h1 = p;
					h1next = p;
				} else {
					h1next.next = p;
					h1next = h1next.next;
				}
				break;
			case 2:
				if (h2 == null) {
					h2 = p;
					h2next = p;
				} else {
					h2next.next = p;
					h2next = h2next.next;
				}
				break;
			}
		}
		// link the 0s,1s and 2s node
		if (h0next != null) {
			h0next.next = h1;
			if (h1next != null)
				h1next.next = h2;
			else// if 1 not exits
				h0next.next = h2;
		} // 0 not exists
		else {
			if (h1next != null) {
				h1next.next = h2;
				return h1;
			} else {// only 2 exists
				return h2;
			}
		}
		return h0;
	}

	/** 99. Insert a node after the n-th node from the end **/
	@Override
	public SLNode<Integer> insertAfterNthNodeFromEnd(SLNode<Integer> head, int x, int n) {
		SLNode<Integer> temp = new SLNode<Integer>(x);
		int l = lengthRecursive(head);
		int pos = l - n + 1; // from begning
		SLNode<Integer> q = head;
		for (int i = 1; i < pos; i++) {
			q = q.next;
		}

		temp.next = q.next;
		q.next = temp;
		return head;
	}

	/** 100. Rotate Linked List block wise **/
	@Override
	public SLNode<Integer> blockWiseRotation(SLNode<Integer> head, int blockSize, int noOfRotation) {

		Queue<SLNode<Integer>> queue = new LinkedList<>();

		SLNode<Integer> p, q, r;
		p = head;
		q = head;
		for (int i = 1; i <= blockSize && p != null; i++) {
			if (i == blockSize) {
				r = p.next;
				p.next = null;
				queue.add(q);
				q = r;
				p = q;
				i = 0;
				continue;
			}
			p = p.next;
		}
		// keep last some node less than bolck size
		SLNode<Integer> x = q;
		boolean isHead = true;
		r = null;
		while (!queue.isEmpty()) {
			p = rotateList(queue.poll(), noOfRotation, true);
			if (isHead) {
				r = p;
				head = p;
				isHead = false;
			} else {
				r.next = p;
			}
			while (r.next != null)
				r = r.next;
		}
		// add x to list
		r.next = x;
		return head;
	}

	/** 101. Count rotations in sorted and rotated linked list **/
	@Override
	public int countRotationClkWise(SLNode<Integer> head) {

		SLNode<Integer> q = head;
		int count = 1;
		while (q != null && q.next != null) {
			if (q.k > q.next.k)
				break;
			count++;
			q = q.next;
		}
		return count;
	}

	/** 102. Make middle node head in a linked list **/
	@Override
	public SLNode<Integer> makeMiddleNodeHead(SLNode<Integer> head) {
		SLNode<Integer> p, q, pPrev;
		p = pPrev = q = head;

		while (q.next != null && q.next.next != null) {
			pPrev = p;
			p = p.next;
			q = q.next.next;
		}
		SLNode<Integer> next = p.next;
		SLNode<Integer> headNext = head.next;
		p.next = headNext;
		head.next = next;
		pPrev.next = head;
		head = p;
		return head;
	}
}
