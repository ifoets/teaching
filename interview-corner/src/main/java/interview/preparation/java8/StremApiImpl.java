package interview.preparation.java8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import interview.preparation.java8.model.Book;

public class StremApiImpl implements IStremApi {

	/** convert list to map */
	@Override
	public Map<String, Book> convertListToMap(List<Book> list) {
		Map<String, Book> map = list.stream().collect(Collectors.toMap(book -> book.getISBN(), book -> book));
		// or
		map = list.stream().collect(Collectors.toMap(Book::getISBN, b -> b));
		// or
		map = list.stream().collect(Collectors.toMap(Book::getISBN, Function.identity()));

		return map;
	}

	/** if duplicate present in list ignore it */
	@Override
	public Map<String, Integer> convertListToMapDuplicate(List<String> list) {
		return list.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1));
	}

	/** sort map based on the value then key */
	@Override
	public Map<String, String> sortMapOnValueThenKey(Map<String, String> map) {
		return map.entrySet().stream().sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	/* to upper case */
	@Override
	public List<String> toUpparCase(List<String> list) {
		return list.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	/** to upper case **/
	@Override
	public List<Integer> toSquire(List<Integer> list) {
		return list.stream().map(i -> i * i).collect(Collectors.toList());
	}

	@Override
	public List<String> toUpparCaseFilter(List<String> list) {
		return list.stream().map(String::toUpperCase).filter(x -> x.length() > 6).collect(Collectors.toList());
	}

	@Override
	public List<Integer> toSquireFilterDistinct(List<Integer> list) {
		return list.stream().map(i -> i * i).filter(x -> x.intValue() > 10).distinct().collect(Collectors.toList());
	}
	/* adding list/arr of elements
	 * Integer sum = integers.stream() .reduce(0, (a, b) -> a + b);
	 */
	
}
