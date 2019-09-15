package com.example.leetcodedemo.week.hundred54;

/**
 * Created by wcxdhr on 2019/9/15.
 */

public class three {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        int negative = 0;
        int positive = 0;
        for (int i : arr) {
            sum += i;
            if (i < 0) negative = 1;
            else if (i > 0) positive = 1;
        }
        if (negative == 1 && positive == 0)
            return 0;
        else if (negative == 0 && positive == 1)
            return (sum * k);

    }
}
