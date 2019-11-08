package com.example.leetcodedemo.array.easy;

import java.util.HashMap;

/**
 * Created by wcxdhr on 2019/8/23.
 */

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> countNum = new HashMap<>();
        for (int num : nums) {
            if (countNum.containsKey(num))
                return true;
            else
                countNum.put(num, true);
        }
        return false;
    }
}
