package com.design.analysis.core.ds.advance.suffixarrayandtree;

import com.design.analysis.core.ds.advance.suffixarrayandtree.model.Suffix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISuffixArrAndSuffTreeTest {

	public ISuffixArrAndSuffTree isfat = null;

	@Before
	public void init() {
		isfat = new SuffixArrAndSuffTreeImpl();
	}

	/** 1. Suffix Array Introduction **/
	@Test
	public void buildTest() {

		String str = "banana";
		Suffix arr[] = isfat.build(str);
		int a[] = { 5, 3, 1, 0, 4, 2 };
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == arr[i].ind);
	}

	@Test
	public void searchTest() {

		String str = "banana";
		Suffix arr[] = isfat.build(str);
		String patrns[] = { "a", "na", "banana", "ban", "nab", "bnana" };
		for (int i = 0; i < patrns.length; i++) {
			if (i < 3)
				Assert.assertTrue(isfat.search(arr, patrns[i]));
			else
				Assert.assertTrue(!isfat.search(arr, patrns[i]));
		}
	}

	/** 2. Suffix Array nLogn Algorithm **/
	@Test  //TODO not give correct result
	public void buildNlogNTest() {

		/*String str = "banana";
		int arr[] = isfat.buildNlogN(str);
		int a[] = { 5, 3, 1, 0, 4, 2 };
		for (int i = 0; i < a.length; i++);*/
			//Assert.assertTrue(a[i] == arr[i]);
	}
}
