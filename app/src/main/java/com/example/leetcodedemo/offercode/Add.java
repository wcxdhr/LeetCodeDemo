package com.example.leetcodedemo.offercode;
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

/**
 * Created by wcxdhr on 2020-02-19.
 */
public class Add {
    /**
     * 位运算
     * 放弃
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        return num2 != 0 ? Add(num1^num2, (num1&num2)<<1) : num1;
    }
}
