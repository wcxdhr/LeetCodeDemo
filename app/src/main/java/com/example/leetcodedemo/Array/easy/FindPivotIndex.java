package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/26.
 */

public class FindPivotIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }

    /**
     * 实测*2比左移1位快
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum*2 + nums[i] == sum)
                return i;
            else
                leftSum +=nums[i];
        }
        return -1;
    }
}
