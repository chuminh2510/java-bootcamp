package com.minhcv.leetcode.binary;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayApp2 {
    static class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            while (left < right) {
                if (nums[left] <= nums[left + 1]) {
                    left++;
                } else {
                    return nums[left + 1];
                }
                if (nums[right] >= nums[right - 1]) {
                    right--;
                } else {
                    return nums[right];
                }
            }
            return nums[left];
        }
    }
}
