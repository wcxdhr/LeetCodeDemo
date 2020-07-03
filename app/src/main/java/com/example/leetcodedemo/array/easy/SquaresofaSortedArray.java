package com.example.leetcodedemo.array.easy;
/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/26.
 */

public class SquaresofaSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{10})));
    }

    public static int[] sortedSquares(int[] A) {
        int[] S = new int[A.length];
        int i;
        for (i = 0; i < A.length; i++)
            A[i] = (int) Math.pow(A[i], 2);
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] > A[right])
                S[--i] = A[left++];
            else
                S[--i] = A[right--];
        }
        return S;
    }
}
