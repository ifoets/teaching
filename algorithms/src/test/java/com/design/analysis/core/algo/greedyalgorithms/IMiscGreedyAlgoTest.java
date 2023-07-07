package com.design.analysis.core.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.algo.greedyalgorithms.model.Customer;
import com.design.analysis.core.algo.greedyalgorithms.model.StockPrice;
import com.design.analysis.core.algo.greedyalgorithms.model.TrainStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMiscGreedyAlgoTest {

	public IMiscGreedyAlgo imga = null;

	@Before
	public void init() {
		imga = new MiscGreedyAlgoImpl();
	}

	/** 1. Split n into maximum composite numbers **/
	@Test
	public void splitIntoMaxCompoiteNumsTest() {
		Assert.assertTrue(imga.splitIntoMaxCompoiteNums(90) == 22);
		Assert.assertTrue(imga.splitIntoMaxCompoiteNums(143) == 34);
	}

	/** 2. Maximum trains for which stoppage can be provided **/
	@Test
	public void maxTrainNeedStopageTest() {

		int a[][] = { { 1000, 1030, 1 }, { 1010, 1030, 1 }, { 1000, 1020, 2 }, { 1030, 1230, 2 }, { 1200, 1230, 3 },
				{ 900, 1005, 1 } };

		List<TrainStatus> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++)
			list.add(new TrainStatus(a[i][0], a[i][1], a[i][2]));
		Assert.assertTrue(imga.maxStoppedTrain(list) == 4);
	}

	/** 3. Buy Maximum Stocks if i stocks can be bought on i-th day **/
	@Test
	public void buyMaxStockTest() {

		int price[] = { 10, 7, 19 };
		List<StockPrice> list = new ArrayList<>();

		for (int i = 0; i < price.length; i++)
			list.add(new StockPrice(i + 1, price[i]));
		Assert.assertTrue(imga.buyMaxStock(list, 45) == 4);
	}

	/** 4. Find the minimum and maximum amount to buy all N candies **/
	@Test
	public void minMaxAmountToBuyAllCandyTest() {
		int prices[] = { 3, 2, 1, 4 };
		Assert.assertTrue(imga.minMaxAmountToBuyAllCandy(prices, 2, true) == 3);
		Assert.assertTrue(imga.minMaxAmountToBuyAllCandy(prices, 2, false) == 7);
	}

	/** 5. Maximum sum possible equal to sum of three stacks **/
	@Test
	public void maxSumEqualtoThreeStackTest() {
		int stack1[] = { 3, 2, 1, 1, 1 };
		int stack2[] = { 4, 3, 2 };
		int stack3[] = { 1, 1, 4, 1 };

		Assert.assertTrue(imga.maxSumEqualtoThreeStack(stack1, stack2, stack3) == 5);
	}

	/** 6. Maximum elements that can be made equal with k updates **/
	@Test
	public void maxEqualsTest() {
		int a[] = { 2, 4, 9 };
		int k1 = 3;
		int b[] = { 5, 5, 3, 1 };
		int k2 = 5;
		int c[] = { 5, 5, 3, 1 };
		int k3 = 6;
		Assert.assertTrue(imga.maxEquals(a, k1) == 2);
		Assert.assertTrue(imga.maxEquals(b, k2) == 3);
		Assert.assertTrue(imga.maxEquals(c, k3) == 4);
	}

	/** 7. Divide cuboid into cubes such that sum of volumes is maximum **/
	@Test
	public void sumOfVolIsMaxTest() {
		int l = 2, b = 4, h = 6;
		Assert.assertTrue(imga.sumOfVolIsMax(l, b, h) == 6);
	}

	/** 8. Maximum number of customers that can be satisfied with given quantity **/
	@Test
	public void maxStisfiedCustomerTest() {
		char customer[] = { 'a', 'b', 'c', 'd', 'e' };
		int aBagSize[] = { 2, 3, 4, 10, 0 };
		int bBagSize[] = { 0, 2, 4, 0, 1 };

		int aSise = 1;
		int bSize = 1;
		int total = 5;
		List<Customer> list = new ArrayList<>();
		for (int i = 0; i < customer.length; list.add(new Customer(aBagSize[i], bBagSize[i], customer[i])), i++)
			;
		List<Character> listResult = imga.maxStisfiedCustomer(list, total, aSise, bSize);
		Assert.assertTrue(listResult.get(0) == 'e');
		Assert.assertTrue(listResult.get(1) == 'a');
	}

	/** 9. Minimum Fibonacci terms with sum equal to K **/
	@Test
	
	public void minFibonacciUseTest() {
		int a = 0;
		int b = 1;
		int K = 17;
		Assert.assertTrue(imga.minFibonacciUse(a, b, K) == 3);

	}

	/** 10. Divide 1 to n into two groups with minimum sum difference **/
	@Test
	public void minSumDiff2GroupTest() {

		List<List<Integer>> ll = imga.minSumDiff2Group(5);
		Assert.assertTrue(imga.getMinDiffTwoGroup(ll.get(0), ll.get(1)) == 1);
		ll = imga.minSumDiff2Group(8);
		Assert.assertTrue(imga.getMinDiffTwoGroup(ll.get(0), ll.get(1)) == 0);
	}
}
