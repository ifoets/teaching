package com.design.analysis.ds.linklist;

import java.util.List;

import com.design.analysis.ds.common.Point;
import com.design.analysis.ds.linklist.node.FlatLNode;
import com.design.analysis.ds.linklist.node.PointNode;
import com.design.analysis.ds.linklist.node.SLNode;
import com.design.analysis.ds.linklist.utils.Lap;

/*
 * Singly Linked List :
1.	Introduction to Linked List(no code)
2.	Linked List vs Array(node code)
3.	Linked List Insertion
4.	Linked List Deletion (Deleting a given key)
5.	Linked List Deletion (Deleting a key at given position)
6.	Find Length of a Linked List (Iterative and Recursive)
7.	Search an element in a Linked List (Iterative and Recursive)
8.	Swap nodes in a linked list without swapping data
9.	Write a function to get Nth node in a Linked List
10.	Print the middle of a given linked list
11.	Nth node from the end of a Linked List
12.	Write a function to delete a Linked List
13.	Write a function that counts the number of times a given int occurs in a Linked List
14.	Reverse a linked list
15.	Detect loop in a linked list
16.	Merge two sorted linked lists
17.	Generic Linked List in C
18.	Function to check if a singly linked list is palindrome
19.	Intersection point of two Linked Lists.
20.	Recursive function to print reverse of a Linked List
21.	Remove duplicates from a sorted linked list
22.	Remove duplicates from an unsorted linked list
23.	Pairwise swap elements of a given linked list
24.	Move last element to front of a given Linked List
25.	Intersection of two Sorted Linked Lists
26.	Delete alternate nodes of a Linked List
27.	Alternating split of a given Singly Linked List
28.	Identical Linked Lists
29.	Merge Sort for Linked Lists
30.	Reverse a Linked List in groups of given size
31.	Reverse alternate K nodes in a Singly Linked List
32.	Delete nodes which have a greater value on right side
33.	Segregate even and odd nodes in a Linked List
34.	Detect and Remove Loop in a Linked List
35.	Add two numbers represented by linked lists | Set 1
36.	Delete a given node in Linked List under given constraints
37.	Union and Intersection of two Linked Lists
38.	Find a triplet from three linked lists with sum equal to a given number
39.	Rotate a Linked List
40.	Flattening a Linked List
41.	Add two numbers represented by linked lists | Set 2
42.	Sort a linked list of 0s, 1s and 2s
43.	Flatten a multilevel linked list
44.	Delete N nodes after M nodes of a linked list
45.	QuickSort on Singly Linked List
46.	Merge a linked list into another linked list at alternate positions
47.	Pairwise swap elements of a given linked list by changing links
48.	Given a linked list of line segments, remove middle points
49.	Clone a linked list with next and random pointer | Set 1
50.	Clone a linked list with next and random pointer | Set 2
51.	Insertion Sort for Singly Linked List
52.	Point to next higher value node in a linked list with an arbitrary pointer
53.	Rearrange a given linked list in-place.
54.	Sort a linked list that is sorted alternating ascending and descending orders.
55.	Select a Random Node from a Singly Linked List
56.	Merge two sorted linked lists such that merged list is in reverse order
57.	Compare two strings represented as linked lists
58.	Rearrange a linked list such that all even and odd positioned nodes are together
59.	Rearrange a Linked List in Zig-Zag fashion
60.	Add 1 to a number represented as linked list
61.	Point arbit pointer to greatest value right side node in a linked list
62.	Merge two sorted linked lists such that merged list is in reverse order
63.	Check if a linked list of strings forms a palindrome
64.	Sort linked list which is already sorted on absolute values
65.	Delete last occurrence of an item from linked list
66.	Delete a Linked List node at a given position
67.	Linked List in java
68.	In-place Merge two linked lists without changing links of first list
69.	Delete middle of linked list
70.	Merge K sorted linked lists | Set 1
71.	Decimal Equivalent of Binary Linked List
72.	Flatten a multi-level linked list | Set 2 (Depth wise)
73.	Rearrange a given list such that it consists of alternating minimum maximum elements
74.	Subtract Two Numbers represented as Linked Lists
75.	Find pair for given sum in a sorted singly linked without extra space
76.	Iteratively Reverse a linked list using only 2 pointers (An Interesting Method)
77.	Partitioning a linked list around a given value and keeping the original order
78.	Check linked list with a loop is palindrome or not
79.	Clone a linked list with next and random pointer in O(1) space
80.	Length of longest palindrome list in a linked list using O(1) extra space
81.	Adding two polynomials using Linked List
82.	Implementing Iterator pattern of a single Linked List
83.	Move all occurrences of an element to end in a linked list
84.	Remove all occurrences of duplicates from a sorted Linked List
85.	Remove every k-th node of the linked list
86.	Check whether the length of given linked list is Even or Odd
87.	Union and Intersection of two linked lists | Set-2 (Using Merge Sort)
88.	Multiply two numbers represented by Linked Lists
89.	Union and Intersection of two linked lists | Set-3 (Hashing)
90.	Find the sum of last n nodes of the given Linked List
91.	Count pairs from two linked lists whose sum is equal to a given value
92.	Merge k sorted linked lists | Set 2 (Using Min Heap)
93.	Recursive selection sort for singly linked list | Swapping node links
94.	Find length of loop in linked list
95.	Reverse a Linked List in groups of given size | Set 2
96.	Insert node into the middle of the linked list
97.	Merge two sorted lists (in-place)
98.	Sort a linked list of 0s, 1s and 2s by changing links
99.	Insert a node after the n-th node from the end
100.	Rotate Linked List block wise
101.	Count rotations in sorted and rotated linked list
102.	Make middle node head in a linked list

 */
public interface ISLinkList<K> {
	/** 3. Linked List Insertion **/
	/* insert collection of element */
	public Lap<SLNode<K>, SLNode<K>> insertArrLast(Lap<SLNode<K>, SLNode<K>> lap, K k[]);

	/* insert single element */
	public Lap<SLNode<K>, SLNode<K>> insertElementLast(Lap<SLNode<K>, SLNode<K>> lap, K k);

	/* insert collection of element in sorted order */
	public SLNode<K> insertArrSorted(SLNode<K> head, K k[]);

	/* insert at given position head is at 1st position */
	public SLNode<K> insertAtPosition(SLNode<K> head, int pos, K k);

	/* print the list */
	public void printList(SLNode<K> node);

	/** 4. Linked List Deletion (Deleting a given key) **/
	/* delete the first occurrence of k */
	public SLNode<K> deleteFirstK(SLNode<K> head, K k);

	/* . Linked List Deletion (Deleting a given key) */
	public SLNode<K> deleteAllX(SLNode<K> head, K k);

	/* delete the last occurrence of node */
	public SLNode<K> deleteLastK(SLNode<K> head, K k);

	/** 5. Linked List Deletion (Deleting a key at given position) **/
	public SLNode<K> deletePos(SLNode<K> head, int pos);

	/** 6. Find Length of a Linked List (Iterative and Recursive) **/
	/* Iterative */
	public int lengthIterative(SLNode<K> head);

	/* Recursive */
	public int lengthRecursive(SLNode<K> head);

	/** 7. Search an element in a Linked List (Iterative and Recursive) **/
	/* Iterative */
	public SLNode<K> searchIterative(SLNode<K> head, K k);

	/* Recursive */
	public SLNode<K> searchRecursive(SLNode<K> head, K k);

	/** 8. Swap nodes in a linked list without swapping data **/
	public SLNode<K> swapNodes(SLNode<K> head, K x, K y);

	/** 9. Write a function to get Nth node in a Linked List head 1st node **/
	public SLNode<K> getNthNode(SLNode<K> head, int n);

	/** 10. Print the middle of a given linked list **/
	public List<SLNode<K>> getMiddelNodes(SLNode<K> k);

	/** 11. Nth node from the end of a Linked List **/
	public SLNode<K> nthNodeFromEnd(SLNode<K> k, int n);

	/** 12. Write a function to delete a Linked List **/
	public void deleteList(SLNode<K> k);

	/** 13. counts the number of times a given int occurs **/
	public Integer countXValNodes(SLNode<K> k, int x);

	/** 14. Reverse a linked list recursive **/
	public SLNode<K> reverseRcv(SLNode<K> k);

	/** 15. Detect loop in a linked list **/
	/* create list that captain loop by mistake */
	public SLNode<K> linkContainLoop(SLNode<K> head, K[] k);

	/* detect and then remove loop in list if any */
	public SLNode<K> detectAndRemoveLoop(SLNode<K> k);

	/** 16. Merge two sorted linked lists **/
	public SLNode<K> mergeTwoSotedList(SLNode<K> k1, SLNode<K> k2);

	/** 17. Generic Linked List in java :all ready done on 3. **/

	/** 18. Function to check if a singly linked list is palindrome **/
	public boolean isPalindrome(SLNode<K> k);

	/** 19. Intersection point of two Linked Lists. **/
	public SLNode<K> intersectionNode(SLNode<K> k1, SLNode<K> k2);

	/** 19. Intersection point of two Linked Lists. **/
	public SLNode<K> intersectionNodeX(SLNode<K> k1, SLNode<K> k2);

	/** 20. Recursive function to print reverse of a Linked List **/
	public void reversePrintRcv(SLNode<K> k);

	/** 21. Remove duplicates from a sorted linked list **/
	public SLNode<K> removeDupicateSortedList(SLNode<K> k);
	
	public SLNode<K> removeDupicateSortedListX(SLNode<K> k);

	/** 22. Remove duplicates from an unsorted linked list **/
	public SLNode<K> removeDupicateUnSortedList(SLNode<K> k);

	/** 23. Pairwise swap elements of a given linked list **/
	public SLNode<K> swapPairwise(SLNode<K> k);

	public SLNode<K> swapPairwiseX(SLNode<K> k);

	/** 24. Move last element to front of a given Linked List **/
	public SLNode<K> moveLastToFirst(SLNode<K> k);

	/** 25. Intersection of two Sorted Linked Lists **/
	public SLNode<K> intersectionOfLists(SLNode<K> k1, SLNode<K> k2);

	/** 26. Delete alternate nodes of a Linked List **/
	public SLNode<K> deleteAlternative(SLNode<K> k);

	/** 27. Alternating split of a given Singly Linked List **/
	public Lap<SLNode<K>, SLNode<K>> alternativeSplit(SLNode<K> k);

	public Lap<SLNode<K>, SLNode<K>> alternativeSplitX(SLNode<K> k);

	/** 28. Identical Linked Lists **/
	public boolean isListsIdentical(SLNode<K> k1, SLNode<K> k2);

	/** 29. Merge Sort for Linked Lists **/
	public SLNode<K> mergeSort(SLNode<K> k);

	/* get middle node of list */
	public SLNode<K> getMiddle(SLNode<K> k);

	/* merge two sorted list */
	public SLNode<K> sortedMerge(SLNode<K> k1, SLNode<K> k2);

	/** 30. Reverse a Linked List in groups of given size..reverse every k nodes **/
	public SLNode<K> reverseGroupOfN(SLNode<K> k, Integer n);

	/** 31. Reverse alternate K nodes in a Singly Linked List **/
	public SLNode<K> reverseAlternateN(SLNode<K> k, Integer n);

	/** 32. Delete nodes which have a greater value on right side **/
	public SLNode<Integer> delLesserNodes(SLNode<K> k);

	public SLNode<K> deleteRightGreaterVal(SLNode<K> k);

	/** 33. Segregate even and odd nodes in a Linked List **/
	public Lap<SLNode<K>, SLNode<K>> seperateOddEvenList(SLNode<K> k);

	/** 34. Detect and Remove Loop in a Linked List **/
	public SLNode<K> isLoopInList(SLNode<K> k);

	public SLNode<K> dectedAndRemoveLoopInList(SLNode<K> k);

	/** 35. Add two numbers represented by linked lists | Set 1 **/
	public SLNode<Integer> addTwoNoRepesentByList(SLNode<K> k1, SLNode<K> k2);

	/** 36. Delete a given node in Linked List under given constraints **/
	public SLNode<K> deleteNode(SLNode<K> head, SLNode<K> delNode);

	/** 37. Union and Intersection of two Linked Lists **/
	public SLNode<K> unionOfLists(SLNode<K> k1, SLNode<K> k2);

	public SLNode<K> intersectionOfListsX(SLNode<K> k1, SLNode<K> k2);

	/** 38. Find a triplet from linked lists with sum equal to a given number **/
	public SLNode<K> sortList(SLNode<K> k);

	public List<List<Integer>> tripletInList(SLNode<K> a, SLNode<K> b, SLNode<K> c, int sum);

	/** 39. Rotate a Linked List **/
	public SLNode<Integer> rotateList(SLNode<K> k, int noOfRotation, boolean isClockWise);

	/** 40. Flattening a Linked List **/
	public FlatLNode<K> insertDownFlatList(FlatLNode<K> node, K k);

	public FlatLNode<K> makeFlatList(List<FlatLNode<K>> list);

	public FlatLNode<K> merge(FlatLNode<K> k1, FlatLNode<K> k2);

	public FlatLNode<K> flattern(FlatLNode<K> k);

	public void displayFlatternList(FlatLNode<K> k);

	public void printListDown(FlatLNode<K> node);

	/** 41. Add two numbers represented by linked lists | Set 2 **/
	// @see @35. in this list only

	/** 42. Sort a linked list of 0s, 1s and 2s **/
	public SLNode<K> sort0s1s2sList(SLNode<K> k);

	/** 43. Flatten a multilevel linked list **/
	public FlatLNode<K> insertNextFlatList(FlatLNode<K> node, K k);

	public FlatLNode<K> multiFlattern(FlatLNode<K> k);

	public void printListNext(FlatLNode<K> node);

	/** 44. Delete N nodes after M nodes of a linked list **/
	public SLNode<K> deleteNnodesAfterMNodes(SLNode<K> k, int m, int n);

	/** 45. QuickSort on Singly Linked List **/
	public SLNode<K> getTail(SLNode<K> k);

	public List<SLNode<Integer>> partition(SLNode<K> h, SLNode<K> t, SLNode<K> nh, SLNode<K> nt);

	public SLNode<K> quickSortOnList(SLNode<K> k, SLNode<K> t);

	/** 46. Merge a linked list into another linked list at alternate positions **/
	public SLNode<K> mergeAtAlternativePos(SLNode<K> k1, SLNode<K> k2);

	/** 47. Pairwise swap elements of a given linked list by changing links **/
	public SLNode<K> pairwiseSwapUseLink(SLNode<K> k);

	/** 48. Given a linked list of line segments, remove middle points **/
	public PointNode insertLineLink(PointNode head, Point p);

	public PointNode removeMiddlePointOfLineSegment(PointNode p);

	public void displayPointList(PointNode p);

	/** 49. Clone a linked list with next and random pointer | Set 1 **/
	/** 50. Clone a linked list with next and random pointer | Set 2 **/

	/***********************************************************************************************************************************************************************/
	/* 70. Merge K sorted linked lists | Set 1 */
	/* 71. Decimal Equivalent of Binary Linked List */
	/* 72. Flatten a multi-level linked list | Set 2 (Depth wise) */
	/*
	 * 73. Rearrange a given list such that it consists of alternating minimum
	 * maximum elements
	 */
	/* 74. Subtract Two Numbers represented as Linked Lists */
	/* 75. Find pair for given sum in a sorted singly linked without extra space */
	/*
	 * 76. Iteratively Reverse a linked list using only 2 pointers (An Interesting
	 * Method)
	 */
	/*
	 * 77. Partitioning a linked list around a given value and keeping the original
	 * order
	 */
	/* 78. Check linked list with a loop is palindrome or not */
	/* 79. Clone a linked list with next and random pointer in O(1) space */
	/*
	 * 80. Length of longest palindrome list in a linked list using O(1) extra space
	 */
	/* 81. Adding two polynomials using Linked List */
	/* 82. Implementing Iterator pattern of a single Linked List */
	/* 83. Move all occurrences of an element to end in a linked list */
	/** 84. Remove all occurrences of duplicates from a sorted Linked List **/

	/** 85. Remove every k-th node of the linked list **/
	// travel k-1 pos and keep node in some list and send for delete
	/** 86. Check whether the length of given linked list is Even or Odd **/
	public boolean evenOrOdd(SLNode<K> k);

	/**
	 * 87. Union and Intersection of two linked lists | Set-2 (Using Merge Sort)
	 **/
	public SLNode<K> unionOfListsByMergeSort(SLNode<K> k1, SLNode<K> k2);

	public SLNode<K> intersectionOfListsByMergeSort(SLNode<K> k1, SLNode<K> k2);

	/** 88. Multiply two numbers represented by Linked Lists **/
	public int multiplyTwoLists(SLNode<K> k1, SLNode<K> k2);

	/** 89. Union and Intersection of two linked lists | Set-3 (Hashing) **/
	// @See @37. point
	/** 90. Find the sum of last n nodes of the given Linked List **/
	public int sumOfLastNNodes(SLNode<K> k, int n);

	/**
	 * 91. Count pairs from two linked lists whose sum is equal to a given value
	 **/
	public int countPairOfSum(SLNode<K> k1, SLNode<K> k2, int sum);

	/** 92. Merge k sorted linked lists | Set 2 (Using Min Heap) **/
	public SLNode<K> mergeKsortedList(List<SLNode<K>> list);

	/**
	 * 93. Recursive selection sort for singly linked list | Swapping node links
	 **/
	/* swap two node */
	public SLNode<K> insertAtSorted(SLNode<K> k, SLNode<K> temp);

	public SLNode<K> selectionSortRcv(SLNode<K> k, SLNode<K> p, SLNode<K> pnext);

	/** 94. Find length of loop in linked list **/
	public int lengthOfloop(SLNode<K> k);

	/** 95. Reverse a Linked List in groups of given size | Set 2 **/
	public SLNode<K> reverseInGroup(SLNode<K> k, int gSize);

	/** 96. Insert node into the middle of the linked list **/
	public SLNode<K> insertAtMiddle(SLNode<K> k, K x);

	/** 97. Merge two sorted lists (in-place) **/
	public SLNode<K> merge2SortedList(SLNode<K> k1, SLNode<K> k2);

	/** 98. Sort a linked list of 0s, 1s and 2s by changing links **/
	public SLNode<K> sort0s1s2sListByChangingLink(SLNode<K> k);

	/** 99. Insert a node after the n-th node from the end **/
	public SLNode<K> insertAfterNthNodeFromEnd(SLNode<K> k, int x, int n);

	/** 100. Rotate Linked List block wise **/
	public SLNode<K> blockWiseRotation(SLNode<K> node, int blockSize, int noOfRotation);

	/** 101. Count rotations in sorted and rotated linked list **/
	public int countRotationClkWise(SLNode<K> head);

	/** 102. Make middle node head in a linked list **/
	public SLNode<K> makeMiddleNodeHead(SLNode<K> k);
}
