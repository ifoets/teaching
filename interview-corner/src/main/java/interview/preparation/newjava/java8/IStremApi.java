package interview.preparation.newjava.java8;

import interview.preparation.newjava.java8.model.Book;
import interview.preparation.newjava.java8.model.Employee;
import interview.preparation.newjava.java8.model.Notes;
import interview.preparation.company.interviews.model.A;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IStremApi {

	/** convert list to map */
	public Map<String, Book> convertListToMap(List<Book> list);

	/** if duplicate present in list ignore it */
	public Map<String, Integer> convertListToMapDuplicate(List<String> list);

	/** sort map based on the value then key */
	public Map<String, String> sortMapOnValueThenKey(Map<String, String> map);

	/* use map() function used to transform each element of the stream */
	public List<String> toUpparCase(List<String> list);

	/** to upper case */
	public List<Integer> toSquire(List<Integer> list);

	/* use filter() function used to transform each element of the stream */
	public List<String> toUpparCaseFilter(List<String> list);

	/** to upper case */
	public List<Integer> toSquireFilterDistinct(List<Integer> list);

	/* use reduce() function used to transform each element of the stream */

	// Practice java 8*/
	public int countInstTypeInStream(List<Object> objects, A a);

	public List<Integer> addListsOnIndexes(List<Integer> l1, List<Integer> l2);

	// stream
	public int secondMaxSingleIterationStream(int[] a);

	// stream nth max
	public int nthMaxSingleIterationStream(int a[], int nth);

	//reverse string using java8
	public String reverseStrJava8(String str);

	/*Sort employee byname and salary using java 8 stream API*/
	public List<Employee> sortByNameAndAge(List<Employee> list);

	/*Merge two Employee ArrayList and sort by age*/
	public List<Employee> mergeEmployeeSortByAge(List<Employee> e1, List<Employee> e2);

	/*flat map collect unique element from list of list*/
	public Set<Integer> uniqueFromListOfList(List<List<Integer>> ll);

	public Set<Integer> uniqueFromListOfListOfList(List<List<List<Integer>>> lll);

	public List<Integer> collectOddPosElement(List<Integer> list);

	/*find first  or last non-repeated char in string*/
	public Character firstLastNonRepeatedChar(String str, boolean firstOrLast);

	/*find first or last repeated char in string*/
	public Character firstLastRepeatedChar(String str, boolean firstOrLast);

	/*find first  or last nth non-repeated char in string*/
	public Character firstLastNthNonRepeatedChar(String str, boolean firstOrLast, int n);

	/*find first or last nth repeated char in string*/
	public Character firstLastNthRepeatedChar(String str, boolean firstOrLast, int n);

	/*add prefix and suffix to string*/
	public String addPrefixSuffix(String str, String prefix, String suffix);

	/*sum first n even elements from list*/
	public int sumFirstNEvenElements(List<Integer> list, int n);

	/*sum last n odd elements from list*/
	public int sumLastNOddElements(List<Integer> list, int n);

	/*collect all elements of integer whose nth pos value is x*/
	public List<Integer> nthPosXValue(List<Integer> list, int n, int x);

	/*sum of duplicate element*/
	public int sumOfDuplicateEle(List<Integer> list);

	/*Write a program to print the count of each character in a String?*/
	public Map<String, Long> findCountOfChars(String s);

	/*How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?*/
	public List<String> getNonEmptyNonNullList(List<Notes> list);

	/*How to find only duplicate or unique elements with its count from the String ArrayList in Java8*/
	public Map<String, Long> findDuplicateOrUnique(String s, boolean uniqueOrDuplicate);

	/*find first  or last non-repeated val in arr*/
	public int firstNonRepeatedVal(int []a);

	/*find first or last repeated val in arr*/
	public int firstRepeatedVal(int []a);
}
