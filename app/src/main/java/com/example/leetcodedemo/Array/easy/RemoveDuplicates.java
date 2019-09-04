package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/20.
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] digits = {9,9,9,9,9,9,9,9};
        int length = removeDuplicates(digits);
        for (int i = 0; i < length; i++) {
            System.out.println(digits[i]);
        }

    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
