package com.example.leetcodedemo.easy;

/**
 * Created by wcxdhr on 2019/8/21.
 */

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] digits = {1,3,5,6};
        System.out.println(searchInsert(digits, 7));

    }

    /**
     * 二分查找
     * 注意：while循环判断条件为<=
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int medium = (right + left) / 2;
            if (nums[medium] == target)
                return medium;
            if (target < nums[medium])
                right = medium - 1;
            else
                left = medium + 1;
        }
        return left;
    }
}
