package com.design.analysis.core.ds.hashing;

public interface IHashing {

	/**Index Mapping (or Trivial Hashing) with negatives allowed **/
	public void insertIndexMapping(int arr[], int maxMinRange);
	
	public int searchIndexMapping(int x);
	
	public boolean deleteIndexMapping(int key);
	
	public void printIndexMapping();
	
}
