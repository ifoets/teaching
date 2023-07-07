package com.design.analysis.core.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.core.algo.greedyalgorithms.model.Customer;
import com.design.analysis.core.algo.greedyalgorithms.model.StockPrice;
import com.design.analysis.core.algo.greedyalgorithms.model.TrainStatus;
import com.design.analysis.core.algo.utils.AlgoUtils;

public class MiscGreedyAlgoImpl implements IMiscGreedyAlgo {

	/** 1. Split n into maximum composite numbers **/
	@Override // 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, ���
	public int splitIntoMaxCompoiteNums(int n) {

		if (n < 4)
			return -1;
		int rem = n % 4;
		if (rem == 0)
			return n / 4;

		if (rem == 1) {
			if (n < 9)
				return -1;
			return (n - 9) / 4 + 1;
		}

		if (rem == 2)
			return (n - 6) / 4 + 1;

		if (rem == 3) {
			if (n < 15)
				return -1;
			return (n - 15) / 4 + 2;
		}
		return 0;
	}

	/** 2. Maximum trains for which stoppage can be provided **/
	@Override
	public int maxStoppedTrain(List<TrainStatus> list) {
		Map<Integer, List<TrainStatus>> map = new HashMap<>();
		List<TrainStatus> tsList = null;
		for (TrainStatus ts : list) {
			if (map.get(ts.platFormNo) == null) {
				tsList = new ArrayList<>();
				tsList.add(ts);
				map.put(ts.platFormNo, tsList);
			} else {
				tsList = map.get(ts.platFormNo);
				tsList.add(ts);
				map.put(ts.platFormNo, tsList);

			}
		}

		int count = 0;
		for (Map.Entry<Integer, List<TrainStatus>> tnListMap : map.entrySet()) {
			List<TrainStatus> tnList = tnListMap.getValue();
			Collections.sort(tnList);

			count++;// default 1 for each platfom
			for (int i = 0; i < tnList.size() - 1; i++) {
				if (tnList.get(i + 1).arrTime >= tnList.get(i).depTime)
					count++;
			}
		}
		return count;
	}

	/** 3. Buy Maximum Stocks if i stocks can be bought on i-th day **/
	public int buyMaxStock(List<StockPrice> list, int price) {
		Collections.sort(list);

		int maxStock = 0;
		for (int i = 0; i < list.size(); i++) {
			if (price < 0)
				break;
			StockPrice sp = list.get(i);
			maxStock += Math.min(sp.day, price / sp.money);
			price -= sp.money * Math.min(sp.day, price / sp.money);
		}
		return maxStock;
	}

	/** 4. Find the minimum and maximum amount to buy all N candies **/
	public int minMaxAmountToBuyAllCandy(int prices[], int noOfOffer, boolean isMinOrMax) {

		Arrays.sort(prices);
		int rs = 0;
		if (isMinOrMax) // ie for minimmm price
		{
			int i = 0;
			int j = prices.length;
			while (i < j) {
				rs += prices[i];
				int k = noOfOffer;
				while (j > i && k != 0) {
					j--;
					k--;
				}
				i++;
			}
		} else { // for maximumm price
			int i = -1;
			int j = prices.length - 1;
			while (i < j) {
				rs += prices[j];
				int k = noOfOffer;
				while (j > i && k != 0) {
					i++;
					k--;
				}
				j--;
			}
		}
		return rs;
	}

	/** 5. Maximum sum possible equal to sum of three stacks **/
	@Override
	public int maxSumEqualtoThreeStack(int stack1[], int stack2[], int stack3[]) {
		int n1 = stack1.length;
		int n2 = stack2.length;
		int n3 = stack3.length;
		int sum1 = 0, sum2 = 0, sum3 = 0;

		// Finding the initial sum of stack1.
		for (int i = 0; i < n1; i++)
			sum1 += stack1[i];

		// Finding the initial sum of stack2.
		for (int i = 0; i < n2; i++)
			sum2 += stack2[i];

		// Finding the initial sum of stack3.
		for (int i = 0; i < n3; i++)
			sum3 += stack3[i];

		// As given in question, first element is top
		// of stack..
		int top1 = 0, top2 = 0, top3 = 0;
		while (true) {
			// If any stack is empty
			if (top1 == n1 || top2 == n2 || top3 == n3)
				return 0;

			// If sum of all three stack are equal.
			if (sum1 == sum2 && sum2 == sum3)
				return sum1;

			// Finding the stack with maximum sum and
			// removing its top element.
			if (sum1 >= sum2 && sum1 >= sum3)
				sum1 -= stack1[top1++];
			else if (sum2 >= sum3 && sum2 >= sum3)
				sum2 -= stack2[top2++];
			else if (sum3 >= sum2 && sum3 >= sum1)
				sum3 -= stack3[top3++];
		}
	}

	/** 6. Maximum elements that can be made equal with k updates **/
	@Override
	public int maxEquals(int a[], int k) {

		Arrays.sort(a);
		int n = a.length;
		int maxEqual = 0;
		int equal = 0;
		for (int i = 1; i < n; i++) {
			int x = k;
			equal = 1;
			for (int j = n - i; j > 0; j--) {
				if (a[n - i] - a[j - 1] <= x) {
					equal++;
					x -= a[n - i] - a[j - 1];
				} else
					break;
			}
			if (equal > maxEqual)
				maxEqual = equal;
		}
		return maxEqual;
	}

	/** 7. Divide cuboid into cubes such that sum of volumes is maximum **/
	@Override
	public int sumOfVolIsMax(int l, int b, int h) {
		// GCD to find side.
		int side = AlgoUtils.gcd(l, AlgoUtils.gcd(b, h));
		System.out.println("side : " + side);
		// dividing to find number of cubes.
		int num = l / side;
		num = (num * b / side);
		num = (num * h / side);
		return num;
	}

	/** 8. Maximum number of customers that can be satisfied with given quantity **/
	@Override
	public List<Character> maxStisfiedCustomer(List<Customer> list, int total, int bagsizeA, int bagSizeB) {
		Collections.sort(list);

		List<Character> resultList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Customer c = list.get(i);
			int aDimand = c.bagA;
			int bDimand = c.bagB;
			if (total - (aDimand + bDimand) >= 0) {
				resultList.add(c.customer);
				total -= (aDimand + bDimand);
			}
		}
		return resultList;
	}

	/** 9. Minimum Fibonacci terms with sum equal to K **/
	public int minFibonacciUse(int a, int b, int K) {
		int result = 0;
		List<Integer> fibList = new ArrayList<>();
		fibList.add(a);
		fibList.add(b);
		int next = a + b;
		while (next < K) {
			fibList.add(next);
			a = b;
			b = next;
			next = a + b;
		}

		for (int i = fibList.size() - 1; i >= 0; i--) {
			if (K == 0)
				break;
			if (K / fibList.get(i) > 0) {
				result += K / fibList.get(i);
				K %= fibList.get(i);
			}
		}
		return result;
	}

	/** 10. Divide 1 to n into two groups with minimum sum difference **/
	public List<List<Integer>> minSumDiff2Group(int n) {
		List<List<Integer>> ll = new ArrayList<>();
		List<Integer> firstG = new ArrayList<>();
		List<Integer> secondG = new ArrayList<>();
		if (n % 2 == 1)
			firstG.add(1);
		boolean flag = true;
		for (int i = n % 2 == 0 ? 1 : 2; i <= n; i += 2) {
			if (flag) {
				firstG.add(i);
				secondG.add(i + 1);
			} else {
				firstG.add(i + 1);
				secondG.add(i);
			}
			flag = !flag;
		}
		ll.add(firstG);
		ll.add(secondG);
		return ll;
	}

	@Override
	public int getMinDiffTwoGroup(List<Integer> firstL, List<Integer> secondL) {
		int sum1 = 0;
		int sum2 = 0;
		for (Integer in : firstL)
			sum1 += in;
		for (Integer ing : secondL)
			sum2 += ing;
		return sum1 == sum2 ? (sum1 - sum2) : (sum1 > sum2 ? sum1 - sum2 : sum2 - sum1);
	}
}
