package interview.preparation.self.asked.company;

import java.util.Arrays;
import java.util.Comparator;

public class MphysisImpl implements IMphysis {

	/*
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock. Input: prices
	 * = [7,1,5,3,6,4] Output: 5
	 */
	// OC(n)
	public int maxProfitSingleStockBuyShell(int a[]) {

		int N = a.length;
		int min_price = Integer.MAX_VALUE;
		int max_profit = 0;

		for (int i = 0; i < N; i++) {
			if (min_price > a[i]) {
				min_price = a[i];
			} else {
				max_profit = Math.max(max_profit, a[i] - min_price);
			}
		}
		return max_profit;
	}

	/* fid the 2nd max value in array by single iteration */
	public int secnodMaxSingleIteration(int a[]) {
		int N = a.length;
		int fmx;
		int smx;
		fmx = smx = 0;
		for (int i = 0; i < N; i++) {
			if (a[i] > smx) {
				if (a[i] > fmx) {
					int temp = fmx;
					fmx = a[i];
					smx = temp;
				} else {
					smx = a[i];
				}
			}
		}
		return smx;
	}

}
