package com.example.leetcodedemo.array.easy;
/**
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */

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
