package com.example.leetcodedemo.Array.easy;

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/8/22.
 */

public class MajorityElement {

    public static void main(String[] args) {
        int[] digits = {2,2,0,1,1,2};
        System.out.println(majorityElement(digits));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i]))
                countMap.put(nums[i], 1);
            else if (countMap.get(nums[i]) == nums.length / 2)
                return nums[i];
            else countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }
        return nums[nums.length - 1];
    }
}
