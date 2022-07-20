package com.minhcv.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversionApp {
    class Solution {
        public String convert(String s, int numRows) {
            Map<Integer, String> lines = new HashMap<>();
            if (numRows == 1) {
                return s;
            }
            for (int idx = 0; idx < numRows; idx++) {
                lines.put(idx, "");
            }
            int row = 0;
            boolean isUp = true;
            for (int idx = 0; idx < s.length(); idx++) {
                String line = lines.get(row);
                line += s.charAt(idx);
                lines.put(row, line);
                if (isUp) {
                    row++;
                    if (row == numRows - 1) {
                        isUp = false;
                    }
                } else {
                    row--;
                    if (row == 0) {
                        isUp = true;
                    }
                }

            }

            return lines.values().stream().collect(Collectors.joining());

        }
    }
}
