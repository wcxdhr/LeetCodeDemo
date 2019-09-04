package com.example.leetcodedemo.Array.easy;

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
