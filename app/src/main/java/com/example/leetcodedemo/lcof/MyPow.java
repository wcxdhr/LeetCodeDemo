package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 *
 * 通过次数22,216提交次数67,728
 */

/**
 * Created by wcxdhr on 2020-06-29.
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(-1.00000 ,-2147483648));
    }

    /**
     * 注意：这种题千万不要把负数变成正数来做，边界会溢出。
     * 注意0、1特殊情况。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        boolean neg = false;
        if (n == 0 || x == 1) return 1;
        if (x == -1) return (n & 1) == 0 ? 1 : -1;
        if (n == Integer.MIN_VALUE) return 0;
        if (n < 0){
            neg = true;
        }
        double ans = x;
        int i;
        for (i = neg ? -1 : 1; i < (n >> 1); i *= 2) {
             ans *= ans;
        }
        int plus = neg ? -1 : 1;
        for (;i != n; i += plus) {
            ans *= x;

        }
        return neg ? 1 / ans : ans;
    }

    /**
     * 此解法会超出时间限制
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        boolean neg = false;
        if (n == 0) return 1;
        if (n < 0){
            neg = true;
            n = -n;
        }
        double ans = 1;
        while (n > 0) {
            ans *= x;
            n--;
        }
        return neg ? 1 / ans : ans;
    }
}
