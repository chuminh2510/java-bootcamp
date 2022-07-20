package com.minhcv.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubStringConcatenationAllWordsApp {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        Solution sol = new Solution();
        sol.findSubstring(s, words);
    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> positions = new ArrayList<>();
            List<String> sortedWords = Arrays.stream(words).sorted().collect(Collectors.toList());
            int wlength = words[0].length();
            boolean isMatched = true;
            for (int idx = 0; idx + wlength * words.length - 1 < s.length(); idx++) {
                final String subStr = s.substring(idx, idx + wlength * words.length);
                List<String> subs = IntStream.iterate(0, i -> i < subStr.length(), i -> i + wlength).mapToObj(i -> subStr.substring(i, i + wlength)).sorted().collect(Collectors.toList());

                for (int idxWord = 0; idxWord < sortedWords.size(); idxWord++) {
                    isMatched = sortedWords.get(idxWord).equals(subs.get(idxWord));
                    if (!isMatched) {
                        break;
                    }
                }
                if (isMatched) {
                    positions.add(idx);
                }
                isMatched = true;

            }
            return positions;
        }
    }
}
