package com.design.analysis.ds.hash.table.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashTableHardImpl implements IHashTableHard{

    /**30. Substring with Concatenation of All Words**/
    @Override
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLen * totalWords;

        if (s.length() < windowSize) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Try all wordLen offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many occurrences → shrink window
                    while (windowMap.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    windowMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }
    /**76. Minimum Window Substring*/
    @Override
    public String minWindow(String s, String t){

        return "";
    }
}
