package com.example.leetcodedemo.Array.easy;

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/7/5.
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] a = {3,3};
        int[] s = twoSum(a, 6);

        System.out.println(s[0] + " " + s[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) ) {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
