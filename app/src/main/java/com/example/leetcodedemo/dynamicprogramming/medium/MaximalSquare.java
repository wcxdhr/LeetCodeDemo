package com.example.leetcodedemo.dynamicprogramming.medium;
/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */

/**
 * Created by wcxdhr on 2020-04-01.
 */
public class MaximalSquare {
    /**
     * 此题没啥思路，
     * 官方的动态规划思路：每一个为1的i,j点的维持的边长 = 与它相邻的三个点的最小边长 + 1（从左上到右下
     * 此外，如果有余力，还可以对dp数组优化，只保留一行，用一个prev变量记录
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];//从1开始循环，可以省去边界特殊条件的处理
        int maxLen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }

            }
        }
        return maxLen * maxLen;
    }
}
