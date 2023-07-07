package com.design.analysis.core.algo.interview;

public interface IGeneral {

	/**
	 * given n pillor find how much water trap if raning happen between the pillors
	 **/
	public int quantityofWaterTrap(int a[]);

	public int findRightSideBiggestPillor(int i, int a[]);

	public int findLeftSideBiggestPillor(int i, int a[]);

	/** find the max 1 in (0,1) sorted row matrix by O(nlog(n)) comlexity **/

	public int findMax1Row(int a[][]);

	public int binarySearchOfLastIndex(int a[], int x, int l, int r);
}
