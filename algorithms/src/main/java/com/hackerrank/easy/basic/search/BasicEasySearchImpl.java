package com.hackerrank.easy.basic.search;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BasicEasySearchImpl implements IBasicEasySearch {

	/* Missing Numbers */
	// @idea count the element at their index and compare
	@Override
	public List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
		List<Integer> rList = new ArrayList<>();

		Integer[] ar = arr.toArray(new Integer[arr.size()]);
		Integer[] br = brr.toArray(new Integer[brr.size()]);

		int maxAr = arr.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
		int maxBr = brr.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

		int a[] = new int[maxAr + 1];
		int b[] = new int[maxBr + 1];

		for (int i = 0; i < ar.length; a[ar[i]]++, i++)
			;
		for (int i = 0; i < br.length; b[br[i]]++, i++)
			;

		for (int i = 0; i < b.length; i++) {
			if (b[i] > a[i])
				rList.add(i);
		}
		return rList;
	}

	/*Sherlock and Array*/
	//@Idea (sum - 2*pref  == arr.get(i)
	@Override
	public String balancedSums(List<Integer> arr) {
		// Write your code here
		int sum = 0;
		for (int su : arr) {
			sum += su;
		}
		for (int i = 0, pref = 0; i < arr.size(); i++) {
			if (sum - 2*pref  == arr.get(i)) {

				return "YES";
			}
			pref += arr.get(i);
		}
		return "NO";
	}
}