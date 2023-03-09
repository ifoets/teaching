package interview.preparation.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.preparation.java8.model.Book;
import interview.preparation.self.asked.model.A;
import interview.preparation.self.asked.model.B;
import interview.preparation.self.asked.model.C;
import interview.preparation.self.asked.model.D;

public class IStremApiTest {

	IStremApi isa = null;

	@Before
	public void init() {
		isa = new StremApiImpl();
	}

	/** convert list to map */
	@Test
	public void convertListToMapTest() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book("12", "Java"));
		list.add(new Book("10", "C++"));
		list.add(new Book("13", "Python"));
		Map<String, Book> map = isa.convertListToMap(list);
		Assert.assertTrue(map.get("12").getName().equals("Java"));
		Assert.assertTrue(map.get("10").getName().equals("C++"));
		Assert.assertTrue(map.get("13").getName().equals("Python"));

	}

	/** if duplicate present in list ignore it */
	@Test
	public void convertListToMapDuplicateTest() {
		List<String> cardsList = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");
		Map<String, Integer> map = isa.convertListToMapDuplicate(cardsList);
		Assert.assertTrue(map.get("Visa") == 4);
		Assert.assertTrue(map.get("MasterCard") == 10);
		Assert.assertTrue(map.get("American Express") == 16);
	}

	/** sort map based on the value then key */
	@Test
	public void sortMapOnValueThenKeyTest() {
		Map<String, String> map = new HashMap<>();
		map.put("12", "Java");
		map.put("14", "Java");
		map.put("10", "C++");
		map.put("13", "Python");
		System.out.println(isa.sortMapOnValueThenKey(map).toString());
	}

	@Test
	public void countInstTypeInStreamTest() {
		List<Object> a = List.of(new C(), new B(), new A(), new D(), new B());
		Assert.assertTrue(isa.countInstTypeInStream(a, new A()) == 4);
	}

	@Test
	public void addListsOnIndexesTest() {
		List<Integer> a = List.of(2, 4, 3, 5, 3, 4, 7);
		List<Integer> b = List.of(20, 5, 10);

		System.out.println(isa.addListsOnIndexes(b, a));
	}

	// stream
	@Test
	public void secnodMaxSingleIterationStreamTest() {

		int a[] = { 7, 1, 5, 3, 6, 4 };
		Assert.assertTrue(isa.secnodMaxSingleIterationStream(a) == 6);
	}

	// stream nth max
	@Test
	public void nthMaxSingleIterationStream() {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		int b[] = { 7, 6, 5, 4, 3, 1 };
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(isa.nthMaxSingleIterationStream(a, i + 1) == b[i]);

	}
}
