package com.hackerrank.easy.basic.greedy;



import com.hackerrank.easy.basic.model.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicEasyGreedyImpl implements IBasicEasyGreedy {

	/* Minimum Absolute Difference in an Array */
	// @Idea Sort and check corresponding difference
	@Override
	public int minimumAbsoluteDifference(List<Integer> arr) {
		int min = Integer.MAX_VALUE;
		arr = arr.stream().sorted().collect(Collectors.toList());
		for (int i = 0; i < arr.size() - 1; i++) {
			int val = Math.abs(arr.get(i + 1) - arr.get(i));
			if (min > val)
				min = val;
		}
		return min;
	}

	/* Marc's Cakewalk */
	// @Idea for Min Reverse sort and multiply with 2 to the power of incremental
	// value
	@Override
	public long marcsCakewalk(List<Integer> calorie) {
		long min = 0;
		int pow = 0;
		calorie = calorie.stream().sorted(Comparator.comparing(Integer::intValue).reversed())
				.collect(Collectors.toList());
		for (Integer i : calorie)
			min += i * Math.pow(2, pow++);
		return min;
	}

	/* Grid Challenge */
	// @Idea Sort each strings and then check downwards in inner loop
	@Override
	public String gridChallenge(List<String> grid) {
		List<String> list = new ArrayList<>();
		for (String st : grid) {
			list.add(Stream.of(st.split("")).sorted().collect(Collectors.joining()));
		}
		for (int i = 0; i < grid.get(0).length(); i++) {
			for (int j = 0; j < grid.size() - 1; j++) {
				if (list.get(j).charAt(i) > list.get(j + 1).charAt(i))
					return "NO";
			}
		}
		return "YES";
	}

	/* Luck Balance */
	// @Idea sort first based on important contests then on unimportant contest
	@Override
	public int luckBalance(int k, List<List<Integer>> contests) {
		int result = 0;
		List<Contest> list = new ArrayList<>();
		for (List<Integer> inList : contests) {
			list.add(new Contest(inList.get(0), inList.get(1)));
		}

		list = list.stream().sorted(Comparator.comparing(Contest::getImp).thenComparing(Contest::getContst).reversed())
				.collect(Collectors.toList());

		for (Contest c : list) {
			if (k > 0) {
				result += c.contst;
				k--;
			} else if (c.imp == 0) {
				result += c.contst;
			} else if (k == 0) {
				result -= c.contst;
			}
		}
		return result;
	}

	/* Maximum Perimeter Triangle */
	// @Idea sort and travel from and check tringle conditiaon a+b>c
	@Override
	public List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
		List<Integer> result = new ArrayList<>();
		sticks = sticks.stream().sorted().collect(Collectors.toList());
		Integer[] a = sticks.toArray(new Integer[sticks.size()]);
		;
		int n = sticks.size();
		int i;
		for (i = n - 1; i > 1; i--) {
			if (a[i] < a[i - 1] + a[i - 2]) {
				result.add(a[i - 2]);
				result.add(a[i - 1]);
				result.add(a[i]);
				break;
			}
		}
		if (i == 1 && result.size() == 0)
			result.add(-1);
		return result;
	}

	/* Priyanka and Toys */
	// @Idea take min and max =min+4 and traverse with count
	@Override
	public int toys(List<Integer> w) {
		Integer[] a = w.toArray(new Integer[w.size()]);
		Arrays.sort(a);
		int n = a.length;
		int count = n > 1 ? 1 : 0;
		int min = a[0];
		int max = min + 4;

		for (int i = 0; i < n; i++) {
			if (a[i] > max) {
				max = a[i] + 4;
				count++;
			}
		}
		return count;
	}

	/* Largest Permutation */
	// @Idea store the i to new i[a[i], swap 0,1,2 th indexed with max 2nd max etc
	@Override
	public List<Integer> largestPermutation(int k, List<Integer> arr) {
		int n = arr.size();
		Integer[] a = new Integer[n];
		int[] index = new int[n + 1];
		for (int i = 0; i < n; i++) {
			a[i] = arr.get(i);
			index[a[i]] = i;
		}
		for (int i = 0; i < n && k > 0; i++) {
			if (a[i] == n - i) {
				continue;
			}
			// need to make clear i 2nd round
			a[index[n - i]] = a[i];
			index[a[i]] = index[n - i];
			a[i] = n - i;
			index[n - i] = i;
			k--;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		return Arrays.asList(a);
	}

	/* Mark and Toys */
	// @Idea, Sort and find the max sum<=k
	@Override
	public int maximumToys(List<Integer> prices, int k) {
		Integer[] a = prices.toArray(new Integer[prices.size()]);
		Arrays.sort(a);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum < k)
				count++;
			else
				break;
		}
		return count;
	}

	/* Beautiful Pairs */
	// @Idea check no of equals in both
	@Override
	public int beautifulPairs(List<Integer> A, List<Integer> B) {
		int N = A.size();

		int a[] = new int[1001];
		for (int i = 0; i < 1001 && i < N; i++) {
			a[A.get(i)]++;
			a[B.get(i)]++;
		}
		int count = 0;
		for (int i = 0; i < 1001; i++) {
			if (a[i] > 0) {
				count += a[i] / 2;
			}
		}
		if (count < N)
			return count + 1;
		else // count == N i.e., no duplicates present
			return count - 1;
	}
}