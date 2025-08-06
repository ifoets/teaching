package interview.preparation.company.interviews.question;

import java.util.List;

public interface IPayPal {

    /**print all the subsequence of the string in sorted order*/
    List<String> generateAllBinary(int []a, int n);

    List<String> sortedSubsequence(String s);

    List<String> sortedSubsequenceX(String s, char[] chars, int index);

    /*Container With Most Water*/
    int containerMaxWater(int[] c);
}
