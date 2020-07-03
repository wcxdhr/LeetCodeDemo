package com.example.leetcodedemo.array.easy;
/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

/**
 * Created by wcxdhr on 2019/8/21.
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] digits = {-2,5,-1,7,9,8};
        System.out.println(maxSubArray(digits));

    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int currentSum = result;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] > currentSum && currentSum < 0) {
                currentSum = nums[i];
            }
            else {
                currentSum += nums[i];
            }
            result = Math.max(currentSum, result);
        }
        return result;
    }
}
