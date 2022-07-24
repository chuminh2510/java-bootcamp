package com.minhcv.leetcode.dynamic;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePathsApp {
    public static void main(String[] args) {
        int nums = new Solution().uniquePaths(7, 4);
        System.out.println(nums);
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            return move(0, 0, m - 1, n - 1);
        }

        public int move(int numDown, int numRight, int m, int n) {
            int count = 0;
            if (numDown == m && numRight == n) {
                return 1;
            }
            if (numDown < m) { // move down
                count += move(numDown + 1, numRight, m, n);
            }

            if (numRight < n) {
                count += move(numDown, numRight + 1, m, n);
            }
            return count;
        }
    }
}
