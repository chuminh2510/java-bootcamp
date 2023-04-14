package com.minhcv.leetcode.counting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.hackerearth.com/problem/algorithm/car-parking/
 */
public class CarParkingApp {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String firstLine = br.readLine();
            int n = Integer.parseInt(firstLine);

            for (int i = 0; i < n; i++) {
                String street = br.readLine();
                countParkingLots(street);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * You are looking for a place to park your car on a wall street. You can park at any position that meets the following requirements:
     * <p>
     * 1. It is not directly in front of a private driveway.
     * 2. It is not directly in front of a bus stop.
     * 3. It is not 5 meters before a bus stop.
     * 4. It is not 10 meters before a bus stop.
     * 5. It is not directly in front of a side-street.
     * 6. It is not 5 meters before a side-street.
     * 7. It is not 5 meters after a side-street.
     *
     * @param street
     * @return
     */
    public static int countParkingLots(String street) {
        int count = 0;
        for (int idx = 0; idx < street.length(); idx++) {
            char c = street.charAt(idx);
            if (c == 'D' || c == 'B' || c == 'S') { // Conditions: 1, 2, 5
                continue;
            }
            if ((idx + 1) < street.length()) {
                char nextArea = street.charAt(idx + 1);
                if (nextArea == 'B' || nextArea == 'S') { // Conditions: 3, 6
                    continue;
                }
            }
            if ((idx + 2) < street.length()) {
                char nextArea = street.charAt(idx + 2);
                if (nextArea == 'B') { // Conditions: 4
                    continue;
                }
            }
            if ((idx - 1) >= 0) {
                char previousArea = street.charAt(idx - 1);
                if (previousArea == 'S') { // Condition 7
                    continue;
                }
            }
            count++;

        }
        System.out.println(count);
        return count;
    }
}
