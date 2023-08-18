package interview.preparation.self.asked.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	public int secondMaxSingleIteration(int a[]) {
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
	/*("Australia");"India");("Africa");("Indonesia");("Malaysia"); output ={"AustraliaAA","AfricaAA"};*/
	@Override
	public List<String> concatFilter(List<String> list){
		return list.stream().filter(e -> e.startsWith("A"))
				.map(e-> (new StringBuilder(e).append((e.charAt(0)+"").repeat(2))).toString())
				.collect(Collectors.toList());
	}
}
