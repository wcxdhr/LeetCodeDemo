package com.example.leetcodedemo.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class TwoSumIIInputarrayissorted {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));

    }

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                return new int[]{i + 1, j + 1};
            else if (numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }
        throw new IllegalArgumentException("No Solution");
    }
}
