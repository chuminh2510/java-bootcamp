package com.minhcv.leetcode.counting;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCowsApp {

    public static void main(String[] args) {
        int[] h = new int[10];
        System.out.println(h['5' - '0']);
    }

    static class Solution {
        public String getHint(String secret, String guess) {
            int x = 0; // Bulls
            int y = 0; // Cows
            int[] unmatchedS = new int[10];
            int[] unmatchedG = new int[10];

            for (int idx = 0; idx < secret.length(); idx++) {
                char cSecret = secret.charAt(idx);
                char cGuess = guess.charAt(idx);
                if (secret.charAt(idx) == guess.charAt(idx)) {
                    x++;
                } else {
                    unmatchedS[cSecret - '0'] += 1;
                    unmatchedG[cGuess - '0'] += 1;
                }
            }
            for (int idx = 0; idx < 10; idx++) {
                y += Math.min(unmatchedS[idx], unmatchedG[idx]);
            }

            return x + "A" + y + "B";
        }
    }
}
