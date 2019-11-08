package com.example.leetcodedemo.array.easy;

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
