package interview.preparation.company.interviews.impl.product.base;

import interview.preparation.company.interviews.impl.product.base.model.Employee;
import interview.preparation.company.interviews.impl.product.base.model.Transaction;

import interview.preparation.company.interviews.model.BoardingPass;
import interview.preparation.company.interviews.question.product.base.IEdwardJones;
import org.checkerframework.checker.units.qual.Temperature;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.stream.Stream;


public class EdwardJonesImpl implements IEdwardJones {
    /**
     * Given a numeric array, re arrange the elements to form the highest possible value.
     * input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
     * output should be: 998764543431
     */
    public String arrangeHeigestValues(int[] a){
        Integer[] arr= Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,(x,y)->
        {
            String s1=x+""+y;
            String s2=y+""+x;
            return s2.compareTo(s1);//ie in reverse order
        });
        if(arr[0]==0)return "0";
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(sb::append);
        return sb.toString();
    }

    /**
     Find sum of all digits of a number in Java 8?
     int i = 236839**/
    @Override
    public int sumOfAllDigitsOfANumber(int n){
        return String.valueOf(n).chars().mapToObj(c->c-48).mapToInt(Integer::intValue).sum();
    }

    /**filter out those employees who have at least one address in Pune**/
    @Override
    public List<Employee> atleastOneAddressPune(List<Employee> list){
        return list.stream().filter(e-> e.getAddresses().stream().anyMatch(a->a.getCity().equalsIgnoreCase("PUNE"))).toList();
    }

    /**1.Perform cube on list elements and filter numbers greater than 50 and sort in descending order.**/
    @Override
    public List<Integer> cubeGreaterThan(List<Integer> list, int K){
        return list.stream().map(i->i*i*i)
            .filter(x->x>K)
            .toList();
    }
    /**find COMPLETED Transaction sum**/
    @Override
    public Map<String,BigDecimal> completedTransSun(List<Transaction> list){
        return list.stream().filter(t-> Objects.equals(t.getStatus(), "COMPLETED"))
            .collect(Collectors.groupingBy(
                Transaction::getStatus,
                Collectors.reducing(
                    BigDecimal.ZERO,
                    Transaction::getAmount,
                    BigDecimal::add
                )
            ));
    }
    /**String[] numbers = {"123","abc",null,"456"};**/
    @Override
    public List<String> filterOnlyNumber(String[] arr){
        return Arrays.stream(arr).filter(Objects::nonNull)
                .filter(s-> !s.isEmpty())
            .filter(s->s.chars().mapToObj(c->(char)c).allMatch(c->c>='0'&&c<='9'))
            .toList();
    }

    /**group anagram strings**/
    @Override
    public List<List<String>> groupAnagrams(List<String> list){
        return list.stream()
            .collect(Collectors.groupingBy(s -> {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }))
            .values()
            .stream()
            .toList();
    }

    /**Write a program to print the pair of values equal to input2 using streams and lambda expressions
     input1 ={2,3,4,-3,7,9,14,10}
     input2 =11 **/
    @Override
    public Map<Integer,Integer> pairsVal(int[] a,int target){
        return IntStream.range(0,a.length)
            .boxed()
            .flatMap(i->IntStream.range(i,a.length)
                .filter(j->a[i]+a[j]==target)
                .mapToObj(j-> Map.entry(a[i],a[j]))
            )
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }

    @Override
    public int getDaysOfYear(int month, int dayOfMonth, int year){
        return LocalDate.of(year,month,dayOfMonth).getDayOfYear();
    }
}
