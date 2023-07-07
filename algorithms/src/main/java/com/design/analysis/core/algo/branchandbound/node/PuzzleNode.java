package com.design.analysis.core.algo.branchandbound.node;

/*this is eight puzzle node*/
public class PuzzleNode {

	public PuzzleNode pt;// parent pointer for traversing to root
	public int mat[][];// used to store the data
	public int x, y;// used to store the blank position
	public int cost;// use to store misplace place
	public int level;// stores the number of moves so far
}
