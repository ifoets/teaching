package com.design.analysis.company.hakarrank.goldmansachs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IGoldmanSachsTest {

	public IGoldmanSachs igs = null;

	@Before
	public void init()

	{
		igs = new GoldmanSachsImpl();
	}

	@Test
	public void feeOrUpfrontTest() {

		int n, k, x, d;
		int p[] = { 100, 200, 300 };
		n = 3;
		k = 20;
		x = 10;
		d = 60;
		Assert.assertTrue(igs.feeOrUpfront(n, k, x, d, p).equals("upfront"));
		n = 3;
		k = 20;
		x = 15;
		d = 120;
		int a[] = { 200, 250, 300 };
		Assert.assertTrue(igs.feeOrUpfront(n, k, x, d, a).equals("free"));

		n = 1;
		k = 1;
		x = 10;
		d = 100;
		int b[] = { 1000 };
		Assert.assertTrue(igs.feeOrUpfront(n, k, x, d, b).equals("free"));
	}

	/** Buy Maximum Stocks ..max i stock by on ith day **/
	@Test
	public void buyMaxStocksTest() {

		int a[] = { 7, 10, 4 };
		int N = a.length;
		Assert.assertTrue(igs.buyMaximumProducts(N, 39, a) == 6);
		Assert.assertTrue(igs.buyMaximumProducts(N, 38, a) == 5);
		int b[] = { 10, 7, 19 };
		Assert.assertTrue(igs.buyMaximumProducts(N, 45, b) == 4);
	}

	/** max profit get the stocker in k transaction*F */

	@Test
	public void traderProfitTest() {
		int a[] = { 12, 5, 10, 7, 17 };
		Assert.assertTrue(igs.traderProfit(a, 1) == 12);

		int b[] = { 10, 22, 5, 75, 65, 80 };
		Assert.assertTrue(igs.traderProfit(b, 2) == 87);

		int c[] = { 20, 580, 420, 900 };

		Assert.assertTrue(igs.traderProfit(c, 4) == 1040);

		int d[] = { 100, 90, 80, 50, 25 };
		Assert.assertTrue(igs.traderProfit(d, 5) == 0);
	}

	/** Time Series Queries **/
	/*
	 * 1 .For type 1, given a value , when was the first time that the price of the
	 * stock was at least v? 2. For type 2, given a value , what's the maximum price
	 * of the stock at a time greater or equal to v?
	 */
	@Test
	public void queryTest() {
		int t[] = { 1, 2, 4, 8, 10 };
		int p[] = { 5, 3, 12, 1, 10 };
		int type[] = { 1, 1, 2, 2, 1 };
		int val[] = { 10, 4, 8, 3, 13 };
		int ans[] = { 4, 1, 10, 12, -1 };
		for (int i = 0; i < val.length; i++)
			Assert.assertTrue(igs.query(t, p, type[i], val[i]) == ans[i]);

	}

	// **hackerran test question*/
	/** Non reapeating digits in producct **/
	/*
	 * Given a number x and a range y to z please find the count of all the numers n
	 * that range such that the porduct of the number n and x does not contian any
	 * digit from the number n
	 */
	@Test
	public void nonRepeatingDigitProductCountTest() {
		Assert.assertTrue(igs.nonRepeatingDigitProductCount(2, 10, 15) == 4);
	}

	/** Number Patterns & finding the the possible smallest numeric value **/
	@Test
	public void smallestTest() {
		System.out.println(igs.smallest("MNM"));
		Assert.assertTrue(igs.smallest("MNM") == 2143);
	}

	/** live coding round **/
	/** find average in two sorted array */
	@Ignore
	public void findAverageTest() {
		int a[] = { 1, 3 };
		int b[] = { 2, 4 };
		Assert.assertTrue(igs.findAverage(a, b) == 2.5);

		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };
		Assert.assertTrue(igs.findAverage(ar1, ar2) == 16);

		int A[] = { 900 };
		int B[] = { 5, 8, 10, 20 };

		Assert.assertTrue(igs.findAverage(A, B) == 10);

		int a1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b1[] = { 100, 200, 300, 400, 500 };
		Assert.assertTrue(igs.findAverage(a1, b1) == 7.5);

		int x[] = { 2, 4, 6, 8, 10, 11, 12 };// { 2, 7, 10 };
		int y[] = { 1, 3, 5, 7, 9 };// { 4, 5 };
		Assert.assertTrue(igs.findAverage(x, y) == 6);

		int t[] = { 2, 7, 10 };
		int n[] = { 4, 5 };

		Assert.assertTrue(igs.findAverage(t, n) == 5);

	}

}
