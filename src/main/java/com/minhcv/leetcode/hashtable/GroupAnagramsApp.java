package com.minhcv.leetcode.hashtable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagramsApp {
    public static void main(String[] args) {


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Solution().groupAnagrams(strs);

    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Integer, List<String>> map = Arrays.asList(strs).stream().collect(Collectors.groupingBy(str -> hashCode(str), Collectors.toList()));
            return map.values().stream().collect(Collectors.toList());
        }


        public int hashCode(String s) {
            int[] chars = new int[26];
            for (int idx = 0; idx < s.length(); idx++) {
                chars[s.charAt(idx) - 'a']++;
            }
            return Arrays.hashCode(chars);
        }
    }
}
