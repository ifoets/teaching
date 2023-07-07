package com.design.analysis.core.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.design.analysis.core.algo.branchandbound.model.KnapsackItem;
import com.design.analysis.core.algo.common.ActivityTime;
import com.design.analysis.core.algo.common.EgyptianFraction;
import com.design.analysis.core.algo.common.JobSequencing;
import com.design.analysis.core.algo.greedyalgorithms.model.HuffmanElement;
import com.design.analysis.core.algo.greedyalgorithms.model.HuffmanNode;
import com.design.analysis.core.algo.greedyalgorithms.model.JobSequen;
import com.design.analysis.core.algo.greedyalgorithms.model.LossMin;
import com.design.analysis.core.algo.greedyalgorithms.model.LossMinSequn;
import com.design.analysis.core.algo.utils.AlgoUtils;

public class StandardGreedyAlgoImpl implements IStandardGreedyAlgo {

	/** 0-1 Knapsack Problem **/
	public int knapsack01(int CP, int val[], int wt[], int n) {
		if (n == 0 || CP == 0)
			return 0;
		if (wt[n - 1] > CP)
			return knapsack01(CP, val, wt, n - 1);

		else// include nth item and exclude nth item
			return AlgoUtils.max(val[n - 1] + knapsack01(CP - wt[n - 1], val, wt, n - 1),
					knapsack01(CP, val, wt, n - 1));
	}

	/** Fractional Knapsack Problem **/
	public long fractionalKnapsack(List<KnapsackItem> list, int W) {
		Collections.sort(list);
		long result = 0;
		for (KnapsackItem knap : list) {
			if (knap.weight < W) {
				result += knap.value;
				W -= knap.weight;
			} else
				result += (knap.value / knap.weight) * W;
		}
		return result;
	}

	/** 1. Max no of element use **/
	@Override
	public int[] maxMinNoofElementUse(int arr[], int sum) {
		Arrays.sort(arr);
		int rArr[] = new int[2];
		int i, j, maxSum = 0;
		int minSum = 0;
		for (i = 0; i < arr.length; i++) {
			minSum += arr[i];
			if (minSum > sum)
				break;
		}
		rArr[0] = i + 1;

		for (j = 0; j < arr.length; j++) {
			maxSum += arr[arr.length - 1 - j];
			if (maxSum > sum)
				break;
		}
		rArr[i] = j + 1;

		return rArr;
	}

	/** 1. Activity Selection Problem **/
	@Override
	public List<ActivityTime> activitySelection(List<ActivityTime> list) {

		Collections.sort(list);
		List<ActivityTime> resList = null;
		if (null != list)
			resList = new ArrayList<>();
		int i = 0;
		resList.add(list.get(0));
		for (int j = 1; j < list.size(); j++) {
			if (list.get(j).getStartTime() >= list.get(i).getEndTime()) {
				resList.add(list.get(j));
				i = j;
			} else
				continue;
		}
		return resList;
	}

	/** 2. Egyptian Fraction **/
	@Override
	public List<EgyptianFraction> egyptianFraction(List<EgyptianFraction> result, int nr, int dr) {
		if (result == null)
			result = new ArrayList<>();

		if (nr == 0 || dr == 0)
			return result;

		if (dr % nr == 0) {
			result.add(new EgyptianFraction(1, dr / nr));
			return result;
		}
		if (nr % dr == 0) {
			result.add(new EgyptianFraction(nr / dr, 1));
			return result;
		}
		if (nr > dr) {
			result.add(new EgyptianFraction(nr / dr, 1));
			return egyptianFraction(result, nr % dr, dr);
		}
		// We reach here dr > nr and dr%nr is non-zero
		// Find ceiling of dr/nr and print it as first
		// fraction

		int n = dr / nr + 1;
		result.add(new EgyptianFraction(1, n));
		return egyptianFraction(result, nr * n - dr, dr * n);
	}

	/** 3. Job Sequencing Problem **/
	@Override
	public List<String> jobSequencingProblem(List<JobSequencing> list) {
		Collections.sort(list);
		List<String> result = new ArrayList<>();
		List<String> result1 = new ArrayList<>();
		boolean slot[] = new boolean[list.size()];

		for (JobSequencing jobSeq : list) {
			for (int j = Math.min(list.size(), jobSeq.deadLine) - 1; j >= 0; j--) {
				if (slot[j] == false) {
					result.add(jobSeq.jobId);
					slot[j] = true;
					break;
				}
			}
		}
		// or
		int c = 0;
		for (int i = 0; i < list.size(); i++) {
			if (c < list.get(i).deadLine) {
				result1.add(list.get(i).jobId);
				c++;
			}
		}
		return result;
	}

	/** 4. Job Sequencing Problem (Using Disjoint Set) **/
	@Override
	public List<JobSequen> jobSequencingProblemDisjointSet(List<JobSequen> list) {
		if (list != null && list.size() > 0) {
			List<JobSequen> rl = new ArrayList<>();
			Collections.sort(list);
			int dl = 0;
			for (JobSequen jb : list) {
				if (dl < jb.deadLine) {
					rl.add(jb);
					dl++;
				}
			}
			return rl;
		}
		return null;
	}

	/** 5. Job Sequencing Problem � Loss Minimization **/
	public List<LossMin> jobSequencingLossMinStrategy(List<LossMin> list) {
		Collections.sort(list, new Comparator<LossMin>() {
			@Override
			public int compare(LossMin o1, LossMin o2) {
				return o2.loss * o1.deadLine - o1.loss * o2.deadLine;
			}

		});
		return list;
	}

	@Override
	public List<LossMinSequn> jobSequencingLossMinStrategyX(List<LossMinSequn> list) {

		if (list != null && list.size() > 0) {
			List<LossMinSequn> rl = new ArrayList<>();
			boolean selected[] = new boolean[list.size()];
			Collections.sort(list);
			int dl = 0;
			for (int i = 0; i < list.size(); i++) {
				if (dl < list.get(i).deadLine) {
					rl.add(list.get(i));
					dl++;
					selected[i] = true;
				}
			}
			for (int i = 0; i < list.size(); i++) {

				if (!selected[i])
					rl.add(list.get(i));
			}
			return rl;
		}
		return null;
	}

	/** 6. Job Selection Problem � Loss Minimization Strategy | Set 2 **/
	public double maxVolumeBestJobSelection(int vol[], double percentage) {
		if (vol != null && vol.length > 0) {
			Arrays.sort(vol);
			double result = 0;
			for (int i = vol.length - 1; i >= 0; i--)
				result += Math.pow((1 - percentage), vol.length - 1 - i) * vol[i];
			return result;
		}
		return 0;
	}

	/** 7. Huffman Coding **/
	class MyComparator implements Comparator<HuffmanNode> {
		public int compare(HuffmanNode x, HuffmanNode y) {
			return x.data - y.data;
		}
	}

	@Override
	public HuffmanNode create(List<HuffmanElement> hufList) {

		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(hufList.size(), new MyComparator());
		for (HuffmanElement huf : hufList)
			q.add(new HuffmanNode(huf.frq, huf.c));

		HuffmanNode root = null;
		while (q.size() > 1) {
			// first min extract.
			HuffmanNode x = q.peek();
			q.poll();

			// second min extarct.
			HuffmanNode y = q.peek();
			q.poll();

			// new node f which is equal
			HuffmanNode f = new HuffmanNode(x.data + y.data, '-');
			// first extracted node as left child.
			f.lt = x;
			// second extracted node as the right child.
			f.rt = y;
			// marking the f node as the root node.
			root = f;
			// add this node to the priority-queue.
			q.add(f);
		}
		return root;
	}

	@Override
	public void printCode(HuffmanNode root, String s) {

		if (root.lt == null && root.rt == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + s);
			return;
		}

		// if we go to left then add "0" to the code.
		// if we go to the right add"1" to the code.

		// recursive calls for left and
		// right sub-tree of the generated tree.
		printCode(root.lt, s + "0");
		printCode(root.rt, s + "1");
	}

	/** 8. Efficient Huffman Coding for sorted input **/
	public HuffmanNode efficientCreate(List<HuffmanElement> hufList) {

		Queue<HuffmanNode> fq = new LinkedList<>();
		Queue<HuffmanNode> sq = new LinkedList<>();
		Collections.sort(hufList);
		for (HuffmanElement huf : hufList)
			fq.add(new HuffmanNode(huf.frq, huf.c));

		HuffmanNode root, lt, rt;
		root = null;
		while (!(fq.isEmpty() && sq.size() == 1)) {
			// Step 3: Dequeue two nodes with the minimum frequency by examining
			// the front of both queues
			lt = findMin(fq, sq);
			rt = findMin(fq, sq);

			// Step 4: Create a new internal node with frequency equal to the sum
			// of the two nodes frequencies. Enqueue this node to second queue.
			root = new HuffmanNode(lt.data + rt.data, '-');
			root.lt = lt;
			root.rt = rt;
			sq.add(root);
		}
		return sq.poll();
	}

	@Override
	public HuffmanNode findMin(Queue<HuffmanNode> firstQueue, Queue<HuffmanNode> secondQueue) {
		// Step 3.a: If second queue is empty, dequeue from first queue
		if (firstQueue.isEmpty())
			return secondQueue.poll();

		// Step 3.b: If first queue is empty, dequeue from second queue
		if (secondQueue.isEmpty())
			return firstQueue.poll();

		// Step 3.c: Else, compare the front of two queues and dequeue minimum
		if (firstQueue.peek().data < secondQueue.peek().data)
			return firstQueue.poll();

		return secondQueue.poll();
	}

	@Override
	public void printCodes(HuffmanNode root, String str) {
		// Assign 0 to left edge and recur
		if (root.lt != null)
			printCodes(root.lt, str + "0");

		// Assign 1 to right edge and recur
		if (root.rt != null)
			printCodes(root.rt, str + "1");

		// If this is a leaf node, then it contains one of the input
		// characters, print the character and its code from arr[]
		if (root.lt == null && root.rt == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + str);
			return;
		}
	}

}
