package com.example.leetcodedemo.math.easy;
/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2020/1/8.
 */
public class PowerofThree {
    /**
     * 思路：基础循环
     * 官方题解提到几种巧妙解法，最后一种直接用java的int范围的3的最大次幂除以n。感觉太取巧。
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        int t = 3;
        while (n >= t && n % t == 0) {
            n /= t;
            t = t * t;
        }
        if ((t % n == 0))
            return true;
        return false;
    }
}
