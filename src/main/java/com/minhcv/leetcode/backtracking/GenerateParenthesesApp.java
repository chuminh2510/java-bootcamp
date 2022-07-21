package com.minhcv.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
                if (isValidParentheses(s)) {
                    return Arrays.asList(s);
                } else {
                    return null;
                }
            }
            List<String> validParentheses = new ArrayList<>();
            if (countOpen > 0) {
                int tempCount = countOpen;
                List<String> ret = appendParentheses(s + "(", --tempCount, countClose);
                if (ret != null) {
                    validParentheses.addAll(ret);
                }
            }
            if (countClose > countOpen) {
                int tempCount = countClose;
                List<String> ret = appendParentheses(s + ")", countOpen, --tempCount);
                if (ret != null) {
                    validParentheses.addAll(ret);
                }
            }
            return validParentheses;
        }

        public boolean isValidParentheses(String s) {
            if (s.length() == 0) {
                return false;
            }
            Stack<Character> parentheses = new Stack<>();
            parentheses.push(s.charAt(0));
            for (int idx = 1; idx < s.length(); idx++) {
                char c = s.charAt(idx);
                if (c == ')') {
                    if (parentheses.size() > 0 && parentheses.peek() == '(') {
                        parentheses.pop();
                    } else {
                        parentheses.push(c);
                    }
                } else {
                    parentheses.push(c);
                }
            }
            return parentheses.size() == 0;
        }
    }
}
