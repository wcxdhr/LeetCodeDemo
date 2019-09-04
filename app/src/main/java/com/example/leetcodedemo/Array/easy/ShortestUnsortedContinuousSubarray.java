package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int i,j;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) break;
        }
        for (j = nums.length - 1; j > 0; j--) {
            if (nums[j] < nums[j - 1]) break;
        }
        int min = nums[i];
        int max = nums[j];
        for (int k = i; k <=j ; k++) {
            if (nums[k] < min) min = nums[k];
            if (nums[k] > max) max = nums[k];
        }
        for (int k = 0; k < i; k++) {
            if (nums[k] > min) {
                i = k;
                break;
            }
        }
        for (int k = nums.length - 1; k > j; k--) {
            if (nums[k] < max) {
                j = k;
                break;
            }
        }
        return (j - i + 1 < 0) ? 0 : j - i + 1;
    }
}
