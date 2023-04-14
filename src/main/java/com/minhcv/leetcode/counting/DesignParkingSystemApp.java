package com.minhcv.leetcode.counting;

/**
 * https://leetcode.com/problems/design-parking-system/
 */
public class DesignParkingSystemApp {

    static class ParkingSystem {

        // Indexes: 0 - big, 1 - medium, 2 - small
        private int[] slots = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            this.slots[0] = big;
            this.slots[1] = medium;
            this.slots[2] = small;
        }

        public boolean addCar(int carType) {
            if (slots[carType - 1] <= 0) {
                return false;
            }
            slots[carType - 1] -= 1;
            return true;
        }
    }
}
