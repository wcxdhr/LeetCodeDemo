package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * 通过次数30,078提交次数38,210
 * 在真实的面试中遇到过这道题？
 */

/**
 * Created by wcxdhr on 2020-06-29.
 */
public class PrintNumbers {
    /**
     * 很简单的题
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int len = 1;
        while (n > 0) {
            len *= 10;
            n--;
        }
        len--;
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
