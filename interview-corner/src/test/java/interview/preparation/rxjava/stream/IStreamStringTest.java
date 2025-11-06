package interview.preparation.rxjava.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IStreamStringTest {

    private IStreamString iss;
    private static final Set<String> STOPWORDS = Set.of(
        "a", "an", "the", "and", "or", "but", "is", "are", "was", "were",
        "in", "on", "at", "of", "to", "for", "from", "by", "with", "this",
        "that", "it", "as", "be", "has", "have", "had", "not"
    );

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
    );

    @Before
    public void init()
    {
        iss = new StreamStringImpl();
    }

    /* * Category 1: Character Frequency & Counting (1 – 15)**/
    /** 1.	Count frequency of each character in a string*/
    @Test
    public void countFrequency()
    {
        Map<Character, Long> map =iss.countFrequency("abhimanyu");
        Assert.assertEquals(2,map.get('a').intValue());
        Assert.assertEquals(1,map.get('b').intValue());
        Assert.assertEquals(1,map.get('y').intValue());
    }
    /**2.	Count frequency of each word in a sentence*/
    @Test
    public void countStringFrequencyTest()
    {
        String input = "Java stream API in Java 8 makes stream processing easy easy easy";

        Map<String, Long> map = iss.countStringFrequency(input);
        Assert.assertEquals(2,map.get("Java").intValue());
        Assert.assertEquals(3,map.get("easy").intValue());
    }
    /**  3.	Find first non-repeating character*/
    @Test
    public void firstNonRepeatingCharTest()
    {
        String str ="rajkumarraj";
        Assert.assertEquals('k',iss.firstNonRepeatingChar(str).charValue());
    }
    @Test
    public void nThNonRepeatingCharTest()
    {
        String str ="rajkumarraj";
        Assert.assertEquals('m',iss.nThNonRepeatingChar(str,3).charValue());
    }
    /** 4.	Find first repeating character*/
    @Test
    public void firstRepeatingCharTest()
    {
        String str ="rajkumarraj";
        Assert.assertEquals('r',iss.firstRepeatingChar(str).charValue());
    }
    @Test
    public void nThRepeatingCharTest()
    {
        String str ="rajkumarraj";
        Assert.assertEquals('j',iss.nThRepeatingChar(str,3).charValue());
    }
    /**  7.	Sort characters by frequency ascending*/
    @Test
    public void sortByFrequencyAscTest()
    {
        Map<Character, Long> map = iss.sortByFrequencyAsc("rajkumarrajabhimanyukumar");
        System.out.println(map);
    }
    @Test
    public void sortByFrequencyAscAlfaTest()
    {
        Map<Character, Long> map = iss.sortByFrequencyAscAlfa("rajkumarrajabhimanyukumar");
        System.out.println(map);
    }
    /**   8.	Sort characters by frequency descending*/
    @Test
    public void sortByFrequencyDescTest()
    {
        Map<Character, Long> map = iss.sortByFrequencyDesc("rajkumarrajabhimanyukumar");
        System.out.println(map);
    }
    @Test
    public void sortByFrequencyDescAlfaTest()
    {
        Map<Character, Long> map = iss.sortByFrequencyDescAlfa("rajkumarrajabhimanyukumar");
        System.out.println(map);
    }
    /**  7.	Sort characters by frequency ascending*/
    @Test
    public void maxCharFrequencyTest()
    {
        char charFrequency = iss.maxCharFrequency("oooooorajkumarrajabhimanyukumar");
        Assert.assertEquals('a',charFrequency);
    }
    /**  8.	Sort characters by frequency descending*/
    @Test
    public void minCharFrequencyTest()
    {
        char charFrequency = iss.minCharFrequency("oooooorajkumarrajabhimanyukumar");
        Assert.assertEquals('b',charFrequency);
    }
    /**  11.	Check if two strings are anagrams*/
    @Test
    public void isAnagramsTest()
    {
        Assert.assertTrue(iss.isAnagrams("listen", "silent"));   // true
        Assert.assertTrue(iss.isAnagrams("triangle", "integral"));// true
        Assert.assertFalse(iss.isAnagrams("hello", "bello"));     // false
    }
    /**  12.	Check if two strings are isomorphic*/
    @Test
    public void isIsomorphicTest()
    {
        Assert.assertTrue(iss.isIsomorphic("egg", "add"));     // true
        Assert.assertFalse(iss.isIsomorphic("foo", "bar"));     // false
        Assert.assertTrue(iss.isIsomorphic("paper", "title")); // true
        Assert.assertFalse(iss.isIsomorphic("ab", "aa"));
    }
    /**  13.	Count vowels and consonants in a string*/
    @Test
    public void countVowelAndConsTest()
    {
        Map<Boolean,Long> map = iss.countVowelAndCons("abhimanyu");
        Assert.assertEquals(4,map.get(true).intValue());
        Assert.assertEquals(5,map.get(false).intValue());
    }
    /**  14.	Count uppercase, lowercase, digits, special characters*/
    @Test
    public void countDiffCharsTest()
    {
        Map<String, Long> map = iss.countDiffChars("HelloWorld123!@#");
        Assert.assertEquals(2,map.get("UPPER-CASE").intValue());
        Assert.assertEquals(8,map.get("LOWER-CASE").intValue());
        Assert.assertEquals(3,map.get("DIGIT").intValue());
        Assert.assertEquals(3,map.get("SPECIAL").intValue());
    }

    /** 15.	Find the most frequent word in a sentence*/
    @Test
    public void mostFrequentWordTest()
    {
        String sentence = "apple banana apple orange banana apple";
        Assert.assertEquals("apple",iss.mostFrequentWord(sentence));
    }


/* *Category 2: String Transformations (16 – 35)*/
    /**16.	Reverse entire string**/
    @Test
    public void reverseStrTest(){
        String str = "abhimanyu";
        Assert.assertEquals("uynamihba",iss.reverseStr(str));
    }
    /**17.	Reverse each word in a sentence**/
    @Test
    public void reverseWordsInSentence(){
        String str="I am wrong man";
        Assert.assertEquals("I ma gnorw nam",iss.reverseWordsInSentence(str));
    }
    /**18.	Reverse order of words in a sentence*/
    @Test
    public void reverseOrderOfWordsTest()
    {
       String str ="I am wrong man";
       Assert.assertEquals("man wrong am I",iss.reverseOrderOfWords(str));
    }

    /**19.	Capitalize first letter of each word*/
    @Test
    public void capFirstLetterOfWordsTest()
    {
        String str ="i am wrong man";
        Assert.assertEquals("I Am Wrong Man",iss.capFirstLetterOfWords(str));
    }

    /**20.	Convert camelCase to snake_case*/
    @Test
    public void convertCamelCaseToSnakeCaseTest()
    {
        String []strA = {"snakeCaseString","thisIsATest","alreadycamelcase"};
        String[] strB = {"snake_case_string","this_is_a_test","alreadycamelcase"};


        for(int i=0;i<strB.length;i++)
        {
            Assert.assertEquals(strB[i],iss.convertCamelCaseToSnakeCase(strA[i]));
        }

    }

    /**21.	Convert snake_case to camelCase*/
    @Test
    public void convertToSnakeCaseToCaeCaseTest(){
        String[] strA = {"snake_case_string","this_is_a_test","alreadySnakeCase"};
        String []strB = {"snakeCaseString","thisIsATest","alreadysnakecase"};

        for(int i=0;i<strB.length;i++)
        {
            Assert.assertEquals(strB[i],iss.convertToSnakeCaseToCaeCase(strA[i]));
        }
    }
    /**22.	Remove vowels from a string*/
    @Test
    public void removeVowels()
    {
        Assert.assertEquals("bhmny",iss.removeVowels("abhimanyu"));
    }

    /**23.	Remove all duplicate characters*/
    @Test
    public void removeDuplicate(){
        Assert.assertEquals("abhimnyu",iss.removeDuplicate("abhimanyu"));
    }

    /**25.	Replace multiple spaces with a single space**/
    @Test
    public void replaceMultiSpaceInSingle(){
        String str ="I am  a   good     boy";
        String rStr = "I am a good boy";
        Assert.assertEquals(rStr,iss.replaceMultiSpaceInSingle(str));
    }

    /**26.	Trim leading and trailing spaces without using trim()*/
    @Test
    public void removeLeadingTrailingWithoutTrimTest()
    {
        Assert.assertEquals("hello world",iss.removeLeadingTrailingWithoutTrim("   hello world   "));
    }

    /**27.	Remove digits from a string**/
    @Test
    public void removeDigitsTest(){
        Assert.assertEquals("abhimanyu",iss.removeDigits("abhi128man01yu007"));
    }

    /**28.	Keep only digits from a string**/
    @Test
    public void  onlyDigitsInStrTest()
    {
        Assert.assertEquals("12801007",iss.onlyDigitsInStr("abhi128man01yu007"));
    }

    /**29.	Remove special characters but keep alphanumerics*/
    @Test
    public void removeSpecialCharsTest()
    {
        Assert.assertEquals("Hello123World",iss.removeSpecialChars("He@#llo! 123$% World^&*"));
    }

    /**30.	Replace each character with its ASCII code (joined by space)**/
    @Test
    public void toAssciCharsString()
    {
        Assert.assertEquals("49 97 32 38 50 51 39",iss.toAssciCharsString("1a &23'"));
    }

    /**31.	Encode characters by shifting ASCII (Caesar cipher simple)*/
    @Test
    public void encodeCharByShiftingAscii()
    {
        Assert.assertEquals("Khoor, Zruog!",iss.encodeCharByShiftingAscii("Hello, World!",3));
    }

    /**32.	Convert string to character frequency encoded form (e.g. a2b1c3)*/
    @Test
    public void charFrequencyEncodedTest()
    {
        Assert.assertEquals("a2b1c3",iss.charFrequencyEncoded("abcacc"));
    }

    /**33.	Expand frequency encoded string (e.g. a2b1c3 → aabccc)*/
    @Test
    public void expandFrequencyEncoded()
    {
        Assert.assertEquals("aabccc",iss.expandFrequencyEncoded("a2b1c3"));
    }

    /**34.	Mask characters except last 4 (e.g. credit card mask)**/
    @Test
    public void maskExceptLast4Digit(){
        String str ="1029384756120987";
        String sStr="************0987";
        Assert.assertEquals(sStr,iss.maskExceptLast4Digit(str));
    }

    /**35.	Remove duplicate words in a sentence**/

    @Test
    public void removeDuplicateWords(){
        String str="hi abhi hi raj how are you are good";
        Assert.assertEquals("hi abhi raj how are you good",iss.removeDuplicateWords(str));
    }

/* *Category 3: Pattern Matching & Validation (36 – 50)*/
    /**36.	Check if a string is palindrome (case-insensitive)*/
    @Test
    public void isPalindromeCaseCaseInSenseTest()
    {
        Assert.assertTrue(iss.isPalindromeCaseCaseInSense("AaA"));
        Assert.assertTrue(iss.isPalindromeCaseCaseInSense("Madam"));
        Assert.assertTrue(iss.isPalindromeCaseCaseInSense("RaceCar"));
        Assert.assertTrue(iss.isPalindromeCaseCaseInSense("Step on no pets"));
    }

    @Test
    public void  isPalindromeCaseCaseInSenseXTest()
    {
        Assert.assertTrue(iss.isPalindromeCaseCaseInSenseX("AaA"));
        Assert.assertTrue(iss.isPalindromeCaseCaseInSenseX("Madam"));
        Assert.assertTrue(iss.isPalindromeCaseCaseInSenseX("RaceCar"));
        Assert.assertTrue(iss.isPalindromeCaseCaseInSenseX("Step on no pets"));
    }
    @Test
    public void isPalindromeCaseCaseSenseTest()
    {
        Assert.assertTrue(iss.isPalindromeCaseCaseSense("AaA"));
        Assert.assertFalse(iss.isPalindromeCaseCaseSense("Madam"));
        Assert.assertTrue(iss.isPalindromeCaseCaseSense("RaCeCaR"));
        Assert.assertTrue(iss.isPalindromeCaseCaseSense("Step on no petS"));
    }

    /**37.	Check if a string is pangram**/
    @Test
    public void isPangramTest()
    {
        String str = "The quick brown fox jumps over the lazy dog";
        Assert.assertTrue(iss.isPangram(str));
    }

    /**38.	Check if string contains only digits**/
    @Test
    public void strContainsOnlyDigitsTest()
    {
        Assert.assertTrue(iss.strContainsOnlyDigits("034347840398403"));
        Assert.assertFalse(iss.strContainsOnlyDigits("034347840x98403"));
    }

    /**39.	Check if string contains only alphabets**/
    @Test
    public void containOnlyAlphabetsTest()
    {
        Assert.assertTrue(iss.containOnlyAlphabets("abhimanyu"));
        Assert.assertFalse(iss.containOnlyAlphabets("abhim7anyu"));
    }

    /**40.	Check if string is valid email (basic regex)**/
    @Test
    public void checkValidEmailTest()
    {
        Assert.assertTrue(iss.checkValidEmail("abhimanyu.kumar@gmail.com"));
        Assert.assertTrue(iss.checkValidEmail("_kumar@gmail.com"));
        Assert.assertFalse(iss.checkValidEmail("kumar@gmail%.com"));
    }

    /**41.	Check if string is valid URL (basic regex)*/
    public void checkValidUrlTest()
    {

    }

    /**42.	Check if string is valid IPv4*/
    public void checkValidIP4Test()
    {

    }

    /**43.	Count occurrences of a substring in a string**/
    @Test
    public void countSubStrInStrTest()
    {
        String str ="This is a good boy, how he is , he is good";
        Assert.assertEquals(3,iss.countSubStrInStr(str,"is"));
    }

    /**44.	Find all indexes of a substring in a string**/
    @Test
    public void indexesOfSubStrInStrTest()
    {
        String str ="This is a good boy, how he is , he is good";
        int[]a = iss.indexesOfSubStrInStr(str,"is");
        System.out.println(Arrays.toString(a));
    }

    /**45.	Extract all numbers from a string**/
    @Test
    public void extractAllNoTest()
    {
        String str = "ak123umar007";
        int [] a = {1,2,3,0,0,7};
        int [] b = iss.extractAllNo(str);
        System.out.println(Arrays.toString(b));
        Assert.assertArrayEquals(a, b);
    }

    /**46.	Find all uppercase words in a sentence**/
    @Test
    public void findUpperCaseWordsTest()
    {
        String str="This is a GOOD Boy, how HE is , he is good";
        List<String> stringList = iss.findUpperCaseWords(str);
        Assert.assertEquals("GOOD", stringList.getFirst());
        Assert.assertEquals("HE", stringList.getLast());
    }

    /**47.	Check if string starts with a vowel using streams**/
    @Test
    public void checkStrStartWithVowelTest()
    {
        String str ="This is a good boy, how are u";
        List<String> list = iss.checkStrStartWithVowel(str);
        Assert.assertEquals("is",list.getFirst());
        Assert.assertEquals("u",list.getLast());
    }

    /**48.	Check if string contains all unique characters**/
    @Test
    public void checkContainsAllUniqueCharTest()
    {
        Assert.assertTrue(iss.checkContainsAllUniqueChar("abcdef1?.-="));
        Assert.assertFalse(iss.checkContainsAllUniqueChar("ab.cdef1?.-="));
    }

    /**49.	Check if two strings are rotations of each other**/
    @Test
    public void checkStrRotationsEachOthersTest()
    {
        Assert.assertTrue(iss.checkStrRotationsEachOthers("abhimanyu","bhimanyua"));
    }

    /**50.	Check if string can be rearranged to form a palindrome**/
    @Test
    public void canArrangeToFormPalindromeTest()
    {
        Assert.assertTrue(iss.canArrangeToFormPalindrome("Mamad"));
        Assert.assertTrue(iss.canArrangeToFormPalindrome("A man a plan a Panama canal"));
        Assert.assertFalse(iss.canArrangeToFormPalindrome("A man a plan a Panama canal "));
    }
    /**    Category 5: Advanced Problems (71 – 90)*/
    /**71.	Longest substring without repeating characters (using stream style)**/
    @Test
    public void longestUniqueSubStrTest()
    {
        String str ="abhimanyu";
        Assert.assertEquals("bhimanyu",iss.longestUniqueSubStr(str));
    }

    /**72.	Longest substring with K distinct characters**/
    @Test
    public void longestUniqueSubStrKDistCharTest(){
        String str ="aabcbaaca";
        Assert.assertEquals("aaca",iss.longestUniqueSubStrKDistChar(str,2));
    }

    /**73.	Smallest substring containing all unique characters**/
    @Test
    public void uniqueCharSmallestSubStrTest()
    {
      Assert.assertEquals("zxy",iss.uniqueCharSmallestSubStr("zzxyzzxyx"));
      Assert.assertEquals("dbca",iss.uniqueCharSmallestSubStr("aabcbcdbca"));
      Assert.assertEquals("ab",iss.uniqueCharSmallestSubStr("aaab"));
    }

    /**74.	All permutations of a string (stream-based recursion)**/
    @Test
    public void permutationTest()
    {
        List<String> list = List.of("abc", "acb", "bac", "bca", "cab", "cba");
        List<String> rList = iss.permutation("abc");
        Assert.assertEquals(list,rList);
    }

    /**75.	All combinations of characters of a string**/
    @Test
    public void combinationTest()
    {
        List<String> list = List.of("a","b","c","ab","bc","abc");
        List<String> rList = iss.combination("abc");
        Assert.assertEquals(list,rList);
    }
    @Test
    public void test()
    {
        String str ="abc";
        for(int i=0;i<str.length();i++) {
            System.out.println(str.substring(0, i));
            System.out.println(str.substring(i+1));
        }
    }

    /**76.	Find common characters between two strings (intersection)**/
    @Test
    public void commonCharTest()
    {
        String s1 = "apple";
        String s2 = "grape";
        Set<Character> set =Set.of('a','p','e');
        Set<Character> rSet = iss.commonChar(s1,s2);
        Assert.assertEquals(set,rSet);
    }

    /**77.	Find characters present in one string but not the other (difference)**/
    @Test
    public void differenceTest()
    {
        String s1 = "apple";
        String s2 = "grape";
        Set<Character> set =Set.of('l','g','r');
        Set<Character> rSet = iss.difference(s1,s2);
        Assert.assertEquals(set,rSet);
    }

    /**78.	Merge two strings alternately**/
    @Test
    public void mergeStringsAlternatelyTest()
    {
        String s1 = "abc";
        String s2 = "pqrstu";
        System.out.println(iss.mergeStringsAlternately(s1,s2));
        Assert.assertEquals("apbqcrstu",iss.mergeStringsAlternately(s1,s2));
    }
    /**79.	Shuffle characters randomly using streams**/
    @Test
    public void shuffleCharsRandomlyTest()
    {
        String str="abhimanyu";
        String rStr = iss.shuffleCharsRandomly(str);
        Assert.assertEquals(str.chars().sorted().mapToObj(c->(char)c).map(String::valueOf).collect(Collectors.joining()),
            rStr.chars().sorted().mapToObj(c->(char)c).map(String::valueOf).collect(Collectors.joining()));
    }

    /**80.	Count number of palindromic substrings*/
    @Test
    public void countPalindromicSubStrTet()
    {
        String str ="abba";
        Assert.assertEquals(6,iss.countPalindromicSubStr(str));
    }

    /**81.	Count number of substrings with unique characters**/
    @Test
    public void uniqueCharSubStrCountTest()
    {
        Assert.assertEquals(5,iss.uniqueCharSubStrCount("aba"));
        Assert.assertEquals(6,iss.uniqueCharSubStrCount("abc"));
    }

    /**82.	Find all substrings of a string using IntStream**/
    @Test
    public void allSubStrTest()
    {
        List<String> list = List.of("a","b","c","ab","bc","abc");
        List<String> rList = iss.allSubStr("abc");
        Assert.assertEquals(list,rList);
    }

    /**83.	Generate all prefixes of a string**/
    @Test
    public void allPrefixesTest()
    {
        List<String> list = List.of("a", "ab", "abc", "abcd");
        Assert.assertEquals(list,iss.allPrefixes("abcd"));
    }

    /**84.	Generate all suffixes of a string**/
    @Test
    public void allSuffixesTest()
    {
        List<String> list = List.of("abcd", "bcd", "cd", "d","");
        Assert.assertEquals(list,iss.allSuffixes("abcd"));
    }

    /**85.	Check if string A is subsequence of string B**/
    @Test
    public void checkSubsequenceTest()
    {
        Assert.assertTrue(iss.checkSubsequence("abc","aebdc"));
    }

    /**86.	Check if two strings have any common substring**/
    @Test
    public void anyCommonSubStrTest(){
        String s1 = "hello";
        String s2 = "world";
        Assert.assertTrue(iss.anyCommonSubStr(s1,s2));
    }
    /**87.	Longest common prefix of list of strings**/
    @Test
    public void longestCommonPrefixTest()
    {
        List<String> list = Arrays.asList("flower", "flow", "flight");
        Assert.assertEquals("fl",iss.longestCommonPrefix(list));
    }
    @Test
    public void longestCommonPrefixXTest()
    {
        List<String> list = Arrays.asList("flower", "flow", "flight");
        Assert.assertEquals("fl",iss.longestCommonPrefixX(list));
    }
    @Test
    public void  longestCommonSubStringTest()
    {
        List<String> list = Arrays.asList("ababc", "babca", "abcba");
        Assert.assertEquals("abc",iss.longestCommonSubString(list));
    }

    /**88.	Longest common suffix of list of strings**/
    @Test
    public void longestCommonSuffixTest()
    {
        List<String> list = Arrays.asList("walking", "barking", "parking");
        Assert.assertEquals("king",iss.longestCommonSuffix(list));
    }

    /**89.	Check if string has balanced parentheses/brackets**/
    @Test
    public void checkBalancedBracketsTest()
    {
       String str ="{[(])}";
       Assert.assertFalse(iss.checkBalancedBrackets(str));
       Assert.assertFalse(iss.checkBalancedBrackets("(()()))"));
       Assert.assertTrue(iss.checkBalancedBrackets("a+(b*c)-(d/e)"));
       Assert.assertTrue(iss.checkBalancedBrackets("{[()]}"));
    }

    /**90.	Find unmatched brackets using stack + stream hybrid**/
    @Test
    public void findUnmatchedBracketsTest()
    {
        Assert.assertEquals(')',iss.findUnmatchedBrackets("(()()))").charValue());
        Assert.assertEquals(']',iss.findUnmatchedBrackets("{[(])}").charValue());
    }

    /* *    Category 6: File/Text Stream Processing (91 – 100)**/
    /**91.	Read lines from file and count total words using streams**/
    @Test
    public void totalNoOfWordsTest() throws IOException{
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/text.txt");
        long count = iss.totalNoOfWords(path);
        System.out.println(count);
        Assert.assertEquals(184,count);
    }

    /**92.	Find most frequent word in file**/
    @Test
    public void mostFrequentWordInFileTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/text.txt");
        String str=iss.mostFrequentWordInFile(path);
        System.out.println(str);
        Assert.assertEquals("the",iss.mostFrequentWordInFile(path));
    }

    /**93.	Remove stopwords from text using streams**/
    @Test
    public void removeStopWordsTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/text.txt");

        String str = iss.removeStopWords(STOPWORDS,path);
        System.out.println(str);
    }
    /**94.	Extract all unique email IDs from text file**/
    @Test
    public void extractUniqueEmailsIdTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/emails.txt");
        Set<String> emails = iss.extractUniqueEmailsId(EMAIL_PATTERN,path);
        System.out.println(emails);
        Assert.assertEquals(4,emails.size());
    }

    /**95.	Count number of sentences in a text (split by .?!)**/
    @Test
    public void countNoOfSentenceTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/text.txt");
        long sentences = iss.countNoOfSentence(path);
        System.out.println(sentences);
        Assert.assertEquals(11,sentences);
    }

    /**96.	Tokenize and sort all words alphabetically from text file**/
    @Test
    public void tokenizeSortAlphaTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/emails.txt");
        Set<String> sets = iss.tokenizeSortAlpha(path);
        System.out.println(sets.toString());
    }

    /**97.	Find longest line in a file**/
    @Test
    public void findLongestLineTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/text.txt");
        String longestSen = iss.findLongestLine(path);
        System.out.println(longestSen);
    }

    /**98.	Find all palindromic words in a file**/
    @Test
    public void allPalindromicWordsTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/palindrome.txt");
        Set<String>  sets = iss.allPalindromicWords(path);
        System.out.println(sets);
    }

    /**99.	Count number of occurrences of each character across multiple lines**/
    @Test
    public void groupCharsInFilesTest()
    {
        Path path = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/text.txt");
        Map<Character,Long> map = iss.groupCharsInFiles(path);
        System.out.println(map.toString());
    }

    /**100.	Merge contents of multiple strings/files and remove duplicates**/
    @Test
    public void removeDuplicateLinesFromFilesTest()
    {
        Path path1 = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/palindrome.txt");
        Path path2 = Paths.get("src//main/java/interview/preparation/rxjava/stream/files/palindrome1.txt");
        List<Path> list = List.of(path1,path2);
        Set<String> lines = iss.removeDuplicateLinesFromFiles(list);
        System.out.println(lines.toString());
    }
    @Test
    public void removeDuplicateWordsFromListStrTest()
    {
        List<String> inputs = List.of(
            "Java Streams are powerful and elegant",
            "Elegant solutions come from powerful ideas",
            "Streams simplify complex code"
        );
        Set<String> sets = iss.removeDuplicateWordsFromListStr(inputs);
        System.out.println(sets);
    }
}
