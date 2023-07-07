package com.design.analysis.core.algo.greedyalgorithms;

import java.util.Arrays;
import java.util.List;

import com.design.analysis.core.algo.greedyalgorithms.model.MemoryPartition;
import com.design.analysis.core.algo.greedyalgorithms.model.Process;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IOperatingSystmGreedyTest {

	public IOperatingSystmGreedy iog = null;

	@Before
	public void init() {
		iog = new OperatingSystmGreedyImpl();
	}

	/** 1. First Fit algorithm in Memory Management **/
	@Test
	public void firstFitMemoryTest() {

		int blockSize[] = { 100, 500, 200, 300, 600 };
		int processSize[] = { 212, 417, 112, 426 };
		List<MemoryPartition> list = iog.firstFitMemory(blockSize, processSize);
		Assert.assertTrue(list.size() == 3);
		System.out.println("Process No.   Process Size   Block no.");
		for (int i = 0; i < processSize.length; i++) {

			if (list.size() > i) {
				MemoryPartition memp = list.get(i);
				System.out.print(i + 1 + "             " + memp.processSize + "           " + memp.blockNo);
			} else
				System.out.print(i + 1 + "             " + processSize[i] + "           " + "Not allocated");
			System.out.println();
		}
	}

	/** 2. Best Fit algorithm in Memory Management **/
	@Test
	public void bestFitMemoryTest() {
		int blockSize[] = { 100, 500, 200, 300, 600 };
		int processSize[] = { 212, 417, 112, 426 };
		List<MemoryPartition> list = iog.bestFitMemory(blockSize, processSize);
		Assert.assertTrue(list.size() == 4);
		System.out.println("Process No.   Process Size   Block no.");
		for (int i = 0; i < processSize.length; i++) {

			if (list.size() > i) {
				MemoryPartition memp = list.get(i);
				System.out.print(i + 1 + "             " + memp.processSize + "           " + memp.blockNo);
			} else
				System.out.print(i + 1 + "             " + processSize[i] + "           " + "Not allocated");
			System.out.println();
		}
	}

	/** 3. Worst Fit algorithm in Memory Management **/
	@Test
	public void worstFitMemoryTest() {
		int blockSize[] = { 100, 500, 200, 300, 600 };
		int processSize[] = { 212, 417, 112, 426 };
		List<MemoryPartition> list = iog.worstFitMemory(blockSize, processSize);
		Assert.assertTrue(list.size() == 3);
		System.out.println("Process No.   Process Size   Block no.");
		for (int i = 0; i < processSize.length; i++) {

			if (list.size() > i) {
				MemoryPartition memp = list.get(i);
				System.out.print(i + 1 + "             " + memp.processSize + "           " + memp.blockNo);
			} else
				System.out.print(i + 1 + "             " + processSize[i] + "           " + "Not allocated");
			System.out.println();
		}
	}

	/** 5. Shortest Job First Scheduling **/
	@Test
	public void findavgTimeTest() {
		int prc[][] = { { 1, 6 }, { 2, 8 }, { 3, 7 }, { 4, 3 } };
		Process proc[] = new Process[prc.length];
		for (int i = 0; i < prc.length; i++) {
			proc[i] = new Process(prc[i][0], prc[i][1]);
		}
		Arrays.sort(proc);
		float rs[] = iog.findavgTime(proc);
		Assert.assertTrue(rs[0] == 7.0);
		Assert.assertTrue(rs[1] == 13.0);
	}
}
