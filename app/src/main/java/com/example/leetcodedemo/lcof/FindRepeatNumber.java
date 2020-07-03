package com.example.leetcodedemo.lcof;
/**
 * 面试题03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 通过次数63,921提交次数95,290
 */

/**
 * Created by wcxdhr on 2020-06-16.
 */
public class FindRepeatNumber {
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :
     * 47.7 MB, 在所有 Java 提交中击败了100.00%的用户
     *
     * 原地置换，比较经典
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            while (nums[i] != i) {
                int tmp = nums[i];
                if (nums[tmp] == tmp)
                    return tmp;
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            i++;
        }
        return -1;
    }
}
