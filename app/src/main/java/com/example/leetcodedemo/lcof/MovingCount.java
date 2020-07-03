package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * 通过次数41,577提交次数85,259
 */

/**
 * Created by wcxdhr on 2020-06-23.
 */
public class MovingCount {

    /**
     * dfs， 写得比较标准，题解太巧了，下次再好好看
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] flags = new boolean[m][n];
        return countHelper(flags, 0, 0, k);
    }

    private int countHelper(boolean[][] flags, int x, int y, int k) {
        if (x < 0 || x >= flags.length || y < 0 || y >= flags[0].length || flags[x][y] || check(x, y, k))
            return 0;
        flags[x][y] = true;
        return 1 + countHelper(flags, x - 1, y, k) + countHelper(flags, x + 1, y, k)
                + countHelper(flags, x, y - 1, k) + countHelper(flags, x, y + 1, k);
    }

    private boolean check(int x, int y, int k) {
        return (sumHelper(x) + sumHelper(y)) > k;
    }

    private int sumHelper(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}
