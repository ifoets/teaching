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
}
