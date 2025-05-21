package com.udemy.basic.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.udemy.basic.functional.finterface.IGreetingService;
import com.udemy.basic.functional.finterface.IMathOperation;
import com.udemy.basic.functional.finterface.IOpertionService;
import com.udemy.basic.generic.creation.IStringOperation;
import com.udemy.basic.reactive.rinterface.IStrOperations;

public class RxFunctionalImpl implements IRxFunctional {

	/** Section 4: Java 8 - Introduction To Lambda **/

	/* How to create lambda function */
	@Override
	public void createLambda() {

		IGreetingService s1 = new IGreetingService() {
			@Override
			public String greet(String name) {
				return "HI..." + name;
			}
		};
		s1.greet("Anonymous Style");

		IGreetingService hi = (e) -> e.toUpperCase();
		hi.greet("Lambda Style");
	}

	/*
	 * SAM(single abstract method @FunctionInterface notation on interface)
	 * Functional interface
	 */
	@Override
	public void samFunctionalExmpl() {
		IOpertionService<String, String> concat = (e1, e2) -> e1.concat(e2);
		System.out.println("Concat of Guru and Ji:- " + concat.operation("Guru", "Ji"));

		IOpertionService<String, Integer> len = (e1, e2) -> e1.length() + e2.length();
		System.out.println("Additionl lenth of String  Abhimanyu and  Kumar :- " + len.operation("abhimanyu", "kumar"));
	}

	/*
	 * Single line VS Multiple line Lambda , when only single line require the no {}
	 * other wise use {}
	 */
	@Override
	public String singleMultiLineLambda(String s1, String s2) {
		// multiple line ie.. body {}
		IOpertionService<String, String> opr = (x, y) ->
			{
				// single line no body required it is optionalF
				IOpertionService<Integer, Integer> innerOper = (a, b) -> a + b;
				System.out.println(innerOper.operation(x.length(), y.length()));

				return x.toUpperCase() + " " + y.toUpperCase();
			};
		return opr.operation(s1, s2);
	}

	/* Functional programming, assigning a function body to a variable */
	@Override
	public void functionProgrammingExmpl() {
		// here assigning (a, b) -> (a + b).length() to opr that is reference
		// here opr is the first class object who hold the behaviour
		IOpertionService<String, Integer> opr = (a, b) -> (a + b).length();
		System.out.println(opr.operation("Guru", "ji"));
	}

	/*
	 * Higher order function, a method who receive the behaviour , ie the parameter
	 * type must be a functional interface
	 */
	@Override
	public <T> void passByBehavour(IStringOperation<T> opr, String str) {
		T t = opr.strOperation(str);
		System.out.println("Ppertion on " + str + " result by passing behaviour: " + t);
	}

	@Override
	public void execuetePassByBehaviour(String str) {
		passByBehavour((e) -> e.length(), str);
		passByBehavour((e) -> e.toUpperCase(), str);
		passByBehavour((e) -> e.replace("man", "MAN"), str);
	}

	public IGreetingService returnBehaviour() {
		return e -> e.toUpperCase();
	}

	public String executeReturnBehaiour(String str) {
		return returnBehaviour().greet(str);
	}

	/*
	 * When lambda executed, it executed when method of functional interface get
	 * called
	 */
	private void test(IGreetingService g) {
		System.out.println("Inside test method , Received GreetingService ");
		System.out.println("FI method start execution...");
		String returnString = g.greet("abhimayu");
		System.out.println("FI method executed");
		System.out.println(returnString);
	}

	@Override
	public void lambdaExecuttionMoment() {
		System.out.println("Execution strarted...");
		test(e ->
			{
				System.out.println("Inside lambda");
				return e.toUpperCase();
			});

		System.out.println("Execution Ending...");

	}

	/* method reference examples */
	/*
	 * Instance Method Reference Method reference to an instance method of an object
	 * object::instanceMethod
	 */
	public void instanceMethodReferenceExmpl() {

		IStringOperation<String> opr = String::toUpperCase; // (s) -> s.toUpperCase();
		System.out.println(opr.strOperation("Abhimanyu"));

		IStrOperations test = Objects::isNull;
		System.out.println(test.accept(null));
	}

	/* Simple calculator */
	public void simpleCalculator(int x, int y) {

		IMathOperation add = (a, b) -> a + b;
		System.out.println(x + "+" + y + "=" + add.operation(10, 5));

		IMathOperation subst = (a, b) -> a - b;
		System.out.println(x + "-" + y + "=" + subst.operation(10, 5));

		IMathOperation multi = (a, b) -> a * b;
		System.out.println(x + "*" + y + "=" + multi.operation(10, 5));

		IMathOperation div = (a, b) -> a / b;
		System.out.println(x + "/" + y + "=" + div.operation(10, 5));
	}

	/** Section 5: Java 8 - Functional Interfaces **/
	/*
	 * Supplier when without passing any argument you need something as per your
	 * requirement
	 */
	@Override
	public void supplierExmpl() {
		Supplier<Double> sup1 = Math::random;// () -> Math.random();
		Supplier<String> sup2 = String.valueOf("abhimanyu")::toUpperCase;

		Supplier<Supplier<String>> sup3 = () -> sup2;
		try {
			System.out.println(sup1.get());
			System.out.println(sup2.get());
			System.out.println(sup3.get()
			        .get());

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/* Consumer example, it take input and not return anything just consume it */
	@Override
	public void consumerExmpl() {

		List<String> sList = new ArrayList<>();
		sList.add("Abhimanyu");
		sList.add("Kumar");

		Consumer<String> dbCon = (s) -> System.out.println("I M writting to db :" + s);
		Consumer<String> logCon = (s) -> System.out.println("I M writting to log :" + s);
		Consumer<String> mailCon = (s) -> System.out.println("I M Sending mail :" + s);

		sList.forEach(dbCon);
		System.out.println("Consumer chaining------------X-----------------X--------------");
		Consumer<String> dbLogMailCon = dbCon.andThen(logCon)
		        .andThen(mailCon);
		sList.forEach(dbLogMailCon);
	}

	@Override
	public void consumerFindSystemProperties() {

		List<String> sList = new ArrayList<>();
		sList.add("Abhimanyu");
		sList.add("Kumar");

		Consumer<String> dbCon = (s) -> System.out.println("to db :" + s);
		Consumer<String> logCon = (s) -> System.out.println("to log :" + s);
		Consumer<String> mailCon = (s) -> System.out.println("Sending mail :" + s);

		Map<String, Consumer<String>> map = new HashMap<>();
		map.put("db", dbCon);
		map.put("log", logCon);
		map.put("mail", mailCon);
		map.put("dblog", dbCon.andThen(logCon));
		// consumer chaining must be same type the only it can be perform chaining
		map.put("dblogmail", dbCon.andThen(logCon)
		        .andThen(mailCon));

		// we can find system properties on behaviour without any if else
		Properties pro = new Properties();
		pro.setProperty("dblogmail", "dblogmail");
		System.setProperties(pro);
		sList.forEach(map.get(System.getProperty("dblogmail")));
	}

	/* By Consumer accept two value and no return type */
	@Override
	public void byConsumerExmpl() {

		Consumer<String> dbCon = (s) -> System.out.println("to db :" + s);
		BiConsumer<String, Consumer<String>> byCon = (s, c) ->
			{
				c.accept(s);
			};
		byCon.accept("Kumar", dbCon);
	}
}
