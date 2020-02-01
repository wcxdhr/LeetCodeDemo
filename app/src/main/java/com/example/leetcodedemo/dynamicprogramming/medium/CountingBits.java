package com.example.leetcodedemo.dynamicprogramming.medium;
/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by wcxdhr on 2020/1/31.
 */

public class CountingBits {

    /**
     * 最初的思路：用一个数组记录数字的递增
     * 题解中有提到最高有效位，最低设置位，关键还是要找二进制数的关系来写动态转移方程。
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        int[] flag = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (flag[0] == 0) {
                flag[0] = 1;
                dp[i] = dp[i - 1] + 1;
            }
            else {
                int f = 1;
                int j;
                for (j = 0; j <= num; j++) {
                    int ans = flag[j] + f;
                    if ( ans == 2) {
                        flag[j] = 0;
                    }
                    else if (ans == 1) {
                        flag[j] = 1;
                        break;
                    }
                }
                dp[i] = dp[i - 1] - j + 1;
            }
        }
        return dp;
    }



}
