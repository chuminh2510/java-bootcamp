package com.minhcv.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSumApp {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return null;
        }

        public List<Integer> findCandidates(int[] candidates, int idx, int target, int sum) {
            sum += candidates[idx];
            if (sum == target) {
                return Arrays.asList(candidates[idx]);
            }
            if (sum > target) {
                return null;
            }
            findCandidates(candidates, idx, target, sum);
            findCandidates(candidates, idx + 1, target, sum);
            return null;
        }
    }
}
