package com.design.analysis.algo.dynamicprogramming;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/*
 * 
 * @author GuruG
 */
public class IDynamicHardTest {

	public IDynamicHard idh = null;

	@Before
	public void init() {
		idh = new DynamicHardImpl();
	}

	/** 1. Palindrome Partitioning **/
	@Test
	public void palindromePartitionTest() {
		String str = "adbcb";///"ababbbabbababa";// "abcbd";
		List<String> list = idh.palindromePartition(str);
		System.out.println(list.get(0));
	}
}
