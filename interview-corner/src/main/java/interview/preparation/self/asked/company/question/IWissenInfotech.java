package interview.preparation.self.asked.company.question;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.design.analysis.company.preparation.model.LNode;

/** This class contain personal interview question faced in @Wissen Infotech at @7 year of experience**/
/**
 * @author Guruji
 */
public interface IWissenInfotech {

	/** 1. Add values in map so it map print sorted order based on values */

	public Map<String, String> getMapOrderByValues(Map<String, String> map);

	public Map<String, String> getMapOrderByValuesX(Map<String, String> map);

	public Map<String, String> getMapOrderByValuesY(Map<String, String> map);

	public Map<String, String> getMapOrderByValuesThenByKey(Map<String, String> map);

	public Map<String, String> getMapOrderByValuesThenByKeyX(Map<String, String> map);

	public Map<String, String> getMapOrderByKey(Map<String, String> map);

	/** 2. Create biggest number form array element using string addition */

	public String getBiggestNumber(int a[]);

	public String getBiggestNumberX(int a[]);

	/** 3. sum array with performance heaving n thread using Executer framework */
	public int getSum(Integer a[], int n) throws InterruptedException, ExecutionException;

	public int getSumAX(Integer a[], int n) throws InterruptedException, ExecutionException;

	/** sum array with performance heaving n thread using ForkandJJoin */
	public int getSumX(Integer a[], int n) throws InterruptedException, ExecutionException;

	public int getSumY(Integer a[], int n) throws InterruptedException, ExecutionException;

	/** 4 max or min number with performance heaving n thread using Executer */
	public int getMaxOrMin(Integer a[], int n, boolean maxOrMin) throws InterruptedException, ExecutionException;

	/** max or min number with performance heaving n thread ForkandJJoin */
	public int getMaxOrMinX(Integer a[], int n, boolean maxOrMin) throws InterruptedException, ExecutionException;

	/** 5 find intersection node, node value may be duplicate */
	public LNode getInterSectionNode(LNode x, LNode y);

	/** 6 find start circular node */
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

}
