package interview.preparation.self.asked.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class IMphysisTest {

	IMphysis imp = null;

	@Before
	public void init() {
		imp = new MphysisImpl();
	}

	/*
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 */
	// O(n)
	@Test
	public void maxProfitSingleStockBuyShellTest() {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		Assert.assertTrue(imp.maxProfitSingleStockBuyShell(a) == 5);
	}

	/* find the 2nd max value in array by single iteration */
	@Test
	public void secnodMaxSingleIterationTest() {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		Assert.assertTrue(imp.secondMaxSingleIteration(a) == 5);
	}
	/*("Australia");"India");("Africa");("Indonesia");("Malaysia"); output ={"AustraliaAA","AfricaAA"};*/
	@Test
	public void concatFilterTest(){
	List<String> list = List.of("Australia","India","Africa","Indonesia","Malaysia");
	System.out.println(imp.concatFilter(list).toString());
	Assert.assertTrue(imp.concatFilter(list).containsAll(List.of("AustraliaAA","AfricaAA")));
	}
}
