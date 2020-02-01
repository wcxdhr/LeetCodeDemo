package com.example.leetcodedemo.dynamicprogramming.medium;
/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020/2/1.
 */

public class PerfectSquares {
    /**
     * 有了coin change铺垫，这道题思路就比较清晰了，这次只是把零钱换成12345等了
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int len = 1;
        while (len * len <= n)
            len++;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < len; j++) {
                int sum = j * j;
                if (sum <= i) {
                    dp[i] = Math.min(dp[i], dp[i - sum] + 1);
                }
                else break;
            }
        }
        return dp[n];
    }
}
