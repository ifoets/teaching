package com.design.analysis.core.algo.string;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMiscTest {

	IMisc im = null;

	@Before
	public void init() {
		im = new MiscImpl();
	}

	@Test
	public void checkStringRotationTest() {
		Assert.assertTrue(im.checkStringRotation("abcd", "cdab"));
		Assert.assertTrue(im.checkStringRotation("abcdefghi", "fghiabcde"));
	}

	@Test
	public void duplicateCountTest() {
		Map<Character, Integer> map1 = im.duplicateCount("test string");
		Assert.assertTrue(map1.get('t') == 3);
		Assert.assertTrue(map1.get('s') == 2);
	}

	@Test
	public void duplicateCountXTest() {
		Map<Character, Integer> map1 = im.duplicateCountX("test string");
		System.out.println(map1);
		Assert.assertTrue(map1.get('t') == 3);
		Assert.assertTrue(map1.get('s') == 2);
	}

	@Test
	public void firstNonReapetinCharTest() {
		Assert.assertTrue(im.firstNonReapetinChar("GeeksforGeeks") == 'f');
		Assert.assertTrue(im.firstNonReapetinChar("abcdefabclmn") == 'd');
	}

	@Test
	public void lastNonReapetinCharTest() {
		Assert.assertTrue(im.lastNonReapetinChar("GeeksforGeeks") == 'r');
		Assert.assertTrue(im.lastNonReapetinChar("abcdefabclmn") == 'n');
	}

	@Test
	public void listItemContaingAllCharTest() {
		String list[] = { "sunday", "geeksforgeeks", "utensils", "just", "sss" };
		String key = "sun";
		List<String> listResult = im.listItemContaingAllChar(list, key);
		Assert.assertTrue(listResult.get(0).equals("sunday"));
		Assert.assertTrue(listResult.get(1).equals("utensils"));
	}

	@Test
	public void reverseWordInStringTest() {
		System.out.println(im.reverseWordInString("geeks quiz practice code"));
		System.out.println(im.reverseWordInString("getting good at coding needs a lot of practice"));
		Assert.assertTrue(im.reverseWordInString("geeks quiz practice code").equals("edoc ecitcarp ziuq skeeg"));
		Assert.assertTrue(im.reverseWordInString("getting good at coding needs a lot of practice")
				.equals("ecitcarp fo tol a sdeen gnidoc ta doog gnitteg"));
	}

	@Test
	public void reverseWordTest() {
		System.out.println(im.reverseWord("abhimanyu"));
		Assert.assertTrue(im.reverseWord("abhimanyu").equals("uynamihba"));
	}

	@Test
	public void runLengthEncodedTest() {
		Assert.assertTrue(im.runLengthEncoded("wwwwaaadexxxxxx").equals("w4a3d1e1x6"));
	}

	@Test
	public void allPermutationTest() {
		im.allPermutation("", "abc");
	}

	@Test
	public void removeAllAdjacentTest() {

	}

	// String list[] = { "sunday", "geeksforgeeks", "utensils", "just", "sss" };
	// String key = "sun";
	// System.out.println(listItemContaingAllChar(list, key));
	// System.out.println(null+"a");
	// System.out.println(reverseWord("abhimanyu"));
	// System.out.println(reverseWordInString("I love programming very much"));
	// System.out.println(runLengthEncoded("wwwwaaadexxxxxx")); //w4a3d1e1x6
	// //w4a3d1e1x6
	// System.out.println("abcbac");

	// String str="ABC";
	// allPermutation("","abc");

	/*
	 * List<Character> list = new ArrayList<>(); list.add('a'); list.add('b');
	 * list.add('c');
	 * 
	 * System.out.println(String.valueOf(list.toArray()));
	 */
	// removeAllAdjacent("azxxzy");
	// removeAllAdjacent("geeksforgeeg");
}
