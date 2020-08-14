package com.design.analysis.company.amazon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.company.hackerrank.google.GoogleImpl;
import com.design.analysis.company.hackerrank.google.IGoogle;

public class IGoogleTest {

	public IGoogle ig = null;

	@Before
	public void init() {
		ig = new GoogleImpl();
	}

	@Test
	public void findGoogleTest() {

		String st[] = { "g<>0l3", "G[]oGIe", "g<>ogl3", "g()()GI3", "g00gle", "g00gle ", "g google", "GGOOGLE",
				"hey google", "G G00gL3", "google", "googIe", };
		boolean bool[] = { false, true, true, true, true, false, false, false, false, false, true, true };

		for (int i = 0; i < st.length; i++)
			Assert.assertTrue(ig.findGoogle(st[i]) == bool[i]);

	}
}
