package com.example.leetcodedemo.math.easy;
/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/12/31.
 */
public class FactorialTrailingZeroes {

    /**
     * 我的思路：0主要考虑2*5 = 10，由于2比5小，所以主要考察阶乘中5出现的个数，考虑溢出的问题，将i减小，而不是增大。
     * 改进：使用while循环，直接对n进行操作，可改进内存使用？
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = n; i >= 5; i = i / 5) {
            ans += i / 5;
        }
        return ans;
    }
}
