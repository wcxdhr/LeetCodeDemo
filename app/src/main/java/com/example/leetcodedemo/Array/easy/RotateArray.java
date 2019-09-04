package com.example.leetcodedemo.Array.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/22.
 */

public class RotateArray {

    public static void main(String[] args) {
        int[] digits = {-1,-100,3,99};
        rotate(digits, 10);
        System.out.println(Arrays.toString(digits));
    }

    /**
     * 可尝试反转解法
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % nums.length;
        int[] tmpNum = new int[nums.length];
        for (int i = 0; i < nums.length - k; i++)
            tmpNum[i + k] = nums[i];

        for (int i = 0; i < k; i++)
            tmpNum[i] = nums[nums.length - k + i];
        for (int i = 0; i < nums.length; i++)
            nums[i] = tmpNum[i];
    }
}
