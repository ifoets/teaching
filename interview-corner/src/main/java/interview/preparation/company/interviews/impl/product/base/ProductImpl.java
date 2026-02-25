package interview.preparation.company.interviews.impl.product.base;

import interview.preparation.company.interviews.question.product.base.IProduct;

import java.util.*;
import java.util.stream.IntStream;

public class ProductImpl implements IProduct {

    /**Find all the Unique numbers from the List of string List<String> strArr = Arrays.asList("1,2,3", "3,4,5", "6,abc,7,-2", "8,9,10", "10,2,4");
     Output:  [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]*/
    @Override
    public List<Integer> uniqueNos(List<String> list){
     return
            list.stream()
                .flatMap(s-> Arrays.stream(s.split(",")).map(String::valueOf))
                .filter(t->t.matches("-?\\d+")) //allow negative too (use "\\d+" if only positive) ? is for optional
                .map(Integer::valueOf)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }
    /**Given an integer n,  the task is to print,
     FizzBuzzRizz if divisible by 3, 5 and 7
     "FizzBuzz" if i is divisible by 3 and 5,
     "FizzRIzz" if divisible by 3 and 7,
     BuzzRizz f divisible by 5 and 7
     "Fizz" if i is divisible by 3,
     "Buzz" if i is divisible by 5
     "Rizz" if i isdivisible by 7
     "n" as a string, if none of the conditions are true**/
    @Override
    public String fizzBuzzRizz(int n){
        Map<Integer, String> map = new TreeMap<>(Map.of(3, "Fizz", 5, "Buzz", 7, "Rizz"));
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer,String> entry: map.entrySet())
        {
            if(n%entry.getKey()==0)
                sb.append(entry.getValue());
        }
        return !sb.isEmpty() ?sb.toString():String.valueOf(n);
    }

    /** FizzBuzzRizzKizz if divisible by 3, 5, 7 and 11*/
    @Override
    public String fizzBuzzRizzKizz(int n){
        Map<Integer, String> map = new TreeMap<>(Map.of(3, "Fizz", 5, "Buzz", 7, "Rizz", 11,"Kizz"));
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer,String> entry: map.entrySet())
        {
            if(n%entry.getKey()==0)
                sb.append(entry.getValue());
        }
        return !sb.isEmpty() ?sb.toString():String.valueOf(n);
    }
    @Override
    public String fizzBuzzRizzKizzX(int n){
        StringBuilder sb = new StringBuilder();
        if (n % 3 == 0) sb.append("Fizz");
        if (n % 5 == 0) sb.append("Buzz");
        if (n % 7 == 0) sb.append("Rizz");
        if (n % 11 == 0) sb.append("Kizz");

        return sb.isEmpty() ? String.valueOf(n) : sb.toString();
    }
}
