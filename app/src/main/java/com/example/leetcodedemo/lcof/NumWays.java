package com.example.leetcodedemo.lcof;
/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 *
 *
 * 通过次数30,629提交次数73,840
 */

/**
 * Created by wcxdhr on 2020-06-21.
 */
public class NumWays {
    /**
     * 斐波那契数列原版
     * @param n
     * @return
     */
    public int numWays(int n) {
        //下面这段边界判断可以省略，因为n < 2时，f1 = 1
//        if (n < 2) return 1;
        int f0 = 1, f1 = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = (f0 + f1)%1000000007;
            f0 = f1;
            f1 = sum;
        }
        //此处返回f1，则不必对sum初始化。
        return f1;
    }
}
