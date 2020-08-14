
package com.design.analysis.ds.hashing;

import com.design.analysis.ds.hashing.node.HNodeTp;

public interface DAIHashing {
	
	/**stat operation on linear probing using link list **/
	public void listLinerProbingInsert(int a[], int maxSize);
	
	public void listLinerProbingInsert(int x);
	
	public boolean listLinerProbingSearch(int x);
	
	public void listLinerProbingDelete(int y);
	
	public int hashOfListProb(int x);
	
	public void printListProb();
	
	/**end of operation on linear probing using link list **/
	
	/**start operation on bst tree probing using link list **/
	public HNodeTp create(HNodeTp node, int dt);
	
	public void bstTreeProbingInsert(int a[], int maxSize);
	
	public void bstTreeProbingInsert(int x);
	
	public boolean bstTreeProbingSearch(int x);
	
	public boolean recursveSearch(HNodeTp node, int key);
	
	public void bstTreeProbingDelete(int y);
	
	public int hashOfTreeProb(int x);
	
	public void printbstTreeProb();
	
	public void print(HNodeTp hashRoot);
	
	/**end of operation on linear probing using link list **/
}
