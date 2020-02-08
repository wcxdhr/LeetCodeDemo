package com.example.leetcodedemo.offercode;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 */

/**
 * Created by wcxdhr on 2020/2/8.
 */

public class RectCover {

    /**
     * 分析时可以从一个n来计算，这时放一个1x2的矩形，
     * 可以横着，也可以竖着，横着就是f(n-2),
     * 竖着就是f(n-1),所以就是斐波那契数列
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 0)
            return 0;
        if (target == 1)
            return 1;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        int ans = 2;
        for (int i = 3; i <= target; i++) {
           ans = dp[0] + dp[1];
           dp[0] = dp[1];
           dp[1] = ans;
        }
        return ans;
    }
}
