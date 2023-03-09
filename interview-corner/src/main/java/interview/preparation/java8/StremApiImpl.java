package interview.preparation.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import interview.preparation.java8.model.Book;
import interview.preparation.self.asked.model.A;

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
	/*
	 * adding list/arr of elements Integer sum = integers.stream() .reduce(0, (a, b)
	 * -> a + b);
	 */

	@Override
	public int countInstTypeInStream(List<Object> list, A a) {
		return (int) list.stream().filter(e -> e instanceof A).count();
	}

	// https://www.techiedelight.com/join-two-lists-java/
	@Override
	public List<Integer> addListsOnIndexes(List<Integer> l1, List<Integer> l2) {
		int N1 = l1.size();
		int N2 = l2.size();

		return IntStream.range(0, N1 > N2 ? N1 : N2).mapToObj(i -> (i < N1 ? l1.get(i) : 0) + (i < N2 ? l2.get(i) : 0))
				.collect(Collectors.toList());
	}
	
	// stream
		public int secnodMaxSingleIterationStream(int[] a) {

			return Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();
		}

		// stream nth max
		public int nthMaxSingleIterationStream(int a[], int nth) {
			return Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).limit(nth).skip(nth - 1).findFirst().get();

		}
}
