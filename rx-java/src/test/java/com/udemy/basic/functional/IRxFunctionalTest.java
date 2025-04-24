package com.udemy.basic.functional;

import org.junit.Before;
import org.junit.Test;

public class IRxFunctionalTest {

	IRxFunctional irxf = null;

	@Before
	public void init() {
		irxf = new RxFunctionalImpl();
	}

	/** Section 4: Java 8 - Introduction To Lambda **/

	/* How to create lambda function */
	@Test
	public void createLambdaTest() {
		irxf.createLambda();
	}

	/*
	 * SAM(single abstract method @FunctionInterface notation on interface)
	 * Functional interface
	 */
	@Test
	public void samFunctionalExmplTest() {
		irxf.samFunctionalExmpl();
	}

	/*
	 * Single line VS Multi line Lambda , when only single line require the no {}
	 * other wise use {}
	 */
	@Test
	public void singleMultiLineLambdaTest() {
		System.out.println(irxf.singleMultiLineLambda("Abhimanyu", "Kumar"));
	}

	/* Functional programming, assigning a function body to a variable */
	@Test
	public void functionProgrammingExmplTest() {
		irxf.functionProgrammingExmpl();
	}

	/*
	 * Higher order function, a method who receive the behaviour , ie the parameter
	 * type must be a functional interface
	 */
	@Test
	public void execuetePassByBehaviourTest() {
		irxf.execuetePassByBehaviour("Abhimanyu");
	}

	@Test
	public void executeReturnBehaiourTest() {
		System.out.println(irxf.executeReturnBehaiour("Guruji"));
	}

	/*
	 * When lambda executed, it executed when method of functional interface get
	 * called
	 */
	@Test
	public void lambdaExecuttionMomentTest() {
		irxf.lambdaExecuttionMoment();
	}

	/* method reference examples */
	/*
	 * Instance Method Reference Method reference to an instance method of an object
	 *  object::instanceMethod
	 */
	@Test
	public void instanceMethodReferenceExmplTest() {
		irxf.instanceMethodReferenceExmpl();
	}

	/* Simple calculator */
	@Test
	public void simpleCalculatorTest() {
		irxf.simpleCalculator(10, 5);
	}

	/** Section 5: Java 8 - Functional Interfaces **/
	/*
	 * Supplier when without passing any argument you need something as per your
	 * requirement
	 */
	@Test
	public void supplierExmplTest() {
		irxf.supplierExmpl();
	}

	/* Consumer example, it take input and not return anything just consume it */
	@Test
	public void consumerExmplTest() {
		irxf.consumerExmpl();
	}

	@Test
	public void consumerExmpl1Test() {
		irxf.consumerFindSystemProperties();
	}

	/* By Consumer accept two value and no return type */
	@Test
	public void byConsumerExmplTest() {
		irxf.byConsumerExmpl();
	}
}
