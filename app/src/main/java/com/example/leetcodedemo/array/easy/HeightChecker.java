package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class HeightChecker {

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{4,1,1,2,1,3}));
    }

    public static int heightChecker(int[] heights) {
        int count = 0;
        int[] sortHeights = heights.clone();
        sort(sortHeights, 0, sortHeights.length - 1);
        for (int i = 0; i < sortHeights.length; i++) {
            if (heights[i] != sortHeights[i])
                count++;
        }
        return count;
    }

    public static void sort(int arr[], int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index)
                j--;
            if (i < j)
                arr[i++] = arr[j];
            while (i < j && arr[i] <= index)
                i++;
            if (i < j)
                arr[j--] = arr[i];
        }
        arr[i] = index;
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
