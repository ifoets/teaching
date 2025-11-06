package interview.preparation.rxjava.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public interface IStreamString {

/* * Category 1: Character Frequency & Counting (1 – 15)**/
    /** 1.	Count frequency of each character in a string*/
    Map<Character, Long> countFrequency(String str);

    /**2.	Count frequency of each word in a sentence*/
    Map<String,Long> countStringFrequency(String sentence);

    /**  3.	Find first non-repeating character*/
    Character firstNonRepeatingChar(String string);
    Character nThNonRepeatingChar(String string, int n);

    /** 4.	Find first repeating character*/
    Character firstRepeatingChar(String str);
    Character nThRepeatingChar(String str, int n);

    /**  5.	Find all repeating characters*/
    Map<Character, Long> allRepeatingChar(String str);

    /**6.	Find all non-repeating characters*/
    Map<Character, Long> allNonRepeatingChar(String str);

    /**  7.	Sort characters by frequency ascending*/
    Map<Character, Long> sortByFrequencyAsc(String str);
    Map<Character, Long> sortByFrequencyAscAlfa(String str);

    /**   8.	Sort characters by frequency descending*/
    Map<Character, Long> sortByFrequencyDesc(String str);
    Map<Character, Long> sortByFrequencyDescAlfa(String str);

    /**  9.	Find character with max frequency*/
    Character maxCharFrequency(String str);
    /** 10.	Find character with min frequency*/
    Character minCharFrequency(String str);

    /**  11.	Check if two strings are anagrams*/
    boolean isAnagrams(String str1, String str2);

    /**  12.	Check if two strings are isomorphic*/
    boolean isIsomorphic(String str1, String str2);

    /**  13.	Count vowels and consonants in a string*/
    Map<Boolean,Long> countVowelAndCons(String str);

    /**  14.	Count uppercase, lowercase, digits, special characters*/
    Map<String, Long> countDiffChars(String str);

    /** 15.	Find the most frequent word in a sentence*/
    String mostFrequentWord(String str);

/* *Category 2: String Transformations (16 – 35)*/
    /**16.	Reverse entire string**/
    String reverseStr(String str);

    /**17.	Reverse each word in a sentence**/
    String reverseWordsInSentence(String str);

    /**18.	Reverse order of words in a sentence*/
    String reverseOrderOfWords(String str);

    /**19.	Capitalize first letter of each word*/
    String capFirstLetterOfWords(String str);

    /**20.	Convert camelCase to snake_case*/
    String convertCamelCaseToSnakeCase(String str);

    /**21.	Convert snake_case to camelCase*/
    String convertToSnakeCaseToCaeCase(String str);

    /**22.	Remove vowels from a string*/
    String removeVowels(String str);

    /**23.	Remove all duplicate characters*/
    /**24.	Keep only unique characters in original order*/
    String removeDuplicate(String str);

    /**25.	Replace multiple spaces with a single space**/
    String replaceMultiSpaceInSingle(String str);

    /**26.	Trim leading and trailing spaces without using trim()*/
    String removeLeadingTrailingWithoutTrim(String str);

    /**27.	Remove digits from a string**/
    String removeDigits(String str);

    /**28.	Keep only digits from a string**/
    String onlyDigitsInStr(String str);

    /**29.	Remove special characters but keep alphanumerics*/
    String removeSpecialChars(String str);

    /**30.	Replace each character with its ASCII code (joined by space)**/
    String toAssciCharsString(String str);

    /**31.	Encode characters by shifting ASCII (Caesar cipher simple)*/
    String encodeCharByShiftingAscii(String str, int shift);

    /**32.	Convert string to character frequency encoded form (e.g. a2b1c3)*/
    String charFrequencyEncoded(String str);

    /**33.	Expand frequency encoded string (e.g. a2b1c3 → aabccc)*/
    String expandFrequencyEncoded(String str);

    /**34.	Mask characters except last 4 (e.g. credit card mask)**/
    String maskExceptLast4Digit(String str);

    /**35.	Remove duplicate words in a sentence**/
    String  removeDuplicateWords(String str);

/* *Category 3: Pattern Matching & Validation (36 – 50)*/
    /**36.	Check if a string is palindrome (case-insensitive)*/
    boolean isPalindromeCaseCaseInSense(String str);
    boolean isPalindromeCaseCaseInSenseX(String str);
    boolean isPalindromeCaseCaseSense(String str);

    /**37.	Check if a string is pangram**/
    boolean isPangram(String str);

    /**38.	Check if string contains only digits**/
    boolean strContainsOnlyDigits(String str);

    /**39.	Check if string contains only alphabets**/
    boolean containOnlyAlphabets(String str);

    /**40.	Check if string is valid email (basic regex)**/
    boolean checkValidEmail(String email);

    /**41.	Check if string is valid URL (basic regex)*/
    boolean checkValidUrl(String url);

    /**42.	Check if string is valid IPv4*/
    boolean checkValidIP4(String ip4);

    /**43.	Count occurrences of a substring in a string**/
    long countSubStrInStr(String str, String subStr);

    /**44.	Find all indexes of a substring in a string**/
    int[] indexesOfSubStrInStr(String str, String subStr);

    /**45.	Extract all numbers from a string**/
    int[] extractAllNo(String str);

    /**46.	Find all uppercase words in a sentence**/
    List<String> findUpperCaseWords(String str);

    /**47.	Check if string starts with a vowel using streams**/
    List<String> checkStrStartWithVowel(String str);

    /**48.	Check if string contains all unique characters**/
    boolean checkContainsAllUniqueChar(String str);

    /**49.	Check if two strings are rotations of each other**/
    boolean checkStrRotationsEachOthers(String str1, String str2);

    /**50.	Check if string can be rearranged to form a palindrome**/
    boolean canArrangeToFormPalindrome(String str);

    //    Category 4: Grouping & Aggregation (51 – 70)
    //51.	Group words by their length
    //52.	Group words by their starting letter
    //53.	Group words by anagram signature
    //54.	Group words by palindrome or not
    //55.	Group characters into vowels and consonants
    //56.	Group strings by first character in a list
    //57.	Group strings by last character in a list
    //58.	Find longest word in a sentence
    //59.	Find shortest word in a sentence
    //60.	Find N longest words in a sentence
    //61.	Find N shortest words in a sentence
    //62.	Sort words by length ascending
    //63.	Sort words by length descending
    //64.	Sort words alphabetically
    //65.	Sort words in reverse alphabetical order
    //66.	Get distinct words in sorted order
    //67.	Group characters into digits / letters / others
    //68.	Get frequency of each word sorted by frequency desc
    //69.	Get top K frequent words
    //70.	Get top K frequent characters

/**    Category 5: Advanced Problems (71 – 90)*/
    /**71.	Longest substring without repeating characters (using stream style)**/
    String longestUniqueSubStr(String str);

    /**72.	Longest substring with K distinct characters**/
    String longestUniqueSubStrKDistChar(String str, int k);

    /**73.	Smallest substring containing all unique characters**/
    String uniqueCharSmallestSubStr(String str);

    /**74.	All permutations of a string (stream-based recursion)**/
    List<String> permutation(String str);

    /**75.	All combinations of characters of a string**/
    List<String> combination(String str);

    /**76.	Find common characters between two strings (intersection)**/
    Set<Character> commonChar(String str1, String str2);

    /**77.	Find characters present in one string but not the other (difference)**/
    Set<Character> difference(String str1, String str2);

    /**78.	Merge two strings alternately**/
    String mergeStringsAlternately(String str1,String str2);

    /**79.	Shuffle characters randomly using streams**/
    String shuffleCharsRandomly(String str);

    /**80.	Count number of palindromic substrings*/
    long countPalindromicSubStr(String str);

    /**81.	Count number of substrings with unique characters**/
    long uniqueCharSubStrCount(String str);

    /**82.	Find all substrings of a string using IntStream**/
    List<String> allSubStr(String str);

    /**83.	Generate all prefixes of a string**/
    List<String> allPrefixes(String str);

    /**84.	Generate all suffixes of a string**/
    List<String> allSuffixes(String str);

    /**85.	Check if string A is subsequence of string B**/
    boolean checkSubsequence(String a, String b);

    /**86.	Check if two strings have any common substring**/
    boolean anyCommonSubStr(String str1, String str2);

    /**87.	Longest common prefix of list of strings**/
    String longestCommonPrefix(List<String> list);
    String longestCommonPrefixX(List<String> list);

    String longestCommonSubString(List<String> list);

    /**88.	Longest common suffix of list of strings**/
    String longestCommonSuffix(List<String> str);

    /**89.	Check if string has balanced parentheses/brackets**/
    boolean checkBalancedBrackets(String str);

    /**90.	Find unmatched brackets using stack + stream hybrid**/
    Character findUnmatchedBrackets(String str);

/* *    Category 6: File/Text Stream Processing (91 – 100)**/
    /**91.	Read lines from file and count total words using streams**/
    long totalNoOfWords(Path path) throws IOException;

    /**92.	Find most frequent word in file**/
    String mostFrequentWordInFile(Path path);

    /**93.	Remove stopwords from text using streams**/
    String removeStopWords(Set<String> stopWords,Path path);

    /**94.	Extract all unique email IDs from text file**/
    Set<String> extractUniqueEmailsId(Pattern pattern,Path path);

    /**95.	Count number of sentences in a text (split by .?!)**/
    long countNoOfSentence(Path path);

    /**96.	Tokenize and sort all words alphabetically from text file**/
    Set<String> tokenizeSortAlpha(Path path);

    /**97.	Find longest line in a file**/
    String findLongestLine(Path path);

    /**98.	Find all palindromic words in a file**/
    Set<String> allPalindromicWords(Path path);

    /**99.	Count number of occurrences of each character across multiple lines**/
    Map<Character,Long> groupCharsInFiles(Path path);

    /**100.	Merge contents of multiple strings/files and remove duplicates**/
    Set<String> removeDuplicateLinesFromFiles(List<Path> paths);
    Set<String> removeDuplicateWordsFromListStr(List<String> lists);
}
