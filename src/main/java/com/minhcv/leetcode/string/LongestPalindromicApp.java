package com.minhcv.leetcode.string;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */
public class LongestPalindromicApp {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("babad");
        sol.longestPalindrome("cbbd");
    }

    public static class Solution {
        public String longestPalindrome(String s) {
            String longestPalindrome = s.length() > 0 ? s.charAt(0) + "" : "";
            for (int idx = 0; idx < s.length(); idx++) {
                char c = s.charAt(idx);
                int lastPos = s.lastIndexOf(c);
                while (lastPos > idx) {
                    if ((lastPos - idx + 1) <= longestPalindrome.length()) {
                        break;
                    }
                    if (isPalindrome(s, idx, lastPos)) {
                        String subStr = s.substring(idx, lastPos + 1);
                        if (subStr.length() > longestPalindrome.length()) {
                            longestPalindrome = subStr;
                        }
                    }
                    lastPos = s.lastIndexOf(c, lastPos - 1);
                }

            }
            return longestPalindrome;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
