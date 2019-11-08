package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/29.
 */

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean inc = false, dec = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1])
                inc = true;
            else if (A[i] > A[i + 1])
                dec = true;
            if (inc && dec)
                return false;
        }
        return true;
    }
}
