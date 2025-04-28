package interview.preparation.self.asked.company.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import interview.preparation.company.interviews.impl.WissenInfotechImpl;
import interview.preparation.company.interviews.question.IWissenInfotech;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.design.analysis.company.preparation.model.LNode;
import com.design.analysis.company.preparation.utils.SListUtils;

public class IWissenIninfotechTest {

	IWissenInfotech iw = null;

	@Before
	public void init() {
		iw = new WissenInfotechImpl();
	}

	/** 1. Add values in map so it map print sorted order based on values */
	@Test
	public void getMapOrderByValuesTest() {
        Assert.assertEquals(iw.getMapOrderByValues(getFilledMapValue()), getSortedFilledValue());

	}

	@Test
	public void getMapOrderByValuesTestX() {
        Assert.assertEquals(iw.getMapOrderByValuesX(getFilledMapValue()), getSortedFilledValue());

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

        Assert.assertEquals(iw.getMapOrderByValuesY(map), mapresult);

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
	public void getMapOrderByValuesThenByKeyXTest() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Delhi", "a");
		map.put("New York", "c");
		map.put("Mumbai", "a");
		map.put("Tokyo", "b");
		map.put("Bangalore", "a");

		System.out.println(iw.getMapOrderByValuesThenByKeyX(map));
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
        Assert.assertEquals("9330", iw.getBiggestNumber(a));
		int b[] = { 952, 9, 90 };
        Assert.assertEquals("995290", iw.getBiggestNumber(b));
		int c[] = { 952, 94, 953 };
        Assert.assertEquals("95395294", iw.getBiggestNumber(c));

	}

	@Test
	public void getBiggestNumberXTest() {

		int a[] = { 3, 30, 9 };
        Assert.assertEquals("9330", iw.getBiggestNumberX(a));
		int b[] = { 952, 9, 90 };
        Assert.assertEquals("995290", iw.getBiggestNumberX(b));
		int c[] = { 952, 94, 953 };
        Assert.assertEquals("95395294", iw.getBiggestNumber(c));

	}

	/** 3. sum array with performance heaving n thread */
	@Test
	public void getSumTest() throws InterruptedException, ExecutionException {

		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
        Assert.assertEquals(500500, iw.getSum(a, 10));
	}

	@Test
	public void getSumAXTest() throws InterruptedException, ExecutionException {

		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
        Assert.assertEquals(500500, iw.getSumAX(a, 10));
	}

	/** sum array with performance heaving n thread using ForkandJJoin */
	@Test
	public void getSumXTest() throws InterruptedException, ExecutionException {
		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
		//Assert.assertTrue(iw.getSumX(a, 10) == 500500);
	}

	/** 4 max or min number with performance heaving n thread */
	@Test
	public void getMaxOrMinTest() throws InterruptedException, ExecutionException {
		Integer[] a = new Integer[100000];
		for (int i = 0; i < 100000; a[i] = i + 1, i++)
			;
		a[100] = 500000;
		a[101] = -10;
        Assert.assertEquals(iw.getMaxOrMin(a, 100, true), (int) a[100]);
        Assert.assertEquals(iw.getMaxOrMin(a, 100, false), (int) a[101]);

	}

	/** max or min number with performance heaving n thread ForkandJJoin */
    @Ignore
	@Test
	public void getMaxOrMinXTest() throws InterruptedException, ExecutionException {
		Integer[] a = new Integer[100000];
		for (int i = 0; i < 100000; a[i] = i + 1, i++)
			;
		a[100] = 500000;
		a[101] = -10;
		//System.out.println(iw.getMaxOrMinX(a, 100, true));
        Assert.assertEquals(iw.getMaxOrMinX(a, 100, true), (int) a[100]);
        Assert.assertEquals(iw.getMaxOrMinX(a, 100, false), (int) a[101]);

	}

	/** 5 find intersection node, node value may be duplicate */
	@Test
	public void getInterSectionNodeTest() {
		int a[] = { 1, 2, 5, 3, 4, 2, 6, 3 };
		int b[] = { 3, 5 };
		LNode x = SListUtils.createList(null, a);
		LNode y = SListUtils.createList(null, b);
		y.next.next = x.next.next.next.next.next;
        Assert.assertEquals(2, iw.getInterSectionNode(x, y).dt);
	}

	/** 6 find start circular node */
	@Test
	public void getCirculerPointNodeTest() {
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
        Assert.assertEquals("ccd", iw.commonCharacters(a, b));
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
        Assert.assertEquals(iw.snakeToCamel(str1), str2);
	}

	@Test
	public void camelTOSnakeTest() {
		String str1 = "geeks_for_geeks";
		String str2 = "geeksForGeeks";
        Assert.assertEquals(iw.camelToSnake(str2), str1);
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
