package com.example.leetcodedemo.array.easy;

import java.util.Arrays;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class RelativeSortArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(
                new int[]{2,7,1},new int[]{1}
        )));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countArr = new int[1001];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            countArr[arr1[i]]++;
            if (arr1[i] > max)
                max = arr1[i];
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < countArr[arr2[i]]; j++)
                arr1[index++] = arr2[i];
            countArr[arr2[i]] = 0;
        }
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < countArr[i]; j++)
                arr1[index++] = i;
        }
        return arr1;
    }
}
