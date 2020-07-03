package com.example.leetcodedemo.dynamicprogramming.easy;
/**
 * 面试题 16.17. 连续数列
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

/**
 * Created by wcxdhr on 2020-03-31.
 */
public class ContiguousSequenceLCCI {

    /**
     * 此题要注意，简单的dp就可以做到，不用复杂的判断
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
