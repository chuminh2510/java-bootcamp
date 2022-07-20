package com.minhcv.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatApp {
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    public static class Solution{
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> mapCharPos = new HashMap<>();
            int length = 0;
            int maxLength = 0;
            int size = s.length();
            int startPos = 0;
            for (int idx = 0 ; idx < size; idx++){
                char curChar = s.charAt(idx);
                if(!mapCharPos.containsKey(curChar)){
                    length ++;
                } else {
                    int curPos = mapCharPos.get(curChar);
                    if(curPos >= startPos){
                        maxLength = maxLength > length ? maxLength : length;
                        startPos = curPos;
                        length = idx - startPos;
                    } else {
                        length++;
                    }
                }
                mapCharPos.put(curChar, idx);
            }
            maxLength = maxLength > length ? maxLength : length;
            return maxLength;
        }
    }
}
