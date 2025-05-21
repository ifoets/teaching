package com.udemy.basic.functional;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.udemy.basic.functional.finterface.F1Closer;
import com.udemy.basic.functional.finterface.F1Interface;
import com.udemy.basic.functional.finterface.IConfiguration;
import com.udemy.basic.functional.finterface.IFactory;
import com.udemy.basic.functional.finterface.IProducer;
import com.udemy.basic.functional.model.Book;
import com.udemy.basic.functional.model.EEmployee;
import com.udemy.basic.functional.model.Movie;

public interface IFunctional {

	/** Section3: basic Lambda and functional interface **/
	/* use of functional interface */
	public void runnaleThredExecute();

	/* Runnable is functional interface it can use in lambda expression */
	public void runnaleThredExecuteLamda();

	/* create and use functional interface */
	public void useOwnFunctionlIntface();

	/* pass behaviour as FI ie us FI as method argument */
	public void onTheFly(F1Interface f);

	/* multiple implementation create multiple class file under the hood */
	public void lambdaUnderTheHood();

	/* imperative/not thread safe vs Declarative style/thread safe of programming */
	public int imperativeDeclarativeStyle();

	/** Section 4: Practice Lambda with different signatures **/

	/* Method with NO parameter No Return Type */
	public void noParamNoReturnType();

	/* Method with parameter No Return Type */
	public void withParamNoReturnType(int x, int y);

	/* Method with parameter Return Type */
	public int withParamReturnType(String s);

	/* method with multiple statement */
	public int multiStatement(String s);

	/** Section 5: Predefined Functional Interfaces and Practice **/

	/* execute generic functional interface */
	public String executeGenFunInterface(String s);

	/* use of Predicate functionality */
	public <T> List<T> filter(List<T> t, Predicate<T> p);

	public List<String> filterString(List<String> list, String str);

	public List<String> filterNonEmptyFString(List<String> list);

	public List<Integer> filterEvenInteger(List<Integer> list);

	/* use of Consumer functionality */
	public <T> void acceptElement(List<T> t, Consumer<T> c);

	public void printElement(List<Integer> list);

	/* use of Supplier functionality */
	public String stringConcat(String str1, String str2);

	public double randomNumber();

	/* use of Function functionality */
	public <T, R> List<R> mapped(List<T> t, Function<T, R> f);

	public List<Integer> lenthOfListStr(List<String> list);

	/* use of UnaryOperator functionality */
	public <T> List<T> mappedUnaryOperator(List<T> t, UnaryOperator<T> u);

	public List<Integer> doubleTheElement(List<Integer> list);

	/* use of BiFunction functionality */
	public Integer getConcateLenth(String str1, String str2);

	/* use of BinaryOperator functionality */
	public String getSpecialConcate(String str1, String str2);

	/** Section 6: Method and Constructor Reference **/

	/* Method reference */
	/* class::static method */
	public void printElementMethodRef(List<Integer> list);

	/* class::staticMethod */
	public double randomNumberMethodRef();

	/* class::staticMethod */
	/* method reference take argument and return something */
	public String concateMethodRef(String str1, String str2);

	/* class::instanceMethod */
	public List<Integer> lenthOfListStrMethodRef(List<String> list);

	/* class::new */
	public void threadGenrator();

	/** Section 7: Optional for Null Pointer **/

	/* creating Optional different ways */
	public void createOptional();

	/* getting the value back from Optional */
	public void getOptional();

	/* getting the empty value back from Optional */
	public void getEmptyOptional();

	/* getting the empty throw Optional */
	public void getEmptyThrowFOptional();

	/* Optional operation part1: map(), filter(), flatMap() */
	public void optionalOperation1();

	/* Optional operation part2: */
	public void optionalOperation2();

	/** Section 8: Functional Programming in Depth **/

	/* impure function, that affect if we pass the result as argument */
	public void impureFunctionUnderstandExmpl();

	/* higher order function creation */
	/*
	 * higher order function(pass lambda as arguments and return lambda as result)
	 * creation, receiving argument is obvious should be FI
	 */
	public <T, R> IFactory<R> higherOrderFunctioncreateFactory(IProducer<T> producer, IConfiguration<T, R> cofigure);

	public void higherOderFunctionCreator();

	/* referential Transparency, no affect the result/code */
	public void referentialTransparencyExmpl();

	/* Functional Programming Technique */

	/* Function chaining */
	public void functionChainingExample();

	/* Function Composition Example */
	public void functionCompositionExampl(int area);

	/*
	 * Closer example..it is a function that refer to closer variables in its
	 * lexical context
	 */
	public void closerExample1();

	public void printTaskCall1(F1Closer fcal);

	public void printTask(F1Closer fcal1, F1Closer fcal2);

	/* Closer Example 2 */
	public void closerExample2();

	public void printTaskCall2(F1Closer fcal);

	public void printTask(F1Closer fcal);

	/*
	 * Currying Example, it is a technique basically restructure the multiple
	 * parameter function into multiple function having single parameter each
	 */
	public void curryingExample();
	/*
	 * Lazy Evaluation, Whenever we write lambda it not get executed, it is just the
	 * implementation. It gets executed whenever we call it; So We can say lambda is
	 * lazy. Yes lazy evaluator
	 */

	/*
	 * Tail call Optimisation,or Tail call Recursion, head recursion keep stack
	 * holding but tail recursion free from it
	 */

	/** Section 9: Design Patterns in Functional Way **/

	/*
	 * Iterator design pattern ,Iterating the collection element without knowing the
	 * internal implementation
	 */
	public void iteratorPatternExampl(Object obj[]);

	/*
	 * Strategy Design Pattern, if algorithm have different solution then select
	 * some one at run time, it eliminate the conditional stuff
	 */

	public void strategyDesignPatternExampl();

	/*
	 * Decorator Design Pattern, add additional functionality using given object
	 * without affecting the original object
	 */
	public void decoratorDesignPatternExamml();

	/* Creating Fluent interfaces, it is easy readable */
	public void fluentInterfacesExampl();

	/*
	 * Creating Factory method pattern, it is creation of object without knowing the
	 * internal implementation at run time
	 */
	public void factoryMethodExampl();

	/*
	 * Builder Design pattern, it is creation of complex object without knowing the
	 * internal implementation at run time
	 */
	public void builderDesignPatternExampl();

	/*
	 * Command design pattern, it control the the behaviour based on command get
	 * fired on object
	 */
	public void commandDesignPatternExmpl();

	/**
	 * Section 10: Streams and Parallel Streams in depth using stream we can pass
	 * the data as functional style and declarative
	 **/

	/* Stream Introduction Example, collect book based on requirement */
	public List<Book> streamIntroExampl(List<Book> books);

	/* Observing the Stream operation ie section wise operation */
	public List<Book> observationOnStreamOperation(List<Book> books);

	/*
	 * Streams are not data Containers, it is not like array/list, it is just a
	 * fancy iterator
	 */
	public List<Book> singleUseStram(List<Book> books);

	/* Different Filter Operation */

	/* Filter Operation print even value, filter even values from stream */
	public void filterOperationExmpl();

	/* map operation, print multiplication table of 5 */
	public void mapOperationExml();

	/* filter map operation together, require only the book name after filter */
	public void filterMapOperationTogether(List<Book> books);

	/* reduce operation ..get sum of even elements */
	public void reducedOperation();

	/* Stream lazy evaluation where as the terminal operation is eager */
	public void collect(Stream<Book> stream);

	public void lazyEvaluationStream(List<Book> books);

	/*
	 * Numeric Stream, this is boxing, map get used to Boxing but mapTo...for un
	 * boxing ...find average rating of books
	 */
	public void numericStreamExmpl(List<Book> books);

	/* Numerics very useful methods */
	public void numericMethodsExmpl();

	/* Bounded Stream, Finite Stream creating example */
	public void boundedStreamCreationExmpl();

	/* unbounded Stream, Finite Stream creating example */
	public void infiniteStreamCreationExmpl();

	/* flastMap operation example */
	public void flatMapOperationExmpl();

	/* Parallel Stream Example */
	public void parallelStreamExmple(List<EEmployee> list);

	/* Stateless and Stateful example why not use parallel frequently */
	public void statelessStatefulOpr();

	/* Setting up the parallelism Example */
	public void settingUpParallelismExmpl(List<EEmployee> list) throws InterruptedException, ExecutionException;

	/** Understanding Spliterator Pattern **/

	/* Spliterator Characteristics Explanation */
	public void spliteratorCharacteristicsExplan(List<Integer> list);

	/* Custom Spliterator example */
	public void customeSpliteratorExmpl();

	/** Section 12: Collectors for Data Processing in Depth **/

	/* Collectors, Important collecting operations */
	public void collectorsOperations() throws IOException;

	/* Downstream collectors example, it is just like SQL query language get used */
	public void downstreamCollectorsExmpl() throws IOException;

	/** Section 13: Creating Your Own Collectors **/

	/* Creating own Collectors1 collect even no of element **/
	public void createOwnCollectorsExmpl1(List<Integer> list);

	/* Creating own Collectors1 that add element in the list sorted order **/
	public void createOwnCollectorsExmpl2(List<Integer> list);

	/** Section 14: Playing with Collections and Map in Functional style **/

	/* basic operation of List in functional ways */
	public void listOpertionFunctionStyle(List<Movie> movies);

	/* basic operation of Set in functional ways */
	public void setOpertionFunctionStyle(Set<Integer> set);

	/* basic operation of Map in functional ways */
	public void mapOperationFuntionalStyle(Map<String, String> contacts);

	/**
	 * Section 15: Data Structures Functional Way Note:- Functional Style data
	 * structure additionally add 3 more fundamental to general data structure that
	 * are the basic stuff of any algorithms/behaviour 1. Immutability- Thread safe
	 * 2.Persistence - Input never get affected 3.Transparent- Anywhere it can use
	 * as algorithm/behaviour
	 **/

	/* Basic List data structure operation example in function style */
	public void listOperationInFunctionlStyle();

	/* Basic queue data structure operation example in function style */
	public void queueOperationInFunctionlStyle();

	/* Basic tree data structure operation example in function style */
	public void treeOperationInFunctionlStyle();

	/* Basic map data structure operation example in function style */
	public void mapOperationInFunctionlStyle();

}
