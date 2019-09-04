package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class LongestContinuousIncreasingSubsequence {


    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        int currentLen = 1;
        if (nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                currentLen++;
            else {
                if (maxLen < currentLen)
                    maxLen = currentLen;
                currentLen = 1;
            }
        }
        if (maxLen < currentLen)
            maxLen = currentLen;
        return maxLen;
    }
}

