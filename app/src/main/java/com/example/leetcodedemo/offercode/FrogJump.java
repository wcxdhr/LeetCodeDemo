package com.example.leetcodedemo.offercode;
/**
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

/**
 * Created by wcxdhr on 2020/2/6.
 */

public class FrogJump {
    /**
     * leetcode上有原题，就是最简单的动态规划
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target < 3)
            return target;
        int f1 = 1, f2 = 2;
        int ans = 0;
        for (int i = 3; i <= target; i++) {
            ans = f1 +f2;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }
}
