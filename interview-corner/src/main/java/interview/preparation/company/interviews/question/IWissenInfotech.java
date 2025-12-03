package interview.preparation.company.interviews.question;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import com.design.analysis.company.preparation.model.LNode;

/** This class contain personal interview question faced in @Wissen Infotech at @7 year of experience**/
/**
 * @author Guruji
 */
public interface IWissenInfotech {

    /**
     * 1. Add values in map so it map print sorted order based on values
     */

    public Map<String, String> getMapOrderByValues(Map<String, String> map);

    public Map<String, String> getMapOrderByValuesX(Map<String, String> map);

    public Map<String, String> getMapOrderByValuesY(Map<String, String> map);

    public Map<String, String> getMapOrderByValuesThenByKey(Map<String, String> map);

    public Map<String, String> getMapOrderByValuesThenByKeyX(Map<String, String> map);

    public Map<String, String> getMapOrderByKey(Map<String, String> map);

    /**
     * 2. Create biggest number form array element using string addition
     */

    public String getBiggestNumber(int a[]);

    public String getBiggestNumberX(int a[]);

    /**
     * 3. sum array with performance heaving n thread using Executer framework
     */
    public int getSum(Integer a[], int n) throws InterruptedException, ExecutionException;

    public int getSumAX(Integer a[], int n) throws InterruptedException, ExecutionException;

    /**
     * sum array with performance heaving n thread using ForkandJJoin
     */
    public int getSumX(Integer a[], int n) throws InterruptedException, ExecutionException;

    public int getSumY(Integer a[], int n) throws InterruptedException, ExecutionException;

    /**
     * 4 max or min number with performance heaving n thread using Executer
     */
    public int getMaxOrMin(Integer a[], int n, boolean maxOrMin) throws InterruptedException, ExecutionException;

    /**
     * max or min number with performance heaving n thread ForkandJJoin
     */
    public int getMaxOrMinX(Integer a[], int n, boolean maxOrMin) throws InterruptedException, ExecutionException;

    /**
     * 5 find intersection node, node value may be duplicate
     */
    public LNode getInterSectionNode(LNode x, LNode y);

    /**
     * 6 find start circular node
     */
    public LNode getCirculrPointNode(LNode x);

    // 2022 interview
    // chunk array of all possible size
    public void chunkArray(int ar[]);

    public List<int[]> splitArray(int ar[], int splitSize);

    public String commonCharacters(String a, String b);

    public void createTwoTread() throws InterruptedException;

    // 2023 interview question
    public List<int[]> splitArrayOfNSize(int a[], int ns);

    // Convert Snake Case string to Camel Case geeks_for_geeks” Output:
    // GeeksForGeeks
    public String snakeToCamel(String str);

    public String camelToSnake(String str);

    public Map<Integer, List<Character>> segerateChars(String str);

    public void putMap(Map<Integer, List<Character>> map, char ch, int key);

    // check a string is permutation of palindrome
    public boolean isPermutationOfPalindrome(String str);

    /**
     * group the string that are anagrams to each other
     */
    List<List<String>> groupAnagrams(List<String> strList);

    /**
     * for any positive natural number digits
     */
    List<Integer> allNDiditPalindrome(int n);

    /**
     * for only even number of digits only
     **/
    List<Integer> allNDiditPalindromeX(int n);

    List<Integer> allNDiditPalindromeY(int n);

    /**
     * for any positive natural number of digits
     */
    List<Integer> allNDiditPalindromeZ(int n);

    String minSlidingWindow(String s, String t);

    void oddPosIsGreaterOrEvenIsSmaller(int[] a);

    int posBeforeAfterSumEqual(int[] a);

    /**Round-1 Evaluating round*/
    /**
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     */
    int firstNonRepeatingCharIndex(String str);
    /**You are given N chocolates, and you need to distribute them among some children based on the following conditions:

    You can choose the number of children .
    Each child must receive at least 2 chocolates.
    No single child can receive all the chocolates.
    All chocolates must be distributed evenly (i.e., no remainders).
    Each child must receive whole chocolates (no fractional distribution).
    Your task is to determine whether it is possible to distribute the chocolates fairly under the given conditions.*/
    String distributeChocolates(int n);

    /** Find char count in string stream apis**/
     Map<Character,Long> findCharCount(String str);

     /* *Round -2**/
     /** group the angram words from list of String*/
     Map<String,List<String>> groupAngram(List<String> list);

     /**4 man, 1 take 1min, 2nd take 2 min, 3rd take 5 min and 4h take 10 min, they having a light, two can cross together a bridge with slower man speed, find the min time taken to cross all man in light*/
    /**design a data structure that holt the order(orderId, orderTime), searching will between start time and end time*. Option A: Balanced BST (TreeMap in Java, std::map in C++), Option B: Segment Tree / Interval Tree*/
     /** design db student, club and event, any student can join many club
      * q1, find all student with club name/ or no club joined
      * q2,**/
     /**distributeChocolates*/

     /* *Round 2 */
    /**merge the map*/
    TreeMap<Integer,Integer> mergeTreeMap(TreeMap<Integer,Integer> map1, TreeMap<Integer,Integer> map2);
    TreeMap<Integer,Integer> mergeListOfTreeMaps(List<Map<Integer,Integer>> mapList);

    /**sort string char based on frequency and same frequency should have maintained order as it is in string*/
    String sortOnFrequency(String str);
    /**sort string char based on frequency and then alphabetical order*/
    String sortOnFrequencyThenAlpha(String str);

}
