package com.design.analysis.core.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.design.analysis.core.algo.branchandbound.model.KnapsackItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.algo.common.ActivityTime;
import com.design.analysis.core.algo.common.EgyptianFraction;
import com.design.analysis.core.algo.common.JobSequencing;
import com.design.analysis.core.algo.greedyalgorithms.model.HuffmanElement;
import com.design.analysis.core.algo.greedyalgorithms.model.HuffmanNode;
import com.design.analysis.core.algo.greedyalgorithms.model.JobSequen;
import com.design.analysis.core.algo.greedyalgorithms.model.LossMin;
import com.design.analysis.core.algo.greedyalgorithms.model.LossMinSequn;

public class IStandardGreedyAlgoTest {

	public IStandardGreedyAlgo isga = null;

	@Before
	public void init() {
		isga = new StandardGreedyAlgoImpl();
	}

	/** 0-1 Knapsack Problem **/
	@Test
	public void Knapsack01Test() {

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int capacity = 50;
		Assert.assertTrue(isga.knapsack01(capacity, val, wt, val.length) == 220);
	}

	/** Fractional Knapsack Problem **/
	@Test
	public void fractionalKnapsackTest() {

		List<KnapsackItem> list = new ArrayList<>();
		list.add(new KnapsackItem(10, 60));
		list.add(new KnapsackItem(20, 100));
		list.add(new KnapsackItem(30, 120));

		int W = 50;
		Assert.assertTrue(isga.fractionalKnapsack(list, W) == 240);
	}

	/** 1. Activity Selection Problem **/
	@Test
	public void activitySelectionTest() {
		ActivityTime t1 = new ActivityTime(1, 2);
		ActivityTime t2 = new ActivityTime(0, 6);

		ActivityTime t3 = new ActivityTime(8, 9);
		ActivityTime t4 = new ActivityTime(3, 4);

		ActivityTime t5 = new ActivityTime(5, 7);
		ActivityTime t6 = new ActivityTime(5, 9);
		List<ActivityTime> list = new ArrayList<>();

		list.add(t1);
		list.add(t2);
		list.add(t3);

		list.add(t4);
		list.add(t5);
		list.add(t6);

		Collections.sort(list);
		List<ActivityTime> rList = isga.activitySelection(list);
		ActivityTime at1 = rList.get(0);
		ActivityTime atLast = rList.get(rList.size() - 1);
		Assert.assertTrue(at1.getStartTime() == 1);
		Assert.assertTrue(at1.getEndTime() == 2);

		Assert.assertTrue(atLast.getStartTime() == 8);
		Assert.assertTrue(atLast.getEndTime() == 9);

	}

	/** 2. Egyptian Fraction **/
	@Test
	public void egyptianFractionTest() {
		List<EgyptianFraction> egtFrList = isga.egyptianFraction(null, 6, 14);
		System.out.println(egtFrList.toString());
		Assert.assertTrue(egtFrList.get(0).dr == 3);
		Assert.assertTrue(egtFrList.get(2).dr == 231);
	}

	/** 3. Job Sequencing Problem **/
	@Test
	public void jobSequencingProblemTest() {
		JobSequencing[] arr = { new JobSequencing("a", 2, 100), new JobSequencing("b", 1, 19),
				new JobSequencing("c", 2, 27), new JobSequencing("d", 1, 25), new JobSequencing("e", 3, 15) };
		List<JobSequencing> list = Arrays.asList(arr);

		List<String> result = isga.jobSequencingProblem(list);
		System.out.println(result.toString());
	}

	/** 4. Job Sequencing Problem (Using Disjoint Set) **/
	@Test
	public void jobSequencingProblemDisjointSetTest() {
		List<JobSequen> list = new ArrayList<>();
		String id[] = { "a", "b", "c", "d", "e", "f" };
		int[] deadline = { 2, 1, 2, 1, 3, 4 };
		int profit[] = { 50, 20, 30, 30, 20, 60 };

		for (int i = 0; i < id.length; i++)
			list.add(new JobSequen(id[i], deadline[i], profit[i]));
		list = isga.jobSequencingProblemDisjointSet(list);
		int a[] = { 30, 50, 20, 60 };
		int i = 0;
		for (JobSequen jb : list)
			Assert.assertTrue(jb.profit == a[i++]);
	}

	/** 5. Job Sequencing Problem – Loss Minimization **/
	@Test
	public void jobSequencingLossMinStrategyTest() {
		List<LossMin> list = new ArrayList<>();
		String id[] = { "a", "b", "c", "d", "e" };
		int[] loss = { 1, 2, 3, 5, 6 };
		int deadline[] = { 2, 4, 1, 3, 2 };

		for (int i = 0; i < id.length; i++)
			list.add(new LossMin(id[i], loss[i], deadline[i]));
		list = isga.jobSequencingLossMinStrategy(list);
		String a[] = { "c", "e", "d", "a", "b" };
		int i = 0;
		for (LossMin jb : list)
			Assert.assertTrue(jb.jobId == a[i++]);
	}

	@Test
	public void jobSequencingLossMinStrategyXTest() {
		List<LossMinSequn> list = new ArrayList<>();
		String id[] = { "a", "b", "c", "d", "e" };
		int[] loss = { 1, 2, 3, 5, 6 };
		int deadline[] = { 2, 4, 1, 3, 2 };

		for (int i = 0; i < id.length; i++)
			list.add(new LossMinSequn(id[i], loss[i], deadline[i]));
		list = isga.jobSequencingLossMinStrategyX(list);
		String a[] = { "c", "e", "d", "b", "a" };
		int i = 0;
		for (LossMinSequn jb : list)
			Assert.assertTrue(jb.jobId == a[i++]);
	}

	/** 6. Job Selection Problem – Loss Minimization Strategy | Set 2 **/
	@Test
	public void maxVolumeBestJobSelectionTest() {
		int vol[] = { -1, 3, 5, 4, 1, 2, 7, 6, 8, 9, 10 };
		System.out.println(isga.maxVolumeBestJobSelection(vol, 0.10));
	}

	/** 7. Huffman Coding **/
	@Test
	public void createAndPrintTest() {

		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		List<HuffmanElement> list = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++)
			list.add(new HuffmanElement(charArray[i], charfreq[i]));
		HuffmanNode root = isga.create(list);
		isga.printCode(root, "");
	}

	/** 8. Efficient Huffman Coding for sorted input **/
	@Test
	public void efficientCreateTest() {
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		List<HuffmanElement> list = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++)
			list.add(new HuffmanElement(charArray[i], charfreq[i]));
		HuffmanNode root = isga.efficientCreate(list);
		isga.printCodes(root, "");
	}
}
