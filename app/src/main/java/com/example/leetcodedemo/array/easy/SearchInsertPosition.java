package com.example.leetcodedemo.array.easy;
/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */

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
