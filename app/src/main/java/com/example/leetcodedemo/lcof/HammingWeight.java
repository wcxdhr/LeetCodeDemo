package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 *
 * 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * 通过次数32,191提交次数43,709
 */

import android.os.SystemPropertiesProto;

/**
 * Created by wcxdhr on 2020-06-27.
 */
public class HammingWeight {


    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(Integer.MIN_VALUE));
    }

    // you need to treat n as an unsigned value

    /**
     * 看下官方解答
     * 重点：左移一位替换除以2（更快），取余则由（N & 1）取代（更快）
     * 惊喜解法：把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变成0
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
    /**
     * 此法太笨
     * 实际上直接用右移和&1，不必在意正负数的事情（因为java中负数直接用补码存储了）
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int oneCount = 0;
        int count = 0;
        int zeroIndex = 0;
        boolean neg = false;
        boolean zeroFlag = false;
        if (n < 0)
            neg = true;
        while (n != 0) {
            count++;
            int rem = n & 1;
            oneCount += rem;
            if (rem == 1 && !zeroFlag) {
                zeroIndex = count;
                zeroFlag = true;
            }
            n /= 2;
        }
        if (neg) oneCount = 32 - oneCount - zeroIndex + 2;
        return oneCount;
    }
}
