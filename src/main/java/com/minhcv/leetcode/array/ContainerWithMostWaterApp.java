package com.minhcv.leetcode.array;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWaterApp {
    class Solution {
        public int maxArea(int[] height) {
            // Loop height with O(n^2)
            int max = 0;
            for (int idx = 0; idx < height.length - 1; idx++) {
                // Check index as first endpoint -> Get next endpoint height(idx)
                for (int j = idx + 1; j < height.length; j++) {
                    int minValue = Math.min(height[idx], height[j]);
                    int square = (j - idx) * minValue;
                    // Calculate the square -> save in temporary variable
                    max = square > max ? square : max;
                }
            }
            return max;

        }

        public int maxArea2(int[] height) {
            int max = 0;
            // left, right pointer
            // Compare a - height[left] and  b - height[right]
            // a < b -> left += 1
            // a > b -> right -= 1;
            // a == b -> left += 1
            // Break: left == right
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                int minValue = Math.min(height[left], height[right]);
                int square = (right - left) * minValue;
                max = square > max ? square : max;
                if (height[left] <= height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }

    }
}
