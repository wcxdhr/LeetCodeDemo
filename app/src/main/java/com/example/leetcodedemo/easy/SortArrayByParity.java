package com.example.leetcodedemo.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class SortArrayByParity {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if ((A[i] & 1) == 1) {
                while ((A[j] & 1) == 1 && i < j)
                    j--;
                if (i < j) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
            i++;
        }
        return A;
    }
}
