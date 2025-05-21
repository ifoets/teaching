package com.udemy.design.analysis.functional;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IFunctionlAnalysisTest {

	IFunctionlAnalysis ifa = null;

	@Before
	public void init() {
		ifa = new FunctionlAnalysisImpl();
	}

	/* pass by behaviour of/within behaviour */
	@Test
	public void executeLambdaWithinLambdaTest() {
		System.out.println(ifa.executeLambdaWithinLambda("abhimanyu", "kumar"));
	}

	/* return behaviour of/within behaviour **/
	@Test
	public void returnLambdaWithinLambdaTest() {
		System.out.println(ifa.returnLambdaWithinLambda("abhimanyu", "kumar"));
	}

	/* Calculator Service, a bit depth */
	// (a+b)*(b-c)
	@Test
	public void calculateExmpl1Test() {
		System.out.println("(10+5)*(5-2)=" + ifa.calculateExmpl1(10, 5, 2));
	}

	/* (a*b)-(b/c) */
	@Test
	public void calculateExmpl2Test() {
		System.out.println("(10*5)-(5/2)=" + ifa.calculateExmpl2(10, 5, 2));
	}

	/* (a+b)-(b-c)+(c*a) */
	@Test
	public void calculateExmpl3Test() {
		System.out.println("(10+5)-(5-3)+(3*10)=" + ifa.calculateExmpl3(10, 5, 3));
	}

	/* Functional interface, Supplier of Supplier */
	@Test
	public void supplierOfSupplierExmplTest() {
		ifa.supplierOfSupplierExmpl("abhimanyu kumar");
	}

	/* Functional interface, Consumer of Consumer */
	@Test
	public void consumerOfConsumerTest() {
		List<String> sList = new ArrayList<>();
		sList.add("Abhimanyu");
		sList.add("Kumar");
		ifa.consumerOfConsumer(sList);
	}
}
