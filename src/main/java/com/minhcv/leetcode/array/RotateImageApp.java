package com.minhcv.leetcode.array;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImageApp {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = {{1, 2}, {3, 4}};
        Solution sol = new Solution();
        sol.rotate(matrix);
    }

    static class Solution {

        /**
         * 1 2 3    9 6 3    7 4 1
         * 4 5 6 -> 8 5 2 -> 8 5 2
         * 7 8 9    7 4 1    9 6 3
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            int temp;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length - i; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
                    matrix[matrix.length - j - 1][matrix.length - i - 1] = temp;
                }
            }
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - i - 1][j];
                    matrix[matrix.length - i - 1][j] = temp;
                }
            }
            System.out.println("End!!!");
        }

        /**
         * Tịnh tiến từng giá trị
         *
         * @param matrix
         */
        public void rotate2(int[][] matrix) {
            if (matrix.length == 1) {
                return;
            }
            int idxCircle = matrix.length - 1;
            int startedRound = 0;
            while (idxCircle > 0) {
                for (int i = 0; i < idxCircle - startedRound; i++) {
                    int x = startedRound;
                    int y = startedRound;
                    boolean isFinished = false;
                    int vector = 1;
                    int temp = matrix[x][y];
                    boolean isPlusY = true;
                    while (!isFinished) {
                        if (isPlusY) {
                            y += vector;
                        } else {
                            x += vector;
                        }
                        int valNext = matrix[x][y];
                        matrix[x][y] = temp;
                        temp = valNext;
                        if (x == startedRound && y == matrix.length - startedRound - 1) {
                            isPlusY = false;
                        }
                        if (x == matrix.length - startedRound - 1 && y == matrix.length - startedRound - 1) {
                            isPlusY = true;
                            vector = -1;
                        }
                        if (x == matrix.length - startedRound - 1 && y == startedRound) {
                            isPlusY = false;
                        }

                        if (startedRound == x && startedRound == y) {
                            isFinished = true;
                        }
                    }
                }
                startedRound++;
                idxCircle--;
            }
        }
    }
}
