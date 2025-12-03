package interview.preparation.company.interviews.question;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public interface IZemosoLabs {

    /**find unique char in string**/
    Map<Character,Long> uniqueChar(String str);

    /**collect all the arrangement of String**/
    void permutation(String str, int l, int r, List<String> list);
}
