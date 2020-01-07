package com.example.leetcodedemo.math.easy;
/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2020/1/7.
 */
public class PowerofTwo {

    /**
     * 思路：常规解法：使用n&1优化时间，直接1ms，100%
     * 题解解法：利用位运算巧妙解
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        while ((n & 1) == 0 && n > 1){
            n /= 2;
        }
        if (n == 1)
            return true;
        return false;
    }
}
