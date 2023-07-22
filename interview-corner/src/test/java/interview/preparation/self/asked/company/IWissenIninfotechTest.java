package interview.preparation.self.asked.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.company.preparation.model.LNode;
import com.design.analysis.company.preparation.utils.SListUtils;

public class IWissenIninfotechTest {

	IWissenIninfotech iw = null;

	@Before
	public void init() {
		iw = new WissenIninfotechImpl();
	}

	/** 1. Add values in map so it map print sorted order based on values */
	@Test
	public void getMapOrderByValuesTest() {
		Assert.assertTrue(iw.getMapOrderByValues(getFilledMapValue()).equals(getSortedFilledValue()));

	}

	@Test
	public void getMapOrderByValuesTestX() {
		Assert.assertTrue(iw.getMapOrderByValuesX(getFilledMapValue()).equals(getSortedFilledValue()));

	}

	@Test
	public void getMapOrderByValuesTestY() {
		Map<String, String> map = new TreeMap<>();
		map.put("Tokyo", "b");
		map.put("New York", "c");
		map.put("Delhi", "a");

		Map<String, String> mapresult = new LinkedHashMap<>();
		mapresult.put("Delhi", "a");
		mapresult.put("Tokyo", "b");
		mapresult.put("New York", "c");

		Assert.assertTrue(iw.getMapOrderByValuesY(map).equals(mapresult));

	}
	@Test
	public void getMapOrderByValuesThenByKeyTest() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Delhi", "a");
		map.put("New York", "c");
		map.put("Mumbai", "a");
		map.put("Tokyo", "b");
		map.put("Bangalore", "a");

		System.out.println(iw.getMapOrderByValuesThenByKey(map));
	}
	@Test
	public void getMapOrderByKeyTest()
	{
		Map<String, String> map = new LinkedHashMap<>();
		map.put("A", "a");
		map.put("E", "a");
		map.put("B", "a");
		map.put("C", "a");
		map.put("D", "a");

		System.out.println(iw.getMapOrderByKey(map));
	}
	/** 1. Create biggest number from array element using string addition */

	@Test
	public void getBiggestNumberTest() {

		int a[] = { 3, 30, 9 };
		Assert.assertTrue(iw.getBiggestNumber(a).equals("9330"));
		int b[] = { 952, 9, 90 };
		Assert.assertTrue(iw.getBiggestNumber(b).equals("995290"));
		int c[] = { 952, 94, 953 };
		Assert.assertTrue(iw.getBiggestNumber(c).equals("95395294"));

	}

	@Test
	public void getBiggestNumberXTest() {

		int a[] = { 3, 30, 9 };
		Assert.assertTrue(iw.getBiggestNumberX(a).equals("9330"));
		int b[] = { 952, 9, 90 };
		Assert.assertTrue(iw.getBiggestNumberX(b).equals("995290"));
		int c[] = { 952, 94, 953 };
		Assert.assertTrue(iw.getBiggestNumber(c).equals("95395294"));

	}

	/** 3. sum array with performance heaving n thread */
	@Test
	public void getSumTest() throws InterruptedException, ExecutionException {

		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
		Assert.assertTrue(iw.getSum(a, 10) == 500500);
	}

	@Test
	public void getSumAXTest() throws InterruptedException, ExecutionException {

		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
		Assert.assertTrue(iw.getSumAX(a, 10) == 500500);
	}

	/** sum array with performance heaving n thread using ForkandJJoin */
	@Test
	public void getSumXTest() throws InterruptedException, ExecutionException {
		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
		Assert.assertTrue(iw.getSumX(a, 10) == 500500);
	}

	/** 4 max or min number with performance heaving n thread */
	@Test
	public void getMaxOrMinTest() throws InterruptedException, ExecutionException {
		Integer[] a = new Integer[100000];
		for (int i = 0; i < 100000; a[i] = i + 1, i++)
			;
		a[100] = 500000;
		a[101] = -10;
		Assert.assertTrue(iw.getMaxOrMin(a, 100, true) == a[100]);
		Assert.assertTrue(iw.getMaxOrMin(a, 100, false) == a[101]);

	}

	/** max or min number with performance heaving n thread ForkandJJoin */
	@Test
	public void getMaxOrMinXTest() throws InterruptedException, ExecutionException {
		Integer[] a = new Integer[100000];
		for (int i = 0; i < 100000; a[i] = i + 1, i++)
			;
		a[100] = 500000;
		a[101] = -10;
		Assert.assertTrue(iw.getMaxOrMinX(a, 100, true) == a[100]);
		Assert.assertTrue(iw.getMaxOrMinX(a, 100, false) == a[101]);

	}

	/** 5 find intersection node, node value may be duplicate */
	@Test
	public void getInterSectionNodeTest() {
		int a[] = { 1, 2, 5, 3, 4, 2, 6, 3 };
		int b[] = { 3, 5 };
		LNode x = SListUtils.createList(null, a);
		LNode y = SListUtils.createList(null, b);
		y.next.next = x.next.next.next.next.next;
		Assert.assertTrue(iw.getInterSectionNode(x, y).dt == 2);
	}

	/** 6 find start circular node */
	@Test
	public void getCirculrPointNodeTest() {
		int a[] = { 1, 2, 5, 3, 4, 2, 6, 4, 3 };
		LNode x = SListUtils.createList(null, a);
		LNode y = SListUtils.tail;
		y.next = x.next.next.next.next.next;
		LNode cn = iw.getCirculrPointNode(x);
		Assert.assertTrue(cn.dt == 2 && cn.next.dt == 6);
	}

	public Map<String, String> getFilledMapValue() {
		Map<String, String> map = new TreeMap<>();
		map.put("Mumbai", "a");
		map.put("Tokyo", "b");
		map.put("New York", "c");
		map.put("Delhi", "a");
		map.put("Mumbai", "a");
		return map;
	}

	public Map<String, String> getSortedFilledValue() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Delhi", "a");
		map.put("Mumbai", "a");
		map.put("Tokyo", "b");
		map.put("New York", "c");
		return map;
	}

	// 2022 interview
	// chunk array of all possible size
	@Test
	public void chunkArrayTest() {
		int a[] = { 1, 2, 3, 4, 5 };
		iw.chunkArray(a);
	}

	@Test
	public void splitArrayTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		List<int[]> ll = iw.splitArray(a, 3);
		for (int[] ar : ll) {
			System.out.println(Arrays.toString(ar));
		}
	}

	@Test
	public void commonCharactersTest() {
		String a = "abcbcd";
		String b = "cdefefc";
		Assert.assertTrue(iw.commonCharacters(a, b).equals("ccd"));
	}

	@Test
	public void createTwoTreadTest() throws InterruptedException {
		iw.createTwoTread();
	}

	// 2023 interview question
	@Test
	public void splitArrayOfNSizeTest() {

		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 2; i < 6; i++) {
			List<int[]> ls = iw.splitArrayOfNSize(a, i);
			for (int[] b : ls) {
				System.out.println(Arrays.toString(b));
			}
			System.out.println();
		}
	}

	@Test
	public void snakeToCamelTest() {
		String str1 = "geeks_for_geeks";
		String str2 = "GeeksForGeeks";
		Assert.assertTrue(iw.snakeToCamel(str1).equals(str2));
	}

	@Test
	public void camelTOSnakeTest() {
		String str1 = "geeks_for_geeks";
		String str2 = "geeksForGeeks";
		Assert.assertTrue(iw.camelToSnake(str2).equals(str1));
	}

	@Test
	public void countCostVowlAndSpecilCharTest() {
		String str = "#<06bIt007*&^ is Abhimanyu Kumar Suman";
		System.out.println(iw.segerateChars(str));
	}

	// check a string is permutation of palindrome
	@Test
	public void isPermutationOfPalindromeTest() {

		Assert.assertTrue(iw.isPermutationOfPalindrome("asciics"));
		Assert.assertFalse(iw.isPermutationOfPalindrome("asciic"));
	}

}
