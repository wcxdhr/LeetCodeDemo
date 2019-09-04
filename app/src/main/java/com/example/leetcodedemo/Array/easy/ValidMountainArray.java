package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/30.
 */

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 2) return false;
        int index;
        boolean flag = false;
        for (index = 0; index < A.length - 1; index++) {
            if (A[index] == A[index + 1]) return false;
            else if (A[index] > A[index + 1]) {
               if (flag) break;
               else return false;
            }
            else flag = true;
        }
        if (index == A.length - 1) return false;
        for (; index < A.length - 1; index++) {
            if (A[index] <= A[index + 1]) return false;
        }
        return true;
    }
}
