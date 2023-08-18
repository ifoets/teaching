package interview.preparation.self.asked.company;

import java.util.List;

public interface IMphysis {

	/*
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 */
	// O(n)
	public int maxProfitSingleStockBuyShell(int prices[]);

	/* find the 2nd max value in array by single iteration */
	public int secondMaxSingleIteration(int a[]);

	/*("Australia");"India");("Africa");("Indonesia");("Malaysia"); output ={"AustraliaAA","AfricaAA"};*/
	public List<String> concatFilter(List<String> list);
}
