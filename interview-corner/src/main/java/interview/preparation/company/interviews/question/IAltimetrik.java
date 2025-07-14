package interview.preparation.company.interviews.question;

import interview.preparation.company.interviews.model.Student;

import java.util.*;
import java.util.function.Predicate;

public interface IAltimetrik {

	 int minimumCandiesPerHour(int []c);

     int minimumCandiesPerHourX(int []c);

	 boolean checkDuplicateCountVal(int []a);

	 int get2ndMaxNo(List<List<Integer>> ll);

	 List<Integer> findVowlesIndex(String str);

     void rotateArrayFromRight(int []a,int x);

     int searchInRotatedArray(int []a, int x);

     int pivotInRotatedArray(int []a, int l, int r);

     String maxPalindromeSubStr(String str);

    List<Integer> rotateList(List<Integer> list, int k);

    List<Integer> rotateListX(List<Integer> list, int k);

    void rotateListY(List<Integer> list, int k);

    /**rotate map position by k to right**/
    Map<Integer,Integer> rotateMap(LinkedHashMap<Integer, Integer> map, int k);

    Map<Integer,Integer> rotateMapX(Map<Integer, Integer> map, int k);

    /**O(n2)*/
    int countUniqueSubstring(String str);

    /**O(n)*/
    int countUniqueSubstringX(String str);

    void allUniqueSubstring(List<String> list, String str);

    Map<String, Integer> getSumOfAgeSameNameStudent(List<Student> list);

    Map<String, Optional<Student>> getMaxAgeStudent(List<Student> list);

    Map<String, Optional<Student>> getMinAgeStudent(List<Student> list);

    List<List<Integer>> segregateOddEvenPredicate(List<Integer> list);

    <T> List<T> filterOddEven(List<T> list, Predicate<T> predicate);

    Map<Boolean, List<Integer>> segregateOddEvenPredicateX(List<Integer> list);

}
