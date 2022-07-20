package com.minhcv.leetcode.string;

import javax.swing.text.EditorKit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LettersCombinationPhoneNumberApp {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> test = sol.letterCombinations("23");
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }
            Map<Integer, List<String>> phoneNumbers = new HashMap<>();
            phoneNumbers.put(2, Arrays.asList("abc".split("")));
            phoneNumbers.put(3, Arrays.asList("def".split("")));
            phoneNumbers.put(4, Arrays.asList("ghi".split("")));
            phoneNumbers.put(5, Arrays.asList("jkl".split("")));
            phoneNumbers.put(6, Arrays.asList("mno".split("")));
            phoneNumbers.put(7, Arrays.asList("pqrs".split("")));
            phoneNumbers.put(8, Arrays.asList("tuv".split("")));
            phoneNumbers.put(9, Arrays.asList("wxyz".split("")));
            List<String> combinedLetters = combineLetters(phoneNumbers, digits);
            return combinedLetters;
        }

        private List<String> combineLetters(Map<Integer, List<String>> phoneNumbers, String digits) {
            if (digits.length() == 1) {
                return phoneNumbers.get(Integer.valueOf(digits));
            }
            List<String> combinedLetters = new ArrayList<>();
            List<String> tmpCombined = combineLetters(phoneNumbers, digits.substring(1));
            List<String> letters = phoneNumbers.get(Integer.valueOf("" + digits.charAt(0)));

            for (String letter : letters) {
                combinedLetters.addAll(tmpCombined.stream().map(s -> letter + s).collect(Collectors.toList()));
            }
            return combinedLetters;
        }
    }
}
