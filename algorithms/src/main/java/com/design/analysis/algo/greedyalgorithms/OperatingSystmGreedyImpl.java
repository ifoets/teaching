package com.design.analysis.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.algo.greedyalgorithms.model.MemoryPartition;
import com.design.analysis.algo.greedyalgorithms.model.Process;

public class OperatingSystmGreedyImpl implements IOperatingSystmGreedy {

	/** 1. First Fit algorithm in Memory Management **/
	@Override
	public List<MemoryPartition> firstFitMemory(int blockSize[], int processSize[]) {

		int m = blockSize.length;
		int n = processSize.length;

		List<MemoryPartition> allocationLit = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (blockSize[j] >= processSize[i]) {
					allocationLit.add(new MemoryPartition(j + 1, blockSize[j], processSize[i]));
					blockSize[j] -= processSize[i];
					break;
				}
			}
		}
		return allocationLit;
	}

	/** 2. Best Fit algorithm in Memory Management **/
	public List<MemoryPartition> bestFitMemory(int blockSize[], int processSize[]) {

		int m = blockSize.length;
		int n = processSize.length;

		int bestIdx = -1;// for finding the min diff of process and block size for best fit
		List<MemoryPartition> allocationLit = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bestIdx = -1;
			for (int j = 0; j < m; j++) {

				if (blockSize[j] >= processSize[i]) {
					if (bestIdx == -1)
						bestIdx = j;
					else if (blockSize[bestIdx] > blockSize[j])
						bestIdx = j;
				}
			}

			if (bestIdx != -1) {
				allocationLit.add(new MemoryPartition(bestIdx + 1, blockSize[bestIdx], processSize[i]));
				blockSize[bestIdx] -= processSize[i];

			}
		}
		return allocationLit;
	}

	/** 3. Worst Fit algorithm in Memory Management **/
	public List<MemoryPartition> worstFitMemory(int blockSize[], int processSize[]) {

		int m = blockSize.length;
		int n = processSize.length;

		int bestIdx = -1;// for finding the min diff of process and block size for best fit
		List<MemoryPartition> allocationLit = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bestIdx = -1;
			for (int j = 0; j < m; j++) {

				if (blockSize[j] >= processSize[i]) {
					if (bestIdx == -1)
						bestIdx = j;
					else if (blockSize[bestIdx] < blockSize[j])
						bestIdx = j;
				}
			}

			if (bestIdx != -1) {
				allocationLit.add(new MemoryPartition(bestIdx + 1, blockSize[bestIdx], processSize[i]));
				blockSize[bestIdx] -= processSize[i];

			}
		}
		return allocationLit;
	}

	/** 5. Shortest Job First Scheduling **/

	/* Function to calculate waiting time */
	public void findWaitingTime(Process proc[], int n, int wt[]) {
		// waiting time for first process is 0
		wt[0] = 0;

		// calculating waiting time
		for (int i = 1; i < n; i++)
			wt[i] = proc[i - 1].bt + wt[i - 1];
	}

	/* Function to calculate turn around time */
	public void findTurnAroundTime(Process proc[], int n, int wt[], int tat[]) {
		// calculating turnaround time by adding
		// bt[i] + wt[i]
		for (int i = 0; i < n; i++)
			tat[i] = proc[i].bt + wt[i];
	}

	/* Function to calculate average time */
	public float[] findavgTime(Process proc[]) {
		int n = proc.length;
		float[] avgTalTime = new float[2];
		int wt[] = new int[n];
		int tat[] = new int[n];

		int total_wt = 0, total_tat = 0;

		// Function to find waiting time of all processes
		findWaitingTime(proc, n, wt);

		// Function to find turn around time for all processes
		findTurnAroundTime(proc, n, wt, tat);

		System.out.println("Order in which process gets executed\n");
		for (int i = 0; i < n; i++)
			System.out.println(proc[i].pid);

		// Display processes along with all details
		System.out.println("\nProcesses :: Burst time :: Waiting time :: Turn around time\n");

		// Calculate total waiting time and total turn
		// around time
		for (int i = 0; i < n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(proc[i].pid + "                  " + proc[i].bt + "              " + wt[i]
					+ "              " + tat[i]);
		}
		avgTalTime[0] = (float) total_wt / (float) n;
		avgTalTime[1] = (float) total_tat / (float) n;
		return avgTalTime;
	}
}
