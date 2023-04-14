package com.minhcv.leetcode.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/contests/cqm-6-2/challenges/switching-bulbs
 */
public class SwitchingBulbsApp {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String firstLine = br.readLine();
            int n = Integer.parseInt(firstLine);
            int steps = n / 3;
            if (n % 3 != 0) {
                steps += 1;
            }
            System.out.println(steps);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
