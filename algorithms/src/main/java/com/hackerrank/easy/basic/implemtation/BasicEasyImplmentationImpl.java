package com.hackerrank.easy.basic.implemtation;

import java.util.*;
import java.util.stream.Collectors;

public class BasicEasyImplmentationImpl implements IBasicEasylmentationImp {

	/** Implementation **/ // start....

	/* count Apple and Orange */
	// @Idea add all list of apples and orange fall point with base of respective
	// tree and check whose lies on floor
	@Override
	public int[] countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
		int fruitCount[] = new int[2];
		for (int i : apples) {
			if (s <= a + i && a + i <= t)
				fruitCount[0]++;
		}
		for (int i : oranges) {
			if (s <= b + i && b + i <= t)
				fruitCount[1]++;
		}
		return fruitCount;
	}

	@Override
	public long[] countApplesAndOrangesStream(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
		long fruitCount[] = new long[2];
		fruitCount[0] = apples.stream().filter(i -> s <= a + i && a + i <= t).count();
		fruitCount[1] = oranges.stream().filter(i -> s <= b + i && b + i <= t).count();
		return fruitCount;
	}

	/* Number Line Jumps */
	// @Idea initial point and velocity of one is greater then other never catch
	// otherwise there will be a chance
	@Override
	public String kangaroo(int x1, int v1, int x2, int v2) {

		if (x1 < x2 && v1 < v2 || x2 < x1 && v2 < v1)
			return "NO";
		for (int i = 1; i <= 10000; i++) {
			int a = x1 + v1 * i;
			int b = x2 + v2 * i;
			if (a == b)
				return "YES";
		}
		return "NO";
	}

	/* Between Two Sets */
	// @Idea Sort for order,
	// integers lies between last of and initial of b with multiple of a(the
	// biggest)
	@Override
	public int getTotalX(List<Integer> a, List<Integer> b) {

		int count = 0;
		boolean nextCheck = true;
		for (int x = a.get(a.size() - 1); x <= b.get(0); x++) {
			nextCheck = true;
			// x = x * i;
			for (Integer p : a) {
				if (x % p != 0) {
					nextCheck = false;
					break;
				}
			}
			if (nextCheck) {
				for (Integer q : b) {
					if (q % x != 0) {
						nextCheck = false;
						break;
					}
				}
			}
			if (nextCheck)
				count++;
		}
		return count;
	}

	/* Breaking the Records */
	// @Idea keep max min in hand and count change of max and min and update max min
	// together
	public List<Integer> breakingRecords(List<Integer> scores) {
		List<Integer> result = new ArrayList<>();

		int max = scores.get(0);
		int min = scores.get(0);
		int maxCount = 0;
		int minCount = 0;

		for (Integer x : scores) {
			if (max < x) {
				max = x;
				maxCount++;
			}
			if (min > x) {
				min = x;
				minCount++;
			}
		}
		result.add(maxCount);
		result.add(minCount);
		return result;

	}

	/* Subarray Division */
	// @Idea loop inner loop of length m and find sum d on continuous sum
	@Override
	public int birthday(List<Integer> s, int d, int m) {

		int count = 0;
		for (int i = 0; i < s.size(); i++) {
			int sum = 0;
			for (int j = i; j < i + m && j < s.size(); j++) {
				sum += s.get(j);
			}
			if (sum == d)
				count++;
		}
		return count;
	}

	@Override
	// @Idea start i=0 and j=i+1 and find a[i]+a[j]%k==0
	public int divisibleSumPairs(int n, int k, List<Integer> ar) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((ar.get(i) + ar.get(j)) % k == 0)
					count++;
			}
		}
		return count;
	}

	@Override
	// @Idea find the count then find the min key of max count
	public int migratoryBirds(List<Integer> arr) {
		TreeMap<Integer, Integer> tMap = new TreeMap<>();
		int maxVal = Integer.MIN_VALUE;
		int minKey = Integer.MAX_VALUE;
		for (Integer i : arr) {
			if (tMap.containsKey(i)) {
				int val = tMap.get(i) + 1;
				tMap.put(i, val);
				if (maxVal < val)
					maxVal = val;
			} else
				tMap.put(i, 1);
		}
		int key;
		for (Map.Entry<Integer, Integer> map : tMap.entrySet()) {
			key = map.getKey();
			if (map.getValue() == maxVal && minKey > key)
				minKey = key;

		}
		return minKey;
	}

	@Override
	// @Idea collect count, reverse sort by value then by key and return first key
	public int migratoryBirdsStream(List<Integer> arr) {
		Map<Integer, Long> map = arr.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()))
				.entrySet().stream()
				.sorted(Comparator.comparing((Map.Entry<Integer, Long> m) -> -m.getValue())
						.thenComparing(Map.Entry::getKey))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return  map.entrySet().stream().findFirst().get().getKey();

	}

	/* Day of the Programmer/256 th Day */
	// @Idea for mainly find the feb no of days
	public String dayOfProgrammer(int year) {
		int pday = 256;
		int feb = 0;
		int a[] = { 31, 0, 31, 30, 31, 30, 31, 31, 30 };

		if (year <= 1917) {
			feb = year % 4 == 0 ? 29 : 28;
		} else if (year == 1918) {
			feb = 15; // 14 th fab is 1st day ie feb have only 15 day
		} else {
			feb = ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
		}

		a[1] = feb;
		for (int i = 0; i < a.length; i++) {
			pday = pday - a[i];
			if (pday < 30) {
				return pday + ".0" + (i + 2) + "." + year;
			}
		}
		return "";
	}

	/* Bill Division */
	// @Idea add bill except k indexed divide by 2 for actual bill
	public void bonAppetit(List<Integer> bill, int k, int b) {
		int bActual = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i != k)
				bActual += bill.get(i);
		}
		bActual = bActual / 2;
		if (bActual == b)
			System.out.println("Bon Appetit");
		else
			System.out.println(b - bActual);
	}

	/* Sales by Match */
	// @Idea collect the count of each key, then divide by/2 the counts and sum
	@Override
	public int sockMerchant(int n, List<Integer> ar) {
		Map<Integer, Long> map = ar.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
		return map.values().stream().mapToInt(k -> (int) (k / 2)).sum();
	}

	/* Drawing Book */
	// @Idea travel start:0 and end:n check matching p with each step start+=2,
	// end-=2
	@Override
	public int pageCount(int n, int p) {// 6,2

		int i = 0;
		int j = n;
		int count = 0;
		while (i <= j) {
			if (p == i || p == i + 1 || p == j || p == j - 1)
				break;
			i += 2;
			j -= 2;
			count++;
		}
		return count;
	}

	/* Counting Valleys */
	// @Idea start from 0 and count zero/sea level where direction up/U with step
	// up:+1 and down:-1
	@Override
	public int countingValleys(int steps, String path) {

		int seaLevel = 0;
		int countVally = 0;
		char[] pathArray = path.toCharArray();
		for (char c : pathArray) {
			if (c == 'U')
				seaLevel++;
			else if (c == 'D')
				seaLevel--;
			if (c != 'D' && seaLevel == 0)
				countVally++;
		}
		return countVally;
	}

	/* Electronics Shop */
	@Override
	// @Idea match a[i]+b[j] max where max<b
	public int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int cost = keyboards[i] + drives[j];
				if (max < cost && cost <= b)
					max = cost;
			}
		}
		return max == Integer.MIN_VALUE ? -1 : max;
	}

	/* Cats and a Mouse */
	// @Idea find the absolute difference of distance of each cat from mouse
	@Override
	public String catAndMouse(int x, int y, int z) {

		if (Math.abs(x - z) < Math.abs(y - z))
			return "Cat A";
		else if (Math.abs(x - z) > Math.abs(y - z))
			return "Cat B";
		return "Mouse C";
	}

	@Override
	// @Idea collect the count and find the max sum of two contineous count
	public int pickingNumbers(List<Integer> a) {
		int maxLenSubArray = Integer.MIN_VALUE;
		int max = a.stream().mapToInt(x -> x).max().orElseThrow();
		int b[] = new int[max + 1];
		for (int i = 0; i < a.size(); b[a.get(i)]++, i++)
			;

		for (int i = 0; i < b.length - 1; i++) {
			if (maxLenSubArray < b[i] + b[i + 1])
				maxLenSubArray = b[i] + b[i + 1];
		}
		return maxLenSubArray;
	}

	/* The Hurdle Race */
	// @Idea find the max height and return max-k if +ve or 0
	@Override
	public int hurdleRace(int k, List<Integer> height) {
		int max = height.stream().mapToInt(x -> x).max().orElseThrow();
		if (max >= k)
			return max - k;
		return 0;
	}

	/* Designer PDF Viewer */
	// @Idea find the max height of letter and return multiply by word length;
	// 97 ascii value of a ie. 0 position in list
	@Override
	public int designerPdfViewer(List<Integer> h, String word) {

		int max = Integer.MIN_VALUE;
		char wordChar[] = word.toCharArray();
		for (Character c : wordChar) {
			if (max < h.get(c - 97))
				max = h.get(c - 97);
		}
		return word.length() * max;
	}

	/** Implementation **/ // continue....
	/**********************************************************************************************************************************************************************/

}