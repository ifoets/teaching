package com.udemy.design.analysis.functional;

import java.util.List;
import java.util.function.Consumer;

import com.udemy.design.analysis.functional.finterface.ICalculatorServie;
import com.udemy.design.analysis.functional.finterface.IInnerService;
import com.udemy.design.analysis.functional.finterface.IOuterService;

import io.reactivex.rxjava3.functions.Supplier;

public class FunctionlAnalysisImpl implements IFunctionlAnalysis {

	/* pass by behaviour of/within behaviour */
	@Override
	public String passByLambdaWithinLambda(String str1, String str2) {

		IOuterService<String, IInnerService<String, String>> ios = (str) ->
			{
				return (instr) ->
					{
						return str.toUpperCase() + " " + instr.toUpperCase();
					};

			};

		return ios.apply(str1)
		        .execute(str2);
	}

	@Override
	public String executeLambdaWithinLambda(String str1, String str2) {
		return passByLambdaWithinLambda(str1, str2);
	}

	@Override
	public IOuterService<IInnerService<String, String>, String> impLambdaWithinLambda(String str1, String str2) {

		IOuterService<IInnerService<String, String>, String> ios = (iis) ->
			{
				String inner = iis.execute(str1);
				return inner + " " + str2.toUpperCase();

			};

		return ios;
	}

	@Override
	public String returnLambdaWithinLambda(String str1, String str2) {

		return impLambdaWithinLambda(str1, str2).apply(e -> e.toUpperCase());
	}

	/* Calculator Service, a bit depth */
	@Override
	// (a+b)*(b-c)
	public double calculateExmpl1(int a, int b, int c) {
		ICalculatorServie<ICalculatorServie<Integer, Integer>, Integer> opr = (opr1, opr2) ->
			{
				return opr1.operation(a, b) * opr2.operation(b, c);
			};

		return opr.operation((x, y) -> x + y, (x, y) -> x - y);

	}

	/* (a*b)-(b/c) */
	@Override
	public double calculateExmpl2(int a, int b, int c) {
		ICalculatorServie<Integer, ICalculatorServie<Integer, Integer>> opr1 = (x, y) ->
			{
				return (t1, t2) -> (x * y) - (t1 / t2);

			};
		return opr1.operation(a, b)
		        .operation(b, c);
	}

	/* (a+b)-(b-c)+(c*a) */
	public int mathCalculate(ICalculatorServie<Integer, Integer> cal, int x, int y) {
		return cal.operation(x, y);
	}

	public double calculateExmpl3(int a, int b, int c) {

		return mathCalculate((x, y) -> x + y, mathCalculate((x, y) -> x - y, mathCalculate((x, y) -> x + y, a, b),
		        mathCalculate((x, y) -> x - y, b, c)), mathCalculate((x, y) -> x * y, c, a));
	}

	/* Functional interface, Supplier of Supplier */
	@Override
	public void supplierOfSupplierExmpl(String str) {

		Supplier<String> inSup = str::toUpperCase;
		Supplier<Supplier<String>> outSup = () -> inSup;
		try {
			System.out.println(outSup.get()
			        .get());
		} catch (Throwable e) {
		}
	}

	/* Functional interface, Consumer of Consumer */
	// unable to use properly here
	@Override
	public void consumerOfConsumer(List<String> sList) {

		Consumer<Consumer<Consumer<String>>> ccon = (doCon) ->
			{
				doCon.andThen((logCon) ->
					{
						logCon.andThen((mailCon) -> System.out.println("mail writting" + mailCon));
					});
			};

		Consumer<Consumer<String>> dbLogCon = (s) ->
			{
				s.andThen((t) -> System.out.println("I M writting to log :" + t));
			};

		Consumer<String> dbCon = (s) -> System.out.println("I M writting to db :" + s);
		dbLogCon.accept(dbCon);
		ccon.accept(dbLogCon);
		sList.forEach(dbCon);
	}
}
