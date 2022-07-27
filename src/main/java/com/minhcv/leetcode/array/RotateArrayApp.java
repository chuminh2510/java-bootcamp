package com.minhcv.leetcode.array;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArrayApp {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new Solution().rotate(nums, 2);

    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            if (k == 0) {
                return;
            }
            int[] leftArr = new int[nums.length - k];
            int[] rightArr = new int[k];
            for (int i = 0; i < nums.length - k; i++) {
                leftArr[i] = nums[i];
            }
            int j = 0;
            for (int i = nums.length - k; i < nums.length; i++) {
                rightArr[j] = nums[i];
                j++;
            }
            for (int i = 0; i < k; i++) {
                nums[i] = rightArr[i];
            }
            j = 0;
            for (int i = k; i < nums.length; i++) {
                nums[i] = leftArr[j];
                j++;
            }
        }
    }
}
