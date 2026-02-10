package interview.preparation.company.interviews.question.product.base;

import interview.preparation.company.interviews.impl.product.base.model.Employee;
import interview.preparation.company.interviews.impl.product.base.model.Transaction;

import interview.preparation.company.interviews.model.BoardingPass;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IEdwardJones {

    /**
     * Given a numeric array, re arrange the elements to form the highest possible value.
     * input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
     * output should be: 998764543431
     */
    String arrangeHeigestValues(int[] a);

    /**
     Find sum of all digits of a number in Java 8?
     int i = 236839**/
    int sumOfAllDigitsOfANumber(int n);

    /**filter out those employees who have at least one address in Pune**/
    List<Employee> atleastOneAddressPune(List<Employee> list);

    /**1.Perform cube on list elements and filter numbers greater than 50 and sort in descending order.**/
    List<Integer> cubeGreaterThan(List<Integer> list, int K);

    /**find COMPLETED Transaction sum**/
    Map<String, BigDecimal> completedTransSun(List<Transaction> list);

    /**
     I/P-DELHI - CALCUTTA
     BLR-CHENNAI
     HYD-BLR
     CHENNAI-DELHI  ,
     output :  starting point and endpoint WHICH IS NOT REPEATING**/
    //@See EmpowerImpl.findInitailAndFinalDesitination
    //Map<String,String> findInitFinalDestination(List<BoardingPass> passes);

    /**String[] numbers = {"123","abc",null,"456"};**/
    List<String> filterOnlyNumber(String[] arr);

    /**group anagram strings**/
    List<List<String>> groupAnagrams(List<String> list);

    /**Write a program to print the pair of values equal to input2 using streams and lambda expressions
     input1 ={2,3,4,-3,7,9,14,10}
     input2 =11 **/
    Map<Integer,Integer> pairsVal(int[] a,int target);

    int getDaysOfYear(int month, int dayOfMonth, int year);
}
