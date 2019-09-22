package com.example.leetcodedemo.week.doubleweek.nine;

/**
 * Created by wcxdhr on 2019/9/21.
 */

public class Two {
    public int minKnightMoves(int x, int y) {
        int step = 0;
        int i = Math.abs(x);
        int j = Math.abs(y);
        int[][] dp = new int[i + 3][j + 3];
        findMin(dp, 0, 0, i, j, 0);
        return dp[i][j];
    }

    private void findMin(int[][] dp, int i, int j, int x, int y, int step) {
        if (i <= x + 2 && j <= y + 2 ) {
            if (dp[i][j] == 0)
                dp[i][j] = step;
            else dp[i][j] = Math.min(dp[i][j], step);
            findMin(dp, i + 2, j + 1, x, y, dp[i][j]);
            findMin(dp, i + 2, j - 1, x, y, dp[i][j]);
            findMin(dp, i + 1, j + 2, x, y, dp[i][j]);
            findMin(dp, i + 1, j - 2, x, y, dp[i][j]);
            findMin(dp, i - 2, j + 1, x, y, dp[i][j]);
            findMin(dp, i - 2, j - 1, x, y, dp[i][j]);
            findMin(dp, i - 1, j + 2, x, y, dp[i][j]);
            findMin(dp, i - 1, j - 2, x, y, dp[i][j]);
        }
    }
}
