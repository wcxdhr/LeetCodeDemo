package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class AvailableCapturesforRook {
    public int numRookCaptures(char[][] board) {
        int rX = -1;
        int rY = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rX = i;
                    rY = j;
                    break;
                }
            }
            if (rX != -1)
                break;
        }
        int count = 0;
        for (int i = rX + 1; i < 8; i++) {
            if (board[i][rY] == 'B')
                break;
            else if (board[i][rY] == 'p') {
                count++;
                break;
            }
        }
        for (int i = rX - 1; i > -1; i--) {
            if (board[i][rY] == 'B')
                break;
            else if (board[i][rY] == 'p') {
                count++;
                break;
            }
        }
        for (int j = rY + 1; j < 8; j++) {
            if (board[rX][j] == 'B')
                break;
            else if (board[rX][j] == 'p') {
                count++;
                break;
            }
        }
        for (int j = rY - 1; j > -1; j--) {
            if (board[rX][j] == 'B')
                break;
            else if (board[rX][j] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }
}
