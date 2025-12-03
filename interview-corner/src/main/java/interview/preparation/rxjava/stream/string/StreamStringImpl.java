package interview.preparation.rxjava.stream.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
                .stream().sorted(
                    Map.Entry.<Character,Long>comparingByValue()
                        .thenComparing(Map.Entry::getKey)
                )
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
                          .thenComparing(Map.Entry.comparingByKey())//if matching frequency go to alfa otherwise get as listed
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
                        .thenComparing(Map.Entry.comparingByKey())//if matching frequency go to alfa otherwise get as listed
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

 /* *    Category 5: Advanced Problems (71 – 90)*/
    /**71.	Longest substring without repeating characters (using stream style)**/
    @Override
    public String longestUniqueSubStr(String str){
        int n = str.length();

        return IntStream.range(0, n)
            .boxed()
            .flatMap(i -> IntStream.rangeClosed(i + 1, n)
                .mapToObj(j -> str.substring(i, j))
                .filter(s -> s.chars().distinct().count() == s.length()))
            .max(Comparator.comparing(String::length)).orElseThrow();
    }

    /**72.	Longest substring with K distinct characters**/
    @Override
    public  String longestUniqueSubStrKDistChar(String str, int k){
        int n = str.length();

        return
            IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, n).mapToObj(j -> str.substring(i, j)))
                .filter(s -> s.chars().distinct().count() == k)
                .max(Comparator.comparing(String::length)).orElseThrow();
    }

    /**73.	Smallest substring containing all unique characters**/
    @Override
    public String uniqueCharSmallestSubStr(String str){
        String uniqueChars = str.chars().mapToObj(c->(char)c).distinct().sorted().map(String::valueOf).collect(Collectors.joining());
        int n = str.length();
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i->IntStream.rangeClosed(i+1,n).mapToObj(j-> str.substring(i,j)))
                .filter(s-> s.chars().distinct().count()==uniqueChars.length())
                .min(Comparator.comparing(String::length))
                .get();
    }

    /**74.	All permutations of a string (stream-based recursion)**/
    @Override
    public List<String> permutation(String str){
       if(str==null||str.isEmpty())
           return List.of("");
       return
           IntStream.range(0,str.length())
               .boxed()
               .flatMap(i->
                   permutation(str.substring(0,i)+str.substring(i+1))
                       .stream().map(rest-> str.charAt(i)+rest)

               ).toList();
    }

    /**75.	All combinations of characters of a string**/
    @Override
    public List<String> combination(String str){
        int n = str.length();
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j->str.substring(i,j)))
                //.sequential() a, ab, abc, b, bc, c
                .sorted(
                    Comparator.comparing(String::length)
                        .thenComparing(Comparator.comparing(String::valueOf))
                )
                .toList();
    }
    /**76.	Find common characters between two strings (intersection)**/
    @Override
    public Set<Character> commonChar(String str1, String str2){

        Set<Character> set1= str1.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        Set<Character> set2= str2.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        return set1.stream().filter(set2::contains).collect(Collectors.toSet());
    }

    /**77.	Find characters present in one string but not the other (difference)**/
    @Override
    public Set<Character> difference(String str1, String str2){
        Set<Character> set1= str1.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        Set<Character> set2= str2.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        Set<Character> allSet= (str1+str2).chars().mapToObj(c->(char)c).collect(Collectors.toSet());

        return allSet.stream().filter(c-> !(set1.contains(c)&&set2.contains(c))).collect(Collectors.toSet());

    }

    /**78.	Merge two strings alternately**/
    @Override
    public String mergeStringsAlternately(String str1,String str2){
        int n1=str1.length();
        int n2 = str2.length();
        int n = Math.max(n1,n2);

        StringBuilder sb = new StringBuilder();
        IntStream.range(0,n)
            .forEach(i->{
                if(i<n1)
                    sb.append(str1.charAt(i));
                if(i<n2)
                    sb.append(str2.charAt(i));

            });
        return sb.toString();
    }

    /**79.	Shuffle characters randomly using streams**/
    @Override
    public String shuffleCharsRandomly(String str){

        return
            new Random()
                .ints(0,str.length())
                .distinct()
                .limit(str.length())
                .mapToObj(str::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**80.	Count number of palindromic substrings*/
    public long countPalindromicSubStr(String str){
        int n = str.length();

        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j->str.substring(i,j)))
                .filter(s->s.contentEquals(new StringBuilder(s).reverse()))
                .count();

    }

    /**81.	Count number of substrings with unique characters**/
    @Override
    public long uniqueCharSubStrCount(String str){
        int n = str.length();

        return IntStream.range(0,n)
            .boxed()
            .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j-> str.substring(i,j)))
            .filter(s->s.chars().distinct().count()==s.length())
            .count();
    }

    /**82.	Find all substrings of a string using IntStream**/
    @Override
    public List<String> allSubStr(String str){
        int n = str.length();
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j->str.substring(i,j)))
                .sorted(
                    Comparator.comparing(String::length)
                        .thenComparing(String::valueOf)
                )
                .toList();
    }

    /**83.	Generate all prefixes of a string**/
    @Override
    public List<String> allPrefixes(String str){
        int n = str.length();
        return
            IntStream.range(0,n)
                .mapToObj(i-> str.substring(0,i+1))
                .toList();
    }

    /**84.	Generate all suffixes of a string**/
    @Override
    public List<String> allSuffixes(String str){
        int n = str.length();
        return
            IntStream.rangeClosed(0,n)
                .mapToObj(str::substring)
                .toList();
    }

    /**85.	Check if string A is subsequence of string B**/
    @Override
    public boolean checkSubsequence(String a, String b){
        int[] index={0};
        IntStream.range(0,b.length())
            .forEach(i->
            {
                if(index[0]<a.length() && a.charAt(index[0])==b.charAt(i))
                    index[0]++;
            });
        return index[0]==a.length();
    }

    /**86.	Check if two strings have any common substring**/
    @Override
    public boolean anyCommonSubStr(String str1, String str2){
        Set<Character> set1= str1.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        Set<Character> set2= str2.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        return set1.stream().anyMatch(set2::contains); //if any substr is common then first their char is matching
    }

    /**87.	Longest common prefix of list of strings**/
    @Override
    public String longestCommonPrefix(List<String> list){
        String firstStr = list.getFirst();
        int prefix = IntStream.range(0,list.size())
            .takeWhile(i-> list.stream().allMatch(s-> i<s.length() && s.charAt(i)==firstStr.charAt(i)))
            .reduce((_, b)->b)
            .orElse(-1)+1;
        return firstStr.substring(0,prefix);
    }
    @Override
    public String longestCommonPrefixX(List<String> list){

        return list.stream()
            .reduce((s1,s2)->
            {
                int n = Math.min(s1.length(),s2.length());
                int i=0;
                while (i<n && s1.charAt(i)==s2.charAt(i))i++;
                return s1.substring(0,i);
            }).orElse("");
    }
    @Override
    public String longestCommonSubString(List<String> list){

        String shortest = list.stream().min(Comparator.comparing(String::length)).orElse("");
        int maxLen = shortest.length();

        return IntStream.rangeClosed(1,maxLen)
            .map(len-> maxLen-len)
            .boxed()
            .flatMap(len-> IntStream.rangeClosed(0,maxLen-len)
                .mapToObj(start-> shortest.substring(start,start+len)))
            .filter(sub->list.stream().allMatch(s->s.contains(sub)))
            .findFirst()
            .orElseThrow();
    }
    /**88.	Longest common suffix of list of strings**/
    @Override

    public String longestCommonSuffix(List<String> list){

        String shortest = list.stream().min(Comparator.comparing(String::length)).orElse("");
        int maxLen = shortest.length();

        int suffixLength=
           IntStream.range(0,maxLen)
               .takeWhile(i-> list.stream().allMatch(s->s.charAt(s.length()-1-i)==shortest.charAt(shortest.length()-1-i)))
               .reduce((a,b)->b)
               .orElse(-1)+1;
        return shortest.substring(shortest.length()-suffixLength);
    }

    /**89.	Check if string has balanced parentheses/brackets**/
    @Override
    public boolean checkBalancedBrackets(String str){
      Map<Character,Character> pairs = Map.of(
          ')','(',
          '}','{',
          ']','['
      );
      Deque<Character> stack = new ArrayDeque<>();

      str.chars().mapToObj(c->(char)c)
          .filter(c->pairs.containsKey(c)||pairs.containsValue(c))
          .forEach(c->
          {
              if(pairs.containsValue(c)) stack.push(c);
              else if(!stack.isEmpty()&& stack.peek()==pairs.get(c)) stack.pop();
              else stack.push('#');
          });

        return stack.isEmpty();
    }

    /**90.	Find unmatched brackets using stack + stream hybrid**/
    @Override
    public Character findUnmatchedBrackets(String str){
        Map<Character,Character> pairs = Map.of(
          ')','(',
          '}','{',
          ']','['
        );

        Deque<Character> stack = new ArrayDeque<>();
        Queue<Character> misMatch = new ArrayDeque<>();
        str.chars().mapToObj(c->(char)c)
            .filter(c->pairs.containsKey(c)||pairs.containsValue(c))
            .forEach(c->
            {
                if(pairs.containsValue(c))stack.push(c);
                else if(!stack.isEmpty()&& stack.peek()==pairs.get(c)) stack.pop();
                else misMatch.add(c);
            });
        return misMatch.poll();
    }
    /* *    Category 6: File/Text Stream Processing (91 – 100)**/
    /**91.	Read lines from file and count total words using streams**/
    @Override
    public long totalNoOfWords(Path path) throws IOException {
        long totalWords = 0;

        try (var lines = Files.lines(path)) {  // auto-closes stream
            totalWords = lines
                .flatMap(line -> Arrays.stream(line.trim().split("\\s+")))
                .filter(word -> !word.isEmpty())
                .count();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return totalWords;
    }
    /**92.	Find most frequent word in file**/
    @Override
    public String mostFrequentWordInFile(Path path){
        String mostFrequentWord="";

        try(var lines = Files.lines(path))
        {
            Map<String, Long> map = lines.flatMap(line-> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.groupingBy(
                    s->s,
                    Collectors.counting()
                ));
            mostFrequentWord =
                map.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
                    .stream().findFirst()
            .orElseThrow();
        }catch(IOException e)
        {
            System.err.println("Error reading file: "+ e.getMessage());
        }
        return mostFrequentWord;
    }

    /**93.	Remove stopwords from text using streams**/
    @Override
    public String removeStopWords(Set<String> stopWords,Path path){
        String str="";

        try(Stream<String> lines=Files.lines(path))
        {
            str = lines.flatMap(line-> Arrays.stream(line.split("\\s+")))
                .filter(word->!word.isEmpty())
                .filter(w->!stopWords.contains(w))
                .collect(Collectors.joining(" "));
        }catch(IOException e)
        {
            System.err.println("Error reading file: "+ e.getMessage());
        }
        return str;
    }

    /**94.	Extract all unique email IDs from text file**/
    @Override
    public Set<String> extractUniqueEmailsId(Pattern pattern,Path path){

        Set<String> emails= new HashSet<>();
        try(Stream<String> lines = Files.lines(path))
        {
            emails = lines.flatMap(line->
            {
                Matcher matcher = pattern.matcher(line);
                List<String> matches = new ArrayList<>();
                while (matcher.find())
                    matches.add(matcher.group());
                return matches.stream();
            })
                .collect(Collectors.toCollection(HashSet::new));

        }catch (IOException e)
        {
            System.err.println("Error reading file: "+ e.getMessage());
        }
        return emails;
    }

    /**95.	Count number of sentences in a text (split by .?!)**/
    @Override
    public long countNoOfSentence(Path path){

        try(Stream<String> lines = Files.lines(path))
        {
            return
                lines.flatMap(line-> Arrays.stream(line.split("[.?!]+")))
                    .map(String::trim)
                    .filter(sen->!sen.isEmpty())
                    .count();

        }catch (IOException e)
        {
            System.err.println("Error reading file: "+ e.getMessage());
            return 0;
        }
    }

    /**96.	Tokenize and sort all words alphabetically from text file**/
    @Override
    public Set<String> tokenizeSortAlpha(Path path){
        try(Stream<String> lines = Files.lines(path))
        {
            return
                lines.flatMap(line-> Arrays.stream(line.split("\\s+")))
                    .map(String::trim)
                    .filter(sen->!sen.isEmpty())
                    .sorted(String::compareToIgnoreCase)
                    .collect(Collectors.toCollection(LinkedHashSet::new));

        }catch (IOException e)
        {
            System.err.println("Error reading file: "+ e.getMessage());
            return Set.of("");
        }
    }

    /**97.	Find longest line in a file**/
    @Override
    public String findLongestLine(Path path){

        try(Stream<String> lines = Files.lines(path))
        {
            return
                lines.flatMap(line-> Arrays.stream(line.split("[.!?]+")))
                    .filter(l->!l.isEmpty())
                    .max(Comparator.comparingInt(String::length))
                    .orElseThrow();

        }catch (IOException e)
        {
            System.err.println("Error reading file : "+e.getMessage());
            return String.valueOf("");
        }
    }

    /**98.	Find all palindromic words in a file**/
    @Override
    public Set<String> allPalindromicWords(Path path){

        try (Stream<String> lines = Files.lines(path))
        {
            return
                lines.flatMap(line-> Arrays.stream(line.toLowerCase()
                    .replaceAll("[^a-z0-9\\s]", "") // remove punctuation
                    .split("\\s+")))
                    .filter(word -> word.length() > 1) // ignore single letters
                    .filter(words-> words.equalsIgnoreCase(new StringBuilder(words).reverse().toString()))
                    .collect(Collectors.toSet());
        }catch (IOException e)
        {
            System.err.println("Error reading in file: "+e.getMessage());
            return new HashSet<>();
        }
    }
    /**99.	Count number of occurrences of each character across multiple lines**/
    @Override
    public Map<Character,Long> groupCharsInFiles(Path path){
        try(Stream<String> lines = Files.lines(path))
        {
            return
                lines
                    .flatMapToInt(String::chars)
                    .mapToObj(c->(char)c)
                    .filter(Character::isLetterOrDigit)
                    .map(Character::toLowerCase)
                    .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                    ));

        }catch (IOException e)
        {
            System.err.println("Error reading file: "+ e.getMessage());
            return new HashMap<>();
        }
    }
    /**100.	Merge contents of multiple strings/files and remove duplicates**/
    @Override
    public Set<String> removeDuplicateLinesFromFiles(List<Path> paths){
        try(Stream<String> allLines = paths.stream()
            .flatMap(path->
                {
                    try {
                        return Files.lines(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            )) {
            return allLines
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
        }
    }
    @Override
    public Set<String> removeDuplicateWordsFromListStr(List<String> lists){

        return
            lists.stream().flatMap(s->Arrays.stream(s.split("\\s+")))
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^a-z0-9]", ""))           // remove punctuation
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(LinkedHashSet::new)); // unique & keep order
    }
}
