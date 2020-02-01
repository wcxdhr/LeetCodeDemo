package com.example.leetcodedemo.dynamicprogramming.medium;
/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2020/1/22.
 */

public class CoinChange {

    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{83,186,408,419},6249);
    }

    /**
     * 没有思路，看官方题解，看不懂，
     * 这个题解写得比较好：
     * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
     * 几个步骤：暴力解法（递归，画出递归树，发现重复计算）-带备忘录的自顶向下（递归时记录）-动态规划（自底向上）
     * 在这道题中，dp数组也是相当于递增穷举的，和coin的个数无关系，而是和amount与coin一起联系
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 以下是错误答案
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        int len = coins.length;
        Arrays.sort(coins);
        if (len == 1)
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        int[][] dp = new int[len][len];
        int start = -1;
        int ans = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < len; i++)
            dp[i][i] = amount / coins[i];
        for (int i = len - 1; i >= 1; i--) {
            if (i < start)
                break;
            int tmpSum = amount % coins[i];
            for (int j = i - 1; j >= 0; j-- ) {
                if (tmpSum > 0 && tmpSum < coins[j])
                    break;
                dp[i][j] = tmpSum / coins[j] + dp[i][j + 1];
                tmpSum %= coins[j];
                if (tmpSum == 0) {
                    ans = Math.min(ans, dp[i][j]);
                    start = j;
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
            return ans;
        else
            return -1;
    }
}
