package com.udemy.basic.functional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import com.udemy.basic.functional.input.utils.FnInputUtils;
import com.udemy.basic.functional.model.Book;

public class IFunctionalTest {

	IFunctional ifl = null;

	@Before
	public void init() {
		ifl = new FunctionalImpl();
	}

	/** Section2: basic Lambda and functional interface **/
	@Test
	public void runnaleThredExecuteTest() {
		ifl.runnaleThredExecute();
	}

	@Test
	public void runnaleThredExecuteLamdaTest() {
		ifl.runnaleThredExecuteLamda();
	}

	/* create and use functional interface ,body implemented at run time */
	@Test
	public void useOwnFunctionlIntfaceTest() {
		ifl.useOwnFunctionlIntface();
	}

	/* pass behaviour as FI ie us FI as method argument */
	@Test
	public void onTheFlyTest() {
		ifl.onTheFly(() -> System.out.println("pass behaviour as FI"));
	}

	/* multiple implementation create multiple class file under the hood */
	@Test
	public void lambdaUnderTheHoodTest() {
		ifl.lambdaUnderTheHood();
	}

	/* imperative/not thread safe vs Declarative style/thread safe of programming */
	// sum of even no from 0 to 100
	@Test
	public void imperativeDeclarativeStyleTest() {
		System.out.println(ifl.imperativeDeclarativeStyle());
	}

	/** Section 4: Practice Lambda with different signatures **/
	/* Method with NO parameter No Return Type */
	@Test
	public void noParamNoReturnTypeTest() {
		ifl.noParamNoReturnType();
	}

	/* Method with parameter No Return Type */
	@Test
	public void withParamNoReturnTypeTest() {
		ifl.withParamNoReturnType(10, 20);
	}

	/* Method with parameter Return Type */
	@Test
	public void withParamReturnTypeTest() {
		System.out.println("Length of String Guruji:- " + ifl.withParamReturnType("Guruji"));
	}

	@Test
	public void multiStatementTest() {
		System.out.println("Length of String Guruji:- " + ifl.multiStatement("Guruji"));
	}

	/** Section 5: Predefined Functional Interfaces and Practice **/
	/* execute generic functional interface */
	@Test
	public void executeGenFunInterfaceTest() {
		System.out.println(ifl.executeGenFunInterface("abhimanyu"));
	}

	@Test
	public void filterStringTest() {
		List<String> list = List.of("Basic", "Strong", "BasicStrong");
		System.out.println(Arrays.asList(ifl.filterString(list, "Basic")));
	}

	@Test
	public void filterNonEmptyFStringTest() {
		List<String> list = List.of("Basic", "", "BasicStrong", "", "Strong");
		System.out.println(Arrays.asList(ifl.filterNonEmptyFString(list)));
	}

	@Test
	public void filterEvenIntegerTest() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(Arrays.asList(ifl.filterEvenInteger(list)));
	}

	@Test
	public void printElementTest() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		ifl.printElement(list);
	}

	/* use of Supplier functionality */
	@Test
	public void stringConcatTest() {
		System.out.println(ifl.stringConcat("abhimanyu ", "Kumar"));
	}

	@Test
	public void randomNumberTest() {
		System.out.println(ifl.randomNumber());
	}

	/* use of Function functionality */
	@Test
	public void lenthOfListStrTest() {
		List<String> list = List.of("Basic", "", "BasicStrong", "", "Strong");
		System.out.println(Arrays.asList(ifl.lenthOfListStr(list)));
	}

	/* use of UnaryOperator functionality */
	@Test
	public void doubleTheElementTest() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(Arrays.asList(ifl.doubleTheElement(list)));
	}

	/* use of BiFunction functionality */
	@Test
	public void getConcateLenthTest() {
		System.out.println(Arrays.asList(ifl.getConcateLenth("Abhimanyu", "Kumar")));
	}

	/* use of BinaryOperator functionality */
	@Test
	public void getSpecialConcateTest() {
		System.out.println(Arrays.asList(ifl.getSpecialConcate("udemy", "com")));
	}

	/** Section 6: Method and Constructor Reference **/

	/* Method reference */
	@Test
	public void printElementMethodRefTest() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		ifl.printElementMethodRef(list);
	}

	@Test
	public void randomNumberMethodRefTest() {
		System.out.println(ifl.randomNumberMethodRef());
	}

	/* method reference tak argument and return somthing */
	@Test
	public void concateMethodRefTest() {
		System.out.println(ifl.concateMethodRef("abhimanyu ", "Kumar"));
	}

	/* class::instanceMethod */
	@Test
	public void lenthOfListStrMethodRefTest() {
		List<String> list = List.of("Basic", "", "BasicStrong", "", "Strong");
		System.out.println(Arrays.asList(ifl.lenthOfListStrMethodRef(list)));
	}

	/* class::new */
	@Test
	public void threadGenratorTest() {
		ifl.threadGenrator();
	}

	/** Section 7: Optional for Null Pointer **/

	/* creating Optional different ways */
	@Test
	public void createOptionalTest() {
		ifl.createOptional();
	}

	/* getting the value back from Optional */
	@Test
	public void getOptionalTest() {
		ifl.getOptional();
	}

	/* getting the empty value back from Optional */
	@Test
	public void getEmptyOptionalTest() {
		ifl.getEmptyOptional();
	}

	/* getting the empty thorw Optional */
	@Test
	public void getEmptyThrowFOptionalTest() {
		ifl.getEmptyThrowFOptional();
	}

	/* Optional operation part1: map(), filter(), flatMap() */
	@Test
	public void optionalOperation1Test() {
		ifl.optionalOperation1();
	}

	/* Optional operation part2: */
	@Test
	public void optionalOperation2Test() {
		ifl.optionalOperation2();
	}

	/** Section 8: Functional Programming in Depth **/

	/* higher order function creation */
	@Test
	public void higherOderFunctionCreatorTest() {
		ifl.higherOderFunctionCreator();
	}

	/* impure function, that affect if we pass the result as argument */
	@Test
	public void impureFunctionUnderstandExmplTest() {
		ifl.impureFunctionUnderstandExmpl();
	}

	/* referential Transparency, no affect the result/code */
	@Test
	public void referentialTransparencyExmplTest() {
		ifl.referentialTransparencyExmpl();
	}

	/* Functional Programming Technique */

	/* Function chaining */
	@Test
	public void functionChainingExampleTest() {
		ifl.functionChainingExample();
	}

	/* Function Composition Example */
	@Test
	public void functionCompositionExamplTest() {
		ifl.functionCompositionExampl(100);
	}

	/*
	 * Closer example..it is a function that refer to closer variables in its
	 * lexical context
	 */
	@Test
	public void closerExampleTest1() {
		ifl.closerExample1();
	}

	@Test
	public void closerExampleTest2() {
		ifl.closerExample2();
	}

	/*
	 * Currying Example, it is a technique basically restructure the multiple
	 * parameter function into multiple function having single parameter each
	 */
	@Test
	public void curryingExampleTest() {
		ifl.curryingExample();
	}

	/** Section 9: Design Patterns in Functional Way **/

	/* Iterator design pattern */
	@Test
	public void iteratorPatternExamplTest() {
		Object obj[] = new Object[] { 1, 2, 3, 4, 5 };
		ifl.iteratorPatternExampl(obj);
	}

	/* Strategy Design Pattern */
	@Test
	public void strategyDesignPatternExamplTest() {
		ifl.strategyDesignPatternExampl();
	}

	/*
	 * Decorator Design Pattern, add additional functionality using given object
	 * without affecting the original object
	 */
	@Test
	public void decoratorDesignPatternExamlTest() {
		ifl.decoratorDesignPatternExamml();
	}

	/* Creating Fluent interfaces, it is easy readable */
	@Test
	public void fluentInterfacesExamplTest() {
		ifl.fluentInterfacesExampl();
	}

	/*
	 * Creating Factory method pattern, it is creation of object without knowing the
	 * internal implementation at run time
	 */
	@Test
	public void factoryMethodExamplTest() {
		ifl.factoryMethodExampl();
	}

	/*
	 * Builder Design pattern, it is creation of complex object without knowing the
	 * internal implementation at run time
	 */
	@Test
	public void builderDesignPatternExamplTest() {
		ifl.builderDesignPatternExampl();
	}

	/* Command design pattern */
	@Test
	public void commandDesignPatternExmplTest() {
		ifl.commandDesignPatternExmpl();
	}

	/** Section 10: Streams and Parallel Streams in depth **/

	/* Stream Introduction Example */
	@Test
	public void streamIntroExampTest() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Abc", "Abc", "horror", 4));
		books.add(new Book("Abc", "abc", "horror", 3));
		books = ifl.streamIntroExampl(books);
		System.out.println(Arrays.asList(books).toString());
	}

	/* Observing the Stream operation ie section wise operation */
	@Test
	public void observationOnStreamOperationTest() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Abc", "Abc", "horror", 4));
		books.add(new Book("Abc", "abc", "horror", 3));
		books = ifl.observationOnStreamOperation(books);
		System.out.println(Arrays.asList(books).toString());
	}

	/*
	 * Streams are not data Containers, it is not like array/list, it is just a
	 * fancy iterator
	 */
	@Test
	public void singleUseStramTest() {

		ifl.singleUseStram(FnInputUtils.getBooks());
	}

	/* Filter Operation */
	@Test
	public void filterOperationExmplTest() {
		ifl.filterOperationExmpl();
	}

	/* map operation, print multiplication table of 5 */
	@Test
	public void mapOperationExmlTest() {
		ifl.mapOperationExml();
	}

	/* filter map operation together, require only the book name after filter */
	@Test
	public void filterMapOperationTogetherTest() {

		ifl.filterMapOperationTogether(FnInputUtils.getBooks());
	}

	/* reduce operation ..get sum of even elements */
	@Test
	public void reducedOperationTest() {
		ifl.reducedOperation();
	}

	/* Stream lazy evaluation where as the terminal operation is eager */
	@Test
	public void lazyEvaluationStreamTest() {
		ifl.lazyEvaluationStream(FnInputUtils.getBooks());
	}

	/*
	 * Numeric Stream, this is boxing, map get used to Boxing but mapTo...for un
	 * boxing ...find average rating of books
	 */
	@Test
	public void numericStreamExmplTest() {
		ifl.numericStreamExmpl(FnInputUtils.getBooks());
	}

	/* Numerics very useful methods */
	@Test
	public void numericMethodsExmplTest() {
		ifl.numericMethodsExmpl();
	}

	/* Bounded Stream, Finite Stream creating example */
	@Test
	public void boundedStreamCreationExmplTest() {
		ifl.boundedStreamCreationExmpl();
	}

	/* unbounded Stream, Finite Stream creating example */
	@Test
	public void infiniteStreamCreationExmplTest() {
		ifl.infiniteStreamCreationExmpl();
	}

	/* flastMap operation example */
	@Test
	public void flatMapOperationExmplTest() {
		ifl.flatMapOperationExmpl();
	}

	/* Parallel Stream Example */
	@Test
	public void parallelStreamExmpleTest() {
		ifl.parallelStreamExmple(FnInputUtils.getEmployees());
	}

	/* Stateless and Stateful example why not use parallel frequently */
	@Test
	public void statelessStatefulOpr() {
		// not require
	}

	/* Setting up the parallelism Example */
	@Test
	public void settingUpParallelismExmpl() throws InterruptedException, ExecutionException {
		ifl.settingUpParallelismExmpl(FnInputUtils.getEmployees());
	}

	/** Understanding Spliterator Pattern **/

	/* Spliterator Characteristics Explanation */
	@Test
	public void spliteratorCharacteristicsExplanTest() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(0);
		list.add(1);
		ifl.spliteratorCharacteristicsExplan(list);
	}

	/* Custom Spliterator example */
	@Test
	public void customeSpliteratorExmplTest() {
		ifl.customeSpliteratorExmpl();
	}

	/** Section 12: Collectors for Data Processing in Depth **/

	/* Collectors, Important collecting operations */
	@Test
	public void collectorsOperationsTest() throws IOException {
		ifl.collectorsOperations();
	}

	/* Downstream collectors example, it is just like SQL query language get used */
	@Test
	public void downstreamCollectorsExmplTest() throws IOException {
		ifl.downstreamCollectorsExmpl();
	}

	/** Section 13: Creating Your Own Collectors **/

	/* Creating own Collectors1 **/
	@Test
	public void createOwnCollectorsExmpl1Test() {
		List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);
		ifl.createOwnCollectorsExmpl1(numbers);
	}

	/* Creating own Collectors1 that add element in the list sorted order **/
	@Test
	public void createOwnCollectorsExmpl2() {
		List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);
		ifl.createOwnCollectorsExmpl2(numbers);
	}

	/** Section 14: Playing with Collections and Map in Functional style **/

	/* basic operation of List in functional was */
	@Test
	public void listOpertionFunctionStyleTest() {
		ifl.listOpertionFunctionStyle(FnInputUtils.getMovies());
	}

	/* basic operation of List in functional ways */
	@Test
	public void setOpertionFunctionStyleTest() {
		Set<Integer> set = Set.of(3, 56, 7, 82, 39);
		ifl.setOpertionFunctionStyle(set);
	}

	/* basic operation of Map in functional ways */
	@Test
	public void mapOperationFuntionalStyleTest() {
		ifl.mapOperationFuntionalStyle(FnInputUtils.getContacts());
	}

	/** Section 15: Data Structures Functional Way **/

	/* Basic List data structure operation example in function style */

	/**
	 * Section 15: Data Structures Functional Way Note:- Functional Style data
	 * structure additionally add 3 more fundamental to general data structure that
	 * are the basic stuff of any algorithms/behaviour 1. Immutability- Thread safe
	 * 2.Persistence - Input never get affected 3.Transparent- Anywhere it can use
	 * as algorithm/behaviour
	 **/

	/* Basic List data structure operation example in function style */
	@Test
	public void listOperationInFunctionlStyleTest() {
		ifl.listOperationInFunctionlStyle();
	}

	/* Basic queue data structure operation example in function style */
	@Test
	public void queueOperationInFunctionlStyleTest() {
		ifl.queueOperationInFunctionlStyle();
	}

	/* Basic tree data structure operation example in function style */
	@Test
	public void treeOperationInFunctionlStyleTest() {
		ifl.treeOperationInFunctionlStyle();
	}

	/* Basic map data structure operation example in function style */
	@Test
	public void mapOperationInFunctionlStyleTest() {
		ifl.mapOperationInFunctionlStyle();
	}

}