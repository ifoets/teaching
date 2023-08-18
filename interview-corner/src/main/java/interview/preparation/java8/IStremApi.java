package interview.preparation.java8;

import java.util.*;

import interview.preparation.java8.model.Book;
import interview.preparation.java8.model.Employee;
import interview.preparation.self.asked.model.A;

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
}
