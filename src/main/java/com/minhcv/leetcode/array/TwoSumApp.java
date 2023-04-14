package com.minhcv.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSumApp {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] secondNums = new int[nums.length];
            Map<Integer, Integer> mapNums = new HashMap<>();
            for (int idx = 0; idx < nums.length; idx++) {
                mapNums.put(nums[idx], idx);
            }
            for (int idx = 0; idx < nums.length; idx++) {
                Integer idxVal = mapNums.get(target - nums[idx]);
                if (idxVal != null && !idxVal.equals(idx)) {
                    return new int[]{idx, idxVal};
                }
            }

            return null;
        }
    }
}
