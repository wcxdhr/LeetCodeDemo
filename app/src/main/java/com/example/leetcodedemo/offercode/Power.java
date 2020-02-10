package com.example.leetcodedemo.offercode;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */

/**
 * Created by wcxdhr on 2020-02-09.
 */
public class Power {

    /**
     * 官方解答更为巧妙，根据exponent是否能整除2，还能进一步化简乘法，并且要用位运算来代替乘除法
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        double ans = 1;
        boolean negFlag = false;
        if (exponent < 0) {
            negFlag = true;
            exponent = -exponent;
        }
        while (exponent > 0 ) {
            if ((exponent & 1) == 1) {
                ans *= base;

            }
            exponent >>= 1;
            base *= base;
        }

        return negFlag ? 1 / ans : ans;
    }
    /**
     * 这道题看似简单，有太多小问题需要注意，一定要分析exponent的正负，并用测试用例走一遍
     * @param base
     * @param exponent
     * @return
     */
    public double Power1(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (base == 0)
            return 0;
        double ans = base;
        boolean negFlag = false;
        if (exponent < 0) {
            negFlag = true;
            exponent = -exponent;
        }
        for (int i = 2; i <= exponent; i++) {
            ans *= base;
        }
        return negFlag ? 1 / ans : ans;
    }
}
