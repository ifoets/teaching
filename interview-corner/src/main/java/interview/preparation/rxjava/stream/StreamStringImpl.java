package interview.preparation.rxjava.stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStringImpl implements IStreamString {
    /* * Category 1: Character Frequency & Counting (1 – 15)**/
    /** 1.	Count frequency of each character in a string*/
    @Override
    public Map<Character, Long> countFrequency(String str){
        return
            str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
    /**2.	Count frequency of each word in a sentence*/
    public Map<String,Long> countStringFrequency(String sentence){
        return
            Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
    /**  3.	Find first non-repeating character*/
    @Override
    public Character firstNonRepeatingChar(String str){
       return allNonRepeatingChar(str)
           .entrySet()
           .stream()
           .filter(x->x.getValue()==1)
           .map(Map.Entry::getKey)
           .findFirst().orElseThrow();
    }
    @Override
    public Character nThNonRepeatingChar(String str, int n){
        return
            allNonRepeatingChar(str)
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .skip(n-1)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
    /** 4.	Find first repeating character*/
    @Override
    public Character firstRepeatingChar(String str){
        return
            allRepeatingChar(str)
                .entrySet()
                .stream()
                .filter(e-> e.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
    @Override
    public Character nThRepeatingChar(String str, int n){
        return
            allRepeatingChar(str)
                .entrySet()
                .stream()
                .filter(e-> e.getValue()>1)
                .skip(n-1)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
    /**  5.	Find all repeating characters*/
    @Override
    public Map<Character, Long> allRepeatingChar(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    c->c,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()>1)
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
    }
    /**6.	Find all non-repeating characters*/
    public Map<Character, Long> allNonRepeatingChar(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    c->c,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()==1)
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
    }

    /**  7.	Sort characters by frequency ascending*/
    public Map<Character, Long> sortByFrequencyAsc(String str){
         return
             str.chars()
                 .mapToObj(c->(char)c)
                 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                 .entrySet()
                 .stream().sorted(Map.Entry.<Character,Long>comparingByValue())
                 .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                     (e1,e2)->e1,
                     LinkedHashMap::new
                 ));

    }

    @Override
    public Map<Character, Long> sortByFrequencyAscAlfa(String str){
        return
            str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.<Character,Long>comparingByValue().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
    }

    /**   8.	Sort characters by frequency descending*/
    public Map<Character, Long> sortByFrequencyDesc(String str){
        return
            str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream().sorted(
                    Map.Entry.<Character,Long>comparingByValue().reversed()
                )
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
    }

    @Override
    public Map<Character, Long> sortByFrequencyDescAlfa(String str){
        return str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(
                Map.Entry.<Character, Long>comparingByValue(Comparator.reverseOrder()) // Frequency descending
                    .thenComparing(Map.Entry.<Character, Long>comparingByKey().reversed())                     // Alphabet descending
            )
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }
    /**  9.	Find character with max frequency*/
    @Override
    public Character maxCharFrequency(String str){
          return
              str.chars().mapToObj(c->(char)c)
                  .collect(Collectors.groupingBy(
                      Function.identity(),
                      LinkedHashMap::new,
                      Collectors.counting()))
                  .entrySet()
                  .stream()
                  .sorted(
                      Map.Entry.<Character,Long>comparingByValue().reversed()
                          .thenComparing(Map.Entry.comparingByKey())//if matching frequencygo to alfa otherwise get as listed
                  )
                  .map(Map.Entry::getKey)
                  .findFirst().orElseThrow();
    }
    /** 10.	Find character with min frequency*/
    @Override
    public Character minCharFrequency(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.<Character,Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey())//if matching requency go to alfa otherwise get as listed
                )
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
    /**  11.	Check if two strings are anagrams*/
    @Override
    public boolean isAnagrams(String str1, String str2){
        return str1.chars().mapToObj(c->(char)c).sorted().map(String::valueOf).collect(Collectors.joining())
            .equals(str2.chars().mapToObj(c->(char)c).sorted().map(String::valueOf).collect(Collectors.joining()));
    }

    /**  12.	Check if two strings are isomorphic*/
    @Override
    public boolean isIsomorphic(String str1, String str2){
        if(str1.length()!=str2.length()) {
            return false;
        }
         Map<Character,Character> mapST = new HashMap<>();
         Map<Character,Character> mapTS = new HashMap<>();

       return IntStream.range(0,str1.length())
            .allMatch(
                i->
                {
                    char c1 = str1.charAt(i);
                    char c2 = str2.charAt(i);

                    if(mapST.containsKey(c1) && mapST.get(c1)!=c2)
                        return false;
                    mapST.putIfAbsent(c1,c2);

                    if(mapTS.containsKey(c2) && mapTS.get(c2)!=c1)
                        return false;
                    mapTS.putIfAbsent(c2,c1);

                    return true;
                }

            );
    }

    /**  13.	Count vowels and consonants in a string*/
    @Override
    public Map<Boolean,Long> countVowelAndCons(String str){
        Set<Character> set =Set.of('a','e','i','o','u');
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    set::contains,
                    Collectors.counting()
                ));

    }
    /**  14.	Count uppercase, lowercase, digits, special characters*/
    @Override
    public Map<String, Long> countDiffChars(String str){

        return
            str.chars().mapToObj(c->(char)c)
                .collect(
                    Collectors.groupingBy(
                        c->Character.isUpperCase(c)?"UPPER-CASE"
                            :Character.isLowerCase(c)?"LOWER-CASE"
                            :Character.isDigit(c)?"DIGIT"
                            :"SPECIAL",
                        Collectors.counting()
                    )
                );
    }

    /** 15.	Find the most frequent word in a sentence*/
    @Override
    public String mostFrequentWord(String str){
        return
            Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.<String ,Long>comparingByValue().reversed()
                )
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }


/* *Category 2: String Transformations (16 – 35)*/
    /**16.	Reverse entire string**/
    @Override
    public String reverseStr(String str){
        if(Objects.isNull(str)||str.length()==1)
            return str;
        return
            str.chars()
                .collect(StringBuilder::new,
                    (sb,ch)->sb.append((char)ch)
                    ,StringBuilder::append)
                .reverse().toString();
    }

    /**17.	Reverse each word in a sentence**/
    @Override
    public String reverseWordsInSentence(String str){
        return
            Arrays.stream(str.split(" "))
                .map(s->new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    /**18.	Reverse order of words in a sentence*/
    @Override
    public String reverseOrderOfWords(String str){
        String []newStr = str.split(" ");
        return
            IntStream.range(0,newStr.length)
                .mapToObj(i-> newStr[newStr.length-1-i])
                .collect(Collectors.joining(" "));
    }

    /**19.	Capitalize first letter of each word*/
    @Override
    public String capFirstLetterOfWords(String str){
        return
            Arrays.stream(str.split(" "))
                .map(s->Character.toUpperCase(s.charAt(0))+s.substring(1))
                .collect(Collectors.joining(" "));
    }

    /**20.	Convert camelCase to snake_case*/
    @Override
    public String convertCamelCaseToSnakeCase(String str){
        StringBuilder sb = new StringBuilder();

            //str.replaceAll("([A-Z])","_$1")
           //     .toLowerCase();
            IntStream.range(0, str.length())
                .forEach(i -> {
                    char c = str.charAt(i);
                    if (Character.isUpperCase(c) && i != 0) {
                        sb.append('_');
                    }
                    sb.append(Character.toLowerCase(c));
                });

        return sb.toString();
    }

    /**21.	Convert snake_case to camelCase*/
    @Override
    public String convertToSnakeCaseToCaeCase(String str){
        StringBuilder sb = new StringBuilder();
        AtomicBoolean toUpper = new AtomicBoolean(false); // flag to capitalize next char after underscore

        IntStream.range(0, str.length())
            .forEach(i -> {
                char c = str.charAt(i);
                if (c == '_') {
                    toUpper.set(true); // set flag to capitalize next char
                } else {
                    if (toUpper.get()) {
                        sb.append(Character.toUpperCase(c));
                        toUpper.set(false);
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                }
            });

        return sb.toString();
    }

    /**22.	Remove vowels from a string*/
    @Override
   public  String removeVowels(String str){

        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
        return
            str.chars().mapToObj(c->(char)c)
                .filter(ch->!set.contains((char)ch))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**23.	Remove all duplicate characters*/
    @Override
    public String removeDuplicate(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**25.	Replace multiple spaces with a single space**/
    @Override
    public String replaceMultiSpaceInSingle(String str){
        return
            Arrays.stream(str.split(" "))
                .filter(s-> !s.isEmpty())
                .map(String::strip)
                .collect(Collectors.joining(" "));
    }

    /**26.	Trim leading and trailing spaces without using trim()*/
    @Override
    public String removeLeadingTrailingWithoutTrim(String str){
       int i=0;
       int l=str.length()-1;
       while(i<=l&&str.charAt(i)==' '){
           i++;
       }
       while(l>=i&&str.charAt(l)==' '){
           l--;
       }
        return str.substring(i,l+1);
    }

    /**27.	Remove digits from a string**/
    @Override
    public String removeDigits(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .filter(ch-> !Character.isDigit(ch))
                .map(String::valueOf)
                .collect(Collectors.joining());

    }

    /**28.	Keep only digits from a string**/
    @Override
    public String onlyDigitsInStr(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**29.	Remove special characters but keep alphanumerics*/
    @Override
    public String removeSpecialChars(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .filter(ch-> Character.isAlphabetic(ch)||Character.isDigit(ch))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**30.	Replace each character with its ASCII code (joined by space)**/
    @Override
    public String toAssciCharsString(String str){
        return str.chars()
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(" "));
    }

    /**31.	Encode characters by shifting ASCII (Caesar cipher simple)*/
    @Override
    public String  encodeCharByShiftingAscii(String str, int shift){
        return str.chars()
            .map(c -> Character.isLetter(c)
                ?
                ((Character.isUpperCase(c) ? 'A' : 'a') + (c - (Character.isUpperCase(c) ? 'A' : 'a') + shift) % 26)
                : c)
            .mapToObj(c -> String.valueOf((char)c))
            .collect(Collectors.joining());
    }

    /**32.	Convert string to character frequency encoded form (e.g. a2b1c3)*/
    @Override
    public String charFrequencyEncoded(String str){
        StringBuilder sb = new StringBuilder();

        Map<Character,Long> map = str.chars().mapToObj(c->(char)c)
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        map.forEach((key, value) -> sb.append(key).append(value));
        return sb.toString();
    }

    /**33.	Expand frequency encoded string (e.g. a2b1c3 → aabccc)*/
    @Override
    public String expandFrequencyEncoded(String str){
        Matcher matcher = Pattern.compile("([a-zA-Z])(\\d+)").matcher(str);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            char ch = matcher.group(1).charAt(0);
            int count = Integer.parseInt(matcher.group(2));
            sb.append(String.valueOf(ch).repeat(count));
        }

        return sb.toString();
    }

    /**34.	Mask characters except last 4 (e.g. credit card mask)**/
    @Override
    public String maskExceptLast4Digit(String str){
        return
            str.substring(0,str.length()-4)
                .chars()
                .mapToObj(c->'*')
                .map(String::valueOf)
                .collect(Collectors.joining())+str.substring(str.length()-4);
    }

    /**35.	Remove duplicate words in a sentence**/
    @Override
    public String removeDuplicateWords(String str){
       return
           Arrays.stream(str.split(" "))
            .distinct()
            .collect(Collectors.joining(" "));
    }

/* *Category 3: Pattern Matching & Validation (36 – 50)*/
    /**36.	Check if a string is palindrome (case-insensitive)*/
    @Override
    public boolean isPalindromeCaseCaseInSense(String str){
        final String s = str.toLowerCase();
        return Stream.iterate(
            new int[]{0, str.length()-1},
            b->b[0]<=b[1],
            b->
            {
                if(s.charAt(b[0])!=s.charAt(b[1])) {
                    return new int[]{-1,-1};
                }
                else {
                    return new int[]{b[0]++,b[1]--};
                }
            }
        ).map(b->{
                return b[0]!=-1;
            }).filter(idx-> idx)
            .findFirst().orElse(false);
    }
    @Override
    public boolean isPalindromeCaseCaseInSenseX(String str){
        String s = str.toLowerCase();
        return
            IntStream.range(0,str.length()/2)
                .allMatch(i-> s.charAt(i)==s.charAt(s.length()-1-i));
    }
    @Override
    public boolean isPalindromeCaseCaseSense(String str){
        return
            IntStream.range(0,str.length()/2)
                .allMatch(i-> str.charAt(i)==str.charAt(str.length()-1-i));
    }

    /**37.	Check if a string is pangram**/
    @Override
    public boolean isPangram(String str){

        return
            str.toLowerCase().chars().mapToObj(c->(char)c)
                .filter(ch-> ch>='a' && ch<='z')
                .distinct().count()==26;
    }

    /**38.	Check if string contains only digits**/
    @Override
    public boolean strContainsOnlyDigits(String str){
        return
            str.chars().mapToObj(c -> (char) c).allMatch(x -> x >= '0' && x <= '9');
    }

    /**39.	Check if string contains only alphabets**/
    @Override
    public boolean containOnlyAlphabets(String str){
        return
            str.toLowerCase().chars().mapToObj(c -> (char) c).allMatch(x -> x >= 'a' && x <= 'z');
    }

    /**40.	Check if string is valid email (basic regex)**/
    @Override
    public boolean checkValidEmail(String str){
        String regex ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
      return Pattern.compile(regex)
          .matcher(str)
          .matches();
    }

    /**41.	Check if string is valid URL (basic regex)*/
    @Override
    public boolean checkValidUrl(String url){
      //need to understand well first the regex
        return false;
    }

    /**42.	Check if string is valid IPv4*/
    @Override
    public boolean checkValidIP4(String ip4){
    //need to understand well first the regex
        return false;
    }

    /**43.	Count occurrences of a substring in a string**/
    @Override
    public long countSubStrInStr(String str, String subStr){

        return
            Arrays.stream(str.split(" "))
                .filter(s->s.equals(subStr))
                .count();
    }

    /**44.	Find all indexes of a substring in a string**/
    @Override
    public int[] indexesOfSubStrInStr(String str, String subStr){

        return
            IntStream.range(0,str.length()-subStr.length()+1)
                .filter(i-> str.startsWith(subStr,i))
                .toArray();
    }

    /**45.	Extract all numbers from a string**/
    @Override
    public int[] extractAllNo(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .filter(ch-> ch>='0'&&ch<='9')
                .mapToInt(x->x-48)
                .toArray();
    }

    /**46.	Find all uppercase words in a sentence**/
    @Override
    public List<String> findUpperCaseWords(String str){
        return
            Arrays.stream(str.split("\\s+"))
                .filter(w-> w.matches("[A-Z]+"))
                .toList();
    }
    /**47.	Check if string starts with a vowel using streams**/
    @Override
    public List<String> checkStrStartWithVowel(String str){
        Set<Character> vowelSet=Set.of('a','e','i','o','u');
        return
            Arrays.stream(str.split("\\s+"))
                .filter(w-> vowelSet.contains(w.charAt(0)))
                .toList();
    }

    /**48.	Check if string contains all unique characters**/
    @Override
    public boolean checkContainsAllUniqueChar(String str){
       return
           str.chars().distinct().count()==str.length();
    }

    /**49.	Check if two strings are rotations of each other**/
    @Override
    public boolean checkStrRotationsEachOthers(String str1, String str2){
        return
            Optional.ofNullable(str1)
                .filter(x-> str2!=null && str1.length()==str2.length())
                .map(x-> (x+x).contains(str2))
                .orElse(false);
    }

    /**50.	Check if string can be rearranged to form a palindrome**/
    @Override
    public boolean canArrangeToFormPalindrome(String str){
        return
            str.toLowerCase().chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    c->c,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e->e.getValue()%2!=0)
                .count()==1;
    }

 /**    Category 5: Advanced Problems (71 – 90)*/
    /**71.	Longest substring without repeating characters (using stream style)**/
    @Override
    public String longestUniqueSubStr(String str){
       return null;
    }
}
