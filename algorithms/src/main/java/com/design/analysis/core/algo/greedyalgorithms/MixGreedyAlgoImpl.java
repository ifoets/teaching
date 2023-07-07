package com.design.analysis.core.algo.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.design.analysis.core.algo.common.JobSequencing;
import com.design.analysis.core.algo.greedyalgorithms.model.TimeEvent;

public class MixGreedyAlgoImpl implements IMixGreedyAlgo {

	/** 1. Minimum time to finish all jobs with given constraints **/
	@Override // workTime: working hour in day
	public Integer minTimeToFinishJobByKEmpl(Integer jobTime[], int noOfemp, int workTime) {

		Arrays.sort(jobTime, Collections.reverseOrder()); // O(nlog(n)) decending order
		int maxDay = 0;
		int assingTime[] = new int[noOfemp];
		int k = 0;
		boolean reverseToAdd = true;
		for (int i = 0; i < jobTime.length; i++) {
			if (reverseToAdd)
				assingTime[k++] += jobTime[i];
			else
				assingTime[--k] += jobTime[i];
			if (k == 0 || k == noOfemp)
				reverseToAdd = !reverseToAdd;
		}

		for (int j = 0; j < assingTime.length; j++)
			if (maxDay < assingTime[j])
				maxDay = assingTime[j];

		return maxDay * workTime;
	}

	/** 2. Job Sequencing Problem | Set 2 (Using Disjoint Set) **/
	@Override
	public List<String> jobSequencingProblem(List<JobSequencing> list) {
		Collections.sort(list);
		List<String> result = new ArrayList<>();
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
		return result;
	}

	/**
	 * 3. Minimum sum of two(X) numbers formed from digits of an array values are
	 * from 0 to 9 need to use all no, it is also use of minmum multiple with some
	 * changes require 358 and 246
	 **/
	@Override
	public int minSumOfTwoNoFormByAllElem(int a[], int xNums) {
		Arrays.sort(a);// for Max sum/multiple use reverse sorting
		int num[] = new int[xNums];
		int result = 0;

		for (int i = 0; i < a.length; i++)
			num[i % xNums] = num[i % xNums] * 10 + a[i];

		for (int j = 0; j < xNums; j++)
			result += num[j];
		return result;
	}

	/**
	 * 4. Find Smallest number with given number of digits and digits sum simillar
	 * concept use for Biggest no..change comfortableForLeastDigit
	 **/

	/* it check for 1 not then for 2 so on.... */
	@Override
	public boolean comfortableForLeastDigit(int minDigit, int sum, int noOfDigits) {

		float x = (sum - minDigit) / 9f;
		float y = noOfDigits - 1;
		return x <= y ? true : false;
	}

	@Override
	public Integer minNoByGivenSumAndNoOfDigit(int sum, int noOfDigits) {

		if (sum <= 0 || sum > noOfDigits * 9)
			return null;
		// last disigt atleast 1 after subtracting
		int rsArr[] = new int[noOfDigits];
		int result = 0;

		for (int i = 0; i < rsArr.length; i++) {
			if (i == rsArr.length - 1) {
				rsArr[i] = sum;
				break;
			}
			for (int j = 1; j < 10; j++) {
				if (comfortableForLeastDigit(j, sum, noOfDigits)) {
					rsArr[i] = j;
					sum = sum - j;
					noOfDigits--;
					break;
				}
			}

		}
		for (int j = 0; j < rsArr.length; result = result * 10 + rsArr[j], j++)
			;
		return result;
	}

	/** 5. Connect n ropes with minimum cost...u may use heaping **/
	public Integer connectNRopsInMinCost(Integer ropArr[]) {

		int ropSize = 0;
		int rop1 = 0;
		int rop2 = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < ropArr.length; i++)
			pq.add(ropArr[i]);

		while (pq.size() != 1) {
			rop1 = pq.poll();
			rop2 = pq.poll();
			ropSize += (rop1 + rop2);
			pq.add(rop1 + rop2);
		}
		return ropSize;
	}

	/** 6. Minimum number of Platforms required for a railway/bus station **/
	public Integer minNoOfPlatform(int[] arrivalTimes, int[] departureTimes) {

		if (arrivalTimes == null || departureTimes == null || arrivalTimes.length != departureTimes.length)
			return null;
		List<TimeEvent> timeList = new ArrayList<>();
		int maxPlatform = 0;
		int currentNoOfPlatform = 0;

		for (int i = 0; i < arrivalTimes.length; i++) {
			timeList.add(new TimeEvent(arrivalTimes[i], true));
			timeList.add(new TimeEvent(departureTimes[i], false));
		}
		Collections.sort(timeList);

		for (TimeEvent te : timeList) {
			if (te.arrDepr)
				currentNoOfPlatform++;
			else
				currentNoOfPlatform--;
			if (maxPlatform < currentNoOfPlatform)
				maxPlatform = currentNoOfPlatform;
		}
		return maxPlatform;
	}

	/**
	 * 7. Minimum sum of absolute difference of pairs of two arrays for max sum sort
	 * 1 array ascending and another in decending
	 **/
	public Integer minSumByDiffOfTowArr(int a[], int b[]) {
		if (a == null || b == null || a.length != b.length)
			return null;
		int sum = 0;
		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < a.length; i++)
			sum = sum + Math.abs(a[i] 
					- b[i]);
		return sum;
	}

	/** 8. Maximize sum of consecutive differences in a circular array **/
	public Integer maxSumConsDifOfCircularArr(int arr[]) {

		int sum = 0;
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			sum -= (2 * arr[i]);
			sum += (2 * arr[n - i - 1]);
		}
		return sum;
	}

	/** 9. Paper cut into minimum number of squares **/
	public Integer cutPaperIntoMinNoOfSquare(int height, int width) {
		int min, max;
		if (height == width)
			return 1;
		else if (height == 0 || width == 0)
			return 0;
		else if (height > width) {
			min = width;
			max = height;
		} else {
			min = height;
			max = width;
		}
		int n1 = max / min;
		return n1 + cutPaperIntoMinNoOfSquare(min, max - n1 * min);
	}

	/**
	 * 10. Minimize sum of product of two arrays with permutation allowed.. For Max
	 * sum of porduct sort both array in assending order
	 **/
	public Integer minSumOfProductOfTwoArrays(Integer a[], Integer b[]) {

		if (a == null || b == null || a.length != b.length)
			return null;
		int prod = 0;
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());

		for (int i = 0; i < a.length; i++)
			prod = prod + a[i] * b[i];
		return prod;
	}
}
