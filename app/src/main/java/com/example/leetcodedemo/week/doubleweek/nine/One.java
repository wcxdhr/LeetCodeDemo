package com.example.leetcodedemo.week.doubleweek.nine;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/9/21.
 */

public class One {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > 5000)
                return i;
        }
        return arr.length;
    }
}
