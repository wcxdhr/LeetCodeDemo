package com.example.leetcodedemo.offercode;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

/**
 * Created by wcxdhr on 2020/2/6.
 */

public class FrogJumpII {

    /**
     * 草稿纸上写一写就出规律了
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }

    /**
     * 2的n次方，用左移，更快
     * @param target
     * @return
     */
    public int JumpFloorII1(int target) {
        return 1 << (target - 1);
    }
}
