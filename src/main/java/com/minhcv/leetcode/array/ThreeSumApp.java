package com.minhcv.leetcode.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSumApp {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            for (int idx = 0; idx < nums.length; idx++) {
                Map<Integer, Integer> mapNums = new HashMap<>();
                int target = 0 - nums[idx];
                for (int i = 0; i < nums.length; i++) {

                }
            }
            return null;
        }

    }
}
