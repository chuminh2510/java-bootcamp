package com.minhcv.leetcode.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/contests/code-golf-mait/challenges/lighting-bulbs
 */
public class LightingBulbsApp {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String numTCs = br.readLine();
            int numTestCases = Integer.parseInt(numTCs);
            for (int idx = 0; idx < numTestCases; idx++) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = new int[n];
                Arrays.fill(arr, 1);
                for (int i = 2; i <= n; i++) {
                    int k = 1;
                    int pos = i * k;
                    while (pos <= n) {
                        if (arr[pos - 1] == 1) {
                            arr[pos - 1] = 0;
                        } else {
                            arr[pos - 1] = 1;
                        }
                        k++;
                        pos = i * k;
                    }
                }
                System.out.println(Arrays.stream(arr).sum());
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
