package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.model.Employee;
import interview.preparation.company.interviews.question.IMphysis;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MphysisImpl implements IMphysis {

	/*
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock. Input: prices
	 * = [7,1,5,3,6,4] Output: 5
	 */
	// OC(n)
    @Override
	public int maxProfitSingleStockBuyShell(int a[]) {

		int N = a.length;
		int min_price = Integer.MAX_VALUE;
		int max_profit = 0;

		for (int i = 0; i < N; i++) {
			if (min_price > a[i]) {
				min_price = a[i];
			} else {
				max_profit = Math.max(max_profit, a[i] - min_price);
			}
		}
		return max_profit;
	}

	/* fid the 2nd max value in array by single iteration */
    @Override
	public int secondMaxSingleIteration(int a[]) {
		int N = a.length;
		int fmx;
		int smx;
		fmx = smx = 0;
		for (int i = 0; i < N; i++) {
			if (a[i] > smx) {
				if (a[i] > fmx) {
					int temp = fmx;
					fmx = a[i];
					smx = temp;
				} else {
					smx = a[i];
				}
			}
		}
		return smx;
	}
	/*("Australia");"India");("Africa");("Indonesia");("Malaysia"); output ={"AustraliaAA","AfricaAA"};*/
	@Override
	public List<String> concatFilter(List<String> list){
		return list.stream().filter(e -> e.startsWith("A"))
				.map(e-> e + (String.valueOf(e.charAt(0))).repeat(2))
				.toList();
	}

	/*remove duplicate char from string*/
	public String removeDuplicateChar(String str){
        StringBuilder sb = new StringBuilder();
            List<Character> charList = str.chars().mapToObj( e->(char)e).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
                keySet()
				.stream()
                .toList();
            charList.forEach(sb::append);
            return sb.toString();
	}

	/*find highest salary employee in each of department*/
	public Map<String,Optional<Employee>> maxEarningOnDeprt(List<Employee> employeeList){
          return  employeeList.stream().collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
	}

	/*run two thread and print hi hello*/
	public void useTwoThread(){
		Runnable r1 = ()->System.out.print("Hi !!");
		Runnable r2 = ()->System.out.print("Hello !!");
		r1.run();
		r2.run();
	}
}
