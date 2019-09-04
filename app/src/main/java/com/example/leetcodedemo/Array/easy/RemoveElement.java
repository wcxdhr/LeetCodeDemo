package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/21.
 */

public class RemoveElement {

    public static void main(String[] args) {
        int[] digits = {3,2,2,3};
        int count = removeElement(digits, 3);
        for (int i = 0; i < count; i++) {
            System.out.println(digits[i]);

        }

    }

    /**
     * LeetCode官方双指针：非常简洁
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val)
                count++;
        }
        int j = length - 1;
        for (int i = 0; i < length - count; i++) {
            if (nums[i] == val) {
                while (nums[j] == val )
                    j--;
                if (j < length - count)
                    break;
                nums[i] = nums[j--];
            }
        }
        return length - count;
    }
}
