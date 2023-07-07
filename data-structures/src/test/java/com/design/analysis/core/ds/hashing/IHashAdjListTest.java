package com.design.analysis.core.ds.hashing;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.Hash;

public class IHashAdjListTest {

	public IHashAdjList hl = null;

	@Before
	public void init() {
		hl = new HashAdjListImpl();
	}

	@Test
	public void addHashNodeTestTest() {
		Hash h = new Hash(100);
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			int rVal = r.nextInt((1999999999 - 1000000000) + 1) + 1000000000;
			hl.addHashNode(h, String.valueOf(rVal));
		}
		hl.print(h);
	}
}
