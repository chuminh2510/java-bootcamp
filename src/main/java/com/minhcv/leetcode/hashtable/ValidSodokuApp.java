package com.minhcv.leetcode.hashtable;

import java.util.Map;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSodokuApp {
    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution sol = new Solution();
        sol.isValidSudoku(board);
    }

    public static class Solution {

        public boolean isValidSudoku(char[][] board) {

            for (int idxX = 0; idxX < board.length; idxX++) {
                int[] checkArr = new int[10];
                for (int idxY = 0; idxY < board[idxX].length; idxY++) {
                    if (board[idxX][idxY] == '.') {
                        continue;
                    }
                    if (checkArr[board[idxX][idxY] - '0'] == 1) {
                        return false;
                    }
                    checkArr[board[idxX][idxY] - '0'] = 1;
                }
            }

            for (int idxX = 0; idxX < board.length; idxX++) {
                int[] checkArr = new int[10];
                for (int idxY = 0; idxY < board[idxX].length; idxY++) {
                    if (board[idxY][idxX] == '.') {
                        continue;
                    }
                    System.out.println("Idx X - Y: " + idxX + " - " + idxY + " === Value = " + board[idxY][idxX]);
                    if (checkArr[board[idxY][idxX] - '0'] == 1) {
                        return false;
                    }
                    checkArr[board[idxY][idxX] - '0'] = 1;
                }
            }
            for (int idxX = 0; idxX < board.length; idxX += 3) {
                for (int idxY = 0; idxY < board[idxX].length; idxY += 3) {
                    int[] checkArr = new int[10];
                    for (int i = idxX; i < idxX + 3; i++) {
                        for (int j = idxY; j < idxY + 3; j++) {
                            if (board[i][j] == '.') {
                                continue;
                            }
                            if (checkArr[board[i][j] - '0'] == 1) {
                                return false;
                            }
                            checkArr[board[i][j] - '0'] = 1;
                        }
                    }
                }
            }
            return true;
        }
    }
}
