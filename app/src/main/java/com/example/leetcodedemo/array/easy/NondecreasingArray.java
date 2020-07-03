package com.example.leetcodedemo.array.easy;
/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，
 * 总满足 array[i] <= array[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class NondecreasingArray {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                index = i;
            }
            if (count == 2)
                return false;
        }
        if (index != -1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < nums.length - 1; j++) {
                    if (j == nums.length - 2)
                        return true;
                    if (j == index)
                        continue;
                    if (j == index - 1) {
                        if (nums[j] > nums[j + 2])
                            break;
                    }
                    else if (nums[j] > nums[j + 1])
                        break;
                }
                index++;
            }
            return false;
        }
        return true;
    }

}
