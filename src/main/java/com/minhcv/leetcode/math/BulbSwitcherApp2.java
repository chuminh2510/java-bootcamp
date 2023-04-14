package com.minhcv.leetcode.math;

/**
 * https://leetcode.com/problems/bulb-switcher-ii/
 */
public class BulbSwitcherApp2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.flipLights(3, 1);
    }

    static class Solution {

        public int flipLights(int n, int presses) {
            if (presses == 0) return 1;
            if (n == 1) return 2;
            if (n == 2 && presses == 1) return 3;
            if (n == 2) return 4;
            if (presses == 1) return 4;
            if (presses == 2) return 7;
            if (presses >= 3) return 8;
            return 0;
        }


    }
}
