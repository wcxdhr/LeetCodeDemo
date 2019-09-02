package com.example.leetcodedemo.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int[] countArr = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            countArr[i] = i + count;
            if (arr[i] == 0)
                count++;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (countArr[i] <= arr.length - 1)
                arr[countArr[i]] = arr[i];
            if (arr[i] == 0 && countArr[i] < arr.length - 1)
                arr[countArr[i] + 1] = 0;
        }
    }
}
