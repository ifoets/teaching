package interview.preparation.java8;

import java.util.List;
import java.util.Map;

import interview.preparation.java8.model.Book;

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
}
