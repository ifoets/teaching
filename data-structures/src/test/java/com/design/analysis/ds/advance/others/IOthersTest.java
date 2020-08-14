package com.design.analysis.ds.advance.others;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.advance.others.node.TernaryNode;

public class IOthersTest {

	public IOthers<Character, Integer> iots = null;
	TernaryNode<Character> root = null;

	@Before
	public void init() {
		iots = new OthersImpl();
	}

	/** 1. Palindromic Tree | Introduction & Implementation **/

	/** 2. Ternary Search Tree **/
	@Test
	public void insertTest() {

		String[] strArr = { "cat", "cats", "up", "bug" };
		for (String str : strArr) {
			char charArr[] = str.toCharArray();
			Character cAr[] = new Character[charArr.length];
			for (int i = 0; i < cAr.length; i++)
				cAr[i] = charArr[i];
			root = iots.insert(root, cAr, 0);
		}
	}

	@Test
	public void traverseTest() {

		String[] strArr = { "cat", "cats", "up", "bug" };
		for (String str : strArr) {
			char charArr[] = str.toCharArray();
			Character cAr[] = new Character[charArr.length];
			for (int i = 0; i < cAr.length; i++)
				cAr[i] = charArr[i];
			root = iots.insert(root, cAr, 0);
		}
		iots.traverse(root, new String());
	}

	@Test
	public void searchTest() {

		String[] strArr = { "cat", "cats", "up", "bug" };
		for (String str : strArr) {
			char charArr[] = str.toCharArray();
			Character cAr[] = new Character[charArr.length];
			for (int i = 0; i < cAr.length; i++)
				cAr[i] = charArr[i];
			root = iots.insert(root, cAr, 0);
		}
		String str1 = "but";
		String str2 = "up";
		Character cha1[] = new Character[str1.length()];
		Character cha2[] = new Character[str2.length()];
		for (int i = 0; i < str1.length(); i++)
			cha1[i] = str1.charAt(i);
		for (int i = 0; i < str2.length(); i++)
			cha2[i] = str2.charAt(i);
		Assert.assertTrue(iots.search(root, cha1, 0) == false);
		Assert.assertTrue(iots.search(root, cha2, 0) == true);
	}

	@Test
	public void deleteTest() {
		String[] strArr = { "cat", "cats", "up", "bug" };
		for (String str : strArr) {
			char charArr[] = str.toCharArray();
			Character cAr[] = new Character[charArr.length];
			for (int i = 0; i < cAr.length; i++)
				cAr[i] = charArr[i];
			root = iots.insert(root, cAr, 0);
		}
		String str1 = "cats";
		Character cha1[] = new Character[str1.length()];
		for (int i = 0; i < str1.length(); i++)
			cha1[i] = str1.charAt(i);
		iots.delete(root, cha1, 0);
		iots.traverse(root, new String());
	}
}
