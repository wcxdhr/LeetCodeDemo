package com.example.leetcodedemo.easy;

/**
 * Created by wcxdhr on 2019/8/28.
 */

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0,2,3,2}));
    }

    /**
     * 动态规划:写状态转移方程
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int i;
        for (i = 2; i < cost.length; i++) {
            int tmp = Math.min(dp[0], dp[1]) + cost[i];
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return Math.min(dp[0], dp[1]);
    }
}
