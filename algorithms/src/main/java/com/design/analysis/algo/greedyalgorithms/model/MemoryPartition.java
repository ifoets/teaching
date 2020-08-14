package com.design.analysis.algo.greedyalgorithms.model;

public class MemoryPartition {
	public int blockNo;
	public int blockSize;
	public int processSize;

	public MemoryPartition(int blockNo, int blockSize, int processSize) {
		super();
		this.blockNo = blockNo;
		this.blockSize = blockSize;
		this.processSize = processSize;
	}
}
