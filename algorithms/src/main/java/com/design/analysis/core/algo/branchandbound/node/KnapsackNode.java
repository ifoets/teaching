package com.design.analysis.core.algo.branchandbound.node;

/*Implementation of 0/1 Knapsack*/
public class KnapsackNode {
	// level is nothing but the index of array
	// profit is total profit at this stage
	// weight is total weigh at this level
	// bound is next level profit to take decision for next movement
	public int level, profit, bound;
	public float weight;

	public KnapsackNode() {
		this.level = -1;
		this.profit = this.bound = 0;
		this.weight = 0;
	}

	@Override
	public String toString() {
		return "KnapsackNode [level=" + level + ", profit=" + profit + ", bound=" + bound + ", weight=" + weight + "]";
	}
}
