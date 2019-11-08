package com.example.leetcodedemo.array.easy;

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
