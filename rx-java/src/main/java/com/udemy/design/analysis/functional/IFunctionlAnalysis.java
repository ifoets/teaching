package com.udemy.design.analysis.functional;

import java.util.List;

import com.udemy.design.analysis.functional.finterface.IInnerService;
import com.udemy.design.analysis.functional.finterface.IOuterService;

public interface IFunctionlAnalysis {

	/* pass by behaviour of/within behaviour */
	public String passByLambdaWithinLambda(String str1, String str2);

	public String executeLambdaWithinLambda(String str1, String str2);

	/* return behaviour of/within behaviour **/
	public IOuterService<IInnerService<String, String>, String> impLambdaWithinLambda(String str1, String str2);

	public String returnLambdaWithinLambda(String str1, String str2);

	/* Calculator Service, a bit depth */
	/* (a+b)*(b-c) */
	public double calculateExmpl1(int a, int b, int c);

	/* (a*b)-(b/c) */
	public double calculateExmpl2(int a, int b, int c);

	/* (a+b)-(b-c)+(c*a) */
	public double calculateExmpl3(int a, int b, int c);

	/* Functional interface, Supplier of Supplier */
	public void supplierOfSupplierExmpl(String str);

	/* Functional interface, Consumer of Consumer */
	public void consumerOfConsumer(List<String> sList);
}
