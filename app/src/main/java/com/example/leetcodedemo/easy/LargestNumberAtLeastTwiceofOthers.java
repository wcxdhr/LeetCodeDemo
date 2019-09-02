package com.example.leetcodedemo.easy;

/**
 * Created by wcxdhr on 2019/8/28.
 */

public class LargestNumberAtLeastTwiceofOthers {

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{0,0,2,3}));
    }

    public static int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            }
            else if (nums[i] > second)
                second = nums[i];
        }
        return max >= second * 2 ? index : -1;
    }
}
