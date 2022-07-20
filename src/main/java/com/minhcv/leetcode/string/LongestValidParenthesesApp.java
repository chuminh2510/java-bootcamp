package com.minhcv.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParenthesesApp {
    public static void main(String[] args) {
//        new Solution().longestValidParentheses(")()())");
    }

    class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() == 0) {
                return 0;
            }
            Stack<ParenthesesInfo> parentheses = new Stack<>();
            List<Integer> counts = new ArrayList<>();
            for (int idx = 0; idx < s.length(); idx++) {
                char c = s.charAt(idx);
                if (c == ')') {
                    if (parentheses.size() > 0) {
                        char c1 = parentheses.peek().c;
                        if (c1 == '(') { // Valid
                            parentheses.pop();
                        } else {
                            parentheses.push(new ParenthesesInfo(c, idx));
                        }
                    } else {
                        parentheses.push(new ParenthesesInfo(c, idx));
                    }
                } else {
                    parentheses.push(new ParenthesesInfo(c, idx));
                }
            }
            if (parentheses.size() == 0) {
                return s.length();
            }
            int previousIdx = -1;
            for (int idx = 0; idx < parentheses.size(); idx++) {
                int count;
                if (previousIdx > -1) {
                    count = parentheses.get(idx).idx - previousIdx - 1;
                } else {
                    count = parentheses.get(idx).idx - 0;
                }
                counts.add(count);
                previousIdx = parentheses.get(idx).idx;
            }
            int count = s.length() - previousIdx - 1;
            counts.add(count);
            if (counts.size() > 0) {
                return counts.stream().max(Integer::compare).get();
            }
            return 0;
        }

        class ParenthesesInfo {
            char c;
            int idx;

            public ParenthesesInfo(char c, int idx) {
                this.c = c;
                this.idx = idx;
            }
        }
    }
}
