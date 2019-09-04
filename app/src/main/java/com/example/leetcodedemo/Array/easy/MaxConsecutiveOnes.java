package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/28.
 */

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,2,3}));
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1)
                count++;
            else {
                if (count > maxCount)
                    maxCount = count;
                count = 0;
            }
        }
        return Math.max(maxCount,count);
    }
}
