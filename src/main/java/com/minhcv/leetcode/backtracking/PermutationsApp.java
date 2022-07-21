package com.minhcv.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/permutations/
 */
public class PermutationsApp {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutation = new Solution().permute(nums);
        System.out.println("Output: " + permutation.toString());
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            return backTrack(new ArrayList<>(), nums);
        }


        public List<List<Integer>> backTrack(List<Integer> ints, int[] nums) {
            if (ints.size() == nums.length) {
                return Arrays.asList(new ArrayList<>(ints));
            }
            List<List<Integer>> permutations = new ArrayList<>();
            for (int idx = 0; idx < nums.length; idx++) {
                if (ints.contains(nums[idx])) {
                    continue;
                }
                ints.add(nums[idx]);
                permutations.addAll(backTrack(ints, nums));
                ints.remove(ints.size() - 1);
            }
            return permutations;
        }

        public List<List<Integer>> appendRandomInt(List<Integer> ints, int[] nums) {
            if (nums.length == 0) {
                return Arrays.asList(ints);
            }
            List<List<Integer>> permutations = new ArrayList<>();
            for (int idx = 0; idx < nums.length; idx++) {
                List<Integer> des = ints.stream().collect(Collectors.toList());
                des.add(nums[idx]);
                int finalIdx = idx;
                int[] subNums = IntStream.range(0, nums.length).filter(i -> i != finalIdx).map(i -> nums[i]).toArray();
                permutations.addAll(appendRandomInt(des, subNums));
            }
            return permutations;
        }
    }
}
