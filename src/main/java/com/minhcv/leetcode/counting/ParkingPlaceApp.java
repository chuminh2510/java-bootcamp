package com.minhcv.leetcode.counting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/contests/hour-of-code2013/challenges/parking-place/problem
 */
public class ParkingPlaceApp {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String firstLine = br.readLine();
            String[] arr = firstLine.split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int k = Integer.parseInt(arr[2]);
            Set<String> parked = new HashSet<>();
            for (int i = 0; i < m; i++) {
                parked.add(br.readLine());
            }
            for (int i = 0; i < k; i++) {
                if (parked.contains(br.readLine())) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
