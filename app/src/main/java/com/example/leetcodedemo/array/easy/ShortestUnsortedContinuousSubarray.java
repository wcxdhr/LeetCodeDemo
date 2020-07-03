package com.example.leetcodedemo.array.easy;
/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

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
