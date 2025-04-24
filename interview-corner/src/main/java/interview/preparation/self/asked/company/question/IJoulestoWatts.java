package interview.preparation.self.asked.company.question;

public interface IJoulestoWatts {
    /* a string contain a, b and ? replace ? by a or b such that  there is no
    3 consecutive char are same
    "a?bb", "a?b?aa", "aa??aa", ???a??b??? -> "aabb", "aabbaa",  "aabbaa", //???a??b???
     */

     String transform(String str);

    String transformStr(char[] chars, int N, int count);

    String convert(String str);

}
