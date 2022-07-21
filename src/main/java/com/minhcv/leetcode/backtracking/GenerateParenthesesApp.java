package com.minhcv.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesesApp {
    public static void main(String[] args) {
        List<String> parentheses = new Solution().generateParenthesis(3);
        System.out.println("Out: " + parentheses.toString());
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            return appendParentheses("", n, n);
        }

        public List<String> appendParentheses(String s, int countOpen, int countClose) {
            if (countOpen == 0 && countClose == 0) {
                return Arrays.asList(s);
            }
            List<String> validParentheses = new ArrayList<>();
            if (countOpen > 0) {
                List<String> ret = appendParentheses(s + "(", countOpen - 1, countClose);
                if (ret != null) {
                    validParentheses.addAll(ret);
                }
            }
            if (countClose > countOpen) { // This ensures parentheses string is always correct
                List<String> ret = appendParentheses(s + ")", countOpen, countClose - 1);
                if (ret != null) {
                    validParentheses.addAll(ret);
                }
            }
            return validParentheses;
        }
    }
}
