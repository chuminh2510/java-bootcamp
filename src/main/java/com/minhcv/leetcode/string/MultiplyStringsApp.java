package com.minhcv.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStringsApp {
    public static void main(String[] args) {
        String ret = new Solution().multiply("123", "456");
        System.out.println("End!");
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            List<String> multiplies = new ArrayList<>();
            for (int idxNum2 = num2.length() - 1; idxNum2 >= 0; idxNum2--) {
                int buff = 0;
                int mod = 0;
                String multiplyStr = rightPad("", '0', num2.length() - idxNum2 - 1);
                for (int idxNum1 = num1.length() - 1; idxNum1 >= 0; idxNum1--) {
                    int digitNum2 = num2.charAt(idxNum2) - '0';
                    int digitNum1 = num1.charAt(idxNum1) - '0';
                    int multiply = digitNum1 * digitNum2 + buff;
                    buff = multiply / 10;
                    mod = multiply % 10;
                    multiplyStr = mod + multiplyStr;
                }
                if (buff > 0) {
                    multiplyStr = buff + multiplyStr;
                }
                multiplies.add(multiplyStr);
            }
            String retMultiply = "";
            for (int idx = 0; idx < multiplies.size(); idx++) {
                retMultiply = sum(retMultiply, multiplies.get(idx));
            }
            System.out.println("End function");
            return retMultiply;
        }

        public String sum(String num1, String num2) {
            String sumStr = "";
            int length = Math.min(num1.length(), num2.length());
            if (num1.length() == length) {
                num1 = leftPad(num1, '0', num2.length() - num1.length());
            } else {
                num2 = leftPad(num2, '0', num1.length() - num2.length());
            }
            int buff = 0;
            int mod = 0;
            for (int idx = num2.length() - 1; idx >= 0; idx--) {
                int digitN1 = num1.charAt(idx) - '0';
                int digitN2 = num2.charAt(idx) - '0';
                int sum = digitN1 + digitN2 + buff;
                buff = sum / 10;
                mod = sum % 10;
                sumStr = mod + sumStr;
            }
            if (buff > 0) {
                sumStr = buff + sumStr;
            }
            return sumStr;
        }

        public String leftPad(String org, char character, int num) {
            for (int i = 0; i < num; i++) {
                org = character + org;
            }

            return org;
        }

        public String rightPad(String org, char character, int num) {
            for (int i = 0; i < num; i++) {
                org += character;
            }

            return org;
        }
    }

}
