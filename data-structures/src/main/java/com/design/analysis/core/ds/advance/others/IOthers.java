package com.design.analysis.core.ds.advance.others;

import com.design.analysis.core.ds.advance.others.node.TernaryNode;

/*
 * 
 * @author GuruG
 * 
 * Others :
1.	Palindromic Tree | Introduction & Implementation
2.	Ternary Search Tree
3.	Interval Tree
4.	BK-Tree | Introduction & Implementation
5.	Ropes Data Structure (Fast String Concatenation)
6.	Summed Area Table � Submatrix Summation
7.	Implement LRU Cache
8.	Sort numbers stored on different machines
9.	Substring with highest frequency length product
10.	Find whether a subarray is in form of a mountain or not
11.	Find all possible interpretations of an array of digits
12.	How to design a tiny URL or URL shortener?
13.	Design a data structure that supports insert, delete, search and getRandom in constant time
14.	Design an efficient data structure for given operations
15.	Tournament Tree (Winner Tree) and Binary Heap
16.	Second minimum element using minimum comparisons
17.	Binomial Heap
18.	Fibonacci Heap
19.	Leftist Heap
20.	Decision Trees � Fake (Counterfeit) Coin Puzzle (12 Coin Puzzle)
21.	Spaghetti Stack
22.	Data Structure for Dictionary and Spell Checker
23.	Cartesian Tree
24.	Cartesian Tree Sorting
25.	Sparse Set
26.	Centroid Decomposition of Tree
27.	Gomory-Hu Tree


 */
public interface IOthers<T, K> {

	/** 1. Palindromic Tree | Introduction & Implementation **/

	/** 2. Ternary Search Tree **/
	public TernaryNode<T> insert(TernaryNode<T> node, Character word[], int prt);

	public void traverse(TernaryNode<T> node, String str);

	public boolean search(TernaryNode<T> node, Character word[], int ptr);

	public void delete(TernaryNode<T> node, Character word[], int ptr);
}
