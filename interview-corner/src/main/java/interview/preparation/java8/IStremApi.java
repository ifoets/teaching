package interview.preparation.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import interview.preparation.java8.model.Book;
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
	public int secnodMaxSingleIterationStream(int[] a);

	// stream nth max
	public int nthMaxSingleIterationStream(int a[], int nth);
}
