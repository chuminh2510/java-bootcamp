package com.minhcv.leetcode.recursion;

import java.util.Stack;

public class BasicCaculatorApp {
    static class Solution {
        public int calculate(String s) {
            Stack<Character> stackOpens = new Stack<>();
            for (int idx = 0; idx < s.length(); idx++) {
                char c = s.charAt(idx);
                if (c == '(') {
                    stackOpens.push(c);
                }
            }
            return 0;
        }


        public int plus(int a, int b) {
            return a + b;
        }

        public int minus(int a, int b) {
            return a - b;
        }

    }
}
