package com.example.leetcodedemo.Array.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class SortArrayByParityII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2,3})));
    }

    /**
     * 更优解法：双指针分为奇偶坐标 取余：位运算
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i+=2) {
            if ((A[i] & 1) == 1) {
                while ((A[j] & 1) == 1)
                    j +=2;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
