package com.design.analysis.core.ds.linklist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.design.analysis.core.ds.linklist.node.DLNode;
import com.design.analysis.core.ds.linklist.node.TTreeNode;
import com.design.analysis.core.ds.linklist.utils.DLHashLap;
import com.design.analysis.core.ds.linklist.utils.Lap;
import com.design.analysis.core.ds.tree.node.BTNode;
import com.design.analysis.core.ds.hashing.utils.BTreeUitls;

public class DLinkListImpl implements IDLinkList<Integer> {

	public BTreeUitls<Integer> util = new BTreeUitls<>();

	public DLNode<Integer> head = null;
	public DLNode<Integer> tail = null;

	/** 1. Doubly Linked List Introduction and Insertion **/
	/* insert collection of element */
	@Override
	public Lap<DLNode<Integer>, DLNode<Integer>> insertArrLast(Lap<DLNode<Integer>, DLNode<Integer>> lap, Integer a[]) {

		if (a == null || a.length == 0)
			return lap;

		if (lap == null)
			lap = new DLHashLap();

		head = lap.getHead();
		tail = lap.getTail();

		int i = 0;
		if (head == null) {
			head = tail = new DLNode<Integer>(a[0]);
			i++;
		}
		DLNode<Integer> temp = null;
		for (; i < a.length; i++) {
			temp = new DLNode<Integer>(a[i]);
			tail.next = temp;
			temp.prev = tail;
			tail = tail.next;// tail=temp;
		}
		lap.put(head, tail);
		return lap;
	}

	/* insert element at first */
	public Lap<DLNode<Integer>, DLNode<Integer>> insertElementFirst(Lap<DLNode<Integer>, DLNode<Integer>> lap,
			Integer k) {

		DLNode<Integer> temp = new DLNode<Integer>(k);
		if (lap == null)
			lap = new DLHashLap();

		head = lap.getHead();
		tail = lap.getTail();

		if (head == null) {
			head = tail = temp;
		} else {
			head.prev = temp;
			temp.next = head;
			head = head.prev;// head=temp;
		}
		lap.put(head, tail);
		return lap;
	}

	/* insert single element at end of list */
	@Override
	public Lap<DLNode<Integer>, DLNode<Integer>> insertElementLast(Lap<DLNode<Integer>, DLNode<Integer>> lap,
			Integer k) {

		DLNode<Integer> temp = new DLNode<Integer>(k);
		if (lap == null)
			lap = new DLHashLap();

		head = lap.getHead();
		tail = lap.getTail();

		if (head == null) {
			head = tail = temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
			tail = tail.next;// tail=temp;
		}
		lap.put(head, tail);
		return lap;
	}

	/* insert at given position head is at 1st position */
	@Override
	public DLNode<Integer> insertAtPosition(DLNode<Integer> head, int pos, Integer k) {
		if (pos < 1)
			return head;
		DLNode<Integer> temp = new DLNode<Integer>(k);
		if (head != null) {
			if (pos == 1) {
				temp.next = head;
				head.prev = temp;
				head = temp;
			} else {
				DLNode<Integer> p = head;
				for (int i = 1; i < pos - 1; i++, p = p.next)
					;
				if (p != null) {
					temp.next = p.next;
					p.next = temp;
					temp.prev = p;
					temp.next.prev = temp;
				} else {
					System.out.println("\n position :" + pos + " is out of list");
				}
			}
		} else { // ie no node exists and pos=1
			if (pos == 1)
				head = temp;
		}
		return head;
	}

	/* print list */
	@Override
	public void print(DLNode<Integer> head) {

		System.out.println("forward:print");
		DLNode<Integer> prv = head;
		for (; head != null; prv = head, head = head.next)
			System.out.print(head.k + "<=>");

		System.out.println("\nBackward:print");
		for (; prv != null; prv = prv.prev)
			System.out.print(prv.k + "<=>");

	}

	/** 2. Delete a node in a Doubly Linked List **/
	@Override
	public DLNode<Integer> deleteNodeFirstK(DLNode<Integer> head, Integer k) {
		boolean isFound = false;
		if (head == null)
			return null;
		DLNode<Integer> q = head;
		if (head.k == k) {
			head = head.next;
			if (head != null)// if only one node exits that is going to delete
				head.prev = null;
			q.next = null;
			q = null;
			isFound = true;
		} else {
			DLNode<Integer> node = head.next;
			DLNode<Integer> prev = head;

			for (; node != null; prev = node, node = node.next) {
				if (node.k == k) {
					q = node;
					prev.next = q.next;
					if (q.next != null)// if q is last node
						q.next.prev = q.prev;
					q.next = q.prev = null;
					q = null;
					break;
				}
			}
		}
		if (isFound)
			System.out.println("\n" + k + ": is deleted");
		else
			System.out.println(k + ": is not found");
		return head;
	}

	/* delete all the node having value k */
	@Override
	public DLNode<Integer> deleteAllOccurance(DLNode<Integer> head, Integer k) {
		boolean isFound = false;
		if (head == null)
			return null;
		DLNode<Integer> q = null;
		while (head != null && head.k == k) {
			q = head;
			head = head.next;
			head.prev = null;
			q.next = null;
			q = head;
			isFound = true;
		}
		DLNode<Integer> node = head.next;
		DLNode<Integer> prev = head;

		for (; node != null; prev = node, node = node.next) {
			if (node.k == k) {
				q = node;
				prev.next = q.next;
				if (q.next != null) // is q is the last node
					q.next.prev = q.prev;
				q.next = null;
				q = null;
				node = prev;
				isFound = true;
			}
		}

		if (isFound)
			System.out.println("\nall: " + k + ": is deleted");
		else
			System.out.println(k + ": is not found");
		return head;
	}

	/* delete first occurrence */
	@Override
	public DLNode<Integer> deleteNodeLastK(DLNode<Integer> head, Integer k) {

		boolean isFound = false;
		DLNode<Integer> prev, prevK, q;
		q = prev = head;
		prevK = null;
		for (; q != null; prev = q, q = q.next) {
			if (q.k == k)
				prevK = prev;
		}
		if (prevK == head) {
			head = head.next;
			head.prev = null;
			prevK.next = null;
			prevK = null;
			isFound = true;
		} else if (prevK != null) {
			DLNode<Integer> temp = prevK.next;
			prevK.next = temp.next;
			if (temp.next != null)// if temp is the last node
				temp.next.prev = temp.prev;
			temp.prev = null;
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

	/** 3. Reverse a Doubly Linked List **/
	/* iterative way to reverse */
	@Override
	public DLNode<Integer> reverseIterative(DLNode<Integer> head) {

		DLNode<Integer> p = head;
		DLNode<Integer> t = null;

		while (p != null) {
			t = p.prev;
			p.prev = p.next;
			p.next = t;
			p = p.prev;
		}
		return t.prev;
	}

	/* recursive way to reverse */
	@Override
	public DLNode<Integer> reverseRecursive(DLNode<Integer> node) {
		if (node == null || node.next == null)
			return node;

		DLNode<Integer> newNode = reverseRecursive(node.next);
		newNode.prev = null;
		node.next.next = node;
		node.prev = node.next;
		node.next = null;
		return newNode;
	}

	/** 4. The Great Tree-List Recursion Problem. **/
	public BTNode<Integer> bstToList(BTNode<Integer> k) {

		BTNode<Integer> node = util.bstToListUtils(k);
		while (node.lt != null)
			node = node.lt;
		return node;
	}

	/** 5. Copy a linked list with next and arbit pointer **/
	/* create random pointer list */
	@Override
	public DLNode<Integer> createRandomPointerList(Integer[] k) {

		Lap<DLNode<Integer>, DLNode<Integer>> lap = insertArrLast(null, k);

		DLNode<Integer> head = lap.getHead();
		DLNode<Integer> tail = lap.getTail();

		head.prev = head.next.next;
		head.next.prev = head;
		head.next.next.prev = tail;
		tail.next = head.next;
		head.next.next.next.prev = head.next.next;

		return head;
	}

	/* clone random pointer list */
	@Override // TODO
	public DLNode<Integer> cloneRandomPointerList(DLNode<Integer> h) {

		/*
		 * DLNode<Integer> cloneHead = null; DLNode<Integer> cloneTail = null;
		 * DLNode<Integer> p = head; DLNode<Integer> temp = null;
		 * ArrayList<DLNode<Integer>> old = new ArrayList(); ArrayList<DLNode<Integer>>
		 * newly = new ArrayList();
		 * 
		 * Set<DLNode<Integer>> set = new HashSet<>(); for (; !set.contains(p); p =
		 * p.next) { set.add(p); temp = new DLNode<Integer>(p.k); if (cloneHead == null)
		 * { cloneHead = cloneTail = temp; cloneHead.prev = head; newly.add(cloneHead);
		 * } else { cloneTail.next = temp; cloneTail = temp; cloneTail.prev = p;
		 * newly.add(cloneTail); } old.add(p); } // select the corresponding node of x
		 * in newly list //and point to for (int i = 0; i < old.size(); i++) {
		 * DLNode<Integer> x = old.get(i); DLNode<Integer> y = newly.get(i); y.prev.prev
		 * = newly.get(x.prev.k); } return cloneHead;
		 */
		return null;
	}

	/** 6. QuickSort on Doubly Linked List **/
	@Override
	public DLNode<Integer> partitation(DLNode<Integer> h, DLNode<Integer> t) {

		// set pivot as h element
		Integer x = t.k;

		// similar to i = l-1 for array implementation
		DLNode<Integer> i = h.prev;

		// Similar to "for (int j = l; j <= h- 1; j++)"
		for (DLNode<Integer> j = h; j != t; j = j.next) {
			if (j.k <= x) {
				// Similar to i++ for array
				i = (i == null) ? h : i.next;
				int temp = i.k;
				i.k = j.k;
				j.k = temp;
			}
		}
		i = (i == null) ? h : i.next; // Similar to i++
		int temp = i.k;
		i.k = h.k;
		h.k = temp;
		return i;
	}

	@Override
	public void quickSort(DLNode<Integer> h, DLNode<Integer> t) {
		if (h != null && h != t && h != t.next) {
			DLNode<Integer> tmp = partitation(h, t);
			quickSort(h, tmp.prev);
			quickSort(tmp.next, t);
		}
	}

	/** 7. Swap Kth node from beginning with Kth node from end in a Linked List **/
	public DLNode<Integer> swapKthNodeFromBegAndEnd(DLNode<Integer> head, int k) {
		int n = 1;
		DLNode<Integer> x, y;
		x = y = head;
		while (y.next != null) {
			n++;
			y = y.next;
		}

		// Check if k is valid
		if (n < k)
			return head;

		// If x (kth node from start) and y(kth node from end)
		// are same
		if (2 * k - 1 == n)
			return head;
		int c = 1;
		while (c != k) {
			x = x.next;
			y = y.prev;
			c++;
		}
		DLNode<Integer> xprev, xnext, yprev, ynext;
		xprev = xnext = yprev = ynext = null;

		xprev = x.prev;
		xnext = x.next;
		yprev = y.prev;
		ynext = y.next;

		if (xprev != null && ynext != null) {
			xprev.next = yprev.next;
			y.prev = xprev;
			y.next = xnext;
			xnext.prev = y;

			yprev.next = x;
			x.prev = yprev;
			x.next = ynext;
			ynext.prev = x;
		} else// swaping data
		{
			int temp = x.k;
			x.k = y.k;
			y.k = temp;
		}
		return head;

	}

	/** 8. Merge Sort for Doubly Linked List **/

	/* get middle node of list */
	@Override
	public DLNode<Integer> getMiddle(DLNode<Integer> k) {
		if (k == null)
			return k;
		DLNode<Integer> slow = k;
		DLNode<Integer> fast = k.next;

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
	public DLNode<Integer> sortedMerge(DLNode<Integer> k1, DLNode<Integer> k2) {

		DLNode<Integer> result = null;
		DLNode<Integer> temp = null;
		if (k1 == null)
			return k2;
		if (k2 == null)
			return k1;

		if (k1.k <= k2.k) {
			result = k1;
			temp = sortedMerge(k1.next, k2);
			result.next = temp;
			temp.prev = result;
		} else {
			result = k2;
			temp = sortedMerge(k1, k2.next);
			result.next = temp;
			temp.prev = result;
		}
		return result;
	}

	/* merge sort of list */
	@Override
	public DLNode<Integer> mergeSort(DLNode<Integer> k) {
		if (k == null || k.next == null)
			return k;
		DLNode<Integer> middle = getMiddle(k);
		DLNode<Integer> nextMiddle = middle.next;

		middle.next = null;
		nextMiddle.prev = null;
		DLNode<Integer> left = mergeSort(k);
		DLNode<Integer> right = mergeSort(nextMiddle);
		DLNode<Integer> sortedList = sortedMerge(left, right);
		return sortedList;
	}

	/** 9. Create a Doubly Linked List from a Ternary Tree **/

	@Override
	public void printTTree(TTreeNode<Integer> node) {

		Queue<TTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TTreeNode<Integer> x = queue.poll();
			System.out.print(x.dt + "->");
			if (x.lt != null)
				queue.add(x.lt);
			if (x.md != null)
				queue.add(x.md);
			if (x.rt != null)
				queue.add(x.rt);
		}
	}

	@Override
	public TTreeNode<Integer> createTernaryTree(TTreeNode<Integer> node, int key) {
		if (node == null)
			node = new TTreeNode<Integer>(key);
		else if (node.lt == null || node.md == null || node.rt == null) {
			if (node.lt == null)
				node.lt = createTernaryTree(node.lt, key);
			else if (node.md == null)
				node.md = createTernaryTree(node.md, key);
			else if (node.rt == null)
				node.rt = createTernaryTree(node.rt, key);
		} else {
			if (node.lt != null)
				createTernaryTree(node.lt, key);
			else if (node.md != null)
				createTernaryTree(node.md, key);
			else if (node.rt != null)
				createTernaryTree(node.rt, key);
		}

		return node;
	}

	public TTreeNode<Integer> createFromTernaryTree(TTreeNode<Integer> root) {

		TTreeNode<Integer> node = root;
		TTreeNode<Integer> tail = null;
		Queue<TTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TTreeNode<Integer> x = queue.poll();
			if (x.lt != null)
				queue.add(x.lt);
			if (x.md != null)
				queue.add(x.md);
			if (x.rt != null)
				queue.add(x.rt);

			if (tail == null) {
				tail = x;
				x.lt = x.rt = x.md = null;
			} else {
				tail.rt = x;
				x.lt = tail;
				x.md = x.rt = null;
				tail = x;
			}

		}
		return root;
	}

	public void printTTOfDl(TTreeNode<Integer> node) {
		while (node != null) {
			System.out.print(node.dt + "->");
			node = node.rt;
		}
	}

	/** 10. Find pairs with given sum in doubly linked list **/
	@Override // O(nlogn) use hashig O(logn)
	public List<List<DLNode<Integer>>> pairOfGivenSum(DLNode<Integer> head, int x) {

		head = mergeSort(head);
		List<List<DLNode<Integer>>> ll = null;
		List<DLNode<Integer>> l = null;
		// and second to the end of DLL.
		DLNode<Integer> first = head;
		DLNode<Integer> second = head;
		while (second.next != null)
			second = second.next;

		while (first != null && second != null && first != second && second.next != first) {
			// pair found
			if (first.k + second.k == x) {

				if (ll == null)
					ll = new ArrayList<>();
				l = new ArrayList<>();
				l.add(first);
				l.add(second);
				ll.add(l);
				first = first.next;
				second = second.prev;
			} else {
				if ((first.k + second.k) < x)
					first = first.next;
				else
					second = second.prev;
			}
		}
		return ll;
	}

	/** 11. Insert value in sorted way in a sorted doubly linked list **/
	@Override
	public DLNode<Integer> insertArrSorted(DLNode<Integer> head, Integer k[]) {

		for (int i = 0; i < k.length; i++) {
			DLNode<Integer> temp = new DLNode<Integer>(k[i]);
			if (head == null) {
				head = tail = temp;
			} else if (k[i] <= head.k) { // = applied later
				temp.next = head;
				head.prev = temp;
				head = temp;
			} else {
				DLNode<Integer> p = head;
				while (p.next != null) {
					if (k[i] <= p.next.k) { // = applied later
						temp.next = p.next;
						p.next = temp;
						temp.prev = p;
						temp.next.prev = temp;
						break;
					}
					p = p.next;
				}
				// add to last node
				if (p.next == null) {
					p.next = temp;
					temp.prev = p;
				}
			}
		}
		return head;
	}

	/** 12. Delete a Doubly Linked List node at a given position **/
	public DLNode<Integer> deletePos(DLNode<Integer> head, int pos) {

		if (pos < 1)
			return head;

		if (head != null) {
			DLNode<Integer> q = null;
			if (pos == 1) {
				q = head;
				head = head.next;
				if (head != null) // if only one node
					head.prev = null;
				q.next = null;
				q = null;
			} else {
				DLNode<Integer> p = head;
				for (int i = 1; i < pos - 1; i++, p = p.next)
					;
				/* p.next is the deleting node */
				if (p != null && p.next != null) {
					q = p.next;
					p.next = q.next;
					if (q.next != null) // last node
						q.next.prev = q.prev;
					q.next = q.prev = null;
					q = null;
				} else {
					System.out.println("\n position :" + pos + " is out of list");
				}
			}
		}
		return head;
	}

	/**
	 * 13. Count triplets in a sorted doubly linked list whose sum is equal to a
	 * given value x
	 **/
	// function to count pairs whose sum equal to given 'value'
	@Override
	public int countPairs(DLNode<Integer> first, DLNode<Integer> second, int value) {
		int count = 0;

		while (first != null && second != null && first != second && second.next != first) {

			// pair found
			if (first.k + second.k == value) {
				count++;
				first = first.next;
				second = second.prev;
			}

			else if ((first.k + second.k) > value)
				second = second.prev;
			else
				first = first.next;
		}
		return count;
	}

	@Override
	public int tripletROfGivenSum(DLNode<Integer> head, int x) {
		// if list is empty
		if (head == null)
			return 0;

		DLNode<Integer> current, first, last;
		int count = 0;

		last = head;
		while (last.next != null)
			last = last.next;

		// traversing the doubly linked list
		for (current = head; current != null; current = current.next) {
			first = current.next;
			count += countPairs(first, last, x - current.k);
		}
		// required count of triplets
		return count;
	}

	/** 14. Remove duplicates from a sorted doubly linked list **/
	@Override
	public DLNode<Integer> removeDuplicate(DLNode<Integer> head) {

		DLNode<Integer> prev, p = head.next;
		prev = head;
		DLNode<Integer> temp = null;
		while (p != null) {
			if (prev.k.equals(p.k)) {
				if (p.next == null)// ie last node
				{
					p.prev = null;
					prev.next = null;
					p = null;
					break;
				}
				temp = p;
				prev.next = temp.next;
				temp.next.prev = prev;
				temp.prev = temp.next = null;
				temp = null;
				p = prev;// since p is deleted
			}
			prev = p;
			p = p.next;
		}
		return head;
	}

	/** 15. Delete all occurrences of a given key in a doubly linked list **/
	@Override
	public DLNode<Integer> deleteAllOccuranceOfX(DLNode<Integer> head, int x) {

		DLNode<Integer> prev, p;
		prev = head;
		DLNode<Integer> temp = null;
		while (prev != null && prev.k.equals(x)) {
			temp = prev;
			prev = prev.next;
			prev.prev = null;
			temp.next = null;
			temp = null;
		}
		head = prev;
		// all node or except one deleted
		if (prev == null || prev.next == null)
			return head;

		p = prev.next;
		while (p != null) {
			if (p.k.equals(x)) {
				if (p.next == null)// ie last node
				{
					p.prev = null;
					prev.next = null;
					p = null;
					break;
				}
				temp = p;
				prev.next = temp.next;
				temp.next.prev = prev;
				temp.prev = temp.next = null;
				temp = null;
				p = prev;// since p is deleted
			}
			prev = p;
			p = p.next;
		}
		return head;
	}

	/** 16. Remove duplicates from an unsorted doubly linked list **/
	@Override // O(nlogn)
	public DLNode<Integer> remveDuplicateFromNonSotedList(DLNode<Integer> head) {

		head = mergeSort(head);
		return removeDuplicate(head);
	}

	/** 17. Sort the biotonic doubly linked list **/
	@Override
	public DLNode<Integer> sortBitonicList(DLNode<Integer> head) {

		if (head == null || head.next == null)
			return head;

		DLNode<Integer> current = head.next;

		while (current != null) {
			if (current.k < current.prev.k)
				break;
			current = current.next;
		}

		// if true, then list is already sorted
		if (current == null)
			return head;

		// spilt into two lists, one starting with 'head'
		// and other starting with 'current'
		current.prev.next = null;
		current.prev = null;

		// reverse the list starting with 'current'
		current = reverseRecursive(current);

		// merge the two lists and return the
		// final merged doubly linked list
		return sortedMerge(head, current);
	}

	/** 18. Sort a k sorted doubly linked list **/
	// function to sort a k sorted doubly linked list
	public static Comparator<DLNode<Integer>> idComparator = new Comparator<DLNode<Integer>>() {
		@Override
		public int compare(DLNode<Integer> p1, DLNode<Integer> p2) {
			return p1.k - p2.k;
		}
	};

	public DLNode<Integer> sortAKSortedDLL(DLNode<Integer> head, int k) {
		// if list is empty
		if (head == null)
			return head;

		Queue<DLNode<Integer>> pq = new PriorityQueue<DLNode<Integer>>(idComparator);

		DLNode<Integer> last, newHead = null;
		last = null;
		// Create a Min Heap of first (k+1) elements from
		// input doubly linked list
		for (int i = 0; head != null && i <= k; i++) {
			// push the node on to 'pq'
			pq.add(head);
			head = head.next;
		}
		while (!pq.isEmpty()) {
			if (newHead == null) {
				newHead = pq.peek();
				newHead.prev = null;
				last = newHead;
			}

			else {
				last.next = pq.peek();
				pq.peek().prev = last;
				last = pq.peek();
			}
			pq.poll();
			if (head != null) {
				pq.add(head);
				head = head.next;
			}
		}
		last.next = null;
		return newHead;
	}

	/**
	 * Below question get collcted from ISLinkLIst
	 ******************************************************/
	/** 50. Clone a linked list with next and random pointer | Set 2 **/
	//incomplete testing
	public DLNode<Integer> arbitrarylist(DLNode<Integer> h) {
		DLNode<Integer> p = h;
		while (p.next != null) {
			p.prev = p.next;
			p = p.next;
		}
		p.prev = h;
		return h;
	}

	// clone and arrange the back pointer//incomplete testing
	public DLNode<Integer> cloneList(DLNode<Integer> h) {
		DLNode<Integer> p = h;
		DLNode<Integer> q, r;
		LinkedHashSet<DLNode<Integer>> set = new LinkedHashSet<>();
		while (p != null) {
			if (set.contains(p))
				break;
			set.add(p);
			p = p.next;
		}
		@SuppressWarnings("unchecked")
		DLNode<Integer> arr[] = new DLNode[set.size()];
		arr = set.toArray(arr);
		p = q = arr[0];
		r = null;

		for (int i = 0; i < arr.length; i++) {
			q.prev = r;
			q = q.next;
			r = q;
		}
		q.next = null;
		return p;

	}

	/*************************************************Analysis*************************************************************************/
	/*************************************************Analysis*************************************************************************/
	public DLNode<Integer> swapPairWiseFromHeadRcv(DLNode<Integer> node){

		if(node==null || node.next==null)
			return node;
		DLNode<Integer> x=node;
		DLNode<Integer> y=node.next;

		if(x.prev!=null)
			x.prev.next=y;
		x.next=y.next;
		if(x.next!=null)
			x.next.prev=x;

		y.prev=x.prev;

		x.prev=y;
		y.next=x;
		swapPairWiseFromHeadRcv(node.next);
		return node.prev;
	}

	@Override
	public DLNode<Integer> swapPairWiseFromTailRcv(DLNode<Integer> node){

		if(length(node)%2==0)
			return swapPairWiseFromHeadRcv(node);
		swapPairWiseFromHeadRcv(node.next);
		return node;
	}

	public int length(DLNode<Integer> node){
		if(node==null)
			return 0;
		return 1+length(node.next);
	}
}
