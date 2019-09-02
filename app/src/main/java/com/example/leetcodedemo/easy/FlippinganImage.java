package com.example.leetcodedemo.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class FlippinganImage {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{{1}})));
    }

    /**
     * 注意判断条件，边界
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            int k = A.length - 1;
            while (j < k) {
                if (A[i][j] == A[i][k]) {
                    A[i][j] = A[i][k] = 1 - A[i][j];
                }
                j++;
                k--;
            }
            if (A.length % 2 == 1)
                A[i][j] = 1 - A[i][j];
        }
        return A;
    }
}
