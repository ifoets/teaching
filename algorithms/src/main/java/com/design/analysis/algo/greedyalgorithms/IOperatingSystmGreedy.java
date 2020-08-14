package com.design.analysis.algo.greedyalgorithms;

import java.util.List;

import com.design.analysis.algo.greedyalgorithms.model.MemoryPartition;
import com.design.analysis.algo.greedyalgorithms.model.Process;

/*
 * 
 * @author GuruG
	Greedy Algorithms in Operating Systems :
	
	1.	First Fit algorithm in Memory Management
	2.	Best Fit algorithm in Memory Management
	3.	Worst Fit algorithm in Memory Management
	4.	Operating System | Program for Next Fit algorithm in Memory Management
	5.	Shortest Job First Scheduling
	6.	Program for Shortest Job First (SJF) scheduling | Set 2 (Preemptive)
	7.	Schedule jobs so that each server gets equal load
	8.	Job Scheduling with two jobs allowed at a time
	9.	Scheduling priority tasks in limited time and minimizing loss
	10.	Program for Optimal Page Replacement Algorithm
	11.	Program for Page Replacement Algorithms | Set 1 ( LRU)
	12.	Program for Page Replacement Algorithms | Set 2 (FIFO)

 */
public interface IOperatingSystmGreedy {

	/** 1. First Fit algorithm in Memory Management **/
	public List<MemoryPartition> firstFitMemory(int blockSize[], int processSize[]);

	/** 2. Best Fit algorithm in Memory Management **/
	public List<MemoryPartition> bestFitMemory(int blockSize[], int processSize[]);

	/** 3. Worst Fit algorithm in Memory Management **/
	public List<MemoryPartition> worstFitMemory(int blockSize[], int processSize[]);

	/** 5. Shortest Job First Scheduling **/

	/* Function to calculate waiting time */
	public void findWaitingTime(Process proc[], int n, int wt[]);

	/* Function to calculate turn around time */
	public void findTurnAroundTime(Process proc[], int n, int wt[], int tat[]);

	/* Function to calculate average time */
	public float[] findavgTime(Process proc[]);

}
