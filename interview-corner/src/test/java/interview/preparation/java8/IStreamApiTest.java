package interview.preparation.java8;

import java.util.*;

import interview.preparation.java8.datautils.DataUtils;
import interview.preparation.newjava.java8.IStremApi;
import interview.preparation.newjava.java8.StremApiImpl;
import interview.preparation.newjava.java8.model.Employee;
import interview.preparation.newjava.java8.model.Notes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.preparation.newjava.java8.model.Book;
import interview.preparation.company.interviews.model.A;
import interview.preparation.company.interviews.model.B;
import interview.preparation.company.interviews.model.C;
import interview.preparation.company.interviews.model.D;

public class

IStreamApiTest {

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
		Assert.assertTrue(isa.secondMaxSingleIterationStream(a) == 6);
	}

	// stream nth max
	@Test
	public void nthMaxSingleIterationStream() {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		int b[] = { 7, 6, 5, 4, 3, 1 };
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(isa.nthMaxSingleIterationStream(a, i + 1) == b[i]);
	}
	@Test
	public void reverseStrJava8Test()
	{
		Assert.assertTrue(isa.reverseStrJava8("abhimanyu").equals("uynamihba"));
		Assert.assertTrue(isa.reverseStrJava8("").equals(""));
	}
	/*Sort employee byname and salary using java 8 stream API*/
	@Test
	public void sortByNameAndSalaryTest()
	{
		isa.sortByNameAndAge(DataUtils.getEmployees()).stream().map(e->e.toString()).forEach(System.out::println);
	}
	/*Merge two Employee ArrayList and sort by age*/
	@Test
	public void mergeEmployeeSortByAgeTest()
	{
		List<Employee> list1 = List.of(new Employee("abhi",40), new Employee("kumar",34));
		isa.mergeEmployeeSortByAge(list1,DataUtils.getEmployees()).stream().map(e->e.toString()).forEach(System.out::println);
	}

	/*flat map collect unique element from list of list*/
	@Test
	public void uniqueFromListOfListTest()
	{
            isa.uniqueFromListOfList(List.of(DataUtils.getOdds(),DataUtils.getEvens(),DataUtils.getPrimes()))
					.stream().forEach(System.out::println);
	}
	@Test
	public void uniqueFromListOfListOfListTest()
	{
		System.out.println(isa.uniqueFromListOfListOfList(List.of(
				        List.of(DataUtils.getOdds(),DataUtils.getEvens(),DataUtils.getPrimes()),
						List.of(DataUtils.getOdds(),DataUtils.getEvens(),DataUtils.getPrimes())))
				.stream().count()==isa.uniqueFromListOfList(List.of(DataUtils.getOdds(),DataUtils.getEvens(),DataUtils.getPrimes()))
				.stream().count());
	}
	@Test
	public void collectOddPosElementTest()
	{
        isa.collectOddPosElement(List.of(0,1,2,3,4,5,6,7,8,9,10,11)).forEach(System.out::println);
	}
	@Test
	public void firstLastNonRepeatedCharTest()
	{
		String input = "Java Hungry Blog Alive is Awesome";
		Assert.assertTrue(isa.firstLastNonRepeatedChar(input, true)=='j');
		Assert.assertTrue(isa.firstLastNonRepeatedChar(input, false)=='m');
	}
	/*find first or last non-repeated char in string*/
	@Test
	public void firstLastRepeatedCharTest()
	{
		String input = "Java Hungry Blog Alive is Awesome";
		Assert.assertTrue(isa.firstLastRepeatedChar(input, true)=='a');
		Assert.assertTrue(isa.firstLastRepeatedChar(input, false)=='e');
	}
	/*find first  or last nth non-repeated char in string*/
	@Test
	public void firstLastNthNonRepeatedCharTest()
	{
		String input = "Java Hungry Blog Alive is Awesome";
		Assert.assertTrue(isa.firstLastNthNonRepeatedChar(input, true,3)=='u');
		Assert.assertTrue(isa.firstLastNthNonRepeatedChar(input, false,3)=='b');
	}

	/*find first or last nth repeated char in string*/
	@Test
	public void firstLastNthRepeatedCharTest()
	{
		String input = "Java Hungry Blog Alive is Awesome";
		Assert.assertTrue(isa.firstLastNthRepeatedChar(input, true,2)=='v');
		Assert.assertTrue(isa.firstLastNthRepeatedChar(input, false,2)=='o');
	}
	/*add prefix and suffix to string*/
	@Test
	public void addPrefixSuffixTest()
	{
		String input = "Java Hungry Blog Alive is Awesome";
		Assert.assertTrue(isa.addPrefixSuffix(input,"#","!").equals("#Java,Hungry,Blog,Alive,is,Awesome!"));
	}
	/*sum first n even elements from list*/
	@Test
	public void sumFirstNElementsTest()
	{
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
		Assert.assertTrue(isa.sumFirstNEvenElements(list,3)==12);
	}
	/*sum last n odd elements from list*/
	@Test
	public void sumLastNOddElementsTest()
	{
		List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
		Assert.assertTrue(isa.sumLastNOddElements(list,3)==21);
	}
	/*collect all elements of integer whose nth pos value is x*/
	@Test
	public void nthPosXValueTest()
	{
		List<Integer> list = List.of(10101,1191,1243,14135);
		isa.nthPosXValue(list,3,1).forEach(System.out::println);
	}
	/*sum of duplicate element*/
	@Test
	public void sumOfDuplicateEleTest()
	{
      Assert.assertTrue(isa.sumOfDuplicateEle(List.of(1,2,3,4,5,6,3,4,5,7,3,9))==15);
	}

	/*Write a program to print the count of each character in a String?*/
	@Test
	public void findCountOfCharsTest()
	{
      System.out.println(isa.findCountOfChars("string data to count each character"));
	}
	/*How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?*/
	@Test
	public void getNonEmptyNonNullListTest()
	{
         List<Notes> list = null;
		 Assert.assertTrue(isa.getNonEmptyNonNullList(list).isEmpty());
		 list = List.of(new Notes("AB"), new Notes("BC"));
		 System.out.println(isa.getNonEmptyNonNullList(list));
	}
	/*How to find only duplicate elements with its count from the String ArrayList in Java8*/
	@Test
	public void findDuplicateTest()
	{
		System.out.println(isa.findDuplicateOrUnique("string data to count each character",true));
		System.out.println(isa.findDuplicateOrUnique("string data to count each character",false));
	}


	/*find first  or last non-repeated val in arr*/
	@Test
	public void firstNonRepeatedValTest()
	{
		int a[] = {8,1,2,3,6,3,2,4,9};
		System.out.println(isa.firstNonRepeatedVal(a));
	}

	/*find first or last repeated val in arr*/
	@Test
	public void firstRepeatedValTest()
	{
		int a[] = {8,1,2,3,6,3,2,4,9};
		System.out.println(isa.firstRepeatedVal(a));
	}

}

