package com.example.leetcodedemo.offercode;
/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

/**
 * Created by wcxdhr on 2020-02-14.
 */
public class Sum_Solution {
    /**
     * 这个题没什么实际意义，主要考察发散思维能力
     * 题解中主要提到利用递归的短路特性
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
