package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int k = 0; k < matrix[0].length; k++) {
            int i = 0;
            int j = k;
            while (i < matrix.length - 1 && j < matrix[0].length - 1) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
                i++;
                j++;
            }
        }
        for (int k = 1; k < matrix.length; k++) {
            int i = k;
            int j = 0;
            while (i < matrix.length - 1 && j < matrix[0].length - 1) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
                i++;
                j++;
            }
        }
        return true;
    }
}
