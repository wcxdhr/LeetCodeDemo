package com.example.leetcodedemo.array.easy;
/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */

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
