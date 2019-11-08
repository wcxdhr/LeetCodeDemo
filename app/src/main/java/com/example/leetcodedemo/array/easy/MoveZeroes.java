package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/21.
 */

public class MoveZeroes {

    public static void main(String[] args) {
        int[] digits = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(digits);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);

        }

    }

    /**
     * 双指针：更优解法：记录零元素当前位置，遍历指针向前寻找非零元素
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                if (j <= i)
                    j = i + 1;
                while (j < nums.length && nums[j] == 0)
                    j++;
                if (j >= nums.length)
                    break;
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
