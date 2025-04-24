package com.udemy.basic.functional;

import com.udemy.basic.functional.finterface.IGreetingService;
import com.udemy.basic.generic.creation.IStringOperation;

public interface IRxFunctional {

	/** Section 4: Java 8 - Introduction To Lambda **/

	/* How to create lambda function */
	public void createLambda();

	/*
	 * SAM(single abstract method @FunctionInterface notation on interface)
	 * Functional interface
	 */
	public void samFunctionalExmpl();

	/*
	 * Single line VS Multiple line Lambda , when only single line require the no {}
	 * other wise use {}
	 */
	public String singleMultiLineLambda(String s, String s2);

	/* Functional programming, assigning a function body to a variable */
	/*
	 * Function as a first class object is the the variable who hold the function
	 * body
	 */
	public void functionProgrammingExmpl();

	/*
	 * Higher order function, a method who receive/return the behaviour , ie the
	 * parameter type must be a functional interface
	 */
	public <T> void passByBehavour(IStringOperation<T> opr, String str);

	public void execuetePassByBehaviour(String str);

	public IGreetingService returnBehaviour();

	public String executeReturnBehaiour(String str);

	/*
	 * When lambda executed, it executed when method of functional interface get
	 * called
	 */
	public void lambdaExecuttionMoment();

	/* method reference examples */
	/*
	 * Instance Method Reference Method reference to an instance method of an object
	 *  object::instanceMethod
	 */
	public void instanceMethodReferenceExmpl();

	/* Simple calculator */
	public void simpleCalculator(int x, int y);

	/** Section 5: Java 8 - Functional Interfaces **/
	/*
	 * Supplier when without passing any argument you need something as per your
	 * requirement
	 */
	public void supplierExmpl();

	/* Consumer example, it take input and not return anything just consume it */
	public void consumerExmpl();

	public void consumerFindSystemProperties();

	/* By Consumer accept two value and no return type */
	public void byConsumerExmpl();

}
