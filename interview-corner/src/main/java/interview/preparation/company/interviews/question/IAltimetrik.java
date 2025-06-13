package interview.preparation.company.interviews.question;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

}
