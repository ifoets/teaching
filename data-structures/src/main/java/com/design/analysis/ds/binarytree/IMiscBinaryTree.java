package com.design.analysis.ds.binarytree;

import java.util.List;
import java.util.Map;

import com.design.analysis.ds.tree.node.BTNode;

/*
 * 
 * @author GuruG
 * 
 * Misc :
1.	Write a program to Delete a Tree
2.	Write a Program to Find the Maximum Depth or Height of a Tree
3.	Write Code to Determine if Two Trees are Identical
4.	Write a program to Calculate Size of a tree
5.	Root to leaf path sum equal to a given number
6.	How to determine if a binary tree is height-balanced?
7.	Diameter of a Binary Tree
8.	Check for Children Sum Property in a Binary Tree
9.	Program to count leaf nodes in a binary tree
10.	The Great Tree-List Recursion Problem
11.	Given a binary tree, print out all of its root-to-leaf paths one per line
12.	Populate Inorder Successor for all nodes
13.	Connect nodes at same level using constant extra space
14.	Connect nodes at same level
15.	Check if a binary tree is subtree of another binary tree | Set 1
16.	Check if a given Binary Tree is SumTree
17.	Print Ancestors of a given node in Binary Tree
18.	Get Level of a node in a Binary Tree
19.	Print nodes at k distance from root
20.	Foldable Binary Trees
21.	Maximum width of a binary tree
22.	Double Tree
23.	Given a binary tree, print all root-to-leaf paths
24.	Linked complete binary tree & its creation
25.	Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution)
26.	Find the maximum sum leaf to root path in a Binary Tree
27.	Vertical Sum in a given Binary Tree | Set 1
28.	Sum of all the numbers that are formed from root to leaf paths
29.	Find next right node of a given key
30.	Deepest left leaf node in a binary tree
31.	Extract Leaves of a Binary Tree in a Doubly Linked List
32.	Remove all nodes which don’t lie in any path with sum>= k
33.	Print Left View of a Binary Tree
34.	Check if all leaves are at same level
35.	Find depth of the deepest odd level leaf node
36.	Difference between sums of odd level and even level nodes of a Binary Tree
37.	Custom Tree Problem
38.	Iterative Method to find Height of Binary Tree
39.	Tree Isomorphism Problem
40.	Check if a binary tree is subtree of another binary tree | Set 2
41.	Find the maximum path sum between two leaves of a binary tree
42.	Threaded Binary Tree
43.	Reverse alternate levels of a perfect binary tree
44.	Print Right View of a Binary Tree
45.	Print all nodes at distance k from a given node
46.	Find distance between two given keys of a Binary Tree
47.	Print all nodes that don’t have sibling
48.	Check if a given Binary Tree is height balanced like a Red-Black Tree
49.	Print all nodes that are at distance k from a leaf node
50.	Find the closest leaf in a Binary Tree
51.	Diagonal Sum of a Binary Tree
52.	Bottom View of a Binary Tree
53.	Print Nodes in Top View of Binary Tree
54.	Serialize and Deserialize an N-ary Tree
55.	Check if a given graph is tree or not
56.	Print nodes between two given level numbers of a binary tree
57.	Find Height of Binary Tree represented by Parent array
58.	Minimum no. of iterations to pass information to all nodes in the tree
59.	Check if two nodes are cousins in a Binary Tree
60.	Find Minimum Depth of a Binary Tree
61.	Maximum Path Sum in a Binary Tree
62.	Expression Tree
63.	Iterative Search for a key ‘x’ in Binary Tree
64.	Find maximum (or minimum) in Binary Tree
65.	Find sum of all left leaves in a given Binary Tree
66.	Remove nodes on root to leaf paths of length < K

 */
public interface IMiscBinaryTree<T> {

	/** 1. Write a program to Delete a Tree **/
	public BTNode<T> deleteTree(BTNode<T> t);

	/** 2. Write a Program to Find the Maximum Depth or Height of a Tree **/
	public int maxHeightOrDepth(BTNode<T> t);

	/** 3. Write Code to Determine if Two Trees are Identical **/
	public boolean isTwoTreeIdentical(BTNode<T> t1, BTNode<T> t2);

	/** 4. Write a program to Calculate Size of a tree **/
	public int sizeOfTree(BTNode<T> t);

	/** 5. Root to leaf path sum equal to a given number **/
	public boolean rootToLeavPathSum(BTNode<T> node, int number);

	public boolean pathWiseSum(BTNode<T> node, int[] path, int size, int number);

	public boolean validate(int[] a, int size, int element);

	/** 6. How to determine if a binary tree is height-balanced? **/
	public boolean isBalanced(BTNode<T> t);

	/** 7. Diameter of a Binary Tree **/
	public int diameter(BTNode<T> t);

	/** 8. Check for Children Sum Property in a Binary Tree **/
	public boolean isChildrenSum(BTNode<T> t);

	/** 9. Program to count leaf nodes in a binary tree **/
	public int countLeafNode(BTNode<T> t);

	/** 10. The Great Tree-List Recursion Problem **/
	// @See IBTUtils.java...bstToListUtils(....)
	/**
	 * 11. Given a binary tree, print out all of its root-to-leaf paths one per line
	 **/
	public void printAllPathPerLine(BTNode<T> t);

	public void pathWisePrint(BTNode<Integer> node, int[] path, int size);

	public void printArray(int[] a, int size);

	/** 12. Populate Inorder Successor for all nodes **/
	public void populateNext(BTNode<T> t);

	public void printSuccConnected(BTNode<T> t);

	/** 13. Connect nodes at same level using constant extra space **/
	public void connectLevelNodes(BTNode<T> t);

	public void printLevelConnect(BTNode<T> t);

	/** 14. Connect nodes at same level **/
	public void connectLevelNodesRec(BTNode<T> t);

	/** 15. Check if a binary tree is subtree of another binary tree | Set 1 **/
	public boolean isSubtree(BTNode<T> main, BTNode<T> sub);

	public boolean isOverlap(BTNode<T> main, BTNode<T> sub);

	public boolean isOverlapTree(BTNode<T> t1, BTNode<T> t2);

	/** 16. Check if a given Binary Tree is SumTree **/
	public boolean isSumTree(BTNode<T> t);

	/** 17. Print Ancestors of a given node in Binary Tree **/
	public void printAllAncestor(BTNode<T> t, int key);

	/** 18. Get Level of a node in a Binary Tree **/
	public int levelOfNode(BTNode<T> node, int k);

	/** 19. Print nodes at k distance from root **/
	public void printKdistNode(BTNode<T> root, int k);

	/** 20. Foldable Binary Trees **/
	public boolean isFoldable(BTNode<T> node);

	public boolean isFoldableX(BTNode<T> node);

	public boolean leftRightFoldable(BTNode<T> a, BTNode<T> b);

	/** 21. Maximum width of a binary tree **/
	public int maxWidth(BTNode<T> t);

	public int longestPathLen(BTNode<T> t);

	/** 22. Double Tree **/
	public void doubleTree(BTNode<T> t);
	/** 23. Given a binary tree, print all root-to-leaf paths **/
	// @See 11. problem

	/** 24. Linked complete binary tree & its creation **/
	/*
	 * this is create complete binary tree @See BinaryTreeUtil.java...create(....)
	 */
	/**
	 * 25. Check whether a given Binary Tree is Complete or not | Set 1 (Iterative
	 * Solution)
	 **/
	public boolean isCompletBinrayTree(BTNode<T> t);

	/** 26. Find the maximum sum leaf to root path in a Binary Tree **/
	public int maxSumRootToLeaf(BTNode<T> t);

	public void getTargetLeaf(BTNode<T> node, int maxSum, int currSum);

	/** 27. Vertical Sum in a given Binary Tree | Set 1 **/
	public Map<Integer, Integer> getVerticalSum(BTNode<T> t);

	/** 28. Sum of all the numbers that are formed from root to leaf paths **/
	public List<Integer> sumOfPathLeafToRoot(BTNode<T> t);

	public List<Integer> getRootToLeafSum(BTNode<Integer> node, int sum);

	/** 29. Find next right node of a given key **/
	public BTNode<T> nextRightNode(BTNode<T> t, T key);

	public BTNode<T> nextRightKthNode(BTNode<T> t, T key, int k);

	public BTNode<T> nextLeftKthNode(BTNode<T> t, T key, int k);

	/** 30. Deepest left leaf node in a binary tree **/
	public BTNode<T> deepestLeftNode(BTNode<T> t);

	/** 31. Extract Leaves of a Binary Tree in a Doubly Linked List **/
	public BTNode<T> extractLeafNodeAsList(BTNode<T> t);

	/** 32. Remove all nodes which don’t lie in any path with sum>= k */
	public BTNode<T> delAllPathLessSum(BTNode<T> t, int k);

	public void pruneUtil(BTNode<Integer> node, int k, int sum);

	/** 33. Print Left View of a Binary Tree **/
	// @See all view of tree DAIHashingWithTree.java

	/** 34. Check if all leaves are at same level **/
	public boolean checkAllLeavesAtSameLevel(BTNode<T> t);

	/** 35. Find depth of the deepest odd level leaf node **/
	public BTNode<T> deepestOddlevelNode(BTNode<T> t);

	/**
	 * 36. Difference between sums of odd level and even level nodes of a Binary
	 * Tree
	 **/
	public int diffSumOfOddAndEvenLevel(BTNode<T> t);

	/** 37. Custom Tree Problem **/
	public BTNode<T> createCustomTree(BTNode<T> t, T p, T c);

	/** 38. Iterative Method to find Height of Binary Tree **/
	public int heightIterative(BTNode<T> t);

	/** 39. Tree Isomorphism Problem **/
	public boolean isIsomorphic(BTNode<T> t1, BTNode<T> t2);
	/** 40. Check if a binary tree is subtree of another binary tree | Set 2 **/
	// @See 15.
	/* 41. Find the maximum path sum between two leaves of a binary tree */
	/* 42. Threaded Binary Tree */
	/* 43. Reverse alternate levels of a perfect binary tree */
	/* 44. Print Right View of a Binary Tree */
	/* 45. Print all nodes at distance k from a given node */
	/* 46. Find distance between two given keys of a Binary Tree */
	/* 47. Print all nodes that don’t have sibling */
	/* 48. Check if a given Binary Tree is height balanced like a Red-Black Tree */
	/* 49. Print all nodes that are at distance k from a leaf node */
	/* 50. Find the closest leaf in a Binary Tree */
	/* 51. Diagonal Sum of a Binary Tree */
	/* 52. Bottom View of a Binary Tree */
	/* 53. Print Nodes in Top View of Binary Tree */
	/* 54. Serialize and Deserialize an N-ary Tree */
	/* 55. Check if a given graph is tree or not */
	/* 56. Print nodes between two given level numbers of a binary tree */
	/* 57. Find Height of Binary Tree represented by Parent array */
	/* 58. Minimum no. of iterations to pass information to all nodes in the tree */
	/* 59. Check if two nodes are cousins in a Binary Tree */
	/* 60. Find Minimum Depth of a Binary Tree */
}
