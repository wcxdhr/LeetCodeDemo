package com.example.leetcodedemo.Array.medium;
/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Created by Wcxdhr on 2019/9/16.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] digits = {1,3,4,2};
        nextPermutation(digits);
        System.out.println(digits);

    }

    public static void nextPermutation(int[] nums) {
        int j;
        for (j = nums.length - 1; j > 0; j--) {
            if (nums[j] < nums[j - 1])
                break;
        }
        if (j == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int minIndex = j - 1;
        for (int i = 1; i < j; i++) {
            if (nums[i] < nums[minIndex] && nums[i] > nums[j])
                minIndex = i;
        }
        int tmp = nums[j];
        nums[j] = nums[minIndex];
        nums[minIndex] = tmp;
        reverse(nums, minIndex, j);

    }

    private static void reverse(int[] nums, int left, int right) {
        int i = left;
        int j = right - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
