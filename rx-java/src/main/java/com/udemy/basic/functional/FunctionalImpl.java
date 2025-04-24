package com.udemy.basic.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import java.util.stream.StreamSupport;

import com.udemy.basic.functional.datastructure.ListFun;
import com.udemy.basic.functional.datastructure.MapFun;
import com.udemy.basic.functional.datastructure.QueueFun;
import com.udemy.basic.functional.datastructure.TreeFun;
import com.udemy.basic.functional.demo.ACAutomationRemote;
import com.udemy.basic.functional.demo.BookSpliterator;
import com.udemy.basic.functional.demo.FlooringFactory;
import com.udemy.basic.functional.demo.Iflooring;
import com.udemy.basic.functional.demo.MobileBuilder;
import com.udemy.basic.functional.designpattern.DecoratorBurger;
import com.udemy.basic.functional.designpattern.FluentInterfaces;
import com.udemy.basic.functional.designpattern.IteratorList;
import com.udemy.basic.functional.designpattern.StrategyFilters;
import com.udemy.basic.functional.finterface.F1Closer;
import com.udemy.basic.functional.finterface.F1Composition;
import com.udemy.basic.functional.finterface.F1Consumer;
import com.udemy.basic.functional.finterface.F1Interface;
import com.udemy.basic.functional.finterface.F2Interface;
import com.udemy.basic.functional.finterface.F3Interface;
import com.udemy.basic.functional.finterface.FGeneric;
import com.udemy.basic.functional.finterface.IConfiguration;
import com.udemy.basic.functional.finterface.IFactory;
import com.udemy.basic.functional.finterface.IProducer;
import com.udemy.basic.functional.model.AC;
import com.udemy.basic.functional.model.Book;
import com.udemy.basic.functional.model.Burger;
import com.udemy.basic.functional.model.EEmployee;
import com.udemy.basic.functional.model.Employee;
import com.udemy.basic.functional.model.Mobile;
import com.udemy.basic.functional.model.Movie;
import com.udemy.basic.functional.model.Square;
import com.udemy.basic.functional.model.Stock;
import com.udemy.basic.functional.spliterator.EmployeeSpliterator;
import com.udemy.basic.functional.utils.ImpureFuncitonUtils;
import com.udemy.basic.functional.utils.PureFunctionUtils;
import com.udemy.basic.functional.utils.StaticMethodRef;

public class FunctionalImpl implements IFunctional {

	/** Section2: basic Lambda and functional interface **/
	/* use of functional interface */
	@Override
	public void runnaleThredExecute() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread Executed with Anonymous");
			}
		});
		t.start();
	}

	/* Runnable is functional interface it can use in lambda expression */
	@Override
	public void runnaleThredExecuteLamda() {
		Thread t = new Thread(() -> System.out.println("Thread Executed with Labda expression"));
		t.start();
	}

	/* create and use functional interface ,body implemented at run time */
	@Override
	public void useOwnFunctionlIntface() {
		F1Interface f1 = () -> System.out.println("Body of functional interface\n created and executed");
		f1.f1Method();
	}

	/* pass behaviour as FI ie us FI as method argument */
	@Override
	public void onTheFly(F1Interface f) {
		f.f1Method();
	}

	/* multiple implementation create multiple class file under the hood */
	@Override
	public void lambdaUnderTheHood() {
//		MyFunInterface fun1 = new MyFunInterface() {
//			@Override
//			public void myMethod() {
//				System.out.println("It's the implementation 1");
//			}
//		};
//		
//		//fun1.myMethod();

//		MyFunInterface fun2 = new MyFunInterface() {
//			@Override
//			public void myMethod() {
//				System.out.println("It's the implementation 2");			
//			}	
//		};
//		
//		fun2.myMethod();

		F1Interface fun = () -> System.out.println("I am Light Weight");
		fun.f1Method();
	}

	/* imperative/not thread safe vs Declarative style/thread safe of programming */
	// sum of even no from 0 to 100
	@Override
	public int imperativeDeclarativeStyle() {
		int sum = 0;
//		for (int i = 0; i <= 100; i++) {
//			if (i % 2 == 0)
//				sum = sum + i;
//		}
		sum = IntStream.rangeClosed(0, 100)
		        .filter(i -> i % 2 == 0)
		        .reduce((x, y) -> x + y)
		        .getAsInt();

		return sum;
	}

	/** Section 4: Practice Lambda with different signatures **/

	/* Method with NO parameter No Return Type */
	@Override
	public void noParamNoReturnType() {
		F1Interface f = () -> System.out.println("No Pram No Return Type");
		f.f1Method();
	}

	/* Method with parameter No Return Type */
	@Override
	public void withParamNoReturnType(int x, int y) {
		F2Interface fsum = (a, b) -> System.out.println("sum:-" + (a + b));
		fsum.operation(x, y);
		F2Interface fmul = (a, b) -> System.out.println("mul:-" + a * b);
		fmul.operation(x, y);
	}

	/* Method no parameter Return Type */
	@Override
	public int withParamReturnType(String s) {
		F3Interface f = str -> str.length();
		return f.length(s);
	}

	/* method with multiple statement */
	@Override
	public int multiStatement(String s) {

		F3Interface f = str ->
			{
				int l = str.length();
				return l;
			};
		return f.length(s);
	}

	/** Section 5: Predefined Functional Interfaces and Practice **/

	/* execute generic functional interface */
	@Override
	public String executeGenFunInterface(String s) {
		FGeneric<String, String> f = str -> str.substring(1, 5);
		return f.execute(s);
	}

	/* use of Predicate functionality */
	@Override
	public <T> List<T> filter(List<T> t, Predicate<T> p) {
		List<T> list = new ArrayList<>();
		for (T x : t) {
			if (p.test(x))
				list.add(x);
		}
		return list;
	}

	@Override
	public List<String> filterString(List<String> list, String str) {
		Predicate<String> predicate = s -> s.contains(str);
		// or or and the with one predicate with others like short circuit
		// predicate = predicate.or/and(s->s.contains("Basic"));
		return filter(list, predicate);
	}

	@Override
	public List<String> filterNonEmptyFString(List<String> list) {
		Predicate<String> predicate = s -> !s.isEmpty();
		return filter(list, predicate);
	}

	@Override
	public List<Integer> filterEvenInteger(List<Integer> list) {
		Predicate<Integer> predicate = i -> i % 2 == 0;
		return filter(list, predicate);
	}

	/* use of Consumer functionality */
	@Override
	public <T> void acceptElement(List<T> t, Consumer<T> c) {
		for (T t2 : t) {
			// you can do series of consumer with below function
			// c.andThen(s->System.out.println("Great job")).accept(t2);
			c.accept(t2);
		}
	}

	@Override
	public void printElement(List<Integer> list) {
		Consumer<Integer> consumer = i -> System.out.println(i);
		consumer.accept(10);
		acceptElement(list, consumer);

	}

	/* use of Supplier functionality */
	@Override
	public String stringConcat(String str1, String str2) {
		Supplier<String> supplier = () -> new String(str1.concat(str2));
		// there is no multiple supply whatever you can supply/return all at a time
		// multiple return is meaning less stuff
		// supplier.nofunction
		return supplier.get();
	}

	@Override
	public double randomNumber() {
		Supplier<Double> supplier = () -> Math.random();
		return supplier.get();
	}

	/* use of Function functionality */
	@Override
	public <T, R> List<R> mapped(List<T> t, Function<T, R> f) {
		List<R> list = new ArrayList<>();
		for (T t2 : t) {
			list.add(f.apply(t2));
		}
		return list;
	}

	@Override
	public List<Integer> lenthOfListStr(List<String> list) {
		Function<String, Integer> fun = s -> s.length();
		return mapped(list, fun);
	}

	/* use of UnaryOperator functionality */
	@Override
	public <T> List<T> mappedUnaryOperator(List<T> t, UnaryOperator<T> u) {
		List<T> list = new ArrayList<>();
		for (T t2 : t) {
			list.add(u.apply(t2));
		}
		return list;
	}

	@Override
	public List<Integer> doubleTheElement(List<Integer> list) {
		UnaryOperator<Integer> un = i -> 2 * i;
		return mappedUnaryOperator(list, un);
	}

	/* use of BiFunction functionality */
	@Override
	public Integer getConcateLenth(String str1, String str2) {
		BiFunction<String, String, Integer> bif = (a, b) -> (a + b).length();
		return bif.apply(str1, str2);
	}

	/* use of BinaryOperator functionality */
	@Override
	public String getSpecialConcate(String str1, String str2) {
		BinaryOperator<String> bif = (a, b) -> a + "." + b;
		return bif.apply(str1, str2);
	}

	/** Section 6: Method and Constructor Reference **/

	/* Method reference */
	/* class::static method */
	@Override
	public void printElementMethodRef(List<Integer> list) {
		Consumer<Integer> consumer = System.out::println;// i -> System.out.println(i);
		consumer.accept(10);
		acceptElement(list, consumer);
	}

	/* class::staticMethod */
	@Override
	public double randomNumberMethodRef() {
		Supplier<Double> supplier = Math::random; // () -> Math.random();
		return supplier.get();
	}

	/* class::staticMethod */
	/* method reference take argument and return something */
	@Override
	public String concateMethodRef(String str1, String str2) {
		BiFunction<String, String, String> bif = StaticMethodRef::staticConcat;// (a, b) ->
		// StaticMethodRef.staticConcat(a,
		// b);
		return bif.apply(str1, str2);
	}

	/* class::instanceMethod */
	@Override
	public List<Integer> lenthOfListStrMethodRef(List<String> list) {
		Function<String, Integer> fun = String::length;
		return mapped(list, fun);
	}

	/* class::new */
	@Override
	public void threadGenrator() {
		Function<Runnable, Thread> threadGenerator = Thread::new;// r->new Thread()

		Runnable run1 = () -> System.out.println("Task 1 Executed");
		Runnable run2 = () -> System.out.println("Task 2 Executed");
		Thread thread1 = threadGenerator.apply(run1);
		Thread thread2 = threadGenerator.apply(run2);

		thread1.run();
		thread2.run();
		threadGenerator.apply(() -> System.out.println("Task 3 Executed"))
		        .start();
	}

	/** Section 7: Optional for Null Pointer **/

	/* creating Optional different ways */
	@Override
	public void createOptional() {

		String str = "Abhimanyu kumar";

		Optional<String> opt = Optional.of(str);
		System.out.println(opt.get());

		// empty optional
		// Optional<String> emptyOpt = Optional.empty();
		// nullable
		// Optional<String> nullableOpt = Optional.ofNullable(null);

	}

	/* getting the value back from Optional */
	// should not use .get() directly if not perfectly sure about the value
	@Override
	public void getOptional() {

		Integer intVal = 10;
		Optional<Integer> opt = Optional.of(intVal);
		System.out.println(opt.get());

		// empty optional
		Optional<Integer> emptyOpt = Optional.empty();
		Integer emptyIntVal = emptyOpt.isPresent() ? emptyOpt.get() : 0;
		System.out.println(emptyIntVal);

		// nullable
		Optional<Integer> nullableOpt = Optional.ofNullable(null);
		Integer nullableIntVal = nullableOpt.isPresent() ? nullableOpt.get() : null;
		System.out.println(nullableIntVal);

	}

	/* getting the empty value back from Optional */
	@Override
	public void getEmptyOptional() {
		Integer intVal = 10;
		Optional<Integer> opt = Optional.of(intVal);
		System.out.println(opt.get());

		// orElse orElseGet
		// orElse
		Optional<Integer> emptyOpt = Optional.empty();
		System.out.println(emptyOpt.orElse(0));

		// orElseGet it required supplyer
		Optional<Integer> nullableOpt = Optional.ofNullable(null);
		Integer nullableInt = nullableOpt.orElseGet(() -> null);
		System.out.println(nullableInt);
	}

	/* getting the empty throw Optional */
	@Override
	public void getEmptyThrowFOptional() {

		Optional<Integer> emptyOpt = Optional.empty();
		// orElseThrow it required supplyer
		emptyOpt.orElseThrow(() -> new IllegalArgumentException());

		// orElseThrow default throw NoSuchElementException just like direct get value
		Optional<Integer> nullableOpt = Optional.ofNullable(null);
		nullableOpt.orElseThrow();

	}

	/* Optional operation part1: map(), filter(), flatMap() */
	@Override
	public void optionalOperation1() {

		// map()..if value is present then It warp and transform into another Optional
		// it modify the value of Optional
		Optional<String> optionalVal = Optional.of("abhimanyu");
		Optional<String> mapOpetional = optionalVal.map(s -> "kumar");
		System.out.println(mapOpetional.get());

		// map()..if value is not present then supply by orElse
		Optional<String> optionalEmpty = Optional.empty();
		String orElse = optionalEmpty.map(s -> "kumar")
		        .orElse("Empty");
		System.out.println(orElse);

		// filter() it check the condition on Optional, it take Predicate to check
		String orElseMap = optionalVal.map(s -> "kumar")
		        .orElse("Empty");
		System.out.println(orElseMap);
		Optional<String> filter = optionalVal.filter(val -> val.equalsIgnoreCase("abhimanyu"));
		System.out.println(filter.get());

		// flatMap() it is similar to map whose resulting function is already Optional
		// and in one single collection
		Optional<String> flatMap = optionalVal.flatMap(val -> Optional.of("Replaced By FlatMap"));
		System.out.println(flatMap.get());
	}

	/* Optional operation part2: ifPresent */
	@Override
	public void optionalOperation2() {

		// ifPresent it consume the value present in Optional
		Optional<String> optional = Optional.of("Value");
		// if op
		optional.ifPresent(e -> System.out.println("This is " + e));
		// if option is empty it don't do anything
		Optional.empty()
		        .ifPresent(e -> System.out.println("This is "));

		// even option is empty require to consume then use ifPresetOrElse
		Optional.empty()
		        .ifPresentOrElse(System.out::print, () -> System.out.println("Value is absent"));

		// stream if value is present it return sequential of that value otherwise
		// return empty String
		Stream<String> stream = optional.stream();
		stream.forEach(System.out::println);
		Optional.empty()
		        .stream()
		        .forEach(System.out::println);

		// or it takes supplier and it return same optional if it has the value if empty
		// then supplying new optional
		optional.or(() -> Optional.of("New Value"))
		        .ifPresent(System.out::print);
		Optional.empty()
		        .or(() -> Optional.of("New Value"))
		        .ifPresent(System.out::print);

		// case supplier return null then NPE arise
		// Optional.empty().or(() -> null).ifPresent(System.out::print);

		// equals it checking others object is equal to optional or not ie both optional
		// are empty or contains same value
		System.out.println(optional.equals(Optional.of("Value")));

		// hashcode it return hashcode of Optional, empty optional return 0
		System.out.println(optional.hashCode());
	}

	/** Section 8: Functional Programming in Depth **/

	/* impure function, that affect if we pass the result as argument */
	@Override
	public void impureFunctionUnderstandExmpl() {
		int result = ImpureFuncitonUtils.add(ImpureFuncitonUtils.multiply(2, 3), ImpureFuncitonUtils.multiply(3, 4));
		System.out.println(result);
		// if calling by returning multiply function return the same result but the
		// significance of the
		// code get changed
		int resultNew = ImpureFuncitonUtils.add(6, 12);
		System.out.println(resultNew);
	}

	/* higher order function creation */
	/*
	 * higher order function(pass lambda as arguments and return lambda as result)
	 * creation, receiving argument is obvious should be FI
	 */
	@Override
	public <T, R> IFactory<R> higherOrderFunctioncreateFactory(IProducer<T> producer, IConfiguration<T, R> cofigure) {
		return () ->
			{
				T product = producer.produce();
				return cofigure.configure(product);
			};
	}

	@Override
	public void higherOderFunctionCreator() {
		IFactory<Integer> ifactory = higherOrderFunctioncreateFactory(() -> Math.random() * 100, r -> r.intValue());
		Integer product = ifactory.create();
		System.out.println(product);
	}

	/* referential Transparency, no affect the result/code */
	@Override
	public void referentialTransparencyExmpl() {
		int result = PureFunctionUtils.add(PureFunctionUtils.multiply(2, 3), PureFunctionUtils.multiply(3, 4));
		result = PureFunctionUtils.add(6, PureFunctionUtils.multiply(3, 4));
		System.out.println(result);
		result = PureFunctionUtils.add(PureFunctionUtils.multiply(2, 3), 12);
		System.out.println(result);
		System.out.println(result);
		result = PureFunctionUtils.add(6, 12);
		System.out.println(result);
	}

	// @Revision point
	/* Functional Programming Technique */

	/* Function chaining */
	@Override
	public void functionChainingExample() {

		F1Consumer<String> c1 = x -> System.out.println(x);
		F1Consumer<String> c2 = y -> System.out.println(y);
		// c1.accept("Hello c1"); c2.accept("Hello c2");
		F1Consumer<String> c3 = c ->
			{
				c1.accept(c);
				c2.accept(c);
			};
		c3.accept("Hello C3");

		F1Consumer<String> c4 = c1.thenAccept(c2);
		// c2 null not gives NE maintain in code before chaining starts
		// Objects.requireNonNull(next);
		c4.accept("Basic Strong");

		Function<Integer, Integer> f1 = s -> s + 2;
		Function<Integer, Integer> f2 = s -> s * 2;
		Function<Integer, Integer> f3 = f1.andThen(f2);
		System.out.println(f3.apply(10));
	}

	/* Function Composition Example */
	@Override
	public void functionCompositionExampl(int areaInput) {
		// F1Composition<T, R>
		F1Composition<Square, Integer> fun1 = s -> s.getArea();
		F1Composition<Integer, Double> fun2 = area -> Math.sqrt(area);
		F1Composition<Square, Double> getSide = fun2.compose(fun1);
		Square square = new Square();
		square.setArea(areaInput);
		System.out.println(getSide.apply(square));

	}

	/*
	 * Closer example..it is a function that refer to closer variables in its
	 * lexical context
	 */
	public void closerExample1() {

		final int val = 100;

		F1Closer fcal = () ->
			{
				System.out.println(val);
				System.out.println("Task Completed1");
			};
		printTaskCall1(fcal);
	}

	public void printTaskCall1(F1Closer fcal) {
		final int val = 200;
		F1Closer fcalNew = () ->
			{
				System.out.println(val);
				System.out.println("Task Completed2");
			};
		// fcal.thenDoNextTask(fcalNew);
		printTask(fcal, fcalNew);
	}

	@Override
	public void printTask(F1Closer fcal1, F1Closer fcal2) {
		fcal1.doTask();
		fcal2.doTask();
	}

	/* Closer Example 2 */
	@Override
	public void closerExample2() {
		final int val = 100;
		F1Closer fcal = () ->
			{
				System.out.println(val);
				System.out.println("Task Completed1");
			};
		printTaskCall2(fcal);
	}

	@Override
	public void printTaskCall2(F1Closer fcal) {
		final int val = 200;
		F1Closer fcalNew = () ->
			{
				System.out.println(val);
				System.out.println("Task Completed2");
			};
		printTask(fcal.thenDoNextTask(fcalNew));
	}

	@Override
	public void printTask(F1Closer fcal) {
		fcal.doTask();

	}

	/*
	 * Currying Example, it is a technique basically restructure the multiple
	 * parameter function into multiple function having single parameter each
	 */
	@Override
	public void curryingExample() {

		Function<Integer, Function<Integer, Function<Integer, Integer>>> fun1 = u -> v -> w -> u + v + w;
		Function<Integer, Function<Integer, Integer>> fun2 = fun1.apply(1);
		Function<Integer, Integer> fun3 = fun2.apply(2);
		Integer sum = fun3.apply(3);
		System.out.println(sum);
	}

	/** Section 9: Design Patterns in Functional Way **/

	/* Iterator design pattern */
	@Override
	public void iteratorPatternExampl(Object obj[]) {
		IteratorList ilits = new IteratorList(obj);
		ilits.foreach(System.out::println);
	}

	/* Strategy Design Pattern */
	@Override
	public void strategyDesignPatternExampl() {
		List<Stock> stockList = new ArrayList<>();

		stockList.add(new Stock("AAPL", 318.65, 10));
		stockList.add(new Stock("MSFT", 166.86, 45));
		stockList.add(new Stock("Google", 99, 12.5));
		stockList.add(new Stock("AMZ", 1866.74, 45));
		stockList.add(new Stock("GOOGL", 1480.20, 3.5));
		stockList.add(new Stock("AAPL", 318.65, 8));
		stockList.add(new Stock("AMZ", 1866.74, 9));

		// StockFilters.bySymbol(stockList, "AMZ").forEach(System.out::println);
		// System.out.println("--------------------");
		// StockFilters.byPriceAbove(stockList, 300).forEach(System.out::println);

		StrategyFilters.filter(stockList, stock -> stock.getSymbol()
		        .equals("AMZ"))
		        .forEach(System.out::println);
		System.out.println("\n--------------------\n");
		StrategyFilters.filter(stockList, stock -> stock.getPrice() > 300)
		        .forEach(System.out::println);
	}

	/*
	 * Decorator Design Pattern, add additional functionality using given object
	 * without affecting the original object
	 */
	@Override
	public void decoratorDesignPatternExamml() {

		// Burger myOrder = new DecoratorBurger(e -> e.addVegies()).use(new Burger());
		// Burger newOrder = new DecoratorBurger(x -> x.addCheese()).use(myOrder);
		Burger newOrder = new DecoratorBurger(x -> x.addCheese())
		        .use(new DecoratorBurger(e -> e.addVegies()).use(new Burger()));

		System.out.println("I get :" + newOrder);
	}

	/* Creating Fluent interfaces, it is easy readable */
	@Override
	public void fluentInterfacesExampl() {
		FluentInterfaces.fluentMethod();
	}

	/*
	 * Creating Factory method pattern, it is creation of object without knowing the
	 * internal implementation at run time
	 */
	@Override
	public void factoryMethodExampl() {
		Iflooring flooring = FlooringFactory.getFlooring(2, 18);
		flooring.installation();

		Iflooring flooring1 = FlooringFactory.getFlooring(13, 46);
		flooring1.installation();
	}

	/*
	 * Builder Design pattern, it is creation of complex object without knowing the
	 * internal implementation at run time
	 */
	@Override
	public void builderDesignPatternExampl() {
		MobileBuilder builder = new MobileBuilder();
		Mobile mobile = builder.with(myBuilder ->
			{
				myBuilder.ram = 4;
				myBuilder.battery = 4000;
				myBuilder.processor = "A12 Bionic";
			})
		        .createMobile();
		System.out.println(mobile.toString());
	}

	/* Command design pattern */
	public void commandDesignPatternExmpl() {
		AC ac1 = new AC();

		ACAutomationRemote remote = new ACAutomationRemote();
		remote.setCommand(() -> ac1.turnOn());
		remote.buttonPressed();

		remote.setCommand(() -> ac1.turnOff());
		remote.buttonPressed();
	}

	/** Section 10: Streams and Parallel Streams in depth **/

	/* Stream Introduction Example, collect book based on requirement */
	public List<Book> streamIntroExampl(List<Book> books) {
		return books.parallelStream()
		        .filter(book -> book.getGenre()
		                .equalsIgnoreCase("horror"))
		        .filter(book -> book.getRating() > 3)
		        .collect(Collectors.toList());
	}

	/* Observing the Stream operation ie section wise operation */
	public List<Book> observationOnStreamOperation(List<Book> books) {
		// Stream Pipeline
		books.stream() // Source
		        .filter((book) -> book.getGenre()
		                .equalsIgnoreCase("Horror")) // Intermediate Op
		        .filter((book) -> book.getRating() > 3) // Intermediate Op
		        .collect(Collectors.toList()); // Terminal Op

		// 1.Source
		Stream<Book> stream = books.stream();
		// 2. Intermediate Operation
		Stream<Book> horrorBooks = stream.filter((book) -> book.getGenre()
		        .equalsIgnoreCase("Horror"));
		// 3. Intermediate Operation
		Stream<Book> pHorrorBooks = horrorBooks.filter((book) -> book.getRating() > 3);
		// 4. Terminal operation
		List<Book> collect = pHorrorBooks.collect(Collectors.toList());
		return collect;
	}

	/*
	 *  Streams are not data Containers, it is not like array/list, it is just a
	 * fancy iterator
	 */
	public List<Book> singleUseStram(List<Book> books) {

		// Same stream can't use twice since after one use it get closed below commented
		// code gives exception
//		Stream<Book> stream = books.stream();
//		List<Book> popularHorrorBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
//				.filter((book) -> book.getRating() > 3).collect(Collectors.toList());
//
//		popularHorrorBooks.forEach(System.out::println);
//
//		List<Book> popularRomanticBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Romance"))
//				.filter((book) -> book.getRating() > 3).collect(Collectors.toList());

		List<Book> popularHorrorBooks = books.stream()
		        .filter((book) -> book.getGenre()
		                .equalsIgnoreCase("Horror"))
		        .filter((book) -> book.getRating() > 3)
		        .collect(Collectors.toList());

		popularHorrorBooks.forEach(System.out::println);

		List<Book> popularRomanticBooks = books.stream()
		        .filter((book) -> book.getGenre()
		                .equalsIgnoreCase("Romance"))
		        .filter((book) -> book.getRating() > 3)
		        .collect(Collectors.toList());
		popularRomanticBooks.forEach(System.out::println);

		return popularRomanticBooks;
	}

	/* Filter Operation print even value, filter even values from stream */
	public void filterOperationExmpl() {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
		        .filter(e -> e % 2 == 0)
		        .forEach(System.out::println);
	}

	/* map operation, print multiplication table of 5 */
	public void mapOperationExml() {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		        .map(e -> e * 5)
		        .forEach(e -> System.out.println(e));
	}

	/* filter map operation together, require only the book name after filter */
	public void filterMapOperationTogether(List<Book> books) {
		books.stream()
		        .filter(e -> e.getGenre()
		                .equals("Horror"))
		        .filter(e -> e.getRating() > 3)
		        .map(e -> e.getName())
		        .forEach(System.out::println);
	}

	/* reduce operation ..get sum of elements */
	public void reducedOperation() {

		Integer sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		        .filter(e -> e % 2 == 0)
		        .reduce(0, (a, b) -> a + b);
		System.out.println(sum);
	}

	/* Stream lazy evaluation where as the terminal operation is eager */// List<Book> books = InputUtils.getBooks();
	public void collect(Stream<Book> stream) {

		List<Book> popularHorrorBooks = stream.collect(Collectors.toList());
		System.out.println("Collection done !");
		popularHorrorBooks.forEach(e -> System.out.println(e));
	}

	public void lazyEvaluationStream(List<Book> books) {
		Stream<Book> stream = books.stream()
		        .filter(e -> e.getGenre()
		                .equals("Horror"))
		        .peek(book -> System.out.println("Filtered book " + book))
		        .filter(e -> e.getRating() > 3);
		System.out.println("Filter done! ");
		collect(stream);
	}

	/*
	 * Numeric Stream, this is boxing, map get used to Boxing but mapTo...for un
	 * boxing ...find average rating of books
	 */
	public void numericStreamExmpl(List<Book> books) {
		// books.stream().map(book->book.getRating()).mapToDouble(rating->rating).average();
		OptionalDouble average = books.stream()
		        .mapToDouble(book -> book.getRating())
		        .average();
		System.out.println(average.getAsDouble());
		// map : Objects ie Boxing
		// mapToDouble : Double to primitive double ie unboxing
	}

	/* Numerics very useful methods */
	public void numericMethodsExmpl() {
		// IntStream
		// DoubleStream
		// LongStream

		// Sum
		int sum = IntStream.of()
		        .sum();
		System.out.println(sum);

		// max() Optional : primitive
		OptionalInt maxOptional = IntStream.of(1, 3, 4, 5)
		        .max();
		System.out.println(maxOptional.getAsInt());

		// min() : Optional Primitive
		OptionalInt minOptional = IntStream.of(1, 2, 3, 4)
		        .min();
		System.out.println(minOptional.getAsInt());

		// average() OptionalDouble
		OptionalDouble avgOptional = IntStream.of(1, 2, 3, 4)
		        .average();
		System.out.println(avgOptional.getAsDouble());

		// summaryStatistics()
		IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 34)
		        .summaryStatistics();
		System.out.println(summaryStatistics);
	}

	/* Bounded Stream, Finite Stream creating example */
	public void boundedStreamCreationExmpl() {
		// 1. stream() on a Collection
		List<Integer> list = List.of(1, 4, 7, 9, 4);
		Stream<Integer> streamIntegers = list.stream();
		streamIntegers.forEach(e -> System.out.println(e));
		// How we can stream a Map.
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
		Stream<Entry<Integer, String>> entries = map.entrySet()
		        .stream();
		entries.forEach(e -> System.out.println(e));

		Stream<String> values = map.values()
		        .stream();
		values.forEach(e -> System.out.println(e));

		Stream<Integer> keys = map.keySet()
		        .stream();
		keys.forEach(e -> System.out.println(e));

		// 2. of() Stream class
		Stream<String> streamStrings = Stream.of("Hey! ", "Happy", "Thanksgiving");
		streamStrings.forEach(e -> System.out.println(e));
		// 3. stream() of Arrays Class

		Integer[] integerArr = { 3, 5, 7, 89, 9 };
		Stream<Integer> stream = Arrays.stream(integerArr);
		stream.forEach(e -> System.out.println(e));
		int[] intArr = { 3, 5, 7, 89, 9 };
		IntStream stream2 = Arrays.stream(intArr);
		stream2.forEach(e -> System.out.println(e));

		// 4. builder() of Stream class.
		Builder<Integer> builder = Stream.builder();
		builder.add(1);
		// code
		// condition
		builder.add(4);
		builder.build()
		        .forEach(e -> System.out.println(e));
	}

	/* unbounded Stream, Finite Stream creating example */
	public void infiniteStreamCreationExmpl() {
		Stream.iterate(0, i -> i + 1);

		// IntStream.iterate(5, i -> i -1 )
		// .limit(15)
		// .forEach(System.out::println);

		// if we don't put limit it execute infinite
		Stream.generate(new Random()::nextInt)
		        .limit(15)
		        .forEach(System.out::println);
	}

	/* flastMap operation example */
	public void flatMapOperationExmpl() {
		Stream<String> a = Stream.of("Hello ", "there! ");
		Stream<String> b = Stream.of("Learning", "Java? ");
		// Stream<Stream<String>> of = Stream.of(a, b);
		Stream<String> flatMap = Stream.of(a, b)
		        .flatMap(e -> e);
		flatMap.collect(Collectors.toList())
		        .forEach(System.out::println);

		System.out.println("======================output from files=======================");
		Path p = Paths.get("src/comman/inputdoc/notebook.txt");
		try (Stream<String> notebook = Files.lines(p);) {

			List<String> collect = notebook.flatMap(line -> Arrays.stream(line.split(" ")))
			        .collect(Collectors.toList());
			collect.forEach(System.out::println);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/* Parallel Stream Example */
	public void parallelStreamExmple(List<EEmployee> list) {
		long startTime;
		long endTime;

		startTime = System.currentTimeMillis();
		System.out.println("Performing Sequentially: " + list.stream()
		        .filter(e -> e.getSalary() > 1000)
		        .count());
		endTime = System.currentTimeMillis();

		System.out.println("Time taken with Sequential : " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		System.out.println("Performing parallely: " + list.parallelStream()
		        .filter(e -> e.getSalary() > 1000)
		        .count());
		endTime = System.currentTimeMillis();

		System.out.println("Time taken with parallel : " + (endTime - startTime));
	}

	/* Stateless and Stateful example why not use parallel frequently */
	public void statelessStatefulOpr() {
		List<Integer> list = List.of(1, 2, 4, 5, 6, 7, 9);
		List<Integer> collect = list.parallelStream()
		        .skip(2)
		        .limit(5)
		        .collect(Collectors.toList());
		collect.forEach(e -> System.out.println(e));
	}

	/* Setting up the parallelism Example */
	public void settingUpParallelismExmpl(List<EEmployee> list) throws InterruptedException, ExecutionException {
		System.out.println(Runtime.getRuntime()
		        .availableProcessors());
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		System.out.println(ForkJoinPool.getCommonPoolParallelism());

		ForkJoinPool pool = new ForkJoinPool(2);

		long count = pool.submit(() -> list.parallelStream()
		        .filter(e -> e.getSalary() > 1000)
		        .count())
		        .get();

		System.out.println(count);

		// Computational Intensive, expansive algorithm
		// Number of threads <= number of cores

		// IO intensive, Http request, database operation
		// Number of threads > Number of cores
	}

	/** Understanding Spliterator Pattern **/

	/* Spliterator Characteristics Explanation */
	public void spliteratorCharacteristicsExplan(List<Integer> list) {
		Stream<Integer> stream = list.stream();
		Spliterator<Integer> spliterator = stream.spliterator();
		int bits = spliterator.characteristics();
		System.out.println(Integer.bitCount(bits));
		// OR
		System.out.println(Integer.bitCount(bits | 0x00000010));
		// And
		System.out.println(bits & 0x00000010);
		System.out.println(spliterator.hasCharacteristics(0x00000010));
		long count = list.stream()
		        .filter(x ->
			        {
				        System.out.println("mapping");
				        return x == x * 2;
			        })
		        .count();

		System.out.println(count);

//		//e.g
//		Stream.of(1,3,2,4,9)//ORDERED, SIZED
//		.filter(i->i%2==0) // ORDERED
//		.sorted() // ORDERED, SORTED
//		.map(i->i+1) // ORDERED
//		.unordered(); // 
	}

	/* Custome Spliterator example */
	public void customeSpliteratorExmpl() {
		Path path = Paths.get("src/comman/inputdoc/books.txt");
		try (Stream<String> lines = Files.lines(path);) {

			Spliterator<String> baseSpliterator = lines.spliterator();
			Spliterator<Book> spliterator = new BookSpliterator(baseSpliterator);

			Stream<Book> stream = StreamSupport.stream(spliterator, false);
			stream.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Section 12: Collectors for Data Processing in Depth
	 * 
	 * @throws IOException
	 **/
	/* Collectors, Important collecting operations */
	public void collectorsOperations() throws IOException {

		Path path = Paths.get("src/comman/inputdoc/employees.txt");

		try (Stream<String> lines = Files.lines(path)) {
			Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> wordSpliterator = words.spliterator();
			Spliterator<Employee> empSpliteretor = new EmployeeSpliterator(wordSpliterator);

			Stream<Employee> employees = StreamSupport.stream(empSpliteretor, false);
			List<Employee> empList = employees.collect(Collectors.toList());

			/* collect the all names of employees in list */
			List<String> empNames = empList.stream()
			        .map(emp -> emp.getName())
			        .collect(Collectors.toList());
			System.out.println("--------------X-------Name List----------X------");
			empNames.forEach(System.out::println);

			/* collect all the destination in company */
			System.out.println("--------------X-------Designation Set----------X------ ");
			Set<String> empDesination = empList.stream()
			        .map(emp -> emp.getDesignation())
			        .collect(Collectors.toSet());
			empDesination.forEach(System.out::println);

			/* collect the name of employee in sorted order */
			System.out.println("--------------X-------Name TreeSet----------X------");
			TreeSet<String> treeSet = empList.stream()
			        .map(emp -> emp.getName())
			        .collect(Collectors.toCollection(TreeSet::new));
			treeSet.forEach(System.out::println);

			/* collect the name of employees by id in map */
			System.out.println("--------------X-------Map Name byid----------X------");
			Map<Integer, String> mapNameById = empList.stream()
			        .collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
			System.out.println(mapNameById);

			/* collect male and female employees separately */
			System.out.println("--------------X-------Male and Female emp in map----------X------");
			Map<Boolean, List<Employee>> partitionedData = empList.stream()
			        .collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));

			System.out.println(partitionedData);

			List<Employee> maleEmployees = partitionedData.get(true);
			List<Employee> femaleEmployees = partitionedData.get(false);

			System.out.println("All Male Emp: " + maleEmployees + "\n All Female Emp :" + femaleEmployees);
			Map<String, List<Employee>> getByDesignation = empList.stream()
			        .collect(Collectors.groupingBy(e -> e.getDesignation()));
			System.out.println(getByDesignation);

			Long collect = empList.stream()
			        .map(e -> e.getSalary())
			        .collect(Collectors.counting());
			System.out.println(collect);

			System.out.println("-----X-------Map---------X---");

			String employeeNamesString = empList.stream()
			        .map(e -> e.getName())
			        .collect(Collectors.joining(", "));

			System.out.println(employeeNamesString);

			System.out.println("-----X-------String---------X---");
		}
	}

	/* Downstream collectors example, it is just like SQL query language get used */
	public void downstreamCollectorsExmpl() throws IOException {

		Path path = Paths.get("src/comman/inputdoc/employees.txt");
		try (Stream<String> lines = Files.lines(path)) {
			Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
			Spliterator<String> wordSpliterator = words.spliterator();
			Spliterator<Employee> empSpliteretor = new EmployeeSpliterator(wordSpliterator);

			Stream<Employee> employees = StreamSupport.stream(empSpliteretor, false);
			List<Employee> employeeList = employees.collect(Collectors.toList());

			/* how many employees in each destination */
			Map<String, Long> countByDesignation = employeeList.stream()
			        .collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));

			System.out.println(countByDesignation);

			/* collect fund distrubution of each destination */
			Map<String, Double> fundDistribution = employeeList.stream()
			        .collect(Collectors.groupingBy(e -> e.getDesignation(),
			                Collectors.summingDouble(e -> e.getSalary())));

			System.out.println(fundDistribution);

			/* collecting max salary in each destination by employee */
			Map<String, Optional<Employee>> maxSalaryEmployees = employeeList.stream()
			        .collect(Collectors.groupingBy(Employee::getDesignation,
			                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

			System.out.println(maxSalaryEmployees);

			/* collecting max salary in each destination by value */
			Map<String, Optional<Double>> maxSalaries = employeeList.stream()
			        .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.mapping(Employee::getSalary,
			                Collectors.maxBy(Comparator.comparing(Function.identity())))));

			System.out.println(maxSalaries);

		} catch (

		IOException e) {
			System.out.println(e);
		}
	}

	/** Section 13: Creating Your Own Collectors **/

	/* Creating own Collectors1 **/
	public void createOwnCollectorsExmpl1(List<Integer> numbers) {
		Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(ArrayList::new, // supplier
		        (list, e) -> list.add(e), // BiConsumer
		        (list1, list2) ->
			        {
				        list1.addAll(list2);
				        return list1;
			        }, // BiFunction
		        Collector.Characteristics.IDENTITY_FINISH);

		List<Integer> evens = numbers.stream()
		        .filter(e -> e % 2 == 0)
		        .collect(toList);
		evens.forEach(System.out::println);
	}

	/* Creating own Collectors1 that add element in the list sorted order **/
	public void createOwnCollectorsExmpl2(List<Integer> numbers) {
		Collector<Integer, List<Integer>, List<Integer>> toSortedListCollector = Collector.of(ArrayList::new, // supplier
		        (list, e) -> list.add(e), // BiConsumer
		        (list1, list2) ->
			        {
				        list1.addAll(list2);
				        return list1;
			        },
		        (list) ->
			        {
				        Collections.sort(list);
				        return list;
			        },
		        Collector.Characteristics.UNORDERED);

		List<Integer> sortedList = numbers.stream()
		        .collect(toSortedListCollector);
		sortedList.forEach(System.out::println);
	}

	/** Section 14: Playing with Collections and Map in Functional style **/

	/* basic operation of List in functional was */
	public void listOpertionFunctionStyle(List<Movie> movies) {
		// Traversal
		movies.forEach(System.out::println);
		System.out.println("------------------");
		// Sorting
		movies.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
		movies.forEach(System.out::println);
		System.out.println("------------------");
		movies.stream()
		        .filter(movie -> movie.getIndustry()
		                .equalsIgnoreCase("Bollywood"))
		        .forEach(System.out::println);
		System.out.println("------------------");
		// Mapping
		movies.stream()
		        .map(movie -> movie.getName())
		        .forEach(System.out::println);
		System.out.println("------------------");
		// Reduce
		Optional<String> moviesString = movies.stream()
		        .map(m -> m.getName())
		        .reduce((m1, m2) -> m1 + " | " + m2);
		System.out.println(moviesString);
		System.out.println("------------------");
	}

	/* basic operation of List in functional ways */
	public void setOpertionFunctionStyle(Set<Integer> set) {
		// traversal
		set.forEach(System.out::println);
		System.out.println("--------------------");

		// Filter
		set.stream()
		        .filter(e -> e % 2 == 0)
		        .forEach(System.out::println);
		System.out.println("--------------------");

		// Sorting
		set.stream()
		        .sorted()
		        .forEach(System.out::println);
		System.out.println("--------------------");
		TreeSet<Integer> sortedSet = set.stream()
		        .collect(Collectors.toCollection(TreeSet::new));
		sortedSet.forEach(System.out::println);
		System.out.println("--------------------");

		// Map
		Set<Double> hashSet = set.stream()
		        .map(e -> Double.valueOf(e))
		        .collect(Collectors.toSet());
		hashSet.forEach(System.out::println);
		System.out.println("--------------------");

		// reduce
		int sum = set.stream()
		        .mapToInt(e -> e)
		        .sum();
		System.out.println(sum);
	}

	public void mapOperationFuntionalStyle(Map<String, String> contacts) {

//traversal	
		for (Map.Entry<String, String> entry : contacts.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		System.out.println("---------------------------");
		contacts.forEach((k, v) -> System.out.println(k + " - " + v));
		System.out.println("---------------------------");

		// Filter
		contacts.entrySet()
		        .stream()
		        .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
		        .forEach(System.out::println);

		Map<String, String> filteredContacts = contacts.entrySet()
		        .stream()
		        .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
		        .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));
		filteredContacts.forEach((k, v) -> System.out.println(k + " - " + v));
		System.out.println("---------------------------");
		// Map
		String contactNames = contacts.entrySet()
		        .stream()
		        .map(c -> c.getValue())
		        .distinct()
		        .collect(Collectors.joining(" , "));

		System.out.println(contactNames);
		System.out.println("---------------------------");
		// sorting
		LinkedHashMap<String, String> sortedMap = contacts.entrySet()
		        .stream()
		        .sorted(Entry.comparingByValue())
		        .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue(), (v1, v2) -> v1, LinkedHashMap::new));

		sortedMap.forEach((k, v) -> System.out.println(k + " - " + v));
		System.out.println("---------------------------");

		// reduce
		Map<String, Double> marks = new HashMap<>();
		marks.put("Science", 66.00);
		marks.put("Maths", 78.00);
		marks.put("English", 90.00);

		OptionalDouble average = marks.values()
		        .stream()
		        .mapToDouble(m -> m)
		        .average();
		System.out.println(average.getAsDouble());
	}

	/** Section 15: Data Structures Functional Way **/

	/**
	 * Section 15: Data Structures Functional Way Note:- Functional Style data
	 * structure additionally add 3 more fundamental to general data structure that
	 * are the basic stuff of any algorithms/behaviour 1. Immutability- Thread safe
	 * 2.Persistence - Input never get affected 3.Transparent- Anywhere it can use
	 * as algorithm/behaviour
	 **/

	/* Basic List data structure operation example in function style */
	public void listOperationInFunctionlStyle() {
		ListFun<Integer> list = ListFun.list(3, 6, 9);
		list.forEach(System.out::println);

		ListFun<Integer> newList = list.addEle(56);
		newList.forEach(System.out::println);

		ListFun<Integer> removeEle = newList.removeEle(9);
		System.out.println();
		removeEle.forEach(System.out::println);

		System.out.println();
		ListFun<Integer> reverseList = removeEle.reverseList();
		reverseList.forEach(System.out::println);

		ListFun<Integer> list1 = ListFun.list(3, 6, 9, 8);
		ListFun<Integer> list2 = ListFun.list(35, 78, 90);

		System.out.println();
		ListFun.concat(list1, list2)
		        .forEach(System.out::println);

		System.out.println();

		List<Integer> l = List.of(2, 5, 8, 6);
		list1.addAllEle(l)
		        .forEach(System.out::println);
	}

	/* Basic queue data structure operation example in function style */
	public void queueOperationInFunctionlStyle() {
		QueueFun<String> q = QueueFun.queue();
		QueueFun<String> enqueue = q.enqueue("Hey")
		        .enqueue(" How are you?")
		        .enqueue(" Fine?");
		enqueue.forEach(System.out::println);
		QueueFun<String> dequeue = enqueue.dequeue();
		dequeue.forEach(System.out::println);
		System.out.println(dequeue.peek());
		System.out.println(dequeue.isEmpty());
		System.out.println(dequeue.size());
	}

	/* Basic tree data structure operation example in function style */
	public void treeOperationInFunctionlStyle() {
		TreeFun<Integer> t = TreeFun.tree(23, 5, 76, 10, 3, 45);
		TreeFun<Integer> tree = t.remove(10);
		System.out.println(tree);

		System.out.println(tree.isMember(50));
		System.out.println(tree.max());
	}

	/* Basic map data structure operation example in function style */
	public void mapOperationInFunctionlStyle() {
		MapFun<Integer, String> map = new MapFun<>(5);
		map.put(1, "Nikhil");
		map.put(2, "Sourabh");
		map.put(3, "Alex");
		map.put(5, "Shawn");
		map.put(100, "Justin");

		map.display();
	}
}
