package interview.preparation.self.asked.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.company.preparation.model.LNode;
import com.design.analysis.company.preparation.utils.SListUtils;

import interview.preparation.self.asked.IWissenIninfotech;
import interview.preparation.self.asked.WissenIninfotechImpl;

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

	/** 3. sum array with performance heaving n thread */
	@Test
	public void getSumTest() throws InterruptedException, ExecutionException {

		Integer[] a = new Integer[1000];
		for (int i = 0; i < 1000; a[i] = i + 1, i++)
			;
		Assert.assertTrue(iw.getSum(a, 10) == 500500);
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
}
