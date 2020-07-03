package com.example.leetcodedemo.array.easy;
/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */

/**
 * Created by wcxdhr on 2019/8/21.
 */

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] digits = {1,2,2,3,5, 0, 0, 0};
        int[] digits2 = {1, 2, 3};
        merge(digits, 5, digits2, 3);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);

        }

    }

    /**
     * 排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempM = new int[m];
        System.arraycopy(nums1, 0, tempM, 0, m);
        int i = 0;
        int j = 0;
        while (i < m && j < n) {

            if (tempM[i] < nums2[j])
                nums1[i + j] = tempM[i++];
            else
                nums1[i + j] = nums2[j++];
        }
        if (i < m) {
            System.arraycopy(tempM, i, nums1, i + j, m - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, i + j, n - j);
        }
    }
}
