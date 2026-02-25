package interview.preparation.company.interviews.question.product.base;

import java.util.List;

public interface IProduct {

    /**Find all the Unique numbers from the List of string List<String> strArr = Arrays.asList("1,2,3", "3,4,5", "6,abc,7", "8,9,10", "10,2,4");
     Output:  [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]*/
    List<Integer> uniqueNos(List<String> list);

    /**Given an integer n,  the task is to print,
     FizzBuzzRizz if divisible by 3, 5 and 7
     "FizzBuzz" if i is divisible by 3 and 5,
     "FizzRIzz" if divisible by 3 and 7,
     BuzzRizz f divisible by 5 and 7
     "Fizz" if i is divisible by 3,
     "Buzz" if i is divisible by 5
     "Rizz" if i isdivisible by 7
     "n" as a string, if none of the conditions are true**/
     String fizzBuzzRizz(int n);

     /** FizzBuzzRizzKizz if divisible by 3, 5, 7 and 9*/
    String fizzBuzzRizzKizz(int n);
    String fizzBuzzRizzKizzX(int n);
}
