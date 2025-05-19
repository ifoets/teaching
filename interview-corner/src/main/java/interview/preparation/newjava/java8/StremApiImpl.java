package interview.preparation.newjava.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import interview.preparation.newjava.java8.model.Book;
import interview.preparation.newjava.java8.model.Employee;
import interview.preparation.newjava.java8.model.Notes;
import interview.preparation.company.interviews.model.A;

public class StremApiImpl implements IStremApi {

	/** convert list to map */
	@Override
	public Map<String, Book> convertListToMap(List<Book> list) {
		Map<String, Book> map = list.stream().collect(Collectors.toMap(Book::getISBN, book -> book));
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
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<String,String>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2)->e1,
                    LinkedHashMap::new
            ));
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
	@Override
	public int secondMaxSingleIterationStream(int[] a) {

		return Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();
	}

	// stream nth max
	@Override
	public int nthMaxSingleIterationStream(int a[], int nth) {
		return Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).limit(nth).skip(nth - 1).findFirst().get();

	}

	@Override
	public String reverseStrJava8(String str)
	{
		if(Objects.isNull(str)||str.length()==1)
			return str;
		return str.chars().mapToObj( c-> (char)c).reduce("", (a,b) -> b+a, (s1,s2)-> s2+s1);
	}
	@Override
	/*Sort employee byname and age using java 8 stream API*/
	public List<Employee> sortByNameAndAge(List<Employee> list){
	  return list.stream()
				.sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getAge))
			  .collect(Collectors.toList());
    }

	/*Merge two Employee ArrayList and sort by age*/
	@Override
	public List<Employee> mergeEmployeeSortByAge(List<Employee> e1, List<Employee> e2)
	{
		return Stream.concat(e1.stream(),e2.stream()).sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
	}
	/*flat map collect unique element from list of list*/
	@Override
	public Set<Integer> uniqueFromListOfList(List<List<Integer>> ll)
	{
		return ll.stream().flatMap(e -> e.stream()).collect(Collectors.toSet());
	}
	@Override
	public Set<Integer> uniqueFromListOfListOfList(List<List<List<Integer>>> lll)
	{
		return lll.stream().flatMap(e->e.stream()).flatMap(e->e.stream()).collect(Collectors.toSet());
	}

	@Override
	public List<Integer> collectOddPosElement(List<Integer> list)
	{
		return IntStream.range(0, list.size()).filter( i-> i%2!=0)
				.mapToObj( i->list.get(i)).collect(Collectors.toList());
	}
	/*find first or last non-repeated char in string*/
	@Override
	public Character firstLastNonRepeatedChar(String str, boolean firstOrLast){
       str = firstOrLast ? str : new StringBuilder(str).reverse().toString();
		return str.chars().mapToObj(e -> Character.toLowerCase(Character.valueOf((char)e)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter( e-> e.getValue()==1l)
				.map( e-> e.getKey())
				.findFirst()
				.get();
	}
	/*find first or last non-repeated char in string*/
	@Override
	public Character firstLastRepeatedChar(String str, boolean firstOrLast)
	{
       str = firstOrLast ? str : new StringBuilder(str).reverse().toString();
	   return str.chars().mapToObj(e -> Character.toLowerCase((char)e))
			   .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
			   .entrySet()
			   .stream()
			   .filter( e -> e.getValue() > 1l)
			   .map(x-> x.getKey())
			   .findFirst()
			   .get();
	}
	/*find first  or last nth non-repeated char in string*/
	@Override
	public Character firstLastNthNonRepeatedChar(String str, boolean firstOrLast, int n){
        str = firstOrLast ? str : new StringBuilder(str).reverse().toString();
		return
				str.chars().mapToObj(e -> Character.toLowerCase((char)e))
						.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
						.entrySet()
						.stream()
						.filter( e -> e.getValue()==1l)
						.map( x -> x.getKey())
						.skip(n-1)
						.findFirst()
						.get();
	}

	/*find first or last nth repeated char in string*/
	@Override
	public Character firstLastNthRepeatedChar(String str, boolean firstOrLast, int n){
		str = firstOrLast ? str : new StringBuilder(str).reverse().toString();

		return str.chars().mapToObj(e -> Character.toLowerCase((char)e))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue()> 1l)
				.map(x -> x.getKey())
				.skip(n-1)
				.findFirst()
				.get();
	}
	/*add prefix and suffix to string*/
	@Override
	public String addPrefixSuffix(String str, String prefix, String suffix)
	{
		StringJoiner joiner = new StringJoiner(",","#", "!");
		List<String> strList = List.of(str.split(" "));
		strList.forEach( e-> joiner.add(e));
		return joiner.toString();
	}
	/*sum first n even elements from list*/
	@Override
	public int sumFirstNEvenElements(List<Integer> list, int n)
	{
		List<Integer> nList = list.stream().filter( e-> e%2==0).toList();
       return IntStream.range(0, list.size() > n ? n : list.size())
			   .mapToObj( i -> nList.get(i))
			   .mapToInt(Integer::intValue)
			   .sum();
	}
	/*sum last n odd elements from list*/
	@Override
	public int sumLastNOddElements(List<Integer> list, int n)
	{
		List<Integer> nList = list.stream().filter(e -> e%2==1).toList();
		return IntStream.range(nList.size()-n, nList.size()).mapToObj( i -> nList.get(i))
				.mapToInt(Integer::intValue)
				.sum();
	}
	/*collect all elements of integer whose nth pos value is x*/
	@Override
	public List<Integer> nthPosXValue(List<Integer> list, int n, int x){
		return list.stream().map( e-> e+"")
				.filter( y -> (y.toCharArray().length >= n && Integer.valueOf((char)y.toCharArray()[n-1]+"")==Integer.valueOf(x)))
				.map(Integer::parseInt)
                .toList();
	}
	/*sum of duplicate element*/
	@Override
	public int sumOfDuplicateEle(List<Integer> list)
	{
		Set<Integer> set = new HashSet<>();
		return list.stream().filter( e -> !set.add(e))
				.mapToInt(Integer::intValue)
				.sum();
	}
	/*Write a program to print the count of each character in a String?*/
	@Override
	public Map<String, Long> findCountOfChars(String s)
	{
		return Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
	}
	/*How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?*/
	@Override
	public List<String> getNonEmptyNonNullList(List<Notes> list)
	{
		return Optional.ofNullable(list)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull)
				.map(Notes::getName).toList();
	}
	/*How to find only duplicate or unique elements with its count from the String ArrayList in Java8*/
	public Map<String, Long> findDuplicateOrUnique(String s, boolean uniqueOrDuplicate){
      return  Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e-> uniqueOrDuplicate ? e.getValue() > 1 : e.getValue()==1)
            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2)->e1,LinkedHashMap::new));
	}

	/*find first  or last non-repeated val in arr*/
	public int firstNonRepeatedVal(int []a){
		return Arrays.stream(a).boxed()
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
            .entrySet()
            .stream()
            .filter( e-> e.getValue()==1l)
            .mapToInt(Map.Entry::getKey)
            .findFirst().orElseThrow();
	}

	/*find first or last repeated val in arr*/
	public int firstRepeatedVal(int []a){

       return Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .filter( e-> e.getValue()>1l)
            .mapToInt(Map.Entry::getKey)
            .findFirst().getAsInt();
	}

}
