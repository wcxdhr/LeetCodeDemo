package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class TransposeMatrix {


    public static int[][] transpose(int[][] A) {
        int[][] T = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++)
                T[i][j] = A[j][i];
        }
        return T;
    }
}
